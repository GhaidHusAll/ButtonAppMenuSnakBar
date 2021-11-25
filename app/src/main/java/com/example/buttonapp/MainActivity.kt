package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var numberTV : TextView
    private lateinit var clMain : ConstraintLayout
    lateinit var addBTN : Button
    lateinit var subBTN : Button
    private var mainNumber = 0
    val colors = listOf("blue","green","red","black","pink","grey","yellow","orange" , "white","purple")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clMain = findViewById(R.id.Main)
        addBTN = findViewById(R.id.btnADD)
        subBTN = findViewById(R.id.btnSUB)
        numberTV = findViewById(R.id.tvNumber)
        addBTN.setOnClickListener {
            addClicked()
        }
        subBTN.setOnClickListener {
            subClicked()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.hiItem -> {
                Snackbar.make(clMain, "Hello there!", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.reset -> {
                mainNumber = 0
                numberTV.setTextColor(Color.BLACK)
                numberTV.text = mainNumber.toString()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun addClicked(){
        mainNumber++
        numberTV.text = mainNumber.toString()
        when {
            mainNumber > 0 -> {
                numberTV.setTextColor(Color.GREEN)
            }
            mainNumber == 0 -> {
                numberTV.setTextColor(Color.BLACK)
            }
        }
    }

    private fun subClicked(){
        mainNumber--
        numberTV.text = mainNumber.toString()
        when {
            mainNumber < 0 -> {
                numberTV.setTextColor(Color.RED)
            }
            mainNumber == 0 -> {
                numberTV.setTextColor(Color.BLACK)
            }
        }
    }
}