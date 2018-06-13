package solicitacaodeferias.magnasistemas.com.solicitacaodeferias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView autor;
    private TextView dtAtual;
    private TextView Status;

    private TextView nomesolic;
    private TextView nomesup;
    private TextView idnotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autor = findViewById(R.id.idAutor);
        dtAtual = findViewById(R.id.idData);
        Status = findViewById(R.id.idStatus);

        nomesolic = findViewById(R.id.idSolicitante);
        nomesup = findViewById(R.id.idSuperior);
//        idnotes = findViewById(R.id.)

        autor.setText("Wagner Cruz");
        dtAtual.setText("15/05/2018");
        Status.setText("Rascunho");

        nomesolic.setText(autor.getText());
        nomesup.setText("Superior Teste");


    }
}
