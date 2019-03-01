package view;

import controller.SoController;
import view.FrameExecutar;
public class Main {

	public static void main(String[] args) {
		SoController soController = new SoController();
		System.out.println(soController.getOs());
		
		FrameExecutar tela = new FrameExecutar();
		tela.setDefaultCloseOperation(tela.EXIT_ON_CLOSE);
		tela.setVisible(true);
		
	}

}
