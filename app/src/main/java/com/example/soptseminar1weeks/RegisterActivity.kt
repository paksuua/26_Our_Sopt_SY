package com.example.soptseminar1weeks

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.soptseminar1weeks.data.RequestSignup
import com.example.soptseminar1weeks.data.ResponseLogin
import com.example.soptseminar1weeks.data.ResponseSignup
import com.example.soptseminar1weeks.network.RequestToServer
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register_rg.setOnClickListener {
            if (et_password_rg.text.toString() != et_password_cf_rg.text.toString()){
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show()
            }else if (et_password_rg.text.isNullOrEmpty()&& et_password_cf_rg.text.isNullOrEmpty()){
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show()
            }else{
                App.prefs.id = et_id_rg.text.toString()
                App.prefs.pwd = et_password_rg.text.toString()

                //TODO: 여기에 Register 통신 구현
                RequestToServer.service.requestSignup(
                    RequestSignup(
                        id=et_id_rg.text.toString(),
                        password = et_password_rg.text.toString(),
                        name=et_name_rg.text.toString(),
                        email=et_email_rg.text.toString(),
                        phone = et_phone_rg.text.toString()
                    ) // 회원가입 정보를 전달
                ).enqueue(object : Callback<ResponseSignup> { // Callback등록. Retrofit의 Callback을 import 해줘야 함.
                    override fun onFailure(call: Call<ResponseSignup>, t: Throwable) {
                        Log.e("에러", t.toString())
                        Toast.makeText(this@RegisterActivity, "회원가입 통신 실패",
                        Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseSignup>,
                        response: Response<ResponseSignup>
                    ) {
                        //통신 성공
                        if (response.isSuccessful) { // statusCode가 200~300 사이일 때. 응답 body 이용 가능.
                            if (response.body()!!.success) { // ResponseRegister의 success가 true인 경우 -> 회원가입
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "회원가입 통신 성공",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent =
                                    Intent(this@RegisterActivity, LoginActivity::class.java)
                                intent.putExtra("ID", et_id_rg.text.toString())
                                intent.putExtra("PASSWORD", et_password_rg.text.toString())
                                setResult(Activity.RESULT_OK, intent)
                                startActivityForResult(intent, 2)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "회원가입 정보를 확인하세요!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
    }
}
