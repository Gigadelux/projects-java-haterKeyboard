package KBManipulation;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KBmanipulation extends KeyAdapter{
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode()== KeyEvent.VK_Q)
            System.out.println("Key Q pressed!");
    }

    public static void switcChar(int button){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        switch (button){
            case KeyEvent.VK_EXCLAMATION_MARK:
                toolkit.setLockingKeyState(KeyEvent.VK_BACK_SPACE, Boolean.TRUE);;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                toolkit.setLockingKeyState(KeyEvent.VK_BACK_SPACE, false);
                toolkit.setLockingKeyState(KeyEvent.VK_1,true);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                toolkit.setLockingKeyState(KeyEvent.VK_1,false);
                break;
        }

    }/*
    public void keyTyped(KeyEvent ke) {
        return ke.getKeyCode();
    }*/


    public static void capsLockRandomize(boolean on) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (on)
            toolkit.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, Boolean.TRUE);
        else
            toolkit.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, Boolean.FALSE);
    }
}