# Circuit-Drawing DSL
*README UPDATED on August 14*

## How to use

Welcome to this citcuit drawing DSL! To run this program, first install some packages on your computer. Open the terminal,

```
$ pip3 install lark-parser
$ pip3 install SchemDraw
```

After the packages are installed, download these files and put them in a place to run. In the ```code``` directory, type this:

```
$ python3 parser.py
```

You should see a file called "output.png" generated in the dirctory and the prettified parse tree printed out in the terminal. Make sure the correct parse tree is printed out in the terminal!

The example output image should look exactly like this:

![output](/code/output.png)

The program is now successfully ran on your computer. Modify ```input.txt``` to make different outputs!

## Grammars

### Decalring elements
it is quite easy to declaring an new elements, it follows the following format

```
ELEMENT_NAME ALIAS is NUMBER UNIT
```

So i can say,
```
cell harry is 999 V
```
or
```
resistor tyler is 20 Omega
```

### Connecting
Good, so now we have two elements in our hand. Now we are going to manipulate them. To connct these two elements in series, simply say

```
connect harry and tyler in series
```
and that will produce this
![output1](/code/example/series/output.png)
Or, we can connect them in parallel, simply say

```
connect harry and tyler in parallel
```

and. . . that will produce this:
![output2](/code/example/parallel/output.png)

### Mutating

What if i want to add an element? Let say we have declared an element beforehand

```
battery jeff is 10 V
```
and that gives up the result
![output3](/code/example/add/output.png)
