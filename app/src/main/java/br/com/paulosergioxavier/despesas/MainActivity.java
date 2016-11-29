package br.com.paulosergioxavier.despesas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, cad_despesa.class);
                startActivity(it);
            }
        });

        carregaDados();
        showUserSettings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent it = new Intent(this, Config.class);
            startActivityForResult(it,RESULT_SETTINGS);
        }

//        return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RESULT_SETTINGS:
                showUserSettings();
                break;
        }
    }

    private void showUserSettings() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n Username: "+ sharedPrefs.getString("prefNome", "NULL"));

        builder.append("\n Send report:"+ sharedPrefs.getBoolean("prefMostraNotficacao", true));

//        TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);

//        settingsTextView.setText(builder.toString());
    }

    protected void carregaDados() {
        DespesaController crud = new DespesaController(getBaseContext());
        Cursor cursor = crud.listar();
        String[] nomeCampos = new String[]{Banco.VALOR, Banco.DESCRICAO};
        int[] idViews = new int[]{R.id.txtListValor, R.id.txtListDescricao};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.content_main, cursor, nomeCampos, idViews, 0);

        lista = (ListView) findViewById(R.id.listaDespesas);
        lista.setAdapter(adaptador);

    }
}
