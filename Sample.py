class Employee:
    employeeGreetings = ""
    def __init__(self,name = "Sitakant"):
        self.employeeGreetings='Hi ! '+name


    def sayHello(self):
        print "Message , {0}".format(self.employeeGreetings)



if __name__ == '__main__':
    print "~~~~~~ Hello ~~~~~~"
    e = Employee('Me')
    e.sayHello()
