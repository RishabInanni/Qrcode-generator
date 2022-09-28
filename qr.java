package qrcode;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.util.*;
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  

public class qr extends JFrame {

	private JPanel contentPane;
	private JTextField link;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qr frame = new qr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the frame.
	 */
	public qr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(143, 76, 616, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QR_CODE");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 32));
		lblNewLabel.setBounds(240, 28, 139, 67);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Link");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		lblNewLabel_1.setBounds(102, 260, 147, 54);
		contentPane.add(lblNewLabel_1);
		
		link = new JTextField();
		link.setBounds(247, 267, 512, 38);
		contentPane.add(link);
		link.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String QrCodeData = link.getText();
					String filepath="C://Users//KIIT//eclipse-workspace1//qrcode//start.png";
					String charset = "UTF-8";  
					
			
					Map <EncodeHintType, ErrorCorrectionLevel> hintmap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
					
					//generates QR code with Low level(L) error correction capability  
					hintmap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
					
					//invoking the user-defined method that creates the QR code  
					BitMatrix matrix = new MultiFormatWriter().encode(new String(QrCodeData.getBytes(charset), charset), BarcodeFormat.QR_CODE, 200, 200,hintmap);  
					MatrixToImageWriter.writeToFile(matrix, filepath.substring(filepath.lastIndexOf('.') + 1), new File(filepath));    
					//prints if the QR code is generated   
					System.out.println("QR Code created successfully at location"+filepath); 
					JFrame frame =new JFrame();
					ImageIcon icon=new ImageIcon("C://Users//KIIT//eclipse-workspace1//qrcode//start.png");
					JLabel label = new JLabel(icon);
					frame.add(label);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.pack();
					frame.setVisible(true);
					

				}
				catch(Exception ex) {
					System.out.println(ex);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		btnNewButton.setBounds(649, 358, 110, 38);
		contentPane.add(btnNewButton);
	}
}
