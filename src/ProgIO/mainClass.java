package ProgIO;

import InnerArch.Parser;
import InnerArch.TaskManager;

import java.util.Scanner;

/**
 * Created by Marat on 01.10.2014.
 */
public class mainClass {

    public static void main( String[] args )
    {
        Scanner scn = new Scanner( System.in );

        String cmd;
        System.out.println( "Task Manager 2014 (c)" );
        System.out.println( "e - exit; r - refresh" );
        System.out.printf( "#####################%n%n" );

        TaskManager taskManager = new TaskManager();

        int done = 0;

        while( done == 0 )
        {
            taskManager.Update();
            cmd = scn.nextLine();

            if( cmd.equals( "r" ) )
            {
                taskManager.Refresh();
            }
            else
            if( cmd.equals( "e" ) )
            {
                System.out.println( "Работы программы завершена." );
                done = 1;
            }
            else
            {
                System.out.println( "Неверная команда!" );
            }
        }
    }
}

