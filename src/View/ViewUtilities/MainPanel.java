package View.ViewUtilities;

import Controller.GameController;
import Utilities.Settings;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by Wimberley on 3/23/16.
 */
public class MainPanel extends JFrame implements Runnable {
    private String title;
    private int windowHeight, windowWidth;
    JPanel panel;

    //Testing stuff
    private Timer timer;
    private int DELAY = 40;


    public MainPanel() {
//        this.title = Settings.TITLE;
        this.windowHeight = Settings.GAMEHEIGHT;
        this.windowWidth = Settings.GAMEWIDTH;
        setTitle(title);
        setSize(new Dimension(windowWidth, windowHeight));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);

        Dimension canvasDimension = new Dimension(windowWidth, windowHeight);
        setMinimumSize(canvasDimension);

//        panel = new JPanel();
//        panel.setPreferredSize(canvasDimension);
//        panel.setMinimumSize(canvasDimension);
//        panel.setFocusable(true);
//        getContentPane().setLayout(new BorderLayout());
//        getContentPane().add(panel, BorderLayout.CENTER);
//        pack();

//        this.getRootPane().addComponentListener(new ComponentAdapter() {
//            public void componentResized(ComponentEvent e) {
//                // This is only called when the user releases the mouse button.
//                Settings.GAMEHEIGHT = windowHeight = getHeight();
//                Settings.GAMEWIDTH = windowWidth = getWidth();
//
//                panel.setPreferredSize(new Dimension(windowWidth, windowHeight));
//                panel.setFocusable(true);
//                //repaint();
//            }
//        });

    }


    public JPanel getPanel() {
        return panel;
    }

    public void addView(JComponent jPanel){
        System.out.println("Added views");
        add(jPanel);
        setBackground(Color.WHITE);
        setResizable(false);
        this.setPreferredSize(new Dimension(windowWidth, windowHeight)); //edit
        setSize(new Dimension(windowWidth, windowHeight));
        this.pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        while (true) {

            //cycle();
            //System.out.println("running main panel");
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}