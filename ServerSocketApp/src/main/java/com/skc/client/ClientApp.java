package com.skc.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import com.skc.util.NetworkUtils;


public class ClientApp {
	/*public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(NetworkUtils.SEVER_HOST,NetworkUtils.SERVER_PORT);
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF("Hello Sitakant");
		dataOutputStream.flush();
		dataOutputStream.close();
		socket.close();
	}*/
	
	public static void main(String[] args) throws IOException {
		Socket socketClient = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		Scanner  scanner = new Scanner(System.in);
		try {
			socketClient = new Socket(NetworkUtils.SEVER_HOST,NetworkUtils.SERVER_PORT);
			
			/*dataInputStream = new DataInputStream(socketClient.getInputStream());
			System.out.println(dataInputStream.readUTF());
			*/
			while (true) {
				dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
				dataOutputStream.writeUTF(scanner.nextLine());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			dataInputStream.close();
		}
	}
}
