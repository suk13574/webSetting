package com.devfun.settingweb_boot.service;


import java.util.HashMap;
import java.util.List;

import com.devfun.settingweb_boot.dto.LoginUser;

public interface StatisticService {
   public HashMap<String,Object> yearloginNum (String year);
   
   public HashMap<String,Object> monthLoginUser(String month);
   
   public HashMap<String,Object> dayLoginUser(String day);
   
   public HashMap<String,Object> monthDepartmentLoginUser(String department);

   public HashMap<String,Object> avgDayLoginCnt(String year);
}