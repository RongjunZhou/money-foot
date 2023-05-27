package cn.edu.njupt.moneyfoot

import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Calendar
import java.util.Date

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val calendar: Calendar = Calendar.getInstance()
        println(Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 0).time)
        println(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli())
    }
}

