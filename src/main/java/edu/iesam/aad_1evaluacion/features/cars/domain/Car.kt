package edu.iesam.aad_1evaluacion.features.cars.domain

import kotlinx.serialization.Serializable

@Serializable
data class Car(private val marca: String, private val model: String, private val plate: String)
