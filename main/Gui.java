package arcticpines.main;

/**import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Thu Feb 14 17:45:25 GMT 2013
 */



/**
 * @author Huw Williams
 
public class Gui extends JFrame {
	public Gui() {
		initComponents();
		bankingButton.setEnabled(false);
		radioButton1.setEnabled(false);
	}

	private void startButtonActionPerformed(ActionEvent e) {
		Variables.beaver = beaverButton.isSelected();
		Variables.urns = urnButton.isSelected();
		Variables.nests = nestButton.isSelected();
		Variables.obelisk = radioButton1.isSelected();
		Variables.banking = bankingButton.isSelected();
		
		Variables.guiOpen = false;
		this.dispose();
	}

	private void urnButtonActionPerformed(ActionEvent e) {
		bankingButton.setEnabled(true);
	} 

	private void nestButtonActionPerformed(ActionEvent e) {
		bankingButton.setEnabled(true);
	}
	
	private void beaverButtonActionPerformed(ActionEvent e) {
		bankingButton.setEnabled(true);
		radioButton1.setEnabled(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Huw Williams
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		urnButton = new JRadioButton();
		label4 = new JLabel();
		nestButton = new JRadioButton();
		label5 = new JLabel();
		beaverButton = new JRadioButton();
		startButton = new JButton();
		label6 = new JLabel();
		radioButton1 = new JRadioButton();
		label7 = new JLabel();
		bankingButton = new JRadioButton();

		//======== this ========
		setFont(new Font("Dialog", Font.PLAIN, 14));
		Container contentPane = getContentPane();

		//---- label1 ----
		label1.setText("Smooth's");
		label1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label1.setForeground(new Color(0, 255, 156));
		label1.setHorizontalTextPosition(SwingConstants.LEFT);

		//---- label2 ----
		label2.setText("Urns:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		//---- label3 ----
		label3.setText("Arctic Pines");
		label3.setFont(new Font("Tahoma", Font.BOLD, 28));
		label3.setForeground(new Color(0, 255, 156));

		//---- urnButton ----
		urnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				urnButtonActionPerformed(e);
			}
		});
		
		beaverButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beaverButtonActionPerformed(e);
			}
		});

		//---- label4 ----
		label4.setText("Nests:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 18));

		//---- nestButton ----
		nestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nestButtonActionPerformed(e);
			}
		});

		//---- label5 ----
		label5.setText("Beaver:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 18));

		//---- startButton ----
		startButton.setText("Start");
		startButton.setFont(startButton.getFont().deriveFont(startButton.getFont().getStyle() | Font.BOLD));
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}
		});

		//---- label6 ----
		label6.setText("Obelisk:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 18));

		//---- label7 ----
		label7.setText("Banking:");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 18));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(label4, GroupLayout.Alignment.TRAILING)
										.addComponent(label2, GroupLayout.Alignment.TRAILING)
										.addComponent(label5, GroupLayout.Alignment.TRAILING)
										.addComponent(label6, GroupLayout.Alignment.TRAILING)
										.addComponent(label7, GroupLayout.Alignment.TRAILING))
									.addGap(29, 29, 29)
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(urnButton)
										.addComponent(radioButton1)
										.addComponent(beaverButton)
										.addComponent(nestButton)
										.addComponent(bankingButton)))
								.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addComponent(label3))))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(34, 34, 34)
							.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label3)
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(label2)
						.addComponent(urnButton))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(label4)
						.addComponent(nestButton))
					.addGap(11, 11, 11)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(label5)
						.addComponent(beaverButton))
					.addGap(10, 10, 10)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(radioButton1)
						.addComponent(label6))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(label7)
						.addComponent(bankingButton))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(startButton)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Huw Williams
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JRadioButton urnButton;
	private JLabel label4;
	private JRadioButton nestButton;
	private JLabel label5;
	private JRadioButton beaverButton;
	private JButton startButton;
	private JLabel label6;
	private JRadioButton radioButton1;
	private JLabel label7;
	private JRadioButton bankingButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
	
	public Gui() {
		initComponents();
	}

	private void startButtonActionPerformed(ActionEvent e) {
		Variables.beaver = beaverButton.isSelected();
		Variables.urns = urnButton.isSelected();
		Variables.nests = nestButton.isSelected();
		Variables.banking = obeliskButton.isSelected();
		
		Variables.guiOpen = false;
		this.dispose();
	}

	private void initComponents() {
	label1 = new JLabel();
	label2 = new JLabel();
	label3 = new JLabel();
	urnButton = new JRadioButton();
	label4 = new JLabel();
	nestButton = new JRadioButton();
	label5 = new JLabel();
	beaverButton = new JRadioButton();
	startButton = new JButton();
	label6 = new JLabel();
	obeliskButton = new JRadioButton();
	//obeliskButton.setEnabled(false);

	//======== this ========
	setFont(new Font("Dialog", Font.PLAIN, 14));
	Container contentPane = getContentPane();

	//---- label1 ----
	label1.setText("Smooth's");
	label1.setFont(new Font("Tahoma", Font.BOLD, 28));
	label1.setForeground(new Color(0, 255, 156));
	label1.setHorizontalTextPosition(SwingConstants.LEFT);

	//---- label2 ----
	label2.setText("Urns:");
	label2.setFont(new Font("Tahoma", Font.PLAIN, 18));

	//---- label3 ----
	label3.setText("Arctic Pines");
	label3.setFont(new Font("Tahoma", Font.BOLD, 28));
	label3.setForeground(new Color(0, 255, 156));

	//---- label4 ----
	label4.setText("Nests:");
	label4.setFont(new Font("Tahoma", Font.PLAIN, 18));

	//---- label5 ----
	label5.setText("Beaver:");
	label5.setFont(new Font("Tahoma", Font.PLAIN, 18));

	//---- startButton ----
	startButton.setText("Start");
	startButton.setFont(startButton.getFont().deriveFont(startButton.getFont().getStyle() | Font.BOLD));
	startButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startButtonActionPerformed(e);
		}
	});

	//---- label6 ----
	label6.setText("Banking:");
	label6.setFont(new Font("Tahoma", Font.PLAIN, 18));

	GroupLayout contentPaneLayout = new GroupLayout(contentPane);
	contentPane.setLayout(contentPaneLayout);
	contentPaneLayout.setHorizontalGroup(
		contentPaneLayout.createParallelGroup()
			.addGroup(contentPaneLayout.createSequentialGroup()
				.addGroup(contentPaneLayout.createParallelGroup()
					.addGroup(contentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(contentPaneLayout.createParallelGroup()
							.addGroup(contentPaneLayout.createSequentialGroup()
								.addGroup(contentPaneLayout.createParallelGroup()
									.addComponent(label4, GroupLayout.Alignment.TRAILING)
									.addComponent(label2, GroupLayout.Alignment.TRAILING)
									.addComponent(label5, GroupLayout.Alignment.TRAILING)
									.addComponent(label6, GroupLayout.Alignment.TRAILING))
								.addGap(29, 29, 29)
								.addGroup(contentPaneLayout.createParallelGroup()
									.addComponent(urnButton)
									.addComponent(obeliskButton)
									.addComponent(beaverButton)
									.addComponent(nestButton)))
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(label3))))
					.addGroup(contentPaneLayout.createSequentialGroup()
						.addGap(39, 39, 39)
						.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(15, Short.MAX_VALUE))
	);
	contentPaneLayout.setVerticalGroup(
		contentPaneLayout.createParallelGroup()
			.addGroup(contentPaneLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(label1)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(label3)
				.addGap(18, 18, 18)
				.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(label2)
					.addComponent(urnButton))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(label4)
					.addComponent(nestButton))
				.addGap(11, 11, 11)
				.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(label5)
					.addComponent(beaverButton))
				.addGap(10, 10, 10)
				.addGroup(contentPaneLayout.createParallelGroup()
					.addComponent(obeliskButton)
					.addComponent(label6))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(startButton)
				.addContainerGap(7, Short.MAX_VALUE))
	);
	pack();
	setLocationRelativeTo(getOwner());
	// JFormDesigner - End of component initialization  //GEN-END:initComponents
}

// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
// Generated using JFormDesigner Evaluation license - Huw Williams
private JLabel label1;
private JLabel label2;
private JLabel label3;
private JRadioButton urnButton;
private JLabel label4;
private JRadioButton nestButton;
private JLabel label5;
private JRadioButton beaverButton;
private JButton startButton;
private JLabel label6;
private JRadioButton obeliskButton;
// JFormDesigner - End of variables declaration  //GEN-END:variables
}
