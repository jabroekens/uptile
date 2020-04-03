package com.github.jabroekens.uptile.monsters;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;

public class Chopper extends Monster {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("chopper.png"));

	public Chopper(GameEngine engine) {
		super(Chopper.sprite, 6, engine);
	}

	@Override
	public void update() {
		// TODO
	}

}
