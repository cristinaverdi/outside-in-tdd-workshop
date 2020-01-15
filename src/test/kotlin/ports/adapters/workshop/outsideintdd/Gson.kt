package ports.adapters.workshop.outsideintdd

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import java.time.Instant
import java.time.format.DateTimeFormatter


object Gson {

    private val instantSerializer = JsonSerializer { instant: Instant, _, _ ->
        val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_INSTANT
        JsonPrimitive(dateTimeFormatter.format(instant))
    }

    val gson: Gson = GsonBuilder()
            .registerTypeAdapter(
                    Instant::class.java,
                    instantSerializer
            )
            .create()
}
