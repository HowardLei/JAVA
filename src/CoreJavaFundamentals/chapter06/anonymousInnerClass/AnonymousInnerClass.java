package CoreJavaFundamentals.chapter06.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * AnonymousInnerClass class
 *
 * @author apple
 * @date 2020/2/5
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        var talkingClock = new TalkingClock();
        talkingClock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
class TalkingClock {
    public void start(int interval, boolean beep) {
        var timer = new Timer(interval, event -> {
            System.out.println("At the tone, the time is " + LocalDateTime.now());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        });
        timer.start();
    }
}