package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//초기화 되면 안되므로 반복문 밖에서 선언
        List<Integer> numbers = new ArrayList<>();
        //초기화 되면 안되므로 반복문 밖에서 선언
        int tries = 1;
        //0~9를 가진 리스트 선언
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        //list 섞어주기
        Collections.shuffle(numbers);
        //순서를 섞은 리스트 앞에서 3개 자르기
        List<Integer> selectedNum = numbers.subList(0, 3);
//        System.out.println(selectedNum); //테스트용

        Scanner sc = new Scanner(System.in);

        System.out.println("0~9의 숫자 중 3가지를 고르세요");

        while (true) {
            //반복문을 돌릴 때 마다 초기화를 시켜줘야 하니 반복문 안에서 선언.
            List<Integer> selectedByMe = new ArrayList<>();
            int strike = 0;
            int ball = 0;

            //스캐너를 이용해 3가지 숫자 입력
            for (int i = 0; i < 3; i++) {
                int num = sc.nextInt();
                selectedByMe.add(num);
            }
            //반복문3회 돌려서 각 인덱스마다 숫자 비교
            for (int j = 0; j < 3; j++) {
                if (selectedNum.get(j).equals(selectedByMe.get(j))) {
                    strike++;//맞출 시 스트라이크+1
                } else {
                    ball++;//틀릴 시 볼+1
                }
            }
            //스트라이크 3 도달 시 break
            if (strike == 3) {
                break;
            } else {
                System.out.println(strike+"S"+ball+"B");//실패 시 결과 알려준 후 시도횟수 +1
                tries++;
            }
        }
        System.out.println(tries + "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}
