package com.gao.mytomcat.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 高磊
 * @date 2020/10/03
 */
public class MyRequest {
    private String url;
    private String method;
    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestByte = new byte[1024];
        Integer length = 0;
        if((length = inputStream.read(httpRequestByte)) > 0){
            httpRequest = new String(httpRequestByte,0,length);
            System.out.println("[test]\n"+httpRequest+"[test]\n");
            httpRequest = httpRequest.split("\n")[0];
        }
        System.out.println("[MyRequest] httpRequest => "+httpRequest);
//        String httpHead = httpRequest.split("\n")[2];
        url = httpRequest.split(" ")[1];
        method = httpRequest.split(" ")[0];
        System.out.println("[MyRequest] => "+this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
