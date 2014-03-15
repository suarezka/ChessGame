package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

/**
 * GVTile is a clickable GUI element for rendering a cell in the mine field
 * 
 * @author Hans Dulimarta
 * @version Winter 2014
 */
@SuppressWarnings("serial")
public class GVTile extends JButton {
    private static final String IMAGE_DIR = "images\\";
    private static final int SIZE = 64;
    public enum ImageType {
        NO_IMAGE,
        ROOK,
        BISHOP,
}  
    
    private static int size;
    private static BufferedImage whiteBishop, blackBishop;
    private Color back;
    private BufferedImage img;
    
    static { 
    	File imgFile;
    	
    	BufferedImage image;
		ImageIcon icon = loadIcon(IMAGE_DIR + "b_bish.png");
		image = convertToBuffedImage(icon);
		blackBishop = image;
    }
    
    public GVTile (boolean useDarkBg)
    {
        this (ImageType.NO_IMAGE, false, useDarkBg);
    }
    
    private static BufferedImage convertToBuffedImage(ImageIcon icon) {
    	BufferedImage bi = new BufferedImage(
    			icon.getIconWidth(),
    			icon.getIconHeight(),
    			BufferedImage.TYPE_INT_RGB);
    	Graphics g = bi.createGraphics();
    	// paint the Icon to the BufferedImage.
    	icon.paintIcon(null, g, 0,0);
    	g.dispose();
    	return bi;
    }

	public GVTile(ImageType kind, boolean isWhitePiece, boolean useDarkBg)
    {
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        back = useDarkBg ? new Color (120, 40, 84) : new Color (200, 200, 50);
        setPreferredSize(new Dimension (SIZE, SIZE));
        showImage(kind, isWhitePiece);
    }

    public void showImage (ImageType kind, boolean isWhitePiece)
    {
        switch (kind) {
        case ROOK:
        	//img = isWhitePiece ? whiteRook : blackRook;
        	//break;
        case BISHOP:
            img = isWhitePiece ? whiteBishop : blackBishop;
            break;
        }
        repaint();
    }
    
    public BufferedImage getImage() { return img; }

    public void setImage(BufferedImage im) {
        img = im;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(back);
        g.fillRect(0, 0, SIZE, SIZE);
        if (img != null) {
            g.drawImage(img, 0, 0, SIZE, SIZE, 0, 0, img.getWidth(), img.getHeight(), null);
        }
    }
    
    /****************************************************************
     * Static method to load the ImageIcon from the given location.
     *
     * @param name Name of the file.
     * @return the requested image.
     ***************************************************************/
    public static ImageIcon loadIcon(String name) {
    	java.net.URL imgURL = ChessGUI.class.getResource(name);
    	if (imgURL == null) {
    		throw new RuntimeException("Icon resource not found.");
    	}

    	return new ImageIcon(imgURL);
    }
    
}