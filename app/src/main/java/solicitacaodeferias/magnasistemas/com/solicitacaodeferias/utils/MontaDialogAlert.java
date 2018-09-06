package solicitacaodeferias.magnasistemas.com.solicitacaodeferias.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by --Luan- on 13/07/2016.
 */
public class MontaDialogAlert {

    public void montar(Context context, String titulo, String mensagem){


        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(titulo);
        alert.setMessage(mensagem);

                alert.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alert.show();

    }
}
