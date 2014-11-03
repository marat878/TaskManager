package InnerArch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marat on 28.10.2014.
 */
public class TaskIDManager {
    private static List<String> ids = new ArrayList<String>();

    public static void AddID( String id )
    {
        ids.add(id);
    }

    public static void Reset()
    {
        ids.clear();
    }

    public static String GetAutoID()
    {
        int i = 0;
        String t;

        do {
            t = String.format("tsk%d", i);
        }
        while (!CheckIDEnable(t));

        return t;
    }

    public static boolean CheckIDEnable( String id )
    {
        if( ids.size() == 0 ) return true;

        String t;
        for( int i = 0; i < ids.size(); i++ )
        {
            t = ids.get(i);
            if( t.equals(id) ) return false;
        }

        return true;
    }
}
