package com.example.smack.Services

import android.graphics.Color
import com.example.smack.Controller.App
import java.util.*

object UserDataService {
    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var email = ""
    var name = ""

    fun logout() {
        id = ""
        avatarColor = ""
        avatarName = ""
        email = ""
        name = ""
        App.prefs.authToken = ""
        App.prefs.userEmail = ""
        App.prefs.isLoggedIn = false
        MessageService.clearMessages()
        MessageService.clearChannels()
    }

    fun returnAvatarColor(components: String) : Int {
        val strippedColor = components
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")

        var red = 0
        var green = 0
        var blue = 0

        val scanner = Scanner(strippedColor)
        if (scanner.hasNext()) {
            red = createColor(scanner.nextDouble())
            green = createColor(scanner.nextDouble())
            blue = createColor(scanner.nextDouble())
        }
        return Color.rgb(red, green, blue)
    }

    private fun createColor(value: Double) : Int {
        return (value * 255).toInt()
    }
}