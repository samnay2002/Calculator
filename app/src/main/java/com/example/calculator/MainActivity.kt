package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var isnewop=true
    var oldnumber=" "
    var op=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }                                                       //last video in 19.50

    fun numberEvent(view: View) {
        if(isnewop)
            editText.setText(" ")
        isnewop=false
        var bunclick=editText.text.toString()
        var buselect=view as Button
        when(buselect.id){
            bu1.id->{bunclick += "1"}
            bu2.id->{bunclick += "2"}
            bu3.id->{bunclick += "3"}
            bu4.id->{bunclick += "4"}
            bu5.id->{bunclick += "5"}
            bu6.id->{bunclick += "6"}
            bu7.id->{bunclick += "7"}
            bu8.id->{bunclick += "8"}
            bu9.id->{bunclick += "9"}
            bu0.id->{bunclick += "0"}
            buDot.id->{bunclick+="."}
            buPlusMinus.id->{bunclick = "-$bunclick"}
        }
        editText.setText((bunclick))
    }

    fun operaterEvent(view: View)
    {
        isnewop=true
        oldnumber=editText.text.toString()
        var bunselect=view as Button
        when(bunselect.id)
        {
            buMultiply.id->{op="*"}
            buPlus.id->{op="+"}
            buDivide.id->{op="/"}
            buMinus.id->{op="-"}
        }

    }

    fun equalevent(view: View)
    {
        var newnumber=editText.text.toString()
        var result=0.0
        when(op)
        {
            "+"->{result=oldnumber.toDouble() + newnumber.toDouble()}
            "-"->{result=oldnumber.toDouble() - newnumber.toDouble()}
            "*"->{result=oldnumber.toDouble() * newnumber.toDouble()}
            "/"->{result=oldnumber.toDouble() / newnumber.toDouble()}
            " "->{
                Toast.makeText(this,"plese enter the operator or next value", Toast.LENGTH_SHORT).show()
                result=newnumber.toDouble()}

//            Toast.makeText(this,"plese enter the operator or next value", Toast.LENGTH_LONG).show()
        }
        op=" "
        editText.setText((result.toString()))

    }

    fun acEvent(view: View) {
        editText.setText("0")
        isnewop=true
    }

    fun percentevent(view: View) {
        var no=editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isnewop=true
    }
}