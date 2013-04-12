package com.bman.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bman.commands.Command;
import com.bman.commands.InitCommand;
import com.bman.commands.WriteCommand;

/**
 * Servlet implementation class MainController
 * @author Santhana Rajagopalan S
 * Apr 12, 2013
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Map<String, Command> commands = new HashMap<String, Command>();
    
    public void init(){
        this.commands.put("init",  new InitCommand());
        this.commands.put("write", new WriteCommand());
    }

    public void processCommand(HttpServletRequest  request, 
                               HttpServletResponse response) 
                           throws ServletException, IOException{

        String formAction = request.getParameter("form_action");

        if(null == formAction){
            formAction = "init";
        }

        Command command = (Command)commands.get(formAction);

        if(null == command){
            throw new IllegalArgumentException(
                "No command for form action: " + formAction);
        }
        command.execute(request, response);
    }

    public void doPost(HttpServletRequest  request, 
                       HttpServletResponse response) 
                  throws ServletException, IOException{

        processCommand(request, response);
    }

    public void doGet(HttpServletRequest  request, 
                      HttpServletResponse response) 
                  throws ServletException, IOException{

        processCommand(request, response);
    }

}
