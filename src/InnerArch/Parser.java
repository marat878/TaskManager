package InnerArch;

import com.sun.javafx.scene.layout.region.Margins;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by Ruzil on 04.10.2014.
 */
public class Parser {
    private SystemError errorCode = SystemError.seNone;
    public TaskList cmdList;

    public Parser( TaskList taskList )
    {
        cmdList = taskList;
    }

    private void AddNotify(NotifyType type, String command, String param, String ID,
                           LocalDateTime time) {
        cmdList.Add(new Notify(type, command, param, ID, time));
    }

    private void AddAction(ActionType type, String command, String param, String ID,
                           LocalDateTime time) {
        cmdList.Add(new Action(type, command, param, ID, time));
    }

    public void TaskReader()
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("TaskList"));
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
        String[] splt = str.split("[ ,]");
        String[] temp = new String[1];
        List<String> buf = new ArrayList<String>();

        LocalDateTime time = null;
        NotifyType nt;
        ActionType at;

        // ignore
        if( str.charAt(0) == '/' || str.charAt(0) == '﻿' ) return 1;

        // post effect
        int i;
        String tstr="";
        int getstr = 0;
        for( i = 0; i < splt.length; i++ )
        {
            if( splt[i].length() > 0 ) {

                if( splt[i].charAt(0) == 39 )
                {
                    getstr = 1;
                }
                if( splt[i].charAt(splt[i].length()-1) == 39 )
                {
                    tstr = tstr.concat(" ");
                    tstr = tstr.concat(splt[i]);
                    getstr = 2;
                }

                switch ( getstr )
                {
                    case 0:
                        buf.add(splt[i]);
                        break;

                    case 1:
                        tstr = tstr.concat(" ");
                        tstr = tstr.concat(splt[i]);
                        break;

                    case 2:
                        tstr = tstr.replaceAll("'", " ");
                        tstr = tstr.trim();

                        buf.add(tstr);
                        tstr = "";
                        getstr = 0;
                        break;
                }

            }
        }
        temp = buf.toArray(temp);
        buf.clear();

        //for(i = 0; i < temp.length; i++)
        //    System.out.println(temp[i]);

        // first as command
        // AddAction: ID, AT, CMD, PRM, DT
        if( temp[0].equals("AddAction") )
        {
            // check cnt
            if( temp.length != 6 )
            {
                throw new IASystemException("Bad command line");
            }

            if(temp[2].equals("Run"))
                at = ActionType.atStartProc;
            else
            if(temp[2].equals("Kill"))
                at = ActionType.atKillProc;
            else {
                errorCode = SystemError.seUnknownActionType;
                return -1;
            }
            time = Utils.ParseTime(temp[5]);
            AddAction( at, temp[3], temp[4], temp[1], time );
        }
        // AddNotify: ID, NT, TXT, PRM, DT
        if( temp[0].equals("AddNotify") )
        {
            // check cnt
            if( temp.length != 6 )
            {
                throw new IASystemException("Bad command line");
            }

            if(temp[2].equals("Warning"))
                nt = NotifyType.ntWarning;
            else
            if(temp[2].equals("Info"))
                nt = NotifyType.ntInfo;
            else {
                errorCode = SystemError.seUnknownNotifyType;
                return -1;
            }

            time = Utils.ParseTime(temp[5]);
            AddNotify( nt, temp[3], temp[4], temp[1], time );
        }

        errorCode = SystemError.seNone;
        return 0;
    }

    public SystemError GetErrorCode()
    {
        return errorCode;
    }
}
