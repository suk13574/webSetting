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
}
