package sistema.view;

import javax.swing.JOptionPane;

public class MensagemView extends JOptionPane{
	public MensagemView(String mensagem) {
//		showMessageDialog(null, mensagem);
		showInternalMessageDialog(null, mensagem, "Mensagem", INFORMATION_MESSAGE);
	}
}
