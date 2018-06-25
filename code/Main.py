# This file should act as the "back"
from line import *
from circuit import *
from element import *

# This 'library' converts names to SchemeDraw library names
# There should be more elements this Dictionary
library = {'Capacitor':'CAP','Resistor':'RES', 'Cell': 'BAT_CELL','Battery':'BATTERY', 'Dot':'DOT','Switch':'SWITCH_SPST'}

# Main
# In this demo, there is a circuit with one line. And on this line there is an element "capacitor"
c = circuit()
l1 = line()
cap = element('Capacitor',"13nC")
l1.addElement(cap)

# replace the argument as the address of the Run.txt file
# After executing Main.py, just use python to run 'Run.txt'
c.writeDocument('/Users/teo/Documents/PycharmProjects/Pioneer DSL/Run.txt','output.png')


