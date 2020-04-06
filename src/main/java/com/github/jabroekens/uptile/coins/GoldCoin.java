package com.github.jabroekens.uptile.coins;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;

public class GoldCoin extends Coin {

	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/coin_gold.png"));

	public GoldCoin(Uptile uptile) {
		super(GoldCoin.SPRITE, 6, uptile, 100);
	}

}
