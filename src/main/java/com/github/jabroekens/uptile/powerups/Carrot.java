package com.github.jabroekens.uptile.powerups;

import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;

public class Carrot extends Powerup {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("item_carrot.png"));

	public Carrot(GameEngine engine) {
		super(Carrot.sprite, engine);
	}

	@Override
	protected void usePowerup(Player player) {
		// TODO
	}

}
