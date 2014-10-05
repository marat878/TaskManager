package InnerArch;

import java.util.Date;

/**
 * Created by Marat on 30.09.2014.
 */
public class Notify extends Task {
    public NotifyType nType;

    public Notify(NotifyType type, String command, Date time)
    {
        nType = type;
        cmd = command;
        runTime = time;
    }

    public void Show()
    {
        switch ( nType )
        {
            case ntInfo:
                // Out here
                break;

            case ntWarning:
                // Out here
                break;
        }
    }
}
