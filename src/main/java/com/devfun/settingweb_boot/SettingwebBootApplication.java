package com.devfun.settingweb_boot;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devfun.settingweb_boot.API.HolidayInfoAPI;

@SpringBootApplication
public class SettingwebBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SettingwebBootApplication.class, args);
		
//		HolidayInfoAPI holiyday = new HolidayInfoAPI();
//		try {
//			Map<String, Object> result = holiyday.hoilday("2022", "09");
//			Iterator<String> iter = result.keySet().iterator();
//			while(iter.hasNext()) {
//				String key = iter.next();
//				Object o = result.get(key);
//				System.out.println(key+ " : " + o);
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
