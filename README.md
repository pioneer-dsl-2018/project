# Trigonometry-Proofs DSL

## Introduction

**Welcome to the Trigonometry-Proofs DSL!**

This Domain-Specific Language caters to the domain of mathematics and the sub-domain of trigonometry. It is intended to serve as a verifier of trigonometric proofs. Almost all introductory as well as intermediate courses in trigonometry tend to include a certain sub-domain which is found in several areas of mathematics, however, whose nature is extremely distinct from those other areas and is unique to trigonometry itself – that of trigonometric proofs. Trigonometry has a myriad of distinct identities and formulae, from compound angle identities to double angle identities, as well as a massive number of other identities which equate different trigonometric functions with each other through manipulation in terms of arithmetic operations. Learning how to verify trigonometric proofs and simplify trigonometric expressions is a skill necessary for students to learn for them to be able to comprehend and utilize the more complex uses of trigonometry; it is also a skill students are only able to improve through intensive and repetitive practice. However, one often insurmountable predicament several students face when dealing with such problems is the absolute lack of mechanisms and methods to verify their work or even seek out a solution if they are stuck on a particular step on this process.

This language intends to help overcome just that predicament by facilitating you to verify and perform transformations on trigonometric identities and expressions respectively. The syntax of this language - in spite of it being implemented using the higher-level programming language Python - is extremely simple. It is structure dependent, however, apart from that it is relatively flexible in that you only need to input your equation, the number of steps, the side to be transformed and the justification for each step, and voila! The compiler outputs all the steps of your proof. You can use this to not only perform a complete proof, but also to see whether or not your idea of using a certain identity will take you in the right direction. You can thus focus completely on the proof itself rather than the details of the transformation.

## Installation and Use

In order to install and use this language on your computer, you only need to perform the following steps:

1. Install Python 3 on your machine. (Installation guides - MacOS: https://docs.python-guide.org/starting/install3/osx/#install3-osx, Windows: https://docs.python-guide.org/starting/install3/win/#install3-windows, Linux: https://docs.python-guide.org/starting/install3/linux/#install3-linux)
2. Once you have Python 3 installed, you will also need to install certain Python modules in order to be able to run this DSL on your machine. Go to your **Terminal** (Mac) or **Command** (Windows) and type ```pip install sympy```.
3. In order to install pyparsing (another required library), once again, in your **Terminal** or **Command**, simply type ```pip install pyparsing```.
4. If you do not already have a text-editor such as Atom, install Atom (https://atom.io/). This is only a recommended text-editor, feel free to use any which other as well.
5. If you are using Atom, you need to install the Script package.
    a. Open a new Atom window. Click on Install a Package.
    b. Search for a packet entitled 'script'.
    c. Click install.
6. Once all the dependencies have been met, press the green **Clone or download** button on this page and download this repository as a zip file onto your computer.
7. In the folder entitled **Trig-Proofs-DSL-Final**, open the file *input-program.txt* and replace the example programs with your proofs. Save this file.
8. Open the file 'interpreter-parser.py' with Atom or your choice of text-editor.
9. Run the program using **Ctrl + Shift + B** on Windows/Linux or **Command + I** on Mac. The program will produce your output in the console below.

## Documentation

A new proof is defined with ```new_proof``` which must be followed then by the equation to be proved starting with ```expr:```, then the number of steps are defined using ```steps:``` in the next line. Post this, the fourth line after starting a new proof tells the program whether to start by transforming the LHS or the RHS, defined as ```startFrom:```. You can then type in the justifications for the transformations to be performed with each step, i.e. the algerbraic function such as ```expand``` or ```factor``` or the trigonometric identity used to perform the transformation, e.g. ```tan(x) = sin(x)/cos(x)``` or ```sin(2*x) = 2*sin(x)*cos(x)```. Comments can be made using the ```#``` sign at the beginning of the comment.

A sample program would look like this:

```
#example program 1
new_proof:
expr: 1 + 1/tan(x) = (sin(x) + cos(x))/sin(x)
steps: 3
startFrom: LHS
step1: factor
step2: tan(x) = sin(x)/cos(x)
step3: expand
```

The program alerts you if there is a discrepancy in the expected and input number of steps and/or if the LHS and RHS for the input equation are actually not equal to each other.

### steps

The steps parameter must contain a colon and have the number of steps defined as an integer such as 2, 3, 6, etc.

### startFrom

The startFrom parameter must also contain a colon and can have inputs such as ```left```, ```right```, ```LHS```, or ```RHS```.

### step

Following is a list of all the different justifications that you can input:

1. sin(x)/cos(x) = tan(x)
to transform all the ratios of sin(x) with cos(x) in the expression into tan(x).

2. expand
to expand the expression, for e.g. to transform tan(x) * (1 + sin(x)) into tan(x) + tan(x)*sin(x).

3. factor
to factor the expression, for e.g. to transform sin(x)**2/cos(x) + sin(x) into (sin(x) + cos(x))*sin(x)/cos(x).

4. simplify
to simplify the expression.

5. csc(x) = 1/sin(x)
to transform all the instances of csc(x) in the expression to 1/sin(x).

6. sec(x) = 1/cos(x)
to transform all the instances of sec(x) in the expression to 1/cos(x).

7.


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
elif step == "1/sin(x)=csc(x)" or step == "1/cos(x)=sec(x)" or step == "1/tan(x)=cot(x)":
expres = (FU['TR111'](expres))
elif step == "tan(x)**2+1=sec(x)**2" or step == "cot(x)**2+1=csc(x)**2":
expres = (FU['TR22'(expres)])
else:


