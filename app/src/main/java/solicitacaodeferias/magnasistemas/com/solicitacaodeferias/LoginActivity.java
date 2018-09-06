package solicitacaodeferias.magnasistemas.com.solicitacaodeferias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import solicitacaodeferias.magnasistemas.com.solicitacaodeferias.chamadasasynctaskws.AsyncCallBasicAuthentication;

public class LoginActivity extends AppCompatActivity {

    private TextView usuario;
    private TextView senha;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.idTxtLogin);
        senha = findViewById(R.id.idTxtPwd);
        btLogin = findViewById(R.id.btnLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usuario.getText().toString();
                String password = senha.getText().toString();

                AsyncCallBasicAuthentication authentication = new AsyncCallBasicAuthentication(new AsyncCallBasicAuthentication.AsyncResponse() {
                    @Override
                    public void processFinish(String result) {

                        if (result.equals("false")) {

                            Toast.makeText(LoginActivity.this, "Login não efetuado ou erro no retorno: " + result, Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(LoginActivity.this,"Login efetuado: " + result,Toast.LENGTH_SHORT).show();
                        }

                    }
                });

//                abrirTelaSolicitacao();

            }
        });


    }

    public void abrirTelaSolicitacao() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
