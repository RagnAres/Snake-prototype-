package com.esneik.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.esneik.game.movements.Movements;
import com.sun.org.apache.xpath.internal.SourceTree;

public class Snake extends ApplicationAdapter {
	private Movements moves;

	@Override
	public void create () {

		moves = new Movements();
	}

	@Override
	public void render () {

			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			System.out.println("---------------------------------------------------------");
			System.out.println("Head X = " + moves.getMovX() + " Head Y = " + moves.getMovY());
			System.out.println("Previous X = " + moves.getPrevX() + " Previous Y = " + moves.getPrevY()) ;
			System.out.println("---------------------------------------------------------");

			moves.DrawSnake();
			moves.DrawBody();
			moves.DrawTail();
			moves.SpawnFood();
			moves.tailDir();
			moves.movement();
			moves.teleportSnk();

	}

	public void dispose() {

		moves.dispose();
		System.out.println("shape disposed!");
	}


}
