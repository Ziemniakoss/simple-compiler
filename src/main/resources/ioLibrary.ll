@.str = private unnamed_addr constant [3 x i8] c"%d "
@.str.1 = private unnamed_addr constant [3 x i8] c"%f "
@.str.2 = private unnamed_addr constant [3 x i8] c"%d "
@.str.3 = private unnamed_addr constant [3 x i8] c"%f "
define dso_local i32 @readInt() #0 {
	%1 = alloca i32
	%2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32* %1)
	%3 = load i32, i32* %1
	ret i32 %3
}

declare dso_local i32 @__isoc99_scanf(i8*, ...) #1

define dso_local float @readFloat() #0 {
	%1 = alloca float
	%2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i64 0, i64 0), float* %1)
	%3 = load float, float* %1
	ret float %3
}

define dso_local i32 @writeInt(i32 %0) #0 {
	%2 = alloca i32
	store i32 %0, i32* %2
	%3 = load i32, i32* %2
	%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32 %3)
	ret i32 %4}

declare dso_local i32 @printf(i8*, ...) #1
define dso_local i32 @writeReal(float %0) #0 {
	%2 = alloca float
	store float %0, float* %2
	%3 = load float, float* %2
	%4 = fpext float %3 to double
	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.3, i64 0, i64 0), double %4)
	ret i32 %5
}
