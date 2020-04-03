package com.github.jabroekens.uptile.monsters;

import java.util.List;
import java.util.Objects;

import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.tiles.FloorTile;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.tile.TileMap;
import processing.core.PVector;

public abstract class Monster extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {

	private GameEngine engine;

	protected Monster(Sprite sprite, int totalFrames, GameEngine engine) {
		super(Objects.requireNonNull(sprite, "sprite cannot be null"), totalFrames);
		this.engine = Objects.requireNonNull(engine, "engine cannot be null");
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
		for (CollidedTile tile : collidedTiles) {
			if (tile.getTile() instanceof FloorTile) {
				try {
					TileMap map = engine.getTileMap();
					PVector vector = map.getTilePixelLocation(tile.getTile());

					switch (tile.getCollisionSide()) {
					case TOP:
						super.setY(vector.y - super.getHeight());
					case BOTTOM:
						super.setY(vector.y + super.getHeight());
						break;
					case LEFT:
						super.setX(vector.x - super.getWidth());
						break;
					case RIGHT:
						super.setX(vector.x + map.getTileSize());
						break;
					default:
						// All relevant cases are covered
					}
				} catch (TileNotFoundException e) {
					// Silently ignore; we're just checking if the tile exists
				}
			}
		}
	}

}
