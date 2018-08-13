# Design notebook entry

## Last week's critique

Previously, as with the prototype for the Trigonometric Proofs Domain-Specific Language, a major struggle encountered during the implementation was the oversimplification of certain steps which resulted in the several steps of the proof simply being skipped. Basis the feedback received from Dr. Wiedermann during the final individual meeting – in an attempt to correct this – I spent a great deal of time over the past week studying and analysing the specific module used by this DSL to transform trigonometric functions in an attempt to be able to gain an understanding of the different layers of each of the transformation algorithms and to try to comprehend how to separate out and only utilise certain layers of the function. I am still working to try to correct this problem by employing the aforementioned method and hope to be able to correct it over the next few days.

## Description

Resuming my project this week meant that I started the implementation of the DSL from scratch, taking into account and employing the functions and methods provided by the SymPy library and some of its specific modules. SymPy’s simplify.fu module utilises the ‘fu’ algorithm which essentially applies a sequence of rules to the expression in a heuristically smart order to obtain a final expression which is simpler but equivalent to the input. The current flow for a user employing this DSL involves them typing in an expression – typically the expression on the left-hand side of the equation – then typing in the number of steps required for the proof and then inputting the justification/transformation needed for each of the steps. Each time a justification is input, the expression in its given form is transformed basis the input; this then becomes the new form of the expression for further justifications to change.
Currently, I am working on the basic functionality of the program, rather than focussing on incorporating the component of its fluency; i.e., the DSL is still in its library stage. The working functionality at the moment essentially involves the user being able to declare a variable which is equal to the LHS in string form. They are then asked to input the number of steps and the justification for each step by the program. The DSL can take into account most of the basic trigonometric identities, including the square identities, compound-angle identities, reciprocal identities, product identities, and most double-angle identities.

## Questions for you to answer

The steps I wish to take and features I hope to implement over the next week involve finding a method to incorporate the remaining identities as well as working on, finalizing, and implementing the syntax for the DSL. Before the end of this week, my aim is for this DSL to be in API form, with there being some degree of fluency in how the user can interact with the DSL.
This week, I spent most of my time rebooting the project, studying the specific SymPy module my DSL uses, and implementing the basic functionality – I spent a total of 6.5 hours on the project this week.

