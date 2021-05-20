package util;

import java.awt.*;
import java.io.File;

public class Parametros {

    public static void loadFont(){
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ARCADECLASSIC.TTF"));
            customFont.deriveFont(Font.PLAIN);
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        }
        catch (Exception e){}
    }


}
