package com.github.jabroekens.uptile.coins;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;

public class SilverCoin extends Coin {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("coin_silver.png"));

	public SilverCoin(Uptile uptile) {
		super(SilverCoin.sprite, 6, uptile, 10);
	}

}
