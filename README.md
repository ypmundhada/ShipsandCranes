# ShipsandCranes
Test cases and Flow of code
Lets now analyze our code for the following test case :-
First the interface will ask for the specifications of the ship.
stackLimit :- 4
weightLimit :- 15
swayTolerance :- 10
riskTolerance :- 10
maxPower :- 10
maxHeight :- 4
After getting this data, an object of the ship class will be initialized in the main method of the driver class.
Now we move to the specifications of the container. For storing containers, a list of the parent class container is created and the references of its child classes will be added to it using upcasting.
Container’s input is as follows:-
1 1 1
2 2 1 2
3 3 1 1
4 5 1
5 2 1 3
6 6 2
7 6 1
8 4 2 4
9 6 2
10 7 1 5
After storing containers in the list, we pass this list and the ship object that we created to the stack method of the crane class.
In the crane class we first check whether it is possible to stack the containers on the ship.
For this we call the isPossible method. All the checks have been mentioned in the isPossible() subheading in class description of crane class. For the current test case isPossible() will return true.
In the process of checking we also bifurcated the container list into 3 lists.
1) Heavy container list :- 6,7,9.
2) Weak container list :- 4.
3) Rest of containers list :- 1,2,3,5,8,10.
PS:- I have mentioned the containerId for representing the container.
Now we start building our stack greedily column by column.
First we instantiate the list of stack present in the ship class which will be our final answer.
The algorithm is as follows:-
while(at least one of the 3 list is non-empty){
Instantiate a new container list lc.
- if(heavy container list is non-empty) add heavy container to lc.
- while(rest of container list is non-empty and current stack height is one less than max stack height) add rest of container to lc.
- if(weak container list is non-empty) add weak container to lc.
- if(weak container was not added) can add one more from the rest of container list.
we add lc to the list of stack(finalAns).
}
Now we just print the answer and return to the driver the class where the program terminates.
OUTPUT:-
6 1 2 4
7 3 5 8
9 10 -1 -1
-1 -1 -1 -1
