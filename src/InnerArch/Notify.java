package InnerArch;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Marat on 30.09.2014.
 */
public class Notify extends Task {
    public NotifyType nType;

    public Notify(NotifyType type, String command, String parm, LocalDateTime time)
    {
        nType = type;
        cmd = command;
        runTime = time;
        param = parm;
        remove = false;
    }

    public void Do( JTextArea textArea )
    {
        String str;
        switch ( nType )
        {
            case ntInfo:
                str = String.format( "[%d %s %d %02d:%02d:%02d] %s%n", runTime.getDayOfMonth(),
                        runTime.getMonth().toString(), runTime.getYear(), runTime.getHour(),
                        runTime.getMinute(), runTime.getSecond(), cmd );
                textArea.append( str );
                break;

            case ntWarning:
                str = String.format( "[%d %s %d %02d:%02d:%02d] [Внимание] %s%n",
                        runTime.getDayOfMonth(), runTime.getMonth().toString(),
                        runTime.getYear(), runTime.getHour(),
                        runTime.getMinute(), runTime.getSecond(), cmd );
                textArea.append( str );
                break;
        }
    }
}
