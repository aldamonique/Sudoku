package sudoku;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Cronometro extends JLabel {

	private static final long serialVersionUID = 1L;
	private static String time;
	private static Cronometro instance;
	private int counter;
	private boolean isRunning;


	public static String getTime() {
		return time;
	}
	public void setTime(String time) {
		super.setText(time);
	}
	private Cronometro() {
		super("00:00:00");
		this.counter = 0;
	}
	
	public static Cronometro getInstance() {
		if(instance == null) {
			instance = new Cronometro();
		}
		return instance;
	}
	private Timer t = new Timer(1000, new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
		  counter++; 
          int hours = counter / 3600;
          int minutes = (counter % 3600) / 60;
          int seconds = counter % 60;
          time = String.format("%02d:%02d:%02d", hours, minutes, seconds);                 
          setTime(time);
		}
	});	
	
	public void startTimer() {
		if(!isRunning) {
			t.start();
			isRunning = true; 
		}
		//t.start();
	}
	
	public void stopTimer() {
		if(isRunning) {
			t.stop();
			isRunning = false; 
		}
	}
	public void restartTimer() {
		//t.restart();
		//this.counter = 0;
		
		//setTime("00:00:00");
	}
}
