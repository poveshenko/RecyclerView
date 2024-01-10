import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Plant
import com.example.recyclerview.R
import com.example.recyclerview.databinding.PlantItemBinding

import java.util.ArrayList

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() { // class adapter - наследуеться от RV,
    // так же в ковычки,мы помещаем класс ViewHolder(со своеим названием). Он хранит в себе все ссылки на все элементы, так же через него,
    // мы будем заполнять каждый элемент.


    val plantList = ArrayList<Plant>() //Список

    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {// Это тот самый класс, который мы указали выше.
        // она наследуеться от View Holder. Так же в круглые скопки, мы помещаем назнавние нашей шаблон разметки, через котою мы будем заполнять наш RV.


        val binding = PlantItemBinding.bind(item) // View Binding - подключение

        fun bind(plant: Plant) = with(binding){//В эту функцию передаються данные из нашего класса Plant

            im.setImageResource(plant.imageId) // обращение к картинке в разметке Plant Item и к классу Plant
            tvTitle.text = plant.title
        }
    }
//метод создает нашу разметку,используя класс адаптер
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }
//Заполнение наше View для появления списка
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }
// передача размера массива
    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}