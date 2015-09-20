package cn.saymagic.weixin.server.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import cn.saymagic.weixin.server.Auth;

public class MsicUtil {
	
	private static final String IP_URL= "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";

	public static String formatString(String string){
		try {
			return new String(string.getBytes("UTF-8"),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}
	
	public static boolean isEmpty(String string){
		if(null == string || string.equals("")){
			return true;
		}
		return false;
	}
	
	public static String getWeixinIpString() throws IOException, JSONException{
		return HttpUtil.get(IP_URL+Auth.getAccessToken());
	}
	
	public static List<String> getWeixinIpList() throws IOException, JSONException{
		String ip = getWeixinIpString();
		JSONObject obj = new JSONObject(ip);
		List<String> list = new ArrayList<String>();
		if(obj.has("ip_list")){
			JSONArray  arr = obj.getJSONArray("ip_list");
			for(int i = 0; i < arr.length(); i++){
				list.add(arr.getString(i));
			}
		}
		return list;
	}
}
