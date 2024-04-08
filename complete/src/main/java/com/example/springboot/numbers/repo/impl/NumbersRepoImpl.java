package com.example.springboot.numbers.repo.impl;

import com.example.springboot.numbers.repo.entity.NumbersEntity;
import com.example.springboot.numbers.repo.NumbersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NumbersRepoImpl {

    private final NumbersRepository numbersRepository;

    public List<Integer> getNumbers(String dataset) {
        NumbersEntity numbersByDataset = numbersRepository.findByDatasetCode(dataset);
        if(numbersByDataset != null){
            return numbersByDataset.getValues();
        }
        return new ArrayList<Integer>();
    }

}
