package br.com.goldencode.appdegastos;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParseException;

import faranjit.currency.edittext.CurrencyEditText;

public class LoginActivity extends AppCompatActivity {

    private EditText editNome, editSobrenome;
    private CurrencyEditText editSaldoInicial;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editSaldoInicial = findViewById(R.id.edtSaldoInicial);

        editNome = findViewById(R.id.edtNome);
        editSobrenome = findViewById(R.id.edtSobrenome);
        mRelativeLayout = findViewById(R.id.mRelativeLayout);


        Button buttonContinuar = findViewById(R.id.btnContinuar);
        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validarCampos()){

                    String nome = editNome.getText().toString();
                    String sobrenome = editSobrenome.getText().toString();

                    try {

                        double teste = editSaldoInicial.getCurrencyDouble();

                        String aaa = String.valueOf(editSaldoInicial.getCurrencyDouble());

                        NumberFormat nf = NumberFormat.getCurrencyInstance();

                        String teste2 = nf.format(teste);

                        Toast.makeText(LoginActivity.this, "Teste, "+aaa, Toast.LENGTH_LONG).show();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    validarCampos();
                }

            }
        });

    }

    private boolean validarCampos() {
        if (editNome.getText().toString().isEmpty()){
            if (mRelativeLayout.getVisibility() == View.GONE){
                mRelativeLayout.setVisibility(View.VISIBLE);
            }
            return false;
        }
        if (editSobrenome.getText().toString().isEmpty()){
            if (mRelativeLayout.getVisibility() == View.GONE){
                mRelativeLayout.setVisibility(View.VISIBLE);
            }
            return false;
        }
        if (editSaldoInicial.getText().toString().isEmpty()){
            if (mRelativeLayout.getVisibility() == View.GONE){
                mRelativeLayout.setVisibility(View.VISIBLE);
            }
            return false;
        }
        return true;
    }

    public void fecharMensagem(View v){
        mRelativeLayout.setVisibility(View.GONE);
    }

}
