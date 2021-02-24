package com.company;

import java.net.InetAddress;

public class Main {

    public static void main(String[] args) throws Exception{

        InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");
        for(InetAddress remote:inetAddresses){
            System.out.println(remote);
        }
	// write your code here
    }
}
