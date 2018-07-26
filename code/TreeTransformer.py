from lark import Lark, Transformer
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
                alias = item.children[0]
            elif item.data == "label":
                label = item.children[0] + '$\\' + item.children[1] + '$'
        return [alias, element(name, label)]

    def connection(self, items):
        if items[1] == 'series':
            series = []
            for child in items[0].children:
                series.append(child.children[0])
            return series

