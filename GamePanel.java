import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Snake snake;
	private Food food;
	private Ground ground;

	public void disPlay(Snake snake, Food food, Ground ground) {
		System.out.println("gamepanel's display");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.repaint();

	}

	public void paint(Graphics g) {
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH*Global.CELL_SIZE, Global.WIDTH*Global.CELL_SIZE);
		if(ground!=null&&food!=null&&snake!=null){
		this.food.drawMe(g);
		this.snake.drawMe(g);
		}
	}

}
