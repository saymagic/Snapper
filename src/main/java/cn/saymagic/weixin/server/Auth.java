package cn.saymagic.weixin.server;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import cn.saymagic.weixin.server.util.HttpUtil;
import cn.saymagic.weixin.server.util.MsicUtil;

public class Auth {
	
	public static String getAccessToken() throws IOException, JSONException{
		if(MsicUtil.isEmpty(Config.getAPPID()) || MsicUtil.isEmpty(Config.getAPPSecret())){
			throw new NullPointerException("APIKEY or APPSECRET is null");
		}
		String result = HttpUtil.get(String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", Config.getAPPID(), Config.getAPPSecret()));
		JSONObject obj = new JSONObject(result);
		return obj.getString("access_token");
	}
	
}
