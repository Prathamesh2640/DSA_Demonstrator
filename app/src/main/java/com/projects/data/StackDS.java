package com.projects.data;

import java.util.ArrayList;
import java.util.List;

public class StackDS implements StructureInterface {
    private static final int MAX_SIZE = 10; // Handle overflow
    private LinkedListDS list;

    public StackDS() {
        list = new LinkedListDS();
    }

    @Override
    public void insert(int value) {
        if (list.display().size() < MAX_SIZE) {
            list.insert(value);
        }
    }

    @Override
    public void delete(int value) {
        if (!list.display().isEmpty()) {
            List<Integer> current = list.display();
            if (current.get(current.size() - 1) == value) {
                list.delete(value); // Remove last inserted (top)
            }
        }
    }

    @Override
    public List<Integer> display() {
        return list.display();
    }
}