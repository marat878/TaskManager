package InnerArch;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Marat on 30.09.2014.
 */

public class Action extends Task {
    public ActionType aType;

    public Action(ActionType type, String command, String parm, LocalDateTime time)
    {
        aType = type;
        cmd = command;
        runTime = time;
        param = parm;
        remove = false;
    }

    public void Do( JTextArea textArea )
    {
        String str;
        switch ( aType )
        {
            case atKillProc:
                ActionRK.Kill( cmd );
                str = String.format( "[%d %s %d %02d:%02d:%02d] Завершение процесса - %s%n",
                        runTime.getDayOfMonth(),
                        runTime.getMonth().toString(), runTime.getYear(), runTime.getHour(),
                        runTime.getMinute(), runTime.getSecond(), cmd );
                textArea.append( str );
                break;

            case atStartProc:
                String[] t = new String[2];
                t[0] = cmd;
                t[1] = param;
                ActionRK.Run( t );
                str = String.format( "[%d %s %d %02d:%02d:%02d] Запуск процесса - %s%n",
                        runTime.getDayOfMonth(),
                        runTime.getMonth().toString(), runTime.getYear(), runTime.getHour(),
                        runTime.getMinute(), runTime.getSecond(), cmd );
                textArea.append( str );
                break;
        }
    }
}
