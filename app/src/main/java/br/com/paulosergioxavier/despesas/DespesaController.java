package br.com.paulosergioxavier.despesas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        long resultado;
        String retorno;
        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();
        String dataCadastro = DateFormat.getDateInstance().format(new Date());

        valores.put(Banco.VALOR, valor);
        valores.put(Banco.DESCRICAO,descricao);
        valores.put(Banco.RECORRENTE, recorrente);
        valores.put(Banco.DATACADASTRO,dataCadastro);

        resultado = db.insert(banco.TABELA, null, valores);
        db.close();

        if(resultado == -1){
            retorno = "Erro ao inserir";
        }else{
            retorno = "Inserido com sucesso!";
        }

        return retorno;
    }
}
