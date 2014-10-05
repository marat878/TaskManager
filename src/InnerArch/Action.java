package InnerArch;

import java.util.Date;

/**
 * Created by Marat on 30.09.2014.
 */

public class Action extends Task {
    public ActionType aType;

    public Action(ActionType type, String command, Date time)
    {
        aType = type;
        cmd = command;
        runTime = time;
    }

    public void Exec()
    {
        switch ( aType )
        {
            case atKillProc:
                ActionRK.Kill( cmd );
                break;

            case atStartProc:
                //ActionRK.Run( cmd );
                break;
        }
    }
}
