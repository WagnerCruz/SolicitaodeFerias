package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.Constants;

import android.widget.Toast;

/**
 * @author Luan Costa
 * 
 */
public class Constants {

	public static enum Mode {
		PRODUCAO, HOMOLOGACAO, TESTE, DESENVOLVIMENTO;
	}

	public static final Mode MODE = Mode.DESENVOLVIMENTO;

	static {
		if (MODE == Mode.DESENVOLVIMENTO) {
			SERVER = "mgappr9";
		} else if (MODE == Mode.TESTE) {
			SERVER = "10.200.142.147";
		} else if (MODE == Mode.PRODUCAO) {
			SERVER = "portal";
		}
	}
		
	// parametros que devem ser mudados antes de ir para produçao
	public static String SERVER;

	public static final int SERVER_TIMEOUT = 2 * 60 * 1000; // 2 minutos
	public static final int SHORT_TIMEOUT = 6 * 1000; // 6 segundos
	public static final int TOAST_DURATION = Toast.LENGTH_SHORT;
	public static final long MAX_USER_INACTIVITY = 300000;
}