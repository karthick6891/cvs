package com.cache.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cache.Command.Command;
import com.cache.Command.InitCommand;
import com.cache.Command.LoginCommand;
import com.cache.Command.WriteCommand;

/**
 * Servlet implementation class ControllerServlet
 * 
 * @author Santhana Rajagopalan S
 */
@WebServlet( name="ControllerServlet", displayName="Controller Servlet", urlPatterns = {"/ControllerServlet","*.do"}, loadOnStartup=1)
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,Command> commands = new HashMap<String,Command>();
	private Map<String,String> credMap =  new HashMap<String, String>();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		this.commands.put("init",  new InitCommand());
		this.commands.put("write", new WriteCommand());
		this.commands.put("login", new LoginCommand());
		credMap.put("abc","abc");
		credMap.put("def","def");
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processCommand(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processCommand(request, response);
	}

	public void processCommand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String formAction = request.getParameter("form_action");
		System.out.println("FORM ACTION: " + formAction);
		if (null == formAction) {
			formAction = "init";
		}

		Command command = commands.get(formAction);

		if (null == command) {
			throw new IllegalArgumentException("No command for form action: "
					+ formAction);
		}

		command.execute(request, response);
	}

}
