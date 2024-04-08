package com.example.springboot.numbers.repo;

import com.example.springboot.numbers.repo.entity.NumbersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumbersRepository extends JpaRepository<NumbersEntity, Long> {

    NumbersEntity findByDatasetCode(String datasetCode);

}
