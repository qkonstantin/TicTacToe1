public class Model {
    private final int tableWidth = 3;
    private final int tableHeight = 3;
    private final String[][] table = {
            {FieldState.EMPTY.toString(), FieldState.EMPTY.toString(), FieldState.EMPTY.toString()},
            {FieldState.EMPTY.toString(), FieldState.EMPTY.toString(), FieldState.EMPTY.toString()},
            {FieldState.EMPTY.toString(), FieldState.EMPTY.toString(), FieldState.EMPTY.toString()}
    };

    public String getTableField(int i, int j) {
        return table[i][j];
    }

    public void setValue(int i, int j, String value){
        table[i][j] = value;
    }

    public void resetTable(){
        for (int i = 0; i < tableHeight; i++) {
            for (int j = 0; j < tableWidth; j++) {
                table[i][j] = FieldState.EMPTY.toString();
            }
        }
    }
}
