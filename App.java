package sourceCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App implements ActionListener {
	
	public static int input;
	public static int computerInput;
	
	private JFrame frame, decisionFrame;
	private JPanel homePanel, decisionPanel;
	private JLabel selectLabel, computerLabel, outcome;
	private JButton rock, paper, scissors, retry, exit;
	
	public App() {
		
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		homePanel = new JPanel();
		homePanel.setLayout(null);
		frame.add(homePanel);
		
		selectLabel = new JLabel("Select!");
		selectLabel.setForeground(Color.BLACK);
		selectLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
		selectLabel.setSize(200, 75);
		selectLabel.setLocation(200, 10);
		homePanel.add(selectLabel);
		
		rock = new JButton("Rock");
		rock.setFont(new Font("Helvetica", Font.PLAIN, 20));
		rock.setSize(120, 50);
		rock.setLocation(40, 70);
		rock.addActionListener(this);
		homePanel.add(rock);
		
		paper = new JButton("Paper");
		paper.setFont(new Font("Helvetica", Font.PLAIN, 20));
		paper.setSize(120, 50);
		paper.setLocation(190, 70);
		paper.addActionListener(this);
		homePanel.add(paper);
		
		scissors = new JButton("Scissors");
		scissors.setFont(new Font("Helvetica", Font.PLAIN, 20));
		scissors.setSize(120, 50);
		scissors.setLocation(340, 70);
		scissors.addActionListener(this);
		homePanel.add(scissors);
		
		
		
		decisionFrame = new JFrame();
		decisionFrame.setSize(500, 500);
		decisionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		decisionPanel = new JPanel();
		decisionPanel.setLayout(null);
		decisionFrame.add(decisionPanel);
		
		computerLabel = new JLabel("Computer Chose: ");
		computerLabel.setForeground(Color.BLACK);
		computerLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
		computerLabel.setSize(500, 75);
		computerLabel.setLocation(100, 10);
		decisionPanel.add(computerLabel);
		
		outcome = new JLabel("You ");
		outcome.setForeground(Color.BLACK);
		outcome.setFont(new Font("Helvetica", Font.BOLD, 30));
		outcome.setSize(200, 75);
		outcome.setLocation(150, 60);
		decisionPanel.add(outcome);
		
		retry = new JButton("Retry");
		retry.setFont(new Font("Helvetica", Font.PLAIN, 20));
		retry.setSize(100, 100);
		retry.setLocation(125, 200);
		retry.addActionListener(this);
		decisionPanel.add(retry);
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Helvetica", Font.PLAIN, 20));
		exit.setSize(100, 100);
		exit.setLocation(235, 200);
		exit.addActionListener(this);
		decisionPanel.add(exit);
		
		
		
		
		
		
		
		frame.setVisible(true);
		decisionFrame.setVisible(false);
		
	}

	public static void main(String[] args) {
//		int input = 1;
//		System.out.println(decision(1));
		
		new App();
	}
	
	/**
	 * helper method to decide the outcome based on the user input
	 * and randomly generated computer choice
	 * 1 -> rock
	 * 2-> paper
	 * 3 -> scissors
	 * @param input -> user input for choice between rock paper scissors
	 * @return integer sentinel value of game decision
	 * 0 -> draw
	 * -1 -> user loss
	 * 1 -> user win
	 */
	private static int decision(int input) {
		int computer = (int)(Math.random()*4 + 1);
		System.out.println("computer: " + computer);
		computerInput = computer;
		if (input == 1) {
			if (computer == 1) {
				return 0;
			} else if (computer == 2) {
				return -1;
			} else {
				return 1;
			}
		}
		if (input == 2) {
			if (computer == 1) {
				return 1;
			} else if (computer == 2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (computer == 1) {
				return -1;
			} else if (computer == 2) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	private void setWinner(int input) {
		int result = decision(input);
		if (computerInput == 1) {
			computerLabel.setText("Computer Chose: rock");
		} else if (computerInput == 2) {
			computerLabel.setText("Computer Chose: paper");
		} else {
			computerLabel.setText("Computer Chose: scissors");
		}
		if (result == 0) {
			outcome.setText("Draw!");
		} else if (result == 1) {
			outcome.setText("You win!");
		} else {
			outcome.setText("You lose!");
		}
		decisionFrame.setVisible(true);
		frame.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rock) {
			input = 1;
			setWinner(input);
		} else if (e.getSource() == paper) {
			input = 2;
			setWinner(input);
		} else if (e.getSource() == scissors) {
			input = 3;
			setWinner(input);
		}
		if (e.getSource() == retry) {
			decisionFrame.setVisible(false);
			frame.setVisible(true);
		} if (e.getSource() == exit) {
			System.exit(0);
		}
		
	}

}
