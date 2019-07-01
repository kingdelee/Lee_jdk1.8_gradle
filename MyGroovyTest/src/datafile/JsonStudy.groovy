package datafile

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import object_rention.Person

//def list = [new Person(name:'john', age:25), new Person(name:'major', age:26)]
//
//def json =  JsonOutput.toJson(list)
//
//println json
//
//def jsonSluper = new JsonSlurper()
//jsonSluper.parse()

def response = getNetworkData(
//        "http://yuexibo.top/yxbApp/course_detail.json"
        "https://kyfw.12306.cn/otn/queryDishonest/query"
)

println response.data.head.name

def getNetworkData(String url){
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text

    // 将json 转化为实体对象
    def jsonSluper = new JsonSlurper()
    return jsonSluper.parseText(response)

}
