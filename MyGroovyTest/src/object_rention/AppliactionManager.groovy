package object_rention

class AppliactionManager {

    static void init() {
        ExpandoMetaClass.enableGlobally()
        // 为第三方类添加方法
        Person.metaClass.static.createPerson = { String name, int age ->
            new Person(name: name, age: age)
        }

    }

}
