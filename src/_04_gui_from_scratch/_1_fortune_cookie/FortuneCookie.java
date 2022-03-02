package _04_gui_from_scratch._1_fortune_cookie;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FortuneCookie implements ActionListener {
	
	public void showButton() {
        System.out.println("Button showed");
        
        JFrame frame = new JFrame("Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JButton button = new JButton();
        button.setText("Click here!");
        button.addActionListener((ActionListener) this);
        frame.add(button);
        frame.pack();
           
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button clicked");
		JOptionPane.showMessageDialog(null, "WOOHOOO!");
		
	}
	
	

}
