package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import org.newdawn.slick.Color;

public class Door {
	
	public static final float DOOR_SIZE = 60f;
	private float xPos = 0;
	private float yPos = 0;
	private boolean open = false;

	public Door(float xArg, float yArg, boolean openArg) {
		
		xPos = xArg;
		yPos = yArg;
		open = openArg;
		
	}
	
	public void draw() {
		
		if(!open) {
			hvlDraw(hvlQuadc(xPos, yPos, DOOR_SIZE, DOOR_SIZE), Color.gray);
		}else {
			hvlDraw(hvlQuadc(xPos, yPos, DOOR_SIZE, DOOR_SIZE), Color.white);
		}
				
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

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
}
