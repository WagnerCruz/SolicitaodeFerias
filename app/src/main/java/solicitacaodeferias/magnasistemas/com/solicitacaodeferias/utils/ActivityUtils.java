package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.content.Context;
import android.widget.Toast;

import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.Constants.Constants;

public class ActivityUtils {
	
	public static void makeToast(Context context, int stringId){
		Toast
			.makeText(context, stringId, Constants.TOAST_DURATION)
			.show();
	}

	public static void makeToast(Context context, String message){
		Toast
			.makeText(context, message, Constants.TOAST_DURATION)
			.show();
	}
}
