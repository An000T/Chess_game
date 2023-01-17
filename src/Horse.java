
public class Horse extends ChessPiece{

    public Horse(String color){
        super(color);
    }
    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (((line+1 == toLine) && (column+2 == toColumn)||(line-1 == toLine) && (column+2 == toColumn)||(line-2 == toLine) &&
                (column+1 == toColumn)||(line-2 == toLine) && (column-1 == toColumn)||(line-1 == toLine) &&
                (column-2 == toColumn)||(line+1 == toLine) && (column-2 == toColumn)||(line+2 == toLine) &&
                (column-1 == toColumn)||(line+2 == toLine) && (column+1 == toColumn)) &&
                (toLine < 8) && (toLine >= 0) &&
                (toColumn < 8) && (toColumn >= 0) &&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color)) && chessBoard.board[line][column] != null)
        {
            int[][] positions = new int[toLine][toColumn];
            return true;
        }

        else return false;
    }

    @Override
    public String getSymbol(){
        return "H";
    }

}
