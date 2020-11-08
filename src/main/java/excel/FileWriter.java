package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {
    Workbook myExcelBook = new XSSFWorkbook(new FileInputStream("C:\\java\\z.xlsx"));
    Sheet sheet = myExcelBook.createSheet();
    CreationHelper creationHelper = myExcelBook.getCreationHelper();

    public FileWriter() throws IOException {
    }

    public CellStyle getDateStyle() {
        CellStyle dateStyle = myExcelBook.createCellStyle();
        dateStyle.setDataFormat(
                creationHelper.createDataFormat().getFormat("dd.MM.yyyy")
        );
        return dateStyle;
    }

    public void writeToFile(List<FinOperation> list, FileOutputStream file) throws IOException {
        int i = 2;
        for (FinOperation finOperation : list) {
            Row row = sheet.createRow(i);
            for (int x = 0; x< 15; x++)
            {
                List list1 = new ArrayList();
                list1.add(row.createCell(x));

            }
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
            cell.setCellStyle(getDateStyle());
            cell.setCellValue(finOperation.date);

            Double incomeMoney = finOperation.moneyReceipt;
            if (incomeMoney != 0) {
                cell1.setCellValue(finOperation.moneyReceipt);
            }
            if (incomeMoney != 0.00 && !finOperation.payer.contains("СБЕРБАНК"))
            {
                cell2.setCellValue(finOperation.payer);
            }
            if (finOperation.payer.contains("СБЕРБАНК")) {
                Double commission = getAcquiringCommission(finOperation);
                cell3.setCellValue(commission);
                Double insCost = incomeMoney + commission;
                cell4.setCellValue(insCost);
                Double tax;
                if (insCost % 10 == 0)
                {
                    tax = insCost * 0.2;
                }
                else
                {
                    tax = insCost * 0.1;
                }
                cell5.setCellValue(tax);

            }



            i++;
        }

        myExcelBook.write(file);
        myExcelBook.close();
    }

    public Double getAcquiringCommission(FinOperation finOperation) {
            String s = finOperation.description;
            int x = s.lastIndexOf("Комиссия ");
            int begin = x + 9;
            int last = s.indexOf(". Возврат покупки");
            String comm = s.substring(begin, last);
            return Double.parseDouble(comm);
        }
    }


