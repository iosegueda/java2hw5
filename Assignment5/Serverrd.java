import java.io.*;
import java.net.*;

public class Server {
	
	public static void main(String[] args) throws IOException 
	{
		String file_name= null;
		String readline= null;
		Socket connection;
		BufferedReader in ;
		BufferedWriter out;
		final int inputSocketNum = 8189;
		ServerSocket input;
		File file;
		try{
		while(true)
		{
			input = new ServerSocket (inputSocketNum);
			connection = input.accept();
			BufferedReader inFromClient = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
			try
			{
				file_name= inFromClient.readLine();
				
				file = new File( file_name );

				if ( file.exists() && file.isFile() )
				{
					System.out.println("loading file");
					in = new BufferedReader ( new FileReader(file_name));
					out=new BufferedWriter( new OutputStreamWriter( connection.getOutputStream() ) );
					while(( readline= in.readLine())!= null)
				    {
						out.write(readline);
						out.write("\n");			    
				    }
				    	in.close();
				    	out.close();
				}
				else
				{
					System.out.println("error file not found");				
				}
			
				
			}
			catch (IOException ex)
			{
				System.out.println(ex.toString());
				System.out.println("could not find file :"+ file_name);
			
			}
			connection.close();
			input.close();
			
		}
		}catch(ConnectException e)
		{
			e.printStackTrace();
		}
		
	}
}
	