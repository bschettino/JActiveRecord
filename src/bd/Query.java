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

/**
 *
 * @author Schettino
 */
public class Query {

    protected static final String DROP_TABLE = " DROP TABLE ";
    protected static final String DROP_SCHEMA = " DROP SCHEMA ";
    protected static final String IF_EXISTS = " IF EXISTS ";
    protected static final String CREATE_TABLE = " CREATE TABLE ";
    protected static final Class<?>[] TIPOS_COLUNAS_BD = new Class<?>[]{int.class, String.class, Date.class, BigDecimal.class};
    protected static final String[] CAMPOS_DEFAULT = new String[]{"id", "dataCriacao", "ultimaAtualizacao"};
    private static final String CAMPOS_DEFAULT_CREATE_TABLE = "id int not null auto_increment,\n data_criacao date not null,\n ultima_atualizacao date not null,\n";

    static String underscore(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                "(?<=[A-Z])(?=[A-Z][a-z])",
                "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"),
                "_");
    }

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
    
    public static String dropSchema(String schema) {
            return DROP_SCHEMA + IF_EXISTS + schema + ";";
    }

    private static String campoCreateTable(ColunaBD coluna) {

        if (coluna.getTipo().equals(String.class.getName())) {
            return coluna.getNome() + " varchar(256),\n";
        } else if (coluna.getTipo().equals(int.class.getName())) {
            return coluna.getNome() + " int,\n";
        } else if (coluna.getTipo().equals(Date.class.getName())) {
            return coluna.getNome() + " date,\n";
        } else if (coluna.getTipo().equals(BigDecimal.class.getName())) {
            return coluna.getNome() + " decimal,\n";
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
        tabela +="s";
        
       return ",\n foreign key (" + key + ") references " + tabela + "(id)";
    }

    public static String createTable(String tableName, List<ColunaBD> columns, List<String> foreignKeys) {
        String query = CREATE_TABLE;
        query += tableName + "(\n ";
        query += CAMPOS_DEFAULT_CREATE_TABLE;

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

    public static String createTable(Class classe) {
        String [] splitAux = classe.getName().split("\\.");
        
        String tableName = underscore(splitAux[splitAux.length - 1]).toLowerCase() + "s";
        Field[] campos = classe.getDeclaredFields();
        ArrayList<ColunaBD> colunas = new ArrayList<ColunaBD>();
        ArrayList<String> foreignKeys = new ArrayList<String>();
        for (int i = 0; i < campos.length; i++) {
            Field campo = campos[i];
            boolean isDefault = false;
            for (int j = 0; (j < CAMPOS_DEFAULT.length) && (isDefault == false); j++) {
                String aux = CAMPOS_DEFAULT[j];
                if (campo.getName().equals(aux)) {
                    isDefault = true;
                }
            }
            if (!isDefault) {
                boolean isCampoBD = false;
                for (int j = 0; (j < TIPOS_COLUNAS_BD.length) && (isCampoBD == false); j++) {
                    Class<?> aux = TIPOS_COLUNAS_BD[j];
                    if (campo.getType().equals(aux)) {
                        isCampoBD = true;
                    }
                }
                if (isCampoBD) {
                    String coluna = underscore(campo.getName()).toLowerCase();
                    colunas.add(new ColunaBD(campo.getType().getName(), coluna));
                    String[] split = coluna.split("_");
                    if (split.length > 1 && split[split.length - 1].equals("id")) {
                        foreignKeys.add(coluna);
                    }
                }
            }
        }
        return createTable(tableName, colunas, foreignKeys);
    }
}
