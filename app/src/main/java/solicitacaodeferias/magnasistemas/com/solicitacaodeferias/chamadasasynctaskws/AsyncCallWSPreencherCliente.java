package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws;

import android.os.AsyncTask;

//import com.magna.sistemas.timesheetv2.webservice.BuscaCliente;

import java.util.ArrayList;

/**
 * Created by --Luan- on 29/05/2016.
 */
public class AsyncCallWSPreencherCliente extends AsyncTask<String, Void, ArrayList> {

    ArrayList displayText;

    public interface AsyncResposta{
        void processFinish(ArrayList result);
    }

    public AsyncResposta delegate = null;

    public AsyncCallWSPreencherCliente(AsyncResposta delegate){
        this.delegate = delegate;
    }

    protected ArrayList doInBackground(String... params) {

//        displayText = BuscaCliente.chamarWebServiceBuscaCliente(params[0], params[1],params[2], "BUSCACLIENTE");
        return displayText;
    }
    protected void onPostExecute  (ArrayList result) {
        delegate.processFinish(result);
    }
}