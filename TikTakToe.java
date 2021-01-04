package tictactoe.gui;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TikTakToe implements ActionListener            //inside java.awt.event.* package
{
    //Instance of Random Class to select who starts the game
    Random random = new Random();
    
    JFrame frame = new JFrame();                            //frame of our game
    JPanel title_panel = new JPanel();                      //for the title 
    JPanel button_pannel = new JPanel();                    //for the buttons
    JLabel textfield = new JLabel();                        //to display the text message
    JButton[] buttons = new JButton[9];                     //for 9 places of X/O, declared an arrray of buttons
    
    //a boolean variable : true means player one's turn and false means playertwo,s turn
    boolean player1_turn;                                   
    
    //constructor
    TikTakToe()         
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);                                                 //sizeof the frame
        frame.getContentPane().setBackground(new Color(50,50,50));              //color of the game's backround
        frame.setLayout(new BorderLayout());                                    //setting Layout of the Frame
        frame.setVisible(true);                                                 //by default frame is not visible(false) so making is visible(true)
        
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));                           //color of the text
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));                   //setting the font and size of the text
        textfield.setHorizontalAlignment(JLabel.CENTER);                        //displaying the label at the center
        textfield.setText("Tik-Tak-Toe");                                       //displaying our Game's name
        textfield.setOpaque(true);
        
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);                                     //coordinates and length,width of our panel
        
        
        button_pannel.setLayout(new GridLayout(3,3));                           //our game board is a 3 x 3 area
        button_pannel.setBackground(new Color(150,150,150));
        
        for(int i=0 ; i<9 ; i++)
        {
            buttons[i] = new JButton();
            button_pannel.add(buttons[i]);                                      //adding buttons on the panel
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);                                 
        }
        
        title_panel.add(textfield);                                             //adding our textfiled over the title panel
        frame.add(title_panel,BorderLayout.NORTH);                              //finally adding the title panel over our frame
        frame.add(button_pannel);
        
        //callinng function to chose whom to start
        firstTurn();                                                            
    
    }
    
    //implementing the method
    public void actionPerformed(ActionEvent ae)
    {
        for(int i=0 ; i<9 ; i++)                    //checkimg each of 9 buttons
        {
            //checking which button is pressed and performing required operation
            if(ae.getSource() == buttons[i])       
            {
                if(player1_turn)                                                //player-1 turn
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X"); 
                        player1_turn = false;                                   //flipping now to player-2
                        textfield.setText("O Turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }
    
    //decide whether X or O starts
    public void firstTurn()     
    {
        try
        {
            Thread.sleep(2000);                           //using Multithreading to stop the text for 2 seconds
            
        }catch(Exception e)                               //Exception Handling
        {}
        
        if(random.nextInt(2) == 0)                          //if 0 comes as randomnumber then its Player-1 turn
        {
            player1_turn = true;
            textfield.setText("X Turn");                    //displaying player1 i.e. X's turn
        }
        else
        {
            player1_turn = false;
            textfield.setText("O Turn");                    //displaying player1 i.e. X's turn
        }
    }
    
    //for checking who wins the game
    public void check()
    {
        //checking all the X winning combinations
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) 
        {
            xWins(0,1,2);
        }
		
       if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
       {
           xWins(3,4,5);
       }

       if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
       {
	xWins(6,7,8);
       }
		
       if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
       {
           xWins(0,3,6);
       }
	
       if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) 
       {
           xWins(1,4,7);
       }
	
       if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") &&	(buttons[8].getText()=="X")) 
       {
            xWins(2,5,8);
       }
		
       if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
       {
            xWins(0,4,8);
       }
		
       if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
       {
           xWins(2,4,6);
       }

       //checking all the O-winning conditions
       
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
        {
            oWins(0,1,2);
	}
	
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
        {
            oWins(3,4,5);	
        }
		
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(6,7,8);
	}
		
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(0,3,6);	
        }
		
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
        {
            oWins(1,4,7);	
        }
	
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
        }
		
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(0,4,8);	
        }
		
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(2,4,6);
        }
        
    }
    
    //for checking if X wins the game 
    public void xWins(int a , int b , int c)
    {
        //changing background color to green to show win
        
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0 ; i<9 ; i++)
            buttons[i].setEnabled(false);                   //setting false so that game will begin again after winning
        
        textfield.setText("X WINS");
        
    }
    
    //for checking if O wins the game
    public void oWins(int a , int b , int c)
    {
        //changing background color to green to show win
        
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0 ; i<9 ; i++)
            buttons[i].setEnabled(false);                   //setting false so that game will begin again after winning
        
        textfield.setText("O WINS");
    }
}
