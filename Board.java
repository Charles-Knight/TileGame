/* Board Class
*  Author: Charles Knight
*
*  Represents game for a tile based, word building game. Tiles are added to the
*  game board to spell out words.
*/

public class Board {
  Tile[][] board = new Tile[15][15];

  public Board() {

  }

  /* setTile
  *  places a tile at a location on the game board.
  *  Paremeters: x and y coordiante, tile object to be placed.
  *  returns: true, if successful. False if not (if something is arleady there)
  */
  public boolean setTile(int x, int y, Tile input) {
    board[y][x] = input;
    return true;
  }

  public void print() {
    for (int i = 0; i < 15; i++) {
      System.out.print("|");
      for (int j = 0; j < 15; j++) {
        System.out.print("     |");
      }
      System.out.println();

      System.out.print("|");
      for (int j = 0; j < 15; j++) {
        if (this.board[i][j] == null) {
          System.out.print("     |");
        } else {
          System.out.print("  " + this.board[i][j].getLetter() + "  |");
        }
      }
      System.out.println();

      System.out.print("|");
      for (int j = 0; j < 15; j++) {
        System.out.print("_____|");
      }
      System.out.println();
    }
  }

  public String toString() {
    String out = "";
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++)
        out = out + i + "," + j + ": " + this.board[i][j] + "; ";
      out = out + "\n";
    }
    return (out);
  }

  public static void main(String[] args) {
    Board board = new Board();
    board.print();
  }

}
