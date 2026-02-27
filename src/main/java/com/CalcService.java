package com;

import java.util.List;

public class CalcService {
    public static int getClosed(List<String>NumberSign) {
        int idx = 0;
        int startIdx = 0;
        int result;
        while (NumberSign.contains("(")) {
            String now = NumberSign.get(idx);
            switch (now) {
                case "(":
                    startIdx = idx;
                    idx++;
                    break;
                case ")":
                    NumberSign.remove(idx);
                    result = getResult(NumberSign.subList(startIdx+1, idx)); //괄호 제외하고 주기
                    NumberSign.remove(startIdx);
                    idx=0;
                    startIdx=0;
                    break;
                default:
                    idx++;
                    break;
            }
        }
        return getResult(NumberSign);
    }

    //재귀 사용 위해 분리
    public static int getResult(List<String>NumberAndSign){
        //1개인 경우 : 정답 리턴
        if(NumberAndSign.size()==1){
            try{
                return Integer.parseInt(NumberAndSign.get(0));
            } catch (Exception e) {
                throw e;
            }
        }

        // * / 가 있는 경우 우선적으로 처리
        int idx=1;
        while(NumberAndSign.contains("*")||NumberAndSign.contains("/")){
            String now = NumberAndSign.get(idx);
            int result,a,b;
            try{
                a = Integer.parseInt(NumberAndSign.get(idx-1));
                b = Integer.parseInt(NumberAndSign.get(idx+1));
            }catch (Exception e){
                idx++;
                continue;
            }
            switch (now){
                case "*":
                    result = multiply(a,b); //붙어 있는 애들 계산
                    updateList(NumberAndSign, idx-1, idx+1, result); //계산한 값을 다시 위치에 넣어서 재귀
                    break;
                case "/":
                    result = divide(a,b);
                    updateList(NumberAndSign, idx-1, idx+1, result);
                    break;
                default: //숫자인 경우 패스
                    idx++;
                    break;
            }
        }

        idx=1;
        while(NumberAndSign.contains("+")||NumberAndSign.contains("-")){
            String now = NumberAndSign.get(idx);
            int a = Integer.parseInt(NumberAndSign.get(idx-1));
            int b = Integer.parseInt(NumberAndSign.get(idx+1));
            int result;
            switch (now){
                case "+":
                    result = add(a,b);
                    updateList(NumberAndSign, idx-1, idx+1, result);
                    break;
                case "-":
                    result = subtract(a,b);
                    updateList(NumberAndSign, idx-1, idx+1, result);
                    break;
                default: //숫자인 경우 패스
                    idx++;
                    break;
            }
        }
        try{
            return Integer.parseInt(NumberAndSign.get(0));
        } catch (Exception e) {
            throw e;
        }
    }

    public static void updateList(List<String> NumberAndSign, int startIdx, int endIdx, int result){
        String calculated = String.valueOf(result);

        //사용한 숫자 제외하고 그 위치에 계산한 값 넣기
        NumberAndSign.set(startIdx,calculated);
        for(int i=endIdx; i>startIdx; i--){
            NumberAndSign.remove(i); //ArrayList이므로 뒤에서부터 지우기
        }
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
