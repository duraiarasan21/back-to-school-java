package org.java.programs.beginner;

import java.math.BigInteger;
import java.util.*;

public class Datatypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            try {

                String nString = sc.next();
                BigInteger n = new BigInteger(nString);

                // Use a StringBuilder to build the output for fitted types
                StringBuilder outputBuilder = new StringBuilder();
                boolean fitted = false;

                // Check byte
                if (n.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
                    outputBuilder.append("* byte\n");
                    fitted = true;
                }
                // Check short
                if (n.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
                    outputBuilder.append("* short\n");
                    fitted = true;
                }
                // Check int
                if (n.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                    outputBuilder.append("* int\n");
                    fitted = true;
                }
                // Check long
                if (n.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 && n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                    outputBuilder.append("* long\n");
                    fitted = true;
                }

                if (fitted) {
                    System.out.println(nString + " can be fitted in:");
                    System.out.print(outputBuilder);
                } else {
                    System.out.println(nString + " can't be fitted anywhere.");
                }

            } catch (Exception e) {
                // This catch block handles cases where the input is not a valid BigInteger.
                // However, the problem statement implies valid integer strings.
                // For robustness, could print an error, but the primary logic is for fitting.
                System.out.println(sc.next() + " can't be fitted anywhere."); // This line is not needed given the problem constraint
            }
        }
        sc.close();
    }
}