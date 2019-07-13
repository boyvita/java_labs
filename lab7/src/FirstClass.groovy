Closure divide = { a,b -> a/b }
Closure subtraction = { d,c -> d - c }
Closure closure = { a,b,c -> subtraction(divide(a,b),c) }

println(divide(15,3))
println(subtraction(100,1))
println(closure(100,5,4))
