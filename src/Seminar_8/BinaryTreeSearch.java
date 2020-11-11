package Seminar_8;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSearch<T>{
    private static class Node<T> {
        int key;
        T value;
        public Node<T> left, right;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    Node<T> root;

    public void add(int key, T value) { root = addRecursive(root, key, value); }

    private Node<T> addRecursive(Node<T> cur, int key, T value) {
        if (cur == null) return new Node<>(key, value);
        if (key < cur.key) cur.left = addRecursive(cur.left, key, value);
        if (key > cur.key) cur.right = addRecursive(cur.right, key, value);
        return cur;
    }

    public T search(int key) { return searchRecursive(root, key).value; }

    private Node<T> searchRecursive(Node<T> cur, int key) {
        if (cur == null) return null;
        if (key < cur.key) return searchRecursive(cur.left, key);
        if (key > cur.key) return searchRecursive(cur.right, key);
        return cur;
    }

    public void delete(int key) { root = deleteRecursive(root, key); }

    private Node<T> findSmallestNode(Node<T> root) {
        return root.left == null ? root : findSmallestNode(root.left);
    }

    private Node<T> deleteRecursive(Node<T> cur, int key) {
        if (cur == null) return null;
        if (key == cur.key) {
            if (cur.left == null && cur.right == null) return null;
            if (cur.right == null) return cur.left;
            if (cur.left == null) return cur.right;
            Node<T> smallestNode = findSmallestNode(cur.right);
            cur.key = smallestNode.key;
            cur.value = smallestNode.value;
            cur.right = deleteRecursive(cur.right, smallestNode.key);
            return cur;
        }
        if (key < cur.key) {
            cur.left = deleteRecursive(cur.left, key);
            return cur;
        }
        cur.right = deleteRecursive(cur.right, key);
        return cur;
    }

    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.key + " " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traverseInOrder() { traverseInOrder(root); }

    public void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node.key + " " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePreOrder() { traversePreOrder(root); }

    public void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(node.key + " " + node.value);
        }
    }

    public void traversePostOrder() { traversePostOrder(root); }

    public void traverseLevelOrder() {
        if (root == null) return;
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.remove();
            System.out.println(node.key + " " + node.value);
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }
    }
}
