@.str = private unnamed_addr constant [3 x i8] c"%d\00"
@.str.1 = private unnamed_addr constant [3 x i8] c"%f\00"
@.str.2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str.3 = private unnamed_addr constant [5 x i8] c"%lf\0A\00"

define dso_local i32 @readInt() #0 {
  %1 = alloca i32
  %2 = alloca i8
  %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32* %1)
  br label %4

4:                                                ; preds = %15, %0
  %5 = call i32 @getchar()
  %6 = trunc i32 %5 to i8
  store i8 %6, i8* %2
  %7 = sext i8 %6 to i32
  %8 = icmp ne i32 %7, -1
  br i1 %8, label %9, label %13

9:                                                ; preds = %4
  %10 = load i8, i8* %2
  %11 = sext i8 %10 to i32
  %12 = icmp ne i32 %11, 10
  br label %13

13:                                               ; preds = %9, %4
  %14 = phi i1 [ false, %4 ], [ %12, %9 ]
  br i1 %14, label %15, label %16

15:                                               ; preds = %13
  br label %4

16:                                               ; preds = %13
  %17 = load i32, i32* %1
  ret i32 %17
}

declare dso_local i32 @__isoc99_scanf(i8*, ...) #1

declare dso_local i32 @getchar() #1

define dso_local double @readReal() #0 {
  %1 = alloca float
  %2 = alloca i8
  %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i64 0, i64 0), float* %1)
  br label %4

4:                                                ; preds = %15, %0
  %5 = call i32 @getchar()
  %6 = trunc i32 %5 to i8
  store i8 %6, i8* %2
  %7 = sext i8 %6 to i32
  %8 = icmp ne i32 %7, -1
  br i1 %8, label %9, label %13

9:                                                ; preds = %4
  %10 = load i8, i8* %2
  %11 = sext i8 %10 to i32
  %12 = icmp ne i32 %11, 10
  br label %13

13:                                               ; preds = %9, %4
  %14 = phi i1 [ false, %4 ], [ %12, %9 ]
  br i1 %14, label %15, label %16

15:                                               ; preds = %13
  br label %4

16:                                               ; preds = %13
  %17 = load float, float* %1
  %18 = fpext float %17 to double
  ret double %18
}

define dso_local i32 @writeInt(i32 %0) #0 {
  %2 = alloca i32
  store i32 %0, i32* %2
  %3 = load i32, i32* %2
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.2, i64 0, i64 0), i32 %3)
  ret i32 %4
}

declare dso_local i32 @printf(i8*, ...) #1

define dso_local i32 @writeReal(double %0) #0 {
  %2 = alloca double
  store double %0, double* %2
  %3 = load double, double* %2
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.3, i64 0, i64 0), double %3)
  ret i32 %4
}
