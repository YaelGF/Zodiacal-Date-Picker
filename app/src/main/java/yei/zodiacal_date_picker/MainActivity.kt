package yei.zodiacal_date_picker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etDate=findViewById<EditText>(R.id.etDate)
        etDate.setOnClickListener { showDatePickerDialog() }
    }
    private fun showDatePickerDialog(){
        val datePicker = DatePickerFragment({day, month, year -> onDateSelected(day, month, year)})
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected ( day:Int, month:Int, year:Int){
        zodiacal(day,month)

    }

    fun zodiacal(day: Int, month: Int){
        val etDate=findViewById<EditText>(R.id.etDate)

        val signo : List<String> =  listOf("Capricornio", "Acuario", "Piscis", "Aries", "Tauro","Geminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario")
        val fechas : List<Int> = listOf(20, 19, 20, 20, 21, 21, 22, 22, 22, 22, 22, 21)
        var mes = month
        if (day > fechas[mes]) {
            mes += 1
        }
        if (mes == 12) {
            mes = 0
        }
        etDate.setText("Tu signo es "+ signo[mes])
    }
}