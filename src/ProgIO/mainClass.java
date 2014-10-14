package ProgIO;

import InnerArch.TaskManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Marat on 01.10.2014.
 */
public class mainClass extends JFrame implements WindowListener {

    public JButton btnRefresh;
    public JTextArea taLog;
    public TaskManager taskManager;
    private Timer tmr;

    private class btnRefreshUpdate implements ActionListener {
        private mainClass owner;

        btnRefreshUpdate( mainClass owner ) {
            this.owner = owner;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            owner.taskManager.Refresh();
        }
    }

    private class tmrUpdate implements ActionListener {
        private mainClass owner;

        tmrUpdate( mainClass owner )
        {
            this.owner = owner;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            taskManager.Update( owner.taLog );
        }
    }

    public mainClass() {
        super();
        setBounds( 200, 200, 800, 500 );
        setTitle( "Task Manager" );
        setVisible( true );

        btnRefresh = new JButton();
        btnRefresh.setText( "Refresh" );
        btnRefresh.setBounds(10, 420, 200, 30);
        btnRefresh.setVisible(true);
        btnRefresh.addActionListener( new btnRefreshUpdate( this ) );
        add(btnRefresh);
        setLayout( null );

        taLog = new JTextArea();
        taLog.setBounds( 10, 10, 780, 400 );
        taLog.setVisible(true);
        add( taLog );
        setLayout( null );

        taskManager = new TaskManager();
        tmr = new Timer( 100, new tmrUpdate( this ) );
        tmr.start();

        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if( e.getID() == WindowEvent.WINDOW_CLOSING )
            windowClosed( new WindowEvent( this, WindowEvent.WINDOW_CLOSED ) );
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if( e.getID() == WindowEvent.WINDOW_CLOSED )
        {
            tmr.stop();
            this.dispose();
        }
    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    public static void main( String[] args )
    {
        mainClass wnd = new mainClass();

    }
}

