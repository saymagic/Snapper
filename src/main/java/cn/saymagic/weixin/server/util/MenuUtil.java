package cn.saymagic.weixin.server.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import cn.saymagic.weixin.server.Auth;

public class MenuUtil {
	
	private static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	
	private static final String SEARCH_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	
	public static String createMenu(JSONObject menuObject) throws IOException, JSONException{
		return createMenu(menuObject).toString();
	}

	public static String createMenu(String menuString) throws IOException, JSONException{
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		String result = HttpUtil.post(CREATE_MENU_URL+Auth.getAccessToken(), menuString, headers);
		return result;
	}
	
	public static String getMenuJson() throws IOException, JSONException{
		return HttpUtil.get(SEARCH_MENU_URL+Auth.getAccessToken());
	}
	
	public static String deleteMenu() throws IOException, JSONException{
		return HttpUtil.get(DELETE_MENU_URL+Auth.getAccessToken());
	}
	
}
