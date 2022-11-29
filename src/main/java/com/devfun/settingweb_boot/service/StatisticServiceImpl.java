package com.devfun.settingweb_boot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfun.settingweb_boot.dao.StatisticList;
import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.dto.LoginUser;

@Service
public class StatisticServiceImpl implements StatisticService{

	@Autowired
	private StatisticMapper uMapper;
	@Autowired
	private StatisticList uList;
	
	@Override
	public HashMap<String, Object> yearloginNum(String year) {
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = uMapper.selectYearLogin(year);
			retVal.put("year", year);
			retVal.put("is_success", true);
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", year);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	@Override
	public HashMap<String, Object> monthLoginUser(String month) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		try {
			List<LoginUser> loginUser = uList.selectMonth(month);
			retVal.put("totCnt", loginUser.size());
			retVal.put("month", month);
			retVal.put("is_success", true);
			retVal.put("list", loginUser);
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("month", month);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	@Override
	public HashMap<String, Object> dayLoginUser(String day) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		try {
			List<LoginUser> loginUser = uList.selectDay(day);
			retVal.put("totCnt", loginUser.size());
			retVal.put("day", day);
			retVal.put("is_success", true);
			retVal.put("list", loginUser);
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("day", day);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}


}
