class Student:
    name = ""
    age = 0

    def __init__(self,name,age):
        self.name=name
        self.age=age

    def getDetails(self):
        print "Details : [name="+self.name+" , age="+self.age+"]"



if __name__ == '__main__':
    data = {}

    for i in range(1,4):
        print "Enter the {0} student details ".format(i)
        name = raw_input("Enter student name ? ")
        age = raw_input("Enter student age ? ")
        student = Student(name,age)
        data[name] = student


    query = raw_input("Enter the student name to find details ? ")
    data[query].getDetails()

