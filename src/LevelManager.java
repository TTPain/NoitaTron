
public class LevelManager {
	
    static int gruntDeathCount = 0;
    
    public static void update() {
    
    	gruntDeathCount = 0;
    for(EnemyGrunt grunt : EnemySpawner.enemyGrunts) {
        if(grunt.livingState == false) {
            gruntDeathCount = gruntDeathCount + 1;
        }
    }
    
    	if(gruntDeathCount == 5) {
    		Game.selected_level = Game.selected_level + 1;
    		EnemySpawner.reset();
    	
    	}
    
    
    
    

    }	
}
