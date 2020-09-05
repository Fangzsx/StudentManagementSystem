object Admin{

    fun home(){
        println("Welcome Admin!")
        println("Please choose an action to continue")
        println("[1] Login   [0] Signup")
        print("Select: ")
        val userChoice = readLine()!!.toInt()
        if(userChoice == 1)
            login()
        else signup()
    }
    // login for admin
    private fun login(){
        println("Log in")
        print("Username: ")
        val usernameAttempt : String = readLine()!!.toString()
        print("Password: ")
        val passwordAttempt : String = readLine()!!.toString()
        val userAttempt = User(usernameAttempt, passwordAttempt)
        if(!Database.accounts.contains(userAttempt)){
            println("Account does not Exist!")
            println("[1] Create a new Admin Account?   [0] Try to login again")
            val userChoice = readLine()!!.toInt()
            if(userChoice == 1){
                signup()
            }
            else login()
        }
        else println("Log in Successful!")
        Thread.sleep(1500)
        showAdminDashboard()
    }

    private fun showAdminDashboard(){
        println("Welcome Admin!")
        println("Please choose an action: ")
        println("[1] Add new Student")
        println("[2] Search a Student")
        println("[3] Edit Student Info")
        println("[4] Show all Enrolled students")
        println("[5] Exit to Main Menu")
        print("Select: ")
        val userChoice: Int = readLine()!!.toInt()
        when(userChoice){
            1 -> addNewStudent()
            2 -> searchStudent()
            3 -> editStudentInfo()
            4 -> showAllEnrolledStudents()
            5 -> exit()
        }
    }

    private fun exit(){
        println("Returning to Main Menu")
        print("Press enter to continue . . . ")
        readLine()
        Home.showMainPage()
    }

    // show all enrolled students
    private fun showAllEnrolledStudents(){
        println("Show all Enrolled Students")
        println("[1] Show names ONLY")
        println("[0] Show names WITH information")
        print("Select: ")
        val userChoice = readLine()!!.toInt()
        if(userChoice == 1){
            var counter = 1
            println("Showing names of Enrolled Students")
            for(names in Database.enrolledList){
                println("$counter: $names")
                counter++
            }
            print("Press enter to Return to Admin Dashboard . . .")
            readLine()
            showAdminDashboard()

        }
        else {
            println("Showing names of Enrolled Students with Information")
            for(student in Database.studentList){
                println("Name: ${student.name}")
                println("Course: ${student.course}")
                println("Age: ${student.age}")
                println("Address: ${student.address}")
                println("Email: ${student.email}")
                println("Contact Number: ${student.contactNumber}\n")
            }
            print("Press enter to Return to Admin Dashboard . . .")
            readLine()
            showAdminDashboard()
        }
    }



    // add a new student
    private fun addNewStudent(){

        println("Enroll a new Student")
        print("Enter Student name: ")
        val studentName = readLine()!!.toString()
        Database.enrolledList.add(studentName)
        println("Select Student's Course from the following: ")
        println("[1] BSCS\n[2] BSIT\n[3] BSBA\n[4] BSED")
        print("Select: ")
        val courseCode = readLine()!!.toInt()
        print("Age: ")
        val studentAge = readLine()!!.toInt()
        print("Address: ")
        val studentAddress = readLine()!!.toString()
        print("Email: ")
        val studentEmail = readLine()!!.toString()
        print("Contact Number: ")
        val studentContact = readLine()!!.toString()
        val newStudent =
            Profile(studentName, getCourse(courseCode), studentAge, studentAddress, studentEmail, studentContact)
        Database.studentList.add(newStudent)
        println("Student was successfully added!")
        print("Press enter to Return to Admin Dashboard . . .")
        readLine()
        showAdminDashboard()
    }

    // search student info
    private fun searchStudent(){

        println("Search")
        print("Please provide student name: ")
        val searchName = readLine()!!.toString()
        if (!Database.enrolledList.contains(searchName)){
            println("Student with name $searchName does not exist!")
            println("[1] Try to search again   [0] Return to Admin Dashboard")
            val userChoice = readLine()!!.toInt()
            if (userChoice == 1)
                searchStudent()
            else showAdminDashboard()
        }
        else {
            for (student in Database.studentList){
                if (student.name == searchName){
                    println("Student with name of ${searchName.toUpperCase()} was found!")
                    println("Student's name: ${student.name}")
                    println("Course: ${student.course}")
                    println("Age: ${student.age}")
                    println("Address: ${student.address}")
                    println("Email: ${student.email}")
                    println("Contact number: ${student.contactNumber}")
                }
            }
        }
        print("Press enter to return to Admin Dashboard . . ")
        readLine()
        showAdminDashboard()

    }

    // edit student info
    private fun editStudentInfo(){
        println("Edit Student Info")
        print("Please provide student's name: ")
        val searchName = readLine()!!.toString()
        if(isExisting(searchName)){
            println("Re-enter the following details for ${searchName.toUpperCase()}")
            for(student in Database.studentList){
                if(student.name == searchName){
                    println("Name: ")
                    student.name = readLine()!!.toString()
                    println("Select Student's Course from the following: ")
                    println("[1] BSCS\n[2] BSIT\n[3] BSBA\n[4] BSED")
                    val courseCode = readLine()!!.toInt()
                    student.course = getCourse(courseCode)
                    print("Age: ")
                    student.age = readLine()!!.toInt()
                    print("Address: ")
                    student.address = readLine()!!.toString()
                    print("Email: ")
                    student.email = readLine()!!.toString()
                    print("Contact number: ")
                    student.contactNumber = readLine()!!.toString()
                }

            }
            println("Student's info was successfully updated!")
            print("Press enter to return to Admin Dashboard . . .")
            readLine()
            showAdminDashboard()
        }
        else{
            println("Student with name ${searchName.toUpperCase()} was not found!")
            println("[1] Try to search other name   [0] Return to Admin Dashboard")
            print("Select: ")
            val userChoice = readLine()!!.toInt()
            if (userChoice == 1)
                searchStudent()
            else showAdminDashboard()
        }


    }

    // for signing up
    private fun signup(){
        println("Signup")
        print("New Username: ")
        val newUsername : String = readLine()!!.toString()
        print("Enter your password: ")
        val newPassword : String = readLine()!!.toString()
        val newAccount  = User(newUsername, newPassword)
        Database.accounts.add(newAccount)
        println("Account registration was successful!")
        print("Proceeding to Log-in . . .\n")
        Thread.sleep(2000)
        login()
    }
}