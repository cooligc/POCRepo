import groovy.json.JsonSlurper

/**
 * Created by IgnatiusCipher on 8/12/2015.
 */
class JsonGroovyParsing {

 final static String DUMMY_JSON="""{
  "first": "John",
  "last": "Doe",
  "age": 39,
  "sex": "M",
  "salary": 70000,
  "registered": true,
  "interests": [ "Reading", "Mountain Biking", "Hacking" ],
  "favorites": {
    "color": "Blue",
    "sport": "Soccer",
    "food": "Spaghetti"
  },
  "skills": [
    {
      "category": "JavaScript",
      "tests": [
        { "name": "One", "score": 90 },
        { "name": "Two", "score": 96 }
      ]
    },
    {
      "category": "CouchDB",
      "tests": [
        { "name": "Three", "score": 79 },
        { "name": "Four", "score": 84 }
      ]
    },
    {
      "category": "Node.js",
      "tests": [
        { "name": "Five", "score": 97 },
        { "name": "Six", "score": 93 }
      ]
    }
  ]
}"""

    public static void main(String... strings){
        String findString="Six"
        JsonSlurper jsonSlurper = new JsonSlurper()
        def json = jsonSlurper.parseText(DUMMY_JSON)
        def list=[]
        json.skills.each{data->
            data.tests.each{
                mydata->list.add(mydata.name)
            }
        }
        println(list)
        assert list.contains(findString)
    }
}
