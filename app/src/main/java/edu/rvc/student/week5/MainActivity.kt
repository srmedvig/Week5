package edu.rvc.student.week5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        //set focus on name
        txtName.requestFocus()

        //submit button
        btnSubmit.setOnClickListener{
            if (rbFemale.isChecked) txtShow.text = "Hello, ${txtName.text}, the women's lounge is on the first floor." +
                    " We will send an email of the meeting agenda to email: ${txtEmail.text}"
            if (rbMale.isChecked) txtShow.text = "Hello, ${txtName.text}, the men's lounge is on the second floor." +
                    " We will send an email of the meeting agenda to email: ${txtEmail.text}"
            hidekeyboard()
            txtName.setText("")
            txtEmail.setText("")
            txtName.requestFocus()
        }

    }

    //hide keyboard
    fun hidekeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }

}
