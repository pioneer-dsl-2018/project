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
      ele     ele   proc

    """
    c = circuit()
    l = line()
    names = {}
    procedures = []
    for lst in tree.children:
        if type(lst[0]) is str:
            names[lst[0]] = lst[1]
        else:
            procedures.append(lst)
    #print(names)
    #print(procedures)

    for proc in procedures:

        proc_elements_names = proc[0]
        proc_name = proc[1]

        #print(proc_elements_names)
        #print(proc_name)

        if proc_name == "series":
            l1 = line()
            for element in proc_elements_names:
                l1.addElement(names[element])
            l = l1
            c.connectInSeries(l)
                    #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))

        elif proc_name == "parallel":
            l1 = line()
            for element in proc_elements_names:
                l1.addElement(names[element])
                c.connectInParallel(l1)
                l1 = line()


        elif proc_name == "add_parallel":
            for item in tree.children:
                if item[0] in names and type(item[1]) is element:
                    l = line()
                    l.addElement(item[1])
                    c.connectInParallel(l)
                else:
                    pass
                    #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))
        elif proc_name == "add_series":
            l1 = line()
            for item in tree.children:
                if item[0] in names and type(item[1]) is element:
                    l1.addElement(item[1])
                    l = l1
                else:
                    pass

    c.evaluate("output.png")
    #print(c)
new_tree = TreeTransformer().transform(parse_tree)

print(new_tree.pretty())

process_tree(new_tree)

