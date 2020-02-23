import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;

import java.util.ArrayList;


public class EnemySpawner {
	
	public static ArrayList<EnemyGrunt> enemyGrunts = new ArrayList<>();
	
	public static void restart() {
		
		enemyGrunts.clear();
		//Fill array with enemies, exact placement can be specified
		if(Game.selected_level == 1) {
			enemyGrunts.add(new EnemyGrunt(100f, 100f, true));
			enemyGrunts.add(new EnemyGrunt(500f, 500f, true));
			enemyGrunts.add(new EnemyGrunt(700f, 700f, true));
			enemyGrunts.add(new EnemyGrunt(600f, 200f, true));
			enemyGrunts.add(new EnemyGrunt(400f, 200f, true));
		}	
	}
	
	public static void update(float delta) {
	//Each frame check if each enemy is alive, and if so, update and draw it.
		for(EnemyGrunt grunt : enemyGrunts) {
			if(grunt.getLivingState()) {
			hvlDraw(hvlQuadc(grunt.xPos, grunt.yPos, EnemyGrunt.GRUNT_SIZE, EnemyGrunt.GRUNT_SIZE), Color.red);
			grunt.update(delta, Game.player);
			}
		
		}

	}
}
