import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;
import com.osreboot.ridhvl2.template.HvlDisplayWindowed;
import com.osreboot.ridhvl2.template.HvlTemplateI;

public class Main extends HvlTemplateI{
	//TEST PUSH
	//TEST PUSH 2

    public static void main(String[] args) {
    	for(int i = 0; i < 5; i++) {
    		System.out.println("Hello Worlk!");
    	}
        new Main();
    }

    public static final int 
    INDEX_MOVE_UP = 0,
    INDEX_MOVE_LEFT = 1,
    INDEX_MOVE_RIGHT = 2,
    INDEX_MOVE_DOWN = 3;

    public Main() {
        super(new HvlDisplayWindowed(144, 1280, 720, "Robotron 2", false));
    }

    @Override
    public void initialize() {
        hvlLoad("src/arrowup.png");//0
        hvlLoad("src/arrowleft.png");//1
        hvlLoad("src/arrowright.png");//2
        hvlLoad("src/arrowdown.png");//3
        Game.initialize();

        Player.initialize(); 
    }

    @Override
    public void update(float delta) {
        Game.update(delta);

    }

}