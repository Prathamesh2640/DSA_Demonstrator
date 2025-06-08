package com.projects.data;

import java.util.ArrayList;
import java.util.List;

public class DequeDS implements StructureInterface {
    private static final int MAX_SIZE = 10; // Handle overflow
    private LinkedListDS list;

    public DequeDS() {
        list = new LinkedListDS();
    }

    @Override
    public void insert(int value) {
        if (display().size() < MAX_SIZE) {
            list.insert(value); // Add to rear
        }
    }

    public void insertFront(int value) {
        if (display().size() < MAX_SIZE) {
            LinkedListDS temp = new LinkedListDS();
            temp.insert(value);
            List<Integer> current = list.display();
            for (Integer val : current) {
                temp.insert(val);
            }
            list = temp;
        }
    }

    @Override
    public void delete(int value) {
        list.delete(value); // Remove first occurrence
    }

    public void deleteFront() {
        List<Integer> current = list.display();
        if (!current.isEmpty()) {
            list.delete(current.get(0)); // Remove first element
        }
    }

    @Override
    public List<Integer> display() {
        return list.display();
    }

    public boolean isPalindrome(String input) {
        if (!input.matches("\\d+")) {
            return false; // Ensure input is numeric
        }
        DequeDS temp = new DequeDS();
        for (char c : input.toCharArray()) {
            temp.insert(Character.getNumericValue(c));
        }
        List<Integer> elements = temp.display();
        int left = 0;
        int right = elements.size() - 1;
        while (left < right) {
            if (!elements.get(left).equals(elements.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}