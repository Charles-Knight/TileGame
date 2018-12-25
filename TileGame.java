
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
    /* Game setup. Create tile bag, player list and board. */
    TileBag tileBag = new TileBag();
    Player[] playerList = playerSetup(tileBag);
    Board board = new Board();

    /* Start game: Print starting board, start player turns. */
    board.print();
    int currentPlayer = 0;
    System.out.println("Player: " + playerList[currentPlayer].getName());

    /* Player turns */
    while(!gameOver(playerList)) {
      playerTurn(playerList[currentPlayer], board, tileBag);
      if(currentPlayer < playerList.length - 1)
        currentPlayer ++;
      else
        currentPlayer = 0;
    }

    System.out.println("GoodBye.");
  } // End main

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
    int numPlayers = Integer.parseInt(keyboard.nextLine());
    ;
    Player[] playerList = new Player[numPlayers];

    /* Create players and assign names */
    for (int i = 0; i < numPlayers; i++) {
      System.out.print("Player " + i + " name: ");
      String name = keyboard.nextLine();
      playerList[i] = new Player(name);
    }

    /* Initial tile draws */
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < playerList.length; j++) {
        playerList[j].addTile(tileBag.draw());
      }
    }

    //keyboard.close();
    return playerList;
  }

  /* playerTurn
   * Goes through process of turn for given player
   * Player should have option place tiles, swap tiles, or pass turn
   * Players tile rack should be repleneished (if possible) at end
   * of turn.
   */
  public static void playerTurn(Player p, Board b, TileBag tb) {
    Scanner keyboard = new Scanner(System.in);

    //Show current player their tile rack.

    //Ask player what they would like to do: Place Swap or Pass
    System.out.print("1)Play word, 2) Swap, 3) Pass : ");
    int choice = Integer.parseInt(keyboard.nextLine());

    System.out.println(p.getName() + " chose " + choice);

    switch(choice) {
      case 1:
        placeWord(p, b);
        p.resetPassCounter();
        break;
      case 2:
        swapTiles(p, tb);
        p.resetPassCounter();
        break;
      case 3:
        p.passed();
        System.out.println("Player passed turn.");
        break;
    }

    //keyboard.close();

  } //End PlayerTurn

  /* placeWord: Player places tiles on board.
   *
   */
   public static void placeWord(Player p, Board b) {

   }

  /* swapTile: Swaps tile between player and TileBag.
   * Player should draw new set aside tiles to return,
   * draw new tiles, and then return old tiles.
   */
  public static void swapTiles(Player p, TileBag tb) {

  } // End swapTile

  public static boolean gameOver(Player[] pl){

    boolean allTilesPlaced = true;
    boolean allPlayersPassed = true;
    //Check if ALL players have passed 3 times,

    for(int i = 0; i < pl.length; i++){
      if (pl[i].hasTiles())
        allTilesPlaced = false;
      if (!pl[i].passedThrice())
        allPlayersPassed = false;
    }
    return allTilesPlaced || allPlayersPassed;
  }

  /* playerDeets: Lists number of players and their current scores.
   *
   */
  public static void playerDeets(Player[] pl) {
    System.out.println("There are " + pl.length + " players");
    System.out.println("--Current Scores--");
    for (int i = 0; i < pl.length; i++) {
      System.out.println(pl[i].getName() + ": " + pl[i].getCurrentScore());
    }
  }

  /* bagDeets: Prints the number of tiles left in TileBag.
   *
   */
  public static void bagDeets(TileBag t) {
    System.out.println("Number of tiles: " + t.size());
    System.out.println(t + "\n");
  }
} // End Class
