package com.bit2016.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPTimeClient {

	private static final String SERVER_IP = "192.168.1.17";
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			// 1. 키보드연결
			
			// 2. 소켓생성
			socket = new DatagramSocket();
			
			// 3. 사용자 입력
			String message = "";
			
			// 4. 메세지 전송
			byte[] sendData = message.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,new InetSocketAddress(SERVER_IP, UDPTimeServer.PORT));
			
			socket.send(sendPacket);
			
			// 5. 메세지 수신
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
			
			socket.receive(receivePacket);
			
			message = new String(receivePacket.getData(), 0 , receivePacket.getLength(),"UTF-8");
			System.out.println(">>" + message);
			
			
		}catch (IOException e){
			e.printStackTrace();
		}finally{  
			
			// 자원정리
			
			if(socket != null && socket.isClosed() == false){
				socket.close();
			}
		}
	}

}
