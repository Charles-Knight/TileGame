
/* TileBag Class
*  Author: Charles Knight
*
*  Represents bag from wich game tiles are drawn by players. All games tiles
*  start in the TileBag and are drawn by players to replenish tiles used during
*  gameplay.
*/

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

public class TileBag {
  private LinkedList<Tile> bag;

  /* Constructor method
  *  creates TileBag, fills with standard set of tiles, and shuffles the bag.
  */
  TileBag() {
    this.bag = new LinkedList<Tile>();
    addTiles('a', 9);
    addTiles('b', 2);
    addTiles('c', 2);
    addTiles('d', 4);
    addTiles('e', 12);
    addTiles('f', 2);
    addTiles('g', 3);
    addTiles('h', 2);
    addTiles('i', 9);
    addTiles('j', 1);
    addTiles('k', 1);
    addTiles('l', 4);
    addTiles('m', 2);
    addTiles('n', 6);
    addTiles('o', 8);
    addTiles('p', 2);
    addTiles('q', 1);
    addTiles('r', 6);
    addTiles('s', 4);
    addTiles('t', 6);
    addTiles('u', 4);
    addTiles('v', 2);
    addTiles('w', 2);
    addTiles('x', 1);
    addTiles('y', 2);
    addTiles('z', 1);
    this.shuffle();
  }

  /* addTiles
  *  Creates specified number of tiles, of the specified character and adds
  *  them to the TileBag. Primarily intended for use when initially filling a
  *  newly created TileBag.
  */
  public void addTiles(char letter, int number) {
    for (int i = 0; i < number; i++) {
      this.bag.add(new Tile(letter));
    }
  }

  /* draw
  *  removes a tile from the tileBag
  */
  public Tile draw() {
    return (this.bag.remove());
  }

  /* swap
  *  Removes and returns a set of tiles equal in size to set of passed in tiles.
  *  Afterwards the bag is reshuffled.
  */
  public Tile[] swap(Tile[] t) {
    Tile[] toReturn = new Tile[t.length];
    /* draw new tiles */
    for (int i = 0; i < toReturn.length; i++) {
      toReturn[i] = this.draw();
    }

    /* Add swapped tiles to bag */
    for (int i = 0; i < t.length; i++) {
      this.bag.add(t[i]);
    }

    this.shuffle();
    return toReturn;
  }

  /* size
  *  Returns the current size of the TileBag.
  */
  public int size() {
    return this.bag.size();
  }

  /* shuffle
  *  Shuffles the contents of the tile bag.
  */
  private void shuffle() {
    Random generator = new Random();
    LinkedList<Tile> newBag = new LinkedList<Tile>();

    while (bag.size() > 0) {
      int index = generator.nextInt(bag.size());
      newBag.add(bag.remove(index));
    }

    this.bag = newBag;
  }

  /* toString
  *  Returns a string representation of the contents of the tileBag
  */
  public String toString() {
    String out = "";
    Iterator<Tile> tiles = this.bag.iterator();

    while (tiles.hasNext()) {
      out = out + tiles.next().getLetter() + ", ";
    }
    return out;
  }

  /*
  *  Main method for testing purposes.
  */
  public static void main(String[] args) {
    TileBag bag = new TileBag();
    System.out.println("Bag Size: " + bag.size());
    System.out.println("--Contents--");
    System.out.println(bag);
    System.out.println("\n");

    bag.shuffle();
    System.out.println("Bag Size: " + bag.size());
    System.out.println("--Contents--");
    System.out.println(bag);
  }

}
