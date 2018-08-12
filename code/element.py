# The element class
# There are fields such as label and names
import SchemDraw
class element:
    d = SchemDraw.Drawing()

    # Constructors
    def __init__(self, name='', label=''):

        # This 'library' converts names to SchemeDraw library names
        # There should be more elements this Dictionary
        library = {'capacitor': 'e.CAP', 'resistor': 'e.RES', 'cell': 'e.BAT_CELL', 'battery': 'e.BATTERY',
                   'dot': 'e.DOT','switch': 'e.SWITCH_SPST','line': 'e.LINE'}

        self.name = name #name is the element itself. Instead of 'capacitor', it should be 'e.CAP'
        self.label = label #label is what the user want to be appear on the circuit, it may contains values e.g. 13nC
        self.schemName = library[self.name]
        self.direction = 'right'

    def __str__(self):
        #str = "[name: "+ self.name + ", " + "label: " + self.label + ", " + "schemName: " + self.schemName +"]"
        str = 'd.add(' + self.schemName + ',' + 'd = \'' + self.direction + '\',' + 'label = ' + '\'' + self.label + '\'' + ')'
        return str

    def __repr__(self):
        str = 'd.add(' + self.schemName + ',' + 'd = \'' + self.direction + '\',' + 'label = ' + '\'' + self.label + '\'' + ')'
        return str

    def setDirection(self, newDir):
        self.direction = newDir

    #change the label of the element
    def changeLabel(self, newLabel):
        self.label = newLabel

