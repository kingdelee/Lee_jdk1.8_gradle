package object_rention

def person = new Person(name: "on", age:3)
person.increaseAge(10)
println "name is ${person.name}, age is ${person.getAge()}"

println person.cry()


// 为类动态的添加一个属性
Person.metaClass.sex = 'male'
person = new Person(name: "on", age:3)
println person.sex




// 为类动态的添加方法
Person.metaClass.sexUpperCase = {->sex.toUpperCase()}
person2 = new Person(name : 'on', age : 26)
println person2.sexUpperCase()

// 为类动态的添加静态方法
Person.metaClass.static.createPerson = {
    String name, int age ->
        new Person(name: name, age: age)
}

def person3 = Person.createPerson('renzhi', 26)
println person3.name + " and " + person3.age





















