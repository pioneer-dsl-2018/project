#computations
#importing necessary libraries
import sympy as sy
from sympy import *
from numpy import *
from math import *
from pyparsing import *
import random
#for trigonometric simplification
FU = sy.FU
x = sy.symbols('x')

#creating expr object
class expr(object):
    startFrom = ""
    expressionI = ""
    numSteps = 0
    express = ""
    def __init__(self, expressionI, numSteps = 0, startFrom = "Left"): #defining defaults for when method is transformed using chaining
        self.expressionI = (expressionI)
        self.numSteps = numSteps
        self.startFrom = startFrom
    def transform(self, step):
        expres = ""
        if "=" in str(self.expressionI): #if it is the first input, i.e. the equation to be proved
            startFromBase = (self.startFrom == "Left" or self.startFrom == "LHS" or self.startFrom == "lhs" or self.startFrom == "left")
            splitExpression = list(self.expressionI.partition("=")) #splitting equation into LHS and RHS
            LHS = splitExpression[0].replace(" ", "")  #eliminating all whitespace
            RHS = splitExpression[2].replace(" ", "")  #eliminating all whitespace

            print (self.expressionI).strip() #printing the equation to be proven
            if startFromBase == True: #start from base checks whether or not startFrom = LHS
                expres = sympify(LHS)
                print "LHS: " + str(LHS)
            else:
                expres = sympify(RHS)
                print "RHS: " + str(RHS)
        else:
            expres = self.expressionI #this is in case expressionI is simply the transformed expression ()

        step = step.replace(" ", "") #eliminating all whitespace from the step input

        if step == "sin(x)/cos(x)=tan(x)":
            expres = (FU['TR2i'](expres))
        elif step == "expand":
            expres = expand(expres)
        elif step == "factor":
            expres = factor(expres)
        elif step == "simplify":
            expres = simplify(expres)
        elif step == "csc(x)=1/sin(x)" or step == "sec(x)=1/cos(x)" or step == "1/sin(x)=csc(x)" or step == "1/cos(x)=sec(x)" or step == "1/tan(x)=cot(x)":
            expres = (FU['TR1'](expres))
            expres = (FU['TR111'](expres))
        elif step == "tan(x)=sin(x)/cos(x)" or step == "cot(x)=cos(x)/sin(x)":
            expres = (FU['TR2'](expres))
        elif step == "sin(x)**2+cos(x)**2=1":
            expres = (FU['TR5'](expres))
        elif step == "cos(x)**2=1-sin(x)**2":
            expres = (FU['TR6'](expres))
        elif step == "cos(2*x)=2*cos(x)**2-1":
            expres = (FU['TR6'](expres))
        elif step == "cos(x)**2 =1-sin(x)**2":
            expres = (FU['TR6'](expres))
        elif step == "sin(a+b)=sin(a)*cos(b)+sin(b)*cos(a)" or step == "sin(a-b)=sin(a)*cos(b)+sin(b)*cos(a)" or step == "cos(a+b)=cos(a)*cos(b)-sin(a)*sin(b)" or step == "cos(a - b) =  cos(a)*cos(b) + sin(a)*sin(b)":
            expres = (FU['TR10'](expres))
        elif step == "sin(2*x)=2*sin(x)*cos(x)" or step == "cos(2*x)=cos(x)**2-sin(x)**2":
            expres = (FU['TR11'](expres))
        elif step == "tan(a+b)=(tan(a)+tan(b))/(-tan(a)*tan(b)+1)" or step == "tan(a+b) = (tan(a)-tan(b))/(tan(a)*tan(b)+1)":
            expres = (FU['TR12'(expres)])
        elif step == "tan(x)**2+1=sec(x)**2" or step == "cot(x)**2+1=csc(x)**2":
            expres = (FU['TR22'(expres)])
        print expres
        return expr(expressionI = expres)

    def verify(self): #to verify that LHS = RHS
        if "=" in str(self.expressionI): #splitting into LHS and RHS
            startFromBase = (self.startFrom == "Left" or self.startFrom == "LHS" or self.startFrom == "lhs" or self.startFrom == "left")
            splitExpression = list(self.expressionI.partition("="))
            LHS = splitExpression[0]
            RHS = splitExpression[2]
            LHS = sympify(LHS) #converting LHS and RHS into sympy expressions for evaluation
            RHS = sympify(RHS)
        randomAngles = []
        for i in range(45): #generating 25 random values between -360 and 360 degrees to see whether or not LHS = RHS for all of these
            randomAngle = random.randint(-360, 360)
            LHSVal = round(LHS.evalf(subs = {x: radians(randomAngle)}), 5) #rounding off to 5 decimal places in order to avoid discrepancies due to rounding
            RHSVal = round(RHS.evalf(subs = {x: radians(randomAngle)}), 5)
            if LHSVal != RHSVal:
                return False
        return True

    def equality(self, otherSide): #attempting to check whether or not LHS = RHS at the end of the steps in order to print QED at the end; however, this does not work for all cases yet since it checks for string equality which can be a problem when LHS = sin(x)*cos(x) but RHS = cos(x)*sin(x)
        if "=" in str(self.expressionI):
            startFromBase = (self.startFrom == "Left" or self.startFrom == "LHS" or self.startFrom == "lhs" or self.startFrom == "left")
            splitExpression = list(self.expressionI.partition("="))
            LHS = splitExpression[0]
            RHS = splitExpression[2]
            if startFromBase:
                if str(RHS) == str(otherSide):
                    return True
            else:
                if str(LHS) == str(otherSide):
                    return True
