package ru.comfortSoft.MinNumberAPI.parser;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ParserXlsx {
    public static Long[] parse(String pathXlsxFile) throws Exception {
        if (!pathXlsxFile.toLowerCase().endsWith(".xlsx")) {
            throw new IllegalArgumentException("File must be .xlsx");
        }

        List<Long> numbersList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(pathXlsxFile)) {
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double numberDouble = cell.getNumericCellValue();
                    numbersList.add(Math.round(numberDouble));
                } else {
                    throw new Exception("Cell in row №: "+ (row.getRowNum() + 1)+ " not numeric");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + pathXlsxFile + ": " + e.getMessage());
            throw e;
        }
        return numbersList.toArray(new Long[0]);
    }
}
