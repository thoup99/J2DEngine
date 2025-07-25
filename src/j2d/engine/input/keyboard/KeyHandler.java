package j2d.engine.input.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * KeyHandler.java
 * A class that tracks and handles j2d.engine.input.keyboard inputs.
 * Allows classes to subscribe to keys and receive
 * callbacks from anywhere.
 *
 * @author Tyler Houp
 */
public class KeyHandler implements KeyListener {

    private static final Map<Integer, Boolean> keyMap = new HashMap<Integer, Boolean>();
    private static final Map<Integer, ArrayList<KeySubscriber>> subscribers = new HashMap<Integer, ArrayList<KeySubscriber>>();
    private static final List<Integer> queuedKeys = new ArrayList<Integer>(); //TODO
    public static KeyHandler keyHandler = new KeyHandler();

    /**
     *  Constructor for KeyHandler
     *  Private constructor to prevent instantiating outside
     *  of this class and prevents the default constructor
     *  from being created.
     */
    private KeyHandler() {

    }


    public static void initialize() {

    }

    private static void addKey(int awtKeyEventKey) {
        synchronized (subscribers) {
            keyMap.putIfAbsent(awtKeyEventKey, false);
            subscribers.putIfAbsent(awtKeyEventKey, new ArrayList<KeySubscriber>());
        }
    }

    private static void removeKey(int awtKeyEventKey) {
        synchronized (subscribers) {
            keyMap.remove(awtKeyEventKey);
            subscribers.remove(awtKeyEventKey);
        }
    }

    /**
     * @param key KeyEvent from Java Awt
     * @return Returns a boolean that's true if key is
     * being pressed and false if it is not.
     */
    public static boolean isKeyPressed(int key) {
        synchronized (subscribers) {
            Boolean pressed = keyMap.get(key);
            return pressed != null ? pressed : false;
        }
    }

    /**
     * @param subscriber KeySubscriber Object
     * @param subscribedKeys List of Keys that subscriber will respond to.
     */
    public static void subscribe(KeySubscriber subscriber, int[] subscribedKeys) {
        synchronized (subscribers) {
            for (int key : subscribedKeys) {
                if (!keyMap.containsKey(key)) {
                    addKey(key);
                }

                if (!subscribers.get(key).contains(subscriber)) {
                    subscribers.get(key).add(subscriber);
                }
            }
        }
    }

    /**
     * @param subscriber Subscriber to remove from all subscribers list
     */
    public static void unsubscribe(KeySubscriber subscriber) {
        synchronized (subscribers) {
            for (int key: new ArrayList<>(subscribers.keySet())) {
                subscribers.get(key).remove(subscriber);

                if (subscribers.get(key).isEmpty()) {
                    removeKey(key);
                }
            }
        }
    }

    /**
     * Unused Function from KeyListener Interface
     * @param e KeyEvent
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Implementation from KeyListener
     * Adds pressed key from keymap setting
     * it to true. Also calls doCallBacks on the first
     * frame that the key is pressed.
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        synchronized (subscribers) {
            int code = e.getKeyCode();
            if (keyMap.containsKey(code)) {
                boolean justPressed = !keyMap.get(code);
                keyMap.put(code, true);

                if (justPressed) {
                    for (KeySubscriber subscriber : subscribers.get(code)) {
                        subscriber.keyPressed(code);
                    }
                }
            }
        }
    }

    /**
     * Implementation from KeyListener
     * Removes pressed key from keymap setting
     * it to false.
     * @param e KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        synchronized (subscribers) {
            int code = e.getKeyCode();
            if (keyMap.containsKey(code)) {
                keyMap.put(code, false);

                for (KeySubscriber subscriber : subscribers.get(code)) {
                    subscriber.keyReleased(code);
                }
            }
        }
    }
}
