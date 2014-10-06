package InnerArch;

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
    }

    public void Exec()
    {
        switch ( aType )
        {
            case atKillProc:
                ActionRK.Kill( cmd );
                break;

            case atStartProc:
                String[] t = new String[2];
                t[0] = cmd;
                t[1] = param;
                ActionRK.Run( t );
                break;
        }
    }
}
