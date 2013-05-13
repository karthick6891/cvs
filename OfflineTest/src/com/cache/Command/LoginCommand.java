package com.cache.Command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cache.bean.ModelBean;
import com.cache.servlet.ControllerServlet;

/**
 *
 *@author Santhana Rajagopalan S
 *
 **/
public class LoginCommand implements Command{
	
	 public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	      /*  ModelBean modelBean = new ModelBean();

	        modelBean.setFirstName(request.getParameter("first_name")); 
	        modelBean.setLastName( request.getParameter("last_name")); 
	        modelBean.setEmail(    request.getParameter("email")); 
	        modelBean.setPhone(    request.getParameter("phone")); 

	        request.setAttribute("modelBean", modelBean);*/
		 	

	        ServletContext context = request.getSession().getServletContext();
	        
	        String userId = request.getParameter("user_id");
	        String password = request.getParameter("password");
	        try{
	        System.out.println("USERID && Password" + userId  + " :: "+ password );
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        if(userId.equalsIgnoreCase("abc") && password.equalsIgnoreCase("abc")){
	              context.getRequestDispatcher("/home.jsp").forward(request, response);
	        }else{
	            context.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
	        }
	    }
}
