package com.cache.WebSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

/**
 * Servlet implementation class UpdateStatus
 * @author Santhana Rajagopalan S 
 */

@WebServlet( name="UpdateStatus", displayName="Update Status", urlPatterns = {"/UpdateStatus","*.*"}, loadOnStartup=1)
public class UpdateStatus extends WebSocketServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<String , Long> fileInfo = new HashMap<String, Long>();
	private HttpServletRequest httpRequest;
	//private static List<UpdateMessageInbound> socketList = new ArrayList<UpdateMessageInbound>();
	private static List<updateStatus> socketList = new ArrayList<updateStatus>();	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("UPDATE STATUS");
        
    }

    public void init(ServletConfig config) throws ServletException {  
    	super.init(config); //added this line then it worked
    	System.out.println("UPDATE CONFIG");
    	System.out.println(getServletContext().getAttribute("TEST"));

    }    
    
    @Override
    protected StreamInbound createWebSocketInbound(String arg0,
            HttpServletRequest arg1) {

        //return new UpdateMessageInbound();
    	return new updateStatus();
    }

    /*public static synchronized List<UpdateMessageInbound> getSocketList() {
        return socketList;
    }*/
    public static synchronized List<updateStatus> getSocketList() {
        return socketList;
    }
    public class updateStatus extends MessageInbound
    {
        private WsOutbound outbound;
        private int userIdName = 0;
        @Override
        public void onOpen( WsOutbound outbound )
        {
            this.outbound = outbound;
            this.userIdName = outbound.hashCode();
             System.out.println("socket opened!");
             getServletContext().setAttribute("channel", this.outbound);
             getSocketList().add(this);
        }

        @Override
        public void onTextMessage( CharBuffer buffer ) throws IOException
        {
            try
            {
            	
            	if(buffer.toString().equalsIgnoreCase("UPDATE")){
            		
                    outbound.writeTextMessage( CharBuffer.wrap( "abc testing".toCharArray() ) );
                    System.out.println("Message sent from server.");
                    getServletContext().setAttribute("Sockets", getSocketList());
                   
            	}

            }
            catch ( IOException ioException )
            {
                    System.out.println("error opening websocket");
            }

        }

        @Override
        protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
            // TODO Auto-generated method stub

        }
        


        @Override
        protected void onClose(int status){
        	System.out.println("Connection close" + status);
        	getSocketList().remove(this);
        }
        public int getUserName(){
        	return userIdName;
        }
    }


}

