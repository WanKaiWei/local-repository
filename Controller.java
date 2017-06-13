import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

public class Controller extends KeyAdapter implements SnakeListener/*,ActionListener*/ {
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamepanel;
	private Game game;

	public Controller(Snake snake, Food food, GamePanel gamepanel,Game game) {

		this.snake = snake;
		this.food = food;
		
		this.gamepanel = gamepanel;
		this.game=game;
	}

	public void snakeMoved(Snake snake) {
		if (food.isSnakeEatFood(snake)) {
			snake.eatFood();
			food.newFood(getPoint());
		}
		if (snake.isEatBody()) {
			snake.die();
		}
		gamepanel.disPlay(snake, food, ground);

	}
//新游戏开始
	public void newGame() {
		snake.start();
		food.newFood(getPoint());
	}
//随即产生食物的位置
	public Point getPoint() {
		Random radom = new Random();
		int x = radom.nextInt(Global.WIDTH);
		int y = radom.nextInt(Global.HEIGHT);
		return new Point(x, y);
	}
//按键处理
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;
		case KeyEvent.VK_ADD:
		case KeyEvent.VK_PAGE_UP:
			snake.speedUp();// 加速
		break;
		case KeyEvent.VK_SUBTRACT:
		case KeyEvent.VK_PAGE_DOWN:
			snake.speedDown();// 减速
		break;
		}
	}

	}


	

