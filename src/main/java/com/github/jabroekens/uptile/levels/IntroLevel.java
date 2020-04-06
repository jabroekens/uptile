package com.github.jabroekens.uptile.levels;

import com.github.jabroekens.uptile.Launchpad;
import com.github.jabroekens.uptile.Portal;
import com.github.jabroekens.uptile.Uptile;
import com.github.jabroekens.uptile.coins.BronzeCoin;
import com.github.jabroekens.uptile.coins.GoldCoin;
import com.github.jabroekens.uptile.coins.SilverCoin;
import com.github.jabroekens.uptile.monsters.Chopper;
import com.github.jabroekens.uptile.monsters.Stinger;
import com.github.jabroekens.uptile.powerups.Lightning;

public class IntroLevel extends Level {

	public IntroLevel(Uptile uptile) {
		super(630, 540, 45, 1935, new int[][] {
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{  0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1,  0,  0,  0,  0, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1,  0,  1,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1,  0,  0,  0,  0, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0,  1,  0 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1,  1,  1,  1,  1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1,  0,  0,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1,  0,  0,  1,  1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1,  1,  1,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1,  0,  0,  0,  0, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1,  0,  0,  0,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
		}, uptile, uptile.loadImage(Uptile.MEDIA_URL.concat("img/bg.png")), Uptile.MEDIA_URL.concat("audio/bg.mp3"));
	}

	@Override
	protected void addGameObjects() {
		mapToTile(new Launchpad(uptile), 4, 3);
		mapToTile(new BronzeCoin(uptile), 7, 6);
		mapToTile(new Launchpad(uptile), 4, 10);
		mapToTile(new Chopper(uptile), 9, 15);
		mapToTile(new Launchpad(uptile), 7, 15);
		mapToTile(new SilverCoin(uptile), 7, 18);
		mapToTile(new Launchpad(uptile), 4, 22);
		mapToTile(new Lightning(uptile), 6, 28);
		mapToTile(new Stinger(uptile), 8, 27);
		mapToTile(new Chopper(uptile), 11, 30);
		mapToTile(new Launchpad(uptile), 10, 29);
		mapToTile(new Lightning(uptile), 13, 31);
		mapToTile(new Launchpad(uptile), 5, 33);
		mapToTile(new GoldCoin(uptile), 6, 40);
		mapToTile(new Launchpad(uptile), 4, 37);
		mapToTile(new Launchpad(uptile), 10, 40);
		mapToTile(new Portal(uptile), 7, 45);
	}

}
