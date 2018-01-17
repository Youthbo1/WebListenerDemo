package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * \Date: 2018/1/17
 * \
 * \Description:
 * \
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        String sessionId=httpSessionEvent.getSession().getId();
        Date createTime=new Date(httpSessionEvent.getSession().getCreationTime());

        System.out.println(sessionId+"   ----"+createTime);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String sessionId = httpSessionEvent.getSession().getId();
        System.out.println("session destroyed,session id:"+sessionId);

    }
}
