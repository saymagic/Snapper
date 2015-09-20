# wx_maven

基于maven的微信公众后台源码,它是一个标准的maven项目，里面是微信公众号后台的主要源码。源码的目录结构如下：

![](http://cdn.saymagic.cn/o_19uc63k641h0t1b7j1u2t16vn674e.png)

`WxApiServlet`是处理请求的实现类，它会将微信服务器发来的Post请求封装成 `MsgRequest`对象，然后根据`MsgRequest`类型的不同(语音、文字、图片)来生成不同类型的handler，这里我只做了Event与Text类型的处理类，添加其它类型的处理需要继承`BaseHandler`，实现里面的`doHandleMsg`方法。这里需要注意两点，第一点是我将普通的文字与语音请求通过图灵机器人进行回复，因此你需要去[图灵机器人](http://www.tuling123.com/openapi/record.do?channel=14791)申请apikey：

![](http://cdn.saymagic.cn/o_19uc6geo1pgco0n1tj22no467o.png)

wx_maven可以通过配置不同的变量来达到每个公众号不同的需求，目前可以配置的变量都在`Config.java`中，包括：

* NAME: 微信公众号的名称

* TOKEN： 微信公众号的token，用于验证之用，这个字段的值需要和微信公众平台后台里设置的token相等。

* APIKEY： 前文所说的图灵机器人的APPKEY，可在图灵官方申请

* WELCOME： 用户关注时发出的欢迎语

* APPID： 微信公众号后台APPID

* APPSECRET： 微信公众号后台APPSECRET

你可以通过直接修改`Config.java` ，但你可以通过在系统变量中配置这个个变量，程序会优先读取系统变量中是否存在这个值，没有的话才会读取`Config.java`中得字段，这主要是为了Docker环境或者类似[Coding](http://coding.net)这类的云平台。

目前没有完工，还在不断完善、进化中。

# Dokcer镜像

如果你习惯Docker环境，欢迎在此查看这个镜像：[https://hub.alauda.cn/repos/saymagic/wx_server](https://hub.alauda.cn/repos/saymagic/wx_server)
