package ru.sbrf.jschool.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ServletListenerExample implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ServletContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("servlet {} is initialized", servletContextEvent.getServletContext().getServletContextName());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info(
                "servlet {} is destroyed",
                servletContextEvent.getServletContext().getServletContextName()
        );
    }
}
