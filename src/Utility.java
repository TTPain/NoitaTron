import java.util.Random;

public class Utility {
	
	private static Random rng = new Random();
	
	public static Random getRngValue() {
		return rng;
	}

	//Returns random int between min and max, inclusive.
	public static int randomIntBetween(int min, int max)	{
		//max++;
		//uncomment this ^^^ for true inclusivity
		if (max > min)
			return min + rng.nextInt(max - min);
		if (max < min)
			return max + rng.nextInt(min - max);
		return min;
	}
	
}
