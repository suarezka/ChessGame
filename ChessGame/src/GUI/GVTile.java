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
    private static final String IMAGE_DIR = "/Users/Kaye/git/ChessGame3/ChessGame/scr/GUI/images/";
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
        size = 44;
        File imgFile;
        try {
            BufferedImage temp;
            imgFile = new File (IMAGE_DIR + "b_bish.png");
            temp = ImageIO.read(imgFile);
            blackBishop = temp;
            //final int W = temp.getWidth();
            //final int H = temp.getHeight();
            //whiteBishop = temp.getSubimage(0, 0, W/2, H);
            //blackBishop = temp.getSubimage(W/2, 0, W/2, H);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public GVTile (boolean useDarkBg)
    {
        this (ImageType.NO_IMAGE, false, useDarkBg);
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

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(back);
        g.fillRect(0, 0, SIZE, SIZE);
        if (img != null) {
            g.drawImage(img, 0, 0, SIZE, SIZE, 0, 0, img.getWidth(), img.getHeight(), null);
        }
    }
    
}