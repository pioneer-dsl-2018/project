from lark import Lark, Transformer, Tree
from line import *
from circuit import *
from element import *
from TreeTransformer import *

grammar = open('grammar.txt','r').read()

parser = Lark(grammar, start = "expression")

file = open('input.txt','r')
program = file.read()

#parse
parse_tree = parser.parse(program)

#print the parse tree in the terminal
#print(parse_tree.pretty())
#print(parse_tree)

def process_tree(tree):
    c = circuit()
    l1 = line()
    for e in tree.children:
        if type(e) is element:
            l1.addElement(e)
    c.connectInSeries(l1)
    c.evaluate("output.png")

new_tree = TreeTransformer().transform(parse_tree)

print(new_tree)

process_tree(new_tree)

