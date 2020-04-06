package com.github.jabroekens.uptile.coins;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;

public class BronzeCoin extends Coin {

	// static to preserve memory; all instances of this class use the same sprite
	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/coin_bronze.png"));

	public BronzeCoin(Uptile uptile) {
		super(BronzeCoin.SPRITE, 6, uptile, 1);
	}

}
