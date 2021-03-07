package com.gao.mytomcat.config;

/**
 * @author 高磊
 * @date 2020/10/03
 */
public class ServletEntity {
    private String servletName;
    private String url;
    private String clazzName;
    public ServletEntity(String servletName,String url,String clazzName){
        this.servletName = servletName;
        this.url = url;
        this.clazzName = clazzName;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
}
