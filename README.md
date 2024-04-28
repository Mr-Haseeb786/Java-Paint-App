## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

    @FXML
    public void startDrawing(ActionEvent e) {
    try {
      root = FXMLLoader.load(getClass().getResource("Drawing.fxml"));
      stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setTitle("Drawing Board");
      stage.setScene(scene);
      stage.show();

    } catch (IOException e1) {
      e1.printStackTrace();
    }

}
