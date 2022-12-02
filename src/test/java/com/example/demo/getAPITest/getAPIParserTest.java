package com.example.demo.getAPITest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;

import com.devfun.settingweb_boot.SettingwebBootApplication;
import com.devfun.settingweb_boot.API.HolidayInfoAPI;

public class getAPIParserTest {
	
	public static void main(String[] args) {		
		HolidayInfoAPI holiyday = new HolidayInfoAPI();
		try {
			HashSet<String> result = holiyday.hoilday("2022", "09");
			Iterator<String> iter = result.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
