package robotron2;

import robotron2.enemy.EnemyGrunt;

public class LevelManager {
	
    public static int gruntDeathCount = 0;
    
    public static void update() {
    	System.out.println(gruntDeathCount);
    
    	gruntDeathCount = 0;
    for(EnemyGrunt grunt : EnemySpawner.enemyGrunts) {
        if(grunt.livingState == false) {
            gruntDeathCount = gruntDeathCount + 1;
        }
    }
    
    	if(gruntDeathCount == 5) {
    		Game.selected_level = 2;
    		EnemySpawner.reset();
    	
    	}
    
    
    
    

    }	
}
