package object_rention

//class Person implements DefaultAction, Action {
class Person implements DefaultAction {

    String name;

    Integer age

    def increaseAge(Integer years){
        this.name +=years
    }

    /**
     * 当使用该重写时，找不到方法的时候会调用
     * @param name
     * @param args
     * @return
     */
    @Override
    def invokeMethod(String name, Object args){
        return "method is ${name}, params is ${args}"
    }

    /**
     * 当使用该重写时，会将缺失的方法打印出来
     * @param name
     * @param args
     * @return
     */
    def methodMissing(String name, Object args){
        return "the method ${name} is missing"
    }

//    @Override
//    void drink() {
//    }

    @Override
    void eat() {

    }
}
