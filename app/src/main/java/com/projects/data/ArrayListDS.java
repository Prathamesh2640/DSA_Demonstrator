package com.projects.data;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDS implements StructureInterface {
    private static final int MAX_SIZE = 10; // Handle overflow
    private ArrayList<Integer> list;

    public ArrayListDS() {
        list = new ArrayList<>();
    }

    @Override
    public void insert(int value) {
        if (list.size() < MAX_SIZE) {
            list.add(value);
        }
    }

    @Override
    public void delete(int value) {
        list.remove(Integer.valueOf(value));
    }

    @Override
    public List<Integer> display() {
        return new ArrayList<>(list);
    }
}