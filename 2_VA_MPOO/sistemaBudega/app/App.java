package sistema.app;

import javax.swing.UIManager;

import sistema.controller.MenuController;
import sistema.model.BaseDados;
import sistema.view.MenuView;

public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MenuView menuview = new MenuView();
		new MenuController(menuview);

		BaseDados.createBase();
	}
}