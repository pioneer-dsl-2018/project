# DSL projects

## Overview
For this project, you will design, implement, evaluate, and document
your own domain-specific language. This will be a significant effort on
your part, and the project makes up 80% of your grade in this course.
There will be periodic milestones during the rest of course, to help keep you
on track and to provide you feedback as you work on your language.

Other than the deadlines and requirements described below, you have
complete freedom. In particular, you're free to choose the domain and
host language in which you will implement your DSL. You should choose a
domain that really interests you and for which having a DSL would
improve yours or others' programming productivity. I will also provide guidance
for designing / choosing a good project.

## Phases of the project
There are two phases to the work for the project. The first phase occurs while
we're having our individual meetings. The second phase occurs after our last 
individual meeting, and lasts until the end of the course.

### Phase 1: Individual meetings
The goals of this phase are to:
   1. Choose a project: what domain will your language serve?
   2. Get started on a design for your DSL.
You and I will work closely during this phase to make sure that your project is
set up for successful. 

During the meetings, please take notes. It's likely that—in each meeting—I'll
give you a few extra things to do, to keep your project on track. Please be sure
you understand what I'm asking you to do and have those things ready for the
next time we meet.

Here are the milestones, deliverables, and deadlines during this phase (with
percentage of your project grade in parentheses):

_For a description of what to turn in for each milestone, click the milestone's
link._

  - [Project repository](#project-repository) (5%) Fork this
    repository before our next individual meeting.
  - [Motivation for DSLs (draft)](#motivation-for-dsls) (5%) Due 24
    hours before our 3rd individual meeting.
  - [Project description and plan](#project-description-and-plan)
    (5%) Due 24 hours before our 4th individual meeting.
  - [Prototype](#prototype) (10%) Due 24 hours before our 5th (and
    final) individual meeting.

### Phase 2: Working on the project
The goals for this phase are to work on the design and implementation of your
project, getting as close as you can to the vision for your project. Along the
way, you should also be learning more about specific language design and
implementation strategies.

Here are the milestones, deliverables, and deadlines during this phase (with
percentage of your project grade in parentheses):


_For a description of what to turn in for each milestone, click the milestone's
link._

   - [Design notebook entries](#design-notebook) (10%) You'll write
     six entries in your design notebook. An entry is due every Sunday @ 11:59pm
     Pacific, starting on Sunday, July 22. 
   - [Critiques](#critiques) (10%) You'll critique another person's
     project each week, by commenting on their design notebook. You'll submit
     six critiques, each due every Tuesday @ 11:59pm Pacific, starting on
     Tuesday, July 24.
   - [Language design and implementation overview](#language-design-and-implementation-overview) 
     (10%) Due Sunday, July 22 @ 11:59pm Pacific.
   - [Preliminary evaluation](#preliminary-evaluation) (10%) Due
     Sunday, August 5 @ 11:59pm Pacific.
   - [Motivation for DSLs (final version)](#motivation-for-dsls) 
     (5%) Due Sunday, August 12 @ 11:59pm Pacific.
   - [Final product](#final-product) (15%) Due Friday, August 31 @
     11:59pm Pacific.

## Project repository
Your project will live in a single repository. The code will, of course,
be in this repository. The project documents (for the critiques, notebooks,
and milestones) will be in the repository's wiki. **To set up your repository
for the project, fork this repository.**

**As soon as you create the repository, submit a pull request.** The pull
request will make it possible for your critique partner to review your work, in
Phase 2.

### Adding the project wiki to your repository  
Whereas the project repository contains all the code for your project, the wiki
contains all the instructions and documents / assignments for the project.
You'll need to follow these extra steps to add the wiki files to your
repository. It's a bit complicated, so be sure to read the directions carefully.

#### Step 1: Create a page on _your_ wiki
   1. Visit the GitHub page for your project.
   1. Click on the `Wiki` tab at the top of the page.
   1. Click the `Create the first page` button.
   1. Click the `Save Page` button.

#### Step 2: Clone your wiki to your computer
On your wiki's home page, click the `Clone in Desktop` button to clone the wiki
to your computer. This step is just like cloning any other repository to your
computer. **This is now your local clone for the project deliverables.** You'll
edit these files, and commit + push them back to GitHub to turn things in.

#### Step 3: Copy all the wiki files to your clone
Now, we need to take all the files I've provided and copy them to your wiki.
Here's how:
   1. Visit the [homepage](https://github.com/pioneer-dsl-2018/project/wiki) for
      the project wiki, 
   1. Click the `Clone in Desktop` button. **I recommend cloning to a temporary
      location.** You're eventually going to delete this directory.
   1. On your computer, open the folder you just created by cloning the project
      wiki. You should see a bunch of markdown (`.md`) files in this folder.
   1. Copy these files and paste them into _your_ wiki clone (i.e., the
      directory you created in Step 2). Your computer will probably warn you
      that you're overwriting or replacing the file `Home.md`. That's good, you
      want to overwrite it.
   1. Once you've copied the files to _your_ wiki clone, delete this clone. You
      don't want to get confused and edit these files, which we cloned just so
      that you could copy the files.

#### Step 4: Add, commit, and push all the new wiki files
Back in your clone, you should see a bunch of new files—all the ones you copied
over. You should add, commit, and push these files to GitHub.

#### Step 5: Confirm that everything worked
   1. Visit the GitHub page for your project.
   1. Click on the `Wiki` tab at the top of the page.
   1. You should see an updated message on the `Home` page, and a sidebar on the
      right-hand side with links to more pages.
   1. If you had any issues or problems, please send me a message on Schoology.

### Using your repository
This repository contains the implementation for your language, including 
the project's code, documentation, sample programs, etc. Your repository should 
always have an up-to-date `README.md` file that describes how to run the sample 
programs in the DSL.

_Note: At first, you may not be able to execute programs in the DSL. In that
case, the `README.md` file can just point people to any existing example
programs, or documentation, or whatever you think will be most useful for your
critique partner._

## Motivation for DSLs
Write a relatively brief (5-paragraph) introduction to DSLs. What are they, and
what differentiates a DSL from a general-purpose programming language? What are
some properties of a well-designed DSL? What are some techniques that language
implementors use to build DSLs?

The paper should be original (i.e., do more than paraphrase Fowler), it should
cite existing sources, and be based on the material we learned during the first
part of the course. The paper should also use examples of DSLs that we have
_not_ previously discussed in class.

Write your paper in the [[appropriate page|DSLs-motivation]] on the wiki. 

## Project description and plan 
This document is for you to collect and clearly convey the goals of your project
and to describe your plan for designing, implementing, and evaluating your DSL.

Place your **project description** in the [[appropriate page|Project-Description]]
on the wiki. It should address the following issues.

**Motivation:** Why is this project useful or interesting, what problem are you
    trying to address, and why is a DSL an appropriate solution?

**Language domain:** What is the domain that this language addresses, and why is
    the domain useful? Who will benefit from this language? Are there any other
    DSLs for this domain? If so, what are they, and how might they influence
    your language design and implementation?

**Language design:** If you had to capture your DSL's *design* in one sentence,
    what would it be? What constitutes a program in your language? What happens
    when a program runs? What kinds of input might a program take, and what
    kinds of output might it produce? What are the nouns, verbs, adjectives, and
    adverbs in your language? What kinds of things might go wrong in a program
    in this domain (e.g., syntax errors, compile-time errors, run-time errors)?
    How might you design your language to prevent such errors or to clearly
    communicate the results of errors to the user?

Place your **project plan** in the [[appropriate page|Project-Plan]] on the
wiki. It should answer the following questions.

**Language evaluation:** How will you know that your language has accomplished
    its goals? What tools, techniques, or measurements will you use to evaluate
    your language *design*? What tools or practices will you use to ensure that
    your language *implementation* is of high quality?

**Implementation plan:** How much time do you think you'll need for the various
    components of your language (e.g., finding a host language, implementing the
    semantics, the parser, tools, etc)? Provide a brief schedule (e.g., with a
    deliverable every week) for your project.

**Contingency plan:** What obstacles (technical and logistical) might you
    encounter while working on your project? How will you look out for them,
    overcome them, or work around them?

Your writing should be well-structured, with complete sentences (rather than
bullet points). You don't need to answer the questions in the order they're
presented; but your writing should be clear to someone who is not familiar with
the project or the domain.
    
## Prototype
Your initial prototype of the language should convey the "user experience": How
does the user describe a program, and what happens when a program runs? The
prototype does _not_ need to be fully implemented in a computer. It might exist
only on paper, as a sample program and a picture / sketch of what happens when
a program runs. Your prototype should be clear to someone who is familiar with
DSLs but not familiar with your language or its domain. 

The week before your prototype is due, we'll use part of our individual meeting
to talk about what a good prototype would look like for your language.

## Design notebook 

Everyone will keep a [[design notebook|Notebook]]. The notebook serves three
purposes:
   + It's the main way that you communicate with your critique partner. Each
     week, your partner will read your notebook entry before writing their
     critique.
   + The notebook is a place for you to organize your thoughts and think about
     the big-picture vision for the project.
   + The notebook also serves as a worklog, recording how much time you spent
     and how much progress you made in a given week. The expectation is that
     you'll spend 6–8 hours a week on your project.

Each entry in your notebook is a separate page on this wiki, and each entry
should address the questions listed on that page. A thoughtful, clear entry each
week is good for your project, good for your grade, and provides excellent
material for your critique partner and your final deliverables. Be sure to
update the notebook each week before Sunday at 11:59pm. 

## Critiques 
For the duration of the project, you'll be assigned a 
[[critique partner|Critique-partners]]. Each week during phase 2, you will
critique your partner's work, by responding to your partner's design-notebook
entry for that week.

Your job as a critic is to help make the project as good as it can be. Is there
something that the designer has missed? Do you know of a related language? Do
you know something about the domain? Can you think of good ways to evaluate the
language? Are the users of the language being served by the current design and
implementation?

Provide your critique by commenting on your partner's design notebook entry, in 
their pull request.

## Language design and implementation overview 
This overview is a chance to reflect and get feedback on the important design
and implementation decisions you've made so far. 

Place your overview in the appropriate [[wiki page|Design-and-Implementation]].
It should address the following topics:

**Language design.** Give a high-level overview of your language. Be
sure to answer the following questions and *note any changes from your
original design*:

-   How does a user write programs in your language (e.g., do they type
    in commands, use a visual/graphical tool, speak, etc.)?
-   What is the basic computation that your language performs?
-   What are the nouns, verbs, adjectives, and adverbs in your language?
-   What kind(s) of input does a program in your DSL require? What
    kind(s) of output does a program produce?
-   Error handling: How can programs go wrong, and how does your
    language communicate those errors to the user?
-   What tool support (e.g., error-checking) does your project provide?
-   Are there any other DSLs for this domain? If so, what are they, and
    how does your language compare to these other languages?

**Example computations:** Describe some example computations in your DSL. These
    computations should describe what happens when a specific program in your
    DSL executes. Note that you *shouldn't* describe the syntax of the program.
    Rather you should describe some canonical examples that help someone else
    understand the kinds of things that your DSL will eventually be able to do. 

_Note:_ You can describe the computations in the wiki page for language design 
itself, or put them in  separate files (e.g., as files in the repository), with 
links from the design page to the files. 

**Language implementation.** Give a high-level overview of the implementation
decisions you've made, including:

- Your choice of an internal vs. external implementation and how and why you
  made that choice.
- Your choice of a host language and how and why you made that choice. 
- Any significant syntax design decisions you've made and the reasons for those
  decisions.
- An overview of the architecture of your system.

## Preliminary evaluation 
Provide some analysis of the work you've done so far. Place your evaluation in
the appropriate [[wiki page|Preliminary-evaluation]]. 

Be sure to address the following issues:

-   Describe what you've done to evaluate your design. Have you tried it out
    on potential users? If so, what did you ask the users to do?
-   What works well? What are you particularly pleased with?
-   What could be improved? For example, how could the user's experience
    be better? How might your implementation be simpler or more
    cohesive?
-   Re-visit your evaluation plan from the beginning of the project. Which tools
    have you used to evaluate the quality of your design? What have you learned
    from these evaluations? Have you made any significant changes as a result of
    these tools, the critiques, or user tests?
-   Where did you run into trouble and why? For example, did you come up
    with some syntax that you found difficult to implement, given your
    host language choice? Did you want to support multiple features, but
    you had trouble getting them to play well together?
-   What's left to accomplish before the end of the project?

## Final product 
Commit all the materials for your language, along with a few sample programs. Be
sure the `README.md` file describes how a user can run the sample programs in your
language. Test-drive this process to make sure that someone else can easily use
your DSL. Your code should follow good practices. In particular, it should be
well-architected (i.e., modular), well-tested, and well-documented.

Create a demo video (maximum two minutes) for your language. A screen-recording
of a program and its execution is sufficient; but you can feel free to add a
voice-over or any other features that you think would help the viewer understand
your language. In your `README.md` file, provide a link to (or embed) your
video.

## Final write-up 
Write a document that describes and reflects on your project. It will
incorporate, with modifications, many of your previous milestones. You can
expect it to be 8–10 pages long. 

Place your writeup in the appropriate [[wiki page|Final-writeup]].
Your write-up should describe your domain, your language, and your
design and implementation processes. Specifically, it should have the
following format:

_Note:_ Your writeup should be clear, cohesive, and well-written. A
list of bullets that addresses the following questions is not
sufficient.

**Introduction:** Describe your domain and motivate the need for a DSL
(i.e., how could domain-experts use and benefit from a DSL?). What is the
essence of your language, and why is it a good language for this domain?

_Note: Your project description can serve as a good first draft 
of the introduction._

**Background:** Provide information to the reader about domain-specific
languages, by including the final version of your "Motivation" paper.

**Language design details:** Give a high-level overview of your language's
design. Be sure to answer the following questions:

-   How does a user write programs in your language (e.g., do they type
    in commands, use a visual/graphical tool, speak, etc.)?
-   What is the basic computation that your language performs?
-   What are the nouns, verbs, adjectives, and adverbs in your language?
-   What kind(s) of input does a program in your DSL require? What
    kind(s) of output does a program produce?
-   Error handling: How can programs go wrong, and how does your
    language communicate those errors to the user?
-   What tool support (e.g., error-checking) does your project provide?
-   Are there any other DSLs for this domain? If so, what are they, and
    how does your language compare to these other languages?

_Note:_ Your language design overview can serve as a good first draft of the
language design details section.

**Example program(s):** Provide one or more examples that give the
casual reader a good sense of your language. Include inputs and outputs.
Think of this section as "Tutorial By Example". You might combine this section
with the previous one, i.e., use your examples to help describe your language.

**Language implementation:** Describe your implementation. In
particular, answer the following questions:

-   What host language did you use (i.e., in what language did you implement
    your DSL)? Why did you choose this host language (i.e., why is it
    well-suited for your language design)?
-   Is yours an external or an internal DSL (or some combination thereof)? Why
    is that the right design?
-   Provide a summary of the architecture of your language, possibly including
    the front, middle, and back-end, along with any technologies used to
    implement these components.
-   "Parsing": Provide more details on how your DSL takes a user program and
    turn it into something that can be executed? 
-   Intermediate representation: What data structure(s) in the host language do
    you use to represent a program in your DSL?
-   Execution: How did you implement the semantics of the program? Describe the
    structure of your code and any special programming techniques you used to
    implement your language. In particular, how do the semantics of your host
    language differ from the semantics of your DSL?

_Note: Your language implementation overview can serve as a good first draft of
the language implementation section._

**Evaluation:** Provide some analysis of the work you did. In
particular:

-   How "DSL-y" is your language? How close or far away is it from a 
    general-purpose language?
-   What works well in your language? What are you particularly pleased with?
-   What could be improved? For example, how could the user's experience
    be better? How might your implementation be simpler or more
    cohesive? Are there more features you'd like to have? Does your current
    implementation differ from your larger vision for the language?
-   Re-visit your evaluation plan from the beginning of the project. Which tools
    have you used to evaluate the quality of your design? What have you learned
    from these evaluations? Have you made any significant changes as a result of
    these tools, the critiques, or user tests?
-   Where did you run into trouble and why? For example, did you come up
    with some syntax that you found difficult to implement, given your
    host language choice? Did you want to support multiple features, but
    you had trouble getting them to play well together?
