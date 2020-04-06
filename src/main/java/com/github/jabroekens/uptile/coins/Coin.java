package com.github.jabroekens.uptile.coins;

import java.util.List;

import com.github.jabroekens.uptile.Alarm;
import com.github.jabroekens.uptile.Audible;
import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public abstract class Coin extends AnimatedSpriteObject implements ICollidableWithGameObjects, IAlarmListener, Audible {

	private final Uptile uptile;
	private final int coinWorth;
	private Alarm alarm;
	private Sound sound;

	protected Coin(Sprite sprite, int totalFrames, Uptile uptile, int coinWorth) {
		super(sprite, totalFrames);

		this.uptile = uptile;
		this.coinWorth = coinWorth;

		alarm = new Alarm(null, 2.0 / totalFrames);
		alarm.addTarget(this);

		sound = new Sound(uptile, Uptile.MEDIA_URL.concat("audio/coin.mp3"));
	}

	@Override
	public void update() {
		alarm.startIfNotRunning();
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				Player player = (Player) obj;
				player.setScore(player.getScore() + coinWorth);
				uptile.deleteGameObject(this);
				sound.play(0);
			}
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		nextFrame();
	}

	/**
	 * @return amount of points the coin is worth
	 */
	public int getCoinWorth() {
		return coinWorth;
	}

	@Override
	public void stopSound() {
		if (sound != null) {
			sound.pause();
		}
	}

}
