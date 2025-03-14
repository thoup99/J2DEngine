package demos.timerdemo;

import j2d.attributes.position.Position2D;
import j2d.components.Timer;
import j2d.components.graphics.text.CenteredText;
import j2d.engine.gameobject.GameObject;
import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.keyboard.KeySubscriber;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TimerUser extends GameObject implements KeySubscriber {
    CenteredText remainingTimeText;
    CenteredText timesHitText;
    Timer timer;
    boolean currentOneShot = false;
    int timesHit = 0;

    public TimerUser() {
        remainingTimeText = new CenteredText(this, new Position2D(300, 50), "1000", 0);
        timesHitText = new CenteredText(this, new Position2D(300, 80), "0", 0);

        remainingTimeText.setColor(Color.RED);
        timesHitText.setColor(Color.BLUE);

        timer = new Timer(this, 1000, this::timerTimeout);

        int[] keys = {KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F};
        KeyHandler.subscribe(this, keys);

        ready();
    }

    private void timerTimeout(){
        timesHit++;
        timesHitText.setText("" + timesHit);
    }

    @Override
    public void update(double delta) {
        remainingTimeText.setText("" + timer.timeRemaining());
    }

    @Override
    public void physicsUpdate(double delta) {

    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_A) {
            timer.start();
        } else if (key == KeyEvent.VK_S) {
            timer.pause();
        } else if (key == KeyEvent.VK_D) {
            timer.stop();
        } else if (key == KeyEvent.VK_F) {
            currentOneShot = !currentOneShot;
            timer.setOneShot(currentOneShot);
        }
    }

    @Override
    public void keyReleased(int key) {

    }
}
