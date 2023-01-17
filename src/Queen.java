public class Queen extends ChessPiece{

    public Queen(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (((((toLine-line) == (toColumn-column)) || (-(toLine-line) == (toColumn-column))) ||
                (((line == toLine) && !(column == toColumn)) || (!(line == toLine) && (column == toColumn))))&&
                (toLine < 8) && (toLine >= 0) && (toColumn < 8) && (toColumn >= 0)&&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null){
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
            else if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
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



    }

        else return false;
}


    @Override
    public String getSymbol(){
        return "Q";
    }
}
