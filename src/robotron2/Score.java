package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlFont;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.menu.MenuManager;

public class Score {
	public static final int EXTRA_LIFE_VALUE = 50000;
	
	public static int extraLifeScore=0;
	public static int score=0;
	public static int lives=3;

	public static void update(float delta, Player player) {
		if(extraLifeScore >= EXTRA_LIFE_VALUE) {
			extraLifeScore = extraLifeScore - EXTRA_LIFE_VALUE;
			lives = lives + 1;
			System.out.println("Extra Life!");
			
			
		}
		
		if(lives <= -1) {
			RoomGenerator.reset(player);
			player.reset();
			Score.reset();
			BulletFire.reset(player);
			//LevelGenerator.reset();
			if(HvlMenu.top()==MenuManager.game) {
				HvlMenu.set(MenuManager.gameover);
			}
		}
		
	}
	
	
	public static void addPoints(int pointValue) {
		
		score = score + pointValue;
		extraLifeScore = extraLifeScore + pointValue;
		
	}
	public static void reset() {
		score=0;
		lives=3;
	}
}
