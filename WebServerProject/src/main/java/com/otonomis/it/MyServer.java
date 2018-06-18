package com.otonomis.it;

import java.io.*;  
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.otonomis.client.beans.ClientDetails;
import com.otonomis.client.status.ClientStatus;
import com.otonomis.client.status.ClientStatusImp;  
public class MyServer {  
public static void main(String[] args){  
try{  
ServerSocket ss=new ServerSocket(6666);  
Socket s=ss.accept();//establishes connection
/*****************Getting information of client request*****************/
String IP = ss.getLocalSocketAddress().toString();
System.out.println(IP);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
Date date = new Date();  
System.out.println(formatter.format(date)); 

/***********************************************************************/
DataInputStream dis=new DataInputStream(s.getInputStream());  
String  str=(String)dis.readUTF();  
System.out.println("message= "+str); 
/********************************************************************/

ClientDetails detail=new ClientDetails();
detail.setIp(IP);
detail.setDatetime(formatter.format(date));
detail.setMessage(str);

ClientStatus status=new ClientStatusImp();
int test=status.saveClientInformation(detail);
if(test==1)
{
	System.out.println("Each information of client is saved in logger file");
}
else
{
	System.out.println("Not Saved in logger file");
}


/*******************************************************************/
ss.close();  
}catch(Exception e){System.out.println(e);}  
}  
}  