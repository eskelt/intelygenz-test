package com.example.springboot.numbers.web;

import com.example.springboot.numbers.service.NumbersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/numbers")
public class NumbersController {

    private final NumbersService numberService;

    @GetMapping("/sortedList/{dataset}")
    public ResponseEntity<List<Integer>> sortedList(@PathVariable String dataset){
        List<Integer> numbersList = numberService.sortedList(dataset);
        return new ResponseEntity<>(numbersList, HttpStatus.OK);
    }

    @GetMapping("/sortedList2/{dataset}")
    public ResponseEntity<List<Integer>> sortedList2(@PathVariable String dataset){
        List<Integer> numbersList = numberService.sortedList2(dataset);
        return new ResponseEntity<>(numbersList, HttpStatus.OK);
    }
}
