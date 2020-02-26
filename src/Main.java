import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;
import com.osreboot.ridhvl2.template.HvlDisplayWindowed;
import com.osreboot.ridhvl2.template.HvlTemplateI;

public class Main extends HvlTemplateI{

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        super(new HvlDisplayWindowed(144, 1280, 720, "Robotron 2", false));
    }

    @Override
    public void initialize() {
    	TextureLoader.loadTextures();
        Game.initialize();
    }

    @Override
    public void update(float delta) {
        Game.update(delta);
    }

}