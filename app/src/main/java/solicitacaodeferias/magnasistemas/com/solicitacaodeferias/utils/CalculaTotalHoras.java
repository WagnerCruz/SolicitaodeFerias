package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * Created by --Luan- on 20/05/2016.
 */
public class CalculaTotalHoras {


    public CalculaTotalHoras() {


    }

    public static String myresult(String hi, String hf, String ds) throws ParseException {

        String tempozero = "24:00";
        String tempoinicio = hi;
        String tempofim = hf;

        String horainicio ;
        String minutoinicio;
        String horafim ;
        String minutofim;

        double horafinal;
        String horazero;

        horazero = tempozero.substring(0,2);
        horainicio = tempoinicio.substring(0,2);
        minutoinicio = tempoinicio.substring(3,5);
        horafim = tempofim.substring(0,2);
        minutofim = tempofim.substring(3,5);

        double CalculoA; double CalculoB; double CalculoTotal; double CalculoZ;
        double ZH = Integer.parseInt(horazero); // hora inicio
        double AH = Integer.parseInt(horainicio); // hora inicio
        double AM = Integer.parseInt(minutoinicio); // minuto inicio
        double BH = Integer.parseInt(horafim); // hora fim
        double BM = Integer.parseInt(minutofim); // minuto fim

        CalculoZ = (ZH * 3600);
        CalculoA = (AH * 3600) + (AM * 60); // transformando Hora e Minuto em Segundos
        CalculoB = (BH * 3600) + (BM * 60); // transformando Hora e Minuto em Segundos

        //Verifica se a opção "As atividades excederam até o dia seguinte"

            if (ds == "Sim"){
                    CalculoA = CalculoA - CalculoZ;
            }

        CalculoTotal = (CalculoB - CalculoA); // calculando a quantidade de minutos (subtraindo)

        horafinal = ((CalculoTotal / 60)/60);

            BigDecimal bd = new BigDecimal(horafinal);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);



            String horafinalSTR = String.valueOf(bd);

            int posicao = horafinalSTR.indexOf(".");

        if(horafinalSTR.length() >= 5 ){
            horafinalSTR = horafinalSTR.substring(0, posicao) + "," + horafinalSTR.substring(posicao + 1,5);

        }else{
            horafinalSTR = horafinalSTR.substring(0, posicao) + "," + horafinalSTR.substring(posicao + 1,4);

        }



        return horafinalSTR;


    }
}