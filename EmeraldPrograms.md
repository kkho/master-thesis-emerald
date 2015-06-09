# Introduction #

Emerald is a simple distributed object oriented programming language which is specialized for mobility.

In Java, C/C++ we have CORBA, which takes alot of functions, method calls to build such a framework. Why not just write on your program "I want to move an object to a specific machine?"



# Details #

An example of a runnable Emerald program is below:

```
%distribute this node:
const RunningMan <- object RunningMan
end RunningMan


const Main <- object Main
  process
    const home <- locate self
    var there :     Node
    var startTime, diff : Time
    var all : NodeList

    all <- home.getActiveNodes
    startTime <- home.getTimeOfDay
    
    for i : Integer <- 1 while i <= all.upperbound by i <- i + 1
    	there <- all[i]$theNode
		there$stdout.putstring["Runnable Man is moving to a location\n"]
    	move RunningMan to there
    end for
	move RunningMan to home
	diff <- home.getTimeOfDay - startTime

    %find out the time it took to move an object and how long it returned back.
    home$stdout.PutString["Finished, total time = " || diff.asString || "\n"]    


  end process
end Main
```

Here you write the program into a _.m_ file where you run the code by typing in :

_emc_ where you come into the compiler mode and then type in the filename.

After compiling the Emerald program and the syntax is correct, you build an execution file where you have to run:

_emx filename.x_ to execute the Emerald file.