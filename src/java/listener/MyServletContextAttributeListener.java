package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * \Date: 2018/1/17
 * \
 * \Description:
 * \
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("ServletContext#attAdded#name:" + scae.getName() + "#value:"	+ scae.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("ServletContext#attRemoved#name:" + scae.getName() + "#value:"	+ scae.getValue());

    }

    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("ServletContext#attReplaced#name:" + scae.getName() + "#value:"	+ scae.getValue());
    }
}
