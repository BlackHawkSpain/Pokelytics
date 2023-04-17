package study.project.pokelytics.api

import android.util.Log
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun <T> getUrlObject(url: URL, classOfT: Class<T>): T {
    val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"
    val inputStream: InputStream = connection.inputStream
    val reader = BufferedReader(InputStreamReader(inputStream))
    val response = reader.readText()
    return try {
        Gson().fromJson(response, classOfT)
    } catch (e: Exception) {
        Log.e("Pokemon Error", "Error parsing pokemon: $url")
        throw e
    }
}

fun <T> getUrlObjectReplace(url: URL, classOfT: Class<T>): T {
    val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"
    val inputStream: InputStream = connection.inputStream
    val reader = BufferedReader(InputStreamReader(inputStream))
    val response = reader.readText().replace("-", "_")
    return Gson().fromJson(response, classOfT)
}