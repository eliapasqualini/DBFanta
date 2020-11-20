package view;

public enum FXMLScreens {

    /**
     * Main View.
     */
    MAIN("/view/Main.fxml"),
    
    CREAZIONE("/view/CreazioneLega.fxml");
    

    private final String resourcePath;
    

    /**
     * @param path
     *            full qualified path of the .fxml
     */
    FXMLScreens(final String path) {
        this.resourcePath = path;
    }

    /**
     * @return full qualified path of the .fxml
     */
    public String getPath() {
        return resourcePath;
    }

 }