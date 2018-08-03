import SchemDraw
import SchemDraw.elements as e
class circuit:

    #Constructors
    def __init__(self):
        # a list of lines. The line should be in order
        self.connection = []

    #connect lines in parallel
    def connectInParallel(self, *lines):
        max_length = 0
        for l in lines:
            if len(l) > max_length:
                max_length = len(l)
        print(max_length)
        for l in lines:
            self.connection.append(l)

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

