#working

import sympy as sy
from sympy import *
FU = sy.FU
x = sy.symbols('x')

# for sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x)
print "Problem 1: sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x)"
expr3 = sin(x) * (1 + tan(x))
print expr3
expr3 = expand(expr3)
print expr3
expr3 = (FU['TR2'](expr3))
print expr3
expr3 = factor(expr3)
print expr3
expr3 = (FU['TR2i'](expr3))
print expr3

print "Problem 2: 1 + 1/tan(x) = (sin(x) + cos(x))/sin(x)"
# for 1 + 1/tan(x) = (sin(x) + cos(x))/sin(x)

exprTwo = 1 + (1/tan(x))
print exprTwo
exprTwo = factor(exprTwo)
print exprTwo
exprTwo = (FU['TR2'](exprTwo))
print exprTwo
exprTwo = factor(exprTwo)
print exprTwo

#attempt

def convert(step, expr):
    if step == "expand":
        expr = expand(expr)
        return expr
    elif step == "tan(x) = sin(x)/cos(x)" or step == "cot(x) = cos(x)/sin(x)":
        expr = (FU['TR2'](expr))
        return expr
    elif step == "sin(x)/cos(x) = tan(x)":
        expr = (FU['TR2i'](expr))
        return expr 
    elif step == "factor":
        print type(expr)
        expr = factor(expr)
        return expr
    elif step == "simplify":
        expr = simplify(expr)
        return expr
        
#expr = raw_input("Enter your expression: ")
expr = sin(x) * (1 + tan(x))
print expr
numOfSteps = int(raw_input("Enter the number of steps: "))
for x in range (1, numOfSteps + 1):
    step = ""
    step = raw_input("Enter step #" + str(x) + ": ")
    expr = convert(step, expr)
    print expr
