package com.gao.mytomcat.servlet;

import com.gao.mytomcat.common.MyRequest;
import com.gao.mytomcat.common.MyResponse;

import java.io.IOException;

/**
 * @author 高磊
 * @date 2020/10/03
 */
public class FindPeopleServlet extends MyServlet{
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try{
            response.write("没有找到");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        doGet(request,response);
    }
}
