package controller;

public class SoController {
	
	public  SoController() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
}
