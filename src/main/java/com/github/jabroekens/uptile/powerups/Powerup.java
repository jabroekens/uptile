package com.github.jabroekens.uptile.powerups;

import java.util.List;
import java.util.Objects;

import com.github.jabroekens.uptile.Player;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public abstract class Powerup extends SpriteObject implements ICollidableWithGameObjects {

	private GameEngine engine;

	public Powerup(Sprite sprite, GameEngine engine) {
		super(Objects.requireNonNull(sprite, "sprite cannot be null"));
		this.engine = Objects.requireNonNull(engine, "engine cannot be null");
	}

	@Override
	public void update() {
		// Nothing to do
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				usePowerup((Player) obj);
				engine.deleteGameObject(obj);
			}
		}
	}

	protected abstract void usePowerup(Player player);

}
