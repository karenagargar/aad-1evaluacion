package edu.iesam.aad_1evaluacion.features.cars.domain

interface CarRepository {
    fun obtainAll(): List<Car>
    fun deleteId(id: String)
    fun getById(id: String): Car?
    fun modifyByCar(car: Car)
}