package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.magna.sistemas.timesheetv2.R;

/**
 * @author Luan Costa
 * 
 */
public class Utils {


	public static void setEnableFocusable(boolean enable, boolean focusable,
			View... views) {
		for (View view : views) {
			view.setEnabled(enable);
			view.setFocusable(focusable);
		}
	}
	
	public static void setVisibility(int visibility, View... views) {
		for (View view : views) {
			view.setVisibility(visibility);
		}
	}
	
	public static void setEnableAll(boolean enable, View... views){
		for (View view : views) {
			view.setEnabled(enable);
			view.setFocusable(enable);							
			view.setClickable(enable);
			view.setFocusableInTouchMode(enable);
		}
	}

	/**
	 * <p>
	 * verifica a existencia de conexão com a internet
	 * </p>
	 * 
	 * @param context
	 *            - informações contextuais da aplicação
	 */
	public static boolean verificaConexao(Context context) {
		boolean conectado;
		ConnectivityManager conectivtyManager = (ConnectivityManager) context
		.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (conectivtyManager.getActiveNetworkInfo() != null
				&& conectivtyManager.getActiveNetworkInfo().isAvailable()
				&& conectivtyManager.getActiveNetworkInfo().isConnected()) {
			conectado = true;
		} else {
			conectado = false;
		}
		return conectado;
	}

	public static void showEmptyMessage(Handler handler, final Context context) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				ActivityUtils.makeToast(context,
						R.string.nenhum_registro_encontrado);
			}
		});
	}

	public static void showNoConnectionMessage(Handler handler,
			final Context context) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				ActivityUtils.makeToast(context,
						R.string.falha_conexao_servidor);
			}
		});
	}
	

	public static String formatStringArray(String[] str){
		
		String formated = "";
		
		for (int i = 0; i < str.length-1; i++){
			formated += "'" + str[i] + "',";
		}
		
		formated += "'" + str[str.length-1] + "'";
		
		return formated;
	}
	
	public static String getTextString(TextView textView){
		
		if (textView != null && !textView.getText().toString().trim().equals("")) 
			return textView.getText().toString();
				
		return null;
	}
	
	public static Long getTextLong(TextView textView){
		
		if (textView != null && !textView.getText().toString().trim().equals("")) 
			return Long.valueOf(textView.getText().toString());
				
		return null;
	}
	
	public static Integer getTextInteger(TextView textView){
		
		if (textView != null && !textView.getText().toString().trim().equals("")) 
			return Integer.valueOf(textView.getText().toString());
				
		return null;
	}
	
	public static String getSpinnerString(Spinner spinner){
		
		if (spinner != null && spinner.getSelectedItem() != null && !spinner.getSelectedItem().toString().equals(""))
			return spinner.getSelectedItem().toString();
		
		return null;
	}
	
	public static Boolean getCheckboxValue(CheckBox checkbox){
		
		if (checkbox != null && checkbox.isChecked())
				return true;
		
		return false;
	}
	
	public static boolean validate(Context context, TextView... fields){
	
		boolean valid = true;
		
		for (TextView field : fields){
			
			if(getTextString(field) == null){
				field.setError(context.getString(R.string.required));
				valid = false;
			}else{
				field.setError(null);
			}
			
		}
		
		return valid;
		
	}
		
}
