package dev.minage.calculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tilNumOne: TextInputLayout
    lateinit var etNumOne : TextInputEditText
    lateinit var tilNumTwo: TextInputLayout
    lateinit var etNumTwo:TextInputEditText
    lateinit var btnAdd:Button
    lateinit var btnSubtract: Button
    lateinit var btnModulus: Button
    lateinit var btnDivision:Button
    lateinit var tvStatus:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castView()
    }

    fun castView(){
        tilNumOne = findViewById(R.id.tilNumOne)
        etNumOne = findViewById(R.id.etNumOne)
        tilNumTwo = findViewById(R.id.tilNumTwo)
        etNumTwo = findViewById(R.id.etNumTwo)
        tvStatus = findViewById(R.id.tvStatus)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val a= etNumOne.text.toString()
            val b = etNumTwo.text.toString()
            validation()
            putTogether(a.toInt(),b.toInt())
        }
        btnDivision = findViewById(R.id.btnDivision)
        btnDivision.setOnClickListener {
            val a = etNumOne.text.toString()
            val b = etNumTwo.text.toString()
            validation()
            divide(a.toInt(),b.toInt())

        }
        btnModulus = findViewById(R.id.btnModulus)
        btnModulus.setOnClickListener {
            val a = etNumOne.text.toString()
            val b = etNumTwo.text.toString()
            validation()
            modulus(a.toInt(),b.toInt())


        }
        btnSubtract = findViewById(R.id.btnSubtract)
        btnSubtract.setOnClickListener {
            val a = etNumOne.text.toString()
            val b = etNumTwo.text.toString()
            validation()
            difference(a.toInt(),b.toInt())
        }
    }

    fun validation(){
        var error = false
        tilNumOne.error = null
        tilNumTwo.error = null
        val numOne = etNumOne.text.toString()
        val numTwo= etNumTwo.text.toString()

        if (numOne.isBlank()){
            tilNumOne.error = "Enter first number"
            error = true
        }
        if (numTwo.isBlank()){
            tilNumTwo.error = "Enter second number"
            error = true
}
    }
    fun putTogether(numOne: Int, numTwo: Int){
        val add = numOne + numTwo
        tvStatus.text = add.toString()
    }
    fun difference(numOne: Int,numTwo: Int){
        val subtract = numOne-numTwo
        tvStatus.text = subtract.toString()
    }
    fun divide(numOne: Int,numTwo: Int){
        val div= numOne/numTwo
        tvStatus.text = div.toString()
    }
    fun modulus(numOne: Int,numTwo: Int){
        val remainder= numOne%numTwo
        tvStatus.text = remainder.toString()
    }

}