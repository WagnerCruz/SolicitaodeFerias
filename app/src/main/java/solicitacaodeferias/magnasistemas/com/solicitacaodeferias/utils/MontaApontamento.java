package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import com.magna.sistemas.timesheetv2.getters.ItemListView;

import java.util.ArrayList;

/**
 * Created by --Luan- on 08/07/2016.
 */
public class MontaApontamento {

    public ArrayList MontaApontamento(ArrayList<String> DetalhesFunc, ArrayList itens){

        itens = new ArrayList<ItemListView>();
        int i = 0;
        for (int x = 0; x < DetalhesFunc.size(); x++) {
            i = i + 1;
            if (i == 24) {
                String OPORTUNIDADE = DetalhesFunc.get(x - 3);
                String TIPO_DE_AUSENCIA = DetalhesFunc.get(x - 4);
                String HORAEXTRA = DetalhesFunc.get(x - 8);
                String TotalHoras = DetalhesFunc.get(x - 9);
                String Desconto = DetalhesFunc.get(x - 10);
                String HFIMAPONTA = DetalhesFunc.get(x - 11);
                String HINIAPONTA = DetalhesFunc.get(x - 12);
                String DTAPONTA = DetalhesFunc.get(x - 13);
                String SUBATIVIDADE = DetalhesFunc.get(x - 14);
                String ATIVIDADE = DetalhesFunc.get(x - 15);
                String AREAMOBILE = DetalhesFunc.get(x - 16);
                String OS = DetalhesFunc.get(x - 17);
                String PROJETO = DetalhesFunc.get(x - 18);
                String CLIENTE = DetalhesFunc.get(x - 19);
                String TIPO = DetalhesFunc.get(x - 20);
                String NOMEFUNC = DetalhesFunc.get(x - 21);
                String NOMEAPROVA = DetalhesFunc.get(x - 22);
                String IDDOC = DetalhesFunc.get(x - 23);
                String HISTORICO = DetalhesFunc.get(x - 2);
                String DIASEGUINTE = DetalhesFunc.get(x - 1);
                String STATUS = DetalhesFunc.get(x - 6);
                String ATIVIDADES = DetalhesFunc.get(x - 5);
                String PED_ALTERA = DetalhesFunc.get(x - 7);
                String FERIADO = DetalhesFunc.get(x - 0);



                ItemListView Func = new ItemListView(NOMEFUNC,DTAPONTA, HINIAPONTA, HFIMAPONTA,
                        ATIVIDADES, TIPO_DE_AUSENCIA, TotalHoras, Desconto,
                        SUBATIVIDADE, AREAMOBILE, ATIVIDADE, OS, PROJETO,
                        TIPO, NOMEAPROVA, CLIENTE, IDDOC, HORAEXTRA, DIASEGUINTE, STATUS, OPORTUNIDADE, HISTORICO, PED_ALTERA, FERIADO);

                itens.add(Func);
                i = 0;
            }
        }


        return itens;
    }

}
