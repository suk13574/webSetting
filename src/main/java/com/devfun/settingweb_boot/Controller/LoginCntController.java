package com.devfun.settingweb_boot.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devfun.settingweb_boot.service.StatisticService;

@Controller
public class LoginCntController {

	@Autowired
	private StatisticService service;
	
	// 월별 로그인 수
	@ResponseBody
	@RequestMapping("/login/months")
	public Map<String, Object> monthLogin(String month) throws Exception{
		return service.monthLoginUser(month);
	}
	
	//일별 로그인 수
	@ResponseBody
	@RequestMapping("login/days")
	public Map<String, Object> dayLogin(String day) throws Exception{
		return service.dayLoginUser(day);
	}
	
	//부서별 월별 로그인 수
	@ResponseBody
	@RequestMapping("login/months/departments")
	public Map<String, Object> monthDepartmentLogin(String department) throws Exception{
		return service.monthDepartmentLoginUser(department);
	}
	
	//평균 하루 로그인 수
	@ResponseBody
	@RequestMapping("login/avg")
	public Map<String, Object> avgDayLoginCnt(String yearMonth) throws Exception{
		return service.avgDayLoginCnt(yearMonth);
	}
}
