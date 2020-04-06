package com.github.jabroekens.uptile;

public class Alarm extends nl.han.ica.oopg.alarm.Alarm {

	private boolean isRunning = false;

	public Alarm(String name, double seconds) {
		super(name, seconds);
	}

	@Override
	public void start() {
		super.start();
		isRunning = true;
	}

	@Override
	public void stop() {
		super.stop();
		isRunning = false;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void startIfNotRunning() {
		if (!isRunning) {
			start();
		}
	}

}
