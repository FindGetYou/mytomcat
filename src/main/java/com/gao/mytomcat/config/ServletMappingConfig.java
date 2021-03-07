package com.gao.mytomcat.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 高磊
 * @date 2020/10/03
 */
public class ServletMappingConfig {
    public static List<ServletEntity> servletList = new ArrayList<>();
    static{
        servletList.add(new ServletEntity("helloworld","/helloworld","com.gao.mytomcat.servlet.HelloWorldServlet"));
        servletList.add(new ServletEntity("findPeople","/findPeople","com.gao.mytomcat.servlet.FindPeopleServlet"));
    }
}
