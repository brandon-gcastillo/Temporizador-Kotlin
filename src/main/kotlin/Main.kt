fun main()  {
    initializeTempo()
}

/*
* This function sanitize the introduced time
* from the user and instantiate a Tempo object
* by the given time.
* */
fun initializeTempo() {
    // Define a regular expression for the time input.
    val timeFormatRegex: Regex = Regex(pattern = "^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)\$")
    print("Insert the time on this format (hh:mm:ss): ")

    // Reads the time input from the user.
    val time = readLine()!!.trim()

    /*
    * Evaluates if the entered time have the right format,
    * otherwise, throws an exception.
    * */
    if (time.matches(timeFormatRegex)) {
        val splitTime: List<String> = time.split(":")

        // Evaluate if no missed parameters were entered (hh,mm,ss).
        if (splitTime.size < 3) throw Exception("Please use the correct format to start the timer.") else Tempo(splitTime).run()

    } else {
        throw Exception("Wrong format." +
                "\nExecute the timer with the correct format one more time.")
    }
}