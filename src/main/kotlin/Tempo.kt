class Tempo (private val formattedTime: List<String>) {
    private var hours = formattedTime[0].toInt()
    private var minutes = formattedTime[1].toInt()
    private var seconds = formattedTime[2].toInt()

    private fun restHours() {
        hours -= 1
    }
    private fun updateHours(newHours: Int) {
        hours = newHours
    }
    private fun restMinutes() {
        minutes -= 1
    }
    private fun updateMinutes() {
        minutes = 59
    }
    private fun restSeconds() {
        seconds -= 1
    }
    private fun updateSeconds() {
        seconds = 59
    }
    private fun getTimeString() {
        val currentTime: String = "Time: " +
                "${if ((hours) < 10) "0${hours}" else hours}:" +
                "${if((minutes) < 10) "0${minutes}" else minutes}:" +
                "${if(seconds < 10) "0$seconds" else seconds}"
        println(currentTime)
    }

    fun run() {
        getTimeString()
        println("\n")
        if (hours > 0)
        {
            while (hours > 0)
            {
                if (minutes == 0 && seconds == 0) {
                    Thread.sleep(1000)
                    getTimeString()
                    updateMinutes()
                    updateSeconds()
                    restHours()
                }
                while (minutes > 0 || hours > 0)
                {
                    if((minutes == 0) && (seconds == 0))
                    {
                        Thread.sleep(1000)
                        getTimeString()
                        updateMinutes()
                        updateSeconds()
                        restHours()
                    }
                    if (seconds == 0)
                    {
                        Thread.sleep(1000)
                        getTimeString()
                        updateSeconds()
                        restMinutes()
                    }
                    while (seconds > 0)
                    {
                        Thread.sleep(1000)
                        getTimeString()
                        restSeconds()
                    }
                }
            }
        } else if (minutes > 0) {
            while (minutes > 0)
            {
                if (seconds == 0) {
                    updateSeconds()
                    restMinutes()
                }
                while (seconds > 0)
                {
                    Thread.sleep(1000)
                    getTimeString()
                    restSeconds()
                }
            }
        } else {
            while (seconds > 0)
            {
                Thread.sleep(1000)
                getTimeString()
                restSeconds()
            }
        }
    }
}