package listener; /**
 * Created by Administrator on 2018/1/17.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class MyServletContextListener implements ServletContextListener{


    public void contextInitialized(ServletContextEvent sce) {
        String appName = sce.getServletContext().getInitParameter("app_name");
        String version = sce.getServletContext().getInitParameter("version");

        sce.getServletContext().setAttribute("app_name", appName);
        sce.getServletContext().setAttribute("version", version);

        System.out.println("MyServletContextListener init,appName:" + appName + ",version:" + version);


    }

    public void contextDestroyed(ServletContextEvent sce) {
        String appName = (String)sce.getServletContext().getAttribute("app_name");
        String version = (String)sce.getServletContext().getAttribute("version");

        System.out.println("MyServletContextListener destroyed,appName:" + appName + ",version:" + version);


    }


}
