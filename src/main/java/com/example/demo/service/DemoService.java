package com.example.demo.service;

import com.example.demo.model.DemoEntity;
import com.example.demo.repository.DemoRepository;
import com.example.demo.util.CustomComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    private CustomComparator customComparator = new CustomComparator();

    public List<DemoEntity> sortNumbersByDecimal(){
        List<DemoEntity> numbers = demoRepository.findAll();
        numbers.sort(customComparator);
        return numbers;
    }

}
