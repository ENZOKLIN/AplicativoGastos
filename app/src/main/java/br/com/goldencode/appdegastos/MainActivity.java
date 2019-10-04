package br.com.goldencode.appdegastos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.TRANSPARENT;
import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvSaldo;
    private TextView tvDespesa;
    private TextView tvDataDespesa;
    private TextView tvValorDespesa;
    private boolean verify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //default true
        verify = true;
        tvNome = findViewById(R.id.tvNome);
        tvSaldo = findViewById(R.id.tvSaldo);
        tvDespesa = findViewById(R.id.tvDespesa);
        tvDataDespesa = findViewById(R.id.tvDataDespesa);
        tvValorDespesa = findViewById(R.id.tvValorDespesa);
        ImageButton imgButtonEsconder = findViewById(R.id.imgBtnEsconder);
        RelativeLayout rLayoutDespesa = findViewById(R.id.rLayoutDespesa);

        rLayoutDespesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Teste", Toast.LENGTH_SHORT).show();
            }
        });

        imgButtonEsconder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //o clique verifica se está true.
                if (verify){
                    //se estiver true, esconde o saldo.
                    esconderSaldo();
                    //depois da checagem ele muda a variavel para false.
                    verify = false;
                } else {
                    //se estiver false, mostra o saldo.
                    mostrarSaldo();
                    //e muda a variável para quando o usuário clicar
                    //novamente, entre na checagem e esconda o saldo.
                    verify = true;
                }

            }
        });

    }

    private void esconderSaldo() {
        tvSaldo.setBackgroundColor(getResources().getColor(R.color.colorMedium));
        tvSaldo.setTextColor(getResources().getColor(R.color.colorMedium));
    }

    private void mostrarSaldo() {
        tvSaldo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tvSaldo.setTextColor(getResources().getColor(R.color.colorWhite));
    }

}
