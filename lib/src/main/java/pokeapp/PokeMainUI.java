package pokeapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.SpringLayout;
import javax.swing.JList;

import java.awt.image.*;
import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;

public class PokeMainUI {

	private JFrame frame;
	private Pokemon myPoke;
	private Pokemon enemyPoke;

	/**
	 * Launch the application.
	 */
	public static void pokeUI(String my_poke_name, String enemy_poke_name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokeMainUI window = new PokeMainUI(my_poke_name, enemy_poke_name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws NullPointerException 
	 */
	public PokeMainUI(String myPoke, String enemyPoke) throws NullPointerException, IOException, InterruptedException, ExecutionException {
		this.myPoke = new Pokemon(myPoke);
		this.enemyPoke = new Pokemon(enemyPoke);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel Enemy_Poke_IMG = new JLabel("");
		Enemy_Poke_IMG.setToolTipText(enemyPoke.toolTip());
		URL url = new URL(enemyPoke.img_url);
		ImageIcon enemy_poke_img = new ImageIcon(url);
		Enemy_Poke_IMG.setIcon(enemy_poke_img);
		sl_panel.putConstraint(SpringLayout.NORTH, Enemy_Poke_IMG, 60, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Enemy_Poke_IMG, 246, SpringLayout.WEST, panel);
		panel.add(Enemy_Poke_IMG);
		
		JLabel My_Poke_IMG = new JLabel("");
		My_Poke_IMG.setToolTipText(myPoke.toolTip());
		URL url1 = new URL(myPoke.img_url);
		ImageIcon my_poke_img = new ImageIcon(url1);
		My_Poke_IMG.setIcon(my_poke_img);
		sl_panel.putConstraint(SpringLayout.NORTH, My_Poke_IMG, 141, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, My_Poke_IMG, 60, SpringLayout.WEST, panel);
		panel.add(My_Poke_IMG);

		
		JList my_actions = new JList();
		panel.add(my_actions);
		
		JList enemy_actions = new JList();
		enemy_actions.setToolTipText("");
		panel.add(enemy_actions);
	}

}
