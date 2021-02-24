package com.company;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        /*String key = "this_is_my_string_key";       // key는 16자 이상
        AES256Util aes256 = new AES256Util(key);

        String text = "이것은 패스워드입니다.";
        //String text = "암호화되지 않은 문자입니다.";
        String encText = aes256.aesEncode(text);
        String decText = aes256.aesDecode(encText);

        System.out.println("암호화할 문자 : " + text);
        System.out.println("암호화된 문자 : " + encText);
        System.out.println("복호화된 문자 : " + decText);*/

        String password = "dsjfjfwijwffjsjafsd";
        String uid = "yistq4Pw20gfHW5Xl7799Uprw2D2";

        try {
            AES256Util aes256 = new AES256Util(uid);
            AES256Util aes256Util = new AES256Util(password);

            System.out.println("암호화 : " + aes256.aesEncode(password));
            System.out.println("암호화 2 : " + aes256Util.aesEncode(uid));
            System.out.println("복호화 : " + aes256.aesDecode(aes256.aesEncode(uid)));
            System.out.println("복호화 2 : " + aes256Util.aesDecode(aes256Util.aesEncode(password)));
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
