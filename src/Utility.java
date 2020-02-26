import java.util.Random;

public class Utility {
	
	private static Random rng;
	
	static
	{
		reseedRandom();
	}
	
	public static Random getRngValue() {
		return rng;
	}

	public static void reseedRandom() {
		rng = new Random();
	}

	public static int randomIntBetween(int min, int max)	{
		if (max > min)
			return min + rng.nextInt(max - min);
		if (max < min)
			return max + rng.nextInt(min - max);

		return min;
	}
	
}
