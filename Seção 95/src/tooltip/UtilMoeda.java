package tooltip;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class UtilMoeda {

	
	private static final Locale PT_BR = new Locale("pt", "BR");
	
	private static NumberFormat NF = NumberFormat.getCurrencyInstance(PT_BR);
	
	public static String formatarBR(BigDecimal valor) {
		
		if (valor == null) return "";
		
		return NF.format(valor);
		
	}
	
}
