package cn.saymagic.weixin.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import cn.saymagic.weixin.server.Config;
import cn.saymagic.weixin.server.bean.TulingResult;

import com.google.gson.Gson;

public class TulingUtil {

	public static String getResponse(String request,String userid) throws IOException{
		String INFO = URLEncoder.encode(request, "utf-8"); 
		String USER_ID = URLEncoder.encode(userid, "utf-8"); 
		String getURL = "http://www.tuling123.com/openapi/api?key=" + Config.getAPIKey() + "&info=" + INFO + "&userid=" + USER_ID; 
		return HttpUtil.get(getURL);
	}

	public static String getContentStr(String request,String userid) throws IOException{
		Gson gson = new Gson();
		TulingResult result = gson.fromJson(getResponse(request,userid), TulingResult.class);  
		return result.getText();
	}

}
