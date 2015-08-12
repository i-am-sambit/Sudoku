
package sudoku.java.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import  static javax.swing.JOptionPane.*;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Sudoku extends JFrame
{
    JButton button[][] = new JButton[9][9];
    JMenuBar mbar;
    JMenu mnuGame, mnuOption, mnuHelp;
    JMenuItem itmNewgame, itmOpen, itmSave, itmSubmit, itmExit, itmAbout,itmHelp;
    JCheckBoxMenuItem itmBeg, itmInter, itmExp;
    JTextPane pane;

    int[][] arrayn;
    int[][] savearray = new int[9][9];
    String[][] readarray;

    Random ranhide;

    public Sudoku(final int level)
    {
        initComp(level);

        itmNewgame.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                call(level);
            }
        });

        itmSubmit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Submit();
            }
        });

        itmExit.addActionListener(new ActionListener() 
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

        itmBeg.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int a = 3;
                call(a);
            }
        }); 

        itmInter.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int a = 5;
                call(a);
            }
        });

        itmExp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int a = 7;
                call(a);
            }
        });

        itmAbout.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                @SuppressWarnings("unused")
                AboutClass ac = new AboutClass();
            }
        });
        
        itmHelp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                showMessageDialog(null,"Please Write the number in the text field.");
                showMessageDialog(null,"Before Choose any Block");
            }
        }); 
    }
    
    private void initComp(int level)
    {
        //-----------------------------------------------------frame details---------------------------------------
        getContentPane().setLayout(new GridLayout(10, 10));
        
         SudokuGameLogic sgl = new SudokuGameLogic();
        int array[][] = sgl.save();
        savearray = array;
        
        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                button[i][j] = new JButton();
                button[i][j].setText(""+array[i][j]);
                button[i][j].setFont(new Font("ARIALBD", Font.BOLD, 20));
                button[i][j].setForeground(Color.DARK_GRAY);
                

                getContentPane().add(button[i][j]);
                if (i == 3 || i == 4 || i == 5 || j == 3 || j == 4 || j == 5) 
                {
                    if (2 < i && i < 6 && 2 < j && j < 6) 
                    {
                        button[i][j].setBackground(Color.CYAN);
                        button[i][j].setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
                        continue;
                    }
                    button[i][j].setBackground(Color.white);
                    button[i][j].setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
                }
                else 
                {
                    button[i][j].setBackground(Color.CYAN);
                    button[i][j].setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
                }
            }
        }
        
        pane = new JTextPane();
        pane.setSize(20, 40); 
        pane.setText("erase me and put the number");
        pane.setFont(new Font("Times New Roman",2,20)); 
        pane.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 255, 255)));
        getContentPane().add(pane);

        ranhide = new Random();

        arrayn = new int[9][9];
        String xyz = null;
        for(int i=0;i<9;i++)
        {
            //int x = ranhide.nextInt(10);
            for(int j=0;j<level;j++)
            {
                int y=ranhide.nextInt(9);
                button[i][y].setText(xyz);
            }
        }
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                final int x = i;
                final int y = j; 
                button[i][j].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0) 
                    {
                        if(button[x][y].getText() == null)
                        {   
                            int abc = Integer.parseInt(pane.getText());
                            button[x][y].setText(""+abc);
                            button[x][y].setFont(new Font("Times New Roman",3,30));
                            button[x][y].setForeground(Color.BLUE);
                            pane.setText("");
                        }
                        else
                        {
                            showMessageDialog(null, "Sorry You Can't Change This number");
                        }
                    }
                });
            }
        }
        
        setSize(1350,730);
        setTitle("Play Sudoku");
        
        //--------------------------------------------------layout set-----------------------------
        mbar = new JMenuBar();

        //menu
        mnuGame = new JMenu("Game");
        mnuOption = new JMenu("Option");
        //itmAbout = new JMenuItem("About");
        mnuHelp = new JMenu("Help");

            //---------------------------------------------------items for Game----------------------------------------------------------------------

        itmNewgame = new JMenuItem("New Game");
        itmSubmit = new JMenuItem("Submit");
        itmExit = new JMenuItem("Exit");   

        //adding shortcut
        itmNewgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itmSubmit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        itmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        //add menu item
        mnuGame.add(itmNewgame);
        //mnuGame.add(itmOpen);
        //mnuGame.add(itmSave);
        mnuGame.add(itmSubmit);
        mnuGame.add(itmExit);

            //----------------------------------------------end of items for Game--------------------------------------------------------------------

            //--------------------------------------------------items for Option-----------------------------------------------------------------

        itmBeg = new JCheckBoxMenuItem("Begginer");
        itmInter = new JCheckBoxMenuItem("Intermidiate");
        itmExp = new JCheckBoxMenuItem("Expert");

        mnuOption.add(itmBeg);
        mnuOption.add(itmInter);
        mnuOption.add(itmExp);

        itmAbout = new JMenuItem("About");
        itmHelp = new JMenuItem("Help");
        mnuHelp.add(itmAbout);
        mnuHelp.add(itmHelp);

        //add menu item to menu bar
        mbar.add(mnuGame);
        mbar.add(mnuOption);
        //mbar.add(itmAbout);
        mbar.add(mnuHelp);

        //add menu bar to frame
        setJMenuBar(mbar);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void Submit()
    {
        readarray = new String[9][9];
        int newarray[][] = new int[9][9];
        int count = 0;
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                readarray[i][j] = button[i][j].getText();
                if(readarray[i][j] == null)
                {
                    count++;
                }
            }
        }
        
        if(count == 0)
        {
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(!"".equals(readarray[i][j]))
                    {
                        newarray[i][j] = Integer.parseInt(readarray[i][j]); 
                    }
                    else
                    {
                        newarray[i][j] = 0;
                    }
                }
            }
            
            int incorrect = 0;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(savearray[i][j] != newarray[i][j])
                    {
                        incorrect++;
                    }
                }
            }
            
            if(incorrect == 0)
            {
                showMessageDialog(null, "You Won");
            }
            else
            {
                showMessageDialog(null, "You Lost");
            }
        }
        else
        {
            showMessageDialog(null, "Blank Blocks");
            showMessageDialog(null, "Please Fill the blank Blocks");
        }
    }
    
    public void call(int m)
    {
        dispose();
        Sudoku sd = new Sudoku(m);
    }
}
