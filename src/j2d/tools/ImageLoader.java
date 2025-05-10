package j2d.tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {

    public static BufferedImage loadResource(String path) {
        //TODO - MAKE THIS ERROR OUT WITH A DEDICATED MESSAGE
        if (path.indexOf("./") == 0) {
            path = path.substring(1);
        }
        else if (path.charAt(0) != '/') {
            path = "/" + path;
        }

        InputStream ipStream = ImageLoader.class.getResourceAsStream(path);

        if (ipStream != null) {
            try {
                return ImageIO.read(ipStream);
            } catch (IOException e) {
                System.out.println(e.getMessage() + "Error Loading Image at " + path);
            }
        }
        return null;
    }

    public static BufferedImage loadAbsolute(String path) {
        //TODO - MAKE THIS ERROR OUT WITH A DEDICATED MESSAGE
        try {
            return ImageIO.read(new File(path));

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error Loading Image");
            return null;
        }
    }
}
