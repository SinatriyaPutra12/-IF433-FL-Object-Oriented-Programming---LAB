package oop_00000070427_sinatriyaariaputra.week08

class NotificationService {
    fun sendEmail(emailAddress: String) {
        println("Mengirim email ke: emailAddress")
    }

    fun processUser(user: UserProfile) {
        // sendEmail(user.email) // INI AKAN ERROR: Type mismatch

        if (user.email != null) {
            // SUCCESS via Smart Cast: compiler tahu 'user.email' pasti tidak null di blok ini
            sendEmail(emailAddress = user.email)
        } else {
            println("User {user.name} tidak memiliki email.")
        }
    }
}
