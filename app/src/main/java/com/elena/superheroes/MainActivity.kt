package com.elena.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.elena.superheroes.databinding.ActivityMainBinding
import com.elena.superheroes.databinding.ActivityProfileBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : AvengerAdapter
    private lateinit var model : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        adapter = AvengerAdapter()

        createRecyclerView()



        binding.navigationBottom.setOnNavigationItemSelectedListener { itemSelected ->
            when (itemSelected.itemId) {
                R.id.option_1 -> {
                    lifecycleScope.launch {
                        binding.progressBar.visibility = View.VISIBLE
                        delay(1000)
                        binding.progressBar.visibility = View.GONE
                        adapter.updateData(model.buenos())

                    }
                }
                R.id.option_2 -> {
                    lifecycleScope.launch {
                        binding.progressBar.visibility = View.VISIBLE

                        delay(1000)

                        binding.progressBar.visibility = View.GONE
                        adapter.updateData(model.malos())
                    }
                }
                R.id.option_3 -> {
                    Toast.makeText(this, "3- Clicked on ${itemSelected.title}", Toast.LENGTH_LONG ).show()
                }
            }
            true
        }

    }


    private fun createRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        adapter.updateData(model.buenos())



    }

}