import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class View {
    private final String title = "Крестики-нолики";
    private final String resSource = "fxml/sample.fxml";
    private final String imageSource = "TicTacToe.png";
    private final int width = 600;
    private final int height = 400;
    private Stage stage;
    public Button field00, field01, field02, field10, field11, field12, field20, field21, field22, playAgain;
    public Label labelWinner, scoreX, scoreO, who;

    Controller controller = new Controller(this, new Model());

    public View(){ }

    public View(Stage stage){
        this.stage = stage;
    }

    public void create() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(resSource));
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.resizableProperty().setValue(false);
        stage.getIcons().add(new Image(Main.class.getResourceAsStream(imageSource)));
        stage.show();
    }

    @FXML
    void onField00Click() {
        String symbol = controller.handleGameStep(0, 0);
        field00.setText(symbol);
        field00.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField01Click() {
        String symbol = controller.handleGameStep(0, 1);
        field01.setText(symbol);
        field01.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField02Click() {
        String symbol = controller.handleGameStep(0, 2);
        field02.setText(symbol);
        field02.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField10Click() {
        String symbol = controller.handleGameStep(1, 0);
        field10.setText(symbol);
        field10.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField11Click() {
        String symbol = controller.handleGameStep(1, 1);
        field11.setText(symbol);
        field11.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField12Click() {
        String symbol = controller.handleGameStep(1, 2);
        field12.setText(symbol);
        field12.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField20Click() {
        String symbol = controller.handleGameStep(2, 0);
        field20.setText(symbol);
        field20.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField21Click() {
        String symbol = controller.handleGameStep(2, 1);
        field21.setText(symbol);
        field21.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    void onField22Click() {
        String symbol = controller.handleGameStep(2, 2);
        field22.setText(symbol);
        field22.setDisable(true);
        controller.checkWinner();
    }

    @FXML
    public void onPlayAgainClick() {
        controller.resetGameBoard();
    }

    public void showWinner(String winner){
        labelWinner.setText(winner);
        disableButtons();
    }

    public void showCurrentPlayer(String currentPlayer) {
        who.setText(currentPlayer);
    }

    public void showScores(String playerScoreX, String playerScoreO) {
        scoreX.setText(playerScoreX);
        scoreO.setText(playerScoreO);
    }

    public void setUpGameBoardForNewGame(){
        resetFields();
        enableButtons();
        labelWinner.setText(FieldState.EMPTY.toString());
    }

    private void resetFields() {
        field00.setText(FieldState.EMPTY.toString());
        field01.setText(FieldState.EMPTY.toString());
        field02.setText(FieldState.EMPTY.toString());
        field10.setText(FieldState.EMPTY.toString());
        field11.setText(FieldState.EMPTY.toString());
        field12.setText(FieldState.EMPTY.toString());
        field20.setText(FieldState.EMPTY.toString());
        field21.setText(FieldState.EMPTY.toString());
        field22.setText(FieldState.EMPTY.toString());
    }

    private void disableButtons() {
        field00.setDisable(true);
        field01.setDisable(true);
        field02.setDisable(true);
        field10.setDisable(true);
        field11.setDisable(true);
        field12.setDisable(true);
        field20.setDisable(true);
        field21.setDisable(true);
        field22.setDisable(true);
    }

    private void enableButtons() {
        field00.setDisable(false);
        field01.setDisable(false);
        field02.setDisable(false);
        field10.setDisable(false);
        field11.setDisable(false);
        field12.setDisable(false);
        field20.setDisable(false);
        field21.setDisable(false);
        field22.setDisable(false);
    }
}
