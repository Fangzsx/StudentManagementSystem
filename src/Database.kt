//database for storing valuable information
object Database{
    // accounts
    var accounts = mutableListOf<User>()

    // students info list
    var studentList = mutableListOf<Profile>()

    // list of names enrolled
    var enrolledList = mutableListOf<String>()
}