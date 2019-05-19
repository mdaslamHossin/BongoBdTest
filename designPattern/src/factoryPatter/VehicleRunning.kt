package factoryPatter

fun main() {
    val car = VehicleFactory().makeCar(4, 4, true)
    val plane = VehicleFactory().makePlane(4, 40, true)
    println("Car Passenger: ${car.setNumOfPassenger()}")
    println("Plane Passenger: ${plane.setNumOfPassenger()}")
}
