package robotron2.enemy;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import robotron2.Player;

public class EnemyHulk {
//
	public EnemyHulk(float xPosArg, float yPosArg, int textureArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		hulkTexture = textureArg;
	}

	public int hulkTexture;
	public float xPos;
	public float yPos;
	public float hulktimer = 0;

	public void update(float delta, Player player) {
		if (player.getxPos() > xPos) {
			xPos = xPos + (50*delta);
		}
		if (player.getxPos() < xPos) {
			xPos = xPos - (50*delta);
		}
		if (player.getyPos() > yPos) {
			yPos = yPos + (50*delta);
		}
		if (player.getyPos() < yPos) {
			yPos = yPos - (50*delta);
		}

	}
	
	public void draw() {
		hvlDraw(hvlQuadc(xPos, yPos, 60, 50), hvlTexture(hulkTexture));
	}
	
}
