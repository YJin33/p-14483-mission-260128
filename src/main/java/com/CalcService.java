package com;

import java.util.List;

public class CalcService {

    //재귀 사용 위해 분리
    public static int getResult(List<String>NumberAndSign){
        if(NumberAndSign.size()==1){
            try{
                return Integer.parseInt(NumberAndSign.get(0));
            } catch (Exception e) {
                return -1;
            }
        }
        for(int i=1;i<NumberAndSign.size();i++){
            String now = NumberAndSign.get(i);
            int a = Integer.parseInt(NumberAndSign.get(i-1));
            int b = Integer.parseInt(NumberAndSign.get(i+1));
            int result;
            switch (now){
                case "*":
                    result = multiply(a,b); //붙어 있는 애들 계산
                    return getResult(updateList(NumberAndSign, i, result)); //계산한 값을 다시 위치에 넣어서 재귀
                case "/":
                    result = divide(a,b);
                    return getResult(updateList(NumberAndSign, i, result));
                case "+":
                    result = add(a,b);
                    return getResult(updateList(NumberAndSign, i, result));
                case "-":
                    result = subtract(a,b);
                    return getResult(updateList(NumberAndSign, i, result));
                default: //숫자인 경우 패스
                    break;
            }
        }
        return 1;
    }
    private static List<String> updateList(List<String> NumberAndSign, int idx, int result){
        String calculated = String.valueOf(result);

        //사용한 숫자 제외하고 그 위치에 계산한 값 넣기
        NumberAndSign.remove(idx+1);
        NumberAndSign.set(idx,calculated);
        NumberAndSign.remove(idx-1);

        return NumberAndSign;
    }

    private static int add(int a, int b){
        return a+b;
    }

    private static int subtract(int a, int b) {
        return a-b;
    }

    private static int multiply(int a, int b) {
        return a*b;
    }

    private static int divide(int a, int b) {
        return a/b;
    }
}
