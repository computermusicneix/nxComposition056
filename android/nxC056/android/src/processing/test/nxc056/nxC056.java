package processing.test.nxc056;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class nxC056 extends PApplet {

// nxComposition056android
// Miquel Parera
// February, 2013



int[] alpha_array = {4,6,8,10,12};

int alpha = PApplet.parseInt(random(0,4));
float beta = random(30,100);
float gamma = random(1,50);
float delta = random(5,100);

float nxShape1vol = random(1.0f,7.0f);

public void setup()
{
   
}

public void draw()
{
    background(255);
    
    fill(0);

    pushMatrix();    
    translate( 1240/4.75f, 1754/4.5f, 0 );
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
}

public void drawCylinder( int sides, float r1, float r2, float h)
{
    float angle = 360 / sides;
    float half1754 = h / 2;
    beginShape(TRIANGLE_STRIP);
    for (int i = 0; i < sides + 1; i++) {
        float x1 = cos( radians( i * angle ) ) * r1;
        float y1 = sin( radians( i * angle ) ) * r1;
        float x2 = cos( radians( i * angle ) ) * r2;
        float y2 = sin( radians( i * angle ) ) * r2;
        vertex( x1, y1, -half1754);
        vertex( x2, y2, half1754);  
    };
    endShape(CLOSE);
    beginShape(TRIANGLE_STRIP);
    for (int i = 0; i < sides + 1; i++) {
        float x1 = cos( radians( i * angle ) ) * r1;
        float y1 = sin( radians( i * angle ) ) * r1;
        float x2 = cos( radians( i * angle ) ) * r2;
        float y2 = sin( radians( i * angle ) ) * r2;
        vertex( x1, y1, -half1754);
        vertex( x2, y2, half1754);
        //rotateY(radians(180));
        rotateX(radians(frameCount/1.25f));
        translate(0,0,alpha);    
    };
    endShape(CLOSE);
}







  public int sketchWidth() { return 1240; }
  public int sketchHeight() { return 1754; }
  public String sketchRenderer() { return OPENGL; }
}
