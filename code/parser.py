from lark import Lark
from line import *
from circuit import *
from element import *

grammar = open('grammar.txt','r').read()

parser = Lark(grammar, start='connection')

file = open('input.txt','r')
program = file.read()


print(parser.parse(program).pretty())

def run_circuit(program):
    parse_tree = parser.parse(program)
    for child in parse_tree.children:
        run(child)

#def run(p):


#Main
#c = circuit()
#run_circuit(program)
#c.evaluate("output.png")
