import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Game extends JFrame {
	JLabel bt1;
	JLabel bt2;

	JMenuItem jixu;
	JMenuItem zanting;
	JMenuItem tuichu;

	JRadioButton chu;
	JRadioButton zhong;
	JRadioButton gao;
	JRadioButton chao;

	JMenuItem guanyu;
	Font f;
	Snake snake = new Snake();

	GamePanel gamepanel = new GamePanel();
	Food food = new Food();
	Controller controller = new Controller(snake, food,gamepanel, this);

	void CreatFrame() {

		f = new Font("����", Font.PLAIN, 12);

		JMenuBar caidan = new JMenuBar();
		JMenu shezhi = new JMenu("����");
		shezhi.setFont(f);
		JMenu nandu = new JMenu("�Ѷ�");
		nandu.setFont(f);
		JMenu bangzhu = new JMenu("����");
		bangzhu.setFont(f);
		caidan.add(shezhi);
		caidan.add(nandu);
		caidan.add(bangzhu);

		jixu = new JMenuItem("���� F2");
		jixu.setFont(f);
		jixu.addActionListener(new ToolListener());
		zanting = new JMenuItem("��ͣ F3");
		zanting.setFont(f);

		zanting.addActionListener(new ToolListener());
		tuichu = new JMenuItem("�˳� F4");
		tuichu.setFont(f);
		tuichu.addActionListener(new ToolListener());

		chu = new JRadioButton("����,����ٶ�195", true);
		chu.setFont(f);
		chu.addActionListener(new ToolListener());
		zhong = new JRadioButton("�м�,����ٶ�225");
		zhong.setFont(f);
		zhong.addActionListener(new ToolListener());
		gao = new JRadioButton("�߼�,����ٶ�255");
		gao.setFont(f);
		gao.addActionListener(new ToolListener());
		chao = new JRadioButton("����,����ٶ�275");
		chao.setFont(f);
		chao.addActionListener(new ToolListener());
		ButtonGroup bg = new ButtonGroup();
		bg.add(chu);
		bg.add(zhong);
		bg.add(gao);
		bg.add(chao);
		nandu.add(chu);
		nandu.add(zhong);
		nandu.add(gao);
		nandu.add(chao);

		guanyu = new JMenuItem("����");
		guanyu.setFont(f);
		guanyu.addActionListener(new ToolListener());

		shezhi.add(jixu);
		shezhi.add(zanting);
		shezhi.add(tuichu);

		bangzhu.add(guanyu);

		this.setJMenuBar(caidan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Global.WIDTH * Global.CELL_SIZE + 8, Global.HEIGHT
				* Global.CELL_SIZE + 49);
		gamepanel.setSize(Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT
				* Global.CELL_SIZE);
		this.add(gamepanel, BorderLayout.CENTER);
		gamepanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		this.addKeyListener(controller);
		this.setResizable(false);
		this.setTitle("̰����-Worm1.0��");
		this.setVisible(true);
		controller.newGame();

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.CreatFrame();

	}

	public class ToolListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == zanting) {
				snake.setZanTing();
			} else if (e.getSource() == jixu) {
				setJixu();
			} else if (e.getSource() == tuichu) {
				setTuiChu();

			} else if (e.getSource() == chu) {
				snake.setSD(300, 110);

			} else if (e.getSource() == zhong) {
				snake.setSD(250, 80);

			} else if (e.getSource() == gao) {
				snake.setSD(200, 50);

			} else if (e.getSource() == chao) {
				snake.setSD(150, 30);

			} else if (e.getSource() == guanyu) {
				JLabel gy = new JLabel("؝����WORM1.0�汾 ���gӭԇ��!"
						+ "��ʾ�����٣�PAGE UP�����٣�PAGE DOWN");
				gy.setFont(f);
				JOptionPane.showMessageDialog(null, gy);

			}
		}

		public void setTuiChu() {
			JLabel tc = new JLabel("ȷ���˳���");
			tc.setFont(f);
			int a = JOptionPane.showConfirmDialog(null, tc);
			if (a == 0) {

				System.exit(0);
			}
		}

		private void setJixu() {

			controller.newGame();
			snake.life = true;

		}
	}

}
