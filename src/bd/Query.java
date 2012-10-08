/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import helpers.StringHelper;
import java.util.Calendar;

/**
 *
 * @author Schettino
 */
public class Query {

    protected static final String DROP_TABLE = "DROP TABLE ";
    protected static final String DROP_SCHEMA = "DROP SCHEMA ";
    protected static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS ";
    protected static final String IF_EXISTS = " IF EXISTS ";
    protected static final String CREATE_TABLE = "CREATE TABLE ";
    protected static final String INSERT = "INSERT INTO ";
    protected static final String VALUES = " VALUES ";
    protected static final Class<?>[] TIPOS_COLUNAS_BD = new Class<?>[]{int.class, String.class, Date.class, BigDecimal.class};
    protected static final String[] CAMPOS_DEFAULT_CREATE = new String[]{"id", "dataCriacao", "ultimaAtualizacao"};
    protected static final String[] CAMPOS_DEFAULT_INSERT = new String[]{"dataCriacao", "ultimaAtualizacao"};
    private static final String QUERY_CAMPOS_DEFAULT_CREATE = "id int not null auto_increment,\n data_criacao datetime not null,\n ultima_atualizacao datetime not null,\n";
    private static final java.text.SimpleDateFormat DateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String dropTable(String table, boolean checkExists) {
        if (checkExists) {
            return DROP_TABLE + IF_EXISTS + table + ";";
        } else {
            return DROP_TABLE + table + ";";
        }
    }

    public static String dropTable(String table) {
        return dropTable(table, true);
    }

    public static String dropSchema(String schema, boolean checkExists) {
        if (checkExists) {
            return DROP_SCHEMA + IF_EXISTS + schema + ";";
        } else {
            return DROP_SCHEMA + schema + ";";
        }
    }

    public static String dropSchema(String schema) {
        return dropSchema(schema, true);
    }

    private static String campoCreateTable(ColunaBD coluna) {

        if (coluna.getTipo().equals(String.class.getName())) {
            return " " + coluna.getNome() + " varchar(256),\n";
        } else if (coluna.getTipo().equals(int.class.getName())) {
            return " " + coluna.getNome() + " int,\n";
        } else if (coluna.getTipo().equals(Date.class.getName())) {
            return " " + coluna.getNome() + " datetime,\n";
        } else if (coluna.getTipo().equals(BigDecimal.class.getName())) {
            return " " + coluna.getNome() + " decimal,\n";
        }

        return "";
    }

    private static String foreignKey(String key) {
        String[] split = key.split("_");
        String tabela = split[0];
        if (split.length > 2) {
            for (int i = 1; i < split.length - 1; i++) {
                tabela += "_" + split[i];
            }
        }
        tabela += "s";

        return ",\n foreign key (" + key + ") references " + tabela + "(id)";
    }

    public static String createTable(String tableName, List<ColunaBD> columns, List<String> foreignKeys) {
        String query = CREATE_TABLE;
        query += tableName + "(\n ";
        query += QUERY_CAMPOS_DEFAULT_CREATE;

        for (int i = 0; i < columns.size(); i++) {
            ColunaBD column = columns.get(i);
            query += campoCreateTable(column);
        }
        query += " primary key(id)";


        for (int i = 0; i < foreignKeys.size(); i++) {
            String key = foreignKeys.get(i);
            query += foreignKey(key);
        }
        return query + "\n );";
    }

    private static boolean isCampoBD(Field field) {
        boolean isDefault = false;
        for (int j = 0; (j < CAMPOS_DEFAULT_CREATE.length) && (isDefault == false); j++) {
            String aux = CAMPOS_DEFAULT_CREATE[j];
            if (field.getName().equals(aux)) {
                isDefault = true;
            }
        }
        if (isDefault) {
            return false;
        } else {
            boolean isCampoBD = false;
            for (int j = 0; (j < TIPOS_COLUNAS_BD.length) && (isCampoBD == false); j++) {
                Class<?> aux = TIPOS_COLUNAS_BD[j];
                if (field.getType().equals(aux)) {
                    isCampoBD = true;
                }
            }
            return isCampoBD;
        }
    }

    public static String createTable(Class klass) {
        String[] splitAux = klass.getName().split("\\.");

        String tableName = StringHelper.underscore(splitAux[splitAux.length - 1]) + "s";
        Field[] campos = klass.getDeclaredFields();
        ArrayList<ColunaBD> colunas = new ArrayList<ColunaBD>();
        ArrayList<String> foreignKeys = new ArrayList<String>();
        for (int i = 0; i < campos.length; i++) {
            Field campo = campos[i];
            if (isCampoBD(campo)) {
                String coluna = StringHelper.underscore(campo.getName());
                colunas.add(new ColunaBD(campo.getType().getName(), coluna));
                String[] split = coluna.split("_");
                if (split.length > 1 && split[split.length - 1].equals("id")) {
                    foreignKeys.add(coluna);
                }
            }
        }
        return createTable(tableName, colunas, foreignKeys);
    }

    public static String insert(Object obj) {
        Class<?> klass = obj.getClass();
        String query = INSERT;

        String[] splitAux = klass.getName().split("\\.");

        String tableName = StringHelper.underscore(splitAux[splitAux.length - 1]) + "s";

        query += tableName + " (";

        ArrayList<String> values = new ArrayList<String>();

        Field[] campos = klass.getDeclaredFields();
        for (int i = 0; i < campos.length; i++) {
            Field campo = campos[i];
            if (isCampoBD(campo)) {
                String coluna = StringHelper.underscore(campo.getName());
                try {
                    java.lang.reflect.Method getAttr;
                    getAttr = obj.getClass().getMethod("get" + StringHelper.capitalize(campo.getName(), true));
                    values.add(getAttr.invoke(obj).toString());
                    query += coluna + ", ";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < CAMPOS_DEFAULT_INSERT.length; i++) {
            String campo = CAMPOS_DEFAULT_INSERT[i];
            query += StringHelper.underscore(campo);
            if (i < CAMPOS_DEFAULT_INSERT.length - 1) {
                query += ", ";
            }



            String currentTime = DateTime.format(Calendar.getInstance().getTime());

            values.add(currentTime);
        }

        query += ") " + VALUES + " (";

        for (int j = 0; j < values.size(); j++) {
            String value = values.get(j);
            query += "'" + value + "'";
            if (j < values.size() - 1) {
                query += ", ";
            }
        }

        query += ");";

        return query;
    }
}
