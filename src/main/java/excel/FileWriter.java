package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.DateFormatConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FileWriter {
    Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\fin.xlsx"));
    Workbook insurancePayments = new XSSFWorkbook(new FileInputStream("C:\\Users\\Krugl\\OneDrive\\Рабочий стол\\1.Игра престолов\\Работа\\paymentsFromIC.xlsx"));


    public FileWriter() throws IOException {
    }

    public CellStyle getDateStyle(Workbook workbook)
    {
        String excelFormatPattern = DateFormatConverter.convert(Locale.ENGLISH, "dd.MM.yyyy");

        CellStyle cellStyle = workbook.createCellStyle();

        DataFormat poiFormat = workbook.createDataFormat();
        cellStyle.setDataFormat(poiFormat.getFormat(excelFormatPattern));
        return cellStyle;
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
                double proceeds = incomeMoney + commission;
                cell5.setCellValue(proceeds);
                double tax;
                if (proceeds % 10 == 0) {
                    tax = proceeds * 0.2;
                } else {
                    tax = proceeds * 0.1;
                }
                cell6.setCellValue(tax);
                double sumToPayToInsuranceCompany = proceeds - tax;
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
            else if (finOperation.payer.contains("Астроволга") && finOperation.moneyReceipt != 0)
            {
                Sheet vsk = insurancePayments.getSheet("Astrovolga");
                putValue(finOperation, vsk);

            }
            else if (finOperation.payer.contains("Согласие") && finOperation.moneyReceipt != 0)
            {
                Sheet vsk = insurancePayments.getSheet("Soglasie");
                putValue(finOperation, vsk);

            }
            else if (finOperation.payer.contains("Ингосстрах") && finOperation.moneyReceipt != 0)
            {
                Sheet vsk = insurancePayments.getSheet("Ingosstrah");
                putValue(finOperation, vsk);

            }
            else if (finOperation.payer.contains("Energogarant") && finOperation.moneyReceipt != 0)
            {
                Sheet vsk = insurancePayments.getSheet("VSK");
                putValue(finOperation, vsk);
            }
            else if (finOperation.moneyReceipt != 0 && finOperation.description.contains("страх") || finOperation.description.contains("вознагр"))
            {
                Sheet anotherIC = insurancePayments.getSheet("AnotherIC");
                putValueForAnotherIC(finOperation, anotherIC);

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
        Cell description = row.createCell(2);
        CellStyle style = getDateStyle(insurancePayments);
        date.setCellValue(finOperation.date);
        date.setCellStyle(style);
        sum.setCellValue(finOperation.moneyReceipt);
        description.setCellValue(finOperation.description);
    }
    public void putValueForAnotherIC(FinOperation finOperation, Sheet sheet) {

        int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum+1);
        Cell payer = row.createCell(0);
        Cell date = row.createCell(1);
        Cell sum = row.createCell(2);
        Cell description = row.createCell(3);
        payer.setCellValue(finOperation.payer);
        CellStyle style = getDateStyle(insurancePayments);
        date.setCellValue(finOperation.date);
        date.setCellStyle(style);
        sum.setCellValue(finOperation.moneyReceipt);
        description.setCellValue(finOperation.description);
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


