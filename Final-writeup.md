# Final Write-up

## Introduction

The field this domain-specific language would aim to cater to is that of mathematics, more specifically the domain of trigonometry. Be it digital imaging or modern architecture, music or video game design – the crucial importance of trigonometry cannot be underplayed. Almost all introductory as well as intermediate courses in trigonometry tend to include a certain sub-domain which is found in several areas of mathematics, however, whose nature is extremely distinct from those other areas and is unique to trigonometry itself – that of trigonometric proofs. Trigonometry has a myriad of distinct identities and formulae, from compound angle identities to double angle identities, as well as a massive number of other identities which equate different trigonometric functions with each other through manipulation in terms of arithmetic operations. Learning how to verify trigonometric proofs and simplify trigonometric expressions is a skill necessary for students to learn for them to be able to comprehend and utilize the more complex uses of trigonometry; it is also a skill students are only able to improve through intensive and repetitive practice.

However, one often insurmountable predicament several students face when dealing with such problems is the absolute lack of mechanisms and methods to verify their work or even seek out a solution if they are stuck on a particular step on this process. This is the very problem this domain-specific language will aim to address. A DSL is the appropriate solution to this problem because of its quality of limited expressiveness and that of its programming-language nature. For one, this DSL for simulation would enable the domain-experts to save time and effort by utilizing jargon only comprehensible to them which allows for more efficient and faster computations. This DSL will act as a verifier for trigonometric proofs and a calculator for trigonometric simplifications. The demographic that shall benefit from this DSL will be school and university students, for whom this DSL will simplify the process of verifying their work and solutions immensely. It can be of great use to any students working with or learning trigonometric proofs, in order to solve a particular problem or even simply verify their own solution. This project is exceedingly interesting in that it is not the typical example of a DSL in terms of its usage of domain-specific jargon and vocabulary as well as its idea of what kind of methods and functions can be called on different objects.

There exist no other DSLs in the specific sub-domain of trigonometric proofs. However, from Scala.math and Python.math, Scala and Python’s own mathematical modules which can calculate sine, cosine, and tangent as well as arcsine, arccosine, and arctangent trigonometric functions and convert between degrees and radians as well as Spire, which has the same functionalities - there are several libraries in the broader domain of trigonometry. Since these are not in the same domain, however, they may not greatly influence this language’s design or implementation.

This DSL’s design would aim to be fluent and concise whilst simultaneously communicating the complete inputs and outputs as required. The input required from a domain expert would be something as simple as the equation to be proven, the number of steps needed, the side of the equation which is to be transformed, and then the steps required to make the necessary transformations. The steps are essentially the justifications for each transformation, i.e. the algebraic command or the trigonometric identity which can be held responsible for the change made. For instance, the justification for transforming (tan(x) + 1)/tan(x) into (sin(x)/cos(x) + 1) *cos(x)/sin(x) would be tan(x) = sin(x)/cos(x) since every tan(x) in the initial equation is transformed into sin(x)/cos(x) using this identity. When the program runs, the DSL will transform each new form of the equation into the next basis the justification which is input by the user, and these different steps, i.e. the different transformed states of the equations will serve as the output.

Due to this domain’s quality of limited expressiveness as well as its domain-focus, it will be limited in terms of what it can do. Hence any mathematical functions or otherwise which are not a part of this domain (e.g. attempts to differentiate, calculate the inverse of, or integrate functions) will incontrovertibly elicit syntax errors. Misspellings of sine, cosine, tangent, or any of the other nouns as well as attempting to perform invalid operations shall result in syntactical errors. Some more complex errors could be if there is a difference between the expected and actual number of steps input, or if the two sides of the equation the user tries to equate are factually unequal. These errors are thus checked for by the DSL during the parsing of a program written in the language in order to correct for logic errors. In order to tackle this error, a verification check runs at the beginning of each new proof in this language is to see whether or not the LHS and RHS of the equation are equal for 10 different values of x. If they differ for even one value, the program will immediately output that there is a logical error in that the two sides of the equation are not equal hence no steps can be used to verify this equality.

This language can be of the essence to students at both the school and university when learning trigonometry. It can serve two primary purposes: for one, students can verify their own comprehension of a trigonometric proof in order to see whether or not the solution they come up with for a particular proof is a valid one. Moreover, this DSL can also facilitate students to reduce the amount of time they spend on trial-and-error when actually performing the proof; this is because it enables them to focus only on what transformation to make instead of having to also pay attention to the intricacies of making the transformation. Students and users of the language can hence often try different steps and identities with ease in order to see which transformation facilitates them to achieve their desired result without having to perform each individual transformation themselves. Especially in the early stages of learning trigonometry, this feature of the DSL can be extremely valuable as students tend to struggle more with the justifications themselves at this point. Both of these functions of the language can make the sub-domain of trigonometric proofs much less daunting and much easier to tackle for a student.

I believe that the DSL’s characteristic of being an external DSL, furthermore, makes it a beneficial language for this domain. This is because the domain-expert, in this case, needs to no longer focus on the complexities of the syntax of the host-language, Python, and can instead devote all their attention to the trigonometric proof itself. There is no dependency of the DSL on the host-language in that there is little to no host flavour and the language attempts to come as close to the natural way of expressing a trigonometric proof as is possible. Moreover, in terms of the amount of whitespace both within a programming statement and between two programming statements, the language is extremely flexible as well in that it is implemented so as to correct for this. Only the basic syntax of the language is rigid, i.e. the structure of a proof and the usage of colons in the required places.

## Background

A programming language is a formal set of vocabulary and grammatical rules used to define a set of specific instructions which can command a machine to perform certain kinds of tasks. Several different programming languages define their own syntax and keywords which are then converted to machine code to be comprehended and executed by a computer. Broadly, programming languages may be classified into two types: general-purpose programming languages (GPPL) and domain-specific languages (DSL). A general-purpose programming language is a versatile tool intended to be broadly applicable across a variety of multifaceted domains and uses; it lacks specialized features to tend to the needs of any individual domain. Common examples of the same are Python, Java, Scala, and C++.

A domain-specific language, on the contrary, is a specialized computer language of limited expressiveness designed to cater to the requirements of a particular domain. The purpose of a DSL is to enable domain-experts to more readily interact with their domain, allowing them to augment their productivity by defining specific functions to perform iterative tasks. While GPPLs enable proficient programmers to write arbitrary algorithms, DSLs are comparatively limited in their scope and capabilities – only focussing on representing the problems of and tasks required by a particular domain or area. DSLs with a well-defined domain thus enable users, i.e. domain experts to increase their productivity and improve communication by focussing on the domain’s specific jargon and syntax as well as catering to its specific problems while eliminating the need for the user to understand the intricate working and internal operations of the machine in doing so; this means that DSLs enable the user to focus on the interface while stripping away the need for them to comprehend the implementation. Examples of DSLs include AutoCad, Mathematica, SQL, Game Maker Language, HTML, and CSS.

One of the key characteristics of DSLs and what greatly differentiates them from GPPLs is their quality of limited expressiveness. The wide variety and range of functionalities of a GPPL, while increasing their usability, also tend to increase the difficulty of being able to learn and utilise it. A DSL only supports the least number of acceptable features required for a domain – this limited expressiveness is a direct manifestation of the primary intent of a DSL being to equip domain-experts who have little to no knowledge of programming with being able to better interact with and navigate their domain. The quality of limited expressiveness also tends to add the advantage of DSLs being more machine-efficient as compared to GPPLs.

The design of a DSL dictates its ease-of-use. In terms of design, the primary purpose of a DSL is to attain a relatively high degree of clarity. Often, this has two major implications in terms of the syntax of the language: utilising the jargon of the domain and most imperatively, maintaining a component of fluency. The specificity and terseness of professional jargon improves the efficiency of communication by increasing the information processing speed; implementing the same in a DSL enables complex problems to be solved in fewer steps as well as better and more effective communication between the language and the expert. Fluency, in terms of a DSL, is defined as the level of readability and resemblance borne by a DSL to human language. This often manifests itself as the degree to which a DSL’s nouns (used to define different forms of data) and verbs (used to define the operations performed on the data) fit together.

DSLs can further be classified broadly into two different types: internal DSLs and external DSLs. An internal DSL is essentially defined as a domain-specific language which greatly utilises and bases its design on the infrastructure of a host language; it builds domain-specific functions and semantics by using the tools and pillars provided by this existing framework. Often, internal DSLs are implemented as fluent libraries for the existing language. Only a small subset of the language’s features is used when implementing an internal DSL. An external DSL, on the other hand, is a stand-alone programming language, independent of a host language. As such, an external DSL develops and follows its own syntax and semantics. An example is the Cascading Style Sheet (CSS) used to define the style used to visualize an HTML document on a screen.

GPPLs and DSLs, instead of being binary values, exist on a spectrum. As a consequence of this, when creating a DSL, the implementer can often employ a series of techniques to make the language increasingly more ‘DSL-y’. What starts out as an API can be converted to an internal DSL by adding fluency. Several different techniques may be employed by the language implementer in order to do so. Function composition, i.e. the application of one function to the result of another, can be used to do so. When multiple functions need to be called on the same object consecutively, something which is the often the case in domain-specific languages where the types of objects are limited due to the requirements of the domain, method-chaining may be employed as well. Essentially, each method returns an object, therefore enabling the different functions to be chained together instead of requiring separate variables to store the intermediate results.

The next step to making a language more like a DSL is often the process of removing the “host flavour” wherein the implementer essentially attempts to reduce the degree of influence the syntax of the host language has on the syntax of the DSL. This can be done by utilising a variety of features, such as infix operators, literal extensions, as well as pre- and post-fix operators. Adding syntactic sugar, i.e. reducing the dependency on the host language and bringing the syntax as close to natural human language as is possible makes the DSL easier to comprehend for those domain-experts who might not be familiar with the fundamentals of the syntax of higher-level languages.

## Language Design and Examples

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

Programs can go wrong due to syntactical or logical errors. Logical errors can occur in case the user inputs an initial equation wherein the left-hand side and right-hand side are not equal. In order to account for this, once the user inputs the equation, the language checks as to whether or not the values of the two expressions are equal for 25 randomly generated values. If they are not, the user is alerted to this error with an error-message and the remainder of the program does not run. Another logical error which can occur is if the number of steps the user inputs is not the same as the expected number. In this case, again, the program checks for the error before the running commences and alerts them of the same. If such an error exists, the program does not run. The DSL also checks for basic syntax errors in that if the user does not use standard syntax, they are alerted to the line where the error occurs as well as the what it should be replaced with. In addition to this, if any proof is not structured as expected, the user is alerted to this error and for which proof it occurs; they are also reminded of the expected structure as part of the error message. For instance, if the following program is input by the user:

```
#example program 1
new_proof:
expr: 1 + 1/tan(x) = (sin(x) + cos(x))/sin(x)
startFrom: LHS
steps: 3 #demonstrating a structural error (steps: and startFrom: are swapped)
step1: factor
step2: tan(x) = sin(x)/cos(x)
step3: expand
```

They receive the following output

```
Proof #1 is not structured as expected. Please structure the proof as:
new_proof
expr: equation
steps: number-of-steps
startFrom: LHS/RHS
steps
```

This DSL will also be unique in providing the functionality of the verification of trigonometric proofs since there is no DSL catering to this domain specifically.


