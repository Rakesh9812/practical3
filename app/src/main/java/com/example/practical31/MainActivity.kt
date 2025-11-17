package com.example.practical31

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.login).setOnClickListener {
            val show = Intent(this, login::class.java)
            startActivity(show)
        }
        findViewById<Button>(R.id.browse).setOnClickListener {
            val url = findViewById<EditText>(R.id.editText1).text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        findViewById<Button>(R.id.phone).setOnClickListener {
            val tel= findViewById<EditText>(R.id.editText2).text.toString()
            val intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:" +tel))
            startActivity(intent)
        }
        findViewById<Button>(R.id.galley).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"))
            startActivity(intent)
        }
        findViewById<Button>(R.id.call).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"))
            startActivity(intent)
        }
        findViewById<Button>(R.id.camera).setOnClickListener {
            val intent = Intent( android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)

        }
        findViewById<Button>(R.id.alarm).setOnClickListener {
            val intent = Intent(android.provider.AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        }


    }
}