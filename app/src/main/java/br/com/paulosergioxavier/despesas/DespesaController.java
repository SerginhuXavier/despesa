package br.com.paulosergioxavier.despesas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Serginhu on 27/11/2016.
 */
public class DespesaController {
    private SQLiteDatabase db;
    private Banco banco;

    public DespesaController(Context ctx){
        banco = new Banco(ctx);
    }

    public String inserir(double valor, String descricao, int recorrente){
        long resultado = 0;
        String retorno;
        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();
        String dataCadastro = DateFormat.getDateInstance().format(new Date());

        valores.put(Banco.VALOR, valor);
        valores.put(Banco.DESCRICAO,descricao);
        valores.put(Banco.RECORRENTE, recorrente);
        valores.put(Banco.DATACADASTRO,dataCadastro);

        try {
            resultado = db.insert(banco.TABELA, null, valores);

        }catch (SQLiteException e){
            Log.d("SQL ERROR", "SQLite operate exception!");
            e.printStackTrace();
        }finally {
            db.close();
            if(resultado == -1){
                retorno = "Erro ao inserir";
            }else{
                retorno = "Inserido com sucesso!";
            }
        }

        return retorno;
    }

    public Cursor listar(){
        Cursor cursor;
        String[] campos = {banco.DESCRICAO, banco.VALOR};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }
}
