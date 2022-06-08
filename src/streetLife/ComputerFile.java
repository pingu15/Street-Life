package streetLife;

import java.util.ArrayList;

public class ComputerFile {

	public String name;
	public String pathName;
	public ComputerFile par;
	public boolean unzipped;
	public boolean isFolder;
	public String prompt;
	public String password;
	public ArrayList<ComputerFile> subFiles;
	
	public ComputerFile(String name, String pathName, ComputerFile par, boolean isFolder) {
		this.name = name;
		this.pathName = pathName;
		this.par = par;
		this.isFolder = isFolder;
		this.unzipped = !isFolder;
		this.subFiles = new ArrayList<>();
	}
	
	public void setPass() {
		this.prompt = Functions.prompts.getOrDefault(name, "");
		this.password = Functions.passwords.getOrDefault(name, "");
	}
	
	@Override
	public String toString() {
		return this.pathName;
	}
	
	public String getRelativePath() {
		return "computer"+pathName.substring(("C:\\Users\\"+Computer.name).length());
	}
	
	public void addSubFile(ComputerFile sub) {
		this.subFiles.add(sub);
	}
	
}
