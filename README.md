# Simple Compiler for Simple Language

Compiler for Simple Language.
Simple Language operates only on numbers (both integer and doubles).
All operations on numbers are performed using Reverse Polish Notation.
Supported operations:
- addition
- subtraction
- multiplying
- modulo
- division

Simple Language uses strong typing, but if operation is performed on double and integer, iteger value will be automatically casted to double.
Same applies to variable assigment.

Every program written in Simple Language must have main method, which:
- does not take any arguments
- returns integer

## IO Library

## Code examples

Simple program returning sum of 3 numbers
```
fun int main() {
	return 10.5 20.5 + 10 +;
}
```

## Dependencies

Simple Compiler for Simple Language uses clang to compile llvm code to executable.