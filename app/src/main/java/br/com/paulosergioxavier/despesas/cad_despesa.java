package br.com.paulosergioxavier.despesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class cad_despesa extends AppCompatActivity {

boolean recorrente = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnSalvar = (Button) findViewById(R.id.btn_cadastrarDespesa);
        setContentView(R.layout.activity_cad_despesa);

        EditText txtDescricao = (EditText) findViewById(R.id.txt_nomeDespesa);
        EditText txtValor = (EditText) findViewById(R.id.txt_nomeDespesa);
        CheckBox chkRecorrente = (CheckBox) findViewById(R.id.txt_recorrente);

        chkRecorrente.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton b, boolean isChecked){

            }
        });

        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v){

    }
}