import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalDesign extends PApplet {

public void setup()
{
	size(800, 600);
	frameRate(60);
}

int opacity = 1000;

//ball coords
int ballX = 300;
int ballY = 590;

int ranX = ((int)(Math.random()));
int ranY = ((int)(Math.random()));

int carX = -100;
float carY = 400;

float carElevation = 0;

int drop = 400;

public void draw()
{
	background(0, 0, 0);
	car();
	drops();
	explode();
	

	//turning pt
	if(carX > 200){
		carElevation = carElevation - 0.1f;
	}

	//reset
	if(carX > 900){
		carY = 400;
		carX = -100;
		carElevation = 0;
		drop = 400;		
	}

	//changes
	carX = carX + 10;
	carY = carY + carElevation;
	carElevation = carElevation*1.02f;
	//System.out.println(carY);
	//System.out.println(carElevation);
	drop++;


}	




public void car(){
	noStroke();
	fill(250, 250, 250);
	
	ellipse(carX, carY,160,30);
	ellipse(carX, carY - 10, 100, 40);
}


public void drops(){
	ellipse(carX+10, drop, 30, 10);
	ellipse(carX+60, drop + 20, 30, 10);

}

int explode = 0;
public void explode(){

	if(carX > 900){
		explode += 50;
	}
	fill(250,250,250,30);
	ellipse(800, 500, explode, explode);
	
}












  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
