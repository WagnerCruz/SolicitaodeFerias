package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Classe para manipulações de datas.
 * 
 * <pre>
 * Last Modified  $Date: 2013/10/19 14:28:13 $
 * Last Modified by $Author: Luan Costa $
 * </pre>
 * 
 * @author lcosta
 */
@SuppressLint("SimpleDateFormat")
public final class DateTimeUtils {
	
	public static final DateFormat DT_FMT_DATE_TIME_SIMPLE = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	public static final DateFormat HORA_FORMAT = new SimpleDateFormat("HH:mm", Locale.getDefault());

	/**
	 * Retorna uma data com a hora 23:59:59.
	 * 
	 * @param data
	 *            - Data a ser formatada
	 * @return Data no formato yyyy-MM-dd 23:59:59
	 */
	public static Date buildDataHoraLimite(Date data) {
		Date result = null;

		if (data != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			result = calendar.getTime();
		}
		return result;
	}

	/**
	 * Retorna uma data com a hora 00:00:00.
	 * 
	 * @param data
	 *            - Data a ser formatada
	 * @return Data no formato yyyy-MM-dd 00:00:00
	 */
	public static Date zerarHoraData(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Transforma em objeto <code>Date</code> uma string de data no formato
	 * "dd/MM/yyyy".
	 * 
	 * @param stringDate
	 * @return Retorna NULL se houver erro de convers�o.
	 */
	public static Date toDate(String stringDate) {
		try {
			return DATE_FORMAT.parse(stringDate);
		} catch (ParseException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * Formata um <code>Date</code> em uma String no formato dd/MM/yyyy hh:mm
	 * 
	 * @param date
	 * @return O String formatado, se for passado null no date, retorna um
	 *         String de espa�os com 8 caracters
	 */
	public static String formataDataSimple(Date date) {
		return date == null ? null : DT_FMT_DATE_TIME_SIMPLE.format(date);
	}
	
	
	/**
	 * Formata um <code>Date</code> em uma String no formato dd/MM/yyyy
	 * 
	 * @param date
	 * @return O String formatado, se for passado null no date, retorna um
	 *         String de espa�os com 8 caracters
	 */
	public static String formataDataOnly(Date date) {
		return date == null ? null : DATE_FORMAT.format(date);
	}

	
	/**
	 * Formata um <code>Date</code> em uma String no formato hh:mm
	 * 
	 * @param date
	 * @return O String formatado, se for passado null no date, retorna um
	 *         String de espa�os com 8 caracters
	 */
	public static String formataHoraOnly(Date date) {
		return date == null ? null : HORA_FORMAT.format(date);
	}

	public static String formatDateFromDatePicker(int year, int month, int day) {
		StringBuilder sb = new StringBuilder();

		String dia = day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);
		sb.append(dia).append("/");

		String mes = month + 1 < 10 ? "0" + String.valueOf(month + 1) : String
				.valueOf(month + 1);
		sb.append(mes).append("/");
		sb.append(year);

		return sb.toString();
	}

	public static String formatTimeFromTimePicker(int hourOfDay, int minute) {
		StringBuilder sb = new StringBuilder();

		String hora = hourOfDay < 10 ? "0" + String.valueOf(hourOfDay) : String
				.valueOf(hourOfDay);
		sb.append(hora).append(":");

		String minuto = minute < 10 ? "0" + String.valueOf(minute) : String
				.valueOf(minute);
		sb.append(minuto);

		return sb.toString();
	}

}
