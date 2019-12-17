/*
 * CSC 120 PA3
 * Dana Lucas
 * 10/15/2019
 *
 * Description: This class creates a background that can alternate between nighttime and daytime. Stars are placed at random
 *              and change locations every time the scene changes back to nighttime.
 *
 * Acknowledgements: Dr. Cindric helped in adding the seed to the random stars. The for loop concept was taught to me by Jacob Sanford.
 *
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
/**
 *
 * @author Dana
 */

import java.awt.*;
import java.util.Random;

public class Background {


private Boolean nighttime;
private Integer randomX, randomY, randomSeed;
private long seed;


public Background(Boolean bg){
    nighttime = bg;
    seed = 1;
}
 
private Random random;
private Random seedValue;


public void draw( Graphics g){

if ( nighttime == true){
    g.setColor(new Color(51,102,51));
    g.fillRect(0,400,400,600);
    g.setColor(new Color(0,0,102));
    g.fillRect(0,0,400,400);
    g.setColor(Color.lightGray);
    g.fillOval(300,75,35,35);
   
    random = new Random(seed);

    for(int i=0; i<25; i++){
        randomX = random.nextInt(390);
        randomY = random.nextInt(390);
        g.fillOval(randomX,randomY,5,5);
        }
}

else{
    g.setColor(new Color(102,255,102));
    g.fillRect(0,400,400,600);
    g.setColor(new Color(102,204,255));
    g.fillRect(0,0,400,400);
    g.setColor(new Color(255,255,0));
    g.fillOval(50,50,65,65);
}

} // end of draw
 
public void changeScene(){
    nighttime = !nighttime;
    seed += 27;
    }


} // end of class