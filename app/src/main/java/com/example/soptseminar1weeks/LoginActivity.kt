package com.example.soptseminar1weeks

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.soptseminar1weeks.data.RequestLogin
import com.example.soptseminar1weeks.data.ResponseLogin
import kotlinx.android.synthetic.main.activity_login.*
import com.example.soptseminar1weeks.network.RequestToServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private val REGISTER_REQUEST_CODE = 0
    private var login_id:String=App.prefs.id
    private var login_pwd:String=App.prefs.pwd
    val requestToServer=RequestToServer // 싱글톤 그대로 가져옴

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
        if(et_id.text.isNullOrBlank()||et_password.text.isNullOrBlank()){
            Toast.makeText(this,"아이디와 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show()
        }else{
            //로그인 요청
            requestToServer.service.requestLogin(
                RequestLogin(
                    id=et_id.text.toString(),
                    password = et_password.text.toString()
                )// 로그인 정보를 전달
            ).enqueue(object : Callback<ResponseLogin> { // Callback등록. Retrofit의 Callback을 import 해줘야 함.
                override fun onFailure(call: Call<ResponseLogin>, t: Throwable){
                    // 통신 실패
                    Log.e("에러", t.toString())
                    Toast.makeText(this@LoginActivity, "로그인 통신 실패",
                        Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    //통신 성공
                    if(response.isSuccessful){ // statusCode가 200~300 사이일 때. 응답 body 이용 가능.
                        if(response.body()!!.success){ // ResponseLogin의 success가 true인 경우 -> 로그인
                            Toast.makeText(this@LoginActivity, "로그인 통신 성공", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this@LoginActivity, "아이디/비밀번호를 확인하세요!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    private fun requestData(){
        /*requestToServer.service.requestLogin(
            RequestLogin(
                id=et_id
            )
        )*/
    }
}