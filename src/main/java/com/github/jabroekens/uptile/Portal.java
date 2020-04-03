package com.github.jabroekens.uptile;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Portal extends SpriteObject implements ICollidableWithGameObjects {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("portal.png"));

	public Portal() {
		super(Portal.sprite);
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
			}
		}
	}

}
