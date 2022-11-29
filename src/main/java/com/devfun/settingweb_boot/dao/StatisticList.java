package com.devfun.settingweb_boot.dao;

import java.util.List;

import com.devfun.settingweb_boot.dto.LoginUser;

public interface StatisticList {
	public List<LoginUser> selectMonth(String month);
	
	public List<LoginUser> selectDay(String day);
}
