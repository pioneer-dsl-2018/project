# Geometry-Draw DSL
*UPDATED AUG 31TH*

## Getting Installed
1. Download the zip file into your computer.
2. Open the **Terminal** (Mac OS) or **Command** (Windows)
3. Go to the directory where you keep Geometry-Draw
4. Type in ```sbt run``` and **Enter**
5. Ignore the warnings and find the number of **myConstructions.main** (In the *DEMO Video*, the number is **2**)
6. Type in the *number* and **Enter**
7. The successful image should be like this

![this](https://github.com/harrylyf/project/blob/master/img/img1.png)


## Starting Use

Basically, Geometry-Draw has five major functions: Draw, Move, Set, Remove and Mark. However, the **Mark** function is still under construction due to some unexpected language issues. This file will only introduce the first four functions.

### Draw
In Draw function, there are two branches: line and arc.

The grammar for drawing the line is: 
```draw line with ruler from A to B```

- **A** and **B** needs to be in Point format, which is: ```( , )```

The grammar for drawing the arc is:
```draw arc with compass A from B with radius C from D to E```

- **A** can be either *clockwise* or *counter-clockwise*
- **B** needs to be in Point format
- **C**, **D** and **E** are all numbers

### Move
For the rest functions, only two branches, point and line, are available.

The grammar for moving the point is:
```move point A B C```

- **A** needs to be in Point format
- **B** needs to be one of the following: *up*, *down*, *left* or *right*
- **C** is number

The grammar for moving the line is:
```move line A B C```

- **A** needs to be in Line format, which is ```(Point, Point)```
- **B** needs to be one of the following: *up*, *down*, *left* or *right*
- **C** is number

### Set

The grammar for setting the point is:
```set point A B to C```

- **A** needs to be in Point format
- **B** needs to be either *color* or *thickness*
- **C** can be number or string
- Support colors: 
	- red
	- yellow
	- blue
	- gray
	- pink
	- green

The grammar for setting the line is:
```set line A B to C```

- **A** needs to be in Line format
- **B** needs to be either *color* or *thickness*
- **C** can be number or string

### Remove
The grammar for removing the point is:
``` remove point A```

- **A** needs to be in Point format


The grammar for removing the line is:
``` remove line A```

- **A** needs to be in Line format



## Demo video
<a href="https://www.youtube.com/watch?feature=player_embedded&v=2T7v8VqQpLs
" target="_blank"><img src="http://img.youtube.com/vi/2T7v8VqQpLs/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="560" height="315" border="10" /></a>
