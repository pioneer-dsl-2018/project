# everything connects in series in A LINE

class line:

    #Constructors
    def __init__(self):
        self.elements = []# a list of elements
        self.length = len(self.elements)

    #mutators
    # this function adds an element to the end of a line
    def addElement(self, element):
        self.elements.append(element)
        self.length += 1

    # insert an element given an index
    # if the index is not given, it will insert the element at the beginning of the line
    def insertElement(self,element, index = 0):
        self.elements.insert(index, element)
        self.length += 1

    def __str__(self):
        return "these are element in this line: {0}".format(self.elements)

    def __repr__(self) -> str:
        return "these are element in this line: {0}".format(self.elements)



