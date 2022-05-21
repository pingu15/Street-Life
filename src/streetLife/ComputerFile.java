package streetLife;

import java.util.ArrayList;

public class ComputerFile {

	public String name;
	public ArrayList<ComputerFile> subFiles;
	public String pathName;
	public ComputerFile par;
	
	public ComputerFile(String name, String pathName, ComputerFile par) {
		this.name = name;
		this.pathName = pathName;
		this.par = par;
	}
	
	@Override
	public String toString() {
		return this.pathName;
	}
	
}
