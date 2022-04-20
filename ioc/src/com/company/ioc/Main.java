package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        IEncoder encoder = new Encoder(new Base64Encoder()); //원하는 객체 주입 di
        String result = encoder.encode(url);

        IEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);

	    System.out.println(result);
    }
}
