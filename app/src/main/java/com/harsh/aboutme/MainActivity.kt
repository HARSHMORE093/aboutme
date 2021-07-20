package com.harsh.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.harsh.aboutme.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName= MyName()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myname= MyName()

//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }


private fun addNickname(view: View){
//    val editText=findViewById<EditText>(R.id.nickname_edit)
//    val nicknametextView=findViewById<TextView>(R.id.nickname_text)
//
//    nicknametextView.text=editText.text
//    editText.visibility=View.GONE                   //text hide jaha likh raha the
//    view.visibility=View.GONE                       //esse button ko hide kar deya
//    nicknametextView.visibility=View.VISIBLE        //visible ho gaye ga vapis


    binding.apply {
//        nicknameText.text=binding.nicknameEdit.text
        myname?.nickname=nicknameEdit.text.toString()
        invalidateAll()
        nicknameEdit.visibility=View.GONE
        doneButton.visibility=View.GONE
        nicknameText.visibility=View.VISIBLE
    }

    // Hide the keyboard.
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

}


