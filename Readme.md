# Slick2D Spriter implementation

This project implements the abstract loader and drawer classes of the generic
Java implementation for Spriter.

Simply import `com.brashmonkey.spriter.slick.Loader` and
`com.brashmonkey.spriter.slick.Drawer` and you should be ready to go.

Example
=======

```
public class SpriterTest extends BasicGame {

    private Drawer drawer;
	private Player player;

    public SpriterTest() {
        super("Spriter test for Slick2D");
    }

    @Override
    public void init(final GameContainer gc) throws SlickException {
        String scml = "";
        try {
            String[] tmp = {""};
            Files.readAllLines(Paths.get("assets/monster/basic_002.scml"))
                    .forEach(line -> tmp[0] += line);
            scml = tmp[0];
        } catch (IOException ex) {
            System.out.println(ex);
        }
        // Parse the scml file
		Data data = new SCMLReader(scml).getData();
        // The the desired entity
		player = new Player(data.getEntity(0));
        // Position the player
		player.setPosition(640, 480);
		// Initialize the loader
    	Loader loader = new Loader(data);
    	// Load the assets
    	loader.load("assets/monster");
    	// Initialize the drawer
    	this.drawer = new Drawer(gc, loader);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        // Update the player on each game iteration
    	player.update();
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        // Draw the player on each render call
    	drawer.draw(player);
    }
}
```