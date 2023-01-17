public class Pawn extends ChessPiece{

    public Pawn(String color){
        super(color);
    }

    @Override
    public String getColor(){
        return color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if ((((line+1 == toLine) && (column == toColumn) && (color == "White"))||((line-1 == toLine) && (column == toColumn) && (color == "Black"))) && (toLine < 8) && (toLine >= 0) &&
                (toColumn < 8) && (toColumn >= 0)&&
                (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null)
        {
            int[][] positions = new int[toLine][toColumn];
            return true;
        }
        else return false;

    }
    @Override
    public String getSymbol(){
        return "P";
    }
}
