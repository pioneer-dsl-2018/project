from lark import Lark, Transformer, Tree
from line import *
from circuit import *
from element import *

class TreeTransformer(Transformer):

    def set_label(self, items):
        #print(items[2].children[1])
        labels = str(items[2].children[0] + items[2].children[1])
        names = items[0].children[0].children[0]
        return element(names,labels)

    def connection(self, items):
        if items[1] == 'series':
            series = []
            for child in items[0].children:
                series.append(child.children[0])
        return series