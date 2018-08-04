import SchemDraw
import SchemDraw.elements as e
class circuit:

    #Constructors
    def __init__(self):
        # a list of lines. The line should be in order
        self.connection = []
        self.max_length = 0

    #connect lines in parallel
    def connectInParallel(self, *lines):
        for l in lines:
            self.connection.append(l)
        for l in self.connection:
            max_length = 0
            if l.length > max_length:
                max_length = l.length
                self.max_length = max_length

    #connect lines in series
    def connectInSeries(self, *lines):
        for l in lines:
            self.connection.extend(l.elements)

    # 'ImageName' is the filename of the generated image'
    def evaluate(self, ImageName):
        d = SchemDraw.Drawing()
        for i in range(0, len(self.connection)):
            exec(str(self.connection[i]))
        #print(self.connection)
        d.draw()
        d.save(ImageName)

