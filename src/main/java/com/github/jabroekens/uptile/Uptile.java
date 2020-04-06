package com.github.jabroekens.uptile;

import com.github.jabroekens.uptile.levels.IntroLevel;
import com.github.jabroekens.uptile.levels.Level;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Uptile extends GameEngine {

	public static final String MEDIA_URL = "com/github/jabroekens/uptile/media/";

	public static void main(String[] args) {
		PApplet.runSketch(new String[] { "com.github.jabroekens.uptile.Uptile" }, new Uptile());
	}

	private final Level[] levels = { new IntroLevel(this) };
	private final Player player = new Player(this, levels[0].getSpawnX(), levels[0].getSpawnY());

	private TextObject scoreText;
	private int lastLevel = 0;

	@Override
	public void setupGame() {
		levels[0].load();
		createDashboard();
	}

	@Override
	public void update() {
		updateDashboard();

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

	public int getViewWidth() {
		return levels[player.getLevel()].getViewWidth();
	}

	public int getViewHeight() {
		return levels[player.getLevel()].getViewHeight();
	}

	public void reloadLevel() {
		levels[player.getLevel()].unload();
		levels[player.getLevel()].load();
	}

	private void createDashboard() {
		Dashboard db = new Dashboard(0, 0, getViewWidth(), 60);

		ScoreIcon icon = new ScoreIcon();
		db.addGameObject(icon, 10, 10);

		scoreText = new TextObject("", 20);
		scoreText.setForeColor(255, 255, 255, 255);
		db.addGameObject(scoreText, (int) icon.getWidth() + 18, 15);

		addDashboard(db);
	}

	private void updateDashboard() {
		scoreText.setText(String.valueOf(player.getScore()));
	}

}
