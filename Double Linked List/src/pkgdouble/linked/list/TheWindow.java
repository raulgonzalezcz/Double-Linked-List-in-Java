/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgdouble.linked.list;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;


/**
 *
 * @author Raúl González Cruz
 * Misael Cabrera Aguilar
 * Gelio Castro Gracida
 * References:
 *      Dr. Juan Carlos Galán Hernández
 *      http://startingtoprogram.blogspot.mx/2011/08/lectura-de-datos-con-bufferedreader.html
 *      http://www.c4learn.com/data-structure/doubly-linked-list/
 * 
 */

//TheWindow class inherit implements from the JFrame Class, in order to construct the window
public class TheWindow extends JFrame implements ActionListener {
    //Atributes
    DLinkedList myList;
    int FRAME_WIDTH = 500;
    int FRAME_HEIGHT = 400;
    int FRAME_X_ORIGIN = 150;
    int FRAME_Y_ORIGIN = 250;
    JMenu actions;
    JTextArea textArea;
    JFrame frame;
    String NEWLINE = System.getProperty("line.separator");
    
    public static void main(String[] args) {
        TheWindow frame = new TheWindow();
        frame.setVisible(true);
    }
    
//With this, we can set all the visual components of the window
    public TheWindow(){
        Container contentPane;
        JMenuItem item;
        
        myList = new DLinkedList();
        //set the frame properties
        setTitle     ("Double Linked List Example");
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setLayout(null);
        contentPane.setBackground( Color.white );
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        actions = new JMenu("Actions");
		
	item = new JMenuItem("Add One Element");
	item.addActionListener( this );
        actions.add(item);
        item = new JMenuItem("Add From File");
	item.addActionListener( this );
        actions.add(item);
        item = new JMenuItem("Delete One Element");
	item.addActionListener( this );
        actions.add(item);
        item = new JMenuItem("Show Contents");
	item.addActionListener( this );
        actions.add(item);
        item = new JMenuItem("Search Contents");
	item.addActionListener( this );
        actions.add(item);
        actions.addSeparator();
        item = new JMenuItem("Exit");
	item.addActionListener( this );
        actions.add(item);	
		
	menuBar.add(actions);
        //create the "paper" where things are going to be displayed
        textArea = new JTextArea();
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setBounds(0, 0, FRAME_WIDTH-5, FRAME_HEIGHT-51);
        //scrollText.setBorder(BorderFactory.createLineBorder(Color.red));
        contentPane.add(scrollText);
        textArea.setEditable(false);
        //Create a new, bigger font
        Font fuente = new Font("Calibri", 1, 20);
        textArea.setFont(fuente);         
        //textArea.setForeground(Color.BLUE);
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    /*recognizes when the user select (click) an item from the Menubar, 
    depending of what the user selects, the action selected
    recognize the methods of the class DLinkedList to be performed*/
    
 /*This method will be the responsable for call all the actions that a double linked list perform.
    In this case, we have to establish a menu that contains sub-menus.    
    */
    public void actionPerformed(ActionEvent event) {
    	String  menuName, input;
        int a;
        menuName = event.getActionCommand();

    //For each sub-menu...
        if(menuName.equals("Exit"))
        	System.exit(0);
        else if (menuName.equals("Add One Element")){
            input = JOptionPane.showInputDialog(null,"Type an integer number to insert:");
            try{ //Has the user introduced a number ?
                a =Integer.parseInt(input);
                myList.addNodeOrdered(a);
            }
            //Ok, we want to remember him to write a number
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(frame, "Please, write an integer number");
            }
        }
        else if (menuName.equals("Add From File")){
            //This help us for reading and storage of data
            BufferedReader reader = null;
            try { 
                    //The program needs the route of the text file that contains numbers
                /*In this case, we have selected a specefic route. But when the user wants to 
                read another text file with numbers, he has to change the route.
                So, don´t forget this.
                */
                    File file = new File("C:\\Users\\Raúl\\Desktop\\numeros.txt");
                    //We need another tool to read data; that is stored in "reader"
                    reader = new BufferedReader(new FileReader(file));
                    String line;
                    //The program starts reading each number of the text file
                    while ((line = reader.readLine()) != null) {
                        input = line;
                        myList.addNodeOrdered(Integer.parseInt(input));
                    }
                }
            catch (IOException e) 
                {
                    //The user doesn´t know exactly where is the file text
                    e.printStackTrace();
                }
            //Always this is executed...
            finally {
                    try{
                        //Stop the actions that perform import.java.io.Filereader
                        reader.close();
                    }
                    //"Try" needs a catch, because of syntax. But, in the program is neve executed. 
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                }
    }
        else if (menuName.equals("Delete One Element")){
            input = JOptionPane.showInputDialog(null,"Type an integer number to delete:");
            try{ //Has the user introduced a number?
                a =Integer.parseInt(input);
                myList.eliminateNode(a);
            } //Remember to introduce a number
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(frame, "Please, write an integer number");
            }
        }
        else if (menuName.equals("Show Contents")){
            //The program skip a line and starts writting in the text area
            textArea.append(NEWLINE + myList.displayList());
        }
        else if (menuName.equals("Search Contents")){
            input = JOptionPane.showInputDialog(null,"Type an integer number to search:");
            try{
                //Has the user introduced a number?
                a =Integer.parseInt(input);
                //We have two posible ways...
                if(myList.searchNode(a)!= null) //The element was found
                textArea.append(NEWLINE+"The number "+input+" was found in the list.");
                else //Or the element is not in the list
                textArea.append(NEWLINE+"The number "+input+" was not found in the list.");
            } //I love to remember the user to introduce a number :)
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(frame, "Please, write an integer number");
            }
            
        }
    }
    
}
