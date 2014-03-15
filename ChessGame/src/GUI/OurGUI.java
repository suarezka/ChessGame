package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

/************************************************************
 * CIS 163-07
 * Chess Project
 * GUI For the chess game
 *
 * @author Kaye Suarez
 * @author DaiLynn Dietz
 * @version Mar 15, 2014
 ************************************************************/
public class OurGUI implements ActionListener {

	private static final int IMAGE_SIZE = 64;
	private ImageIcon w_Bish = loadIcon("images\\w_bish.png");
	
	/****************************************************************
     * Static method to load the ImageIcon from the given location.
     *
     * TODO you might not need this
     *
     * @param name Name of the file.
     * @return the requested image.
     ***************************************************************/
    public static ImageIcon loadIcon(String name) {
    	java.net.URL imgURL = ChessGUI.class.getResource(name);
    	if (imgURL == null) {
    		throw new RuntimeException("Icon resource not found.");
    	}

    	ImageIcon icon = new ImageIcon(imgURL);
    	Image img = icon.getImage();
    	Image resize = img.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, 
    			Image.SCALE_AREA_AVERAGING);
    	
    	return new ImageIcon(resize);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
