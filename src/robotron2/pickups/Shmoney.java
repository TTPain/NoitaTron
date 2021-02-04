package robotron2.pickups;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import robotron2.Player;
import robotron2.Score;

public class Shmoney {
	
	private float xPos;
	private float yPos;
	public int shmoneyAmount;
	private int type;
	private boolean exists = true;
	public static int timer = 144*15;
	public static ArrayList<Shmoney> availableRubies = new ArrayList<Shmoney>();	
	
	public Shmoney(float xPosArg, float yPosArg, int typeArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		type = typeArg;
	}
	public void update(float delta, Player player) {
		if ((player.getxPos() - Player.PLAYER_WIDTH / 2 < xPos + 6)
				&& (player.getxPos() + Player.PLAYER_WIDTH / 2 > xPos - 6)
				&& (player.getyPos() - Player.PLAYER_HEIGHT / 2 < yPos + 6)
				&& player.getyPos() + Player.PLAYER_HEIGHT / 2 > yPos - 6) {
			Score.score += 1000;
			exists = false;
		}
		draw(delta);
		setTimer(getTimer() - 1);
	}
	public void draw(float delta) {
		hvlDraw(hvlQuadc(xPos, yPos, 12, 12), Color.pink);	
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
	public ArrayList<Shmoney> getAvailableRubies() {
		return availableRubies;
	}
	public void setAvailableRubies(ArrayList<Shmoney> availableRubies) {
		this.availableRubies = availableRubies;
	}
	public int getTimer() {
		return timer;
	}
	public static void setTimer(int timer) {
		Shmoney.timer = timer;
	}	
}

