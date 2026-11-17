package edu.iesam.aad_1evaluacion.features.cars.data

import edu.iesam.aad_1evaluacion.features.cars.data.local.xml.CarXmlLocalDataSource
import edu.iesam.aad_1evaluacion.features.cars.domain.Car
import edu.iesam.aad_1evaluacion.features.cars.domain.CarRepository

class CarDataRepository(private val xmlLocalDataSource: CarXmlLocalDataSource) : CarRepository {
    override fun obtainAll(): List<Car> {
        return xmlLocalDataSource.getAll()
    }

    override fun deleteId(id: String) {
        xmlLocalDataSource.deleteById(id)
    }

    override fun getById(id: String): Car? {
        return xmlLocalDataSource.getById(id)
    }

    override fun modifyByCar(car: Car) {
        xmlLocalDataSource.modifyByCar(car)
    }

}