package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * \Date: 2018/1/17
 * \
 * \Description:
 * \
 */
@WebListener
public class MyFirstListener  implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent) {


        System.out.println("Initialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Destroyed");
    }
}
