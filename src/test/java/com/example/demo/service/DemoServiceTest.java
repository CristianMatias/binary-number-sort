package com.example.demo.service;

import com.example.demo.model.DemoEntity;
import com.example.demo.repository.DemoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Mock
    private DemoRepository demoRepository;

    private List<DemoEntity> unsortedList;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        unsortedList = new ArrayList<>();
        unsortedList.add(new DemoEntity(1));
        unsortedList.add(new DemoEntity(15));
        unsortedList.add(new DemoEntity(5));
        unsortedList.add(new DemoEntity(7));
        unsortedList.add(new DemoEntity(3));
    }

    //15, 7, 3, 5, 1
    @Test
    void testSortNumbers(){
        Mockito.when(demoRepository.findAll()).thenReturn(unsortedList);
        List<DemoEntity> expectedList = new ArrayList<>();
        expectedList.add(new DemoEntity(15));
        expectedList.add(new DemoEntity(7));
        expectedList.add(new DemoEntity(3));
        expectedList.add(new DemoEntity(5));
        expectedList.add(new DemoEntity(1));

        var result = demoService.sortNumbersByDecimal();
        assertEquals(expectedList, result);
    }

}