package sistema.view;

import javax.swing.JOptionPane;

public class MensagemErroView extends JOptionPane{
	public MensagemErroView(String mensagem) {
		showMessageDialog(null, mensagem, "Erro", ERROR_MESSAGE);
	}
}
