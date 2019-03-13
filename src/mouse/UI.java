package mouse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI {

	private JFrame frame;
	private Mouse mouse;
	private boolean running;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.mouse = new Mouse();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 235, 109);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 47, 89, 14);
		frame.getContentPane().add(lblState);
		
		final JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!running)
					try {
						mouse.nmzStart();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
					mouse.nmzStop();
				lblState.setText("State: " + (running ? "false" : "true"));
				btnStart.setText(running ? "start" : "stop");
				running = !running;
			
				
			}
		});
		btnStart.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JLabel lblBigDickNmz = new JLabel("BIG DICK NMZ");
		lblBigDickNmz.setBounds(136, 47, 83, 14);
		frame.getContentPane().add(lblBigDickNmz);
		
		
	}
}
