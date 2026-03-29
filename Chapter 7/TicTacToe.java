import java.util.*;
/**
 * Write a description of class TicTacToe here.
 *
 * @author (Amani Bradsher)
 * @version (4/24/23)
 */
public class TicTacToe
{
    //Use a 3 X 3 (two-dimensional) arry for the game board.
    
    private static char [][] board = new char[3][3];
    private static char turn;
    private static int row;                //Loop controls to
    private static int col;                //display the board
    private static int turnRow;            //User input to
    private static int turnCol;            //select move
    private static boolean entryError;
    private static boolean anotherGame = true;
    private static char repeat;            //Usrer input: y or Y to repeat
    private static int entryCount = 0;     //Game ends when board is full
                                           //(when entryCount = 9)
                                           
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
         while(anotherGame)
         {
             newGame();
             
             while(!winner())
             {
                 writeBoard();
                 getMove();
             }
         
         System.out.println(" Another game? Enter Y or y for yes.");
         repeat = keyboard.next().charAt(0);
         if(repeat == 'y' || repeat == 'Y')
            anotherGame = true;
         else 
            anotherGame = false;
        }
    }
    
    public static void writeBoard()
    {
        System.out.println("------------");
        System.out.println("|R\\C| 1 | 2 | 3 |");
        System.out.println("------------");
        for(row = 0; row < 3; ++row)
        {
            System.out.println("| "+ (row + 1)
                           + " | " + board[row][0]
                           + " | " + board[row][1]
                           + " | " + board[row][2]
                            + " | ");
            System.out.println("------------");                
        }
    }
    
    public static void getMove()
    {
        entryError = true;
        
        Scanner keyboard = new Scanner(System.in);
        
        while(entryError)
        { 
            System.out.println();
            System.out.println(turn + "'s turn.");
            System.out.println("Where do what your " + turn + "placed?");
            System.out.println("Please eneter row number and colum number" + " separted by a space.");
            System.out.println();
            
            turnRow = keyboard.nextInt();
            turnCol = keyboard.nextInt();
            System.out.println(" You have eneterd row#" + turnRow);
            System.out.println("           and column#" +turnCol);
            
            //check for proper range(1,2, or 3)
            
            if (turnRow < 1 || turnRow > 3 || turnCol < 1 || turnCol > 3)
            {
                System.out.println("Invaild entry: try again");
                System.out.println("Row & column numbers must be either 1, 2, or 3.");
            }
            // Check to see if it is already occupied
            //adjust turnRow and turnCol fir 0-numbering in array
            
            else if (board[turnRow - 1][turnCol - 1] == 'X'
                         || board[turnRow - 1][turnCol - 1] == '0')
                         
            {
                System.out.println("That cell is already taken.");
                System.out.println(" Please make another selection.");
            }
            
            else //vaild entry
            {
            entryError = false;
            System.out.println("Thank you for your selection.");
            board[turnRow - 1][turnCol - 1] = turn;
            ++entryCount;
             }
        }
    }
    
    public static boolean winner()
    {
        //row checks
        
        for (row = 0; row<3; ++row)
        {
            if(board[row][0] ==turn)
            { 
                if(board[row][1] ==turn)
                {
                    if(board[row][2] ==turn)
                    {
                      System.out.println();
                      System.out.println(turn + " IS THE WINNER!!!");
                      writeBoard();
                      return true;
                    }
               }
            }
    }
    
    //column cheacks
    for(col =0; col< 3; ++col)
       if(board[col][0] ==turn)
        {
           if(board[col][1] ==turn)
           {
               if(board[col][2] ==turn)
               {
                   System.out.println();
                      System.out.println(turn + " IS THE WINNER!!!");
                      writeBoard();
                      return true;
               }
           }
        }
        
    //digonal cheacks
    if(board[0][0] ==turn)
        {
           if(board[1][1] ==turn)
           {
               if(board[2][2] ==turn)
               {
                   System.out.println();
                      System.out.println(turn + " IS THE WINNER!!!");
                      writeBoard();
                      return true;
               }
           }
        }
        
    if(board[0][2] ==turn)
        {
           if(board[1][1] ==turn)
           {
               if(board[2][0] ==turn)
               {
                   System.out.println();
                      System.out.println(turn + " IS THE WINNER!!!");
                      writeBoard();
                      return true;
               }
           }
        }
        
        //these lines excute only ifthere is no winner.
        //end game if board is full
        
    if(entryCount >= 9)
    {
       System.out.println();
        System.out.println("Draw: no winner and board is full.");
        writeBoard();
        return true; 
    }
    
    else //Next player's turn
    {
        if(turn =='X')
           turn = '0';
        else turn = 'X';
        return false;
    }
   }


          
    public static void newGame()
    {
        System.out.println();
        System.out.println("New Game: X goes first.");
        turn = 'O'; //turn will chnage to X when winner90 I CALLED
        
        //cLEAR THE BOARD 
        
        for(row = 0; row<3; ++row)
        {
             for(col = 0; col<3; ++col)
             board[row][col]= ' ' ;
        }
        entryCount = 0;
        System.out.println();
    }
}
    

