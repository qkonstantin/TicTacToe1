import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Label labelWinner, scoreX, scoreO, who;
    private String symbol;
    private int plX = 0;
    private int plO = 0;
    public Button field00, field01, field02, field10, field11, field12, field20, field21, field22, playAgain;
    private int i = 1;
    private static String[][] table = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

    @FXML
    void onField00Click() {
        game();
        field00.setText(symbol);
        table[0][0] = symbol;
        field00.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField01Click() {
        game();
        field01.setText(symbol);
        table[0][1] = symbol;
        field01.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField02Click() {
        game();
        field02.setText(symbol);
        table[0][2] = symbol;
        field02.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField10Click() {
        game();
        field10.setText(symbol);
        table[1][0] = symbol;
        field10.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField11Click() {
        game();
        field11.setText(symbol);
        table[1][1] = symbol;
        field11.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField12Click() {
        game();
        field12.setText(symbol);
        table[1][2] = symbol;
        field12.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField20Click() {
        game();
        field20.setText(symbol);
        table[2][0] = symbol;
        field20.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField21Click() {
        game();
        field21.setText(symbol);
        table[2][1] = symbol;
        field21.setDisable(true);
        checkWinner();
    }

    @FXML
    void onField22Click() {
        game();
        field22.setText(symbol);
        table[2][2] = symbol;
        field22.setDisable(true);
        checkWinner();
    }

    public void game() {
        if (i % 2 == 0) {
            symbol = "X";
            who.setText("O");
        } else {
            symbol = "O";
            who.setText("X");
        }
        i++;
    }

    public void checkWinner() {
        if ((table[0][0].equals("X") && table[0][1].equals("X") && table[0][2].equals("X"))
                || (table[1][0].equals("X") && table[1][1].equals("X") && table[1][2].equals("X"))
                || (table[2][0].equals("X") && table[2][1].equals("X") && table[2][2].equals("X"))
                || (table[0][0].equals("X") && table[1][0].equals("X") && table[2][0].equals("X"))
                || (table[0][1].equals("X") && table[1][1].equals("X") && table[2][1].equals("X"))
                || (table[0][2].equals("X") && table[1][2].equals("X") && table[2][2].equals("X"))
                || (table[0][0].equals("X") && table[1][1].equals("X") && table[2][2].equals("X"))
                || (table[2][0].equals("X") && table[1][1].equals("X") && table[0][2].equals("X"))) {
            labelWinner.setText("Победа X");
            disableAll();
            winX();
        }
        if ((table[0][0].equals("O") && table[0][1].equals("O") && table[0][2].equals("O"))
                || (table[1][0].equals("O") && table[1][1].equals("O") && table[1][2].equals("O"))
                || (table[2][0].equals("O") && table[2][1].equals("O") && table[2][2].equals("O"))
                || (table[0][0].equals("O") && table[1][0].equals("O") && table[2][0].equals("O"))
                || (table[0][1].equals("O") && table[1][1].equals("O") && table[2][1].equals("O"))
                || (table[0][2].equals("O") && table[1][2].equals("O") && table[2][2].equals("O"))
                || (table[0][0].equals("O") && table[1][1].equals("O") && table[2][2].equals("O"))
                || (table[2][0].equals("O") && table[1][1].equals("O") && table[0][2].equals("O"))) {
            labelWinner.setText("Победа O");
            disableAll();
            winO();
        }
    }

    public void disableAll() {
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

    public void winX() {
        plX++;
        String playerX = String.valueOf(plX);
        scoreX.setText(playerX);
    }

    public void winO() {
        plO++;
        String playerO = String.valueOf(plO);
        scoreO.setText(playerO);
    }

    @FXML
    public void onPlayAgainClick() {
        table[0][0] = " ";
        field00.setText(" ");
        field00.setDisable(false);
        table[0][1] = " ";
        field01.setText(" ");
        field01.setDisable(false);
        table[0][2] = " ";
        field02.setText(" ");
        field02.setDisable(false);
        table[1][0] = " ";
        field10.setText(" ");
        field10.setDisable(false);
        table[1][1] = " ";
        field11.setText(" ");
        field11.setDisable(false);
        table[1][2] = " ";
        field12.setText(" ");
        field12.setDisable(false);
        table[2][0] = " ";
        field20.setText(" ");
        field20.setDisable(false);
        table[2][1] = " ";
        field21.setText(" ");
        field21.setDisable(false);
        table[2][2] = " ";
        field22.setText(" ");
        field22.setDisable(false);
        labelWinner.setText(" ");
    }
}
