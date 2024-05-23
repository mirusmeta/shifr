package com.example.shifr

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var text:TextView = findViewById(R.id.text)
        val encryptionHelper = EncryptionHelper("Fg58ASPhU52vFg8A")
        val encrypt = encryptionHelper.encrypt("testemail@email.ru")
        val decrypt = encryptionHelper.decrypt(encrypt)
        text.text = "$encrypt\n\n$decrypt"
    }
}