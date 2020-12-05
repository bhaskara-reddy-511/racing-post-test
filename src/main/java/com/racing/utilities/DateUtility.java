package com.racing.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    /**+
     *  @type: Method
     *  @Usage: This will return the current date in the requested format
     *  @parameters: String
     *  @return: String
     */
    public static String getCurrentDateInSpecificFormat(String dateFormat){
        SimpleDateFormat formatDae = new SimpleDateFormat(dateFormat);
        return formatDae.format(new Date());
    }

    /**+
     *  @type: Method
     *  @Usage: This will Compare the passed dates and return integer
     *   >0: date1 is greater than date2
     *   <0: date1 is less than date2
     *   =0: date1 is equal to date2
     *  @parameters: String, String
     *  @return: int
     */
    public static int compareDates(String date1,String date2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy");
        Date parsedDate1 = dateFormat.parse(date1);
        Date parsedDate2 = dateFormat.parse(date2);
        return parsedDate1.compareTo(parsedDate2);
    }
}
