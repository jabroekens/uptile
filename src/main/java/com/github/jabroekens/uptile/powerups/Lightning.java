package com.github.jabroekens.uptile.powerups;

import java.util.Iterator;

import com.github.jabroekens.uptile.Player;
import com.github.jabroekens.uptile.Uptile;
import com.github.jabroekens.uptile.monsters.Monster;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.view.Viewport;

public class Lightning extends Powerup {

	private static final Sprite SPRITE = new Sprite(Uptile.MEDIA_URL.concat("img/item_lightning.png"));

	public Lightning(Uptile uptile) {
		super(Lightning.SPRITE, uptile, new Sound(uptile, Uptile.MEDIA_URL.concat("audio/lightning.mp3")));
	}

	@Override
	protected void usePowerup(Player player) {
		Viewport vp = uptile.getView().getViewport();
		Iterator<GameObject> it = uptile.getGameObjectItems().iterator();

		while (it.hasNext()) {
			GameObject obj = it.next();

			if (obj instanceof Monster
					&& obj.getX() >= vp.getX() && obj.getX() <= vp.getX() + vp.getZoomWidth() - obj.getWidth()
					&& obj.getY() >= vp.getY() && obj.getY() <= vp.getY() + vp.getZoomHeight() - obj.getHeight()) {
				((Monster) obj).stopSound();
				it.remove();
			}
		}

		sound.play(0);
	}

}
