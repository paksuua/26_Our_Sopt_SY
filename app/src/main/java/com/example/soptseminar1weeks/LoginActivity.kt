package com.example.soptseminar1weeks

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import android.content.SharedPreferences
import android.provider.Telephony.Mms.Part.FILENAME
import android.view.View
import kotlinx.android.synthetic.main.activity_cst_img.*

class LoginActivity : AppCompatActivity() {
    private val REGISTER_REQUEST_CODE = 0
    private var login_id:String=App.prefs.id
    private var login_pwd:String=App.prefs.pwd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_id.setText(login_id)
        et_password.setText( login_pwd)

        btn_login.setOnClickListener {
            checkUserInfo()
        }
        tv_register.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==REGISTER_REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                when (requestCode) {
                    2 -> {
                        login_id=data!!.getStringExtra("ID").toString()
                        login_pwd=data!!.getStringExtra("PASSWORD").toString()
                    }
                }
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun checkUserInfo(){
        /*if (App.prefs.id!=login_id || App.prefs.pwd!=login_pwd){
            Toast.makeText(this, "없는 사용자 정보입니다.", Toast.LENGTH_LONG).show()
        }
*/
        if(et_id.text.isNullOrBlank()||et_password.text.isNullOrBlank()){
            Toast.makeText(this,"아이디와 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }
    }
}