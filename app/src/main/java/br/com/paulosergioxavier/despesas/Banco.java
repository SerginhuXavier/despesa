package br.com.paulosergioxavier.despesas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Serginhu on 27/11/2016.
 */
public class Banco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "despesas";
    public static final String ID = "_id integer primary key autoincrement";
    public static final String VALOR = "valor float(10,2) not null";
    public static final String DESCRICAO = "descricao text not null";
    public static final String RECORRENTE = "recorrente tinyint(1)";
    public static final String DATACADASTRO = "dataCadastro datetime";
    private static final int VERSAO = 1;

    public Banco(Context ct){
        super(ct, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABELA+"("+ID+","+VALOR+","+DESCRICAO+","+RECORRENTE+","+DATACADASTRO+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TABELA+";");
        onCreate(db);
    }
}
