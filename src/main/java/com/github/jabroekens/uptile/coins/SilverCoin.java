package com.github.jabroekens.uptile.coins;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;

public class SilverCoin extends Coin {

	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/coin_silver.png"));

	public SilverCoin(Uptile uptile) {
		super(SilverCoin.SPRITE, 6, uptile, 10);
	}

}
