package com.gao.mytomcat.application;

import com.gao.mytomcat.common.MyRequest;
import com.gao.mytomcat.common.MyResponse;
import com.gao.mytomcat.config.ServletEntity;
import com.gao.mytomcat.config.ServletMappingConfig;
import com.gao.mytomcat.servlet.MyServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {
    private int port = 8080;
    private Map<String,String> servletMap = new HashMap<>();
    public MyTomcat(){}
    public MyTomcat(int port){
        this.port = port;
    }
    public void initServletMap(){
        for(ServletEntity servlet : ServletMappingConfig.servletList){
            servletMap.put(servlet.getUrl(),servlet.getClazzName());
        }
    }
    public void start(){
        initServletMap();
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("mytomcat is running at port : ["+port+"]");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                while(true){
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    MyRequest myRequest = new MyRequest(inputStream);
                    MyResponse myResponse = new MyResponse(outputStream);
                    dispatch(myRequest,myResponse);
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(serverSocket != null){
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void dispatch(MyRequest myRequest,MyResponse myResponse){
        try{
            Class<MyServlet> servletClass = (Class<MyServlet>)Class.forName(servletMap.get(myRequest.getUrl()));
            MyServlet myServlet =servletClass.newInstance();
            myServlet.service(myRequest,myResponse);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat().start();
    }
}
