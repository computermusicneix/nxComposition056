// nxComposition056
// Miquel Parera
// February, 2013

import processing.opengl.*;

int width = 1440 / 2;
int height = 900 / 2;

int[] alpha_array = {4,6,8,10,12};

int alpha = int(random(0,4));
float beta = random(30,100);
float gamma = random(1,50);
float delta = random(5,100);

float nxShape1vol = random(1.0,7.0);

void setup()
{
    size(width, height, OPENGL);
}

void draw()
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
      alpha = int(random(0,4));
      beta = random(30,100);
      gamma = random(1,50);
      delta = random(5,100);

      nxShape1vol = random(1.0,7.0);
  }
}

void drawCylinder( int sides, float r1, float r2, float h)
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
        rotateX(radians(frameCount/1.25));
        translate(0,0,alpha);    
    };
    endShape(CLOSE);
}






