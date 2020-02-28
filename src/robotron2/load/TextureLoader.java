package robotron2.load;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

import com.osreboot.ridhvl2.loader.HvlLoaderSound;

public class TextureLoader {
	
    public static final int 
    INDEX_MOVE_UP = 0,
    INDEX_MOVE_LEFT = 1,
    INDEX_MOVE_RIGHT = 2,
    INDEX_MOVE_DOWN = 3,
    INDEX_GRUNTSTEP_1 = 4,
    INDEX_GRUNTSTEP_2 = 5;

	public static void loadTextures() {
		hvlLoad("PlayerBlueBack.png"); //0
		hvlLoad("arrowleft.png"); //1
		hvlLoad("arrowright.png"); //2
		hvlLoad("PlayerBlue.png"); //3
		hvlLoad("GruntStep1.png"); //4
		hvlLoad("GruntStep2.png"); //5
	}
	
}
