public class Bishop extends ChessPiece{

    public Bishop(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if ((((toLine-line) == (toColumn-column)) || (-(toLine-line) == (toColumn-column)))&& (toLine < 8) && (toLine >= 0) && (toColumn < 8) && (toColumn >= 0)&&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null)
        {
            if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
                    (toColumn == Math.min(column, toColumn) && toLine == Math.max(line, toLine))) {
                int max_line = Math.max(line, toLine);
                int min_column = Math.min(column, toColumn);
                int min_line = Math.min(line, toLine);
                int max_column = Math.max(column, toColumn);
                int[][] positions = new int[max_column - min_column][1];
                for (int i = 1; i < max_column - min_column; i++) {
                    if (chessBoard.board[max_line - i][min_column + i] == null) {
                        positions[i - 1] = new int[]{max_line - i, min_column + i};
                    } else if (!chessBoard.board[max_line - i][min_column + i].color.equals(this.color) && max_line - i == toLine) {
                        positions[i - 1] = new int[]{max_line - i, min_column + i};
                    } else {
                        return false;
                    }
                }
                return true;
            } else {

                int min_line = Math.min(line, toLine);
                int min_column = Math.min(column, toColumn);
                int max_line = Math.max(line, toLine);
                int max_column = Math.max(column, toColumn);
                int[][] positions = new int[max_column - min_column][1];
                for (int i = 1; i < max_column - min_column; i++) {
                    if (chessBoard.board[min_line + i][min_column + i] == null) {
                        positions[i - 1] = new int[]{min_line + i, min_column + i};
                    } else if (!chessBoard.board[min_line + i][min_column + i].color.equals(this.color) && min_line + i == toLine) {
                        positions[i - 1] = new int[]{min_line + i, min_column + i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
        } else return false;
    }

    @Override
    public String getSymbol(){
        return "B";
    }
}
