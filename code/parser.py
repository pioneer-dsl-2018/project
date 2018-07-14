from lark import Lark, Transformer
from line import *
from circuit import *
from element import *

grammar = open('grammar.txt','r').read()

parser = Lark(grammar, start = "expression")

file = open('input.txt','r')
program = file.read()

#parse
parse_tree = parser.parse(program)

#print the parse tree in the terminal
#print(parse_tree.pretty())
#print(parse_tree)

class TreeTransformer(Transformer):
    def set_label(self, items):
        print(items[2].children[1])
        label = str(items[2].children[0] + items[2].children[1])
        alias = items[0].children[0].children[0] #can't find a better way finding this branch
        return element(alias,label)
#    def connection(self, items):
#        return []
print(TreeTransformer().transform(parse_tree))
