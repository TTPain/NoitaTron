package robotron2;
import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

public class Game {

	public static Player player;
	
    public static float globalTimer = 0f;
    public static int selected_level = 1;

    public static void initialize(){
        player = new Player(Player.PLAYER_START_X, Player.PLAYER_START_Y);
        BulletFire.initialize();
        EnemySpawner.reset();
    }

    public static void update(float delta){
    	globalTimer += delta;
    
    	player.update(delta);
    	player.draw(delta);    

    	EnemySpawner.update(delta);
    	BulletFire.update(delta, player);
    	LevelManager.update();
    }
    
}