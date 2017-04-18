import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class client {

	public static void main(String[] args) throws IOException{
		final int port = 8189;
		JFrame frame;
	//	BufferedReader inFromUser = null;
		String FileName;
		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		
		JTextField text = new JTextField(20);
		
		JTextArea outFromFile = new JTextArea (30 ,30);
		
		frame= new JFrame("assignment 5 ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(text, BorderLayout.NORTH);
		frame.getContentPane().add(outFromFile, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		
		FileName=text.getText();
		
		clientSocket = new Socket("localhost",port);
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		   
		outToServer.writeBytes(FileName + '\n');
		   
		System.out.println("FROM SERVER: " );
		 
		while((inFromServer.readLine())!= null)
		{
			inFromServer.readLine();
		}
		//inFromUser.close();
		inFromServer.close();
		  
		 
		clientSocket.close();
	
	}



}

	
	
	

