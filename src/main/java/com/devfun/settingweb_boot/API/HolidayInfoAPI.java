package com.devfun.settingweb_boot.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HolidayInfoAPI {
	private final static String secretKey = "guEoQjOWaOUqTQcc7b1JwPMhLu0OqEbiuZfNJ8u8N1K6xBX4iCdUlZzIVG6j1MDnXtVlo2f6xVdEXcfeqJx7bQ%3D%3D";

	public HashSet<String> hoilday(String year, String month) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo"); /* URL */

		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + secretKey); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("solYear", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8")); /* 연 */
		urlBuilder
				.append("&" + URLEncoder.encode("solMonth", "UTF-8") + "=" + URLEncoder.encode(month, "UTF-8")); /* 월 */
		urlBuilder.append(
				"&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* json으로 요청 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());

		// 정보 받아옴
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}

		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		//json 데이터 파서
		List<Map<String, Object>> list = dateList(sb.toString());
		//공휴일 날짜만 뽑아서 반환
		return dateSet(list);

	}

	// json 데이터 파서 후 공휴일 정보 리스트 반환
	private List<Map<String, Object>> dateList(String json) {
		JSONParser jsonParser = new JSONParser();
		JSONArray days = null;
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
			JSONObject response = (JSONObject) jsonObject.get("response");
			System.out.println(response);
			JSONObject body = (JSONObject) response.get("body");
			JSONObject items = (JSONObject) body.get("items");
			days = (JSONArray) items.get("item");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return days;
	}

	// 공휴일 정보 리스트 날짜 set으로 담음
	private HashSet<String> dateSet(List<Map<String, Object>> list) {
		HashSet<String> holiydaySet = new HashSet<>();
		for (Map<String, Object> holiydayInfo : list) {
			Object result = holiydayInfo.get("locdate");
			String date = result.toString();
			holiydaySet.add(date.substring(2));
		}
		return holiydaySet;
	}

}
