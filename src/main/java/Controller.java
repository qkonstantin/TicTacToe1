public class Controller {
    private String symbol;
    private int scoreX = 0;
    private int scoreO = 0;
    private int i = 1;
    private Model model;
    private View view;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public String handleGameStep(int fieldCoordY, int fieldCoordX){
        game(fieldCoordY, fieldCoordX);
        return symbol;
    }

    public void checkWinner() {
        boolean isSomeoneWin = false;
        boolean isWinnerX = false;
        String winnerStr = "";

        if (checkWinner(FieldState.CROSS.toString())) {
            winnerStr = "Победа X";
            isSomeoneWin = true;
            isWinnerX = true;
        }

        if (checkWinner(FieldState.TOE.toString())) {
            winnerStr = "Победа O";
            isSomeoneWin = true;
            isWinnerX = false;
        }

        if(isSomeoneWin){
            changeScore(isWinnerX);
            view.showWinner(winnerStr);
            view.showScores(String.valueOf(scoreX), String.valueOf(scoreO));
            i = 1;
        }
    }

    public void resetGameBoard() {
        model.resetTable();
        view.setUpGameBoardForNewGame();
    }

    boolean checkWinner(String symbol){
        return (model.getTableField(0,0).equals(symbol) && model.getTableField(0,1).equals(symbol) && model.getTableField(0,2).equals(symbol))
                || (model.getTableField(1,0).equals(symbol) && model.getTableField(1,1).equals(symbol) && model.getTableField(1,2).equals(symbol))
                || (model.getTableField(2,0).equals(symbol) && model.getTableField(2,1).equals(symbol) && model.getTableField(2,2).equals(symbol))
                || (model.getTableField(0,0).equals(symbol) && model.getTableField(1,0).equals(symbol) && model.getTableField(2,0).equals(symbol))
                || (model.getTableField(0,1).equals(symbol) && model.getTableField(1,1).equals(symbol) && model.getTableField(2,1).equals(symbol))
                || (model.getTableField(0,2).equals(symbol) && model.getTableField(1,2).equals(symbol) && model.getTableField(2,2).equals(symbol))
                || (model.getTableField(0,0).equals(symbol) && model.getTableField(1,1).equals(symbol) && model.getTableField(2,2).equals(symbol))
                || (model.getTableField(2,0).equals(symbol) && model.getTableField(1,1).equals(symbol) && model.getTableField(0,2).equals(symbol));
    }

    private void changeScore(boolean isWinnerX) {
        if (isWinnerX) {
            scoreX++;
        } else {
            scoreO++;
        }
        String playerX = String.valueOf(scoreX);
        String playerO = String.valueOf(scoreO);
        view.showScores(playerX, playerO);
    }

    private void game(int fieldCoordY, int fieldCoordX) {
        String currentPlayer;
        if (i % 2 == 0) {
            symbol = FieldState.CROSS.toString();
            currentPlayer = FieldState.TOE.toString();
        } else {
            symbol = FieldState.TOE.toString();
            currentPlayer = FieldState.CROSS.toString();
        }
        model.setValue(fieldCoordY, fieldCoordX, symbol);
        view.showCurrentPlayer(currentPlayer);
        i++;
    }
}
