package com.santrong.plt.webpage.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.santrong.plt.system.Global;
import com.santrong.plt.webpage.BaseAction;
import com.santrong.plt.webpage.teacher.entry.UserItem;

/**
 * @author weinianjie
 * @date 2014年11月6日
 * @time 下午4:43:07
 */
public abstract class RegistBaseAction extends BaseAction {
	
	// 控制器方法的前置方法
	public RmCode preMethod(HttpServletRequest request, HttpServletResponse response) {
		UserItem user = (UserItem)request.getSession().getAttribute(Global.SessionKey_LoginUser);
		if(user == null) {
			return RmCode.REQUIRE_LOGIN;
		}
		
		if(!user.isRegist()) {
			return RmCode.REQUIRE_REGIST_AUTH;
		}
		return RmCode.PASS;
	}	
	
}
