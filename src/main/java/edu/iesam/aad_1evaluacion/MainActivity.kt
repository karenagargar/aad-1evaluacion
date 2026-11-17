package edu.iesam.aad_1evaluacion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.aad_1evaluacion.core.serialization.KotlinJsonSerializer
import edu.iesam.aad_1evaluacion.features.cars.data.local.xml.CarXmlLocalDataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val carXmlLocalDataSource = CarXmlLocalDataSource(this, KotlinJsonSerializer.create())
        carXmlLocalDataSource.getAll()
    }
}