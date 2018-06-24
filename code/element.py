# The element class
# There should be private variables such as label and names


class element:

    label = "" #label is what the user want to be appear on the circuit, it may contains values e.g. 13nC
    name = "" #name is the element itself

    # Constructors
    def __init__(self):
        self.label = ""

    def __init__(self, name, label):
        self.name = name
        self.label = label

    #change the name of the element

