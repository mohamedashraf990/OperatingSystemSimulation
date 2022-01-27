# Operating-Systems-Simulation Project
 
 
**In this project you will see a simulation of an operating system. how the OS manages resources and processes by implementing a scheduler, memory, PCB .**



### Scheduler: 
*Scheduler is responsible for scheduling between the processes in the Ready Queue. It ensures that all processes get a chance to execute. A scheduling Algorithm is an algorithm that chooses the process that gets to execute.  there are many different scheduling algorithms to schedule processes. In this project, you will see the implementation the Round Robin algorithm. Round robin is a scheduling algorithm where each process is assigned a fixed time slice. For this project, each process executes 2 instructions in its time slice. For simplicity you can assume that all processes arrive together in this order, P1, P2, P3.*

### Memory:
*this system will store all the created variables in a single data structure and the memory system will be augmented by making the OS manage it and assign a space for each process. The memory is of non-dynamic size. The memory is large enough to hold the un-parsed lines of code, variables and PCB for each of the processes. The memory is divided into memory words, each word can store 1 variable and it’s corresponding data. . Processes should not access any data outside their allocated memory block.*

### PCB:
*A process control block is a data structure used by computer operating systems to store all the information about a process.In order to schedule your processes, The system will need to keep a PCB for every process. The PCB should contain the following information: 1. Process ID (Assume that the ID corresponds to the program number) 2. Process State 3. Program Counter 4. Memory Boundaries*

## How to execute
*In order to run the project You are required to run the main class, where you schedule the processes. The system will start by reading the program files from the disk and assigning memory locations for each of the aforementioned processes. Once all the processes are loaded in the memory, the OS will start the scheduling process. The scheduler will choose the process to run and do so by checking the processes states from the PCBs stored in the memory, then running the selected process’s code from the memory.*

## Syntax used for programs

**print**: *to print the output on the screen. Example: print x*

**assign**: *to initialize a new variable and assign a value to it. Example: assign x y, where x is the variable and y is the value assigned. The value could be an integer number, or a string*

**add**: *to perform the summation of 2 numbers. Example: add x y, where x and y are the 2 values summed, and the result of the summation is saved in x.*

**writeFile**: *to write data to a file. Example: writeFile x y, where x is the filename and y is the data.*

**readFile**: *to read data from a file. Example: readFile x, where x is the filename*

