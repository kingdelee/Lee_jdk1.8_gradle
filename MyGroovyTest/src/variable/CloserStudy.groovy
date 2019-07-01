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


int x = fab(5)

println(x)

int fab(int num) {
    int result = 1
    // 从1到num 开始迭代
    1.upto(num, { index -> result *= index })
    return result
}

int x2 = fab2(5)
println(x2)

int fab2(int num) {
    int result = 1
    num.downto(1) {
        index -> result *= index
    }
    return result
}

// 通过闭包来代替循环
int x3 = cal(101)
println(x3)

int cal(int num) {
    int ret
    num.times {
        idx -> ret += idx
    }
    return ret
}

// the 2 and 3 is 5
String str = 'the 2 and 3 is 5'
// String的字符each的遍历
str.each {
    String tmp -> print tmp
}

println()
// find来查找
str.find {
    String s -> s.isNumber()
}

def list = str.findAll {
    String s -> s.isNumber()
}

println list.toString()


ret = str.any {
    String s -> s.isNumber()
}
println(ret)

str.every {
    String s -> s.isNumber()
}

def list2 = str.collect {
    it.toUpperCase()
}

println(list2.toListString())


def scriptClouser = {
    println "classClouser this:" + this // 代表闭包定义处的类
    println "classClouser owner:" + owner    // 代表闭包定义处的类或者对象
    println "classClouser delegate:" + delegate  // 代表任意对象
}
scriptClouser.call()


class Person {
    def static classClouser = {
        println "classClouser this:" + this // 代表闭包定义处的类
        println "classClouser owner:" + owner    // 代表闭包定义处的类或者对象
        println "classClouser delegate:" + delegate  // 代表任意对象
    }

    def static say() {
        def classClouser = {
            println "classClouser this:" + this // 代表闭包定义处的类
            println "classClouser owner:" + owner    // 代表闭包定义处的类或者对象
            println "classClouser delegate:" + delegate  // 代表任意对象
        }
        classClouser.call()
    }

}

Person p = new Person()
Person.classClouser.call()
Person.say()

println("------------------1")


// 在闭包中定义闭包
// this指的是当前脚本类，owner指向最近的闭包的对象
def nestClouser = {
    def innerClouser = {
        println "classClouser this:" + this // 代表闭包定义处的类
        println "classClouser owner:" + owner    // 代表闭包定义处的类或者对象
        println "classClouser delegate:" + delegate  // 代表任意对象
    }

    innerClouser.call()

}


nestClouser.call()

println("------------------2")


def nestClouser2 = {
    def innerClouser = {
        println "classClouser this:" + this // 代表闭包定义处的类
        println "classClouser owner:" + owner    // 代表闭包定义处的类或者对象
        println "classClouser delegate:" + delegate  // 代表任意对象
    }
    innerClouser.delegate = p // 默认
    innerClouser.call()

}

nestClouser2.call()
println("------------------3")

//
//class Student {
//    String name
//    def pretty = { "My name is ${name}" }
//
//    String toString() {
//        pretty.call()
//    }
//}
//
//class Teacher {
//    String name
//}
//
//def stu = new Student(name: "stu")
//def tea = new Teacher(name: "tea")
//
//stu.pretty.delegate = tea
//stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
//stu.pretty.resolveStrategy = Closure.DELEGATE_ONLY
//println(stu.toString())


// 实际上是根据name作为委托属性去查找的，所以当name的名改变之后，就无法委托了


class Student {
    String name
    def pretty = { "My name is ${name}" }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name1
}

stu = new Student(name: "stu")
tea = new Teacher(name1: "tea")

stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
//stu.pretty.resolveStrategy = Closure.DELEGATE_ONLY
println(stu.toString())


