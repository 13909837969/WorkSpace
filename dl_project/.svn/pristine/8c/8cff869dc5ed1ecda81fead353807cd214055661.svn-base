package com.qfjy.meeting.web.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuild {
	public LinkedHashMap<String,String> build(){
		LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();
		//查询数据库resource表代码
		map.put("/pages/admin/login.jsp","anon");
		map.put("/loginUsers/login","anon");
		map.put("/h-ui/**","anon");
		map.put("/images/**","anon");
		map.put("/js/**","anon");
		map.put("/validate.code","anon");
		map.put("/**","authc");
		return map;
	}
	/**
	   <value>
                /login.jsp = anon
                /users/login=anon
                /images/**=anon
                /aaaa/logout=logout
                /student.jsp=roles[student]
                /teacher.jsp=roles[teacher]
                /list.jsp=roles["student","teacher"]
                /** = authc
            </value>
	 */
}
