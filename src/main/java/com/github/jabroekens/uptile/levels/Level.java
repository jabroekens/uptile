package com.github.jabroekens.uptile.levels;

import java.util.Objects;

import com.github.jabroekens.uptile.Uptile;

public abstract class Level {

	protected final Uptile uptile;
	private final int worldWidth;
	private final int worldHeight;
	private final int viewWidth;
	private final int viewHeight;

	protected Level(Uptile uptile, int worldWidth, int worldHeight, int viewWidth, int viewHeight) {
		this.uptile = Objects.requireNonNull(uptile, "uptile cannot be null");
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
	}

	public int getWorldWidth() {
		return worldWidth;
	}

	public int getWorldHeight() {
		return worldHeight;
	}

	public int getViewWidth() {
		return viewWidth;
	}

	public int getViewHeight() {
		return viewHeight;
	}

	public abstract void load();

	public abstract void unload();

}
