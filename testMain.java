public class testMain{

  public static void main(String[] args) {
      //Create board
      Board b = new Board();
      //print board
      b.print();
      System.out.println(b);

      //create Tiles
      Tile p = new Tile('p');
      Tile h = new Tile('h');
      Tile y = new Tile('y');
      Tile s = new Tile('s');
      Tile i = new Tile('i');
      Tile c = new Tile('c');
      Tile s2 = new Tile('s');
      //add tiles to Board
      System.out.println("adding letters...");
      b.setTile(0,0,p);
      b.setTile(0,1,h);
      b.setTile(0,2,y);
      b.setTile(0,3,s);
      b.setTile(0,4,i);
      b.setTile(0,5,c);
      b.setTile(0,6,s2);
      b.print();

      System.out.println(b);
      //print board
  }

}
