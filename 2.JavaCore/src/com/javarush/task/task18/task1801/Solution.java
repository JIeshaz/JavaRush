package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(R.readLine());
        int data = 0, s;
        while(input.available() > 0)
            if ((s = input.read()) > data) data = s;
            R.close();
            input.close();
        System.out.println(data);
    }
}
