package aneeb.practice.dobcalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        btnDatePicker.setOnClickListener {

            clickDatePicker()
        }
    }

    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{view, selectedYear,selectedMonth,selectedDayOfMonth ->
            Toast.makeText(this,"Date Picker Pressed",Toast.LENGTH_LONG).show()


            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

            tvSelectedDate?.text = selectedDate;

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)




        },
            year,
            month,
            day

            ).show()


    }
}