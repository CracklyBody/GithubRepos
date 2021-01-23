package ru.tech_reliab.githubrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tech_reliab.githubrepos.adapter.RepositoryAdapter
import ru.tech_reliab.githubrepos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    lateinit var adapter: RepositoryAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recycler.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        adapter = RepositoryAdapter(listOf())
        binding.recycler.adapter = adapter
        viewModel.repos.observe(this){
            adapter.refresh(it)
        }
        binding.load.setOnClickListener{
            if(binding.username.text.toString() != ""){
                viewModel.loadData(binding.username.text.toString())
            }
        }
    }
}