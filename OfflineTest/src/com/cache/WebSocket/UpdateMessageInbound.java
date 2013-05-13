package com.cache.WebSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

/**
 *
 *santhana_s01
 *
 **/
public class UpdateMessageInbound extends MessageInbound{
	   private WsOutbound outbound;
	   private int userIdName = 0;
       @Override
       public void onOpen( WsOutbound outbound )
       {
    	   super.onOpen(outbound);
           this.outbound = outbound;
           userIdName = outbound.hashCode();
            System.out.println("socket opened!");
           // UpdateStatus.getSocketList().add(this);
       }

       @Override
       public void onTextMessage( CharBuffer buffer ) throws IOException
       {
           try
           {
           	
           	if(buffer.toString().equalsIgnoreCase("UPDATE")){
           		
                   outbound.writeTextMessage( CharBuffer.wrap( "abc testing".toCharArray() ) );
                   System.out.println("Message sent from server.");
                   
           		
           	}
           	
           /*	for (UpdateMessageInbound messageInbound : UpdateStatus.getSocketList()) {
                CharBuffer msgBuffer1 = CharBuffer.wrap("MSG1");
                CharBuffer msgBuffer2 = CharBuffer.wrap("MSG@");

                WsOutbound outbound = messageInbound.getWsOutbound();
                if (messageInbound.getUserIdName() != this.getUserIdName()) {
                    outbound.writeTextMessage(msgBuffer1);
                    outbound.flush();
                } else {
                    outbound.writeTextMessage(msgBuffer2);
                }
            }*/

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
      //  UpdateStatus.getSocketList().remove(this);
        super.onClose(status);
       }
       
       public void writeMessage(String msg) throws IOException{
    	   CharBuffer msgBuffer1 = CharBuffer.wrap(msg);
    	   outbound.writeTextMessage(msgBuffer1);
       }
       
       public WsOutbound getChannel(){
    	   return outbound;
       }
       public int getUserIdName() {
           return userIdName;
       }
}
