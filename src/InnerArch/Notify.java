package InnerArch;

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
    }

    public void Show()
    {
        switch ( nType )
        {
            case ntInfo:
                System.out.format( "[%d %s %d %02d:%02d:%02d] %s%n", runTime.getDayOfMonth(),
                        runTime.getMonth().toString(), runTime.getYear(), runTime.getHour(),
                        runTime.getMinute(), runTime.getSecond(), cmd );
                break;

            case ntWarning:
                System.out.format( "[%d %s %d %02d:%02d:%02d] [Внимание] %s%n",
                        runTime.getDayOfMonth(), runTime.getMonth().toString(),
                        runTime.getYear(), runTime.getHour(),
                        runTime.getMinute(), runTime.getSecond(), cmd );
                break;
        }
    }
}
