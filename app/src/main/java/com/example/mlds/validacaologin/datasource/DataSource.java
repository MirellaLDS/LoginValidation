package com.example.mlds.validacaologin.datasource;

/**
 * Created by mlds on 05/04/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mlds.validacaologin.datamodel.DataModel;


/**
 * Created by maddo on 03/05/15.
 */
public class DataSource extends SQLiteOpenHelper{

    SQLiteDatabase db;

    public DataSource(Context context) {

        super(context, DataModel.getDB_NAME(), null, 1);

        db = this.getReadableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataModel.criarTabelaLogin());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        onCreate(db);

    }

    /**
     * Método persiste - Incluir ou alterar os dados no Banco de Dados
     * Caso o ID seja nulo ou zero, será executado o método insert().
     * Caso contrário, será executado o método update().
     * @param values
     * @param tabela
     */
    public void persist(ContentValues values, String tabela) {

        if (values.containsKey("id") && values.getAsInteger("id") != null
                && values.getAsInteger("id") != 0) {
            Integer id = values.getAsInteger("id");
            db.update(tabela, values, "id = " + id, null);
        } else {

            db.insert(tabela, null, values);

        }

    }

    /**
     * Método find utilizado para persquisar dados em qualquer tabela do banco
     * de dados local conforme os parâmetros informados.
     *
     * Retorna um DataSet com o resultado da busca.
     *
     * @return retorno
     *
     */
    public Cursor find(String tabela, String[] columns, String selection,
                       String[] selectionArgs, String groupBy, String having,
                       String orderBy, String limit) {
        Cursor retorno = db.query(tabela, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);

        return retorno;
    }
}
