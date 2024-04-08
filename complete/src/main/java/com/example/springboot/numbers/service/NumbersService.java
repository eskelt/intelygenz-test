package com.example.springboot.numbers.service;

import com.example.springboot.numbers.repo.impl.NumbersRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NumbersService {

    private final NumbersRepoImpl numberRepoImpl;

    public List<Integer> sortedList(String dataset){
        List<Integer> numbers = numberRepoImpl.getNumbers(dataset);
        return numbers.stream().sorted((o1, o2) -> {
            int o1Binary1ocurr = get1OcurrencesInBinary(o1);
            int o2Binary1ocurr = get1OcurrencesInBinary(o2);
            if(o1Binary1ocurr != o2Binary1ocurr){
                return o2Binary1ocurr - o1Binary1ocurr;
            }
            else{
                return o1 - o2;
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> sortedList2(String dataset){
        List<Integer> numbers = numberRepoImpl.getNumbers(dataset);
        Map<Integer, Integer> numbersMap = new HashMap();
        numbers.forEach(n -> numbersMap.put(n, get1OcurrencesInBinary(n)));
        return numbers.stream().sorted((a, b) -> {
            if(numbersMap.get(a) != numbersMap.get(b)){
                return numbersMap.get(b) - numbersMap.get(a);
            }
            else{
                return a - b;
            }
        }).collect(Collectors.toList());
    }

    private int get1OcurrencesInBinary(Integer n){
        return countString1Occurrences(Integer.toBinaryString(n));
    }

    private int countString1Occurrences(String s){
        return (int)s.chars().filter(c -> c == '1').count();
    }

}
