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
                str = String.format( "[%s] %s%n", Utils.TimeFormat( runTime ), cmd );
                textArea.append( str );
                break;

            case ntWarning:
                str = String.format( "[%s] [Внимание] %s %n", Utils.TimeFormat( runTime ), cmd );
                textArea.append( str );
                break;
        }
    }
}
