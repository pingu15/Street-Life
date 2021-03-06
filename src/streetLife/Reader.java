package streetLife;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader to read files
 * 
 * @author Max Sun
 * @since 1.0
 * @see BufferedReader
 */
public class Reader extends BufferedReader {
	
	public Reader(String file) throws IOException {
		super(new FileReader("text\\"+file));
	}
	
	public String nextPara() throws IOException {
		String tmp, s = "";
		while((tmp = readLine()) != null) {
			s += tmp + "\n";
		}
		return s;
	}
	
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}

}
