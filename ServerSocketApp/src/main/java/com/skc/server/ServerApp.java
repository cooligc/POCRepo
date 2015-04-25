package com.skc.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.skc.util.NetworkUtils;


public class ServerApp {
	/*public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(NetworkUtils.SERVER_PORT);
		Socket socket = serverSocket.accept();
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		String str = (String)dataInputStream.readUTF();
		System.out.println("Network Data :"+str);
		serverSocket.close();
		
	}*/
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket =null;
		Socket socket = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			serverSocket = new ServerSocket(NetworkUtils.SERVER_PORT);
			socket = serverSocket.accept();
			
			while(true){
				dataInputStream = new DataInputStream(socket.getInputStream());
				System.out.println("Client Says " +dataInputStream.readUTF());
			}
			
			/*dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeUTF("Hi ");
			dataOutputStream.flush();
			dataOutputStream.close();
			*/
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			dataInputStream.close();
		}
	}
}
