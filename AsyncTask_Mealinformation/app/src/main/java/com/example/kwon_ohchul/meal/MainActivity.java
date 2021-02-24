package com.example.kwon_ohchul.meal;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "태그";
    List<String> meallist = new ArrayList<>();
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textview);


        setMeallist();



        /*try{
            textView.setText(meallist.get(12));
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }*/


    }

    private void setMeallist() {


        Calendar cal = Calendar.getInstance();

        int cnt = 1;
        int maximumday = cal.getMaximum(Calendar.DAY_OF_MONTH);

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Document document = Jsoup.connect("http://www.gmma.hs.kr/wah/main/schoolmeal/calendar.htm?menuCode=102").get(); // 학교 급식 사이트 파싱
            Elements meals = document.select(".Contents_schoolmeal_Date"); // 오늘을 제외한 모든 급식 메뉴를 크롤링
            Elements todaymeal = document.select(".Contents_schoolmeal_ToDay"); // 오늘의 급식 메뉴

            for (Element txt : meals) { // 메뉴들을 ArrayList에 넣음
                if (txt.text().length() > 0) { // stringindexoutofboundsexception 대비를 위함

                    while (cnt != Integer.parseInt(txt.text().substring(0, 2).trim())) { //항목이 없는 날에 대해서 '급식 정보 없음' 이라고 추가
                        if (cnt == Integer.parseInt(todaymeal.text().substring(0, 2).trim())) { // 오늘 급식 정보 추가
                            meallist.add(todaymeal.text());

                        } else {
                            meallist.add(cnt + "일의 급식 정보가 없습니다.");
                        }
                        cnt++;
                    }
                    if (cnt == Integer.parseInt(txt.text().substring(0, 2).trim())) {// 오늘 급식이 아닌 나머지 한달동안의 급식
                        meallist.add(txt.text());
                    }
                    cnt++;
                }
            }

            while (cnt <= maximumday) {
                meallist.add(cnt + "일의 급식정보가 없습니다.");
                cnt++;
            }

            Toast.makeText(getApplicationContext(), "완료", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "setMeallist: 완료");
            /*System.out.println("완료");
            for (String temp : meallist) {
                System.out.println(temp);
            }*/

            //System.out.println("오늘의 급식 : " + todaymeal.text().substring(2).trim()); // 오늘 급식, 정상 작동

        } catch (IOException e) {

            Toast.makeText(getApplicationContext(), "IOException", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
    }


}
