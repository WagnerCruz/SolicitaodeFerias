package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import java.util.ArrayList;

import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.MainActivity;
import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.adapters.SaveSharedPreference;
import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws.AsyncCallWSAprova;
import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils.MontaDialogAlert;

//import com.magna.sistemas.timesheetv2.R;
//import com.magna.sistemas.timesheetv2.activitys.MainActivity;
//import com.magna.sistemas.timesheetv2.adapters.SaveSharedPreference;
//import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWSAprova;
//import com.magna.sistemas.timesheetv2.utils.MontaDialogAlert;

/**
 * Created by --Luan- on 21/07/2016.
 */
public class RetornoAsyncCallEnviar {

    public RetornoAsyncCallEnviar(final Context context, final String parametroAprova, final ProgressDialog proDialog, final String modoEnvio){

        String vUser = SaveSharedPreference.getUserName(context);
        String vSenha = SaveSharedPreference.getSenha(context);

        AsyncCallWSAprova asyncTaskReprova = (AsyncCallWSAprova) new AsyncCallWSAprova(new AsyncCallWSAprova.AsyncRespostaAprova() {

            @Override
            public void processFinish(ArrayList result) {

                proDialog.dismiss();

                if (result.get(0).equals("0")) {

                    String tituloCamposObrigatorios = "";
                    String mensagemCamposObrigatorios = "";

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloCamposObrigatorios, mensagemCamposObrigatorios);

                }

                if (result.get(0) == "ERROWeb") {

                    String tituloTimeOut = "Timeout";
                    String mensagemTimeOut = "Erro timeoout";

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloTimeOut, mensagemTimeOut);
                }

                String erroApontamento = "";
                String vpesquisa = result.get(0).toString();

                if (vpesquisa.contains("1A")) {
                    erroApontamento = "1A";
                }
                if (vpesquisa.contains("1B")) {
                    erroApontamento = "1B";
                }

                if (vpesquisa.contains("1C")) {
                    erroApontamento = "1C";
                }

                if (erroApontamento == "1A") {

                    String tituloErroCfEmitido = "Erro CF Emitido";
                    String mensagemCfEmitido = "MSg erro CF emitido";

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloErroCfEmitido, mensagemCfEmitido);

                }

                if (erroApontamento == "1C") {

                    String tituloErroFerias = "Erro Ferias";
                    String mensagemErroFerias = "Msg Erro ferias";

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloErroFerias, mensagemErroFerias);
                }


                if (erroApontamento == "1B") {

                    String tituloErroConflitoHorario = "Erro conflito horario";
                    String mensagemErroConflitoHorario = "MSg Erro conflito horario";

                    MontaDialogAlert montaDialogAlert = new MontaDialogAlert();
                    montaDialogAlert.montar(context, tituloErroConflitoHorario, mensagemErroConflitoHorario);
                }

                String vsucesso = result.get(0).toString();

                if (vsucesso.contains("1S")) {
                    vsucesso = "1S";
                }

                if (vsucesso.equals("1S")) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Apontamento enviado sucesso");
                    alert.setCancelable(false);
                    if(modoEnvio.equals("aprovacao")) {
                        alert.setMessage("Apontamento enviado sucesso");
                    }else{
                        alert.setMessage("Apontamento salvo sucesso");

                    }
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
        }).execute(parametroAprova, vUser, vSenha);

    }
}



