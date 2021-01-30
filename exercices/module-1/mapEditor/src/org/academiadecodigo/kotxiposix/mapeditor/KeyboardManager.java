package org.academiadecodigo.kotxiposix.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class KeyboardManager implements KeyboardHandler {

    private Keyboard keyboard;
    private MapEditor mapEditor;
    private boolean pressingSpace = false;

    public enum Direction {

        LEFT,
        UP,
        RIGHT,
        DOWN;
    }

    public KeyboardManager(MapEditor mapEditor) {

        this.keyboard = new Keyboard(this);

        this.mapEditor = mapEditor;

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent releaseSpace = new KeyboardEvent();
        releaseSpace.setKey(KeyboardEvent.KEY_SPACE);
        releaseSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent pressC = new KeyboardEvent();
        pressC.setKey(KeyboardEvent.KEY_C);
        pressC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressS = new KeyboardEvent();
        pressS.setKey(KeyboardEvent.KEY_S);
        pressS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressL = new KeyboardEvent();
        pressL.setKey(KeyboardEvent.KEY_L);
        pressL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(pressRight);
        keyboard.addEventListener(pressLeft);
        keyboard.addEventListener(pressUp);
        keyboard.addEventListener(pressDown);
        keyboard.addEventListener(pressSpace);
        keyboard.addEventListener(pressC);
        keyboard.addEventListener(pressS);
        keyboard.addEventListener(pressL);
        keyboard.addEventListener(releaseSpace);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:

                if (pressingSpace){

                mapEditor.getGrid().paint(mapEditor.getCursor().col, mapEditor.getCursor().row);
                }

                if (!mapEditor.onEdge(Direction.RIGHT)) {

                    mapEditor.getCursor().moveRight();

                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (!mapEditor.onEdge(Direction.LEFT)) {

                    mapEditor.getCursor().moveLeft();

                }
                break;

            case KeyboardEvent.KEY_DOWN:

                if (!mapEditor.onEdge(Direction.DOWN)) {

                    mapEditor.getCursor().moveDown();

                }
                break;

            case KeyboardEvent.KEY_UP:

                if (!mapEditor.onEdge(Direction.UP)) {

                    mapEditor.getCursor().moveUp();

                }
                break;

            case KeyboardEvent.KEY_SPACE:

                pressingSpace = true;

                if (!(mapEditor.getGrid().isPainted(mapEditor.getCursor().col, mapEditor.getCursor().row))) {

                    mapEditor.getGrid().paint(mapEditor.getCursor().col, mapEditor.getCursor().row);

                } else {

                    mapEditor.getGrid().erase(mapEditor.getCursor().col, mapEditor.getCursor().row);

                }
                break;

            case KeyboardEvent.KEY_C:

                mapEditor.getGrid().eraseAll();

                break;

            case KeyboardEvent.KEY_S:

                try {

                    mapEditor.getGrid().saveToFile();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_L:

                mapEditor.getGrid().loadToFile();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        pressingSpace = false;
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){

            mapEditor.getGrid().keepDrawingErasing(mapEditor.getCursor().col, mapEditor.getCursor().row);
        }
    }
}
