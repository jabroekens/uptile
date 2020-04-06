package com.github.jabroekens.uptile;

import java.util.List;

import com.github.jabroekens.uptile.monsters.Monster;
import com.github.jabroekens.uptile.tiles.BreakableFloorTile;
import com.github.jabroekens.uptile.tiles.FloorTile;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.tile.Tile;
import nl.han.ica.oopg.tile.TileMap;
import processing.core.PVector;

public class Player extends AnimatedSpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles, IAlarmListener, Audible {

	// static to preserve memory; all instances of this class use the same sprite and speeds
	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/bunny.png"));
	private static final float[] SPEEDS = { 3.0F, 8.0F };

	private int score, level;
	private final Uptile uptile;
	private boolean canJump = true, canMove;

	private final Alarm[] alarms = {
			new Alarm("left", Player.SPEEDS[0] / 10.0D),
			new Alarm("right", Player.SPEEDS[0] / 10.0D)
	};

	private final Sound[] sounds;

	public Player(Uptile uptile, int spawnX, int spawnY) {
		super(Player.SPRITE, 7);
		this.uptile = uptile;
		sounds = new Sound[] {
				new Sound(uptile, Uptile.MEDIA_URL.concat("audio/walking.mp3")),
				new Sound(uptile, Uptile.MEDIA_URL.concat("audio/jump.mp3")),
				new Sound(uptile, Uptile.MEDIA_URL.concat("audio/death.mp3"))
		};

		setX(spawnX);
		setY(spawnY);

		setCurrentFrameIndex(2);
		setFriction(0.02F);
		setGravity(0.2F);

		setxSpeed(Player.SPEEDS[0]);
		setySpeed(Player.SPEEDS[1]);

		alarms[0].addTarget(this);
		alarms[0].addTarget(this);
	}

	@Override
	public void update() {
		if (getX() <= 0) {
			setX(0);
		}

		if (getX() >= uptile.getView().getWorldWidth() - getWidth()) {
			setX(uptile.getView().getViewport().getZoomWidth() - getWidth());
		}

		if (getY() <= 0) {
			setY(0);
		}

		if (getY() >= uptile.getView().getWorldHeight() - getHeight()) {
			respawn();
		}
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject obj : collidedGameObjects) {
			if (obj instanceof Launchpad) {
				canMove = true;
				canJump = true;
			}

			if (obj instanceof Monster) {
				sounds[2].play(0);
			}
		}
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		TileMap map = uptile.getTileMap();

		for (CollidedTile ct : collidedTiles) {
			Tile tile = ct.getTile();

			if (tile instanceof FloorTile) {
				try {
					PVector vector = map.getTilePixelLocation(tile);

					switch (ct.getCollisionSide()) {
					case INSIDE:
					case TOP:
						setY(vector.y - getHeight());
						setySpeed(Player.SPEEDS[1]);

						if (tile instanceof BreakableFloorTile) {
							((BreakableFloorTile) tile).breakTile(uptile);
						}

						if (getCurrentFrameIndex() == 1) {
							setCurrentFrameIndex(2);
						}

						canJump = true;
						canMove = true;
						break;
					case LEFT:
						setX(vector.x - getWidth());
						break;
					case RIGHT:
						setX(vector.x + map.getTileSize());
						break;
					default:
						break; // We've handled all the relevant cases
					}
				} catch (TileNotFoundException e) {
					// Silently ignore; we're just checking if the tile exists
				}
			}
		}
	}

	@Override
	public void keyPressed(int keyCode, char key) {
		switch (key) {
		case 'a':
			if (canMove) {
				setDirectionSpeed(-90, canJump ? Player.SPEEDS[0] : Player.SPEEDS[0] * 1.8F);
				setCurrentFrameIndex(6);

				alarms[0].startIfNotRunning();
				sounds[0].play(0);
				canMove = false;
			}
			break;
		case 'd':
			if (canMove) {
				setDirectionSpeed(90, canJump ? Player.SPEEDS[0] : Player.SPEEDS[0] * 1.8F);
				setCurrentFrameIndex(3);

				alarms[1].startIfNotRunning();
				sounds[0].play(0);
				canMove = false;
			}
			break;
		case ' ':
			if (canJump) {
				setDirectionSpeed(0, Player.SPEEDS[1]);
				setCurrentFrameIndex(1);
				sounds[1].play(0);
				canJump = false;
				canMove = true;
			}
			break;
		default:
			break; // We've handled all the relevant cases
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		if (alarmName.equalsIgnoreCase("left") && getCurrentFrameIndex() == 6) {
			setCurrentFrameIndex(5);
		} else if (alarmName.equalsIgnoreCase("right") && getCurrentFrameIndex() == 3) {
			setCurrentFrameIndex(4);
		}
	}

	/**
	 * @return player's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score sets player's score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return player's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level sets player's level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * sets player's score and level to 0, and restarts the level
	 */
	public void respawn() {
		score = 0;
		level = 0;
		setxSpeed(0);
		setySpeed(0);
		uptile.reloadLevel();
	}

	@Override
	public void stopSound() {
		for (Sound sound : sounds) {
			sound.pause();
		}
	}

}
