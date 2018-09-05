from pyparsing import *
import numpy as np
from sourcecode import expr
import os
dir_path = os.path.dirname(os.path.realpath(__file__)) #in order to define the path of the file on whichever computer it is stored on

def lineEmpty(line): #defining a function to check if a line is empty
    return len(line.strip()) < 1
lines = [] #defining an array to store the lines at separate indices

with open(dir_path + "/input-program.txt") as f:
    for line in f:
        if line.startswith('#') == False and lineEmpty(line) == False:
            line = line[:-1]
            lines.append(line) #this serves to only add to the list the lines which are not empty and do not begin with a pound sign, i.e. are not comments

    for x in range(len(lines)):
        line = lines[x]
        if "#" in line: #checking if any elements of the list contain in-line comments and removing them from the lines if they are there
            line = line.split("#", 1)
            lines[x] = line[0]
        lines[x] = lines[x].strip() #stripping all lines of any whitespace

#parser and interpreter

#defining expected structure
numStepsParse = "steps:" + Word(nums)
startFromParse = "startFrom:" + Word(alphas)

#initializing
numProofs = 0
expressionsAll = [] #array to hold all expressions
startFroms = [] #array to hold all startFroms
numStepsAll = [] #array to hold all number of steps
stepsAll = [] #array to hold all lists of steps
syntaxError = False #boolean which defines whether or not a syntax error has occurred

for i in range(len(lines)): #iterating through all the lines
    if lines[i] == "new_proof:":
        numProofs = numProofs + 1
        #checking for the structure
        if (lines[i + 1]).startswith("expr") != True or lines[i + 2].startswith("steps") != True or lines[i + 3].startswith("startFrom") != True:
            print "Proof #" + str(numProofs) + " is not structured as expected. Please structure the proof as:\nnew_proof\nexpr: equation\nsteps: number-of-steps\nstartFrom: LHS/RHS\nsteps"
            syntaxError = True
            break

        #given that structure is non-erroneous, assigning following lines after proof is defined to variables
        expression = lines[i + 1]
        numSteps = lines[i + 2]
        startFrom = lines[i + 3]

        #checking for syntax errors
        if not "expr:" in expression:
            print "Syntax error in line " + str(i + 1) + "." " Please define new expression with 'expr:' and recompile."
            syntaxError = True
            break

        if not "steps:" or "Steps:" in numSteps:
            print "Syntax error in line " + str(i + 2) + "." " Please define number of steps with 'steps:' and recompile."
            syntaxError = True
            break

        if not "startFrom:" or "startfrom:" in numSteps:
            print "Syntax error in line " + str(i + 3) + "." " Please define the side to be transformed with 'startFrom:' and recompile."
            syntaxError = True
            break

        #extracting the expression
        expressionX = expression.split(":", 1)
        expressionX = expressionX[1]

        #extracting the number of steps and which side of the equation to start from
        parsedNumSteps = numStepsParse.parseString(numSteps)
        parsedStartFrom = startFromParse.parseString(startFrom)
        numStepsX = int(parsedNumSteps[1])
        startFromX = str(parsedStartFrom[1])

        #extracting the steps
        stepsX = []
        for s in range(numStepsX):
            #i is the index of the line where the proof begins, s is the index with reference to the line where the first step occurs, and +4 in order to account for the number of lines between the definition of a new proof and the beginning of the steps
            stepLineX = lines[i + s + 4]
            if stepLineX.startswith("step") == False: #checking if the number of steps matches the expected number by ensuring that the expected number of lines begin with step:
                print "For proof #" + str(numProofs) + ", input number of steps entered does not match expected number of steps. Number of steps expected were " + str(numStepsX) + ", but number of steps entered were " + str(s) + "."
                syntaxError = True
                break

        #given that no syntax error occurs, extracting the steps
        for j in range(numStepsX):
            stepLineX = lines[i + j + 4]
            stepX = stepLineX.split(":", 1)
            stepX = stepX[1].lstrip()
            stepsX.append(stepX)

        #adding all elements to the respective arrays
        expressionsAll.append(expressionX)
        startFroms.append(startFromX)
        numStepsAll.append(numStepsX)
        stepsAll.append(stepsX)

#only runs if no syntax error has occurred throughout the program
if syntaxError == False:
    for k in range(numProofs): #running for all the proofs
        if not k == 0:
            print " " #adding a line between the different proofs
        print "Proof #" + str(k + 1)
        exprX = expr(expressionsAll[k], numSteps = numStepsAll[k], startFrom = startFroms[k]) #defining an expression object using the user's input parameters
        if exprX.verify() == True: #first checking if the two sides of the equation are equal
            for l in range(numStepsAll[k]):
                steps = stepsAll[k]
                exprX = exprX.transform(steps[l])
                final = exprX.expressionI
        else:
            print "The left-hand side and right-hand side cannot be equated."
