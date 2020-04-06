package com.github.jabroekens.uptile;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class ScoreIcon extends SpriteObject {

	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/coin_icon.png"));

	public ScoreIcon() {
		super(ScoreIcon.SPRITE);
	}

	@Override
	public void update() {
		// Nothing to do
	}

}
