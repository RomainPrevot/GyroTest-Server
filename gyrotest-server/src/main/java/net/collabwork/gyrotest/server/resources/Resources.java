package net.collabwork.gyrotest.server.resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Resources {

    private static Font openSansLight;

    public static Font openSansLight() {
        if (openSansLight == null) {
            InputStream resourceStream = Resources.class.getResourceAsStream("OpenSans-Light.ttf");
            try {
                openSansLight = Font.createFont(Font.TRUETYPE_FONT, resourceStream);
            } catch (FontFormatException | IOException e) {
                openSansLight = Font.getFont(Font.SANS_SERIF);
            }
        }

        return openSansLight;
    }
}
