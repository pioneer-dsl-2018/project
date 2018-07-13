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

You should see a file called "output.png" generated in the dirctory and the prettified parse tree printed out in the terminal
```
expression
  set_label
    capacitor
    label
      15
      C
  set_label
    resistor
    label
      15
      Om
  connection
    components
      components	capacitor
      resistor
    series

Process finished with exit code 0

```
The program is now successfully ran on your computer
