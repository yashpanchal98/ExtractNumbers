package com.numberExtraction.numberExtraction.controller;

import com.numberExtraction.numberExtraction.InputString;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class NumberExtract {

    // Store all previous POST results
    private static final List<List<Integer>> allResults = new ArrayList<>();

    // POST mapping (your working one)
    @PostMapping("/extractNumbers")
    public List<Integer> getNumbers(@RequestBody InputString inputString) {
        List<Integer> numbers = extractNumbers(inputString.getText());
        allResults.add(numbers); // store result
        return numbers;
    }

    // GET mapping to return all previous POST results
    @GetMapping("/allNumbers")
    public List<List<Integer>> getAllNumbers() {
        return allResults;
    }

    // Helper method to extract numbers from a string
    private List<Integer> extractNumbers(String text) {
        List<Integer> numbers = new ArrayList<>();
        String temp = "";
        for (char c : text.toCharArray()) {
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
