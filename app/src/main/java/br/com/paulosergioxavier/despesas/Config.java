package br.com.paulosergioxavier.despesas;

/**
 * Created by Serginhu on 29/11/2016.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Config extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.configuracoes);

    }
}