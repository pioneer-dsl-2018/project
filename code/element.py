# The element class
# There should be private variables such as label and names


class element:

    # Constructors

    def __init__(self, name='', label=''):
        self.name = name #name is the element itself
        self.label = label #label is what the user want to be appear on the circuit, it may contains values e.g. 13nC


    #change the name of the element

