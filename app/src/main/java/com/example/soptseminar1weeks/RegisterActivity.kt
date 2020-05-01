package com.example.soptseminar1weeks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register_rg.setOnClickListener {
            /*if (et_password_rg.text.toString() == et_password_cf_rg.text.toString()){
                App.prefs.id = et_id_rg.text.toString()
                App.prefs.pwd = et_password_rg.text.toString()

                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show()
            }*/
            if (et_password_rg.text.toString() != et_password_cf_rg.text.toString()){
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show()
            }else if (et_password_rg.text.isNullOrEmpty()&& et_password_cf_rg.text.isNullOrEmpty()){
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show()
            }else{
                App.prefs.id = et_id_rg.text.toString()
                App.prefs.pwd = et_password_rg.text.toString()

                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
