/*
 * CSC 120 PA3
 * Dana Lucas
 * 10/15/2019
 *
 * Description: This class creates rockets that move vertically and horizontally. Thrusters can be activated or deactivated manually, 
 *              but are automatically activated/deactivated when the rocket reaches the top/bottom of the screen.
 *
 * Aknowledgements: I used a for loop in here, which was taught to me by Jacob Sanford.
 *
 *
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

public class Rocket {

private final Integer LEFT_EDGE = 0;
private final Integer RIGHT_EDGE = 400;
private final Integer TOP_EDGE = 0;
private final Integer BOTTOM_EDGE = 600;

private Integer anchorX, anchorY, height;
private Color rocketColor;
private Integer verticalMovement, horizontalMovement;
private Boolean thrustersActivated;
private Polygon rocketShape;
private Polygon fin1, fin2;
private Polygon thruster;

public Rocket(Boolean th, Integer x, Integer y, Integer h, Color c, Integer vert, Integer hor){
thrustersActivated = th;
anchorX = x;
anchorY = y;
height = h;
rocketColor = c;
verticalMovement = vert;
horizontalMovement = hor;
}

public void draw(Graphics g){

rocketShape = new Polygon();
fin1 = new Polygon();
fin2 = new Polygon();
thruster = new Polygon();

rocketShape.addPoint(anchorX, anchorY);
rocketShape.addPoint(anchorX + height/8, anchorY - height/4);
rocketShape.addPoint(anchorX + height/4, anchorY);
rocketShape.addPoint(anchorX + height/4, anchorY + height);
rocketShape.addPoint(anchorX, anchorY + height);

fin1.addPoint(anchorX, anchorY + 2*height/3);
fin1.addPoint(anchorX, anchorY + 5*height/6);
fin1.addPoint(anchorX-height/5, anchorY + 7*height/6);
fin1.addPoint(anchorX-height/6, anchorY + 5*height/6);

fin2.addPoint(anchorX + height/4, anchorY + 2*height/3);
fin2.addPoint(anchorX + height/4, anchorY + 5*height/6);
fin2.addPoint(anchorX + height/4 + height/5, anchorY + 7*height/6);
fin2.addPoint(anchorX + height/4 + height/6, anchorY + 5*height/6);
  
thruster.addPoint(anchorX, anchorY + height);
thruster.addPoint(anchorX + height/4, anchorY + height);
thruster.addPoint(anchorX + 3*height/8, anchorY + 15*height/12);
thruster.addPoint(anchorX + 3*height/16, anchorY + 7*height/6);
thruster.addPoint(anchorX + height/8, anchorY + 9*height/6);
thruster.addPoint(anchorX + height/16, anchorY + 7*height/6);
thruster.addPoint(anchorX - height/8, anchorY + 4*height/3);

g.setColor(rocketColor);
g.fillPolygon(rocketShape);
g.fillPolygon(fin1);
g.fillPolygon(fin2);
g.setColor(Color.BLACK);
g.drawPolygon(rocketShape);

for(int i=0; i<7; i++){
g.fillRect(anchorX + height/16,anchorY +(i+1)*height/10, height/16,height/16);
} // This taught to me by Jacob last semester


if(thrustersActivated == true){
    g.setColor(Color.ORANGE);
    g.fillPolygon(thruster);
//    verticalMovement +=10;
}
 
//if(thrustersActivated == false){
//    verticalMovement += 10;
//}
                
} // end of draw

public void moveVertically(){
    if((anchorY + (9*height/6) + verticalMovement) >= BOTTOM_EDGE){
        verticalMovement = -1* verticalMovement;
        thrustersActivated = true;
        }
    if ((anchorY + verticalMovement) <= TOP_EDGE){
        verticalMovement = -1* verticalMovement;
        thrustersActivated = false;
        }
    anchorY += verticalMovement;
} // end of moveVertically

 
public void moveHorizontally(){
    if ((anchorX - height/5 + horizontalMovement <= LEFT_EDGE) || ((anchorX + height/4 + height/5 + horizontalMovement) >= RIGHT_EDGE)){
        horizontalMovement = -1* horizontalMovement;
        } 
    anchorX += horizontalMovement;

} // end of moveHorizontally

public void changeThrusters(){
    thrustersActivated = !thrustersActivated;
}


} // end of Class
