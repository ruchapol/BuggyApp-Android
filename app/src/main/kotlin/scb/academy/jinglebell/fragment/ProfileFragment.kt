package scb.academy.jinglebell.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_profile.*
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.ProfileNextActivity

class ProfileFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        super.onCreate(savedInstanceState)

        val _view = inflater.inflate(R.layout.activity_profile, container, false)


        return _view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        inputName.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//
//                Log.d("input", "afterTextChanged:" + p0.toString())
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.d("input", "beforeTextChanged:" + p0.toString())
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.d("input", "onTextChanged:" + p0.toString())
//            }
//
//        })

        inputName.setOnEditorActionListener() {
            v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                //your code here
                Log.d("input", "IME_ACTION_DONE:" + v.text)
                val _intent = Intent(context, ProfileNextActivity::class.java)
                _intent.putExtra("nickName", v.text.toString())
                startActivity(_intent)
            }
            false
        }

//        actionDone

//        inputName.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
//            Log.d("onkey", view.toString())
//        }

    }



}