package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {


    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int lastday = cal.getMaximum(Calendar.DAY_OF_MONTH);

        String[] day; // 날짜
        String[] meal; // 식단 저장

        int cntday = 0;
        int today;

        int cnt = 0;


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M월 d");

        Document doc = null;

        try {
            doc = Jsoup.connect("http://www.gmma.hs.kr/wah/main/schoolmeal/calendar.htm?menuCode=102").get();
            Elements elements = doc.select(".Contents_schoolmeal_Date");
            Elements elements1 = doc.select(".Contents_schoolmeal_ToDay");

            System.out.println("--------오늘---------");
            for (Element element : elements1) {
                today = Integer.parseInt(element.text().substring(0, 2).trim());

                System.out.println("오늘 " + today); // 오늘 날짜, 완료

            }

            for (Element element : elements1) {
                System.out.println(element.text().substring(2).trim());
            } // 오늘 메뉴

            System.out.println("----------원본---------");

            for (Element el : elements) { // 원본
                System.out.println(el.text());
                cntday++;
            }
        } catch (Exception e) {
        }

        day = new String[cntday];
        try {
            doc = Jsoup.connect("http://www.gmma.hs.kr/wah/main/schoolmeal/calendar.htm?menuCode=102").get();
            Elements elements = doc.select(".Contents_schoolmeal_Date");

            System.out.println("---------숫자----------");
            for (Element el : elements) { // 숫자
                day[cnt] = el.text().substring(0, 2).trim();

                System.out.println(day[cnt]);
                cnt++;
                //System.out.println(el.text().substring(0, 2).trim());
            }
        } catch (Exception e) {
            cnt = 0;
            //e.printStackTrace();
            System.out.println("숫자오류");
        }

        meal = new String[cntday];


        try {
            doc = Jsoup.connect("http://www.gmma.hs.kr/wah/main/schoolmeal/calendar.htm?menuCode=102").get();
            Elements elements = doc.select(".Contents_schoolmeal_Date");
            Elements elements1 = doc.select(".Contents_schoolmeal_ToDay");

            System.out.println("----------메뉴---------");
            for (Element el : elements) { // 메뉴
                //meal[cnt] = el.text().substring(2).trim();
                cnt++;
                System.out.println(el.text().substring(3).trim());
            }

        } catch (Exception e) {
            cnt = 0;
            e.printStackTrace();
            System.out.println("메뉴오류");
        }

        System.out.println("---------합체---------");
        for (int i = 0; meal.length > i; i++) {
            if (day[i] == null || meal[i] == null) {
                break;
            }
            System.out.println(day[i] + " " + meal[i]);


        }


        //setmeal(lastday, meal, day, today);

    }


    private static void setmeal(int lastday, String[] meal, String[] day, int today) {

        String[] everymeal = new String[lastday];
        String[] everyday = new String[lastday];


        for (int i = 0; i < lastday; i++) {

        }
        System.out.println("---------메소드--------");


    }

}
