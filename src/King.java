public class King extends ChessPiece{

    public King(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (((line+1 == toLine)||(line-1 == toLine)||(line == toLine)) &&
                ((column+1 == toColumn)||(column-1 == toColumn)||(column == toColumn)) &&
                (!((column == toColumn)&&(line == toLine))) &&
                (toLine < 8) && (toLine >= 0) && (toColumn < 8) && (toColumn >= 0)&&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null &&
                !(isUnderAttack(chessBoard, toLine, toColumn))
        )

        {
            int[][] positions = new int[toLine][toColumn];
            return true;
        }

        else return false;
    }

    @Override
    public String getSymbol(){
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
