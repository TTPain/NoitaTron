package robotron2.pickups;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import robotron2.Player;
import robotron2.Score;

public class Shmoney {
	
	//Number of seconds rubies will last before despawning, plus or minus a few frames
	public static final int DESPAWN_TIMER_IN_SECONDS = 10;
	public static final int SIZE = 22;
	
	private float xPos;
	private float yPos;
	public int shmoneyAmount;
	private int type;
	private boolean exists = true;
	private int timer = (144*DESPAWN_TIMER_IN_SECONDS);
	public static ArrayList<Shmoney> availableRubies = new ArrayList<Shmoney>();	
	
	public Shmoney(float xPosArg, float yPosArg, int typeArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		type = typeArg;
	}
	public void update(float delta, Player player) {
		if ((player.getxPos() - Player.PLAYER_WIDTH / 2 < xPos + SIZE/2)
				&& (player.getxPos() + Player.PLAYER_WIDTH / 2 > xPos - SIZE/2)
				&& (player.getyPos() - Player.PLAYER_HEIGHT / 2 < yPos + SIZE/2)
				&& player.getyPos() + Player.PLAYER_HEIGHT / 2 > yPos - SIZE/2) {
			Score.score += 1000;
			exists = false;
		}
		draw(delta);
		setTimer(getTimer() - 1);
	}
	public void draw(float delta) {
		hvlDraw(hvlQuadc(xPos, yPos, SIZE, SIZE), hvlTexture(7));	
	}
	public float getxPos() {
		return xPos;
	}
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	public float getyPos() {
		return yPos;
	}
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isExists() {
		return exists;
	}
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}	
}

