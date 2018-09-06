package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.magna.sistemas.timesheetv2.R;
import com.magna.sistemas.timesheetv2.adapters.AdapterListView;
import com.magna.sistemas.timesheetv2.getters.ItemListView;

import java.util.ArrayList;

/**
 * Created by --Luan- on 08/07/2016.
 */
public class CriarActionMenuLongClick {

    public CriarActionMenuLongClick(final AdapterListView adapterListView, final ListView listView, final ArrayList<ItemListView> selectedItens, final Integer vMenu, final ArrayList itens){

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setAdapter(adapterListView);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                final int checkedCount = listView.getCheckedItemCount();
                mode.setTitle((checkedCount + ""));
                adapterListView.getItem(position);
                adapterListView.toggleSelection(position);

                SparseBooleanArray checado = listView.getCheckedItemPositions();
                selectedItens.add(adapterListView.getItem(position));
                //mode.setTag(selectedItens);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(vMenu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                switch (item.getItemId()) {
                    case (R.id.menu_enviar_aprovacao):


                        break;
                }
                return false;
            }


            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

    }

}
