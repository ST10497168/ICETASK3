package vcmsa.ci.ice3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.core.view.isInvisible

private lateinit var rdGroup: RadioGroup
private lateinit var btinstall : Button
private lateinit var btrepairs : Button
private lateinit var btassamble : Button
private lateinit var btwoodenplnk : Button
private lateinit var btscrew : Button
private lateinit var btfastener : Button
private lateinit var ethours : EditText
private lateinit var btcalculate : Button
private lateinit var tvcost : TextView
private lateinit var materialCost: Int

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         enableEdgeToEdge()
         setContentView(R.layout.activity_main)
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
             val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
             insets
         }
         rdGroup = findViewById(R.id.rdGroup)
         btinstall = findViewById(R.id.btinstall)
         btrepairs = findViewById(R.id.btrepairs)
         btassamble = findViewById(R.id.btassamble)
         btwoodenplnk = findViewById(R.id.btwoodenplnk)
         btscrew = findViewById(R.id.btscrew)
         btfastener = findViewById(R.id.btfastener)
         ethours = findViewById(R.id.ethours)
         btcalculate = findViewById(R.id.btcalculate)
         tvcost = findViewById(R.id.tvcost)


         private fun calculateTotalCost(){
             var materialCost = 0

             if (btwoodenplnk.isActivated)
                 materialCost += 1000
             if (btscrew.isActivated)
                 materialCost += 500
             if (btfastener.isActivated)
                 materialCost += 250
             val hoursText =
                 ethours.text.toString()
             if (hoursText.isEmpty()){
                 Toast.makeText(this,"Please enter number of labour hours",Toast.LENGTH_SHORT).show()

                 return
             }
             val hours =
                 hoursText.toIntOrNull()
             if (hours == null || hours <= 0)
                 Toast.makeText(this,"Please enter positive number of hours",Toast.LENGTH_SHORT).show()

             return
         }
         if (!btfastener.isActivated && !btscrew.isActivated && !btwoodenplnk.isActivated){

             Toast.makeText(this,"Please select at least a single material", Toast.LENGTH_SHORT).show(){

                 return@show
             }
             if (rdGroup.isActivated == -1){
                 Toast.makeText(this,"Please select task.", Toast.LENGTH_SHORT).show()
                 return
             }
             val totalcost = materialCost * ethours
             tvcost.text = "Total estimated cost : R$totalcost"



         }         }










     }











