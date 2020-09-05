// students main functions
object Student{
    var studentName = ""
    fun login() {
        println("Welcome Student!")
        print("Enter your name: ")
        studentName = readLine()!!.toString()
        // check if the student's name exist in the student list
        if (!Database.enrolledList.contains(studentName)){
            println("Your name does not exist in the enrolled list!")
            println("[1] Try to re-enter your name   [0] Return to Main Menu")
            print("Select: ")
            val userChoice = readLine()!!.toInt()
            if (userChoice == 1)
                login()
            else Home.showMainPage()
        }
        else showHome()

    }

    private fun showHome(){
        println("Welcome Student ${studentName.toUpperCase()}")
        println("Please choose your action: ")
        println("[1] Your Info")
        println("[2] Exit to Main Menu")
        print("Select: ")
        val userChoice = readLine()!!.toInt()
        if (userChoice == 1){
            for (student in Database.studentList){
                if (student.name == studentName){
                    println("Name: ${student.name}")
                    println("Course: ${student.course}")
                    println("Age: ${student.age}")
                    println("Address: ${student.address}")
                    println("Email: ${student.email}")
                    println("Contact Number: ${student.contactNumber}\n")
                }
            }
        }
        else {
            println("Returning to Main Menu")
            print("Press enter to continue . . .")
            readLine()
            Home.showMainPage()
        }


    }

}