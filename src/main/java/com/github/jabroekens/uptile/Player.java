package com.github.jabroekens.uptile;

import java.util.List;
import java.util.Objects;

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

public class Player extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("player.png"));

	private final GameEngine engine;
	private int score;
	private int level;

	public Player(GameEngine engine) {
		super(Player.sprite, 9);
		this.engine = Objects.requireNonNull(engine, "engine cannot be null");
		setCurrentFrameIndex(2);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void respawn() {
		score = 0;
		level = 0;
	}

	@Override
	public void update() {
		// TODO
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// Nothing to do
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

	@Override
	public void keyPressed(int keyCode, char key) {
		// TODO
	}

}
