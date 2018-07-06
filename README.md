# Circuit-Drawing DSL

## How to use

To run this program, first install some packages on your computer. Open the terminal,

```
$ pip3 install lark-parser
```

After the packages are installed, download these files and put them in a place to run. In the ```code``` directory, type this:

```
python3 parser.py
```

You should see a file called "output.png generated in the dirctory and something like this printed out
```
sentence
  verb	connect
  noun	capacitor
  conj	and
  noun	resistor
  prep	in
  connection	series
  verb	connect
  noun	resistor
  prep	in
  connection	series

[<element.element object at 0x117307b00>, <element.element object at 0x117307b38>, <element.element object at 0x117307828>]

Process finished with exit code 0

```
The program is successfully ran on your computer
