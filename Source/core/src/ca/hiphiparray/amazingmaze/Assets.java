/********************************************************************************
 * Amazing Maze is an educational game created in Java with the libGDX library.
 * Copyright (C) 2017 Hip Hip Array
 *
 * This file is part of Amazing Maze.
 *
 * Amazing Maze is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Amazing Maze is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Amazing Maze. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package ca.hiphiparray.amazingmaze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.Disposable;

/**
 * Class to easily manage assets, furthering the capabilities of an {@link AssetManager};
 *
 * @since 0.1
 * @author Vincent Macri
 * @author Chloe Nguyen
 * @author Susie Son
 * <br>
 * Time (Chloe): 30 minutes
 * <br>
 * Time (Vincent): 3 hours
 */
public class Assets implements Disposable {

	/** Efficiently manages game assets. */
	protected AssetManager manager;

	/** The UI skin. */
	protected Skin skin;

	/** The name of the sans header style in the UI skin. */
	protected static final String SANS_HEADER_STYLE = "header";
	/** The name of the serif header style in the UI skin. */
	protected static final String SERIF_HEADER_STYLE = "serif-header";
	/** The name of the credits contents style in the UI skin. */
	protected static final String CREDITS_CONTENTS = "contents";
	/** The name of the small credits contents style in the UI skin. */
	protected static final String SMALL_CREDITS_CONTENTS = "small-contents";
	/** The name of the hud label style in the UI skin. */
	protected static final String HUD_STYLE = "hud";
	/** The name of the story label style in the UI skin. */
	protected static final String STORY_STYLE = "story";
	/** The name of the white sans label style in the UI skin. */
	protected static final String WHITE_SANS_STYLE = "white-sans";

	/** The location of the tile atlas. */
	protected static final String GAME_ATLAS_LOCATION = "game/pack.atlas";

	/** The regular monospace font. */
	protected static final String MONO_REGULAR = "LiberationMono-Regular";

	/** The regular sans font. */
	protected static final String SANS_REGULAR = "LiberationSans-Regular";
	/** The bold sans font. */
	protected static final String SANS_BOLD = "LiberationSans-Bold";

	/** The regular serif font. */
	protected static final String SERIF_REGULAR = "LiberationSerif-Regular";
	/** The bold serif font. */
	protected static final String SERIF_BOLD = "LiberationSerif-Bold";

	/** The font size for small text. */
	protected static final int SMALL_FONT_SIZE = 32;
	/** The font size for regular text. */
	protected static final int REGULAR_FONT_SIZE = 64;
	/** The font size for large text. */
	protected static final int LARGE_FONT_SIZE = 128;

	/** The game logo. */
	protected static final String GAME_LOGO = "logos/game.png";
	/** The company logo. */
	protected static final String COMPANY_LOGO = "logos/company.png";
	/** The life HUD image. */
	protected static final String LIFE_HUD_IMAGE = "hud/life.png";
	/** The menu background image. */
	protected static final String MENU_BACKGROUND_IMAGE = "misc/main.png";
	/** The fish minigame background image. */
	protected static final String MINI_BACKGROUND = "mini/background.png";

	/** The pencil button image. */
	protected static final String PENCIL_BUTTON = "mini/pencil.png";
	/** The eraser button image. */
	protected static final String ERASER_BUTTON = "mini/eraser.png";
	/** The help button image. */
	protected static final String HELP_BUTTON = "mini/help.png";
	/** The check answer button image. */
	protected static final String CHECK_BUTTON = "mini/check.png";
	/** The clear button image. */
	protected static final String CLEAR_BUTTON = "mini/clear.png";

	/** The file name of the song that plays on the menu screen. */
	protected static final String MENU_SONG = "music/SecretsOfTheSchoolyard.mp3";
	/** The file name of the song that plays on the story screen. */
	protected static final String STORY_SONG = "music/Vanes.mp3";
	/** The file name of the song that plays in the maze. */
	protected static final String MAZE_SONG = "music/LightlessDawn.mp3";
	/** The file name of the song that plays on the math screen. */
	protected static final String MATH_SONG = "music/Babylon.mp3";
	/** The file name of the song that plays during the credits. */
	protected static final String CREDITS_SONG = "music/DigitalLemonade.mp3";

	/** The atlas name of the background tile. */
	private static final String BACKGROUND = "background";
	/** The atlas name of the barrier tile. */
	private static final String BARRIER = "blocked";
	/** The atlas name of the placeholder tile. */
	protected static final String PLACEHOLDER = "placeholder";
	/** The atlas name of the mouse. */
	protected static final String MOUSE = "mouse";

	/** The atlas name of the cheese tile. */
	private static final String CHEESE = "cheese";

	/** The string appended to the end of atlas names for their on variation. */
	protected static final String ON_MODIFIER = "-on";
	/** The string appended to the end of atlas names for their off variation. */
	protected static final String OFF_MODIFIER = "-off";
	/** The string appended to the end of atlas names for their unknown variation. */
	protected static final String UNKNOWN_MODIFIER = "-unknown";

	/** The string appended to the end of atlas names for their up variation. */
	protected static final String UP_MODIFIER = "-up";
	/** The string appended to the end of atlas names for their down variation. */
	protected static final String DOWN_MODIFIER = "-down";
	/** The string appended to the end of atlas names for their left variation. */
	private static final String LEFT_MODIFIER = "-left";
	/** The string appended to the end of atlas names for their right variation. */
	private static final String RIGHT_MODIFIER = "-right";

	/** The atlas base name of the vertical wire. */
	private static final String VERTICAL = "vertical";
	/** The atlas base name of the turn wire. */
	private static final String TURN = "turn";

	/** The atlas base name of the AND gate. */
	protected static final String AND_GATE = "and";
	/** The atlas base name of the NAND gate. */
	protected static final String NAND_GATE = "nand";
	/** The atlas base name of the OR gate. */
	protected static final String OR_GATE = "or";
	/** The atlas base name of the NOR gate. */
	protected static final String NOR_GATE = "nor";
	/** The atlas base name of the XOR gate. */
	protected static final String XOR_GATE = "xor";

	/** The atlas base name of the fish. */
	protected static final String FISH = "fish";

	/** The string appended to the end of the fish atlas name for the blue variant. */
	protected static final String BLUE_MODIFIER = "-blue";
	/** The string appended to the end of the fish atlas name for the blue variant. */
	protected static final String PURPLE_MODIFIER = "-purple";
	/** The string appended to the end of the fish atlas name for the blue variant. */
	protected static final String GREEN_MODIFIER = "-green";
	/** The string appended to the end of the fish atlas name for the blue variant. */
	protected static final String RED_MODIFIER = "-red";
	/** The string appended to the end of the fish atlas name for the blue variant. */
	protected static final String ORANGE_MODIFIER = "-orange";

	/** The set of tiles used in the maps. */
	protected TiledMapTileSet tiles;

	/** How many frames the mouse animation has. */
	protected static final int MOUSE_FRAME_COUNT = 5;
	/** The index of the mouse running frame. */
	protected static final int MOUSE_RUN_FRAME = 3;
	/** How long to spend on each frame of the mouse animations. */
	protected static final float MOUSE_FRAME_DURATION = 0.25f;

	/** The mouse walking up animation. */
	protected static Animation<TextureRegion> mouseUp;
	/** The mouse walking down animation. */
	protected static Animation<TextureRegion> mouseDown;
	/** The mouse walking left animation. */
	protected static Animation<TextureRegion> mouseLeft;
	/** The mouse walking right animation. */
	protected static Animation<TextureRegion> mouseRight;

	/**
	 * {@link Assets} constructor.
	 * Calling this constructor loads in all of the game assets.
	 * As such, only one {@link Assets} instance should ever be created.
	 */
	public Assets() {
		manager = new AssetManager();

		// Allow loading FreeTypeFonts.
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

		loadSkin();
		loadMapResources();
		setupMouseAnimation();

		manager.load(GAME_LOGO, Texture.class);
		manager.load(COMPANY_LOGO, Texture.class);
		manager.load(LIFE_HUD_IMAGE, Texture.class);
		manager.load(MENU_BACKGROUND_IMAGE, Texture.class);
		manager.load(MINI_BACKGROUND, Texture.class);
		manager.load(PENCIL_BUTTON, Texture.class);
		manager.load(ERASER_BUTTON, Texture.class);
		manager.load(HELP_BUTTON, Texture.class);
		manager.load(CHECK_BUTTON, Texture.class);
		manager.load(CLEAR_BUTTON, Texture.class);

		loadMusic();

		manager.finishLoading();
	}

	/** Helper method to setup the mouse animation. */
	private void setupMouseAnimation() {
		TextureAtlas atlas = manager.get(Assets.GAME_ATLAS_LOCATION, TextureAtlas.class); // Reference used for readability.
		mouseUp = new Animation<TextureRegion>(MOUSE_FRAME_DURATION, atlas.findRegions(Assets.MOUSE + Assets.UP_MODIFIER), PlayMode.LOOP_PINGPONG);
		mouseDown = new Animation<TextureRegion>(MOUSE_FRAME_DURATION, atlas.findRegions(Assets.MOUSE + Assets.DOWN_MODIFIER), PlayMode.LOOP_PINGPONG);
		mouseLeft = new Animation<TextureRegion>(MOUSE_FRAME_DURATION, atlas.findRegions(Assets.MOUSE + Assets.LEFT_MODIFIER), PlayMode.LOOP_PINGPONG);
		mouseRight = new Animation<TextureRegion>(MOUSE_FRAME_DURATION, atlas.findRegions(Assets.MOUSE + Assets.RIGHT_MODIFIER), PlayMode.LOOP_PINGPONG);

		assert mouseUp.getKeyFrames().length == MOUSE_FRAME_COUNT : "mouseUp frame count does not match MOUSE_FRAME_COUNT.";
		assert mouseDown.getKeyFrames().length == MOUSE_FRAME_COUNT : "mouseDown frame count does not match MOUSE_FRAME_COUNT.";
		assert mouseLeft.getKeyFrames().length == MOUSE_FRAME_COUNT : "mouseLeft frame count does not match MOUSE_FRAME_COUNT.";
		assert mouseRight.getKeyFrames().length == MOUSE_FRAME_COUNT : "mouseRight frame count does not match MOUSE_FRAME_COUNT.";
	}

	/** Helper method to load the game's music. */
	private void loadMusic() {
		manager.load(MENU_SONG, Music.class);
		manager.load(STORY_SONG, Music.class);
		manager.load(MAZE_SONG, Music.class);
		manager.load(MATH_SONG, Music.class);
		manager.load(CREDITS_SONG, Music.class);
	}

	/** Helper method for loading the map resources. */
	private void loadMapResources() {
		manager.load(GAME_ATLAS_LOCATION, TextureAtlas.class);
		manager.finishLoadingAsset(GAME_ATLAS_LOCATION);
		TextureAtlas atlas = manager.get(Assets.GAME_ATLAS_LOCATION, TextureAtlas.class); // Reference used for readability.

		tiles = new TiledMapTileSet();

		StaticTiledMapTile background = new StaticTiledMapTile(atlas.findRegion(BACKGROUND));
		StaticTiledMapTile barrier = new StaticTiledMapTile(atlas.findRegion(BARRIER));
		StaticTiledMapTile placeholder = new StaticTiledMapTile(atlas.findRegion(PLACEHOLDER));

		background.setId(TileIDs.computeID(TileIDs.BACKGROUND));
		barrier.setId(TileIDs.computeID(TileIDs.BARRIER));
		placeholder.setId(TileIDs.computeID(TileIDs.PLACEHOLDER));

		tiles.putTile(background.getId(), background);
		tiles.putTile(barrier.getId(), barrier);
		tiles.putTile(placeholder.getId(), placeholder);

		StaticTiledMapTile verticalOn = new StaticTiledMapTile(atlas.findRegion(VERTICAL + ON_MODIFIER));
		StaticTiledMapTile verticalOff = new StaticTiledMapTile(atlas.findRegion(VERTICAL + OFF_MODIFIER));
		StaticTiledMapTile verticalUnknown = new StaticTiledMapTile(atlas.findRegion(VERTICAL + UNKNOWN_MODIFIER));

		verticalOn.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.VERTICAL, TileIDs.ON));
		verticalOff.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.VERTICAL, TileIDs.OFF));
		verticalUnknown.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.VERTICAL, TileIDs.UNKNOWN));

		tiles.putTile(verticalOn.getId(), verticalOn);
		tiles.putTile(verticalOff.getId(), verticalOff);
		tiles.putTile(verticalUnknown.getId(), verticalUnknown);

		loadGates(atlas, ON_MODIFIER, UP_MODIFIER, TileIDs.ON, TileIDs.UP_GATE);
		loadGates(atlas, ON_MODIFIER, DOWN_MODIFIER, TileIDs.ON, TileIDs.DOWN_GATE);
		loadGates(atlas, OFF_MODIFIER, UP_MODIFIER, TileIDs.OFF, TileIDs.UP_GATE);
		loadGates(atlas, OFF_MODIFIER, DOWN_MODIFIER, TileIDs.OFF, TileIDs.DOWN_GATE);
		loadGates(atlas, UNKNOWN_MODIFIER, UP_MODIFIER, TileIDs.UNKNOWN, TileIDs.UP_GATE);
		loadGates(atlas, UNKNOWN_MODIFIER, DOWN_MODIFIER, TileIDs.UNKNOWN, TileIDs.DOWN_GATE);

		StaticTiledMapTile turnOnUpLeft = new StaticTiledMapTile(atlas.findRegion(TURN + ON_MODIFIER + UP_MODIFIER + LEFT_MODIFIER));
		StaticTiledMapTile turnOffUpLeft = new StaticTiledMapTile(atlas.findRegion(TURN + OFF_MODIFIER + UP_MODIFIER + LEFT_MODIFIER));
		StaticTiledMapTile turnOnUpRight = new StaticTiledMapTile(atlas.findRegion(TURN + ON_MODIFIER + UP_MODIFIER + RIGHT_MODIFIER));
		StaticTiledMapTile turnOffUpRight = new StaticTiledMapTile(atlas.findRegion(TURN + OFF_MODIFIER + UP_MODIFIER + RIGHT_MODIFIER));
		StaticTiledMapTile turnOnDownLeft = new StaticTiledMapTile(atlas.findRegion(TURN + ON_MODIFIER + DOWN_MODIFIER + LEFT_MODIFIER));
		StaticTiledMapTile turnOffDownLeft = new StaticTiledMapTile(atlas.findRegion(TURN + OFF_MODIFIER + DOWN_MODIFIER + LEFT_MODIFIER));
		StaticTiledMapTile turnOnDownRight = new StaticTiledMapTile(atlas.findRegion(TURN + ON_MODIFIER + DOWN_MODIFIER + RIGHT_MODIFIER));
		StaticTiledMapTile turnOffDownRight = new StaticTiledMapTile(atlas.findRegion(TURN + OFF_MODIFIER + DOWN_MODIFIER + RIGHT_MODIFIER));

		turnOnUpLeft.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.ON, TileIDs.UP_LEFT));
		turnOffUpLeft.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.OFF, TileIDs.UP_LEFT));
		turnOnUpRight.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.ON, TileIDs.UP_RIGHT));
		turnOffUpRight.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.OFF, TileIDs.UP_RIGHT));
		turnOnDownLeft.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.ON, TileIDs.DOWN_LEFT));
		turnOffDownLeft.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.OFF, TileIDs.DOWN_LEFT));
		turnOnDownRight.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.ON, TileIDs.DOWN_RIGHT));
		turnOffDownRight.setId(TileIDs.computeID(TileIDs.WIRE_RANGE, TileIDs.TURN, TileIDs.OFF, TileIDs.DOWN_RIGHT));

		tiles.putTile(turnOnUpLeft.getId(), turnOnUpLeft);
		tiles.putTile(turnOffUpLeft.getId(), turnOffUpLeft);
		tiles.putTile(turnOnUpRight.getId(), turnOnUpRight);
		tiles.putTile(turnOffUpRight.getId(), turnOffUpRight);
		tiles.putTile(turnOnDownLeft.getId(), turnOnDownLeft);
		tiles.putTile(turnOffDownLeft.getId(), turnOffDownLeft);
		tiles.putTile(turnOnDownRight.getId(), turnOnDownRight);
		tiles.putTile(turnOffDownRight.getId(), turnOffDownRight);

		loadFish(atlas, BLUE_MODIFIER, TileIDs.BLUE);
		loadFish(atlas, PURPLE_MODIFIER, TileIDs.PURPLE);
		loadFish(atlas, GREEN_MODIFIER, TileIDs.GREEN);
		loadFish(atlas, RED_MODIFIER, TileIDs.RED);
		loadFish(atlas, ORANGE_MODIFIER, TileIDs.ORANGE);

		StaticTiledMapTile cheese = new StaticTiledMapTile(atlas.findRegion(CHEESE));
		cheese.setId(TileIDs.computeID(TileIDs.POWERUP_RANGE, TileIDs.CHEESE));
		tiles.putTile(cheese.getId(), cheese);
	}

	/**
	 * Load the fish with the given parameters.
	 *
	 * @param atlas the {@link TextureAtlas} to load from.
	 * @param colourName the name of the colour in the atlas.
	 * @param colourID the ID of the colour in {@link TileIDs}.
	 */
	private void loadFish(TextureAtlas atlas, String colourName, int colourID) {
		StaticTiledMapTile fish = new StaticTiledMapTile(atlas.findRegion(FISH + colourName));
		fish.setId(TileIDs.computeID(TileIDs.POWERUP_RANGE, TileIDs.FISH, colourID));
		tiles.putTile(fish.getId(), fish);
	}

	/**
	 * Load all gates for the given parameters.
	 *
	 * @param atlas the {@link TextureAtlas} to load from.
	 * @param electricStateName the name of the electrical state of the gates to load.
	 * @param directionName the name of the direction of the gates to load.
	 * @param electricID the ID of the electrical state of the gates to load.
	 * @param directionID the directional ID of the gates to load.
	 */
	private void loadGates(TextureAtlas atlas, String electricStateName, String directionName, int electricID, int directionID) {
		StaticTiledMapTile and = new StaticTiledMapTile(atlas.findRegion(AND_GATE + electricStateName + directionName));
		StaticTiledMapTile nand = new StaticTiledMapTile(atlas.findRegion(NAND_GATE + electricStateName + directionName));
		StaticTiledMapTile or = new StaticTiledMapTile(atlas.findRegion(OR_GATE + electricStateName + directionName));
		StaticTiledMapTile nor = new StaticTiledMapTile(atlas.findRegion(NOR_GATE + electricStateName + directionName));
		StaticTiledMapTile xor = new StaticTiledMapTile(atlas.findRegion(XOR_GATE + electricStateName + directionName));

		and.setId(TileIDs.computeID(TileIDs.GATE_RANGE, TileIDs.AND_GATE, directionID, electricID));
		nand.setId(TileIDs.computeID(TileIDs.GATE_RANGE, TileIDs.NAND_GATE, directionID, electricID));
		or.setId(TileIDs.computeID(TileIDs.GATE_RANGE, TileIDs.OR_GATE, directionID, electricID));
		nor.setId(TileIDs.computeID(TileIDs.GATE_RANGE, TileIDs.NOR_GATE, directionID, electricID));
		xor.setId(TileIDs.computeID(TileIDs.GATE_RANGE, TileIDs.XOR_GATE, directionID, electricID));

		tiles.putTile(and.getId(), and);
		tiles.putTile(nand.getId(), nand);
		tiles.putTile(or.getId(), or);
		tiles.putTile(nor.getId(), nor);
		tiles.putTile(xor.getId(), xor);
	}

	/** Load the UI skin. */
	private void loadSkin() {
		manager.load("ui/flat-earth-ui.json", Skin.class);
		manager.finishLoadingAsset("ui/flat-earth-ui.json"); // Make sure the skin is loaded before continuing.
		skin = manager.get("ui/flat-earth-ui.json", Skin.class); // Retrieve the skin.

		// Set the fonts. This is not done in the .json in order to allow easier adjusting of font size
		skin.get(LabelStyle.class).font = getFont(SANS_REGULAR, REGULAR_FONT_SIZE);
		skin.get(TextButtonStyle.class).font = getFont(MONO_REGULAR, REGULAR_FONT_SIZE);

		skin.get(SANS_HEADER_STYLE, LabelStyle.class).font = getFont(SANS_BOLD, LARGE_FONT_SIZE);
		skin.get(SERIF_HEADER_STYLE, LabelStyle.class).font = getFont(SERIF_BOLD, LARGE_FONT_SIZE);
		skin.get(CREDITS_CONTENTS, LabelStyle.class).font = getFont(SERIF_REGULAR, LARGE_FONT_SIZE);
		skin.get(SMALL_CREDITS_CONTENTS, LabelStyle.class).font = getFont(SERIF_REGULAR, REGULAR_FONT_SIZE);
		skin.get(HUD_STYLE, LabelStyle.class).font = getFont(MONO_REGULAR, SMALL_FONT_SIZE);
		skin.get(STORY_STYLE, LabelStyle.class).font = getFont(SERIF_REGULAR, REGULAR_FONT_SIZE);
		skin.get(WHITE_SANS_STYLE, LabelStyle.class).font = getFont(SANS_REGULAR, REGULAR_FONT_SIZE);

		skin.get(CheckBoxStyle.class).font = getFont(SANS_REGULAR, REGULAR_FONT_SIZE);
		skin.get(TextFieldStyle.class).font = getFont(SANS_REGULAR, REGULAR_FONT_SIZE);
		skin.get(WindowStyle.class).titleFont = getFont(SANS_REGULAR, SMALL_FONT_SIZE);
	}

	/**
	 * Return the given font, if it is loaded. The font will be lazily loaded if it is not loaded already.
	 *
	 * @param fontName the name of the font.
	 * @param fontSize the size of the font.
	 * @return the desired {@link BitmapFont}.
	 */
	protected BitmapFont getFont(String fontName, int fontSize) {
		if (manager.containsAsset(fontName + fontSize + ".ttf")) {
			return manager.get(fontName + fontSize + ".ttf");
		}
		FreeTypeFontLoaderParameter fontParams = new FreeTypeFontLoaderParameter();
		fontParams.fontFileName = "fonts/" + fontName + ".ttf";

		float horizontalAdjust = Gdx.graphics.getWidth() / 1920f;
		float verticalAdjust = Gdx.graphics.getHeight() / 1080f;
		float totalAdjust = horizontalAdjust * verticalAdjust * 1.25f;
		float screenSize = Math.min(horizontalAdjust, Math.min(verticalAdjust, totalAdjust));

		fontParams.fontParameters.size = (int) (fontSize * Gdx.graphics.getDensity() * screenSize);

		manager.load(fontName + fontSize + ".ttf", BitmapFont.class, fontParams);
		manager.finishLoadingAsset(fontName + fontSize + ".ttf");
		return manager.get(fontName + fontSize + ".ttf");
	}

	@Override
	public void dispose() {
		manager.dispose();
	}
}
