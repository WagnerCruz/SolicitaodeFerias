package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import android.content.Context;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.magna.sistemas.timesheetv2.R;
import com.magna.sistemas.timesheetv2.activitys.ActivityVerificaTelaBuscas;
import com.magna.sistemas.timesheetv2.adapters.SaveSharedPreference;
import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWSPreencherOportunidade;
import com.magna.sistemas.timesheetv2.utils.CarregaListaClientesProjetos;
import com.magna.sistemas.timesheetv2.utils.MontaDialogAlert;

import java.util.ArrayList;

/**
 * Created by --Luan- on 18/07/2016.
 */
public class RetornoAsyncCallWSBuscaOportunidade extends ActivityVerificaTelaBuscas {

    public RetornoAsyncCallWSBuscaOportunidade(final Context context, final ListView Lista, final AutoCompleteTextView autoCompleteTextView, final String cliente){

        String vUser = SaveSharedPreference.getUserName(context);
        String vSenha = SaveSharedPreference.getSenha(context);


        AsyncCallWSPreencherOportunidade BuscarCliente = (AsyncCallWSPreencherOportunidade) new AsyncCallWSPreencherOportunidade(new AsyncCallWSPreencherOportunidade.AsyncResposta() {

            @Override
            public void processFinish(ArrayList result) {

                if (result.size() == 0){

                    String tituloErroDadosColab = context.getString(R.string.dialog_titulo_timeout);
                    String mensagemErroDadosColab = context.getString(R.string.dialog_mensagem_oportunidade_vazia);

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloErroDadosColab, mensagemErroDadosColab);

                }else {


                    if (result.get(0) == "TRATAERRO") {
                        result.add("");
                        result.clear();

                        String tituloErroDadosColab = context.getString(R.string.dialog_titulo_timeout);
                        String mensagemErroDadosColab = context.getString(R.string.dialog_mensagem_timeout);

                        MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                        montaDialogAlert.montar(context, tituloErroDadosColab, mensagemErroDadosColab);
                    }

                    CarregaListaClientesProjetos carregaListaClientesProjetos = new CarregaListaClientesProjetos(result, context, Lista, autoCompleteTextView);

                }
            }

        }).execute(cliente, vUser, vSenha);

    }



}
