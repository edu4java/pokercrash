package com.pokercrash.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Login implements Screen {

	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonPlay, buttonExit;
	private BitmapFont white, black; 
	private Pokercrash game;
	private TextField nameText;
	private TextField passwordText;
	
	public Login(Pokercrash game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Table.drawDebug(stage);														// borrar cuando se termine
		stage.act(delta);
		stage.draw(); 
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		float ancho=350;

		stage = new Stage(new FitViewport(ancho, ancho*h/w));

		
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/buttonMio.pack");
		skin = new Skin(atlas);
		 	    
		table = new Table(skin);
		table.setFillParent(true);
//		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		white = new BitmapFont(Gdx.files.internal("fnt/comic_white.fnt"),false);
	    black = new BitmapFont(Gdx.files.internal("fnt/comic_black.fnt"),false);
		
		TextButtonStyle textButtonStyle= new TextButtonStyle();           //tube que importat a mano
		
		textButtonStyle.up = skin.getDrawable("Button_UP");
		textButtonStyle.down = skin.getDrawable("Button_DOWN");
		textButtonStyle.pressedOffsetX = 1 ;
		textButtonStyle.pressedOffsetY = -1 ;
		textButtonStyle.font = black;
		
		
		LabelStyle labelStyle = new LabelStyle(white, Color.RED);

		
		Skin skin2 = new Skin(Gdx.files.internal("data/uiskin.json"));

		Label nameLabel = new Label("Name:", labelStyle);
		nameText = new TextField("", skin2);
		Label addressLabel = new Label("Address:", labelStyle);
		passwordText = new TextField("", skin2);	

		table.row().pad(20);
		table.add(nameLabel);
		table.add(nameText);
		table.row().pad(20);
		table.add(addressLabel);
		table.add(passwordText);
		table.row().pad(20);
		
		
		
		buttonExit = new TextButton("EXIT", textButtonStyle);
		buttonPlay = new TextButton("Play", textButtonStyle);
		buttonPlay.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				boolean valid = game.getService().validateUser(nameText.getText(),passwordText.getText());
				if (valid) {
					game.gotoLobby(); 
					dispose();
				}else {
					nameText.setText("");
					passwordText.setText("");
					//TODO mensaje de error user password 
				}
				
			}
		});
		
		buttonExit.pad(20);  
		table.add(buttonPlay); 

		table.add(buttonExit); 
		
		
		
		table.debug();              												 // borrar cuando se termine
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
