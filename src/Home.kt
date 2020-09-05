object Home{
    //homepage
    fun showMainPage(){
        println("Student Information System")
        println("Select User Type")
        println("[1] Admin")
        println("[0] Student")
        print("Select: ")
        val userChoice : Int = readLine()!!.toInt()
        if (userChoice == 1)
            Admin.home()
        else Student.login()
    }
}