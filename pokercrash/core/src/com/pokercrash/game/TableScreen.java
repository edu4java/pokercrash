package com.pokercrash.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pokercrash.game.model.GameTable;
import com.pokercrash.game.model.IService;
import com.pokercrash.game.model.Seat;
import com.pokercrash.game.model.TableChangeListener;
import com.pokercrash.game.model.User;

public class TableScreen implements Screen {

	private static final float[][] SEAT_POS = { { 463.0f, 447.0f }, { 619.25f, 390.75f }, { 658.0f, 277.0f },
			{ 565.5f, 160.75f }, { 334.25f, 118.25f }, { 111.75f, 162.0f }, { 14.25f, 278.25f }, { 64.25f, 389.5f },
			{ 220.5f, 448.25f } };
	private Pokercrash pokercrash;
	private Stage stage;

	private ArrayList<ActorSeat> actorSeats;
	private IService service;
	private int idGameTable;

	public TableScreen(Pokercrash pokercrash,int idGameTable) {
		this.idGameTable = idGameTable;
		this.pokercrash = pokercrash;
		this.service = pokercrash.getService();
	}

	/**
	 * actualiza los actores con el modelo
	 */
	private void updateView() {
		GameTable table = service.getGameTable(idGameTable);
		ArrayList<Seat> seats = table.getSeats();
		for (int i = 0; i < actorSeats.size(); i++) {
			actorSeats.get(i).updateModel(seats.get(i));
		}
	}

	@Override
	public void show() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		float ancho = 800;
		stage = new Stage(new FitViewport(ancho, ancho * h / w));
		Gdx.input.setInputProcessor(stage);

		Image background = new Image(Assets.table_background);
		stage.addActor(background);
		actorSeats = new ArrayList<ActorSeat>();
		for (int i = 0; i < 9; i++) {
			final ActorSeat seat = new ActorSeat(i,Assets.player);
			seat.setPosition(SEAT_POS[i][0], SEAT_POS[i][1]);
			seat.addListener(new InputListener(){
				@Override
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					if (service.tryReservedSeat(idGameTable,seat.getSeatPos())) {
						Gdx.input.getTextInput(new TextInputListener() {
							@Override
							public void input(String money) {
								if (service.trySeat(idGameTable,money)) {
									seat.setStack("$10");
								}
							}
							@Override
							public void canceled() {
								service.cancelSeat(idGameTable,seat.getSeatPos());
							}
						}, "cuanto ? de los "+ service.getUser().getMoney(), service.getGameTable(idGameTable).getMinStack()+"");
					};
					return false;
				}
				
			});
			stage.addActor(seat);
			actorSeats.add(seat);
		}
		
		updateView();
		service.addTableChangeListener(new TableChangeListener() {
			@Override
			public void onChange() {
				// actualizar esta ventana para reflejar los cambios	
				updateView();
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
