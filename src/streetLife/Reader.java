package streetLife;

import java.io.*;

public class Reader {
	
	BufferedReader br;
	
	public void setFile(String file) throws IOException {
		br = new BufferedReader(new FileReader(file));
	}
	
	public String readLine() throws IOException {
		return br.readLine();
	}
	
	public boolean ready() throws IOException {
		return br.ready();
	}

}
