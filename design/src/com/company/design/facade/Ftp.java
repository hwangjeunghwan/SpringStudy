package com.company.design.facade;

public class Ftp {

    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path){
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect(){
        System.out.println("FTP host : "+host+" Port : "+port);
    }
    public void moveDirectory(){
        System.out.println("FTP path : "+path+" 로 이동합니다.");
    }
    public void discConnect(){
        System.out.println("FTP 연결을 종료 합니다");
    }
}
