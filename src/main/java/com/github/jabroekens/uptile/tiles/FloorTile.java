package com.github.jabroekens.uptile.tiles;

import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.tile.Tile;

public class FloorTile extends Tile {

	// static to preserve memory; all instances of this class use the same sprite
	public static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/tile.png"));

	public FloorTile(Sprite sprite) {
		super(sprite);
	}

}
