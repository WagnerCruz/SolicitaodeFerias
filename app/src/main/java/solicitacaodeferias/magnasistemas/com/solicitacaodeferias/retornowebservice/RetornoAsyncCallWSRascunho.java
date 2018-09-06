package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ListView;

import com.magna.sistemas.timesheetv2.R;
import com.magna.sistemas.timesheetv2.adapters.SaveSharedPreference;
import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWS;
import com.magna.sistemas.timesheetv2.utils.CarregaLista;
import com.magna.sistemas.timesheetv2.utils.MontaDialogAlert;

import java.util.ArrayList;

/**
 * Created by --Luan- on 08/07/2016.
 */
public class RetornoAsyncCallWSRascunho  {

    ProgressDialog progDialog;


    @SuppressLint("ValidFragment")
    public RetornoAsyncCallWSRascunho(final Context context, final ListView Lista, final ProgressDialog progDialog){

        String vUser = SaveSharedPreference.getUserName(context);
        String vSenha = SaveSharedPreference.getSenha(context);

        String webService = "LISTADOCABERTO";
        String soapAction = "LISTADOCAGUARDANDO?WSDL";

        AsyncCallWS asyncTask = (AsyncCallWS) new AsyncCallWS(new AsyncCallWS.AsyncResposta() {

            @Override
            public void processFinish(ArrayList result) {


                if (result.get(0) == "ERROWeb"){
                    result.clear();

                    String tituloErroDadosColab = context.getString(R.string.dialog_titulo_timeout);
                    String mensagemErroDadosColab = context.getString(R.string.dialog_mensagem_timeout);

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context,tituloErroDadosColab,mensagemErroDadosColab);

                } else {
                    CarregaLista carregaLista = new CarregaLista(result,context, Lista, progDialog);
                }
            }

            //}).execute(SaveSharedPreference.getUserName(getActivity().getApplicationContext()));
        }).execute(vUser, vSenha, webService,soapAction);

    }
}
