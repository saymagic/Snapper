package cn.saymagic.weixin.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import cn.saymagic.weixin.server.util.MsicUtil;

public class GetWeixinIP extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			resp.getWriter().write(MsicUtil.getWeixinIpString());
		} catch (JSONException e) {
			resp.getWriter().write("JSONException: " + e.toString());
		};
	}
	
}
