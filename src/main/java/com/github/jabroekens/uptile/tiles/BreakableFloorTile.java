package com.github.jabroekens.uptile.tiles;

import java.util.Objects;

import com.github.jabroekens.uptile.Alarm;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;

public class BreakableFloorTile extends FloorTile implements IAlarmListener {

	public static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("tile_breakable.png"));

	private GameEngine engine;
	private Alarm alarm;

	public BreakableFloorTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if (engine != null) {
			try {
				PVector vector = engine.getTileMap().getTilePixelLocation(this);
				engine.getTileMap().setTile((int) vector.x / BreakableFloorTile.sprite.getWidth(),
						(int) vector.y / BreakableFloorTile.sprite.getHeight(), -1);
			} catch (TileNotFoundException e) {
				// Silently ignore; we're just checking if the tile still exists
			}
		}
	}

	public void breakTile(GameEngine engine) {
		if (alarm == null || !alarm.isRunning()) {
			this.engine = Objects.requireNonNull(engine, "engine cannot be null");
			Alarm alarm = new Alarm(null, 2);
			alarm.addTarget(this);
			alarm.start();
		}
	}

}
