
package sudoku.java.game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.*;

public class Main extends JFrame
{
    JButton Play,Newgame,about,help,exit;
    
    public Main()
    {
        initComp();
        
        Play.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                Sudoku sd = new Sudoku(3);
            }
        }); 
        
        about.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                AboutClass ac = new AboutClass();
            }
        }); 
        
        help.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                showMessageDialog(null,"Please Write the number in the text field.");
                showMessageDialog(null,"Before Choose any Block");
            }
        }); 
        
        exit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int x = showConfirmDialog(null, "U want to quit?");
                if(x == 0)
                {
                    System.exit(0);
                }
            }
        });
    }
    
    private void initComp()
    {
        setVisible(true);
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //label = new JLabel("HII");
        
        Play = new JButton("Play");
        about = new JButton("About");
        help = new JButton("Help");
        exit = new JButton("Exit");
        
        getContentPane().setLayout(new GridLayout(4, 2));
        
        //getContentPane().add(label);
        getContentPane().add(Play);
        getContentPane().add(about);
        getContentPane().add(help);
        getContentPane().add(exit);
    }
    public static void main(String[] args)
    {
        Main main = new Main();
    }
}
