package InnerArch;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Marat on 06.10.2014.
 */
public class TaskManager {
    private Parser parser;
    private TaskList taskList;
    private LocalDateTime destTime;
    private int destId;

    public TaskManager()
    {
        taskList = new TaskList();
        parser = new Parser( taskList );
        Refresh();
    }

    private void GetDest()
    {
        int i, len = taskList.GetLength();
        Task t;

        if( taskList.GetLength() == 0 )
        {
            destTime = null;
            return;
        }

        LocalDateTime ldt = taskList.getValue(0).runTime;

        for( i = 0; i < len; i++ )
        {
            t = taskList.getValue( i );
            if( t.runTime.isBefore( ldt ) )
            {
                ldt = t.runTime;
                destId = i;
            }
        }

        destTime = ldt;
    }

    private void Cleanup()
    {
        int i = 0, len = taskList.GetLength();

        while( i < len-1 )
        {
            if( taskList.getValue( i ).remove )
            {
                taskList.RemoveId(i);
                i = 0;
                len = taskList.GetLength();
            }
            else
            {
                i++;
            }
        }
    }

    public void Refresh()
    {
        parser.TaskReader();
        GetDest();
    }

    public void Update( JTextArea textArea )
    {
        int i, len = taskList.GetLength();
        Task t;
        LocalDateTime curr = LocalDateTime.now();

        if( curr.isAfter( destTime ) )
        {
            t = taskList.getValue( destId );
            t.Do( textArea );
            t.remove = true;

            for( i = 0; i < len; i++ )
            {
                t = taskList.getValue( i );

                if( t.runTime.isBefore( destTime ) || t.runTime.isEqual( destTime ) )
                {
                    if( !t.remove )
                        t.Do( textArea );
                    t.remove = true;
                }
            }

            Cleanup();
            GetDest();
        }

    }
}
