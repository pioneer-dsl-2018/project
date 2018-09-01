from pyparsing import *
import numpy as np
from sourcecode import expr
import os
dir_path = os.path.dirname(os.path.realpath(__file__))

def lineEmpty(line):
    return len(line.strip()) < 1
lines = []
with open(dir_path + "/input-program.txt") as f:
    for line in f:
        if line.startswith('#') == False and lineEmpty(line) == False:
            line = line[:-1]
            lines.append(line)

            for line in lines:
                if "#" in line:
                    line = line.split("#", 1)
                    line = line[1]

#parser and interpreter

#defining expected structure
numStepsParse = "steps:" + Word(nums)
startFromParse = "startFrom:" + Word(alphas)
#lines = text_input.splitlines()

numProofs = 0
expressionsAll = []
startFroms = []
numStepsAll = []
stepsAll = []
syntaxError = False

for i in range(len(lines)):
    if lines[i] == "new_proof:":
        numProofs = numProofs + 1
        expression = lines[i + 1]
        numSteps = lines[i + 2]
        startFrom = lines[i + 3]
        if not "expr:" in expression:
            print "Syntax error in line " + str(i + 1) + "." " Please define new expression with 'expr:' and recompile."
            syntaxError = True
            break

        if not "steps:" or "Steps:" in numSteps:
            print "Syntax error in line " + str(i + 2) + "." " Please define new expression with 'steps:' and recompile."
            syntaxError = True
            break

        if not "startFrom:" or "startfrom:" in numSteps:
            print "Syntax error in line " + str(i + 3) + "." " Please define new expression with 'startFrom:' and recompile."
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
            stepLineX = lines[i + s + 4]
            if stepLineX.startswith("step") == False:
                print "Number of steps entered does not match expected number of steps. Number of steps expected were " + str(numStepsX) + ", but number of steps entered were " + str(1) + "."
                syntaxError = True
                break

        for j in range(numStepsX):
            stepLineX = lines[i + j + 4]
            stepX = stepLineX.split(":", 1)
            stepX = stepX[1].lstrip()
            stepsX.append(stepX)

        expressionsAll.append(expressionX)
        startFroms.append(startFromX)
        numStepsAll.append(numStepsX)
        stepsAll.append(stepsX)

if syntaxError == False:
    for k in range(numProofs):
        if not k == 0:
            print " "
        print "Proof #" + str(k + 1)
        exprX = expr(expressionsAll[k], numSteps = numStepsAll[k], startFrom = startFroms[k])
        if exprX.verify() == True:
            for l in range(numStepsAll[k]):
                steps = stepsAll[k]
                exprX = exprX.transform(steps[l])
                final = exprX.expressionI
        else:
            print "The left-hand side and right-hand side cannot be equated."
