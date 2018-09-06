package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws;

import android.os.AsyncTask;

//import com.magna.sistemas.timesheetv2.webservice.BuscaAusencia;

import java.util.ArrayList;

/**
 * Created by --Luan- on 29/05/2016.
 */
public class AsyncCallWSPreencherAusencia extends AsyncTask<String, Void, ArrayList> {

    ArrayList displayText;

    public interface AsyncResposta{
        void processFinish(ArrayList result);
    }

    public AsyncResposta delegate = null;

    public AsyncCallWSPreencherAusencia(AsyncResposta delegate){
        this.delegate = delegate;
    }

    protected ArrayList doInBackground(String... params) {

//        displayText = BuscaAusencia.chamarWebServiceBuscaAusencia(params[0], params[1], params[2], "BUSCAAUSENCIA");
        return displayText;
    }
    protected void onPostExecute  (ArrayList result) {
        delegate.processFinish(result);
    }
}