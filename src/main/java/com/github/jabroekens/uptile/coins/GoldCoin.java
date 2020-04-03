package com.github.jabroekens.uptile.coins;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;

public class GoldCoin extends Coin {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("coin_gold.png"));

	public GoldCoin(Uptile uptile) {
		super(GoldCoin.sprite, 6, uptile, 100);
	}

}
