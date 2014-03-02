import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import gifAnimation.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class nxComposition056gif extends PApplet {

// nxComposition056gif
// Miquel Parera
// February, 2013




GifMaker gifExport;

int d = day();    
int m = month();  
int y = year();
int h = hour();
int minut = minute();
int s = second();

float numFrames = 180;

int width = 400;
int height = 300;

int[] alpha_array = {4,6,8,10,12};

int alpha = PApplet.parseInt(random(0,4));
float beta = random(30,100);
float gamma = random(1,50);
float delta = random(5,100);

float nxShape1vol = random(1.0f,7.0f);

public void setup()
{
    size(width, height, OPENGL);
    gifExport = new GifMaker(this, "nxComposition056-"+y+"-"+m+"-"+d+"_"+h+"-"+minut+"-"+s+".gif");
    gifExport.setRepeat(0); 
    gifExport.setTransparent(0,0,0);
}

public void draw()
{
    background(255);
    
    fill(0);

    pushMatrix();    
    translate( width/2, height/2, 0 );
    rotateX( PI/12 );
    rotateY( radians( frameCount ) );
    rotateZ( radians( frameCount ) );
    noFill();
    stroke(0,0,0,100);
    scale(nxShape1vol);
    drawCylinder( alpha_array[alpha], beta, gamma, delta );
    popMatrix();
    
    if (mousePressed) {
      alpha = PApplet.parseInt(random(0,4));
      beta = random(30,100);
      gamma = random(1,50);
      delta = random(5,100);

      nxShape1vol = random(1.0f,7.0f);
  }
 
  gifExport.setDelay(1);
  gifExport.addFrame();
  
  if (frameCount > numFrames) {
    gifExport.finish();
    exit();
  }
  
}

public void drawCylinder( int sides, float r1, float r2, float h)
{
    float angle = 360 / sides;
    float halfHeight = h / 2;
    beginShape(TRIANGLE_STRIP);
    for (int i = 0; i < sides + 1; i++) {
        float x1 = cos( radians( i * angle ) ) * r1;
        float y1 = sin( radians( i * angle ) ) * r1;
        float x2 = cos( radians( i * angle ) ) * r2;
        float y2 = sin( radians( i * angle ) ) * r2;
        vertex( x1, y1, -halfHeight);
        vertex( x2, y2, halfHeight);  
    };
    endShape(CLOSE);
    beginShape(TRIANGLE_STRIP);
    for (int i = 0; i < sides + 1; i++) {
        float x1 = cos( radians( i * angle ) ) * r1;
        float y1 = sin( radians( i * angle ) ) * r1;
        float x2 = cos( radians( i * angle ) ) * r2;
        float y2 = sin( radians( i * angle ) ) * r2;
        vertex( x1, y1, -halfHeight);
        vertex( x2, y2, halfHeight);
        //rotateY(radians(180));
        rotateX(radians(frameCount/1.25f));
        translate(0,0,alpha);    
    };
    endShape(CLOSE);
}






  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "nxComposition056gif" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
