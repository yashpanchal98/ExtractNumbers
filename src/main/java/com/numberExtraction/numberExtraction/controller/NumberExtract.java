package com.numberExtraction.numberExtraction.controller;

import com.numberExtraction.numberExtraction.InputString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class NumberExtract {

    @PostMapping("/extractNumbers")
    public List<Integer> getNumbers(@RequestBody InputString inputString) {
        List<Integer> numbers = new ArrayList<>();
        String temp = "";

        for (char c : inputString.getText().toCharArray()) {
            if (Character.isDigit(c)) {
                temp += c;
            } else {
                if (!temp.isEmpty()) {
                    numbers.add(Integer.parseInt(temp));
                    temp = "";
                }
            }
        }
        if (!temp.isEmpty()) {
            numbers.add(Integer.parseInt(temp));
        }

        return numbers;
    }
}
