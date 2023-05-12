package sistemaSupermercado;

import java.util.Calendar;
import java.util.Date;

public class Verificador {

	private boolean VerificarVencimento(Date validadeProduto) {
		Date dateAtual = new Date(System.currentTimeMillis());
		Calendar calB = Calendar.getInstance();
		calB.setTime(dateAtual);
		dateAtual = calB.getTime();
		return true;
	}
}
