package pokeapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class PokeHomePage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String myPokeName;
	private String enemyPokeName;

	/**
	 * Launch the application.
	 */
	public static void selectScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokeHomePage window = new PokeHomePage();
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
	public PokeHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 262, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 440, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel select_poke = new JLabel("Select two Pokemons");
		sl_panel.putConstraint(SpringLayout.NORTH, select_poke, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, select_poke, -127, SpringLayout.EAST, panel);
		panel.add(select_poke);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 56, SpringLayout.SOUTH, select_poke);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, select_poke);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 19, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel my_poke = new JLabel("My Pokemon");
		sl_panel.putConstraint(SpringLayout.NORTH, my_poke, 5, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, my_poke, 28, SpringLayout.WEST, panel);
		panel.add(my_poke);
		
		JLabel enemy_poke = new JLabel("Enemy Pokemon");
		sl_panel.putConstraint(SpringLayout.NORTH, enemy_poke, 5, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, enemy_poke, 0, SpringLayout.WEST, my_poke);
		panel.add(enemy_poke);
		
		JButton battlr_button = new JButton("Battle");
		battlr_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 myPokeName = textField.getText();
				 enemyPokeName = textField_1.getText();
				try {
					Battle_Screen();
				} catch (NullPointerException | IOException | InterruptedException | ExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.SOUTH, battlr_button, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, battlr_button, -10, SpringLayout.EAST, panel);
		panel.add(battlr_button);
	
	

		

	}
	
	private void Battle_Screen() throws NullPointerException, IOException, InterruptedException, ExecutionException {
		PokeMainUI screen = new PokeMainUI(myPokeName,enemyPokeName);
		screen.pokeUI(myPokeName,enemyPokeName);
		frame.dispose();
		
	}

}
