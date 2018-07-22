# Circuit-Drawing DSL

## How to use

To run this program, first install some packages on your computer. Open the terminal,

```
$ pip3 install lark-parser
$ pip3 install SchemDraw
```

After the packages are installed, download these files and put them in a place to run. In the ```code``` directory, type this:

```
$ python3 parser.py
```

You should see a file called "output.png" generated in the dirctory and the prettified parse tree printed out in the terminal. Make sure the correct parse tree is printed out.
```
expression
  set_label
    components
      alias	capacitor
    alias	tyler
    label
      20000
      C
  set_label
    components
      alias	resistor
    alias	Harry
    label
      15
      Om
  connection
    components
      alias	John
      alias	tyler
    series

Process finished with exit code 0

```
The output image should look exactly like this:

![output](/code/output.png)

The program is now successfully ran on your computer. Modify ```input.txt``` to make different outputs!
