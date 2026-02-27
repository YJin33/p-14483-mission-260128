package com;
//다항식 계산기 구현
//
//테스트케이스를 하나씩 도입해서 전부 만족하도록 구현
//
//스택 자료구조 사용금지
//
//재귀방식으로 구현
//
//t1 부터 순서대로 클리어 해주세요.
public class Calc {
    //
    public static int run(String s){
        //Step01. 부호와 숫자 구분
        //Step02. +, - 먼저
        //Step03. *, / 단일
        //Step04. 여러개 계산
        //Step04. 섞인 부호 순서

        String[] NumberAndPlus = s.split(" "); //공백을 기준으로 분할

        //일단 ideal 만
        for(int i=1;i<NumberAndPlus.length;i++){
            String now = NumberAndPlus[i];
            int a = Integer.parseInt(NumberAndPlus[i-1]);
            int b = Integer.parseInt(NumberAndPlus[i+1]);

            switch (now){
                case "*":
                    return CalcService.multiply(a,b);
                case "/":
                    return CalcService.divide(a,b);
                case "+":
                    //+ 이전의 결과와 이후의 결과를 합친다
                    return CalcService.add(a,b);
                case "-":
                    return CalcService.subtract(a,b);
                default: //숫자인 경우 패스
                    break;
            }

        }
        return 2;
    }
}
