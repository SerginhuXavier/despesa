package br.com.paulosergioxavier.despesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class cad_despesa extends AppCompatActivity {

    boolean recorrente = false;
    private CheckBox chkRecorrente;
    private EditText txtValor;
    private EditText txtDescricao;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnSalvar = (Button) findViewById(R.id.btn_cadastrarDespesa);
        setContentView(R.layout.activity_cad_despesa);

        txtDescricao = (EditText) findViewById(R.id.txt_nomeDespesa);
        txtValor = (EditText) findViewById(R.id.txt_nomeDespesa);
        chkRecorrente = (CheckBox) findViewById(R.id.txt_recorrente);

        chkRecorrente.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton b, boolean isChecked){
                recorrente = isChecked;
            }
        });

    }

    public void salvarDespesa(View v){
        DespesaController crud = new DespesaController(getBaseContext());
        String resultado;
        double campoValor = Double.valueOf(txtValor.getText().toString()).doubleValue();
        String campoDescricao = txtDescricao.getText().toString();
        int campoRecorrente = (recorrente) ? 1 : 0;

        resultado = crud.inserir(campoValor,campoDescricao,campoRecorrente);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }
}