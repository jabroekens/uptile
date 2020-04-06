package com.github.jabroekens.uptile.monsters;

import com.github.jabroekens.uptile.Alarm;
import com.github.jabroekens.uptile.Uptile;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Stinger extends Monster implements IAlarmListener {

	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/stinger.png"));

	private Alarm moveAlarm = new Alarm(null, 1);
	private Alarm frameAlarm = new Alarm("frame", 0.2);
	private boolean goingLeft;

	public Stinger(Uptile uptile) {
		super(Stinger.SPRITE, 6, uptile, new Sound(uptile, Uptile.MEDIA_URL.concat("audio/stinger.mp3")));
		moveAlarm.addTarget(this);
		frameAlarm.addTarget(this);
	}

	@Override
	public void update() {
		moveAlarm.startIfNotRunning();
		frameAlarm.startIfNotRunning();
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if (alarmName != null) {
			if (goingLeft) {
				setCurrentFrameIndex(getCurrentFrameIndex() == 2 ? 3 : 2);
			} else {
				setCurrentFrameIndex(getCurrentFrameIndex() == 0 ? 1 : 0);
			}
		} else {
			setDirectionSpeed(goingLeft ? 90 : -90, 2F);
			goingLeft = !goingLeft;
		}
	}

}
