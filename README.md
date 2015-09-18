# wx_maven

基于maven的微信公众后台源码,它是一个标准的maven项目，里面是微信公众号后台的主要源码。源码的目录结构如下：

![](http://cdn.saymagic.cn/o_19uc63k641h0t1b7j1u2t16vn674e.png)

`WxApiServlet`是处理请求的实现类，它会将微信服务器发来的Post请求封装成 `MsgRequest`对象，然后根据`MsgRequest`类型的不同(语音、文字、图片)来生成不同类型的handler，这里我只做了Event与Text类型的处理类，添加其它类型的处理需要继承`BaseHandler`，实现里面的`doHandleMsg`方法。这里需要注意两点，第一点是我将普通的文字与语音请求通过图灵机器人进行回复，因此你需要去[图灵机器人](http://www.tuling123.com/openapi/record.do?channel=14791)申请apikey：

![](http://cdn.saymagic.cn/o_19uc6geo1pgco0n1tj22no467o.png)

然后再Config.java中配置`APPKEY`属性。第二点是微信公众平台会对首次添加的后台地址做token验证，因此也需要在Config.java文件里配置`TOKEN`字段。这个字段的值需要和微信公众平台后台里设置的token相等。

目前没有完工，还在不断完善、进化中。

# Dokcer镜像

如果你习惯Docker环境，欢迎在此查看其镜像：[https://hub.alauda.cn/repos/saymagic/wx_server](https://hub.alauda.cn/repos/saymagic/wx_server)
