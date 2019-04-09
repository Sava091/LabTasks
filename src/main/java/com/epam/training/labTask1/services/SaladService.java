package com.epam.training.labTask1.services;

import com.epam.training.labTask1.domain.Salad;
import com.epam.training.labTask1.domain.Vegitable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SaladService {
    public double calCalories(Salad salad) {
        Vegitable[] vegitables = salad.getVegitables();
        int calories = 0;
        for (int i = 0; i < vegitables.length; i++) {
            calories += vegitables[i].calCalories();
        }
        return calories;
    }

    public void sortWeigth(Salad salad) {
        Vegitable[] vegitables = salad.getVegitables();
        Arrays.sort(vegitables, new Comparator<Vegitable>() {
            public int compare(Vegitable o1, Vegitable o2) {
                return (int) (o1.getWeigth() - o2.getWeigth());
            }
        });
    }

    public List<Vegitable> findCalories(Salad salad, double minCalories, double maxCalories) {
        Vegitable[] vegitables = salad.getVegitables();
        List<Vegitable> resVegitebles = new ArrayList<>();
        for (int i = 0; i < vegitables.length; i++){
            if (minCalories < vegitables[i].calCalories() && maxCalories > vegitables[i].calCalories()) {
                resVegitebles.add(vegitables[i]);
            }
        }
        return resVegitebles;
    }
}
