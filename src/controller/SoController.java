package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

public class SoController {
	
	public  SoController() {
		super();
	}

	public String getOs() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public boolean chamaProcesso(String processo) {
		try {
			Runtime.getRuntime().exec(processo);
			return true;
		} catch (IOException e) {
			if(e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString());
					return true;
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE); return false;
				}
			}else {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE); return false;
			}
		}
	}
	
}
