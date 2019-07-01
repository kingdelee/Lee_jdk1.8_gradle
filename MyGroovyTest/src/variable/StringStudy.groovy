package variable
//class variable.StringStudy {
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


def name = 'a single \'a\' string'

def thupleName = '''\
    line one
    line two
    line three
    '''

name = "On"
def sayHello = "Hello:${name}"
println(sayHello)
println(sayHello.class)

def sum = "sum ${2+3}"

def result