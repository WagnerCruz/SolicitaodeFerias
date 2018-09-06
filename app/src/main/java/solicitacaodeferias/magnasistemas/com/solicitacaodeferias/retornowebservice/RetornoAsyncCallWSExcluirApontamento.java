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

import java.util.ArrayList;

/**
 * Created by diego on 27/07/2016.
 */
public class RetornoAsyncCallWSExcluirApontamento {

    public RetornoAsyncCallWSExcluirApontamento(final Context context, final String parametro, final ProgressDialog proDialog){

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

                String vsucesso = result.get(0).toString();

                if (vsucesso.contains("1S")) {
                    vsucesso = "1S";
                }

                if (vsucesso.equals("1S")) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle(context.getResources().getString(R.string.dialog_titulo_excluido_sucesso));
                    alert.setCancelable(false);


                    alert.setMessage(context.getResources().getString(R.string.dialog_mensagem_excluido_sucesso));

                    alert.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context,MainActivity.class);
                            context.startActivity(intent);

                        }
                    });

                    alert.show();
                }

            }

        }).execute(parametro, vUser, vSenha);

    }
}