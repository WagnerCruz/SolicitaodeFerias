package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws;

import android.os.AsyncTask;

//import com.magna.sistemas.timesheetv2.webservice.AprovaApontamento;


import java.util.ArrayList;

/**
 * Created by --Luan- on 29/05/2016.
 */
public class AsyncCallWSAprova extends AsyncTask<String, Void, ArrayList> {

    ArrayList displayText;

    public interface AsyncRespostaAprova{
        void processFinish(ArrayList result);
    }

    public AsyncRespostaAprova delegate = null;

    public AsyncCallWSAprova(AsyncRespostaAprova delegate){
        this.delegate = delegate;
    }

    protected ArrayList doInBackground(String... params) {

//        displayText = AprovaApontamento.invokeHelloWorldWS(params[0],params[1], params[2], "ATUALIZADOC");
        return displayText;
    }

    protected void onPostExecute  (ArrayList result) {

        delegate.processFinish(result);
    }
}