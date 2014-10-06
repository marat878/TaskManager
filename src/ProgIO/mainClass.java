package ProgIO;

import InnerArch.Parser;
import java.util.Scanner;

/**
 * Created by Marat on 01.10.2014.
 */
public class mainClass {

    public static void main( String[] args )
    {
        Scanner scn = new Scanner( System.in );
        Parser prs = new Parser();

        // init
        prs.TaskReader();

        String cmd;
        System.out.println( "Task Manager 2014 (c)" );
        System.out.println( "e - exit; r - refresh" );
        System.out.printf( "#####################%n%n" );

        int done = 0;

        while( done == 0 )
        {
            // ToDo: update, check time, exec tasks
            cmd = scn.nextLine();

            if( cmd.equals( "r" ) )
            {
                // ToDo: refresh func here
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

