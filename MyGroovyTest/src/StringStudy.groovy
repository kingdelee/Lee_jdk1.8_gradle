//class StringStudy {
//}

def str = "groovy"

println str.center(8)

// 从左填充字符串
// groovy -> aagroovy
println str.padLeft(8, 'a')


def str2 = "Hello"

println str > str2
println str[0]
println str[0..1]


println str - str2

