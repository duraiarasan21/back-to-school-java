package org.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.java.programs.beginner.StringPalindrome;

/**
 * Unit test for simple App.
 */
public class Runner extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Runner(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Runner.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        StringPalindrome stringPalindrome = new StringPalindrome();
        stringPalindrome.reverse("arara");
        assertTrue(true);
    }
}
