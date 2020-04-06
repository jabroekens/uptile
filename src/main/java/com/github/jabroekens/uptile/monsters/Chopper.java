package com.github.jabroekens.uptile.monsters;

import com.github.jabroekens.uptile.Alarm;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Chopper extends Monster implements IAlarmListener {

	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/chopper.png"));

	private Alarm alarm = new Alarm(null, 2);
	private boolean goingDown;

	public Chopper(Uptile uptile) {
		super(Chopper.SPRITE, 1, uptile, new Sound(uptile, Uptile.MEDIA_URL.concat("audio/chopper.mp3")));
		alarm.addTarget(this);
	}

	@Override
	public void update() {
		alarm.startIfNotRunning();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		setDirectionSpeed(goingDown ? 180 : 0, 2F);
		goingDown = !goingDown;
	}

}
