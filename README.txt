
What does the marker need to know about your program?

compile:
To run the program use "make run" command
To remove all class file use "make clean" command

Views:
This MVC have four Views and use GridLayout with 2 row 2 colums.
First view : to input the guess word. (press ENTER to send words)
Second view: to set the target word as required.
Third view: a Jtable to record all inputs.
Fourth view: a Jtable to show the exact and hints

Notes:
First View:
The only thing that the First View will accept is a five-length string.
All other length will be reject and print a error message in terminal.
Also Show lives, lives -1 indicate that the game is over(either win or lose)

Second View:
It can be set only once. After set once, it become unEditable.

Third View:
Output your guesses, number of exact char, number of partial char
Win and lose will output a message.

Forth View:
This is the hint view, First col is the user's guessed word. second col is the exact
characters. Third col is all the exact and partial characters in the correct order.
For example, If target word is ABCDE, user guess is DAOLP , then we have two 
partial character 'D' and 'A'. Third col will give D and A in the correct with is
'A D'. Note: thus, if user get all partial charater 'A''B''C''D''E' no matter in anyorder 
user guess. The hint will return 'ABCDE' which is the correct answer. Thus this table 
will not show partial characters (otherwise game will be too easy).