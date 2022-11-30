package com.devfun.settingweb_boot.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfun.settingweb_boot.dao.StatisticList;
import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.dto.LoginUser;
import com.devfun.settingweb_boot.dto.MonthCnt;

@Service
public class StatisticServiceImpl implements StatisticService{

	@Autowired
	private StatisticMapper uMapper;
	@Autowired
	private StatisticList uList;
	@Autowired
	private SqlSessionTemplate session;
	
	
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
	

	//부서별 월별 로그인 수
	@Override
	public HashMap<String, Object> monthDepartmentLoginUser(String department) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		try {
			List<MonthCnt> monthCnt = uList.selectMonthDepartment(department);
			retVal.put("department", department);
			retVal.put("is_success", true);
			retVal.put("list", monthCnt);
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("department", department);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	//평균 하루 로그인 수
	@Override
	public HashMap<String, Object> avgDayLoginCnt(String yearMonth) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		try {
			int cnt = session.selectOne("selectTotalMonth", yearMonth);
			double avgCnt;
			System.out.println(cnt);
			String month = yearMonth.substring(2, yearMonth.length());
			switch (month) {
			case "02": avgCnt = (double) cnt / 28; break;
			case "04": case "06": case "09": case "11": avgCnt = (double) cnt / 30; break;
			default: avgCnt = (double) cnt / 31;
			}
			avgCnt = Math.round(avgCnt * 100) / 100.0;
			retVal.put("avgCnt", avgCnt);
			retVal.put("yearMonth", yearMonth);
			retVal.put("is_success", true);

		} catch (Exception e) {
			retVal.put("avgCnt", -999);
			retVal.put("is_success", false);
		}
		
		return retVal;
	}

	
	

}
