package com.projects.data;

import java.util.ArrayList;
import java.util.List;

public class BSTDS implements StructureInterface {
    private static final int MAX_SIZE = 10; // Handle overflow
    private class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void insert(int data) {
        if (size < MAX_SIZE) {
            root = insertRec(root, data);
            size++;
        }
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root; // Iterative alternative: use a loop to traverse and insert
    }

    @Override
    public void delete(int data) {
        if (root != null) {
            root = deleteRec(root, data);
            size--;
        }
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) return null; // Handle NullPointerException
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root; // Iterative alternative: use a parent pointer and loop
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    @Override
    public List<Integer> display() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    private void inorderRec(Node root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.data);
            inorderRec(root.right, result);
        } // Iterative alternative: use a stack for inorder traversal
    }
}