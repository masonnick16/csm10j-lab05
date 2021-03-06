/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author Nick
 */
public class Lab05 {
    
    /**
     * @param number1
     * @param number2
     * @return 
     */
    public static String addNums(String number1, String number2){
    char[] num1char = number1.toCharArray();
    char[] num2char = number2.toCharArray();
    if (num1char.length > num2char.length) {
        num2char = formatLength(num1char, num2char);
    } else if (num1char.length < num2char.length) {
        num1char = formatLength(num2char, num1char);
    }
    final char[] addition = new char[num1char.length + 1];
    char carry = '0';
    for (int i = num1char.length - 1; i >= 0; i--) {
        int sum = Character.getNumericValue(num1char[i]) + Character.getNumericValue(num2char[i]) + Character.getNumericValue(carry);
        char[] csum = String.valueOf(sum).toCharArray();
        carry = '0';
        if (csum.length > 1 && i == 0) {
            addition[i + 1] = csum[1];
            addition[0] = csum[0];
        } else if (csum.length > 1) {
            carry = csum[0];
            addition[i + 1] = csum[1];
        } else {
            addition[i + 1] = csum[0];
        }
    }
    return String.valueOf(addition);
}
    public static char[] formatLength(char[] num1char, char[] num2char) {
    int diff = num1char.length - num2char.length;
    char[] num = new char[num1char.length];
    for (int i = 0; i < diff; i++) {
        num[i] = '0';
    }
    for (int i = 0; i < num2char.length; i++) {
        num[diff + i] = num2char[i];
    }
    return num;
}
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the first number: ");
        String firstNum=in.next();
        System.out.println("Enter the second number: ");
        String secondNum=in.next();
        String finalNum=addNums(firstNum,secondNum);
        System.out.println("  "+firstNum);
        System.out.println("+ "+secondNum);
        System.out.print("= "+ finalNum);
    }
    
}
