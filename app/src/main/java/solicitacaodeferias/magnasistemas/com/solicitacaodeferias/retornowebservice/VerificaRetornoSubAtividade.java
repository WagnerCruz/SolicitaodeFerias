package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWSPreencherSubAtividade;

import java.util.ArrayList;

/**
 * Created by --Luan- on 20/07/2016.
 */
public class VerificaRetornoSubAtividade {

    boolean esconderOs = false;

    public boolean VerificaRetornoSubAtividade(String parametroClienteProjeto){


        AsyncCallWSPreencherSubAtividade buscarOs = (AsyncCallWSPreencherSubAtividade) new AsyncCallWSPreencherSubAtividade(new AsyncCallWSPreencherSubAtividade.AsyncResposta() {

            @Override
            public void processFinish(ArrayList result) {

                if (result.size() == 0) {

                    esconderOs = true;

                }else{

                    esconderOs = false;

                }

            }

        }).execute(parametroClienteProjeto);

        return esconderOs;

    }

}
