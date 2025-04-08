package org.java.programs.beginner;

public class PrimeNumber {

    static void primeCheckSimple(long number){
        if (number == 1){
            System.out.println(number + " is neither Prime nor composite");
            return;
        }
        if(number == 2){
            System.out.println(number + " is a Prime number");
            return;
        }

        for(int i = 3; i < number; i++){
            if(number % i == 0){
                System.out.println(number + " is not a Prime number");
                return;
            }
        }
        System.out.println(number + " is a Prime number");
    }

    static void primeCheckOptimized(long number){
        boolean isprime = false;
        if (number <= 1){
            isprime = false;
        } else if(number == 2){
            isprime = true;
        }

        for(int i = 3; i <= number/2; i++){
            if (number % i == 0) {
                isprime = false;
                break;
            }
        }
        System.out.println(number + " is " + (isprime ? "Prime number" : "not Prime number"));
    }

    static void primeCheckOptimizedSqrt(long number){
        if(isPrime(number))
            System.out.println(number + " is a Prime number");
        else
            System.out.println(number + " is not a Prime number");
    }

    static boolean isPrime(long number){

        // 0 and 1 are not prime numbers
        // negative numbers are not prime
        if (number <= 1){
            return false;
        } else if(number == 2){ // special case as 2 is the only even number that is prime
           return true;
        } else if(number % 2 == 0) {  // Check if n is a multiple of 2 thus all these won't be prime
            return false;
        }

        for(int i = 3; i <= Math.sqrt(number); i+=2){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        primeCheckSimple(17);
        primeCheckOptimized(132145465);
        primeCheckOptimizedSqrt(4546875425121842131L);
    }
}
