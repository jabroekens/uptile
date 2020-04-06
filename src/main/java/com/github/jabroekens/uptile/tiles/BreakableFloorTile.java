package com.github.jabroekens.uptile.tiles;

import com.github.jabroekens.uptile.Alarm;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;

public class BreakableFloorTile extends FloorTile implements IAlarmListener {

	public static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/tile_breakable.png"));

	private Uptile uptile;
	private Alarm alarm = new Alarm(null, 2);

	public BreakableFloorTile(Sprite sprite) {
		super(sprite);
		alarm.addTarget(this);
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if (uptile != null) {
			try {
				PVector vector = uptile.getTileMap().getTilePixelLocation(this);
				uptile.getTileMap().setTile((int) vector.x / BreakableFloorTile.SPRITE.getWidth(),
						(int) vector.y / BreakableFloorTile.SPRITE.getHeight(), -1);
			} catch (TileNotFoundException e) {
				// Silently ignore; we're just checking if the tile still exists
			}
		}
	}

	public void breakTile(Uptile uptile) {
		this.uptile = uptile;
		alarm.startIfNotRunning();
	}

}
