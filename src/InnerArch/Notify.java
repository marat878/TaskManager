package InnerArch;

import java.util.Date;

/**
 * Created by Marat on 30.09.2014.
 */
public class Notify extends Task {
    public NotifyType nType;
    public String nTitle;

    public Notify(NotifyType type, String command, Date time, String title)
    {
        nType = type;
        cmd = command;
        runTime = time;
        nTitle=title;
    }
}
