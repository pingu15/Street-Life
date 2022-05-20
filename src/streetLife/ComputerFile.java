package streetLife;

import java.util.ArrayList;

public class ComputerFile {

	public String name;
	public ArrayList<ComputerFile> subFiles;
	public String pathName;
	public ComputerFile par;
	
	public ComputerFile(String n, String pn, ComputerFile p) {
		name = n;
		pathName = pn;
		par = p;
	}
	
	@Override
	public String toString() {
		return pathName;
	}
	
}
