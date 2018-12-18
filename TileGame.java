
/* Charles Knight
*
*  Main class for a tile based word game. Players will make words by laying
*  tiles on a board. Each Players has a limited "hand" and as tiles are used,
*  new ones are drawn from a tile bag. Each tile has a letter, and a value.
*  Points are assigned to players as they make words based on the value of the
*  letters in each word. The game ends when the players have used up all the
*  tiles or no further words can be made.
*/
import java.util.Scanner;

public class TileGame {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    TileBag tileBag = new TileBag();
    Player[] playerList = playerSetup(tileBag);
    Board board = new Board();

    board.print();
    int currentPlayer = 0;
    System.out.println("Player: " + playerList[currentPlayer].getName());

    keyboard.close();
    System.out.println("GoodBye.");

  }

  /* playerSetup
  *  creates playerList of size entered by user and then populates
  *  list with players. User is asked to enter a name for each player.
  *
  *  Returns: Array of Players.
  */
  public static Player[] playerSetup(TileBag tileBag) {
    Scanner keyboard = new Scanner(System.in);

    /* Get number of players and create player list */
    System.out.print("Enter number of players: ");
    int numPlayers = keyboard.nextInt();
    ;
    Player[] playerList = new Player[numPlayers];

    /* Create players and assign names */
    for (int i = 0; i < numPlayers; i++) {
      System.out.print("Player " + i + " name: ");
      String name = keyboard.next();
      playerList[i] = new Player(name);
    }

    /* Initial tile draws */
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < playerList.length; j++) {
        playerList[j].addTile(tileBag.draw());
      }
    }

    keyboard.close();
    return playerList;
  }

  public static void playerTurn(Player p) {

  } //End PlayerTurn

  /*
  *  Swaps tiles from player rack with tiles from tile bag.
  */
  public static void swapTiles() {

  } // End swapTile

  public static void playerDeets(Player[] pl) {
    System.out.println("There are " + pl.length + " players");
    System.out.println("--Current Scores--");
    for (int i = 0; i < pl.length; i++) {
      System.out.println(pl[i].getName() + ": " + pl[i].getCurrentScore());
    }
  }

  public static void bagDeets(TileBag t) {
    System.out.println("Number of tiles: " + t.size());
    System.out.println(t + "\n");
  }
} // End Class
