package com.elles.leetcode;


import org.testng.annotations.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: 'hello'
 * Output: 'holle'
 * Example 2:
 *
 * Input: 'leetcode'
 * Output: 'leotcede'
 * Note:
 * The vowels does not include the letter 'y'.
 *
 *
 */
public class L345 {


    @Test
    public void testOk(){
        String s="hello";

        System.out.println( reverseVowels(s));
    }

    public String reverseVowels(String s) {
        if(s== null){
            return s;
        }
        List<Character> vowelsLst=Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'});
        char[] charArr=new char[s.length()];

        int i=0;
        int j=s.length()-1;
        while(i<=j){
            char leftChar=s.charAt(i);
            char rightChar=s.charAt(j);
            if(!vowelsLst.contains(leftChar)){
                charArr[i]=leftChar;
                i++;

            }else if(!vowelsLst.contains(rightChar)){
                charArr[j]=rightChar;
                j--;
            }else{
                charArr[i]=rightChar;
                charArr[j]=leftChar;
                i++;
                j--;
            }
        }
        return new String(charArr);

    }

    @Test
    public  void case0(){
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        ParsePosition parsePosition=new ParsePosition(0);
//        Date d=sdf.parse("2020-02-29 01:00:00",parsePosition);
//        System.out.println(d.toString());


//        System.out.println( Pattern.matches("^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))\\\\s(0\\\\d{1}|1\\\\d{1}|2[0-3]):[0-5]\\\\d{1}:([0-5]\\\\d{1})$","2016-11-07 11:51:24"));

        System.out.println("2016-11-07 11:51:24".matches("^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))\\\\\\\\s(0\\\\\\\\d{1}|1\\\\\\\\d{1}|2[0-3]):[0-5]\\\\\\\\d{1}:([0-5]\\\\\\\\d{1})$"));

    }
}
