import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food extends Point {
//	���Ƿ�Ե�ʳ��ж���ͷ��ʳ��������Ƿ���ȣ�������Ϊ�Ե�
	public boolean isSnakeEatFood(Snake snake) {   
		System.out.println("Food's issnakeeatfood");
		return this.equals(snake.getHead());

	}
//����һ����ʳ��
	public void newFood(Point p) {
		this.setLocation(p);
	}
//����ʳ��
	public void drawMe(Graphics g) {
		System.out.println("food's drawme");
		g.setColor(Color.BLUE);
		g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
}
