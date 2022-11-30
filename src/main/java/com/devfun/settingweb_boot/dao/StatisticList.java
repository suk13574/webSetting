package com.devfun.settingweb_boot.dao;

import java.util.List;

import com.devfun.settingweb_boot.dto.LoginUser;
import com.devfun.settingweb_boot.dto.MonthCnt;

public interface StatisticList {
	public List<LoginUser> selectMonth(String month);
	
	public List<LoginUser> selectDay(String day);
	
	public List<MonthCnt> selectMonthDepartment(String department);
}
