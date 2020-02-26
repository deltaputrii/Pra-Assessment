package com.d3if4201.praassessment


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.d3if4201.praassessment.databinding.FragmentPersegipanjangBinding
import kotlinx.android.synthetic.main.fragment_persegipanjang.*

/**
 * A simple [Fragment] subclass.
 */
class PersegiPanjang(val root: View?) : Fragment() {
    private lateinit var binding: FragmentPersegipanjangBinding
    private var panjang: Double = 0.00
    private var lebar: Double = 0.00
    private var luas: Double = 0.00
    private var keliling: Double = 0.00

    companion object{
        const val KEY_LUAS = "key_luas"
        const val KEY_KELILING = "key_keliling"
    }
    @SuppressLint
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persegipanjang, container, false)
        if (savedInstanceState != null) {
            luas = savedInstanceState.getDouble(KEY_LUAS)
            keliling = savedInstanceState.getDouble((KEY_KELILING))

        }
        binding.btnHitungPP.setOnClickListener {
            if (binding.etPanjang.text.toString().isEmpty() || binding.etLebar.text.toString().isEmpty()) {
                Toast.makeText(this.activity, "Field tidak boleh kosong!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                panjang = binding.etPanjang.text.toString().toDouble()
                lebar = binding.etLebar.text.toString().toDouble()
                luas = panjang * lebar
                keliling = 2 * (panjang + lebar)
                binding.tvLuasPP.text = "Luas = $luas"
                binding.tvKelilingPP.text = "Keliling = $keliling"
            }
        }

        binding.btnSharePersegiPanjang.setOnClickListener {
            val luasPersegiPanjang = tvLuasPP.text.toString()
            val kelilingPersegiPanjang = tvKelilingPP.text.toString()
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, luasPersegiPanjang + "\n" + kelilingPersegiPanjang)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Hasil hitung persegi panjang")
            startActivity(Intent.createChooser(shareIntent, "Share text via..."))
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble(KEY_LUAS, luas)
        outState.putDouble(KEY_KELILING, keliling)
    }

    @SuppressLint
    private fun updateNilai(a: Double, b: Double) {
        binding.tvLuasPP.setText("Luas =" + a.toString())
        binding.tvKelilingPP.setText("Keliling =" + b.toString())
    }
}
