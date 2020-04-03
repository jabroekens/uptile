package com.github.jabroekens.uptile.coins;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;

public class BronzeCoin extends Coin {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("coin_bronze.png"));

	public BronzeCoin(Uptile uptile) {
		super(BronzeCoin.sprite, 6, uptile, 1);
	}

}
