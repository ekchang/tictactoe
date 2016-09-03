# tictactoe

Basic Tic Tac Toe implementation as teaching example.

Default game supports 2 players on a 3x3 grid, but custom game settings let you specify `n` players on an `h`x`w` grid and even specify `# in a row` win condition:

```
      ___                   ___                 ___         ___         ___                 ___         ___         ___     
     /\  \        ___      /\  \               /\  \       /\  \       /\  \               /\  \       /\  \       /\  \    
     \:\  \      /\  \    /::\  \              \:\  \     /::\  \     /::\  \              \:\  \     /::\  \     /::\  \   
      \:\  \     \:\  \  /:/\:\  \              \:\  \   /:/\:\  \   /:/\:\  \              \:\  \   /:/\:\  \   /:/\:\  \  
      /::\  \    /::\__\/:/  \:\  \             /::\  \ /::\~\:\  \ /:/  \:\  \             /::\  \ /:/  \:\  \ /::\~\:\  \ 
     /:/\:\__\__/:/\/__/:/__/ \:\__\           /:/\:\__/:/\:\ \:\__/:/__/ \:\__\           /:/\:\__/:/__/ \:\__/:/\:\ \:\__\
    /:/  \/__/\/:/  /  \:\  \  \/__/          /:/  \/__\/__\:\/:/  \:\  \  \/__/          /:/  \/__\:\  \ /:/  \:\~\:\ \/__/
   /:/  /    \::/__/    \:\  \               /:/  /         \::/  / \:\  \               /:/  /     \:\  /:/  / \:\ \:\__\  
   \/__/      \:\__\     \:\  \              \/__/          /:/  /   \:\  \              \/__/       \:\/:/  /   \:\ \/__/  
               \/__/      \:\__\                           /:/  /     \:\__\                          \::/  /     \:\__\    
                           \/__/                           \/__/       \/__/                           \/__/       \/__/    


Custom game settings or classic tic-tac-toe? (Enter 'custom' or anything for default)
> custom
Enter number of players: 3
Enter board size.
Width: 5
Height: 5
Enter # in a row to win: 3
Starting game...

Players: 3
Board: 5 x 5

Enter Player 1's name: 
> Erick
Enter their piece letter (eg. x, o, or other): 
> x
Erick was successfully registered.
##################################


Enter Player 2's name: 
> Donald
Enter their piece letter (eg. x, o, or other): 
> o
Donald was successfully registered.
##################################


Enter Player 3's name: 
> Alfred
Enter their piece letter (eg. x, o, or other): 
> w
Alfred was successfully registered.
##################################


Start game!

.
.
.

Turn 1
##################################

  0   1   2   3   4  
0   |   |   |   |  
 -------------------
1   |   |   |   |  
 -------------------
2   |   |   |   |  
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Erick's turn.
Row: 0
Column: 0

Turn 2
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   |   |   |   |  
 -------------------
2   |   |   |   |  
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Donald's turn.
Row: 1
Column: 1

Turn 3
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o |   |   |  
 -------------------
2   |   |   |   |  
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Alfred's turn.
Row: 2
Column: 2

Turn 4
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o |   |   |  
 -------------------
2   |   | w |   |  
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Erick's turn.
Row: 1
Column: 2

Turn 5
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o | x |   |  
 -------------------
2   |   | w |   |  
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Donald's turn.
Row: 1
Column: 3

Turn 6
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o | x | o |  
 -------------------
2   |   | w |   |  
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Alfred's turn.
Row: 2
Column: 4

Turn 7
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o | x | o |  
 -------------------
2   |   | w |   | w
 -------------------
3   |   |   |   |  
 -------------------
4   |   |   |   |  

Erick's turn.
Row: 3
Column: 1

Turn 8
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o | x | o |  
 -------------------
2   |   | w |   | w
 -------------------
3   | x |   |   |  
 -------------------
4   |   |   |   |  

Donald's turn.
Row: 2
Column: 1

Turn 9
##################################

  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o | x | o |  
 -------------------
2   | o | w |   | w
 -------------------
3   | x |   |   |  
 -------------------
4   |   |   |   |  

Alfred's turn.
Row: 2
Column: 3

Alfred wins!
  0   1   2   3   4  
0 x |   |   |   |  
 -------------------
1   | o | x | o |  
 -------------------
2   | o | w | w | w
 -------------------
3   | x |   |   |  
 -------------------
4   |   |   |   |  

.
.
.

Game over! Play again? (y/n)
> n
Goodbye. Thanks for playing.
```

## Exercise to reader
- How might this be adapted for Connect Four mode?
- Specify a list of special unicode icons as the player piece instead of letter?
- Register an AI player who automatically takes a turn (Minimax?)
