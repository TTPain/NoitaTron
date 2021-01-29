package robotron2.util;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlAction;
import com.osreboot.ridhvl2.HvlCoord;

import robotron2.terrain.Block;

public class Utility {

	private static Random rng = new Random();

	public static Random getRngValue() {
		return rng;
	}

	// Returns random int between min and max, inclusive. Source: ridhvl1 (os_reboot)
	public static int randomIntBetween(int min, int max) {
		max++;
		if (max > min)
			return min + rng.nextInt(max - min);
		if (max < min)
			return max + rng.nextInt(min - max);
		return min;
	}

	// Returns random float between min and max, inclusive. Source: ridhvl1 (os_reboot)
	public static float randomFloatBetween(float min, float max)	{
		return min + ((float) Math.random() * (max - min));
	}

	public static void scale(float xScaleArg, float yScaleArg, HvlAction.A0 actionArg){
		GL11.glPushMatrix();
		GL11.glScalef(xScaleArg, yScaleArg, 0);
		actionArg.run();
		GL11.glPopMatrix();
	}

	public static int getCursorX(){
		return Mouse.getX();
	}

	public static int getCursorY(){
		return Display.getHeight() - Mouse.getY();
	}

	public static HvlCoord getCurrentTile(float xArg, float yArg) {
		
		xArg+=Block.BLOCK_SIZE/2;
		yArg+=Block.BLOCK_SIZE/2;
		
		int x = (int)(xArg/Block.BLOCK_SIZE);
		int y = (int)(yArg/Block.BLOCK_SIZE);
		
		hvlDraw(hvlQuadc(x*Block.BLOCK_SIZE, y*Block.BLOCK_SIZE, 10, 10), Color.white);
		
		//System.out.println("X: " + x + " Y: " + y);
		
		return new HvlCoord(x, y);
		
		
	}

}
