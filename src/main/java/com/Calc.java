package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<String> NumberAndSign = new ArrayList<>(Arrays.asList(s.split(" "))); //공백을 기준으로 분할
        return CalcService.getResult(NumberAndSign);
    }
}
