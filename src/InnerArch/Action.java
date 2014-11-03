package InnerArch;

import ProgIO.StringStorage;

import java.time.LocalDateTime;

/**
 * Created by Marat on 30.09.2014.
 */

public class Action extends Task {
    public ActionType aType;

    public Action(ActionType type, String command, String parm, String ID, LocalDateTime time)
    {
        aType = type;
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
        switch ( aType )
        {
            case atKillProc:
                ActionRK.Kill( cmd );
                str = String.format( "[%s] Завершение процесса - %s%n",
                        Utils.TimeFormat( runTime ), cmd );
                StringStorage.Add( str );
                break;

            case atStartProc:
                String[] t = new String[2];
                t[0] = cmd;
                t[1] = param;
                ActionRK.Run( t );
                str = String.format( "[%s] Запуск процесса - %s%n",
                        Utils.TimeFormat( runTime ), cmd );
                StringStorage.Add(str);
                break;
        }
    }
}
