package interfacePattern

import common.Car
import common.Plane
import common.Vehicle

fun main() {
    var vehicle: Vehicle = Car(4, 4, true)
    println("Car has gas: ${vehicle.hasGas()}")
    vehicle = Plane(4, 20, true)
    println("Plane has gas: ${vehicle.hasGas()}")
}