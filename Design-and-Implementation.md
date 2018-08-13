# Language design and implementation overview

## Language design

The language I am working to create caters to the domain of mathematics and the sub-domain of trigonometry; within trigonometry, it shall aim to essentially serve as a verifier for trigonometric proofs. A user of the language will ideally be able to type in the identity they hope to verify, the number of steps, and then the justification for each step (for instance, the identity used for a transformation of the expression) and the DSL will perform transformations basis the input justifications to facilitate the user to verify the steps taken to prove the identity.

The user types in these inputs into the DSL using the syntax of the language; this syntax is primarily mathematical symbols combined with some amount of natural language and a minimum amount of dependence on the host language’s syntax. The language essentially employs certain specific methods and functions provided by a specific module of SymPy, i.e. the simplify.fu module to transform a trigonometric expression in a certain way using particular identities or instructions. This module does so by essentially applying a sequence of rules to the expression in a heuristically smart order to obtain a final expression which is simpler but equivalent to the input. The basic computation the language performs is interpreting the commands typed in by the user and then using this to call functions defined using the simplify.fu module. The language then outputs the entire proof required to convert the left-hand side equation into the right-hand side (or vice-versa, depends on user’s input).

The nouns, verbs, adjectives, and adverbs in this language are mathematical functions and operators. Examples of nouns can include the different kinds of trigonometric functions, such as sin(x), cos(x), and tan(x), meanwhile examples of adjectives can be means of transforming these functions, example additions, multiplications, powers, etc. The verbs are the justifications provided by the user which are necessary to transform the expression from one state to the next. These nouns and adjectives are how the different inputs are described, and the verbs are how computations can be performed on the objects defined. The specific inputs required by a user will include the equation, whether the proof needs to go from LHS to RHS or vice-versa, the number of steps, and the justification for each step.

Programs can go wrong due to syntactical or logical errors. Logical errors can occur in case the user inputs an initial equation wherein the left-hand side and right-hand side are not equal. In order to account for this, once the user inputs the equation, the language checks as to whether or not the values of the two expressions are equal for 100 randomly generated values. If they are not, the user is alerted to this error and the remainder of the program does not run. The DSL does not currently have a sophisticated means of sorting the different kinds of syntax error, therefore at the moment, it simply indicates to the user that such an error exists. This DSL will also be unique in providing the functionality of the verification of trigonometric proofs since there is no DSL catering to this domain specifically.

## Example computations

For an example input:

```
exprOne = expr(sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x), numSteps = 4, startFrom = LHS)
steps.transform(expand)
     .transform(tan(x) = sin(x)/cos(x))
     .transform(factor)
     .transform(sin(x)/cos(x) = tan(x)
```
The program parses the input expression, separating it into LHS and RHS basis the placement of the equals-to symbol. It then parses the numSteps variable which facilitates it to analyse how many times the transformation loop in the library must run. The startFrom argument essentially helps the program understand whether these transformations are to be made to the LHS or the RHS. Once this is input, the user must then input their steps, object-oriented prograe utilised in order to allow for chaining here such that the user need only type in all the justifications in one go. The program then inputs these justifications as arguments into the transformation loop to output the following.

The output would be:

```
Problem 1: sin(x) * (1 + tan(x)) = (sin(x) + cos(x))*tan(x)
Step 1: (tan(x) + 1)*sin(x)
Step 2: sin(x)*tan(x) + sin(x)
Step 3: sin(x)**2/cos(x) + sin(x)
Step 4: (sin(x) + cos(x))*sin(x)/cos(x)
Final: (sin(x) + cos(x))*tan(x) = RHS
```

## Language implementation

This DSL will be an internal DSL since there will be some degree of dependency on the syntax of the host-language. While the dependence exists, the implementation will attempt to eliminate as much of the host-flavour as is possible in order to make the language easy to learn and use for the users. This is why the syntax of the justifications is close to human language.

I chose Python as a host-language for this DSL. One of the reasons for this choice was my own familiarity with the language which meant that I needed to dedicate lesser time to comprehend and learn how to use the implementation language. Another reason was the existence of libraries necessary to transform trigonometric function since this would mean that I, as the implementer of this DSL could focus a greater amount of my time on adding fluency to and removing the host-flavour from this language to make it more ‘DSL-y’ rather than dedicating a majority of my time to writing functions to actually perform the specific transformations.

The syntax of this language is not entirely in terms of natural human language and tends to be more step-wise. This is because of the domain of the DSL, mathematics, also avoids the usage of a great deal of human-language to a great extent, instead using its own syntax in terms of operators, functions, and keywords.

The DSL essentially takes the identity to be verified, the number of steps, and whether to transform the LHS expression or RHS expression as input. It then takes the justifications for each of the steps as input. Parsing these input parameters creates an intermediate form of the program which then contains variables and input parameters in terms of the host language. A library of functions which uses the SymPy simplify.fu module is then called on this intermediate script in order to produce the output steps for the user.

