package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try{
            String s = "";
            while(!s.equals("exit")){
                s = br.readLine();
                Calc.run(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}