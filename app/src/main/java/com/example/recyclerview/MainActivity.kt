package com.example.recyclerview

import PlantAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter() // подключение адаптера
    private var editLauncher: ActivityResultLauncher<Intent>? = null //подключение лаунчера

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ // наш кол бак, для передачи информации
            if(it.resultCode == RESULT_OK){
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }

    private fun init() {  //инициализация нашего RecyclerView
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)// настройки - как будет выглядеть наш список
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {  //при нажатие на кнопку, переходим на др страницу
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}