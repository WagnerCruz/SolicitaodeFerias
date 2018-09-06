package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws;

import android.os.AsyncTask;

//import com.magna.sistemas.timesheetv2.webservice.PreencherCampos;

import java.util.ArrayList;


public class AsyncCallWSPreencherOportunidade extends AsyncTask<String, Void, ArrayList> {
    ArrayList displayText;
    public interface AsyncResposta{
        void processFinish(ArrayList result);
    }

    public AsyncResposta delegate = null;

    public AsyncCallWSPreencherOportunidade(AsyncResposta delegate){
        this.delegate = delegate;
    }

    protected ArrayList doInBackground(String... params) {

//        displayText = PreencherCampos.chamarWebServicePreencherCampos(params[0], params[1], params[2], "BUSCAOPORTUNIDADE");
        return displayText;
    }
    protected void onPostExecute  (ArrayList result) {
        delegate.processFinish(result);
    }
}


