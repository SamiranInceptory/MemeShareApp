package com.example.android.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android.msgshareapp.R
import com.example.android.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
//        val TAG : String = "MainActivity"
        val TAG : String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShowToast.setOnClickListener {
            Log.i(TAG, "Clicked")
            showToast(getString(R.string.button_clicked), Toast.LENGTH_LONG)
//            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }

        btnSendThisToNextActivity.setOnClickListener{
            val message: String = editUserMassage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", message)
            startActivity(intent)
        }

        shareToOtherApps.setOnClickListener {
            val message: String = editUserMassage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra( Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To"))
        }

        recyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}