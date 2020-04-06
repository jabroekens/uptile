package com.github.jabroekens.uptile;

import java.util.List;

import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Launchpad extends AnimatedSpriteObject implements ICollidableWithGameObjects, IAlarmListener, Audible {

	// static to preserve memory; all instances of this class use the same sprite
	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/launchpad.png"));

	private Alarm alarm = new Alarm(null, 0.05);
	private Sound sound;

	public Launchpad(Uptile uptile) {
		super(Launchpad.SPRITE, 4);
		alarm.addTarget(this);
		sound = new Sound(uptile, Uptile.MEDIA_URL.concat("audio/launchpad.mp3"));
	}

	@Override
	public void update() {
		if (getCurrentFrameIndex() != 0 && !alarm.isRunning()) {
			alarm.start();
		}
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				((Player) obj).setDirectionSpeed(0, 12F);
				alarm.startIfNotRunning();
				sound.play(0);
			}
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		nextFrame();
	}

	@Override
	public void stopSound() {
		if (sound != null) {
			sound.pause();
		}
	}

}
