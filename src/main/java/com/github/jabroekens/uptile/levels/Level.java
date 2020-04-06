package com.github.jabroekens.uptile.levels;

import java.util.Iterator;

import com.github.jabroekens.uptile.Audible;
import com.github.jabroekens.uptile.Uptile;
import com.github.jabroekens.uptile.tiles.BreakableFloorTile;
import com.github.jabroekens.uptile.tiles.FloorTile;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.EdgeFollowingViewport;
import nl.han.ica.oopg.view.View;
import processing.core.PImage;

public abstract class Level implements Audible {

	protected final Uptile uptile;
	private final PImage backgroundImage;
	private final Sound backgroundSound;

	private final int viewWidth, viewHeight;
	private final int spawnX, spawnY;
	private final int[][] tileMap;

	protected Level(int viewWidth, int viewHeight, int spawnX, int spawnY, int[][] tileMap, Uptile uptile, PImage backgroundImage, String bgSoundFile) {
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.tileMap = tileMap;
		this.uptile = uptile;
		this.backgroundImage = backgroundImage;
		backgroundSound = new Sound(uptile, bgSoundFile);
	}

	@Override
	public void stopSound() {
		backgroundSound.pause();
	}

	/**
	 * @return player's spawn x-coordinate
	 */
	public int getSpawnX() {
		return spawnX;
	}

	/**
	 * @return player's spawn y-coordinate
	 */
	public int getSpawnY() {
		return spawnY;
	}

	/**
	 * load level
	 */
	public void load() {
		initializeTileMap();
		initializeView();

		uptile.addGameObject(uptile.getPlayer(), spawnX, spawnY);
		addGameObjects();

		backgroundSound.loop(-1);
	}

	/**
	 * unload level
	 */
	public void unload() {
		Iterator<GameObject> it = uptile.getGameObjectItems().iterator();

		while (it.hasNext()) {
			GameObject obj = it.next();

			if (obj instanceof Audible) {
				((Audible) obj).stopSound();
			}

			it.remove();
		}
	}

	private void initializeTileMap() {
		TileType<FloorTile> floorTileType = new TileType<>(FloorTile.class, FloorTile.SPRITE);
		TileType<BreakableFloorTile> breakableFloorTileType = new TileType<>(BreakableFloorTile.class, BreakableFloorTile.SPRITE);

		TileType<?>[] tileTypes = { floorTileType, breakableFloorTileType };
		uptile.setTileMap(new TileMap(FloorTile.SPRITE.getWidth(), tileTypes, tileMap));
	}

	private void initializeView() {
		EdgeFollowingViewport vp = new EdgeFollowingViewport(uptile.getPlayer(), viewWidth, viewHeight);
		vp.setTopTolerance(FloorTile.SPRITE.getHeight());
		vp.setX(0);
		vp.setY(backgroundImage.height - viewHeight);

		View view = new View(vp, backgroundImage.width, backgroundImage.height);
		view.setBackground(backgroundImage);
		uptile.setView(view);

		uptile.size(viewWidth, viewHeight);
	}

	/**
	 * add a GameObject to the 'world', aligned to the tile (tileX,tileY)
	 *
	 * @param obj
	 * @param tileX
	 * @param tileY
	 */
	protected void mapToTile(GameObject obj, int tileX, int tileY) {
		int tileSize = uptile.getTileMap().getTileSize();
		uptile.addGameObject(obj, tileX * tileSize, backgroundImage.height - tileY * tileSize);
	}

	/**
	 * add all desired GameObjects to the 'world'
	 */
	protected abstract void addGameObjects();

}
