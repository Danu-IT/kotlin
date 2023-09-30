package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findButtonById(R.id.btn_0).setOnClickListener{ setTextFields("0") }
        findButtonById(R.id.btn_1).setOnClickListener{ setTextFields("1") }
        findButtonById(R.id.btn_2).setOnClickListener{ setTextFields("2") }
        findButtonById(R.id.btn_3).setOnClickListener{ setTextFields("3") }
        findButtonById(R.id.btn_4).setOnClickListener{ setTextFields("4") }
        findButtonById(R.id.btn_5).setOnClickListener{ setTextFields("5") }
        findButtonById(R.id.btn_6).setOnClickListener{ setTextFields("6") }
        findButtonById(R.id.btn_7).setOnClickListener{ setTextFields("7") }
        findButtonById(R.id.btn_8).setOnClickListener{ setTextFields("8") }
        findButtonById(R.id.btn_9).setOnClickListener{ setTextFields("9") }

        findButtonById(R.id.btn_add).setOnClickListener{setTextFields("+")}
        findButtonById(R.id.btn_mult).setOnClickListener{setTextFields("*")}
        findButtonById(R.id.btn_sub).setOnClickListener{setTextFields("-")}
        findButtonById(R.id.btn_division).setOnClickListener{setTextFields("/")}
        findButtonById(R.id.btn_rigth).setOnClickListener{setTextFields(")")}
        findButtonById(R.id.btn_left).setOnClickListener{setTextFields("(")}

        findButtonById(R.id.btn_AC).setOnClickListener{ // Удаление всех полей
            findButtonById(R.id.math_operation).text = ""
            findButtonById(R.id.math_result).text = ""
        }

        findButtonById(R.id.btn_back).setOnClickListener{// Возврат назад
            val str: String = findButtonById(R.id.math_operation).text.toString()
            if(str.isNotEmpty()){
                findButtonById(R.id.math_operation).text = str.substring(0, str.length - 1)
            }

            findButtonById(R.id.math_result).text = ""
        }

        findButtonById(R.id.btn_equally).setOnClickListener{ // =
            try{
                val str: String = findButtonById(R.id.math_operation).text.toString()
                val ex = ExpressionBuilder(str).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble()){
                    findButtonById(R.id.math_result).text = longRes.toString()
                } else {
                    findButtonById(R.id.math_result).text = result.toString()
                }


            } catch (e: Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun findButtonById(id: Int) = findViewById<TextView>(id)

    fun setTextFields(string: String){
        if (findButtonById(R.id.math_result).text != ""){
            findButtonById(R.id.math_operation).text = findButtonById(R.id.math_result).text
            findButtonById(R.id.math_result).text = ""
        }
        findButtonById(R.id.math_operation).append(string)
    }

}