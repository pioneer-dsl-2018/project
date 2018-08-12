import SchemDraw
from element import *
from line import *
import SchemDraw.elements as e
class circuit:

    #Constructors
    def __init__(self):
        self.connection = []
        self.max_length = 0

    #connect lines in parallel
    def connectInParallel(self, *lines):
        max_length = 0
        for l in lines:
            self.connection.append(l)

        def find_max_length(self):
            nonlocal max_length
            for l in self.connection:
                if l.length > max_length:
                    max_length = l.length
                    self.max_length = max_length

            for l in self.connection:
                if l.length < max_length:
                    e = element('line')
                    l.addElement(e)

        return find_max_length(self)

    #connect lines in series
    def connectInSeries(self, *lines):
        for l in lines:
            self.connection.append(l)

    # 'ImageName' is the filename of the generated image'
    def evaluate(self, ImageName):
        d = SchemDraw.Drawing()
        d.push()
        for i in range(0, self.connection[0].length):
            exec(str(self.connection[0].elements[i]))
        if len(self.connection) > 1 :
            d.add(e.LINE, d='down')
            d.pop()
            d.add(e.LINE, d='down')
            for i in range(0, self.connection[1].length):
                exec(str(self.connection[1].elements[i]))
            # iteratively add lines
            '''
            for i in range(2, len(self.connection)):
                d.push()
                d.add(e.LINE, d='down')
                for j in range(0, self.connection[i].length):
                    exec(str(self.connection[i].elements[j]))
                d.add(e.LINE, d='up')
                d.pop()
            '''
        #print(self.connection)
        d.draw()
        d.save(ImageName)

