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

	private static final Sprite sprite = new Sprite(Uptile.MEDIA_URL.concat("tile_breakable.png"));

	private final GameEngine engine;
	private Alarm alarm;

	public BreakableFloorTile(GameEngine engine) {
		super(BreakableFloorTile.sprite);
		this.engine = Objects.requireNonNull(engine, "engine cannot be null");
	}

	@Override
	public void triggerAlarm(String alarmName) {
		try {
			PVector vector = engine.getTileMap().getTilePixelLocation(this);
			engine.getTileMap().setTile((int) vector.x / BreakableFloorTile.sprite.getWidth(),
					(int) vector.y / BreakableFloorTile.sprite.getHeight(), -1);
		} catch (TileNotFoundException e) {
			// Silently ignore; we're just checking if the tile still exists
		}
	}

	public void breakTile() {
		if (alarm == null || !alarm.isRunning()) {
			Alarm alarm = new Alarm(null, 2);
			alarm.addTarget(this);
			alarm.start();
		}
	}

}
