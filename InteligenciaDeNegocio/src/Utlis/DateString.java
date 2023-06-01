package Utlis;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class DateString {

public static Calendar StringToDate( String date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
    try {
        Calendar dt = Calendar.getInstance();
        dt.setTime(format.parse(date));
        return dt;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
}

public static String DateToString( Calendar date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
    try {
        String dt = format.format(date);
        return dt;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

public static Date StringToDateSQL( String date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
    Date dt;
    try {
        dt = new Date(format.parse(date).getTime());
        return dt;
    } catch (ParseException ex) {
        Logger.getLogger(DateString.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

public static String DateSQLToString( Date date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
    try {
        String dt = format.format(date);
        return dt;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    


public static Calendar StringToDateTime( String date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    try {
        Calendar dt = Calendar.getInstance();
        dt.setTime(format.parse(date));
        return dt;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
}

public static String DateTimeToString( Calendar date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    try {
        String dt = format.format(date);
        return dt;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    
public static Timestamp StringToDateTimeSQL( String date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    try {
        Timestamp ts;
        ts = new Timestamp(format.parse(date).getTime());
        return ts;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

public static String DateTimeSQLToString( Timestamp date){
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    try {
        String dt = format.format(date);
        return dt;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    
public static String StringToDateActual(){
        // Crear un formato para la fecha
    SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    
    Date currentDate = new Date();
    // Obtener la fecha actual formateada
    String formattedDate = format.format(currentDate);
    System.out.println("DH Actual "+formattedDate);
    return formattedDate;
}



public static Date String_To_Date( String date){
    Calendar c = StringToDate(date);
    Date x = c.getTime();
      System.out.println(x);      
    return x;
}
public static Date String_To_DateTime( String date){
    Calendar c = StringToDateTime(date);
    Date x = c.getTime();
      System.out.println(x);      
    return x;
}


}
