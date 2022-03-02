package _04_gui_from_scratch._3_sound_effects_machine;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffectMachine implements ActionListener {

	JFrame frame = new JFrame("Sound Effects");
	JPanel panel = new JPanel();
	
	JButton sound1 = new JButton("Sound 1");
	JButton sound2 = new JButton("Sound 2");
	
	public void show() {
		System.out.println("show running");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		sound1.addActionListener((ActionListener) this);
		sound2.addActionListener((ActionListener) this);
		
		frame.add(panel);
		panel.add(sound1);
		panel.add(sound2);
		
		frame.pack();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed == sound1) {
			System.out.println("Sound 1 pressed.");
			playSound("sawing-wood-daniel_simon.wav");
		}
		
	}
	
	private void playSound(String soundFile) {
			//creates variable for the path
			String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			//creates a file object with the path file and sound inputed
			File sound = new File(path+soundFile);
			//uses exist method 
			if (sound.exists()) {
				//using lambda to execute sound
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000); //giving it time
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}
	
//	private void playSound(String fileName) {
//	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName)); 
//	    sound.play();
//	}

}
