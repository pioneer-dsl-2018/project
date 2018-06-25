# This file should act as the "back"

#import packages
from line import *
from circuit import *
from element import *

# This 'library' converts names to SchemeDraw library names
# There should be more elements this Dictionary
library = {'Capacitor':'e.CAP','Resistor':'e.RES', 'Cell': 'e.BAT_CELL','Battery':'e.BATTERY', 'Dot':'e.DOT','Switch':'e.SWITCH_SPST'}

# Main
# In this demo, there is a circuit with one line. And on this line there is an element "capacitor"
c = circuit()                              # instantiate a new circuit
l1 = line()                                # instantiate a new line
cap = element(library['Capacitor'],"13nC") # instantiate a new element and convert the name to a SchemDraw Library name
l1.addElement(cap)                         # add the capacitor element to l1
c.connectInSeries(l1)

# replace the argument as the address of the Run.txt file
# After executing Main.py, just use python to run 'Run.txt'
c.writeDocument('/Users/teo/Documents/PycharmProjects/Pioneer DSL/Run.txt',"output.png")


