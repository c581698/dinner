package com.hd.helloworld.interview.io.bio;

import java.awt.geom.FlatteningPathIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		try {
			int port=9527;
			ServerSocket ss=new ServerSocket(port);
			System.out.println("Server listen on port: "+port);
			Socket socket=ss.accept();
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			while(true){
				String line=in.readLine();
				if(line==null){
					Thread.sleep(100);
					continue;
				}
				if("quit".equalsIgnoreCase(line.trim())){
					in.close();
					out.close();
					ss.close();
					System.out.println("Server has been shutdown!");
					System.exit(0);
				}
				else{
					System.out.println("Message from client: "+ line);
					out.println("Server response："+line);
					Thread.sleep(100);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
