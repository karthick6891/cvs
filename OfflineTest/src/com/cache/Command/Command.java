package com.cache.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Santhana Rajagopalan S
 */
public interface Command
{

    public void execute(HttpServletRequest request, 
                        HttpServletResponse response) 
                    throws ServletException, IOException;
}
