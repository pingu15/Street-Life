package streetLife;

import java.io.*;

public class Reader extends BufferedReader {
	
	public Reader(String file) throws IOException {
		super(new FileReader(file));
	}
	
	public String nextPara() throws IOException {
		String tmp, s = "";
		while((tmp = readLine()) != null) {
			s += tmp + "\n";
		}
		return s;
	}

}
