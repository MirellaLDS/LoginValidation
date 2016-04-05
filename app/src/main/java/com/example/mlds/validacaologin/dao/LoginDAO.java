package com.example.mlds.validacaologin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.example.mlds.validacaologin.MainActivity;
import com.example.mlds.validacaologin.datamodel.DataModel;
import com.example.mlds.validacaologin.datasource.DataSource;
import com.example.mlds.validacaologin.model.Login;

/**
 * Created by mlds on 05/04/2016.
 */
public class LoginDAO {

    DataSource ds;
    ContentValues values;

    public LoginDAO(Context context){
        ds = new DataSource(context);
    }

    public boolean adicionar(Login obj){

        boolean retorno = false;

        values = new ContentValues();

        values.put(DataModel.getLOGIN(),obj.getLogin());
        values.put(DataModel.getSENHA(),obj.getSenha());

        try {
            ds.persist(values,DataModel.getTABELA_LOGIN());
            retorno = true;
        }catch (Exception e){
        }

        return retorno;
    }
}
