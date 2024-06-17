import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicTacToe extends JFrame implements ActionListener
{
	JFrame launcher;
	JLabel title,info;
	JButton start;
	JButton[][] tile;
	char turn='X';

	TicTacToe()
	{
		launcher=new JFrame("Tic-Tac-Toe");
		launcher.setSize(360,200);
		launcher.setResizable(false);
		launcher.setVisible(true);
		launcher.setLayout(null);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title=new JLabel("Tic-Tac-Toe");
		title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(55,10,250,30);
		launcher.add(title);

		info=new JLabel("Player 1 = X        Player 2 = O");
		info.setFont(new Font("Cambria",Font.PLAIN,16));
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBounds(30,60,300,20);
		launcher.add(info);

		start=new JButton("START!");
		start.setFont(new Font("Georgia",Font.BOLD,18));
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.setBounds(105,110,150,30);
		start.addActionListener(this);
		launcher.add(start);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==start)
		{
			launcher.remove(title);
			launcher.remove(info);
			launcher.remove(start);
			launcher.dispose();

			launcher=new JFrame("Tic-Tac-Toe");
			launcher.setSize(360,360);
			launcher.setResizable(false);
			launcher.setVisible(true);
			launcher.setLayout(new GridLayout(3,3,1,1));
			launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			tile=new JButton[3][3];
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					JButton b=new JButton();
					b.setSize(120,120);
					b.addActionListener(this);
					b.setFont(new Font("Arial",Font.BOLD,40));
					b.setBackground(Color.white);
					b.setForeground(Color.black);
					tile[i][j]=b;
					launcher.add(tile[i][j]);
				}
			}
		}

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(ae.getSource()==tile[i][j])
				{
					if(tile[i][j].getText()=="")
					{
						if(turn=='X')
						{
							tile[i][j].setText("X");
							turn='O';
							winStatus();
						}
						else
						{
							tile[i][j].setText("O");
							turn='X';
							winStatus();
						}
					}
				}
			}
		}
	}

	public void winStatus()
	{
		for(int i=0;i<3;i++)
		{
			if((tile[i][0].getText()==tile[i][1].getText() && tile[i][0].getText()==tile[i][2].getText() && tile[i][1].getText()==tile[i][2].getText() && tile[i][0].getText()!="" && tile[i][1].getText()!="" && tile[i][2].getText()!="") 
				|| (tile[0][i].getText()==tile[1][i].getText() && tile[0][i].getText()==tile[2][i].getText() && tile[1][i].getText()==tile[2][i].getText() && tile[0][i].getText()!="" && tile[1][i].getText()!="" && tile[2][i].getText()!="") 
				|| (tile[0][0].getText()==tile[1][1].getText() && tile[0][0].getText()==tile[2][2].getText() && tile[1][1].getText()==tile[2][2].getText() && tile[0][0].getText()!="" && tile[1][1].getText()!="" && tile[2][2].getText()!="")
				|| (tile[0][2].getText()==tile[1][1].getText() && tile[0][2].getText()==tile[2][0].getText() && tile[1][1].getText()==tile[2][0].getText() && tile[0][2].getText()!="" && tile[1][1].getText()!="" && tile[2][0].getText()!=""))
			{
				JOptionPane.showMessageDialog(null,"Player "+(turn=='O'? "1 (X)":"2 (O)")+" wins!");
				int n=JOptionPane.showConfirmDialog(null,"Play Again?","Tic-Tac-Toe",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION)
				{
					launcher.dispose();
					TicTacToe ttt=new TicTacToe();
					break;
				}
				else
				{
					System.exit(0);
				}
			}
			else if(tile[0][0].getText()!="" && tile[0][1].getText()!="" && tile[0][2].getText()!="" && tile[1][0].getText()!="" && tile[1][1].getText()!="" && tile[1][2].getText()!="" && tile[2][0].getText()!="" && tile[2][1].getText()!="" && tile[2][2].getText()!="")
			{
				JOptionPane.showMessageDialog(null,"Game Draw!");
				int m=JOptionPane.showConfirmDialog(null,"Play Again?","Tic-Tac-Toe",JOptionPane.YES_NO_OPTION);
				if(m==JOptionPane.YES_OPTION)
				{
					launcher.dispose();
					TicTacToe ttt=new TicTacToe();
					break;
				}
				else
				{
					System.exit(0);
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		TicTacToe ttt=new TicTacToe();	
	}
}
