//Iris Osegueda
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {

	public static void main(String[] args) throws IOException{
		final int port = 8189;
		JFrame frame;
		 String FileName;
		Socket clientSocket;
		BufferedReader inFromServer;
		BufferedWriter outToServer;
		final JTextField text = new JTextField(20);
		String Out;
			
		JTextArea outFromFile = new JTextArea ("output from server",30,30);
		
		frame= new JFrame("assignment 5 ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(text, BorderLayout.NORTH);
		frame.getContentPane().add(outFromFile, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		
		text.addActionListener( new ActionListener()
			{
				public void actionPerformed( ActionEvent ae ) 
				{
						
						text.setEditable(false);
				}
			});
		FileName=text.getText();
		
		clientSocket = new Socket("localhost",port);
		outToServer = new BufferedWriter( new OutputStreamWriter( clientSocket.getOutputStream() ) );
		inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		   
		outToServer.write(FileName);
		   
	 
		while((Out=(inFromServer.readLine()))!= null)
		{
			outFromFile.setText(Out);
		}
		
		text.setEditable(true);
		inFromServer.close();
		  
		 
		clientSocket.close();
		
		
		
	
	}



}