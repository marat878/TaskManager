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

    private void Sort()
    {
        int i, j;
        LocalDateTime ldt1, ldt2;
        Task t;
        for( i = 0; i < taskList.GetLength(); i++ )
        {
            for( j = 0; j < taskList.GetLength()-1; j++ )
            {
                ldt1 = taskList.getValue(j).runTime;
                ldt2 = taskList.getValue(j+1).runTime;
                if( ldt1.isAfter(ldt2) )
                {
                    t = taskList.getValue(j);
                    taskList.setValue(j, taskList.getValue(j+1));
                    taskList.setValue(j+1, t);
                }
            }
        }
        destId = 0;
    }

    private void Cleanup()
    {
        int i = 0, len = taskList.GetLength();

        while( i < len )
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
        Sort();
    }

    public void Update()
    {
        int i, len = taskList.GetLength();
        Task t;
        LocalDateTime curr = LocalDateTime.now();

        if( len == 0 ) return;

        for( i = 0; i < len; i++ )
        {
            t = taskList.getValue(i);

            if (curr.isEqual(t.runTime)) {
                if(!t.remove) {
                    t.Do();
                    t.remove = true;
                }
            }
            else
            if (curr.isAfter(t.runTime))
            {
                if(Utils.DateTimeClose( t.runTime, curr )) {
                    if (!t.remove) {
                        t.Do();
                        t.remove = true;
                    }
                }
            }
        }

        Cleanup();
    }
}
