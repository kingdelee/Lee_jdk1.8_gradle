package datafile

import groovy.util.slurpersupport.GPathResult

final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>java</title>
                    <author id="1">李刚</author>
                </book>
                <book available="22" id="2">
                    <title>java2</title>
                    <author id="2">李刚2</author>
                </book>
            </books>
        </value>
    </response>

'''

// 开始解析xml
def slurper = new XmlSlurper()
def respose = slurper.parseText(xml)

// 访问文本
def text = respose.value.books[0].book[0].title.text()
println text
// 访问属性
available = respose.value.books[0].book[0].@available
println available

def list = []
respose.value.books.each{ books ->
    books.book.each{ book ->
        def author = book.author.text()
        if(author.eqauls('李刚')){
            list.add(book.title.text())
        }
    }
}

println list.toListString()