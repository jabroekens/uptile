package com.github.jabroekens.uptile.tiles;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.tile.Tile;

public class FloorTile extends Tile {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("tile.png"));

	public FloorTile() {
		super(FloorTile.sprite);
	}

	protected FloorTile(Sprite sprite) {
		super(sprite);
	}

}
