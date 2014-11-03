package InnerArch;

import java.io.IOException;

/**
 * Created by Нияз on 30.09.2014.
 */
public class ActionRK {

    public static boolean Run(String[] cmd )
    {
        try
        {
            Process process = Runtime.getRuntime().exec(cmd);
        }
        catch (IOException e)
        {
            System.out.println( e.toString() );
            return false;
        }
        return true;
    }

    public static boolean Kill(String processName)
    {
        try {
            String[] cmd = new String[] { "cmd.exe", "/C", "taskkill /f /im", processName };
            Process process = Runtime.getRuntime().exec(cmd);
        }
        catch (IOException e)
        {
            System.out.println( e.toString() );
            return false;
        }
        return true;
    }
}
