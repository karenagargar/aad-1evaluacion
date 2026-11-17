package edu.iesam.aad_1evaluacion.features.cars.data.local.xml

import android.content.Context
import edu.iesam.aad_1evaluacion.R
import edu.iesam.aad_1evaluacion.core.cache.CacheTTL
import edu.iesam.aad_1evaluacion.core.serialization.JsonSerializer
import edu.iesam.aad_1evaluacion.features.cars.domain.Car

class CarXmlLocalDataSource(
    private val context: Context,
    private val serializer: JsonSerializer<Car>
) {

    companion object {
        const val clave = "cars"
        const val ttl: Long = 2 * 1000 //2 milis?
    }

    private val key = context.getString(R.string.local_data_car)
    val sharedPref = context.getSharedPreferences(key, Context.MODE_PRIVATE)

    private val Json = serializer

    //no me funciona el serializer y no supe hacer que me funcionara, por lo que no funciona nada
    val cacheTTL = CacheTTL(context)

    fun save(cars: List<Car>) {
        val carsString = Json.toJson(cars[0])
        sharedPref.edit().putString(clave, carsString).apply()
    }

    fun getAll(): List<Car> {
        if (cacheTTL.isExpired(key, ttl)) {
            val carsString = sharedPref.getString(clave, "")

            carsString.let {
                val carList = Json.fromJson(carsString)
                return carList
            }
            return emptyList<Car>()
        } else {
            return emptyList<Car>()
        }
    }

    fun deleteById(id: String) {
        save(getAll().filterNot { it.id == id })
    }

    fun modifyByCar(car: Car) {
        val newList = getAll().toMutableList().filterNot { it.id == id }
        newList.add(car)
        save(newList)
    }

    fun getById(id: String): Car? {
        return getAll().find { it.id == id }
    }
}