package iBanking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.SpringLayout;

// import javafx.scene.paint.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class iBanking {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel greetings;
	JLabel message;
	JLabel AccountBalance, Amount;
	JButton Go;
	double money;
	JLabel textAccount, textDesc, textDebited, textBalance, textCredit, textLegger, notification;

	JButton submit, withdrawal, deposit, transfer;

	private double credit;
	private double debit;
	private double accountBalance;
	int balanceInfo;
	Scanner ty;
	int collection;

	double newBalance;

	JLabel error = new JLabel("Invalid details");

	JPanel panel, panel_1, panel_2, panel_3, panel_4;
	JLabel accountNumber;

	// Declaring global variables for logic
	private long AccountNumber[] = { 1009161480, 1021345618, 1008778188 };
	private String customerName[] = { "Dennis Shaba", "Nike Troy", "Ella Oyime" };
	private long passCode[] = { 1881, 9989, 1091 };

	private int userInput, pin;
	private JTextField textField_2, AmountField;
	private JButton logout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iBanking window = new iBanking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public iBanking() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		// the frame of the application
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		// here we have all respective panels
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(20, 11, 375, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("  iBANKING");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Swis721 Blk BT", Font.PLAIN, 23));
		lblNewLabel_2
				.setIcon(new ImageIcon("C:\\Users\\User 5\\Documents\\Software Egineering\\Java\\icons\\bank.png"));
		lblNewLabel_2.setIconTextGap(3);
		lblNewLabel_2.setMaximumSize(new Dimension(142, 10));
		lblNewLabel_2.setBounds(24, 6, 199, 54);
		panel.add(lblNewLabel_2);

		// Logout Button. this will close the window
		logout = new JButton("Logout");
		logout.setVisible(false);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
			}
		});
		logout.setBounds(279, 17, 90, 34);
		panel.add(logout);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(20, 88, 188, 183);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		// panel_1.setBackground(Color.PINK);

		// This textfields hold the account number and the pin.
		textField = new JTextField();
		textField.setBounds(49, 105, 91, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(21, 48, 141, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Account Number");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(49, 23, 91, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pin Number");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(63, 79, 77, 14);
		panel_1.add(lblNewLabel_1);

		// Login Button. this login button will check and validate the users account
		// number and pin
		submit = new JButton("Submit");
		submit.setBounds(59, 145, 77, 28);
		panel_1.add(submit);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// try catch to check and ensure that the users entered a valid datatype (int)
				try {
					userInput = Integer.parseInt(textField_1.getText());
				} catch (NullPointerException nullPointer) {

				}
				try {
					pin = Integer.parseInt(textField.getText());
				} catch (NullPointerException nullPointer) {

				}

				for (int n = 0; n < customerName.length; n++) {

				}

				for (int i = 0; i < AccountNumber.length; i++) {

				}

				if (userInput == AccountNumber[0] && pin == passCode[0]) {

					message.setText("Hi " + customerName[0]);
					AccountBalance.setText("Account Balance: " + accountBalance);
					textField_1.setEnabled(false);
					textField.setEnabled(false);
					submit.setEnabled(false);
					withdrawal.setEnabled(true);
					deposit.setEnabled(true);
					logout.setVisible(true);

				} else if (userInput == AccountNumber[1] && pin == passCode[1]) {

					message.setText("Hi " + customerName[1]);
					AccountBalance.setText("Account Balance: " + accountBalance);
					textField_1.setEnabled(false);
					textField.setEnabled(false);
					submit.setEnabled(false);
					withdrawal.setEnabled(true);
					deposit.setEnabled(true);
					logout.setVisible(true);

				} else if (userInput == AccountNumber[2] && pin == passCode[2]) {

					message.setText("Hi " + customerName[2]);
					AccountBalance.setText("Account Balance: " + accountBalance);
					textField_1.setEnabled(false);
					textField.setEnabled(false);
					submit.setEnabled(false);
					withdrawal.setEnabled(true);
					deposit.setEnabled(true);
					logout.setVisible(true);
				} else if (userInput == 0 && pin == 0) {
					JOptionPane.showConfirmDialog(null, "Enter your Account Number", "Login Validation",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
				}

				else {
					JOptionPane.showConfirmDialog(null, "Invalid Login Details", "Login Validation",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
				}

			}

		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(218, 87, 177, 184);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		// Withdrawal Button with evenlistener. this button will active the AmountField
		// and then carryout a withdral
		withdrawal = new JButton("Withrawal");
		withdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Go.setEnabled(true);
				AmountField.setEnabled(true);
				try {
					money = Double.parseDouble(AmountField.getText());
				} catch (NumberFormatException ex) {

				}
				if (accountBalance == 0) {
					AccountBalance.setText("Insufficient Balance" + accountBalance);
				} else {
					accountBalance -= money;
					AccountBalance.setText("New Balance: " + accountBalance);
					// This will display on the notification panel
					notification.setText("Notification");
					textDesc.setText("A transaction just occured");
					textDebited.setText("Account Debited: " + money);
					textBalance.setText("Current Balance: " + accountBalance);
					double legger = accountBalance + money;
					textLegger.setText("Legger Balance: " + legger);

				}

			}
			// 1009161480
		});
		withdrawal.setBounds(41, 49, 100, 23);
		panel_2.add(withdrawal);

		// Deposit Button also contain logic to check the AmountField and then carry out
		// a deposit
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Go.setEnabled(true);
				AmountField.setEnabled(true);
				try {
					money = Double.parseDouble(AmountField.getText());
				} catch (NumberFormatException ex) {

				}
				accountBalance += money;
				AccountBalance.setText("New Balance: " + accountBalance);

				if (money == 0) {
					textBalance.setText("Please Enter an Amount ");
				} else {
					// This will display on the notification panel
					notification.setText("Notification");
					textDesc.setText("***Successful Transaction***");
					textDebited.setText("Amount Credited: " + money);
					textBalance.setText("Current Balance: " + accountBalance);
					double legger = accountBalance - money;
					textLegger.setText("Legger Balance: " + legger);
				}

			}

		});
		deposit.setBounds(41, 89, 100, 23);
		panel_2.add(deposit);

		transfer = new JButton("Transfer");
		transfer.setBounds(41, 129, 100, 23);
		panel_2.add(transfer);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(0, 0, 128));
		panel_3.setBounds(405, 88, 258, 183);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		// This section will display transaction details
		notification = new JLabel("");
		notification.setForeground(new Color(0, 255, 255));
		notification.setFont(new Font("SansSerif", Font.PLAIN, 24));
		notification.setBounds(64, 18, 129, 23);
		panel_3.add(notification);

		textDesc = new JLabel("");
		textDesc.setForeground(new Color(255, 255, 255));
		textDesc.setBounds(30, 50, 230, 20);
		textDesc.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textDesc.setVisible(true);
		panel_3.add(textDesc);
		// textAccount, textDesc, textDate, textBalance, textCredit

		textDebited = new JLabel("");
		textDebited.setForeground(new Color(255, 255, 255));
		textDebited.setBounds(30, 70, 200, 20);
		textDebited.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textDebited.setVisible(true);
		panel_3.add(textDebited);

		textBalance = new JLabel("");
		textBalance.setForeground(new Color(255, 255, 255));
		textBalance.setBounds(30, 90, 200, 20);
		textBalance.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textBalance.setVisible(true);
		panel_3.add(textBalance);

		textLegger = new JLabel("");
		textLegger.setForeground(new Color(255, 255, 255));
		textLegger.setBounds(30, 120, 200, 20);
		textLegger.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textLegger.setVisible(true);
		panel_3.add(textLegger);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(SystemColor.textHighlight);
		panel_4.setBounds(405, 11, 258, 66);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(SystemColor.textHighlight);
		panel_5.setBounds(20, 282, 643, 146);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(SystemColor.textHighlight);
		panel_6.setBounds(146, 32, 319, 69);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		greetings = new JLabel("");
		greetings.setBounds(40, 15, 300, 20);
		panel_4.add(greetings);

		message = new JLabel("");
		message.setBounds(40, 12, 300, 20);
		panel_4.add(message);

		AccountBalance = new JLabel("");
		AccountBalance.setBounds(40, 30, 300, 20);
		panel_4.add(AccountBalance);

		// Amount Field
		Amount = new JLabel("Amount");
		Amount.setForeground(SystemColor.text);
		Amount.setBounds(51, 26, 55, 16);
		panel_6.add(Amount);

		AmountField = new JTextField();
		AmountField.setBounds(107, 16, 100, 33);
		panel_6.add(AmountField);
		AmountField.setColumns(10);
		AmountField.setEnabled(false);

		Go = new JButton("Go");
		Go.setBounds(207, 24, 50, 20);
		Go.setEnabled(false);
		Go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				money = Integer.parseInt(AmountField.getText());

			}// 1009161480

		});

		deposit.setEnabled(false);
		transfer.setEnabled(false);
		withdrawal.setEnabled(false);

	}
}
