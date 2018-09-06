package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.magna.sistemas.timesheetv2.R;
import com.magna.sistemas.timesheetv2.activitys.ActivityLogin;
import com.magna.sistemas.timesheetv2.activitys.MainActivity;
import com.magna.sistemas.timesheetv2.adapters.SaveSharedPreference;
import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWSPreencher;
import com.magna.sistemas.timesheetv2.utils.MontaDialogAlert;

import java.util.ArrayList;

/**
 * Created by --Luan- on 15/07/2016.
 */

public class RetornoAsyncCallPreencheCampos extends ActivityLogin{

    public RetornoAsyncCallPreencheCampos(final Context context, final String nome, final String senha){

        AsyncCallWSPreencher preencheDadosColab = (AsyncCallWSPreencher) new AsyncCallWSPreencher(new AsyncCallWSPreencher.AsyncResposta() {

            @Override
            public void processFinish(ArrayList result) {

                if (result.get(0) == "") {
                    result.clear();

                    String tituloErroDadosColab = getApplicationContext().getString(R.string.dialog_titulo_login_erro_dados_colab);
                    String mensagemErroDadosColab = getApplicationContext().getString(R.string.dialog_mensagem_login_erro_dados_colab);

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(getApplicationContext(), tituloErroDadosColab, mensagemErroDadosColab);

                } else {

                    SaveSharedPreference.setUserName(context, nome);
                    SaveSharedPreference.setSenha(context, senha);

                    Intent intent = new Intent(context, MainActivity.class);
                    Bundle params = new Bundle();

                    params.putString("LoginFunc", nome);
                    intent.putExtras(params);
                    context.startActivity(intent);

                    SaveSharedPreference.setArea(context, result.get(1).toString());
                    SaveSharedPreference.setColab(context, result.get(0).toString());
                }
            }
        }).execute(nome,nome, senha);

    }


}
