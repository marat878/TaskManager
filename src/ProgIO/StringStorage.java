package ProgIO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marat on 25.10.2014.
 */
public class StringStorage {
    private static List<String> items = new ArrayList<String>();

    public static void Add( String str )
    {
        items.add( str );
    }

    public static void Clear()
    {
        items.clear();
    }

    public static String[] Get()
    {
        String[] arr = new String[1];
        arr = items.toArray(arr);
        return arr;
    }
}
