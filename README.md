# Simple Compiler for Simple Language

Compiler for Simple Language.
Simple Language operates only on numbers (both integer and doubles).
All operations on numbers are performed using Reverse Polish Notation.
Supported operations:
- addition,
- subtraction,
- multiplying,
- modulo,
- division.

Simple Language uses strong typing, but if operation is performed on double and integer, iteger value will be
automatically casted to double. Same applies to variable assigment.

Every program written in Simple Language must have main method, which:

- does not take any arguments,
- returns integer.

## IO Library

```
writeInt(int x);
writeReal(real x);

readInt();
readReal();
```

## Code examples

### Complex math

```
fun int main() {
	var int x = 1 2.5 * 10 - 20 + 5 %;
	writeReal(x 4.0 /);
}
```

### Conditional execution

```
fun int main() {
	if(2 2 + == 1) {
		writeInt(1);
	} elif(3 3 <= -1) {
		writeInt(2);
	} else {
		writeInt(3);
	}
}
```

### While loop

```
fun int main() {
	var int i = 2 3 *;
	while(i >= -10) {
		i = i 1 -;
	}
}
```

## Dependencies

Simple Compiler for Simple Language uses clang to compile llvm code to executable.