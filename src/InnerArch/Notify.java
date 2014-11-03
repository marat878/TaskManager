package InnerArch;

import ProgIO.StringStorage;

import java.time.LocalDateTime;

/**
 * Created by Marat on 30.09.2014.
 */
public class Notify extends Task {
    public NotifyType nType;

    public Notify(NotifyType type, String command, String parm, String ID, LocalDateTime time)
    {
        nType = type;
        cmd = command;
        runTime = time;
        param = parm;
        remove = false;

        if( ID.equals("AutoID") )
        {
            id = TaskIDManager.GetAutoID();
            TaskIDManager.AddID(id);
            return;
        }

        if( TaskIDManager.CheckIDEnable(ID) ) {
            id = ID;
            TaskIDManager.AddID(ID);
        }
        else
        {
            throw new IASystemException(String.format("%s ID is an unable.", ID));
        }
    }

    public void Do()
    {
        String str;
        switch ( nType )
        {
            case ntInfo:
                str = String.format( "[%s] %s%n", Utils.TimeFormat( runTime ), cmd );
                StringStorage.Add( str );
                break;

            case ntWarning:
                str = String.format( "[%s] [Внимание] %s %n", Utils.TimeFormat( runTime ), cmd );
                StringStorage.Add( str );
                break;

        }
    }
}
