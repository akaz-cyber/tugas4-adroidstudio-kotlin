package com.sttbandung.tugas4

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameuser = findViewById<EditText>(R.id.edtnama)
        val nomortelepon = findViewById<EditText>(R.id.telepon)
        val pilihtanggallahir = findViewById<Button>(R.id.pilihtanggal)
        val showtanggal = findViewById<EditText>(R.id.showtanggal)
        val showNameTextView = findViewById<TextView>(R.id.showname)
        val nomorTeleponShowTextView = findViewById<TextView>(R.id.nomortelephonshow)
        val tanggalShowTextView = findViewById<TextView>(R.id.tanggalshow)
        val submitbutton = findViewById<Button>(R.id.btnsubmit)

        pilihtanggallahir.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, monthOfYear, dayOfMonth ->
                    val selectedDate = "$dayOfMonth - ${monthOfYear + 1} - $selectedYear"
                    showtanggal.setText(selectedDate)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }


        submitbutton.setOnClickListener {
         val nameuser = nameuser.text.toString()
         val nomortelepon = nomortelepon.text.toString()
         val pilihtanggal = showtanggal.text.toString()
            val toastMessage = "terimakasih sudah mendaftarkan tanggal lahir"
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()

            showNameTextView.text = "Nama: $nameuser"
            nomorTeleponShowTextView.text = "Nomor Telepon: $nomortelepon"
            tanggalShowTextView.text = "Tanggal: $pilihtanggal"
        }

    }



}