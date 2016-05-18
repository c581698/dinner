package com.hd.helloworld.interview.io.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TcpClient {

	public static void main(String[] args) throws IOException {
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		channel.connect(new InetSocketAddress("127.0.0.1", 9521));
		
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_CONNECT);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			if(channel.isConnected()){
				String cmd = in.readLine();
				channel.write(Charset.forName("UTF-8").encode(cmd));
				
				if(cmd == null || "quit".equalsIgnoreCase(cmd.trim())){
					in.close();
					selector.close();
					channel.close();
					
					System.out.println("Client quit");
					
					System.exit(0);
				}
			}
			
			int nKey = selector.select();
			
			if(nKey>0){
				for(SelectionKey key : selector.keys()){
					SocketChannel sc = (SocketChannel)key.channel();
					
					if(key.isConnectable()){
						sc.configureBlocking(false);
						
						sc.register(selector, SelectionKey.OP_READ);
						sc.finishConnect();
					}else if(key.isReadable()){
						ByteBuffer bb = ByteBuffer.allocate(1024);
						int rl = 0;
						
						while((rl=sc.read(bb)) > 0){
							
						}
						
						bb.flip();
						
						System.out.println(Charset.forName("UTF-8").decode(bb));
						
						bb.clear();
						bb = null;
					}
				}
				selector.keys().clear();
			}
		}
		
	}

}
