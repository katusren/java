package chapter06;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MazeGame extends JFrame implements KeyListener {
	int[][] maze;
	int cellSize = 20;

	int playerX = 1;
	int playerY = 1;

	public MazeGame(String difficulty) {
		setTitle("🧩 Maze Generator Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		switch (difficulty.toLowerCase()) {
		case "easy" -> maze = new MazeGenerator(15, 15).getMaze();
		case "medium" -> maze = new MazeGenerator(25, 25).getMaze();
		case "hard" -> maze = new MazeGenerator(35, 35).getMaze();
		default -> maze = new MazeGenerator(15, 15).getMaze();
		}

		setSize(maze[0].length * cellSize + 20, maze.length * cellSize + 40);
		addKeyListener(this);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze[0].length; x++) {
				switch (maze[y][x]) {
				case 1 -> g.setColor(Color.BLACK); // 벽
				case 0 -> g.setColor(Color.WHITE); // 길
				case 2 -> g.setColor(Color.GREEN); // 목표
				}
				g.fillRect(x * cellSize + 10, y * cellSize + 30, cellSize, cellSize);
			}
		}

		// 플레이어
		g.setColor(Color.BLUE);
		g.fillOval(playerX * cellSize + 10, playerY * cellSize + 30, cellSize, cellSize);
	}

	public void keyPressed(KeyEvent e) {
		int newX = playerX;
		int newY = playerY;

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP -> newY--;
		case KeyEvent.VK_DOWN -> newY++;
		case KeyEvent.VK_LEFT -> newX--;
		case KeyEvent.VK_RIGHT -> newX++;
		}

		if (maze[newY][newX] != 1) {
			playerX = newX;
			playerY = newY;
		}

		if (maze[playerY][playerX] == 2) {
			JOptionPane.showMessageDialog(this, "🎉 Goal Reached!");
			playerX = 1;
			playerY = 1;
		}

		repaint();
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		String[] options = { "Easy", "Medium", "Hard" };
		String difficulty = (String) JOptionPane.showInputDialog(null, "Select difficulty:", "Maze Game",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (difficulty != null)
			new MazeGame(difficulty);
	}
}
