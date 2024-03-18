package com.example.demo.util;

import com.example.demo.model.DemoEntity;

import java.util.Comparator;

public class CustomComparator implements Comparator<DemoEntity> {

    @Override
    public int compare(DemoEntity num1, DemoEntity num2) {
        int countOnesNum1 = countOnesInBinaryRepresentation(num1.getNumber());
        int countOnesNum2 = countOnesInBinaryRepresentation(num2.getNumber());

        // Si tienen la misma cantidad de unos, compara los números decimales
        if (countOnesNum1 == countOnesNum2) {
            return num1.getNumber() - num2.getNumber();
        }

        // Si no, compara la cantidad de unos en la representación binaria
        return countOnesNum2 - countOnesNum1; // Orden descendente por cantidad de unos
    }

    private int countOnesInBinaryRepresentation(int num) {
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}
