/* 
 * CSC 120 PA3
 * Dana Lucas
 * 10/15/2019
 *
 * Description: This program creates rockets on a background that switches between a night sky and daylight. 
 *              The rockets move vertically and horizontally when the Move Objects button is pressed. The thrusters 
 *              are turned on/off when the Change Thrusters button is pressed, but are also activated/deactivated 
 *              when the rocket reaches the bottom/top of the screen.
 */ 
import java.awt.*;
import javax.swing.*;
  
public class MUPanel extends JPanel {

    // 1. Declare private objects here:
              
    private Rocket rocketTest, r2, r3; 
    private Background background;
   
  
    // constructor method
    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(400, 600));
        setUp();
        setBackground(Color.WHITE);
    
        // 2. Instantiate objects here by calling "new":
             
        rocketTest = new Rocket(true, 300, 300, 50, Color.DARK_GRAY, 30, 0);
        r2 = new Rocket(false, 100, 100, 75, Color.RED, -40, -10);
        r3 = new Rocket(false, 200, 150, 90, Color.magenta, -50, 5);
        background = new Background(true);
         
    } // end of constructor
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This line must be first in this method!

        // 3. Call methods of objects here:

        background.draw(g);
        rocketTest.draw(g);
        r2.draw(g);
        r3.draw(g);
		  
		  
    } // end of paintComponent()
    
     public void moveObjects(){
        rocketTest.moveHorizontally();
        r2.moveHorizontally();
        r3.moveHorizontally();
        rocketTest.moveVertically();
        r2.moveVertically();
        r3.moveVertically();
        
        } // end of moveObjects


     public void changeScene(){
        background.changeScene();
        }
    
     public void changeThrusters(){
        rocketTest.changeThrusters();
        r2.changeThrusters();
        r3.changeThrusters();
}
       
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void setUp() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(false);    
    }

    public static void main(String args[]){new MUPanel();}

} // end of class MUPanel
