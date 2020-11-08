package excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
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
            Cell cell = row.createCell(0);
            cell.setCellStyle(getDateStyle());
            cell.setCellValue(finOperation.date);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(finOperation.moneyReceipt);
            Cell cell2 = row.createCell(2);
            if (finOperation.moneyReceipt != 0.00 && !finOperation.payer.contains("СБЕРБАНК"))
            {
                cell2.setCellValue(finOperation.payer);
            }
            Cell cell3 = row.createCell(3);
            if (finOperation.payer.contains("СБЕРБАНК")) {
                cell3.setCellValue(getAcquiringCommission(finOperation));
            }

            i++;
        }

        myExcelBook.write(file);
        myExcelBook.close();
    }

    public Double getAcquiringCommission(FinOperation finOperation) {
            String s = finOperation.description;
            int x = s.lastIndexOf("Комиссия ");
            int last = s.indexOf(". Возврат покупки");
            String comm = s.substring(x, last);
            comm = comm.replace(".", ",");
            return Double.parseDouble(comm);
        }
    }


