from lark import Lark
from line import *
from circuit import *
from element import *

grammar = open('grammar.txt','r').read()

parser = Lark(grammar, start='sentence', ambiguity='explicit')

file = open('input.txt','r')
program = file.read()


print(parser.parse(program).pretty())

def run_circuit(program):
    parse_tree = parser.parse(program)
    for sentence in parse_tree.children:
        run_sentence(sentence)

def run_sentence(p):
    if p.data == 'verb':
        if p.children[0] == 'connect':
            global l1
            l1 = line()
    elif p.data == 'connection':
        if p.children[0] == 'series':
            c.connectInSeries(l1)
    elif p.data == "conj":
        if p.children[0] == 'and':
            pass
    elif p.data == 'prep':
        pass
    elif p.data == 'noun':
        if p.children[0] == 'capacitor':
            cap = element('e.CAP', "19C")
            l1.addElement(cap)
        elif p.children[0] == 'resistor':
            res = element('e.RES', "89\Omega")
            l1.addElement(res)

#Main
c = circuit()
run_circuit(program)
c.evaluate("output.png")
