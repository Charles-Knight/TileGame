
/* Player Class
*  Author: Charles Knight
*
*  Player class for a tile based word building game.
*  Each player has a name, a score, and a tile list.
*  Players can place tiles, pass their turn, draw new tiles, or swap tiles.
*/

import java.util.LinkedList;
import java.util.Iterator;

public class Player {
  private static int MAX_SIZE = 7; // Max size of tiles list.
  private String name;
  private int passCounter;
  private int score;
  private LinkedList<Tile> tiles;

  /*
  *  Constructor: Sets player name to name argument, sets score to zero, and
  *  initializes tiles list.
  */
  public Player(String name) {
    this.name = name;
    this.score = 0;
    this.passCounter = 0;
    this.tiles = new LinkedList<Tile>();
  }

  public void addPoints(int points) { this.score = this.score + points; }
  public String getName() { return this.name; }
  public int getCurrentScore() { return this.score; }
  public int getPassCounter() { return this.passCounter; }
  public void passed() { this.passCounter++; }
  public void resetPassCounter() { this.passCounter = 0; }

  /*
  * Adds tile to players tile list. Returns boolean to indicate success/failure
  */
  public boolean addTile(Tile t) {
    if (this.tiles.size() < MAX_SIZE)
      return this.tiles.add(t);
    else
      return false;
  }

  /*
  *  Removes and returns tile from players tile list.
  */
  public Tile removeTile(int pos) {
    Tile toReturn = null;
    Iterator<Tile> tileIterator = this.tiles.iterator();
    int i = 0;
    while (i < pos && tileIterator.hasNext())
      toReturn = tileIterator.next();

    tileIterator.remove();
    return toReturn;
  }

  /*
  *  Returns pointer to tile in tile list at specified location
  */
  public Tile getTile(int pos) {
    Tile toReturn = null;
    Iterator<Tile> tileIterator = this.tiles.iterator();
    int i = 0;
    while (i < pos && tileIterator.hasNext())
      toReturn = tileIterator.next();

    return toReturn;
  }

  /*
  *  Returns Iterator for players tiles list.
  */
  public Iterator<Tile> iterator() {
    return this.tiles.iterator();
  }

} //End Player class
