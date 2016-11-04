/**
 * Created by Daron Adkins and Hunter Caughlin on 11/3/16.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.URL;


public class AdkinsCaughlinProject3 extends JApplet{

    private Timer timer;
    private Image image;
    private int index = 0;




    private static String[] imageArray =
            {
                    "res/cat1.jpg", "res/cat2.jpg",
                    "res/cat3.jpg", "res/cat4.jpg",
                    "res/cat5.jpg", "res/cat6.jpg",
                    "res/cat7.jpg", "res/cat8.jpg",
                    "res/cat9.jpg", "res/cat10.jpg"

            };


            public void init(){

                setSize(1080,768);
                URL url = getDocumentBase();

                image = getImage(url, imageArray[index]);

                int TIME_DELAY = 1000;
                timer = new Timer(TIME_DELAY, new TimerListener());

                timer.start();
            }

            public void paint(Graphics g)
            {

                super.paint(g);

                g.drawImage(image,0,0,1080,768,this);

            }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(index < 10)
                index++;
            if(index == imageArray.length)
                index = 0;

            image = getImage(getDocumentBase(), imageArray[index]);


            repaint();
        }
    }



}
