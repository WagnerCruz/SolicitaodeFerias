package solicitacaodeferias.magnasistemas.com.solicitacaodeferias;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView autor;
    private TextView dtAtual;
    private TextView Status;
    private TextView nomesolic;
    private TextView nomesup;
    private TextView idnotes;
    private TextView dtinicio;
    private TextView dtfim;
    private Spinner qtdedias;
    private String[] dias;
    private Button botao_ws;

    private Calendar calendario;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(android.R.layout.activity_main);
        setContentView(R.layout.activity_main);

        autor = findViewById(R.id.idAutor);
        dtAtual = findViewById(R.id.idData);
        Status = findViewById(R.id.idStatus);

        nomesolic = findViewById(R.id.idSolicitante);
        nomesup = findViewById(R.id.idSuperior);
        dtinicio = findViewById(R.id.idTxtDtInicio);
        dtfim = findViewById(R.id.idTxtDtFim);
        qtdedias = findViewById(R.id.idSpinQtdeDias);
        botao_ws = findViewById(R.id.idBtnWS);

        String[] dias = new String[]{"0","10","15","20","30"};


//        idnotes = findViewById(R.id.)

        autor.setText("Wagner Cruz");
        dtAtual.setText("15/05/2018");
        Status.setText("Rascunho");

        nomesolic.setText(autor.getText());
        nomesup.setText("Superior Teste");

         ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                 android.R.layout.simple_spinner_item,dias);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtdedias.setAdapter(adapter);
        calendario = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener  date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                calendario.set(Calendar.YEAR, view.getYear());
                calendario.set(Calendar.MONTH+1, view.getMonth());
                calendario.set(Calendar.DAY_OF_MONTH, view.getDayOfMonth());

                //calendario.set(ano, mes, dia);
//                datainicio(view);

                int messelec = view.getMonth()+1;
                int numdias = Integer.parseInt(qtdedias.getSelectedItem().toString());
                dtinicio.setText(view.getDayOfMonth()+"/"+messelec+"/"+view.getYear());

                calendario.add(Calendar.DATE, numdias);

                int mesfim = calendario.get(Calendar.MONTH)+1;
                dtfim.setText(calendario.get(Calendar.DAY_OF_MONTH) + "/" + mesfim + "/" + calendario.get(Calendar.YEAR));
                String msg_erro = validaData();
                alerta("erro", msg_erro);
            }

        };

        dtinicio.setText("");
        dtinicio.setShowSoftInputOnFocus(false);
        dtinicio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        botao_ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valores = chamarws();
                alerta("Teste",valores);
            }
        });

    }
/*
    private void datainicio(DatePicker view){

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String dataformatada = sdf.format(calendario.getTime());
        String dataformatada = String.valueOf(calendario.getTime());
        calendario.add(Calendar.DATE, 20);
        String datafim = String.valueOf(calendario.getTime());

        int messelec = view.getMonth()+1;
        int mesfim = calendario.get(Calendar.MONTH)+1;
        dtinicio.setText(view.getDayOfMonth()+"/"+messelec+"/"+view.getYear());
        dtfim.setText(calendario.get(Calendar.DAY_OF_MONTH) + "/" + mesfim + "/" + calendario.get(Calendar.YEAR));


    }
    */

    private void alerta(String titulo, String mensagem){

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(titulo)
                .setMessage(mensagem)
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //ok
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    private String validaData(){

        String erro = "Erro";


        return erro;
    };

    private String chamarws(){

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String erro = "";
        try {
            URL url = new URL("http://pokeapi.co/api/v2/pokemon/1/");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha;
            StringBuffer buffer = new StringBuffer();
            while((linha = reader.readLine()) != null) {
                buffer.append(linha);
                buffer.append("\n");
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            erro = e.getMessage();
            System.out.println("Erro: " + erro);
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return erro;
    }






}
