package com.example.aulia_mobile.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aulia_mobile.MainActivity
import com.example.aulia_mobile.R
import com.example.aulia_mobile.databinding.ActivityFourthBinding
import com.example.aulia_mobile.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_third)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)
//        val btnKirim: Button = findViewById(R.id.btnKirim)
        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age",0)
        Log.e("Data Intent","Nama: $name , Usia: $age, Asal: $from")
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//            val nomor = binding.inputNoTujuan.text
//            Toast.makeText(this, "Pesan berhasil dikirim ke $nomor", Toast.LENGTH_SHORT).show()
        }
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }

        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    finish()
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }
    }
}