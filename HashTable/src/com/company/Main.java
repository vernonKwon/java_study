package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("spring", "12");
        map.put("summer", "123");
        map.put("fall", "1234");
        map.put("winter", "12345");

        Scanner scanner = new Scanner(System.in);

        String id, password;

        while (true) {
            System.out.println("아이디와 비밀번호를 입력해주세요.");
            System.out.println("아이디 : ");

            id = scanner.nextLine();

            System.out.println("비밀번호 : ");
            password = scanner.nextLine();
            System.out.println();

            if (map.containsKey(id)) {
                if (map.get(id).equals(password)) {
                    System.out.println("로그인 됐습니다");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                }
            } else {
                System.out.println("입력하신 아이디가 존재하지 않습니다");
            }
        }
    }
}
