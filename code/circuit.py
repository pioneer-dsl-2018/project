import SchemDraw
from element import *
from line import *
import SchemDraw.elements as e
class circuit:

    #Constructors
    def __init__(self):
        self.connection = []
        self.max_length = 0
        self.modes = []
        

    #connect lines in parallel
    def connectInParallel(self, *lines):
        for l in lines:
            self.connection.append(l)

    def find_max_length(self):
        for l in self.connection:
            if l.length > self.max_length:
                self.max_length = l.length

        for l in self.connection:
            if l.length < self.max_length:
                e = element('line')
                l.addElement(e)

    #connect lines in series
    def connectInSeries(self, *lines):
        for l in lines:
            self.connection.append(l)

    # 'ImageName' is the filename of the generated image'
    def evaluate(self, ImageName):

        if "hand-mode" in self.modes:
            import matplotlib.pyplot as plt
            plt.xkcd()

        if "calculator" in self.modes:
            self.print_data()

        self.find_max_length()
        d = SchemDraw.Drawing()
        d.push()
        for i in range(0, self.connection[0].length):
            exec(str(self.connection[0].elements[i]))

        # deals with parallel situations
        if len(self.connection) > 1 :
            d.add(e.LINE, d='down')
            d.pop()
            d.add(e.LINE, d='down')
            for i in range(0, self.connection[1].length):
                exec(str(self.connection[1].elements[i]))

            # iteratively add lines
            for i in range(2, len(self.connection)):
                d.push()
                d.add(e.LINE, d='down')
                for j in range(0, self.connection[i].length):
                    self.connection[i].elements[j].setDirection('left')
                    exec(str(self.connection[i].elements[j]))
                d.add(e.LINE, d='up')
                d.pop()
        #print(self.connection)
        d.draw()
        d.save(ImageName)

    def __str__(self):
        string = ''
        for l in self.connection:
            string += str(l)
            string += "\n"
        return string

    def __repr__(self):
        string = ''
        for l in self.connection:
            string += str(l)
            string += "\n"
        return string
    
    def set_mode(self, mode_name):
        self.modes.append(mode_name)


############################
    def print_data(self):
        for l in self.connection:
            for e in l.elements:
                message = 'type: {0}\n ' + 'alias: {1}\n' + 'voltage: {2} \n' +'current: {3}\n\n'.format(e.name, e.alias, e.get_voltage(), e.get_current())
                print(message)

###########################