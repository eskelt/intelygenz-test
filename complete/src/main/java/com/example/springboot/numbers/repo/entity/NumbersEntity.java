package com.example.springboot.numbers.repo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "NUMBERS_DATASETS")
@Data
@NoArgsConstructor
public class NumbersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATASET_CODE")
    private String datasetCode;

    @ElementCollection
    @CollectionTable(name = "DATASETS_VALUES", joinColumns = @JoinColumn(name = "NUMBERS_DATASETS_ID"))
    @Column(name = "NUMBER_VALUE")
    private List<Integer> values;

}