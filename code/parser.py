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
print(parse_tree.pretty())
#print(parse_tree)

def process_tree(tree):
    """
        new_parse_tree
         /    |    \
        /     |     \
      ele     ele   names

    """
    c = circuit()
    l = line()
    ############################change this three lines!!
    names = tree.children[len(tree.children)-1][0]
    connection = tree.children[len(tree.children)-2][1]
    mutation = tree.children[len(tree.children)-1][1]
    ############################
    print(mutation)
    if connection == "series":
        l1 = line()
        for item in tree.children:
            if item[0] in names and type(item[1]) is element:
                l1.addElement(item[1])
                l = l1
            else:
                pass
        c.connectInSeries(l)
                #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))

    elif connection == "parallel":
        for item in tree.children:
            if item[0] in names and type(item[1]) is element:
                l = line()
                l.addElement(item[1])
                c.connectInParallel(l)
            else:
                pass
                #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))
    elif connection == "add_parallel":
        for item in tree.children:
            if item[0] in names and type(item[1]) is element:
                l = line()
                l.addElement(item[1])
                c.connectInParallel(l)
            else:
                pass
                #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))
    if mutation == "add_parallel":
        for item in tree.children:
            if item[0] in names and type(item[1]) is element:
                l = line()
                l.addElement(item[1])
                c.connectInParallel(l)
            else:
                pass
                #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))
    if mutation == "add_series":
        l1 = line()
        for item in tree.children:
            if item[0] in names and type(item[1]) is element:
                l1.addElement(item[1])
                l = l1
            else:
                pass
        c.connectInSeries(l)

    c.evaluate("output.png")

new_tree = TreeTransformer().transform(parse_tree)

#print(new_tree)

process_tree(new_tree)

