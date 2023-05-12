package sistema.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sistema.controller.EstoqueController;
import sistema.model.BaseDados;
import sistema.view.AVencerView;
import sistema.view.DescontoView;
import sistema.view.EstoqueView;

public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("ola 1");
		BaseDados.createBase();
		new EstoqueController(new EstoqueView());
	}
}