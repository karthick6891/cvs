package com.cache.Command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cache.bean.ModelBean;

/**
 * @author Santhana Rajagopalan S
 */
public class WriteCommand implements Command
{

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ModelBean modelBean = new ModelBean();

        modelBean.setFirstName(request.getParameter("first_name")); 
        modelBean.setLastName( request.getParameter("last_name")); 
        modelBean.setEmail(    request.getParameter("email")); 
        modelBean.setPhone(    request.getParameter("phone")); 

        request.setAttribute("modelBean", modelBean);

        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/jsp/view.jsp").forward(request, response);
    }
}
