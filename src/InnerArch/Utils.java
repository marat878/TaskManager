package InnerArch;

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
}
