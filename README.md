![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

`javaDSA` is a library of Java data structure and algorithms source code files that I built as references during a previous course. These are here as a continuing reference for myself and anyone else who stumbles across!


### Doubly Linked List
The DList class is constructed with a static inner Node class and uses the Generic object type. The DList object contains references to the head and tail. Each node will contain a reference to the previous and next node in the sequence. There are included methods to perform all generally required operations for a linked list.

### Stack
The Stack class is dependent on DList because it takes advantage of the DList structure. It contains all standard methods (pop, peek, push, etc...).

### Queue
The Queue class is also dependent on DList because it takes advantage of the structure of doubly linked lists. All standards methods are implemented (peek, dequeue, enqueue, etc...).

### Algorithms
So far, the source code for some of the most common sorting algorithms have been built and included in this repo. Comments regarding the structure and time/space complexity can be found in each source code file.
