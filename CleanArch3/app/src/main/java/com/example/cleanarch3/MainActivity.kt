        package com.example.cleanarch3

        import android.os.Bundle
        import androidx.appcompat.app.AppCompatActivity
        import androidx.navigation.findNavController
        import androidx.navigation.ui.AppBarConfiguration
        import androidx.navigation.ui.NavigationUI
        import com.example.cleanarch3.databinding.ActivityMainBinding
        import dagger.hilt.android.AndroidEntryPoint

        @AndroidEntryPoint
        class MainActivity : AppCompatActivity() {

            private lateinit var binding: ActivityMainBinding
            private lateinit var appBarConfiguration: AppBarConfiguration

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

                val navController = findNavController(R.id.nav_host_fragment)
                appBarConfiguration = AppBarConfiguration(navController.graph)


            }

            override fun onSupportNavigateUp(): Boolean {
                val navController = findNavController(R.id.nav_host_fragment)
                return navController.navigateUp() || super.onSupportNavigateUp()
            }
        }
