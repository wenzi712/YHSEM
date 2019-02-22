package com.cjl.controller.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.cjl.pojo.weather.Weather;
import com.cjl.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;


public class WeatherController implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		String url="https://free-api.heweather.com/s6/weather/now?key=87333fbdd1ea42fc90e1774ac97e4995&location=beijing&lang=zh";
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		String weather = json.toString();
		
		
		JsonNode jsonToJsonNode = JsonUtil.jsonToJsonNode(weather);
		String newNode = jsonToJsonNode.get("HeWeather6").toString();
		String str = newNode.substring(1, newNode.length()-1);
		JsonNode jsonToJsonNode1 = JsonUtil.jsonToJsonNode(str);
		JsonNode basic = jsonToJsonNode1.get("basic");
		JsonNode update = jsonToJsonNode1.get("update");
		JsonNode nows = jsonToJsonNode1.get("now");

		Weather wt = new Weather();
			String location = basic.get("location").toString();
			
			 wt.setLocation(location.substring(1, location.length()-1));
			 String loc = update.get("loc").toString();
			 wt.setDate(loc.substring(1, loc.length()-1));
			 String tmp = nows.get("tmp").toString();
			 wt.setTmp(tmp.substring(1, tmp.length()-1));
			 String txt = nows.get("cond_txt").toString();
			 wt.setTxt(txt.substring(1, txt.length()-1));
			 String dir = nows.get("wind_dir").toString();
			 wt.setDir(dir.substring(1, dir.length()-1));
			 String sc = nows.get("wind_sc").toString();
			 wt.setSc(sc.substring(1, sc.length()-1));
			 String spd = nows.get("wind_spd").toString();
			 wt.setSpd(spd.substring(1, spd.length()-1));
			 String hum = nows.get("hum").toString();
			 wt.setHum(hum.substring(1, hum.length()-1));
			 String cloud = nows.get("cloud").toString();
			 wt.setCloud(cloud.substring(1, cloud.length()-1));
		
			 
	}

}
