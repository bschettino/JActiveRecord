/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.Date;

/**
 *
 * @author Schettino
 */
public class DateHelper {

    public static String stringfy(Date date) {
        if (date == null) {
            return "";
        } else {
            String[] data_array = date.toString().split("-");
            String data = data_array[2];
            data += "/" + data_array[1];
            data += "/" + data_array[0];
            return data;
        }
    }
}
