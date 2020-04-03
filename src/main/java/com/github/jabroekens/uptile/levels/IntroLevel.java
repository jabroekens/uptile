package com.github.jabroekens.uptile.levels;

import java.awt.Color;

import com.github.jabroekens.uptile.Uptile;
import com.github.jabroekens.uptile.tiles.BreakableFloorTile;
import com.github.jabroekens.uptile.tiles.FloorTile;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.EdgeFollowingViewport;
import nl.han.ica.oopg.view.View;

public class IntroLevel extends Level {

	public IntroLevel(Uptile uptile) {
		super(uptile, 2000, 2000, 500, 500);
	}

	@Override
	public void load() {
		TileType<FloorTile> floorTileType = new TileType<>(FloorTile.class, FloorTile.sprite);
		TileType<BreakableFloorTile> breakableFloorTileType = new TileType<>(BreakableFloorTile.class,
				BreakableFloorTile.sprite);

		TileType[] tileTypes = { floorTileType, breakableFloorTileType };
		int tileMap[][] = {
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, 0, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
		};

		uptile.setTileMap(new TileMap(50, tileTypes, tileMap));
		uptile.addGameObject(uptile.getPlayer(), 50, 50);

		EdgeFollowingViewport vp = new EdgeFollowingViewport(uptile.getPlayer(), super.getViewWidth(),
				super.getViewHeight());
		View view = new View(vp, super.getWorldWidth(), super.getWorldHeight());
		uptile.setView(view);
		uptile.size(super.getViewWidth(), super.getViewHeight());
		uptile.setBackground(new Color(0, 50, 75));
	}

	@Override
	public void unload() {
		// TODO
	}

}
