package com.example.demo.controller;

import com.example.demo.model.DemoEntity;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/sortNumber")
    public List<DemoEntity> sortNumbersInBinary(){
        return demoService.sortNumbersByDecimal();
    }
}
