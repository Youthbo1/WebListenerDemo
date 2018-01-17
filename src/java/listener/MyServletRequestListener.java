package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * \Date: 2018/1/17
 * \
 * \Description:
 * \
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener{
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request listener,request destroyed... ...");
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        HttpServletRequest request= (HttpServletRequest) servletRequestEvent.getServletRequest();
        String path = request.getRequestURI();
        String par = request.getParameter("par");

        System.out.println("request listener,path:" + path + ",par is :" + par);

    }
}
