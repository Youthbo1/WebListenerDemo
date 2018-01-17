package com.listener;

import com.cache.LoginCache;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * \Date: 2018/1/17
 * \
 * \Description:
 * \
 */
@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {

    private static final String LOGIN_USER="loginUser";

    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();//监听到session属性值发生添加操作，获取对应操作的属性名

        if(LOGIN_USER.equals(attrName)){//若属性名为登录属性名，判定为用户登录操作
            String attrVal = (String)httpSessionBindingEvent.getValue();//获取添加的属性值，即用户登录名
            HttpSession session = httpSessionBindingEvent.getSession();//该次操作的session对象
            String sessionId = session.getId();//该次操作的session对象ID

            String sessionId2 = LoginCache.getInstance().getSessionIdByUsername(attrVal);//从缓存对象里面，获得该用户登录名对应的sessionID值
            if(null == sessionId2){//未获得结果，不需要清理前次登录用户会话信息

            }else{
                HttpSession session2 = LoginCache.getInstance().getSessionBySessionId(sessionId2);//获取前次该用户登录对应的session对象
                session2.invalidate();//清理前次登录用户会话存储信息，使得前次登录失效
            }

            //完成该次登录用户登录名、sessionID，session对象的缓存对象存储
            LoginCache.getInstance().setSessionIdByUserName(attrVal, sessionId);
            LoginCache.getInstance().setSessionBySessionId(sessionId, session);
    }}

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
