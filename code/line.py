# everything connects in series in A LINE
class line:

    elements = []

    #Constructors
    def __init__(self):
        self.element = []

    #mutators
    # this function adds an element to the end of a line
    def addElement(self, element):
        e = element()
        self.elements.append(e)




