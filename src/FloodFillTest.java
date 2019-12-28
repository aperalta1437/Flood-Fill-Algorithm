import javax.imageio.ImageIO;           // Imports the ImageIO class for input, output image operations
import java.awt.image.BufferedImage;    // Imports the BufferedImage class to create an image buffer.
import java.io.File;                    // Imports the File class to create file paths.
import java.io.IOException;

public class FloodFillTest
{
    public static void main (String[] args) throws IOException
    {
        BufferedImage img = null;       // holds the given image.
        File filePath;                  // file path to where the image is and where the resultant image will be.

        try
        {
            filePath = new File("Sample_Image.png");
            img = ImageIO.read(filePath);                           // Reading the image from the file path and
                                                                    // storing it in the image buffer.
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        FloodFill customizer = new FloodFill(img);      // Creating a FloodFill object and passing the buffered
                                                        // image as an argument.


        customizer.floodFill(75, 75, FloodFill.ColorChoice.WHITE);

        filePath = new File("Sample_Image_Result.png");
        ImageIO.write(img, "png", filePath);            // Writing the the resultant image back in to
                                                                    // the path where the first one inhibited.
    }
}
