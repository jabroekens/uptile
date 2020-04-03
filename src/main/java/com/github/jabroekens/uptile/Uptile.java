package com.github.jabroekens.uptile;

import com.github.jabroekens.uptile.levels.IntroLevel;
import com.github.jabroekens.uptile.levels.Level;
import nl.han.ica.oopg.engine.GameEngine;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Uptile extends GameEngine {

	public static final String MEDIA_URL = "src/main/com/github/jabroekens/uptile/media";

	public static void main(String[] args) {
		PApplet.runSketch(new String[] { "com.github.jabroekens.uptile.Uptile" }, new Uptile());
	}

	private final Level[] levels = { new IntroLevel(this) };
	private final Player player = new Player(this);
	private int lastLevel = 0;

	@Override
	public void setupGame() {
		levels[0].load();
	}

	@Override
	public void update() {
		int newLevel = player.getLevel();
		if (newLevel != lastLevel && newLevel < levels.length) {
			levels[lastLevel].unload();
			levels[newLevel].load();
			lastLevel = newLevel;
		}
	}

	public Player getPlayer() {
		return player;
	}

}
