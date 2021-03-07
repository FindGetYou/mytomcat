# mytomcat

## 描述

自己实现一个简单的tomcat

* application

主程序，启动mytomcat

* common

自己实现request和response，分别使用InputStream和OutputStream接受端口请求的数据内容和发送数据

* config

servlet映射表，记录当前服务器上的各个服务信息(服务名，url，服务类的全限定名)

* servlet

定义servlet抽象类，实现doGet和doPost方法



## 问题

运行mytomcat，在浏览器地址栏直接输入http://localhost:8080/helloworld来发送请求，在使用InputStream读取请求内容时，可以发现请求内容

```http
GET /helloworld HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
sec-ch-ua: "Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99"
Accept: */*
sec-ch-ua-mobile: ?0
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36
Origin: null
Sec-Fetch-Site: cross-site
Sec-Fetch-Mode: cors
Sec-Fetch-Dest: empty
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,en-CN;q=0.8,en;q=0.7
```

第一行有我们想要的基本信息（请求类型method，请求路径url），根据这些信息我们就可以调用对应的服务类来处理请求，不过在使用Chrome浏览器的时候，浏览器会默认请求一次`../favicon.png`，这时候我们的servletMapping中没有对应的服务，就会报错，这时候要在dispatch中做过滤，处理掉没有的服务请求

如果使用jQuery.ajax()来发送请求，就会报`CORS error`的错误，是因为我们没有实现CORS接口，无法跨源通信

不过对于简单的功能来说，mytomcat已经实现



