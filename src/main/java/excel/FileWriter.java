package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileWriter {
    Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\fin.xlsx"));
    Workbook insurancePayments = new XSSFWorkbook(new FileInputStream("C:\\java\\2.xlsx"));

    CreationHelper creationHelper = myExcelBook.getCreationHelper();

    public FileWriter() throws IOException {
    }

    public CellStyle getDateStyle(Workbook workbook) {
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(
                creationHelper.createDataFormat().getFormat("dd.MM.yyyy")
        );
        return dateStyle;
    }

    public void writeToFile(List<FinOperation> list, FileOutputStream file) throws IOException {
        Sheet clonedSheet = myExcelBook.cloneSheet(myExcelBook.getSheetIndex("month"));
        myExcelBook.setSheetName(myExcelBook.getSheetIndex(clonedSheet), "10");
        int i = 2;
        for (FinOperation finOperation : list) {
            Row row = clonedSheet.createRow(i);
            Cell cell = row.createCell(0);
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);
            Cell cell3 = row.createCell(3);
            Cell cell4 = row.createCell(4);
            Cell cell5 = row.createCell(5);
            Cell cell6 = row.createCell(6);
            Cell cell7 = row.createCell(7);
            Cell cell8 = row.createCell(8);
            Cell cell9 = row.createCell(9);
            Cell cell10 = row.createCell(10);
            Cell cell11 = row.createCell(11);
            Cell cell12 = row.createCell(12);
            Cell cell13 = row.createCell(13);
            Cell cell14 = row.createCell(14);

            cell.setCellStyle(getDateStyle(myExcelBook));
            cell.setCellValue(finOperation.date);
            Double incomeMoney = finOperation.moneyReceipt;
            Double outcomeMoney = finOperation.consumption;
            if (incomeMoney != 0.00 && !finOperation.payer.contains("СБЕРБАНК")) {
                cell1.setCellValue(incomeMoney);
                cell2.setCellValue(finOperation.payer);
            }
            if (finOperation.payer.contains("СБЕРБАНК")) {
                cell3.setCellValue(incomeMoney);
                Double commission = getAcquiringCommission(finOperation);
                cell4.setCellValue(commission);
                Double proceeds = incomeMoney + commission;
                cell5.setCellValue(proceeds);
                Double tax;
                if (proceeds % 10 == 0) {
                    tax = proceeds * 0.2;
                } else {
                    tax = proceeds * 0.1;
                }
                cell6.setCellValue(tax);
                Double sumToPayToInsuranceCompany = proceeds - tax;
                cell7.setCellValue(sumToPayToInsuranceCompany);
            }
            if (finOperation.payer.contains("Финогенов")) {
                if (incomeMoney != 0) {
                    cell8.setCellValue(incomeMoney);
                } else if (outcomeMoney != 0) {
                    cell9.setCellValue(outcomeMoney);
                }
            }
            if (outcomeMoney != 0) {
                if (finOperation.payer.contains("Согласие") || finOperation.description.contains("страхов") || finOperation.payer.contains("РОСЭНЕРГО")) {
                    cell10.setCellValue(outcomeMoney);
                    cell11.setCellValue(finOperation.payer);
                } else if (finOperation.payer.contains("ИФНС")) {
                    cell12.setCellValue(outcomeMoney);
                    cell14.setCellValue("оплата налогов");
                } else if (!finOperation.payer.contains("Финогенов")) {
                    cell13.setCellValue(outcomeMoney);
                    cell14.setCellValue(finOperation.payer);
                }
            }

            i++;
        }

        myExcelBook.write(file);
        myExcelBook.close();
    }
    public void writePaymentsFromIC (List <FinOperation> list, FileOutputStream file) throws IOException {
        for (FinOperation finOperation : list) {
            if (finOperation.payer.contains("РОСЭНЕРГО") && finOperation.moneyReceipt != 0)
            {
                Sheet rosenergo = insurancePayments.getSheet("Rosenergo");
                putValue(finOperation, rosenergo);

            }
            else if (finOperation.payer.contains("ВСК") && finOperation.moneyReceipt != 0)
            {
                Sheet vsk = insurancePayments.getSheet("VSK");
                putValue(finOperation, vsk);
            }
        }
        insurancePayments.write(file);
        insurancePayments.close();

    }

    public void putValue(FinOperation finOperation, Sheet sheet) {

        int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum+1);
        Cell date = row.createCell(0);
        Cell sum = row.createCell(1);
        date.setCellStyle(getDateStyle(insurancePayments));
        date.setCellValue(finOperation.date);
        sum.setCellValue(finOperation.moneyReceipt);
    }

    public Double getAcquiringCommission(FinOperation finOperation) {
        String s = finOperation.description;
        int x = s.lastIndexOf("Комиссия ");
        int begin = x + 9;
        int last = s.indexOf(". Возврат покупки");
        String comm = s.substring(begin, last);
        comm = comm.replace(",", "");
        return Double.parseDouble(comm);
    }
}


