package com.example.tesgisting

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.example.tesgisting.databinding.FragmentPertnnBinding
import com.example.tesgisting.model.GistingRespons
import com.example.tesgisting.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class PertnnFragment : Fragment() {
    private lateinit var bind: FragmentPertnnBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentPertnnBinding.inflate(inflater, container, false)
        bind.ivDatetime.load(R.drawable.ic_launcher_background)
        bind.ivPh.load(R.drawable.ic_launcher_background)
        bind.ivTds.load(R.drawable.ic_launcher_background)
        bind.ivRain.load(R.drawable.ic_launcher_background)
        bind.ivSuhuAir.load(R.drawable.ic_launcher_background)
        bind.ivWinddir.load(R.drawable.ic_launcher_background)
        bind.ivWindspeed.load(R.drawable.ic_launcher_background)
        bind.ivWaterflow1.load(R.drawable.ic_launcher_background)
        bind.ivWaterflow2.load(R.drawable.ic_launcher_background)
        bind.ivWaterflow3.load(R.drawable.ic_launcher_background)
        bind.ivWaterflow4.load(R.drawable.ic_launcher_background)
        bind.ivBerat.load(R.drawable.ic_launcher_background)
        bind.ivSuhu.load(R.drawable.ic_launcher_background)
        bind.ivTekananUdara.load(R.drawable.ic_launcher_background)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                loadData()
                Handler().postDelayed(this, 1000)
            }
        }, 1000)
    }

    private fun loadData(){
        RetrofitClient.apiVPSInstance
            .getGisting()
            .enqueue(object : Callback<GistingRespons> {
                @SuppressLint("SimpleDateFormat")
                override fun onResponse(
                    call: Call<GistingRespons>,
                    response: Response<GistingRespons>
                ) {
                    response.body()?.let {
                        val sensor = it.result[0]
                        val formattedDate = SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(
                            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(sensor.datetime))
                        bind.tvDatetime.text=formattedDate
                        bind.tvHumidity280.text=sensor.humidity280.toString()
                        bind.tvTds.text=sensor.pressure280.toString()
                        bind.tvRain.text=sensor.temperature280.toString()
                        bind.tvSuhuAir.text=sensor.temperature388.toString()
                        bind.tvWinddir.text=sensor.pressure388.toString()
                        bind.tvWindspeed.text=sensor.phsensor.toString()
                        bind.tvWaterflow1.text=sensor.tdssensor.toString()
                        bind.tvWaterflow2.text=sensor.moisturesensor.toString()
                        bind.tvWaterflow3.text=sensor.anemometer.toString()
                        bind.tvWaterflow4.text=sensor.windvane.toString()
                        bind.tvBerat.text=sensor.currentsensor.toString()
                        bind.tvSuhu.text=sensor.rainintensity.toString()
                        bind.tvTekananUdara.text=sensor.rainstatus.toString()
                    }
                }
                override fun onFailure(call: Call<GistingRespons>, t: Throwable) {
                    t.message?.let {
                        Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}