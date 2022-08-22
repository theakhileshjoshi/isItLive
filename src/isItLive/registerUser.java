package isItLive;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class registerUser {

	private JFrame frmIsitlive;
	private JTextField userName;
	private JTextField userEmail;
	private JLabel lblNewLabel_2;
	private JTextField noOfHours;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_3;
	private JTextField userURL;
	private JLabel status;
	
	backEnd be = new backEnd();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerUser window = new registerUser();
					window.frmIsitlive.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registerUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsitlive = new JFrame();
		frmIsitlive.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmIsitlive.setTitle("isItLive");
		frmIsitlive.setResizable(false);
		frmIsitlive.setBounds(0, 0, 680, 560);
		frmIsitlive.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIsitlive.getContentPane().setLayout(null);
		
		
		//All the Labels
		JLabel lblNewLabel = new JLabel("isItLive");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(237, 10, 161, 44);
		frmIsitlive.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(137, 80, 95, 33);
		frmIsitlive.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(137, 143, 95, 33);
		frmIsitlive.getContentPane().add(lblNewLabel_1_1);
		
		lblNewLabel_2 = new JLabel("Hours");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(137, 209, 95, 33);
		frmIsitlive.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("URL");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(137, 275, 95, 33);
		frmIsitlive.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_1_2 = new JLabel("Message");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(137, 341, 95, 33);
		frmIsitlive.getContentPane().add(lblNewLabel_1_2);
		
		//All the text fields
		
		userName = new JTextField();
		userName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userName.setBounds(269, 80, 247, 33);
		frmIsitlive.getContentPane().add(userName);
		userName.setColumns(10);
		
		userEmail = new JTextField();
		userEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userEmail.setColumns(10);
		userEmail.setBounds(269, 143, 247, 33);
		frmIsitlive.getContentPane().add(userEmail);
		
		noOfHours = new JTextField();
		noOfHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noOfHours.setColumns(10);
		noOfHours.setBounds(269, 209, 122, 33);
		frmIsitlive.getContentPane().add(noOfHours);
		
		userURL = new JTextField();
		userURL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userURL.setColumns(10);
		userURL.setBounds(269, 275, 247, 33);
		frmIsitlive.getContentPane().add(userURL);
		
		JTextArea userMessage = new JTextArea();
		userMessage.setBounds(269, 341, 247, 82);
		frmIsitlive.getContentPane().add(userMessage);
		userMessage.setBorder(userName.getBorder());
		
		//All the buttons
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(179, 455, 122, 33);
		frmIsitlive.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					URI uri = new URI(userURL.getText());
					URL url = uri.toURL();
					int response = be.tryConnection(url);
					if(response == 200)status.setText("Website is Live!!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					status.setText("Something's wrong with the URL");
				}
			}
			
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(353, 455, 122, 33);
		frmIsitlive.getContentPane().add(btnClear);
		
		status = new JLabel("");
		status.setVerticalTextPosition(SwingConstants.TOP);
		status.setVerticalAlignment(SwingConstants.TOP);
		status.setForeground(Color.RED);
		status.setFont(new Font("Tahoma", Font.PLAIN, 14));
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setBounds(10, 498, 666, 25);
		frmIsitlive.getContentPane().add(status);
		
		
	}
}
