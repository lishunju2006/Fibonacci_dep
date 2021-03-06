package com.emc.interview.servlet;
import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.log4j.PropertyConfigurator;  
  
/** 
 * Servlet implementation class Log4jInit 
 */  
public class Log4JInitServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        
        super.doGet(req, resp);  
    }  
  
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        // TODO Auto-generated method stub  
        super.doPost(req, resp);  
    }  
  
    @Override  
    public void init() throws ServletException {  
        // TODO Auto-generated method stub  
        super.init();  
        String prefix = getServletContext().getRealPath("/");  
        String file = getInitParameter("fib-log");  
        if (file != null) {  
            System.out.println("read log4j.properties:"+prefix + file);  
            PropertyConfigurator.configure(prefix + file);  
        }  
    }  
  
} 