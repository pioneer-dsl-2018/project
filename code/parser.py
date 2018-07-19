from lark import Lark, Transformer, Tree
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
print(parse_tree.pretty())
#print(parse_tree)

class TreeTransformer(Transformer):
    def set_label(self, items):
        #print(items[2].children[1])
        label = str(items[2].children[0] + items[2].children[1])
        alias = items[0].children[0].children[0]
        return element(alias,label)
    def connection(self, items):
        if items[1] == 'series':
            series = []
            for child in items[0].children:
                series.append(child.children[0])
        return series

def process_tree(tree):
    elements = tree.find_pred(lambda x: x is element)
    lists = tree.find_pred(lambda x: x is list)
    return list(elements), list(lists)



new_tree = TreeTransformer().transform(parse_tree)
print(new_tree)

print(process_tree(new_tree))

