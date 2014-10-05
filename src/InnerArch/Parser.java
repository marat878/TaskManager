package InnerArch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/**
 * Created by Ruzil on 04.10.2014.
 */
public class Parser {
    private SystemError errorCode;
    public TaskList cmdList;

    Parser()
    {
        cmdList = new TaskList();
    }

    private void AddNotify(NotifyType type, String command, Date time) {
        cmdList.Add(new Notify(type, command, time));
    }

    private void AddAction(ActionType type, String command, Date time){
        cmdList.Add(new Action(type, command, time));
    }

    public void TaskReader()
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("TaskList.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            ParseString( scanner.nextLine() );
            if( errorCode != SystemError.seNone )
            {
                System.out.println( errorCode.toString() );
            }
        }
        scanner.close();
    }

    public int ParseString(String str) {
        String[] temp = str.split(";");

        Date time = null;
        //String title, command;
        NotifyType nt;
        ActionType at;

        if( temp.length < 4 ) {
            errorCode = SystemError.seWrongLineFormat;
            return -1;
        }

        if(temp[0].equals("N")) {
            if(temp[1].equals("W"))
                nt = NotifyType.ntWarning;
            else
            if(temp[1].equals("I"))
                nt = NotifyType.ntInfo;
            else {
                errorCode = SystemError.seUknownNotifyType;
                return -1;
            }

            AddNotify( nt, temp[2], time );

        }
        else
        if(temp[0].equals("A")) {
            if(temp[1].equals("S"))
                at = ActionType.atStartProc;
            else
            if(temp[1].equals("K"))
                at = ActionType.atKillProc;
            else {
                errorCode = SystemError.seUnknownActionType;
                return -1;
            }

            AddAction( at, temp[2], time );
        }
        else
        {
            errorCode = SystemError.seWrongLineHeader;
            return -1;
        }

        errorCode = SystemError.seNone;
        return 0;
    }

    public SystemError GetErrorCode()
    {
        return errorCode;
    }
}
