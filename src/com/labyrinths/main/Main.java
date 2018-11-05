package com.labyrinths.main;

import com.labyrinths.frames.MainFrame;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
      JFrame frame = new JFrame("MainFrame");
      frame.setContentPane(new MainFrame().getContentPanel());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
    }
}
