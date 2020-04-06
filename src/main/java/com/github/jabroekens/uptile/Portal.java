package com.github.jabroekens.uptile;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;

public class Portal extends SpriteObject implements ICollidableWithGameObjects {

	// static to preserve memory; all instances of this class use the same sprite
	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/portal.png"));

	private Sound sound;

	public Portal(Uptile uptile) {
		super(Portal.SPRITE);
		sound = new Sound(uptile, Uptile.MEDIA_URL.concat("audio/checkpoint.mp3"));
	}

	@Override
	public void update() {
		// Nothing to do
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				Player player = (Player) obj;
				player.setLevel(player.getLevel() + 1);
				sound.play(0);
			}
		}
	}

}
