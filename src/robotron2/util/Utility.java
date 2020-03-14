package robotron2.util;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.osreboot.ridhvl2.HvlAction;

public class Utility {

	private static Random rng = new Random();

	public static Random getRngValue() {
		return rng;
	}

	// Returns random int between min and max, inclusive.
	public static int randomIntBetween(int min, int max) {
		 max++;
		if (max > min)
			return min + rng.nextInt(max - min);
		if (max < min)
			return max + rng.nextInt(min - max);
		return min;
	}
	
	public static float randomFloatBetween(float min, float max)	{
		return min + ((float) Math.random() * (max - min));
	}
	
	public static void scale(float xScaleArg, float yScaleArg, HvlAction.A0 actionArg){
	    GL11.glPushMatrix();
	    GL11.glScalef(xScaleArg, yScaleArg, 0);
	    actionArg.run();
	    GL11.glPopMatrix();
	}
	

	
	
	
}
