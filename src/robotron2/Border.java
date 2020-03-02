package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.newdawn.slick.Color;

public class Border {
	public static void update(float delta) {
		hvlDraw(hvlQuad(0, 0, 160, 720), Color.gray);
		hvlDraw(hvlQuad(1120, 0, 160, 720), Color.gray);
	}


}
