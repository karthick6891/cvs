package com.bman.commands;
/**
 * @author Santhana Rajagopalan S
 * Apr 12, 2013
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bman.dto.ModelBean;


public class InitCommand implements Command{

    public void execute(HttpServletRequest request, 
                        HttpServletResponse response) 
                    throws ServletException, IOException{

        request.setAttribute("modelBean", new ModelBean());

        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/view.jsp").forward(request, response);
    }
}
