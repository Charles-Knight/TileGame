/*
* TileRack class contains a linked list that holds up to 7 tiles.
*/

import java.util.LinkedList;

public class TileRack {
  private int MAX_SIZE = 7;
  private int currentSize;
  private LinkedList<Tile> rack;

  /*
  *  Generic constructor: Sets currentSize to zero and creates new LinkedList
  *  for rack.
  */
  public TileRack(){
    this.currentSize = 0;
    this.rack = new LinkedList<Tile>();
  }

  /*
  *  Return pointer to specified Tile in tile rack
  */
  public Tile getTile(int position){
    //Return object from linked list rack

  }

  /*
  *  Add Tile to the rack and increment currentSize.
  */
  public boolean addTile(Tile t){
    if(this.currentSize < MAX_SIZE){
      rack.add(t);
      currentSize++;
      return true;
    } else {
      return false;
    }
  }

  /*
  *  Return pointer to Tile in tile rack and remove fromr rack.
  */
  public Tile removeTile(int position){
    Tile toReturn;

    // Set toReturn to tile to return.

    //Remove tile from rack

    //decrement currentSize

    //return toReturn

  }

  /*
  *  Return the current size of the tile rack.
  */
  public int getSize(){ return this.currentSize;}

  /*
  *  return string representation of tile rack.
  */
  public String toString(){ return rack.toString();}

}  // End Tile class
