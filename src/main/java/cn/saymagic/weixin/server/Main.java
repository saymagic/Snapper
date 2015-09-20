package cn.saymagic.weixin.server;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import cn.saymagic.weixin.server.util.MenuUtil;
import cn.saymagic.weixin.server.util.MsicUtil;

public class Main {

	public static void main(String[] args) throws JSONException, IOException {
		JSONObject object = new JSONObject("{\n" +
                "     \"button\":[\n" +
                "     {\t\n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"今日歌曲\",\n" +
                "          \"key\":\"V1001_TODAY_MUSIC\"\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"菜单\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"搜索\",\n" +
                "               \"url\":\"http://www.soso.com/\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"视频\",\n" +
                "               \"url\":\"http://v.qq.com/\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"click\",\n" +
                "               \"name\":\"赞一下我们\",\n" +
                "               \"key\":\"V1001_GOOD\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }");
		System.out.println(MsicUtil.getWeixinIpString());
	}

}
