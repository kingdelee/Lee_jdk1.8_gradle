package variable

//def list = new ArrayList()

def list = [1, 2, 3, 4, 5]
println(list.class)
println(list.size)

def array = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]

// 排序
def sortList = [6, -3, 9, 2, -7, 1, 5]
//Comparator mc = {a, b -> a == b ? 0: Math.abs(a) < Math.abs(b) ? -1 : 1}
//Collections.sort(sortList, mc)

//sortList.sort()
//println(sortList)


sortList.sort { a, b ->
    a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}


def sortStringList = ['abc', 'z', 'hello', 'groovy', 'java']
sortStringList.sort { it -> return it.size() }
println(sortStringList)

// 列表查找
def findList = [-3, 9, 6, 2, -8, 1, 5]
int ret = findList.find { return it % 2 == 0 }
def ret2 = findList.findAll { return it % 2 != 0 }
println(ret2.toListString())
def ret3 = findList.every { return it % 2 == 0 }
//findList.min()
//findList.max()
findList.min { return Math.abs(it) }
findList.max { return Math.abs(it) }


findList.count { return it % 2 == 0 }


//def map = new HashMap()

def colors = [red: 'ff0000', green: '00ff00', blue: '0000ff']
println colors.getClass()

// 索引方式
println colors['red']
println colors.red

// 添加元素
colors.yellow = 'ffff00'
colors.complex = [a: 1, b: 2]
println(colors.toMapString())
println colors.getClass()

def students = [
        1: [numbsers: '0001', name: 'Aob', score: 45, sex: 'male'],
        2: [numbsers: '0002', name: 'Bob', score: 55, sex: 'male'],
        3: [numbsers: '0003', name: 'Cob', score: 65, sex: 'male'],
        4: [numbsers: '0004', name: 'Dob', score: 75, sex: 'male']
]

students.each { def student ->
//    println 'the key is ${student.key}'
    println "the key is ${student.key}" + "the value is ${student.value}"
}

//students.eachWithIndex { Entry<Integer, LinkedHashMap<String, Serializable>> entry, int i ->
////    println "index is ${index}, the key is ${entry.key}, value is ${entry.value}"
//    println " the key is ${entry.key}, value is ${entry.value}"
//}


students.eachWithIndex { def entry, int i ->
    println " the key is ${entry.key}, value is ${entry.value}"

}

students.eachWithIndex { key, value, index ->
    println "the key is ${index}, key is ${key}, value is ${value}"
}


// Map的查找
def entry = students.find { def student ->
    return student.value.score >= 60
}

println entry

def entrys = students.findAll { def student ->
    return student.value.score >= 60
}

def count = students.count { def student ->
    return student.value.score >= 60
}

println count

def names = students.findAll { def student ->
    return student.value.score >= 60
}.collect {
    return it.value.name
}

println names
println names.toListString()


def group = students.groupBy { def student ->
    return student.value.score >= 60 ? '及格' : '不及格'
}

println group.toMapString()

/**
 * 排序
 */

def sort = students.sort { def student1, def student2 ->
    Number score1 = student1.value.score
    Number score2 = student2.value.score
    return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}


// 范围

def range = 1..10
println range[0]
println range.contains(10)
println range.from
println range.to

//range.each {
//    println it
//}
//
//for (i in range) {
//    println i
//}

//Caught: org.codehaus.groovy.runtime.typehandling.GroovyCastException: Cannot cast object '及格' with class 'java.lang.String' to class 'int'
//org.codehaus.groovy.runtime.typehandling.GroovyCastException: Cannot cast object '及格' with class 'java.lang.String' to class 'int'
//at variable.DataStructure.run(DataStructure.groovy:164)

println "----------getGrade"
def getGrade(Number number) {
    def result
    switch (number) {
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '及格'
            break
    }
    return result
}

def ret5 = getGrade(60)
println ret5

println "----------switch"
def age = 25;
switch (age) {
    case 0..17:
        println '未成年'
        break
    case 18..30:
        println '青年'
        break
    case 31..50:
        println '中年'
        break
    default:
        println '老年'
}


//age = getGrade(60)
println age



































