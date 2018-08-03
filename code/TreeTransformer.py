from lark import Lark, Transformer, Tree
from lark.lexer import Token
from line import *
from circuit import *
from element import *


class TreeTransformer(Transformer):

    #set label has to come before connection
    def set_label(self, items):
        alias, name, label = "", "", ""
        for item in items:
            if item.data == "components":
                name = item.children[0].children[0]
            elif item.data == "alias":
                alias = item.children[0].value
            elif item.data == "label":
                label = item.children[0] + '$' + item.children[1] + '$'
        return [alias, element(name, label)]

    def connection(self, items):
        names = []
        alias_connected = items[0].find_pred(lambda x: type(x.children[0]) == Token)
        for alias in alias_connected:
            names.append(alias.children[0].value)
        if items[1] == 'series':
            return [names, 'series']
        elif items[1] == 'parallel':
            return [names, 'parallel']

