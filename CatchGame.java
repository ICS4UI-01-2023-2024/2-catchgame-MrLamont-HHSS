
/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    private Board gameBoard;


    /**
     * The constructor for the game.
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        this.gameBoard = new Board(12,12);
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        this.gameBoard.displayMessage("Click the board!");
        this.gameBoard.putPeg(Board.GREEN, 2, 5);
        while(true){
            Coordinate click = this.gameBoard.getClick();
            this.gameBoard.putPeg(Board.RED, click.getRow(), click.getCol());
            this.gameBoard.removePeg(2, 5);
        }
    
    }

}
