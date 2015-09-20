package cn.saymagic.weixin.server.handler;


import cn.saymagic.weixin.server.bean.MsgRequest;
import cn.saymagic.weixin.server.Config;

public class EventHandler extends BaseHandler {
	@Override
	public String doHandleMsg(MsgRequest msgRequest) {
		if(!"event".equals(msgRequest.getMsgType()))
			return null;
		else
			if("subscribe".equals(msgRequest.getEvent())){
				return getResponseStringByContent(Config.getWelcome(), msgRequest);
			}else if("CLICK".equals(msgRequest.getEvent())){
				String eventKey = msgRequest.getEventKey();
				String content = "";
				content = "Click Menu"+msgRequest.getEventKey();
				return getResponseStringByContent(content, msgRequest);
			}
			else{ 
				return getResponseStringByContent("暂时无法处您的请求，请稍后再试。", msgRequest);
			}

	}
}
