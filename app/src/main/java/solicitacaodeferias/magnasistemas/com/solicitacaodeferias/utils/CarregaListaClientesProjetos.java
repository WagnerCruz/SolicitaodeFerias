package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by --Luan- on 08/07/2016.
 */

public class CarregaListaClientesProjetos {

    public CarregaListaClientesProjetos(ArrayList<String> DetalhesFunc, Context context, ListView listView, final AutoCompleteTextView autoCompleteTextView) {

        final ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,DetalhesFunc   );
        listView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setDropDownHeight(0);
    }
}
