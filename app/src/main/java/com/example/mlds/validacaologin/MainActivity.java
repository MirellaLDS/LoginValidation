package com.example.mlds.validacaologin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText editLogin;
    EditText editSenha;
    Button btnAcessar;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        //Com esta alteração, a interface OnClickListener() ficara "ouvindo" as ações de click do usuário, e chamará o método onClick() definido no segundo passo.
        btnAcessar.setOnClickListener(this);
        btnSalvar.setOnClickListener(this);

//        btnAcessar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (editLogin.getText().length() == 0 || editSenha.getText().length() == 0) {
//                    Toast.makeText(getApplication(), "Os campos Login e Senha são obrigatórios", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplication(), "Senha bem vindo! " + editLogin.getText().toString() + "!", Toast.LENGTH_LONG).show();
//                    editLogin.setText("");
//                    editSenha.setText("");
//                }
//            }
//        });
    }

    boolean CamposValidados;
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case (R.id.btnAcessar):
                //Regra de negocio btnAcessar
                CamposValidados = true;
                //Validar o campo login
                if (editLogin.getText().length() == 0 || editSenha.getText().length() == 0) {
                    Toast.makeText(getApplication(), "Os campos Login e Senha são obrigatórios", Toast.LENGTH_LONG).show();
                    CamposValidados = false;
                } else {
                    Toast.makeText(getApplication(), "Senha bem vindo! " + editLogin.getText().toString() + "!", Toast.LENGTH_LONG).show();
                    CamposValidados = false;
                    editLogin.setText("");
                    editSenha.setText("");
                }

                if(CamposValidados){
                    btnSalvar.setEnabled(true);
                }else{
                    Toast.makeText(getApplication(), "Dados Inválidos", Toast.LENGTH_LONG).show();
                }
                break;
            case (R.id.btnSalvar):
                ///Regra de negocio btnSalvar
                break;
        }
    }

}
