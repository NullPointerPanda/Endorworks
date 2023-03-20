# Documentation for Endorworks

## DesktopLauncher

The `DesktopLauncher` class is responsible for launching the game on desktop platforms. It contains a `main` method that creates an instance of the `LwjglApplication` class with the `EndorworksGame` instance and a configuration object as arguments. The configuration object specifies the title of the game window, the width and height of the game screen, and whether the game window is resizable.

The `DesktopLauncher` class also imports the `CAMERA_WIDTH` and `CAMERA_HEIGHT` constants from the `GameAppConfig` class using the `import static` statement.
## EndorworksGame

The `EndorworksGame` class extends the `Game` class from the libGDX framework and is responsible for managing the different screens of the game.
### Fields 
- `INSTANCE`: a static instance of the `EndorworksGame` class, used for accessing the game instance from other parts of the code. 
- `inputSystem`: an instance of the `InputSystem` class, used for handling input events. 
- `menuScreen`: an instance of the `MenuScreen` class, representing the game's menu screen. 
- `gameScreen`: an instance of the `GameScreen` class, representing the game's main gameplay screen. 
- `assetManager`: an instance of the `AssetManager` class, used for managing game assets such as images and sounds.
### Methods 
- `EndorworksGame()`: the constructor for the `EndorworksGame` class. It sets the `INSTANCE` field to this instance of the class. 
- `create()`: a method that is called once when the game is started. It initializes the `InputSystem`, creates an instance of the `AssetManager` class, and sets the game screen to a `LoadingScreen` instance with the `AssetScreenEnum.GAMESCREEN` argument. 
- `render()`: a method that is called continuously during the game's lifetime. It calls the `render` method of the superclass to render the current screen. 
- `dispose()`: a method that is called when the game is closed. It disposes of the `AssetManager` instance. 
- `onNotify(int keycode)`: a method that is called by the `InputSystem` when an input event is received. It checks the value of `keycode` and sets the game screen to either the `GameScreen` or `MenuScreen` instance depending on the value of the keycode. 
- `initInputSystem()`: a method that initializes the `InputSystem` instance and sets it as the input processor. 
- `initInputObserver()`: a method that adds the `EndorworksGame` instance and the `PlayerManager` instance as observers to the `InputSystem`. 
- `getAssetManager()`: a method that returns the `AssetManager` instance. 
- `getInputProcessor()`: a method that returns the current input processor.
### Import statements

The `EndorworksGame` class imports several classes and packages: 
- `com.badlogic.gdx.Game`: the superclass for the `EndorworksGame` class. 
- `com.badlogic.gdx.Gdx`: a class that provides access to various parts of the libGDX framework, such as input and graphics. 
- `com.badlogic.gdx.InputProcessor`: an interface that defines methods for handling input events. 
- `com.badlogic.gdx.assets.AssetManager`: a class that manages game assets such as images and sounds.
- `de.pandastudios.endorworks.core.screens.Game

## IsometricTile Class

The `IsometricTile` class is responsible for defining the behavior of an isometric tile and rendering it on the screen. It implements the `Disposable` interface to dispose of the tile's texture when it is no longer needed.
### Class Variables 
- `texture`: The texture of the tile. 
- `tilemapPos`: The position of the tile in the TileMap. 
- `worldPos`: The position of the tile in the WorldMap. 
- `onScreen`: A boolean value indicating whether the tile is currently visible on the screen. 
- `aniY`: The Y-axis position of the tile for animation purposes. 
- `time`: The amount of time that has elapsed since the previous frame. 
- `aniSpeed`: The speed at which the tile's animation occurs.
### Class Methods 
- `IsometricTile(Texture texture, Vector2 tilemapPos, Vector2 worldPos)`: Constructor method that sets the values of the `texture`, `tilemapPos`, `worldPos`, `aniY`, and `onScreen` variables. The `aniSpeed` variable is also initialized randomly. 
- `render(SpriteBatch batch, float delta, Vector2 playerTilePos)`: Renders the tile on the screen if it is visible. It checks the tile's distance from the player's position and adjusts the tile's `aniY` value to animate its appearance. The method takes in a `SpriteBatch`, the amount of time that has elapsed since the previous frame, and the position of the player in the TileMap. 
- `dispose()`: Disposes of the tile's texture.
## IsometricTileMap Class

The `IsometricTileMap` class is responsible for creating an isometric tile map, generating a random map or loading a map from a file. It implements the `Disposable` interface to dispose of the tiles' textures when they are no longer needed.
### Class Variables 
- `base_floor`: A linked list of isometric tiles representing the base layer of the tile map. 
- `upper_floor`: A linked list of isometric tiles representing the upper layer of the tile map. 
- `baseMap`: A two-dimensional integer array representing the base layer of the tile map. 
- `upperMap`: A two-dimensional integer array representing the upper layer of the tile map.
### Class Methods 
- `IsometricTileMap()`: Constructor method that initializes the `base_floor` and `upper_floor` linked lists and calls either the `generateMapRandom()` or `generateMapByFile()` method to create the tile map. 
- `renderIsometricTilemap(SpriteBatch batch, float delta, Vector2 playerTilePos)`: Renders the isometric tile map by calling the `render()` method of each isometric tile in the `base_floor` and `upper_floor` linked lists. The method takes in a `SpriteBatch`, the amount of time that has elapsed since the previous frame, and the position of the player in the TileMap. 
- `fillIsometricTileToMap(final int[][] baseMap, final int[][] upperMap, final int rows, final int cols)`: Fills the `base_floor` and `upper_floor` linked lists with the arranged isometric tiles based on the `baseMap` and `upperMap` integer arrays. The method takes in the `baseMap` and `upperMap` integer arrays, the number of rows and columns in the integer arrays.
- `private void generateMapRandom()`

This method generates a random IsometricTileMap. It first creates empty 2D integer arrays for `baseMap` and `upperMap` of size `ISOMETRIC_MAP_SIZE x ISOMETRIC_MAP_SIZE`. It then iterates through each tile in the maps and assigns it a random value based on the probability values.

The probability values are as follows: 
- Base Tile
- Grass (60%)
- Water (20%)
- Sand (20%) 
- Upper Tile
- Grass (10%)
- Tree (20%)
- Water (70%)

After assigning each tile a value, it sets the tile in the center of the map to a grass tile with no upper tile. Finally, it calls the `fillIsometricTileToMap()` method with the `baseMap` and `upperMap` arrays to fill the `base_floor` and `upper_floor` lists.
### `private void generateMapByFile()`

This method generates an IsometricTileMap based on a fixed map from a file. It first reads the map file using the `MapFileHandler.readMap()` method, which returns a 2D String array of size `rows x cols`. It then converts the `String` values in the array to integer values for `baseMap` and `upperMap` using a set of if-else statements.

After assigning each tile a value, it calls the `fillIsometricTileToMap()` method with the `baseMap` and `upperMap` arrays to fill the `base_floor` and `upper_floor` lists.

- `public int[][] getBaseMap()`

This method returns the `baseMap` 2D integer array.
- `public int[][] getUpperMap()`

This method returns the `upperMap` 2D integer array.
- `public void dispose()`

This method disposes of all the `IsometricTile` objects in the `base_floor` and `upper_floor` lists by calling their `dispose()` method.
