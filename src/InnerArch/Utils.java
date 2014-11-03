package InnerArch;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Marat on 14.10.2014.
 */
public class Utils {

    private static String GetMonthName( int index )
    {
        switch ( index ) {
            case 1:
                return "Январь";

            case 2:
                return "Февраль";

            case 3:
                return "Март";

            case 4:
                return "Апрель";

            case 5:
                return "Май";

            case 6:
                return "Июнь";

            case 7:
                return "Июль";

            case 8:
                return "Август";

            case 9:
                return "Сентябрь";

            case 10:
                return "Октябрь";

            case 11:
                return "Ноябрь";

            case 12:
                return "Декабрь";
                        
            default:
                return "ERROR";
        }
    }

    public static String TimeFormat( LocalDateTime localDateTime ) {
        return String.format( "%d %s %d %02d:%02d:%02d", localDateTime.getDayOfMonth(),
                GetMonthName( localDateTime.getMonth().getValue() ), localDateTime.getYear(), localDateTime.getHour(),
                localDateTime.getMinute(), localDateTime.getSecond() );
    }

    public static LocalDateTime ParseTime( String str )
    {
        String[] temp = str.split(":");
        if( temp.length != 6 ) return null;
        return LocalDateTime.of(Integer.parseInt(temp[2]),
                Integer.parseInt(temp[1]), Integer.parseInt(temp[0]),
                Integer.parseInt(temp[3]), Integer.parseInt(temp[4]),
                Integer.parseInt(temp[5]));
    }

    public static boolean DateTimeClose( LocalDateTime ldt1, LocalDateTime ldt2 )
    {
        int dif = Math.abs(ldt1.getMinute() - ldt2.getMinute());
        return dif <= 1;
    }
}
