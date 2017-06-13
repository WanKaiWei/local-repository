import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.JOptionPane;

public class Snake {
	Set<SnakeListener> listeners = new HashSet<SnakeListener>();
	LinkedList<Point> body = new LinkedList<Point>();
	public int oldDirection, newDirection;
	private Point oldTail;
	public boolean life;
	public static final int UP = 1, DOWN = -1, LEFT = 2, RIGHT = -2;
	public static int sd = 300;// 停滞时间
	public static int d = 200;// 最快多少;
	double speedChangeRate = 0.75;
//初始化Snake
	public Snake() {
		inti();
	}

	public Point getHead() {
		return body.getFirst();
	}

	private void inti() {
		int x = Global.WIDTH / 2;
		int y = Global.HEIGHT / 2;
		for (int i = 0; i < 2; i++) {
			body.addLast(new Point(x--, y));
		}
		oldDirection = newDirection = RIGHT;
		life = true;
	}
//蛇移动如果新方向和老方向不相反时，把新方向赋值给老方向
	public void move() {
		System.out.println("snake's Move");
		if (!(newDirection + oldDirection == 0)) {
			oldDirection = newDirection;
		}

		// 1.去尾
		oldTail = body.removeLast();
		int x = body.getFirst().x;
		int y = body.getFirst().y;
		switch (oldDirection) {
		case UP:
			y--;
			if (y < 0)

				this.die();

			break;
		case DOWN:
			y++;
			if (y > Global.HEIGHT)

				this.die();
			break;
		case LEFT:
			x--;
			if (x < 0)

				this.die();

			break;
		case RIGHT:
			x++;
			if (x >= Global.WIDTH)
				this.die();

			break;
		}
		Point newHead = new Point(x, y);
		// 2.添头
		body.addFirst(newHead);
	}

	public void changeDirection(int direction) {
		System.out.println("snake's changedirection");

		newDirection = direction;
	}
//吃到食物后，添加尾巴
	public void eatFood() {
		System.out.println("snake's eatfood");
		body.addLast(oldTail);
	}
//判断是否吃到身体（判断equals是否相等
	public boolean isEatBody() {
		System.out.println("snake's iseatbody");
		for (int i = 1; i < body.size(); i++) {
			if (body.get(i).equals(this.getHead())) {
				return true;
			}
		}
		return false;
	}

	public void drawMe(Graphics g) {
		g.setColor(Color.BLUE);
		System.out.println("snake's drawMe");
		for (Point p : body) {
			g.fill3DRect(p.x * Global.CELL_SIZE, p.y * Global.CELL_SIZE,
					Global.CELL_SIZE, Global.CELL_SIZE, true);
		}
	}

	public class SnakeThread implements Runnable {

		public void run() {

			while (life) {
				move();
				for (SnakeListener l : listeners) {
					l.snakeMoved(Snake.this);
				}
				if (sd <= d) {
					sd = d;
				} else {
					sd -= 5;
				}

				try {
					Thread.sleep(sd);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	public void start() {
		new Thread(new SnakeThread()).start();
	}

	public void addSnakeListener(SnakeListener l) {
		if (l != null) {
			this.listeners.add(l);
		}
	}
//线程死亡
	public void die() {
		life = false;
		JOptionPane.showMessageDialog(null, "游戏结束   ! ! !");
	}
//暂停键
	public void setZanTing() {
		if (life) {
			life = false;
		} else {
			life = true;

		}
	}

	public void setSD(int a, int b) {
		sd = a;
		d = b;

	}
//加速
	public void speedUp() {
		d *= speedChangeRate;

	}
//减速
	public void speedDown() {
		d /= speedChangeRate;
	}
}
