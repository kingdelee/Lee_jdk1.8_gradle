package object_rention

class Entry {

    public static void main(String[] args) {
        println 'start app...'
        // init
        AppliactionManager.init()
        println 'app init finish'

        def person = PersonManager.createPerson('ren', 26)
        println "the person name is ${person.name} age is ${person.age}"

    }

}
