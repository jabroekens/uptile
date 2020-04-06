package com.github.jabroekens.uptile.powerups;

import java.util.List;

import com.github.jabroekens.uptile.Audible;
import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;

public abstract class Powerup extends SpriteObject implements ICollidableWithGameObjects, Audible {

	protected Uptile uptile;
	protected Sound sound;

	protected Powerup(Sprite sprite, Uptile uptile, Sound sound) {
		super(sprite);
		this.uptile = uptile;
		this.sound = sound;
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
				uptile.deleteGameObject(this);
			}
		}
	}

	/**
	 * actions to happen when a player picks up (activates) a power-up
	 * @param player player who used the power-up
	 */
	protected abstract void usePowerup(Player player);

	@Override
	public void stopSound() {
		sound.pause();
	}

}
