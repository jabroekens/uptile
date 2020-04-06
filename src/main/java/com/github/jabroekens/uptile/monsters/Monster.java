package com.github.jabroekens.uptile.monsters;

import java.util.List;

import com.github.jabroekens.uptile.Audible;
import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import com.github.jabroekens.uptile.tiles.FloorTile;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.tile.Tile;
import nl.han.ica.oopg.tile.TileMap;
import processing.core.PVector;

public abstract class Monster extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles, Audible {

	protected Uptile uptile;
	protected Sound sound;

	protected Monster(Sprite sprite, int totalFrames, Uptile uptile, Sound sound) {
		super(sprite, totalFrames);
		this.uptile = uptile;
		this.sound = sound;
		sound.loop(-1);
	}

	@Override
	public abstract void update();

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				((Player) obj).respawn();
			}
		}
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		TileMap map = uptile.getTileMap();

		for (CollidedTile ct : collidedTiles) {
			Tile tile = ct.getTile();

			if (tile instanceof FloorTile) {
				try {
					PVector vector = map.getTilePixelLocation(tile);

					switch (ct.getCollisionSide()) {
					case LEFT:
						setX(vector.x - getWidth());
						break;
					case RIGHT:
						setX(vector.x + map.getTileSize());
						break;
					case TOP:
						setY(vector.y - getHeight());
						break;
					case BOTTOM:
						setY(vector.y + map.getTileSize());
					default:
						break;
					}
				} catch (TileNotFoundException e) {
					// Ignore; it's only to check its existence
				}
			}
		}
	}

	@Override
	public void stopSound() {
		if (sound != null) {
			sound.pause();
		}
	}

}
