import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;
import javax.swing.JOptionPane; 


public class compareGUI {

    public static void main(String[] args) throws IOException {



        String name = JOptionPane.showInputDialog("TYPE your image");
        String name2 = JOptionPane.showInputDialog("TYPE your 2nd image");

        //File file1 = new File(name);

        ImageIcon image = new ImageIcon(name);
        ImageIcon image2 = new ImageIcon(name2);

        File file1 = new File(name);
        File file2 = new File(name2);

        BufferedImage pic = ImageIO.read(file1);
        BufferedImage pic2 = ImageIO.read(file2);


        JLabel label = new JLabel();
        label.setIcon(image);

        JLabel label2 = new JLabel();
        label2.setIcon(image2);



        //JOptionPane.showMessageDialog (null, "both are the same");

        if (areImagesEqual(pic, pic2)) {
            JOptionPane.showMessageDialog (null, "both are the same");
        } else {
            JOptionPane.showMessageDialog (null, "These images dont look the same.");
        }
    }


        public static boolean areImagesEqual(BufferedImage pic, BufferedImage pic2) {
        // Check if dimensions are the same
        if (pic.getWidth() != pic2.getWidth() || pic.getHeight() != pic2.getHeight()) {
            return false;
        }

        // Compare pixel by pixel
        for (int y = 0; y < pic.getHeight(); y++) {
            for (int x = 0; x < pic.getWidth(); x++) {
                if (pic.getRGB(x, y) != pic2.getRGB(x, y)) {
                    return false;
                }
            }
        }

        // Images are identical
        return true;
    }


    }


