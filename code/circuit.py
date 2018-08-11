import SchemDraw
from element import *
import SchemDraw.elements as e
class circuit:

    #Constructors
    def __init__(self):
        # a list of lines. The line should be in order
        self.connection = []
        self.max_length = 0

    #connect lines in parallel
    def connectInParallel(self, *lines):
        max_length = 0
        for l in lines:
            self.connection.append(l)

        def max_length(self):
            nonlocal max_length
            for l in self.connection:
                if l.length > max_length:
                    max_length = l.length
                    self.max_length = max_length

            for l in self.connection:
                if len(l) < max_length:
                    e = element('line')
                    l.addElement(e)

        return max_length(self)

    #connect lines in series
    def connectInSeries(self, *lines):
        for l in lines:
            self.connection.extend(l.elements)

    # 'ImageName' is the filename of the generated image'
    def evaluate(self, ImageName):
        d = SchemDraw.Drawing()
        #for i in range(0, len(self.connection)):
        #    exec(str(self.connection[i]))
        d.push()
        d.add(e.SOURCE_V, d='right', label='10V')
        d.add(e.LINE, d='down')
        d.pop()
        d.add(e.LINE, d='down')
        d.add(e.RES, d='right', label='100K$\Omega$')
        # recursively add a line object
        d.push()
        d.add(e.LINE, d='down')
        d.add(e.RES, d='left', label='12$\Omega$')
        d.add(e.LINE, d='up')
        d.pop()
        #print(self.connection)
        d.draw()
        d.save(ImageName)

