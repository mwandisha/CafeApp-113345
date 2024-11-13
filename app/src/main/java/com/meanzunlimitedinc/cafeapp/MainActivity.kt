package com.meanzunlimitedinc.cafeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var mOrderMessage: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val fab: FloatingActionButton = findViewById(R.id.fab)
            fab.setOnClickListener {
                val intent = Intent(this, OrderActivity::class.java)
                intent.putExtra("orderMessage", mOrderMessage) // example data
                startActivity(intent)

            }
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }
          }
    //Display a toast message
    private fun displayToast(message:String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
    //Show a message that the donut image was clicked
     fun showDonutOrder(view : View){
         mOrderMessage = "You ordered a donut"
         displayToast(mOrderMessage)
     }

    //Show a message that the ice cream sandwich image was clicked
    fun showIceCreamOrder(view : View){
        mOrderMessage = "You ordered an Ice Cream sandwich"
        displayToast(mOrderMessage)
    }

    //Show a message that the froyo image was clicked
    fun showFroyoOrder(view : View){
        mOrderMessage = "Froyo is premium self-serve frozen yoghurt"
        displayToast(mOrderMessage)
    }


}