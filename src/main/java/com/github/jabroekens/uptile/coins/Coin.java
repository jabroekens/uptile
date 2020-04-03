package com.github.jabroekens.uptile.coins;

import java.util.List;
import java.util.Objects;

import com.github.jabroekens.uptile.Alarm;
import com.github.jabroekens.uptile.Player;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public abstract class Coin extends AnimatedSpriteObject implements ICollidableWithGameObjects, IAlarmListener {

	private final GameEngine engine;
	private final int coinWorth;
	private Alarm alarm;

	protected Coin(Sprite sprite, int totalFrames, GameEngine engine, int coinWorth) {
		super(Objects.requireNonNull(sprite, "sprite cannot be null"), totalFrames);
		this.engine = Objects.requireNonNull(engine, "uptile cannot be null");
		this.coinWorth = coinWorth;
	}

	@Override
	public void update() {
		if (alarm == null || !alarm.isRunning()) {
			alarm = new Alarm(null, 2 / super.getTotalFrames());
			alarm.addTarget(this);
			alarm.start();
		}
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Player) {
				Player player = (Player) obj;
				player.setScore(player.getScore() + coinWorth);
				alarm.stop();
				engine.deleteGameObject(this);
			}
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		super.nextFrame();
	}

	public int getCoinWorth() {
		return coinWorth;
	}

}
