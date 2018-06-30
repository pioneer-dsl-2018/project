# The element class
# There are fields such as label and names
import SchemDraw
class element:
    d = SchemDraw.Drawing()

    # Constructors
    def __init__(self, name='', label=''):
        self.name = name #name is the element itself WITH THE SCHEMDRAW REFERENCE. Instead of 'capacitor', it should be 'e.CAP'
        self.label = label #label is what the user want to be appear on the circuit, it may contains values e.g. 13nC

    def __str__(self):
        str = 'd.add(' + self.name + ',' + 'd = \'right\',' + 'label = ' + '\'' +self.label + '\'' + ')'
        return str

    #change the label of the element
    def changeLabel(self, newLabel):
        self.label = newLabel

