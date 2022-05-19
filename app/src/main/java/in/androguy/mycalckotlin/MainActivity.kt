package `in`.androguy.mycalckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvOne).setOnClickListener{appendExpression("1",true)}
        findViewById<TextView>(R.id.tvTwo).setOnClickListener{appendExpression("2",true)}
        findViewById<TextView>(R.id.tvThree).setOnClickListener{appendExpression("3",true)}
        findViewById<TextView>(R.id.tvFour).setOnClickListener{appendExpression("4",true)}
        findViewById<TextView>(R.id.tvFive).setOnClickListener{appendExpression("5",true)}
        findViewById<TextView>(R.id.tvSix).setOnClickListener{appendExpression("6",true)}
        findViewById<TextView>(R.id.tvSeven).setOnClickListener{appendExpression("7",true)}
        findViewById<TextView>(R.id.tvEight).setOnClickListener{appendExpression("8",true)}
        findViewById<TextView>(R.id.tvNine).setOnClickListener{appendExpression("9",true)}
        findViewById<TextView>(R.id.tvZero).setOnClickListener{appendExpression("0",true)}
        findViewById<TextView>(R.id.tvDot).setOnClickListener{appendExpression(".",true)}

        findViewById<TextView>(R.id.tvPlus).setOnClickListener{appendExpression("+",false)}
        findViewById<TextView>(R.id.tvMinus).setOnClickListener{appendExpression("-",false)}
        findViewById<TextView>(R.id.tvMultiply).setOnClickListener{appendExpression("*",false)}
        findViewById<TextView>(R.id.tvDivision).setOnClickListener{appendExpression("/",false)}
        findViewById<TextView>(R.id.tvFirstBracket).setOnClickListener{appendExpression("(",false)}
        findViewById<TextView>(R.id.tvSecondBracket).setOnClickListener{appendExpression(")",false)}

        findViewById<TextView>(R.id.tvClearAll).setOnClickListener{
            findViewById<TextView>(R.id.tvExp).text=""
            findViewById<TextView>(R.id.tvResult).text=""
        }


        findViewById<TextView>(R.id.tvBack).setOnClickListener{
            val string= findViewById<TextView>(R.id.tvExp).text.toString()
            if (string.isNotEmpty()){
                findViewById<TextView>(R.id.tvExp).text=string.substring(0,string.length-1)
            }
            findViewById<TextView>(R.id.tvResult).text=""
        }

        findViewById<TextView>(R.id.tvEquals).setOnClickListener{
            try {

                val expression=ExpressionBuilder(findViewById<TextView>(R.id.tvExp).text.toString()).build()
                val result= expression.evaluate()
                val longResult= result.toLong()
                if (result==longResult.toDouble()){
                    findViewById<TextView>(R.id.tvResult).text=longResult.toString()
                }else{
                    findViewById<TextView>(R.id.tvResult).text=result.toString()
                }
            }catch (e: Exception){

            }
        }


    }

    fun appendExpression(str: String, clr: Boolean){

        if (findViewById<TextView>(R.id.tvResult).text.isNotEmpty()){
            findViewById<TextView>(R.id.tvExp).text=""
        }

        if (clr){
            findViewById<TextView>(R.id.tvResult).text=""
            findViewById<TextView>(R.id.tvExp).append(str)
        }else{
            findViewById<TextView>(R.id.tvExp).append(findViewById<TextView>(R.id.tvResult).text)
            findViewById<TextView>(R.id.tvExp).append(str)
            findViewById<TextView>(R.id.tvResult).text=""
        }
    }


}