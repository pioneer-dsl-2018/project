# Language design and implementation overview

## Language design

The design of this DSL essentially employs the tools of parsing, object-oriented programming, and a the SymPy library’s simplify.fu module. It is split into three components: a Python program which contains the classes and methods necessary for the core computations, a second program which consists of an interpreter and parser that checks for syntax and logical errors when processing the input file and translating it into instructions which can be carried out using the computations from the first program, and a text file in which users can write their programs. The first file contains the translation between the input justification and the transformation to be performed on a given trigonometric expression; it defines a class entitled ``expr`` which needs input arguments of the equation, the number of steps, and the side to be transformed. Within this class, a method entitled ``transform`` is defined, which with the input of a justification, outputs a new ``expr`` object with the new equation serving as the expression argument.

The user types in these inputs into the DSL using the syntax of the language; this syntax is primarily mathematical symbols combined with some amount of natural language and a minimum amount of dependence on the host language’s syntax. The language essentially employs certain specific methods and functions provided by a specific module of SymPy, i.e. the simplify.fu module to transform a trigonometric expression in a certain way using particular identities or instructions. This module does so by essentially applying a sequence of rules to the expression in a heuristically smart order to obtain a final expression which is simpler but equivalent to the input. The basic computation the language performs is interpreting the commands typed in by the user and then using this to call functions defined using the simplify.fu module. The language then outputs the entire proof required to convert the left-hand side equation into the right-hand side (or vice-versa, depends on user’s input).
The following is a sample input:

```
#example program 1
new_proof:
expr: sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x) #this is a comment
steps: 4
startFrom: LHS
step1: expand
step2: tan(x) = sin(x)/cos(x)
step3: factor
step4: sin(x)/cos(x) = tan(x)

new_proof:
expr: cot(x) + tan(x) = sec(x)*csc(x)
steps: 4
startFrom: LHS
step1: tan(x)=sin(x)/cos(x)
step2: factor
step3: sin(x)**2 + cos(x)**2 = 1
step4: csc(x)=1/sin(x)
```

For this program, the user will receive the following output:

```
Proof #1
sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x)
LHS: sin(x) * (1 + tan(x))
sin(x)*tan(x) + sin(x)
sin(x)**2/cos(x) + sin(x)
(sin(x) + cos(x))*sin(x)/cos(x)
(sin(x) + cos(x))*tan(x)

Proof #2
cot(x) + tan(x) = sec(x)*csc(x)
LHS: cot(x) + tan(x)
sin(x)/cos(x) + cos(x)/sin(x)
(sin(x)**2 + cos(x)**2)/(sin(x)*cos(x))
1/(sin(x)*cos(x))
csc(x)*sec(x)
```

One of the most interesting features of this DSL is that it would be exceedingly unconventional in terms of the nature of its nouns, verbs, adjectives, and adverbs. The nouns in this language would ideally be the different kinds of trigonometric functions: sine, cosine, tangent, arcsine, arccosine, and arctangent since these will be the different kinds of data which are manipulated in order to achieve the output of the steps of verification of a trigonometric proof. The adverbs, if they are not functions themselves, could often simply be integers and floats which are used to implement the verbs on the basic functions.

The nouns, verbs, adjectives, and adverbs in this language are mathematical functions and operators. Examples of nouns can include the different kinds of trigonometric functions, such as sin(x), cos(x), and tan(x), meanwhile examples of adjectives can be means of transforming these functions, example additions, multiplications, powers, etc. The verbs are the justifications provided by the user which are necessary to transform the expression from one state to the next. Another set of verbs in this language are also, to my comprehension, somewhat of a DSL within themselves, in that they are a variety of arithmetic, trigonometric, and functional transformations performed on these trigonometric functions – such as the + operator for addition, the – operator for subtraction, the / operator for division, the * operator or a simply a number being multiplied by a function (as in 2*sine or simply 2sine) for multiplication, ^n to raise a function to the power n, using cosec, secant, and cotangent as reciprocals of the basic functions, etc. These nouns and adjectives are how the different inputs are described, and the verbs are how computations can be performed on the objects defined. The specific inputs required by a user will include the equation, whether the proof needs to go from LHS to RHS or vice-versa, the number of steps, and the justification for each step.

Programs can go wrong due to syntactical or logical errors. Logical errors can occur in case the user inputs an initial equation wherein the left-hand side and right-hand side are not equal. In order to account for this, once the user inputs the equation, the language checks as to whether or not the values of the two expressions are equal for 25 randomly generated values. If they are not, the user is alerted to this error with an error-message and the remainder of the program does not run. Another logical error which can occur is if the number of steps the user inputs is not the same as the expected number. In this case, again, the program checks for the error before the running commences and alerts them of the same. If such an error exists, the program does not run. The DSL also checks for basic syntax errors in that if the user does not use standard syntax, they are alerted to the line where the error occurs as well as the what it should be replaced with. In addition to this, if any proof is not structured as expected, the user is alerted to this error and for which proof it occurs; they are also reminded of the expected structure as part of the error message.

This DSL will also be unique in providing the functionality of the verification of trigonometric proofs since there is no DSL catering to this domain specifically.


## Example computations

For an example input:

For instance, if the following program is input by the user:

```
#example program 1
new_proof:
expr: sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x) #this is a comment
steps: 4
startFrom: LHS
step1: expand
step2: tan(x) = sin(x)/cos(x)
step3: factor
step4: sin(x)/cos(x) = tan(x)

new_proof:
expr: cot(x) + tan(x) = sec(x)*csc(x)
steps: 4
startFrom: LHS
step1: tan(x)=sin(x)/cos(x)
step2: factor
step3: sin(x)**2 + cos(x)**2 = 1
step4: csc(x)=1/sin(x)
```
The program parses the input expression, separating it into LHS and RHS basis the placement of the equals-to symbol. It then parses the numSteps variable which facilitates it to analyse how many times the transformation loop in the library must run. The startFrom argument essentially helps the program understand whether these transformations are to be made to the LHS or the RHS. Once this is input, the user must then input their steps, object-oriented prograe utilised in order to allow for chaining here such that the user need only type in all the justifications in one go. The program then inputs these justifications as arguments into the transformation loop to output the following.

The output would be:

```
Proof #1
sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x)
LHS: sin(x) * (1 + tan(x))
sin(x)*tan(x) + sin(x)
sin(x)**2/cos(x) + sin(x)
(sin(x) + cos(x))*sin(x)/cos(x)
(sin(x) + cos(x))*tan(x)

Proof #2
cot(x) + tan(x) = sec(x)*csc(x)
LHS: cot(x) + tan(x)
sin(x)/cos(x) + cos(x)/sin(x)
(sin(x)**2 + cos(x)**2)/(sin(x)*cos(x))
1/(sin(x)*cos(x))
csc(x)*sec(x)
```

## Language implementation

This DSL will be an internal DSL since there will be some degree of dependency on the syntax of the host-language. While the dependence exists, the implementation will attempt to eliminate as much of the host-flavour as is possible in order to make the language easy to learn and use for the users. This is why the syntax of the justifications is close to human language.

I chose Python as a host-language for this DSL. One of the reasons for this choice was my own familiarity with the language which meant that I needed to dedicate lesser time to comprehend and learn how to use the implementation language. Another reason was the existence of libraries necessary to transform trigonometric function since this would mean that I, as the implementer of this DSL could focus a greater amount of my time on adding fluency to and removing the host-flavour from this language to make it more ‘DSL-y’ rather than dedicating a majority of my time to writing functions to actually perform the specific transformations.

The syntax of this language is not entirely in terms of natural human language and tends to be more step-wise. This is because of the domain of the DSL, mathematics, also avoids the usage of a great deal of human-language to a great extent, instead using its own syntax in terms of operators, functions, and keywords.

The DSL essentially takes the identity to be verified, the number of steps, and whether to transform the LHS expression or RHS expression as input. It then takes the justifications for each of the steps as input. Parsing these input parameters creates an intermediate form of the program which then contains variables and input parameters in terms of the host language. A library of functions which uses the SymPy simplify.fu module is then called on this intermediate script in order to produce the output steps for the user.

