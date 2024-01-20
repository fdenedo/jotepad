# JotePad
This is a Notepad clone I am working on in Java. Well, at its most basic it is, but really this project is going to be an exploration of the kind of algorithms and data structures text editors employ to make editing large documents easy and efficient.

<img width="412" alt="Screenshot 2024-01-20 152036" src="https://github.com/fdenedo/jotepad/assets/24829887/771b31c5-1f05-40b5-b25e-0cf121afc99b">

## Requirements
**Java 17** or Higher

## Installation
I haven't built an executable for this project, and I don't intend to as the important thing is the exploration of text data structures. Having said that, if you wish to browse the source code or rin the project for yourself, feel free to clone it and run the code from the `GUI` class.

## Current Implementaion
Right now, this is a simple, barebones Notepad clone, built using Java Swing components. Java Swing makes this part of the project really easy, as it supplies a `JTextComponent` class, with essentially all that's needed to style and configure a large text area for editing documents. Speaking of Documents, the `JTextComponent` uses the `Document` class, which is the first part of the exploration.

## Next Steps
* Create a custom text area.
Exploring how to make a text area from scratch will allow me to create my own Document interface, which I can then usee to create multiple representations for the text data.

* Add tests
* Implement a simple array representation with insertion and deletion (much like `String` now), perhaps do the same using a `StringBuilder`
* Implement a gap buffer data structure to allow for more efficient insertion and deletion (this is how Swing's `Document` class represents its text)
* Implement a piece table data structure for the document (this is what Microsoft pioneered when creating their first version of MS Word)
* Implement a layer to switch between the different data structures in the GUI, and add the ability to compare the insertion and deletion speed of each
