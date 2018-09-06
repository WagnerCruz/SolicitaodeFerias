package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.magna.sistemas.timesheetv2.R;
import com.magna.sistemas.timesheetv2.activitys.MainActivity;
import com.magna.sistemas.timesheetv2.adapters.SaveSharedPreference;
import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWSAprova;
import com.magna.sistemas.timesheetv2.utils.MontaDialogAlert;

import java.util.ArrayList;

/**
 * Created by diego on 27/07/2016.
 */
public class RetornoAsyncCallWSSolicitaAlteracao {

    public RetornoAsyncCallWSSolicitaAlteracao(final Context context, final String parametro, final ProgressDialog proDialog){

        String vUser = SaveSharedPreference.getUserName(context);
        String vSenha = SaveSharedPreference.getSenha(context);

        AsyncCallWSAprova asyncTask = (AsyncCallWSAprova) new AsyncCallWSAprova(new AsyncCallWSAprova.AsyncRespostaAprova() {

            @Override
            public void processFinish(ArrayList result) {

                proDialog.dismiss();

                if (result.get(0) == "ERRO") {
                    result.clear();
                    //result.add("");

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle(context.getString(R.string.dialog_titulo_apontamento_enviado_sucesso));
                    alert.setMessage(context.getString(R.string.dialog_mensagem_timeout));

                    alert.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
                    alert.show();
                }

                String erroApontamento = "";
                String vpesquisa = result.get(0).toString();

                if (vpesquisa.contains("1A")) {
                    erroApontamento = "1A";
                }

                if (erroApontamento == "1A") {

                    String tituloErroCfEmitido = context.getResources().getString(R.string.dialog_titulo_erro_controle_frequencia_emitido_solicita_alteracao);
                    String mensagemCfEmitido = context.getResources().getString(R.string.dialog_mensagem_erro_controle_frequencia_emitido__solicita_alteracao);

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloErroCfEmitido, mensagemCfEmitido);
                }


                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);


            }

        }).execute(parametro, vUser, vSenha);

    }
}
