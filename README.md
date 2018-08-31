# Circuit-Drawing DSL
*README UPDATED on August 31*
[*Click here to see a video demo(final product)*](https://youtu.be/IH-zbR-e2kg)

## How to use

**Welcome to this citcuit drawing DSL!**

To run this program, you have to install some prerequisites. The most important one is **python3**, which you could easily get them on the official site, and some other important python3 modules. I have these important modules written in ```requirements.txt```, to install these modules, open the terminal and type the following command

```
$ pip3 install -r requirements.txt
```

After the packages are installed, download these files and put them in a place to run. If you prefer using a fancy graphical user interface, simply type this in the terminal.**(in the ```code``` directory)**

```
python3 gui.py
```

And suddently the window pops out which looks like this:

![GUI](/example/gui/gui.png)

Otherwise, if you prefer using a terminal and editing text files, in the ```code``` directory, type this:

```
$ python3 parser.py
```
*note: if you are using terminal, you have to edit ```input.txt``` to modify input*

Both of these steps yield the same result. You should see a file called ```output.png``` generated in the dirctory and the prettified **parse tree** printed out in the terminal. Make sure the correct parse tree is printed out in the terminal!

The example output image should look something similar to this:

![output](/code/output.png)

The program is now successfully ran on your computer! Try out different grammars.

## Grammars

There are four main types of grammars in this DSL: **enabling modes**, **declaring elements**, **adding elements**, and most importantly, **connecting** two elements

### Decalring elements
it is quite easy to declaring an new elements, it follows the following format

```
ELEMENT_NAME ALIAS is NUMBER UNIT
```
*note: if an element does not have a number of a unit, simply omit* ```is NUMBER UNIT```

To declare a ```cell``` element whose alias is ```harry``` and is 999 volts I say
```
cell harry is 999 V
```

giving another example, a ```resistor``` element whose alias is ```tyler``` and contains 20 Omega of resistance, I say
```
resistor tyler is 20 Omega
```

### Connecting two elements
Good, so now we have two elements in our hand. We are going to manipulate them. To connct these two elements in series, simply say

```
connect harry and tyler in series
```
and that will produce an image like this

![output1](/example/series/output.png)

*note: there must be a* ```connect``` *statement in an individual program, it works like a* **main function**

Otherwise, we can connect them in parallel, simply change the part that came after ```in```,

```
connect harry and tyler in parallel
```

and. . . that will produce this:

![output2](/example/parallel/output.png)

### Mutating

After having a base, we can add a element to another element in series or in parallel, for example, if I have another element declared right after the above program:

```
# declaration
battery jeff is 10 V

# mutation
add jeff to tyler in parallel
```
After I added a **mutation** procedure, that yields the result

![output3](/example/add/output.png)

### Modes

In this program, there are several modes that let the user use. The general form of grammar for enabling modes is ```enable MODE_NAME```.

There are ```hand-mode```, which makes the output circuit looks like if it was draw by hand. Continuing the able procedures, if I add,

```enable hand-mode```

that yields the result of this:

![output4](/example/hand-mode/output.png)

And ```draw-mode```, which can literaly draw any kinds of circuit you want. After saying ```enable draw-mode```, the grammar turns into,

```Add COMPONENT with ATTRIBUTES```

For example,

```
# enabling modes
enable draw-mode

# procedures
add battery with theta = 30
add capacitor with theta = 90
add resistor with theta = 20
```
And that yields the result,

![output5](/example/draw-mode/output.png)

## Other notes

### Different types of attributes

```
xy     : [x,y] starting coordiante.
         Element drawn in current direction and default length.
endpts : [[x1,y1], [x2,y2]] start and end coordinates
to     : [x,y] end coordinate
tox    : x-value of end coordinate (y-value same as start)
toy    : y-value of end coordinate (x-value same as start)
l      : total length of element
zoom   : zoom/magnification for element (default=1)
anchor : 'xy' argument refers to this position within the element.
For example, an opamp can be anchored to 'in1', 'in2', or 'out'
```

### Component names

```
capacitor, resistor, cell, battery, dot, switch, voltmeter, ammeter, ground, line, switch, and more!
```
