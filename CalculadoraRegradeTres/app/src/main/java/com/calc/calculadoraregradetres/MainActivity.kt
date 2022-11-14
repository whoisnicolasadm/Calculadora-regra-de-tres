package com.calc.calculadoraregradetres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.calc.calculadoraregradetres.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            isValid()
        }
    }


    private fun isValid(){
        if(binding.A.text.toString() != "" && binding.B.text.toString() != "" && binding.C.text.toString() != "" ){
            if(binding.A.text.toString().toFloat() == 0f || binding.B.text.toString().toFloat() == 0f || binding.C.text.toString().toFloat() == 0f){
                Toast.makeText(this, "As variaveis nao podem ser iguais a ZERO", Toast.LENGTH_LONG).show()
            }else{
                calculate()
            }

        }else{
            Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_LONG).show()
        }
    }

    private fun calculate(){
        val a: Float = binding.A.text.toString().toFloat()
        val b: Float = binding.B.text.toString().toFloat()
        val c: Float = binding.C.text.toString().toFloat()
        val x = (b * c) / a
        val xStr = "${"%.2f".format(x)}"
        binding.X.setText(xStr)
    }

}





