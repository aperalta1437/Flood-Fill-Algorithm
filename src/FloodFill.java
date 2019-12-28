import java.awt.*;                          // Color.
import java.awt.image.BufferedImage;

/**
 * FloodFill.java
 * <p>
 * <h1>FloodFill</h1>
 * Objects of this class can take images and use the Flood Fill algorithm to change an
 * area of pixels sharing the same color to a different color.
 * <p>
 * @authors Logan Moloshok & Angel Peralta
 * @since 28MAR2019 12:40 EST
 */
public class FloodFill
{
    /**
     * ColorChoice represents all possible colors to select that are also represent a constant in the Color class.
     */
    public enum ColorChoice
    {BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW}

    private BufferedImage img;              // The image to to change.
    private int width;                      // The width of the image.
    private int height;                     // the height if the image.
    private boolean[][] visited;            // A two-dimensional array resembling the already visited pixels in the image.
    private int targetPixel;                // Holds the color value of the pixel from which the flood fill will take place.
    private int toColor;                    // Holds the color value to that will be assign to the area of of pixels.

    /**
     * Initializes the image, its width, height and the two-dimensional array that resembles the already visited pixels.
     * @param img
     */
    public FloodFill(BufferedImage img)
    {
        this.img = img;
        width = img.getWidth();
        height = img.getHeight();
        visited = new boolean[height][width];
    }

    /**
     * Changes the pixel area from the color it already has to another color.
     * @param x
     * @param y
     * @param replacement
     */
    public void floodFill(int x, int y, ColorChoice replacement)
    {
        targetPixel = img.getRGB(x,y);
        toColor = toPixelValue(replacement);

        recFloodFill(x, y);
    }

    /**
     * Recursively changes the value of pixels sharing the same pixel value and area with the chosen one.
     * @param x
     * @param y
     */
    private void recFloodFill(int x, int y)
    {
        if (x >= height || x < 0 || y >= width || y < 0)
            return;

        if (img.getRGB(x, y) == targetPixel && !visited[x][y])
        {
            img.setRGB(x, y, toColor);
            visited[x][y] = true;

            recFloodFill(x - 1, y);
            recFloodFill(x, y - 1);
            recFloodFill(x + 1, y);
            recFloodFill(x, y + 1);
        }
    }

    /**
     * Returns the pixel value of the given ColorChoice value.
     * @param color
     * @return
     */
    private int toPixelValue(ColorChoice color)
    {
        int pixelValue = 0;

        switch (color)
        {
            case BLACK:
                pixelValue = Color.BLACK.getRGB();
                break;
            case BLUE:
                pixelValue = Color.BLUE.getRGB();
                break;
            case CYAN:
                pixelValue = Color.CYAN.getRGB();
                break;
            case DARK_GRAY:
                pixelValue = Color.DARK_GRAY.getRGB();
                break;
            case GRAY:
                pixelValue = Color.GRAY.getRGB();
                break;
            case GREEN:
                return Color.GRAY.getRGB();
            case LIGHT_GRAY:
                pixelValue = Color.LIGHT_GRAY.getRGB();
                break;
            case MAGENTA:
                pixelValue = Color.MAGENTA.getRGB();
                break;
            case ORANGE:
                pixelValue = Color.ORANGE.getRGB();
                break;
            case PINK:
                pixelValue = Color.PINK.getRGB();
                break;
            case RED:
                pixelValue = Color.RED.getRGB();
                break;
            case WHITE:
                pixelValue = Color.WHITE.getRGB();
                break;
            case YELLOW:
                pixelValue = Color.YELLOW.getRGB();
                break;
        }
        return pixelValue;
    }
}
