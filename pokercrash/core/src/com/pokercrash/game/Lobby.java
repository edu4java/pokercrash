package com.pokercrash.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.esotericsoftware.tablelayout.BaseTableLayout;
import com.pokercrash.game.model.GameTable;

public class Lobby implements Screen {

	private static final String HEAD_TITLE = "Titulo poker";
	private Pokercrash pokercrash;
	private Stage stage;
	private List<GameTable> list;
	
	public Sprite fondoLobby;
	public SpriteBatch batchFondoLobby;
	

	public Lobby(Pokercrash pokercrash) {
		super();
		this.pokercrash = pokercrash;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//////-----------------Agrego fondo al LOBBY------------------------///////
		batchFondoLobby.begin();
		fondoLobby.draw(batchFondoLobby);
		batchFondoLobby.end();
		/////////////-------------------------------------//////////////////////////
		
		Table.drawDebug(stage); // borrar cuando se termine
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		///////////////Para fondo////////////////
		batchFondoLobby = new SpriteBatch();		
		Texture fondoLobbyTexture = new Texture(Gdx.files.internal("fondoRojo.jpg"));	
		fondoLobby = new Sprite(fondoLobbyTexture);
		fondoLobby.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		///////////////////////////////////////////////////////////////
		
		Skin skin2 = new Skin(Gdx.files.internal("data/uiskin.json"));

		Table table = new Table();
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Label headline = new Label(HEAD_TITLE, skin2);

		list = new List<GameTable>(skin2);
		list.setItems(pokercrash.getService().getGameTables());
		ScrollPane scrollList = new ScrollPane(list);
		
		
		
		TextButton buttonExit = new TextButton("Exit", skin2);
		buttonExit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
				dispose();
			}
		});		
		TextButton buttonPlay = new TextButton("Play", skin2);
		buttonPlay.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				GameTable gameTable = (GameTable) list.getSelected();
				pokercrash.gotoMesa(gameTable.getId());
				dispose();
			}
			
			
		});						
		
		table.row().expandX();
		table.add(headline);
		table.row();
		table.add(scrollList).align(BaseTableLayout.LEFT);
		table.row();
		table.add(buttonPlay);
		table.add(buttonExit);
		table.row();
		table.debug(); // borrar cuando se termine
		stage.addActor(table);
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
