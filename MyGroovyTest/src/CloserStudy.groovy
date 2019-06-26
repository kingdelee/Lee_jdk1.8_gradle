package variable

// 闭包，把方法定义为一个变量，通过变量将方法传递
def clouser = { String name -> println "hello ${name}" }

clouser("Groovy")

// 闭包的默认参数 ${it}
def clouser2 = { println "hello ${it}" }
clouser2.call()
def ret = clouser2("Groovy")

// 闭包一定有返回值
println ret

def clouser3 = { "hello ${it}" }
ret = clouser3("Groovy")
println ret
