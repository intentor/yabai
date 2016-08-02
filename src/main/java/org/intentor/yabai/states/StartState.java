package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.LCD;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.RotationDirection;
import org.intentor.yabai.core.State;
import org.intentor.yabai.util.Menu;
import org.intentor.yabai.util.MenuItem;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Start state.
 */
public class StartState extends State {
    /** View menu items. */
    private final MenuItem[] menuItems = {
        new MenuItem("Start Left"),
        new MenuItem("Start Right"),
        new MenuItem("Back")
    };

    /** AI parameters. */
    protected AiParameters parameters;
    /** Main menu. */
    private Menu menu;


    /**
     * Creates a new instance of the class.
     *
     * @param parameters AI parameters.
     */
    public StartState(AiParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void onStart() {
        if (this.menu == null) {
            this.menu = new Menu(this.menuItems, 4);
        }

        this.menu.setCurrentIndex(0);
    }

    @Override
    public void update() {
        LCD.clear();

        this.graphics.drawRegion(Asset.LOGO_INTENTOR, 0, 0,
            Asset.LOGO_INTENTOR.getWidth(), Asset.LOGO_INTENTOR.getHeight(),
            0, 0, 0, Graphics.LEFT | Graphics.TOP);

        int selection = menu.select();
        switch (selection) {
            case 0:
                this.parameters.rotation = RotationDirection.LEFT;
                this.stateManager.start(StateName.RUNNING);
                break;
            case 1:
                this.parameters.rotation = RotationDirection.RIGHT;
                this.stateManager.start(StateName.RUNNING);
                break;
            case 2:
                this.stateManager.start(StateName.HOME);
                break;
        }
    }
}