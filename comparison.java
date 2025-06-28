import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class comparison {

    public static void main(String[] args) throws IOException {
        // Load the two images
        //make it a scanner to string so that file isnt coded into it.
        File file1 = new File("T000.png");
        File file2 = new File("T001.png");

        BufferedImage img1 = ImageIO.read(file1);
        BufferedImage img2 = ImageIO.read(file2);

        // Compare the images
        if (areImagesEqual(img1, img2)) {
            System.out.println("These images look the same");
        } else {
            System.out.println("These images dont look the same.");
        }
    }

    public static boolean areImagesEqual(BufferedImage img1, BufferedImage img2) {
        // Check if dimensions are the same
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }

        // Compare pixel by pixel
        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }

        // Images are identical
        return true;
    }
}