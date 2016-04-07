/*
 
 Xcos on Desktop- Part A
  
  Author- Devendra Pratap Yadav
  		   B.Tech CSE, IIT Ropar
  		  2014csb1010@iitrpr.ac.in
  
  
  |README|
   
  The program opens Jframe with contents as specified in problem. 
  Right-Click on label opens value input frame.
  
  Please Enter the color as hexadecimal values only
  Eg. #FFC5C3
  The '#' is compulsory.
  
  Integer input for color is accepted but not recommended.
  
  Sources/References:
  http://www.tutorialspoint.com/awt/awt_color.htm
  https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
  http://www.tutorialspoint.com/swing/swing_jframe.htm
  
  
  
 
 */




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelBox 
{

	JLabel mainLabel;
	
	class ShowMenu extends JPopupMenu 
	{
		// declare menu items
	    JMenuItem item1;
	    JMenuItem item2;
	    JMenuItem item3;
	    
	    /**
	     * Default constructor
	     */
	    public ShowMenu()
	    {
	    	// initialize items
	        item1 = new JMenuItem("Option 1");
	        add(item1);
	        item2 = new JMenuItem("Option 2");
	        add(item2);
	        item3 = new JMenuItem("Properties");
	        add(item3);
	        
	        
	        // add click listener
	        item3.addActionListener(new ActionListener()
	        {
	           public void actionPerformed(ActionEvent e)
	           {
	              showValuesFrame();
	           }
	        });
	        
	    }
	} // end class ShowMenu
	
	
	// RightClick listener class
	class RightClickListener extends MouseAdapter 
	{
		
		// open menu function
		private void doPop(MouseEvent e)
	    {
	        ShowMenu rightClickMenu = new ShowMenu();
	        rightClickMenu.show(e.getComponent(), e.getX(), e.getY());
	    }
		
		// mouse down
	    public void mousePressed(MouseEvent e)
	    {
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    // mouse up
	    public void mouseReleased(MouseEvent e)
	    {
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    
	}
	
	
	// show main JFrame of program
	public  void showMainFrame()
	{

		JFrame frame = new JFrame("Change Properties");

		JPanel panel = new JPanel();
		//panel.setLayout(new FlowLayout());
		panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel label = new JLabel("Changing Properties");
		mainLabel = label;
		
		label.setFont(label.getFont().deriveFont(20.0f));	// set font size
		
		
		label.addMouseListener(new RightClickListener());
		
		panel.add(label,gbc);	// add label to panel
		
		frame.add(panel);	// add panel
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	
	}
	
	
	
    // JFrame to open on selecting properties
	public  void showValuesFrame()
	{

		final JFrame inputFrame = new JFrame("Enter Values:");

		JPanel panel = new JPanel();
		//panel.setLayout(new FlowLayout());
		
		panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
		
        
        // add input text fields
        final JTextField background = new JTextField(10);
        JLabel backLabel = new JLabel("Change Background Colour :");
        backLabel.setLabelFor(background);
        backLabel.setFont(backLabel.getFont().deriveFont(15.0f));
        
        
        final JTextField fontColor = new JTextField(10);
        JLabel fontLabel = new JLabel("Change Font Colour :");
        fontLabel.setLabelFor(fontColor);
        fontLabel.setFont(fontLabel.getFont().deriveFont(15.0f));
        
		
        final JTextField text = new JTextField(20);
        JLabel textLabel = new JLabel("Change Text :");
        fontLabel.setLabelFor(fontColor);
        textLabel.setFont(textLabel.getFont().deriveFont(15.0f));
        
        // add submit button
        JButton submit=new JButton("SUBMIT");
        final JLabel message = new JLabel("<html>Please enter hex values for color. Example: #FFC394 , #00358F<html>",SwingConstants.CENTER);
        message.setForeground(Color.GRAY);        
        
        
        // Validate input and change properties on SUBMIT
        submit.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               int err=0;

               Color back=Color.WHITE,fontCol=Color.BLACK;
               
               try{
            	   if (background.getText().length()>0)
            		   back=Color.decode(background.getText());
            	   
            	   if (fontColor.getText().length()>0)
            		   fontCol=Color.decode(fontColor.getText());
        	   
        	  
               }
               catch (NumberFormatException ne)
               {
            	   message.setText("Error in color Input");
            	   err=1;
               }
        	   
               String changeText=text.getText();
        	          	  
               if (err==0)
               {
            	   
            	   // Change properties
            	   
            	   if (background.getText().length()>0)
            	   mainLabel.setBackground(back);
            	   if (fontColor.getText().length()>0)
            	   mainLabel.setForeground(fontCol);
            	          	   
            	   mainLabel.setOpaque(true);
            	   
            	   if (changeText.length()>0)
            	   { mainLabel.setText(changeText);}
            	   
            	   
            	   inputFrame.setVisible(false);
               }
               
        	   
        	   
           }
        });
        
        
        
        
        // insert the textfields and button in gridlayout panel
        
        c.insets=new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy =0;
        c.anchor=GridBagConstraints.WEST;
		panel.add(backLabel,c);
		c.gridx=1;
		panel.add(background,c);
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(fontLabel,c);
		c.gridx=1;
		panel.add(fontColor,c);
		
		c.gridx = 0;
		c.gridy = 2;
		
		panel.add(textLabel,c);
		c.gridx=1;
		panel.add(text,c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.insets=new Insets(10, -40, 10, 10);
		panel.add(submit,c);
		
		c.insets=new Insets(10, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth=2;
		panel.add(message,c);
		
		
		inputFrame.add(panel);
		inputFrame.setSize(500, 300);
		inputFrame.setLocationRelativeTo(null);
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputFrame.setVisible(true);
		
	
	}
	
	
	
	
	public static void main(String[] args)
	{
		LabelBox l=new LabelBox();
		
		// show main Frame
		l.showMainFrame();

		
	}
	
}
