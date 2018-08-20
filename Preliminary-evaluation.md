In order to evaluate the benefits and drawbacks of my design, I decided to try the language in its API form – as presented in the language design and implementation overview – on certain potential users; in order to diversify the sample, I asked some of my classmates who were familiar with programming as well as some who were unfamiliar with programming to attempt to use the DSL. While those who were familiar found it to be exceedingly easy to comprehend and utilise the syntax; those who were not brought up the fact that using syntactical elements such as double quotes and brackets felt unnatural to them when attempting to write the justifications for a trigonometric proof and that they thought the language could benefit from attempting to eliminate this need as well as certain other similar ones.
Almost all the users found that the chaining capabilities of the language as well as the phrasing of the different justifications worked well for them. I am thus particularly pleased with these capabilities, with the object definition of an expression, as well as with the parsing ability. However, I believe that the language would benefit greatly if I were to attempt to remove a greater deal of the host flavour by perhaps enhancing the parsing capabilities. My language is currently leaning further towards the API section of the spectrum rather than that of an internal DSL. The implementation can be made more cohesive by adding an intermediate level between the user and the library in order to make inputs simpler and less syntax dependent for the user. Attempting to account for a program written the following way, for instance, might be an ideal scenario.
```
newproof:
expr = 1 + 1/tan(x) = (sin(x) + cos(x))/sin(x)
steps = 4
startFrom LHS
step 1: expand
step 2: tan(x) = sin(x)/cos(x)
step 3: factor
step 4: sin(x)/cos(x) = tan(x)
```
The major predicament I encountered was because of my own unfamiliarity with object-oriented programming in Python and hence there were several bugs I found much more difficult to overcome than they would’ve been otherwise. In addition to this, learning about the library module used to transform my functions was a time-consuming but necessary process.

Before the end of the project, my aim is to implement the syntax as is shown above by perhaps creating a new kind of file which is then read by the .py file in order to input arguments and parameters into the necessary functions. In addition to this, I would like to be able to add certain necessary error messages as well as create a basic documentation for the different components of the DSL.

