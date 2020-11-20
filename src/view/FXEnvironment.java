package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The {@link Environment}; this class if the core of the the framework for charging new screens. All the javafx
 * {@link Application} relie to this class, this is a only instace classs(singleton).
 * <p>
 * This environment has all the {@link Node} of the application: {@link Stage}, {@link Scene} and {@link StackPane}.
 *
 */
public class FXEnvironment extends Application {
    /**
     * 
     */


    private static FXEnvironment environment;
    private final ScreenLoader loader;
    private final Pane mainPane;
    private Stage mainStage;
    private final Scene mainScene;


    /**
     * 
     */
    public FXEnvironment() {
        super();
        this.mainPane = new StackPane();
        this.mainScene = new Scene(this.mainPane);
        this.loader = ScreenLoader.getScreenLoader();
    }

    /** (non-Javadoc).
     * @see javafx.application.Application#start(javafx.stage.Stage).
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setOnCloseRequest(e -> System.exit(0));
    }

    /**
     * Get the {@link FXEnvironment} instance.
     *
     * @return the {@link FXEnvironment}
     */
    public static FXEnvironment getInstance() {
        synchronized (FXEnvironment.class) {
            if (environment == null) {
                FXEnvironment.environment = new FXEnvironment();
            }
        }
        return environment;
    }

    /**
     * Show the actual view.
     */
    public void show() {
        this.mainStage.show();
    }

    /**
     * 
     * @return
     *          The main scene of the application.
     */
    public Stage getMainStage() {
        return this.mainStage;
    }

    /**
     * The main {@link Scene} of the application.
     *
     * @return The main application {@link Scene}
     */
    public Scene getMainScene() {
        return this.mainScene;
    }

    /**
     * All the node are charged in a {@link Map}, this method return the {@link Node} stored.
     *
     * @param screen
     *            the {@link FXMLScreens}
     * @return the {@link Node} loaded
     */
    public Node getNode(final FXMLScreens screen) {
        return this.loader.getLoadedNode(screen);
    }

    /**
     * Display the {@link FXMLScreens} into this scene.
     *
     * @param screen
     *            the {@link FXMLScreens} to display
     */
    public void displayScreen(final FXMLScreens screen) {
        try {
            this.loader.loadScreen(screen, this.mainPane);
            this.show();
        } catch (final IOException e) {
            System.out.println("Unable to display screen " + screen);
            e.printStackTrace();
        }
    }

    /**
     * Loads a {@link FXMLScreens} ad sets its controller.
     *
     * @param screen
     *            the {@link FXMLScreens}
     * @param controller
     *            the controller
     */
    public void loadScreen(final FXMLScreens screen, final Object controller) {
        try {
            this.loader.loadFXMLInCache(screen, controller);
        } catch (final IOException e) {
            System.out.println("Unable to load screen " + screen);
            e.printStackTrace();
        }
    }

    
    
}