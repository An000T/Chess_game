public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((((line == toLine) && !(column == toColumn)) || (!(line == toLine) && (column == toColumn))) &&
                (toLine < 8) && (toLine >= 0) && (toColumn < 8) && (toColumn >= 0) &&
                (chessBoard.board[toLine][toColumn] == null ||
                        !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null) {
            if ((line == toLine) && !(column == toColumn)) {
                int max_column = Math.max(column, toColumn);
                int min_column = Math.min(column, toColumn);
                for (int i = min_column + 1; i < max_column; i++) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == max_column) return false;
                        else if (chessBoard.board[line][i].getColor().equals(this.color) && i == toLine)
                            return false;
                        else if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toLine)
                            return true;
                        else if (i != toColumn && i != column) return false;

                    }
                }
                if (chessBoard.board[line][toColumn] != null) {
                    if (chessBoard.board[line][toColumn].getColor().equals(this.color) && chessBoard.board[line][toColumn] != this)
                        return false;
                    else
                        return !chessBoard.board[line][toColumn].getColor().equals(this.color) && chessBoard.board[line][toColumn] != this;
                } else return true;
            } else if (!(line == toLine) && (column == toColumn)) {
                int max_line = Math.max(line, toLine);
                int min_line = Math.min(line, toLine);
                for (int i = min_line + 1; i < max_line; i++) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == max_line) return false;
                        else if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return false;
                        else if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return true;
                        else if (i != toLine && i != line) return false;

                    }
                }
                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this)
                        return false;
                    else
                        return !chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this;
                } else return true;

            }

            else return false;

        }

        else return false;
    }


    @Override
    public String getSymbol(){
        return "R";
    }
}
