package com.home.socket;

import java.net.Socket;

public class CheckPort {

	public boolean isPortListening(String host, int port) {
		try (Socket socket = new Socket(host, port)) {
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		CheckPort cp = new CheckPort();
		boolean isServerRunning = false;
		try {
			for(int i = 0; i < 5; i++) {
				if(cp.isPortListening("localhost", 9292)) {
					isServerRunning = true;
					break;
				}
				Thread.sleep(10000);  // wait 10 seconds
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		if(isServerRunning) {
			System.out.println("server is up and running");
		} else {
			System.out.println("server is down");
		}
	}
}
