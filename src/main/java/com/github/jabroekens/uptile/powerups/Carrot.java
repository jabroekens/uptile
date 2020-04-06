package com.github.jabroekens.uptile.powerups;

import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Carrot extends Powerup {

	// static to preserve memory; all instances of this class use the same sprite
	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/item_carrot.png"));

	public Carrot(Uptile uptile) {
		super(Carrot.SPRITE, uptile, new Sound(uptile, Uptile.MEDIA_URL.concat("audio/carrot.mp3")));
	}

	@Override
	protected void usePowerup(Player player) {
		// TODO
	}

}
