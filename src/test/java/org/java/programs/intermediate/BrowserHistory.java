package org.java.programs.intermediate;

import java.util.Stack;
import java.util.Scanner;

class BrowserHistory {
    // Stores URLs to go back to.
    private Stack<String> backStack;
    // Stores URLs that were navigated back from (for forward navigation).
    private Stack<String> forwardStack;
    // The currently displayed URL.
    private String currentURL;

    /**
     * Constructor to initialize the browser history with the home page.
     */
    public BrowserHistory(String homePage) {
        // Initialize stacks and set the starting URL.
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();
        this.currentURL = homePage;
    }

    /**
     * Adds a new URL to the history.
     */
    public void visit(String url) {
        // 1. Current URL is pushed to backStack (becomes the previous page)
        backStack.push(currentURL);

        // 2. New URL becomes the current URL
        currentURL = url;

        // 3. forwardStack is cleared (cannot go forward after visiting a new page)
        forwardStack.clear();
    }

    /**
     * Navigates to the previous URL.
     */
    public void goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No history to go back to.");
            return;
        }

        // 1. Current URL is pushed to forwardStack (to enable 'goForward')
        forwardStack.push(currentURL);

        // 2. Top URL from backStack becomes the current URL
        currentURL = backStack.pop();
    }

    /**
     * Navigates to the next URL.
     */
    public void goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No forward history available.");
            return;
        }

        // 1. Current URL is pushed to backStack
        backStack.push(currentURL);

        // 2. Top URL from forwardStack becomes the current URL
        currentURL = forwardStack.pop();
    }

    /**
     * Retrieves the current URL.
     */
    public String getCurrentURL() {
        return currentURL;
    }


    public static void main(String[] args) {
        // Initial setup as specified in the problem.
        final String HOME_PAGE = "www.homepage.com";
        BrowserHistory browserHistory = new BrowserHistory(HOME_PAGE);

        Scanner scanner = new Scanner(System.in);

        // Loop to process user input commands.
        while (scanner.hasNextInt()) {
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after the integer input

            if (option == 5) { // Exit
                break;
            }

            switch (option) {
                case 1: // Visit a page
                    if (scanner.hasNextLine()) {
                        String url = scanner.nextLine();
                        browserHistory.visit(url);
                    }
                    break;
                case 2: // Go forward
                    browserHistory.goForward();
                    break;
                case 3: // Go back
                    browserHistory.goBack();
                    break;
                case 4: // Print current URL
                    System.out.println(browserHistory.getCurrentURL());
                    break;
                default:
                    // For any unexpected input
                    break;
            }
        }
        scanner.close();
    }
}