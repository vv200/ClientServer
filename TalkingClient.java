package com.clientserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalkingClient
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket s = new Socket("localhost", 6666);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "", str2 = "";
		while (!str1.equals("end"))
		{
			str1 = br.readLine();
			dout.writeUTF(str1);
			dout.flush();
			str2 = din.readUTF();
			System.out.println("Server says: " + str2);
		}
		dout.close();
		s.close();

	}

}
