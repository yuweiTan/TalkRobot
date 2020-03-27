package com.cyw.TalkRobot;

import com.alibaba.fastjson.JSONObject;
import com.cyw.TalkRobot.Enums.ActionEnum;
import com.cyw.TalkRobot.entity.PO.response.ActionListPO;
import com.cyw.TalkRobot.entity.PO.response.ResponseListPO;
import com.cyw.TalkRobot.entity.PO.response.ResponsePO;
import com.cyw.TalkRobot.entity.PO.skill.*;
import com.cyw.TalkRobot.util.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TalkRobotApplicationTests {

	/**
	 * 重要提示代码中所需工具类
	 * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	 * 下载
	 */
	private static String version = "2.0";//版本
	private static String service_id = "S19144";//机器人id
	private static String bot_id="60517";//技能ID
	private static String user_id="88888";//技能对话的用户id
	private static String type="TEXT";//请求信息类型
	private static String source="KEYBOARD";//请求信息来源
	private static String query="你好";//用户说的话
	private static int bernard_level=1;//系统自动发现不置信意图/词槽，并据此主动发起澄清确认的频率。取值范围：0(关闭)、1(低频)、2(高频)。
	private static String log_id="7758521";//日志唯一ID
	private static String session_id = "";
	private static String accessToken = "24.6c3b2159e53cbdafa08317efc55a8f59.2592000.1586688207.282335-16489391";

	private static String utterance() {
		// 请求URL
		String talkUrl = "https://aip.baidubce.com/rpc/2.0/unit/bot/chat";
		try {
			// 请求参数
			RequestPO requestPO = new RequestPO(user_id, query, new QueryInfoPO(type), bernard_level, new HyperParamsPO());
			ParamsPO paramsPO = new ParamsPO(version,bot_id,log_id,requestPO,new BotSessionPO(session_id).toJsonString());
			String params = JSONObject.toJSONString(paramsPO);
            /*params = "{" +
                    "\"bot_session\":\"\"," +
                    "\"log_id\":\"7758521\"," +
                    "\"request\":{" +
                    "\"bernard_level\":1," +
                    "\"client_session\":\"{" +
                    "\\\"client_results\\\":\\\"\\\", " +
                    "\\\"candidate_options\\\":[]}\"," +
                    "\"query\":\"你好\"," +
                    "\"query_info\":{" +
                    "\"asr_candidates\":[]," +
                    "\"source\":\"KEYBOARD\"," +
                    "\"type\":\"TEXT\"}," +
                    "\"updates\":\"\"," +
                    "\"user_id\":\"88888\"}," +
                    "\"bot_id\":\"60517\"," +
                    "\"version\":\"2.0\"}";*/
			System.out.println(params);
			String result = HttpUtil.post(talkUrl, accessToken, "application/json", params);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String robot() {
		// 请求URL
		String talkUrl = "https://aip.baidubce.com/rpc/2.0/unit/service/chat";
		try {
			// 请求参数
			Robot robot = new Robot();
			com.cyw.TalkRobot.entity.PO.robot.RequestPO requestPO = new com.cyw.TalkRobot.entity.PO.robot.RequestPO(user_id, query);
			com.cyw.TalkRobot.entity.PO.robot.ParamsPO paramsPO = new com.cyw.TalkRobot.entity.PO.robot.ParamsPO(version, service_id, log_id, session_id, requestPO);
//            String params = "{\"log_id\":\"UNITTEST_10000\",\"version\":\"2.0\",\"session_id\":\"\",\"skill_ids\":[\"60516\",\"60517\",\"60518\",\"60519\"],\"request\":{\"query\":\"杭州天气\",\"user_id\":\"88888\"}}";
			String params = JSONObject.toJSONString(paramsPO);
			String result = HttpUtil.post(talkUrl, accessToken, "application/json", params);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Test
	public void contextLoads() {


//        String auth = getAuth();
//        System.out.println(auth);
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String next = scanner.next();
			query = next;
//            String utterance = utterance();
			String utterance = robot();
			ResponsePO responsePO = JSONObject.parseObject(utterance, ResponsePO.class);
			java.util.List<ResponseListPO> response_list = responsePO.getResult().getResponse_list();
			for (ResponseListPO responseListPO : response_list) {
				java.util.List<ActionListPO> action_list = responseListPO.getAction_list();
				for (ActionListPO actionListPO : action_list) {
					if (!actionListPO.getType().equals(ActionEnum.failure.getKey()))
						System.out.println(actionListPO.getSay());
				}
			}
			System.out.println(utterance);
			if ("再见".equals(next))
				return;
		}
	}

	/**
	 * 获取权限token
	 * @return 返回示例：
	 * {
	 * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
	 * "expires_in": 2592000
	 * }
	 */
	public static String getAuth() {
		// 官网获取的 API Key 更新为你注册的
		String clientId = "G3pyH3oAKMvGlUrZdtYItzVs";
		// 官网获取的 Secret Key 更新为你注册的
		String clientSecret = "orjSxe4AdPoOTP40zmgKUkDDtH34cBSu";
		return getAuth(clientId, clientSecret);
	}

	/**
	 * 获取API访问token
	 * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
	 * @param ak - 百度云官网获取的 API Key
	 * @param sk - 百度云官网获取的 Securet Key
	 * @return assess_token 示例：
	 * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
	 */
	public static String getAuth(String ak, String sk) {
		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
				// 1. grant_type为固定参数
				+ "grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + ak
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + sk;
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.err.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			/**
			 * 返回结果示例
			 */
			System.err.println("result:" + result);
			JSONObject jsonObject = new JSONObject(Boolean.parseBoolean(result));
			String access_token = jsonObject.getString("access_token");
			return access_token;
		} catch (Exception e) {
			System.err.printf("获取token失败！");
			e.printStackTrace(System.err);
		}
		return null;
	}



}
