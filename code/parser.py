from lark import Lark
from line import *
from circuit import *
from element import *

grammar = open('grammar.txt','r').read()

parser = Lark(grammar, start='sentence', ambiguity='explicit')

file = open('input.txt','r')
program = file.read()

#print(parser.parse(program).pretty())

def run_circuit(program):
    parse_tree = parser.parse(program)
    for sentence in parse_tree.children:
        run_sentence(sentence)

def run_sentence(p):
    c = circuit()
    if p.data == 'verb':
        pass
    if p.data == 'connection':
        pass
    if p.data == "conj":
        pass
    if p.data == 'prep':
        pass
    if p.data == 'noun':
        pass

#Main
run_circuit(program)
