package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.retornowebservice;

import com.magna.sistemas.timesheetv2.chamadasasynctaskws.AsyncCallWSPreencherNumOS;

import java.util.ArrayList;

/**
 * Created by --Luan- on 20/07/2016.
 */
public class VerificaRetornoOs {


    public  VerificaRetornoOs(String parametroProjeto){


        AsyncCallWSPreencherNumOS buscarOs = (AsyncCallWSPreencherNumOS) new AsyncCallWSPreencherNumOS(new AsyncCallWSPreencherNumOS.AsyncResposta() {

            @Override
            public void processFinish(ArrayList result) {
                boolean esconderOs = true;

                if (result.size() == 0) {

                    esconderOs = true;

                }else{

                    esconderOs = false;

                }
            }

        }).execute(parametroProjeto);

    }

}
