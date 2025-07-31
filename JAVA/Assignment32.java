package com.wipro.practice;
/*
 By using multiple catch blocks, write a class to demonstrate the order of the execution of the 
catch blocks usingNegativeArraySizeException,ArrayIndexOutOfBoundsException, 
StringIndexOutOfBoundsException, IndexOutOfBoundsException, NullPointerException,          
ArithmeticException and print the stack trace for each exception.
 */
public class Assignment32 {
	public static void main(String[] args) {

        // NegativeArraySizeException
        try {
            int[] a = new int[-2];
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }

        // StringIndexOutOfBoundsException
        try {
            String s = "Hello";
            System.out.println(s.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        }

        //IndexOutOfBoundsException
        try {
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            list.add(100);
            System.out.println(list.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        }

        // NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        }

        // ArithmeticException
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }

        System.out.println("Program finished!");
    }

}


/*
 Caught NegativeArraySizeException
java.lang.NegativeArraySizeException: -2
	at com.wipro.practice.Assignment32.main(Assignment32.java:13)
Caught ArrayIndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 2
	at com.wipro.practice.Assignment32.main(Assignment32.java:22)
Caught StringIndexOutOfBoundsException
java.lang.StringIndexOutOfBoundsException: Index 10 out of bounds for length 5
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
	at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
	at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	at java.base/java.lang.String.checkIndex(String.java:4832)
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:46)
	at java.base/java.lang.String.charAt(String.java:1555)
	at com.wipro.practice.Assignment32.main(Assignment32.java:31)
Caught IndexOutOfBoundsException
java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 1
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	at java.base/java.util.Objects.checkIndex(Objects.java:385)
	at java.base/java.util.ArrayList.get(ArrayList.java:427)
	at com.wipro.practice.Assignment32.main(Assignment32.java:41)
Caught NullPointerException
java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
	at com.wipro.practice.Assignment32.main(Assignment32.java:50)
Caught ArithmeticException
java.lang.ArithmeticException: / by zero
	at com.wipro.practice.Assignment32.main(Assignment32.java:58)
Program finished!

 */
 