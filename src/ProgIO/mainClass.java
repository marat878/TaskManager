package ProgIO;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

/**
 * Created by Marat on 01.10.2014.
 */
public class mainClass {

    private static Scanner scn;

    public static void main( String[] args )
    {
        scn = new Scanner( System.in );

        String cmd = " ";
        System.out.println( "Task Manager 2014 (c)" );
        System.out.println( "e - exit; r - refresh" );

        int done = 0;

        while( done == 0 )
        {
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
