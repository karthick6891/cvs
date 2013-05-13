package com.cache.Command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cache.bean.ModelBean;
/**
 * @author santhana_s01@infosys.com
 */

public class InitCommand implements Command
{

    public void execute(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("modelBean", new ModelBean());

        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/jsp/view.jsp").forward(request, response);
        
    }
}
