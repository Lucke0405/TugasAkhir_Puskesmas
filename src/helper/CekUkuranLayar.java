package helper;

import java.awt.*;
import java.util.HashMap;

public class CekUkuranLayar {
    public static HashMap<String, Integer> ukur(double percentage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int widthInPixels = (int) (screenSize.getWidth() * percentage);
        int heightInPixels = (int) (screenSize.getHeight() * percentage);

        HashMap<String, Integer> dimensions = new HashMap<>();
        dimensions.put("width", widthInPixels);
        dimensions.put("height", heightInPixels);

        return dimensions;
    }
}
