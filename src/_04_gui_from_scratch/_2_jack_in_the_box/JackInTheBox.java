package _04_gui_from_scratch._2_jack_in_the_box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JackInTheBox implements ActionListener {
	
	public int count = 0;
	
	public void show() {
        System.out.println("JFrame showing");
        
        JFrame frame = new JFrame("Jack in the Box"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JButton button = new JButton();
        button.setText("Surprise?");
       
        frame.add(button);
        frame.pack();
        
        button.addActionListener((ActionListener) this);
           
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button clicked");
		
		//using count to trigger if statement to show  image
		count+=1;
		System.out.println(count);
		if(count==5) {
			showPicture("jackInTheBox.png");
			System.out.println("SURPRISE");
		}
		
	}

	private void showPicture(String fileName) {
	     try {
	          JLabel imageLabel = createLabelImage(fileName);
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private JLabel createLabelImage(String fileName) {
	     try {
	          URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	          } else {
	               Icon icon = new ImageIcon(imageURL);
	               JLabel imageLabel = new JLabel(icon);
	               return imageLabel;
	          }
	     } catch (Exception e) {
	          System.err.println("Could not find image " + fileName);
	          return new JLabel();
	     }
	}
	
	
	
}
