package com.gao.mytomcat.servlet;

import com.gao.mytomcat.common.MyRequest;
import com.gao.mytomcat.common.MyResponse;

/**
 * @author 高磊
 * @date 2020/10/03
 */
public abstract class MyServlet {
    public abstract void doGet(MyRequest request, MyResponse response);
    public abstract void doPost(MyRequest request, MyResponse response);
    public void service(MyRequest request,MyResponse response){
        if(request.getMethod().equalsIgnoreCase("GET")){
            doGet(request,response);
        }else {
            doPost(request,response);
        }
    }
}
