class circuit:

    # a list of lines. The line should be in order
    connection = []

    #Constructors
    def __init__(self):
        self.connection = []

    #
    def connectInParallel(self, *lines):
        for l in lines:
            self.connection.append(l)


    def connectInSeries(self, *lines):
        for l in lines:
            self.connection.extend(l.elements)






