package com.github.jabroekens.uptile;

import java.util.List;

import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Launchpad extends AnimatedSpriteObject implements ICollidableWithGameObjects, IAlarmListener {

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("launchpad.png"));

	private Player player;

	public Launchpad() {
		super(Launchpad.sprite, 4);
	}

	@Override
	public void update() {
		// TODO
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				player = (Player) obj;
				// TODO
			}
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		// TODO
	}

}
