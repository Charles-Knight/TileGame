/* Tile Class
*  Author: Charles Knight
*  Represents the tile game piece in a word-building board game. Each tile has a
*  letter and a value.
*/

public class Tile {
  private char letter;

  /* Constructor
  *  Parameters: char letter, reprents the tiles alphabetic value.
  *  Return:  a Tile object
  */
  public Tile(char letter) {
    this.letter = letter;
  }

  /* getLetter
  *  Paremeters: none
  *  Return: letter value of tile.
  */
  public char getLetter() {
    return this.letter;
  }

  /* getValue
  *  Paremeters: none
  *  Return: score value of tile.
  */
  public int getValue() {
    switch (letter) {
    case 'a':
      return 1;
    case 'b':
      return 3;
    case 'c':
      return 3;
    case 'd':
      return 2;
    case 'e':
      return 1;
    case 'f':
      return 4;
    case 'g':
      return 2;
    case 'h':
      return 4;
    case 'i':
      return 1;
    case 'j':
      return 8;
    case 'k':
      return 5;
    case 'l':
      return 1;
    case 'm':
      return 3;
    case 'n':
      return 1;
    case 'o':
      return 1;
    case 'p':
      return 3;
    case 'q':
      return 10;
    case 'r':
      return 1;
    case 's':
      return 1;
    case 't':
      return 1;
    case 'u':
      return 1;
    case 'v':
      return 4;
    case 'w':
      return 4;
    case 'x':
      return 8;
    case 'y':
      return 4;
    case 'z':
      return 10;
    default:
      return 0;
    }
  }

  /* toString
  *  Come on, you know what this does...
  *  returns a string representation of the Tile in the
  *  format '$letter: $value'
  *  Parameters: none
  *  Return: string representation of Tile object.
  */
  public String toString() {
    return letter + ": " + this.getValue();
  }

  // Main function for testing Tile class.
  public static void main(String[] args) {
    Tile a = new Tile('A');
    Tile b = new Tile('B');

    System.out.println("Printing tiles using get methods:");
    System.out.println(a.getLetter() + ": " + a.getValue());
    System.out.println(b.getLetter() + ": " + b.getValue() + "\n");

    System.out.println("Printing tiles using toString method");
    System.out.println(a);
    System.out.println(b + "\n");

    System.out.println(a);
    System.out.println(b);

  }

}
