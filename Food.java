import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food extends Point {
//	蛇是否吃到食物？判断蛇头和食物的坐标是否相等，如果相等为吃到
	public boolean isSnakeEatFood(Snake snake) {   
		System.out.println("Food's issnakeeatfood");
		return this.equals(snake.getHead());

	}
//产生一个新食物
	public void newFood(Point p) {
		this.setLocation(p);
	}
//画出食物
	public void drawMe(Graphics g) {
		System.out.println("food's drawme");
		g.setColor(Color.BLUE);
		g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
}
