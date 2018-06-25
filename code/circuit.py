
class circuit:


    #Constructors
    def __init__(self):
        # a list of lines. The line should be in order
        self.connection = []

    #
    def connectInParallel(self, *lines):
        for l in lines:
            self.connection.append(l)


    def connectInSeries(self, *lines):
        for l in lines:
            self.connection.extend(l.elements)

    # There will be more methods to add a new line, or change the order of a line

    # mutators

    # this method converts the data to a valid SchemdDraw Program
    def writeDocument(self, address):
        file = open(address, 'w')
        file.write('import SchemeDraw as scheme\n'           #import the SchemeDraw package
                   'import SchemeDraw.elements as e\n'       #and elements
                   'd = Scheme.Drawing()\n'                  #Default setting . . .
                   '')                                       #add elements

