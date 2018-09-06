package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws;


        import android.os.AsyncTask;

        import java.util.ArrayList;

        import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.webservices.WebServiceRetornaListaApontamentos;

//import com.magna.sistemas.timesheetv2.webservice.WebServiceRetornaListaApontamentos;


public class AsyncCallWS extends AsyncTask<String, Void, ArrayList> {

    ArrayList displayText;
    public interface AsyncResposta{
        void processFinish(ArrayList result);
    }

    public AsyncResposta delegate = null;

    public AsyncCallWS(AsyncResposta delegate){
        this.delegate = delegate;
    }

    protected ArrayList doInBackground(String... params) {
        displayText = WebServiceRetornaListaApontamentos.chamarWebserviceApontamentos(params[0], params[1] ,params[2], params[3]);
        return displayText;
    }

    protected void onPostExecute  (ArrayList result) {
        delegate.processFinish(result);
    }
}
