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

public class whiteClock extends PApplet {

int[] bgc = {0, 0, 0}; //背景色
int[] mc = {255, 255, 255}; //時計針の色 (R,G,B)
int[] poc = {255, 255, 255}; //時計板の色（R,G,B)

public void setup(){
	 //全画面表示
	//size(300,300); //300未満描画困
	frameRate(30); 
	 
}

public void draw(){
	translate(0, 0);
	noStroke();
	fill(bgc[0], bgc[1], bgc[2], 120);
	rect(0, 0, width, height);

	translate(width / 2, height / 2);
	noFill();
	float s = second();
	float m = minute() + (s / 60.0f);
	float h = hour() % 12 + (m / 60.0f);
	float[] time = {s, m, h};

	float[] cs = {height + (height / 3.5f), height + (height / 4.7f), height + (height / 7)};
	int[] si = {height / 5, height / 40, height / 10}; 

	float p = (height - 20) / 2;
	int stW, fil = 0;
	for(int t = 0; t < 360; t += 6){
		if(t % 30 == 0){
			stW = 15; fil = 150;
		}else{
			stW = 10; fil = 50;
		}
		stroke(poc[0], poc[1], poc[2], fil);
		strokeWeight(stW);
		float[] xy = {p * cos(radians(t)), p * sin(radians(t))};
		point(xy[0], xy[1]);
	}
	
	rotate(PI / 4);
	float n = 0.0f;
	for(int j = 0; j < 3; j++){
		strokeWeight(3);
		stroke(mc[0], mc[1], mc[2], 40 + 40 * j);
		pushMatrix();
		if(j == 2){
			n = 12.0f;
		}else{
			n = 60.0f;
		}
		rotate(radians(time[j] * 360 / n));
		rect(-cs[j] / 4, -cs[j] / 4, cs[j] / 2, cs[j] / 2);
		line(-cs[j] / 4, -cs[j] / 4, -si[j], -si[j]);
		popMatrix();
	}
}
  public void settings() { 	fullScreen(2); 	smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "whiteClock" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
