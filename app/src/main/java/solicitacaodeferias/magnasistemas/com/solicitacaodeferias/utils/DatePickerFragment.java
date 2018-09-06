package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {

	public interface OnDateSetDialogListener extends DatePickerDialog.OnDateSetListener {
		public void setData(int year, int month, int day);

		@Override
		void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth);
	}

	private OnDateSetDialogListener listener;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		DatePickerDialog dialog = new DatePickerDialog(getActivity(), listener, year, month, day);
		dialog.getDatePicker().setMaxDate(new Date().getTime());

		return dialog;
		// Create a new instance of DatePickerDialog and return it
		//return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		view.setMaxDate(Calendar.getInstance().getTimeInMillis());
		listener.setData(year, month, day);



	}

	public OnDateSetDialogListener getListener() {
		return listener;
	}

	public void setListener(OnDateSetDialogListener listener) {
		this.listener = listener;
	}
}