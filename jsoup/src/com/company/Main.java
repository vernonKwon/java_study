package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args)  {
        int cnt=0;
        try {
            Document document = Jsoup.connect("http://www.naver.com").get();
            Elements title = document.select(".ah_item");
            for(Element obj :title){
                String str = obj.text();
                System.out.println(str);
                //Thread.sleep(500);
                cnt++;
                if(cnt==20){
                    break;
                }


            }
            System.out.println(cnt);
        } catch (Exception e) {
            System.out.println("error");
        }

        System.out.println("-------------------");
        cnt=0;

        try {
            Document document = Jsoup.connect("https://www.daum.net").get();
            Elements title = document.select(".txt_issue");
            for(Element obj :title){
                String str = obj.text();
                cnt+=1;
                if(cnt%2!=0){
                    System.out.println(str);
                }

                //Thread.sleep(500);

                if(cnt==20){
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println("error");
        }


    }
}
