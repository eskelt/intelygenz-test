package com.example.springboot.numbers.service;

import com.example.springboot.numbers.repo.impl.NumbersRepoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class NumbersServiceTest {

    @InjectMocks
    NumbersService numbersService;

    @Mock
    NumbersRepoImpl numbersRepoImpl;

    private final int RUN_ITERATIONS = 1000;
    private final int RANDOM_LIST_SIZE = 1000;
    private final int RANDOM_LIST_MAX_NUMBER = 1000000;
    private List<Integer> randomList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        generateRandomList();
    }

    private void generateRandomList(){
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < RANDOM_LIST_SIZE; i++){
            randomList.add(random.nextInt(RANDOM_LIST_MAX_NUMBER));
        }
        this.randomList = randomList;
    }

    @Test
    public void sortedListTest(){
        when(numbersRepoImpl.getNumbers(anyString())).thenReturn(List.of(8, 16, 31, 32, 64, 128, 15, 256));
        List<Integer> result = numbersService.sortedList(anyString());
        assertEquals(List.of(31, 15, 8, 16, 32, 64, 128, 256), result);
    }



    @Test
    public void sortedListPerformanceTest(){
        when(numbersRepoImpl.getNumbers(anyString())).thenReturn(this.randomList);

        long startTime = System.nanoTime();
        for (int i = 0; i < RUN_ITERATIONS; ++i) {
            numbersService.sortedList(anyString());
        }
        long endTime = System.nanoTime();

        System.out.println("sortedList: " + (endTime - startTime)/1000000 + " milliseconds");
    }

    @Test
    public void sortedList2PerformanceTest(){
        when(numbersRepoImpl.getNumbers(anyString())).thenReturn(this.randomList);

        long startTime = System.nanoTime();
        for (int i = 0; i < RUN_ITERATIONS; ++i) {
            numbersService.sortedList2(anyString());
        }
        long endTime = System.nanoTime();

        System.out.println("sortedList Version 2: " + (endTime - startTime)/1000000 + " milliseconds");
    }

}
