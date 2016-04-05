package com.example.mlds.validacaologin.datamodel;

/**
 * Created by mlds on 05/04/2016.
 */
public class DataModel {

    private static final String DB_NAME = "db_curso_android.sqlite";
    private static final String TABELA_LOGIN = "login";
    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final String TIPO_TEXTO = "TEXT";
    private static final String TIPO_INTEIRO = "INTEGER";
    private static final String TIPO_INTEIRO_PK = "INTEGER PRIMARY KEY ";

    public static String criarTabelaLogin() {

        String query = "CREATE TABLE " + getTABELA_LOGIN();

        query += " (";
        query += getID() + " " + TIPO_INTEIRO_PK + ", ";
        query += getLOGIN() + " " + TIPO_TEXTO + ", ";
        query += getSENHA() + " " + TIPO_TEXTO + " ";
        query += ")";

        return query;
    }

    public static String getDB_NAME() {
        return DB_NAME;
    }

    public static String getTABELA_LOGIN() {
        return TABELA_LOGIN;
    }

    public static String getID() {
        return ID;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getSENHA() {
        return SENHA;
    }
}
