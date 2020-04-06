package com.github.jabroekens.uptile.powerups;

import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Jetpack extends Powerup {

	// static to preserve memory; all instances of this class use the same sprite
	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/item_jetpack.png"));

	public Jetpack(Uptile uptile) {
		super(Jetpack.SPRITE, uptile, new Sound(uptile, Uptile.MEDIA_URL.concat("audio/jetpack.mp3")));
	}

	@Override
	protected void usePowerup(Player player) {
		// TODO
	}

}
