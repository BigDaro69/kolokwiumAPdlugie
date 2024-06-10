package com.example.kolos6

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kolos6.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var pK = 0
    private var pM = 0

    private var wiek = 0
    private var waga : Double = 0.0
    private var wzrost : Double = 0.0

    private var aktywnosc : Double = 0.0

    private var wynik : Double = 0.0
    private var wynik2 : String = ""

    private var ppm : Double = 0.0
    private var ppm2 : String = ""

    private var cpm : Double = 0.0
    private var cpm2 : String = ""

    private var wartosci = arrayOf("1 - Brak aktywności","2 - Bardzo lekka aktywność","3 - Lekka aktywność","4 - Średnia aktywność","5 - Duża aktywność","6 - Bardzo duża aktywność")

    private var licznik = 0
    private var drugieOk = arrayOf<String>("","","")
    private var historia = arrayOf<String>("","","","","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,wartosci)
        binding.spinner.adapter = adapter
        binding.spinner.setSelection(0,false)



        binding.grupaPlec.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.plecK){
                pK = 1
                pM = 0
            }else if(checkedId == R.id.plecM){
                pK = 0
                pM = 1
            }

        }

        binding.oblicz.setOnClickListener(){
            licznik++

            wiek = binding.wiekText.text.toString().toInt()
            waga = binding.wagaText.text.toString().toDouble()
            wzrost = binding.wzrostText.text.toString().toDouble()
            wzrost = wzrost / 100

            if(binding.spinner.selectedItemPosition == 0){
                if(pK == 1){
                    aktywnosc = 1.2
                }else if(pM==1){
                    aktywnosc = 1.2
                }

                wynik = bmi(waga,wzrost)
                wynik2 = String.format("%.2f",wynik)
                Toast.makeText(applicationContext,"BMI: "+wynik2,Toast.LENGTH_SHORT).show()

                ppm = ppm(waga,wzrost,wiek)
                ppm2 = String.format("%.2f",ppm)
                Toast.makeText(applicationContext,"PPM: "+ppm2,Toast.LENGTH_SHORT).show()

                cpm = cpm(ppm,aktywnosc)
                cpm2 = String.format("%.2f",cpm)
                Toast.makeText(applicationContext,"CPM: "+cpm2,Toast.LENGTH_SHORT).show()

            }else if(binding.spinner.selectedItemPosition == 1){

                if(pK == 1){
                    aktywnosc = 1.3
                }else if(pM==1){
                    aktywnosc = 1.3
                }

                wynik = bmi(waga,wzrost)
                wynik2 = String.format("%.2f",wynik)
                Toast.makeText(applicationContext,"BMI: "+wynik2,Toast.LENGTH_SHORT).show()

                ppm = ppm(waga,wzrost,wiek)
                ppm2 = String.format("%.2f",ppm)
                Toast.makeText(applicationContext,"PPM: "+ppm2,Toast.LENGTH_SHORT).show()

                cpm = cpm(ppm,aktywnosc)
                cpm2 = String.format("%.2f",cpm)
                Toast.makeText(applicationContext,"CPM: "+cpm2,Toast.LENGTH_SHORT).show()


            }else if(binding.spinner.selectedItemPosition == 2){

                if(pK == 1){
                    aktywnosc = 1.5
                }else if(pM==1){
                    aktywnosc = 1.6
                }
                wynik = bmi(waga,wzrost)
                wynik2 = String.format("%.2f",wynik)
                Toast.makeText(applicationContext,"BMI: "+wynik2,Toast.LENGTH_SHORT).show()

                ppm = ppm(waga,wzrost,wiek)
                ppm2 = String.format("%.2f",ppm)
                Toast.makeText(applicationContext,"PPM: "+ppm2,Toast.LENGTH_SHORT).show()

                cpm = cpm(ppm,aktywnosc)
                cpm2 = String.format("%.2f",cpm)
                Toast.makeText(applicationContext,"CPM: "+cpm2,Toast.LENGTH_SHORT).show()



            }else if(binding.spinner.selectedItemPosition == 3){

                if(pK == 1){
                    aktywnosc = 1.6
                }else if(pM==1){
                    aktywnosc = 1.7
                }
                wynik = bmi(waga,wzrost)
                wynik2 = String.format("%.2f",wynik)
                Toast.makeText(applicationContext,"BMI: "+wynik2,Toast.LENGTH_SHORT).show()

                ppm = ppm(waga,wzrost,wiek)
                ppm2 = String.format("%.2f",ppm)
                Toast.makeText(applicationContext,"PPM: "+ppm2,Toast.LENGTH_SHORT).show()

                cpm = cpm(ppm,aktywnosc)
                cpm2 = String.format("%.2f",cpm)
                Toast.makeText(applicationContext,"CPM: "+cpm2,Toast.LENGTH_SHORT).show()



            }else if(binding.spinner.selectedItemPosition == 4){

                if(pK == 1){
                    aktywnosc = 1.9
                }else if(pM==1){
                    aktywnosc = 2.1
                }

                wynik = bmi(waga,wzrost)
                wynik2 = String.format("%.2f",wynik)
                Toast.makeText(applicationContext,"BMI: "+wynik2,Toast.LENGTH_SHORT).show()

                ppm = ppm(waga,wzrost,wiek)
                ppm2 = String.format("%.2f",ppm)
                Toast.makeText(applicationContext,"PPM: "+ppm2,Toast.LENGTH_SHORT).show()

                cpm = cpm(ppm,aktywnosc)
                cpm2 = String.format("%.2f",cpm)
                Toast.makeText(applicationContext,"CPM: "+cpm2,Toast.LENGTH_SHORT).show()


            }else if(binding.spinner.selectedItemPosition == 5){

                if(pK == 1){
                    aktywnosc = 2.2
                }else if(pM==1){
                    aktywnosc = 2.4
                }
                wynik = bmi(waga,wzrost)
                wynik2 = String.format("%.2f",wynik)
                Toast.makeText(applicationContext,"BMI: "+wynik2,Toast.LENGTH_SHORT).show()

                ppm = ppm(waga,wzrost,wiek)
                ppm2 = String.format("%.2f",ppm)
                Toast.makeText(applicationContext,"PPM: "+ppm2,Toast.LENGTH_SHORT).show()

                cpm = cpm(ppm,aktywnosc)
                cpm2 = String.format("%.2f",cpm)
                Toast.makeText(applicationContext,"CPM: "+cpm2,Toast.LENGTH_SHORT).show()



            }else{
                Toast.makeText(applicationContext,"Wybierz poziom aktywności",Toast.LENGTH_LONG).show()
            }

            drugieOk[0] = "BMI: "+ wynik2
            drugieOk[1] = "PPM: "+ ppm2
            drugieOk[2] = "CPM: "+ cpm2

            if(licznik == 1){
                historia[0] = "BMI: "+ wynik2
                historia[1] = "PPM: "+ ppm2
                historia[2] = "CPM: "+ cpm2

            }else if(licznik == 2){
                historia[3] = "BMI: "+ wynik2
                historia[4] = "PPM: "+ ppm2
                historia[5] = "CPM: "+ cpm2

            }else if(licznik == 3){
                historia[6] = "BMI: "+ wynik2
                historia[7] = "PPM: "+ ppm2
                historia[8] = "CPM: "+ cpm2

            }

        }


        binding.drugieOkno.setOnClickListener(){
            val intent = Intent(this,DrugieOkno::class.java).also{
                it.putExtra("a",drugieOk[0])
                it.putExtra("b",drugieOk[1])
                it.putExtra("c",drugieOk[2])
            }
            startActivity(intent)
        }

        binding.historia.setOnClickListener(){
            val intent = Intent(this,Historia::class.java).also{
                it.putExtra("a",historia[0])
                it.putExtra("b",historia[1])
                it.putExtra("c",historia[2])
                it.putExtra("d",historia[3])
                it.putExtra("e",historia[4])
                it.putExtra("f",historia[5])
            }
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun bmi(masa:Double,wzrost:Double):Double{
        val bmi = masa / wzrost.pow(2)
        return  bmi
    }

    public fun ppm(masa:Double,wzrost:Double,wiek:Int):Double{
        val ppm = (10*masa) + (6.25*wzrost*100)-(5*wiek)+5
        return ppm
    }
    public fun cpm(ppm:Double,akt:Double):Double{
        val cpm = ppm*akt
        return cpm
    }
}