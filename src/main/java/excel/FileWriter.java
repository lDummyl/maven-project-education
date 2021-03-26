package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.DateFormatConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class FileWriter {
    Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\fin.xlsx"));
    Workbook insurancePayments = new XSSFWorkbook(new FileInputStream("C:\\java\\paymentsFromIC.xlsx"));


    public FileWriter() throws IOException {
    }

    public CellStyle getDateStyle(Workbook workbook) {
        String excelFormatPattern = DateFormatConverter.convert(Locale.ENGLISH, "dd.MM.yyyy");

        CellStyle cellStyle = workbook.createCellStyle();

        DataFormat poiFormat = workbook.createDataFormat();
        cellStyle.setDataFormat(poiFormat.getFormat(excelFormatPattern));
        return cellStyle;
    }

    public void writeToFile(List<FinOperation> list, FileOutputStream file) throws IOException {
        Sheet clonedSheet = myExcelBook.cloneSheet(myExcelBook.getSheetIndex("month"));
        myExcelBook.setSheetName(myExcelBook.getSheetIndex(clonedSheet), "12");
        int i = 2;
        for (FinOperation finOperation : list) {
            Row row = clonedSheet.createRow(i);
            Cell cellDate = row.createCell(0);
            Cell incomeFromInsuranceCompany = row.createCell(1);
            Cell insuranceCompanyPayer = row.createCell(2);
            Cell incomePayment = row.createCell(3);
            Cell acquiringCommission = row.createCell(4);
            Cell earnings = row.createCell(5);
            Cell agentCommission = row.createCell(6);
            Cell sumToPayToInsuranceCompany = row.createCell(7);
            Cell depositingMoney = row.createCell(8);
            Cell transferMoney = row.createCell(9);
            Cell paymentToInsuranceCompany = row.createCell(10);
            Cell insuranceCompanyRecipientPayment = row.createCell(11);
            Cell payTax = row.createCell(12);
            Cell otherOutlay = row.createCell(13);
            Cell comments = row.createCell(14);
            cellDate.setCellStyle(getDateStyle(myExcelBook));
            cellDate.setCellValue(finOperation.date);
            Double incomeMoney = finOperation.moneyReceipt;
            Double outcomeMoney = finOperation.consumption;
            if (incomeMoney != 0.00 && !finOperation.payer.contains("СБЕРБАНК")) {
                incomeFromInsuranceCompany.setCellValue(incomeMoney);
                insuranceCompanyPayer.setCellValue(finOperation.payer);
            }
            if (finOperation.payer.contains("СБЕРБАНК")) {
                incomePayment.setCellValue(incomeMoney);
                Double commission = getAcquiringCommission(finOperation);
                acquiringCommission.setCellValue(commission);
                double proceeds = incomeMoney + commission;
                earnings.setCellValue(proceeds);
                double tax;
                if (isGreenCard(proceeds)) {
                    tax = proceeds * 0.2;
                } else {
                    tax = proceeds * 0.1;
                }
                agentCommission.setCellValue(tax);
                double payToInsuranceCompany = proceeds - tax;
                sumToPayToInsuranceCompany.setCellValue(payToInsuranceCompany);
            }
            if (finOperation.payer.contains("Финогенов")) {
                if (incomeMoney != 0) {
                    depositingMoney.setCellValue(incomeMoney);
                } else if (outcomeMoney != 0) {
                    transferMoney.setCellValue(outcomeMoney);
                }
            }
            if (outcomeMoney != 0) {
                if (finOperation.payer.contains("Согласие") || finOperation.description.contains("страхов") || finOperation.payer.contains("РОСЭНЕРГО")) {
                    paymentToInsuranceCompany.setCellValue(outcomeMoney);
                    insuranceCompanyRecipientPayment.setCellValue(finOperation.payer);
                } else if (finOperation.payer.contains("ИФНС")) {
                    payTax.setCellValue(outcomeMoney);
                    comments.setCellValue("оплата налогов");
                } else if (!finOperation.payer.contains("Финогенов")) {
                    otherOutlay.setCellValue(outcomeMoney);
                    comments.setCellValue(finOperation.payer);
                }
            }

            i++;
        }

        myExcelBook.write(file);
        myExcelBook.close();
    }

    public boolean isGreenCard(double proceeds) {
        return proceeds % 10 == 0;
    }

    HashMap<String, String> russianNamesOfInsuranceCompanies = new HashMap<>();

    {
        russianNamesOfInsuranceCompanies.put("Согласие", "SOGLASIE");
        russianNamesOfInsuranceCompanies.put("РОСЭНЕРГО", "ROSENERGO");
        russianNamesOfInsuranceCompanies.put("ВСК", "VSK");
        russianNamesOfInsuranceCompanies.put("Ингосстрах", "INGOSSTRAH");
        russianNamesOfInsuranceCompanies.put("Росгосстрах", "RGS");
        russianNamesOfInsuranceCompanies.put("РЕСО-Гарантия", "RESO");
        russianNamesOfInsuranceCompanies.put("Страховое общество газовой промышленности", "SOGAZ");
    }

    public void writePaymentsFromIC(List<FinOperation> list, FileOutputStream file) throws IOException {
        for (FinOperation finOperation : list) {
            if (finOperation.moneyReceipt != 0) {
                for (String companyName : russianNamesOfInsuranceCompanies.keySet()) {
                    if (finOperation.payer.contains(companyName)) {
                        String transliterationName = russianNamesOfInsuranceCompanies.get(companyName);
                        Sheet sheet = insurancePayments.getSheet(transliterationName);
                        putValue(finOperation, sheet);
                    }
                }
            }
        }
        insurancePayments.write(file);
        insurancePayments.close();
    }

    public void putValue(FinOperation finOperation, Sheet sheet) {

        int lastRowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRowNum + 1);
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
        Row row = sheet.createRow(lastRowNum + 1);
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


