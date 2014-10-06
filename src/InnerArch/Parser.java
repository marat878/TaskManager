package InnerArch;

import com.sun.javafx.scene.layout.region.Margins;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;


/**
 * Created by Ruzil on 04.10.2014.
 */
public class Parser {
    private SystemError errorCode;
    public TaskList cmdList;

    public Parser()
    {
        cmdList = new TaskList();
    }

    private void AddNotify(NotifyType type, String command, String param, LocalDateTime time) {
        cmdList.Add(new Notify(type, command, param, time));
    }

    private void AddAction(ActionType type, String command, String param, LocalDateTime time) {
        cmdList.Add(new Action(type, command, param, time));
    }

    public void TaskReader()
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("TaskList.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if( scanner == null ) return;

        while( scanner.hasNextLine() )
        {
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

        LocalDateTime time = null;
        NotifyType nt;
        ActionType at;

        // ignore
        if( str.charAt(0) == '/' ) return 1;

        if( temp.length < 10 ) {
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
                errorCode = SystemError.seUnknownNotifyType;
                return -1;
            }

            time = LocalDateTime.of( Integer.parseInt( temp[4] ), Integer.parseInt( temp[5] ),
                    Integer.parseInt( temp[6] ), Integer.parseInt( temp[7] ),
                    Integer.parseInt( temp[8] ), Integer.parseInt( temp[8] ));

            AddNotify( nt, temp[2], temp[3], time );

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

            time = LocalDateTime.of( Integer.parseInt( temp[4] ), Integer.parseInt( temp[5] ),
                    Integer.parseInt( temp[6] ), Integer.parseInt( temp[7] ),
                    Integer.parseInt( temp[8] ), Integer.parseInt( temp[8] ));

            AddAction( at, temp[2], temp[3], time );
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
