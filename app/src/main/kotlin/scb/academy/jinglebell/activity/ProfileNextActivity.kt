package scb.academy.jinglebell.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_next_profile.*
import scb.academy.jinglebell.R


class ProfileNextActivity : AppCompatActivity() {

    lateinit var mNickname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_profile)



        nickNameLab.setText(mNickname)

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {


        mNickname = intent.getStringExtra("nickName")

        Log.d("nickNameP2", mNickname)


        return super.onCreateView(name, context, attrs)

    }




}