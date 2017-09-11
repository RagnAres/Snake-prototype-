package com.esneik.game.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

/**
 * Created by Cam on 8/6/2017.
 */

public class Movements {
    private ShapeRenderer shape;
    private ShapeRenderer body;
    private ShapeRenderer tail;
    public float movX = 200;
    public float movY = 200;
    public float bodX;
    public float bodY;
    private boolean moveL = false;
    private boolean moveR = false;
    private boolean moveU = false;
    private boolean moveD = false;
    private int eaten = 0;
    private float vel = 10f;
    Random rand = new Random();
    int rx = 140, ry = 90;
    float prevX, prevY;


    public void movement(){

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && !moveR){
            moveL = true;
            moveR = false;
            moveU = false;
            moveD = false;}
        if(moveL){
            getMovXN();
            prevX = getMovX() + 10;
            prevY = getMovY();}
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && !moveL){
            moveR = true;
            moveL = false;
            moveU = false;
            moveD = false;}
        if(moveR){
            getMovXP();
            prevX = getMovX() - 10;
            prevY = getMovY();}
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && !moveD){
            moveU = true;
            moveD = false;
            if(moveR)
               movX = getMovX()-10;
            if(moveL)
                movX = getMovX()+10;
            moveL = false;
            moveR = false;}
        if (moveU){
            getMovYP();
            prevY = getMovY() - 10;
            prevX = getMovX();
            }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && !moveU){
            moveD = true;
            moveU = false;
            if(moveR)
                movX = getMovX()-10;
            if(moveL)
                movX = getMovX()+10;
            moveL = false;
            moveR = false;}
        if (moveD){
            getMovYN();
            prevY = getMovY() + 10;
            prevX = getMovX();
          }
    }
    public void DrawSnake(){
        shape = new ShapeRenderer();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(movX, movY, 10, 10);
        shape.end();
    }
    public void SpawnFood(){
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(rx, ry, 10, 10);
        if(isEaten()){
            rx = rand.nextInt(40);
            ry = rand.nextInt(40);
            rx = rx * 10;
            ry = ry * 10;}
        shape.end();

    }
    public void DrawBody() {
            body = new ShapeRenderer();
            body.begin(ShapeRenderer.ShapeType.Filled);
            body.setColor(Color.GREEN);
            body.rect(getPrevX(), getPrevY(), 10, 10);
            body.end();

    }
    public void DrawTail(){
        tail = new ShapeRenderer();
        tail.begin(ShapeRenderer.ShapeType.Filled);
        tail.setColor(Color.GREEN);
        tail.rect(bodX, bodY, 10 ,10);
        tail.end();

    }
    public void tailDir(){
        if(moveL){
            bodX = getPrevX();
            bodY = getPrevY();}
        if(moveR){
            bodX = getPrevX();
            bodY = getPrevY();}
        if(moveU){
            bodY = getPrevY();
            bodX = getPrevX();}
        if(moveD){
            bodY = getPrevY();
            bodX = getPrevX();}
    }
    public void teleportSnk(){
        if(movX < 0)
            movX = 390;
        if(movX > 390)
            movX = 0;
        if (movY < 0)
            movY = 390;
        if (movY > 390)
            movY = 0;
    }

    public boolean isEaten(){
        if(getMovX() == rx && getMovY() == ry){
            eaten++;
            System.out.println("eaten is : " + eaten);
            return true;}
        else
            return false;
    }
    public float getMovXN(){
        return movX = movX - vel;
    }
    public float getMovXP(){
        return movX = movX + vel;
    }
    public float getMovYP(){
        return  movY = movY + vel;
    }
    public float getMovYN(){
        return  movY = movY - vel;
    }


    public float getPrevX() { return prevX;}
    public float getPrevY() { return prevY;}

    public float getMovX(){  return movX;}
    public float getMovY(){
        return movY;
    }

    public void dispose() {

        shape.dispose();
        body.dispose();
        tail.dispose();
        System.out.println("shape disposed!");
    }

}