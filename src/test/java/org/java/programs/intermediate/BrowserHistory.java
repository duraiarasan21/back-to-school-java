package org.java.programs.intermediate;

import java.util.Stack;

public class BrowserHistory {

    interface BrowserHistoryInterface {
        void visit(String url);
        String back(int steps);
        String forward(int steps);
    }

    public static class BrowserHistoryUsingStacks implements BrowserHistoryInterface{

        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();

        BrowserHistoryUsingStacks(String homepage) {
            backStack.push(homepage);
        }

        @Override
        public void visit(String url) {
            while (!forwardStack.isEmpty()) {
                forwardStack.pop();
            }
            backStack.push(url);
        }

        @Override
        public String back(int steps) {
            while (steps > 0 && backStack.size() > 1) {
                forwardStack.push(backStack.pop());
                steps--;
            }
            return backStack.peek();
        }

        @Override
        public String forward(int steps) {
            while (steps > 0 && !forwardStack.isEmpty()) {
                backStack.push(forwardStack.pop());
                steps--;
            }
            return backStack.peek();
        }
    }

    public static class BrowserHistoryUsingDoublyLinkedList implements BrowserHistoryInterface{
        static class Node {
            String url;
            Node prev;
            Node next;

            Node(String url) {
                this.url = url;
            }
        }

        Node current;

        BrowserHistoryUsingDoublyLinkedList(String homepage) {
            current = new Node(homepage);
        }

        @Override
        public void visit(String url) {
            Node newNode = new Node(url);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        @Override
        public String back(int steps) {
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
            return current.url;
        }

        @Override
        public String forward(int steps) {
            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }
            return current.url;
        }
    }




    void run(BrowserHistoryInterface browserHistoryInterface) {
        browserHistoryInterface.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistoryInterface.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistoryInterface.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistoryInterface.back(1)); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistoryInterface.back(1)); // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistoryInterface.forward(1)); // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistoryInterface.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistoryInterface.forward(2)); // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistoryInterface.back(2)); // You are in "linkedin.com", move back two steps to "google.com" return "google.com"
        System.out.println(browserHistoryInterface.back(7)); // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }


    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        String homepage = "leetcode.com";
        System.out.println("Using Stacks:");
        browserHistory.run(new BrowserHistoryUsingStacks(homepage));
        System.out.println("Using Doubly Linked List:");
        browserHistory.run(new BrowserHistoryUsingDoublyLinkedList(homepage));
    }
}



