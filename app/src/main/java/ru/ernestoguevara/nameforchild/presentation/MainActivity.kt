package ru.ernestoguevara.nameforchild.presentation

import android.content.Intent
import android.os.Bundle
import com.moxy_mvp.androidx.MvpAppCompatActivity
import ru.ernestoguevara.nameforchild.databinding.ActivityMainBinding
import ru.ernestoguevara.nameforchild.presentation.service.DataLoaderService


class MainActivity : MvpAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var loaderIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        loaderIntent = Intent(this, DataLoaderService::class.java)
        startService(loaderIntent)
    }

    override fun onStop() {
        super.onStop()

        stopService(loaderIntent)
    }

}