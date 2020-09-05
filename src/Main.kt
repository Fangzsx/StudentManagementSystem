
fun main(){

    Home.showMainPage()

}

fun getCourse(code : Int) : Course{

    val courseList = Course.values()
    return courseList[code-1]
}

fun isExisting(name : String) : Boolean {
    return Database.enrolledList.contains(name)
}


