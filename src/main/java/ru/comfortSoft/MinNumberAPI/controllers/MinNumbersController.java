package ru.comfortSoft.MinNumberAPI.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.comfortSoft.MinNumberAPI.parser.ParserXlsx;
import ru.comfortSoft.MinNumberAPI.util.Sort;

@Tag(name = "MinNumberController",
        description = "Контроллер для поиска N-го минимального числа в массиве из XLSX файла")
@RestController
@RequestMapping("/min")
public class MinNumbersController {

    @GetMapping
    public ResponseEntity<Long> minNumbers(@Parameter(description = "Local path to .xlsx file",
                                                   example = "d:/array_numbers.xlsx",
                                                   required = true)
                                           @RequestParam String pathFile,
                                           @Parameter(description = "Minimum number index", example = "3",
                                                   required = true)
                                           @RequestParam int N) throws Exception {
        if (pathFile == null || N < 1) {
            throw new Exception("Path file empty or number < 1");
        }
        Long[] longArray = ParserXlsx.parse(pathFile);
        if (longArray.length == 0 || longArray.length < N) {
            throw new Exception("Array is empty or number > array length");
        }
        Sort.quickSort(longArray);
        Long minElement = longArray[N - 1];
        return new ResponseEntity<>(minElement, HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<String> handlerException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
