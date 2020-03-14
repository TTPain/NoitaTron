package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlFont;

import org.newdawn.slick.Color;

public class Score {
	public static final int EXTRA_LIFE_VALUE = 50000;
	
	public static int extraLifeScore=0;
	public static int score=0;
	public static int lives=3;

	public static void update(float delta) {
		if(extraLifeScore >= EXTRA_LIFE_VALUE) {
			extraLifeScore = extraLifeScore - EXTRA_LIFE_VALUE;
			lives = lives + 1;
			System.out.println("Extra Life!");
		}
		
		hvlFont(0).draw("Lives: "+ lives, 1920-160, 10, Color.white, 0.2f);
		hvlFont(0).draw("Score: ", 12, 10, Color.white, 0.2f);
		hvlFont(0).draw(""+ score, 40, 45, Color.white, 0.17f);
		
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
