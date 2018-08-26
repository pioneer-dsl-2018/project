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
                   'dot': 'e.DOT','switch': 'e.SWITCH_SPST','line': 'e.LINE', 'voltmeter': 'METER_V', 'ammeter': 'METER_I',
                   'ground':'GND'}

        self.name = name #name is the element itself. Instead of 'capacitor', it should be 'e.CAP'
        self.label = label #label is what the user want to be appear on the circuit, it may contains values e.g. 13nC
        self.schemName = library[self.name]
        self.direction = 'right'
        self.alias = ''
        self.voltage = 0
        self.resistance = 0
        self.current = 0

    def get_voltage(self):
        return self.current * self.resistance

    def get_current(self):
        if self.resistance == 0:
            print( "the resistance is 0, unable to divide")
            return 0
        return self.voltage / self.resistance

    def get_resistance(self):
        if self.current == 0:
            print( "the current is 0, unable to divide")
            return 0
        return self.voltage / self.current

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
    
#overrides the above 'element' class
class CompleteElement(element):

    d = SchemDraw.Drawing()

    # Constructors
    def __init__(self, name=''):
        d = SchemDraw.Drawing()

        library = {'capacitor': 'e.CAP', 'resistor': 'e.RES', 'cell': 'e.BAT_CELL', 'battery': 'e.BATTERY',
                   'dot': 'e.DOT','switch': 'e.SWITCH_SPST','line': 'e.LINE', 'voltmeter': 'METER_V', 'ammeter': 'METER_I',
                   'ground':'GND'}

        self.name = name 
        self.schemName = library[self.name]
        self.alias = ''
        self.label = ''

        self.other_attrs_nums = {}
        self.other_attrs_strings = {}
        self.attrs_strings = ''

    def set_other_attrs(self, attr_dict):
        num_attrs = ['xy', 'endpts', 'to', 'tox', 'toy', 'l', 'zoom', 'theta', 'label']
        str_attrs = ['anchor', 'd']
        for attr in attr_dict:
            if attr in num_attrs:
                self.other_attrs_nums[attr] = attr_dict[attr]
            elif attr in str_attrs:
                self.other_attrs_strings[attr] = attr_dict[attr]
            else:
                pass #belongs to neither of the group
    
    def process_other_attrs(self):
        for attr in self.other_attrs_nums:
            self.attrs_strings += ', {0} = {1}'.format(attr, self.other_attrs_nums[attr])
        for attr in self.other_attrs_strings:
            self.attrs_strings += ', {0} = \'{1}\''.format(attr, self.other_attrs_strings[attr])
    
    def __str__(self):
        str = 'd.add(' + self.schemName + self.attrs_strings + ')'
        return str

    def __repr__(self):
        str = 'd.add(' + self.schemName +  self.attrs_strings + ')'
        return str

        
        

