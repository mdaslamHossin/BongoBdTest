package factoryPatter

import common.Car
import common.Plane
import common.Vehicle

class VehicleFactory {
    fun makeCar(numberOfWheel: Int, numberOfPassenger: Int, hasGas: Boolean): Vehicle {
        return Car(numberOfWheel, numberOfPassenger, hasGas)
    }

    fun makePlane(numberOfWheel: Int, numberOfPassenger: Int, hasGas: Boolean): Vehicle {
        return Plane(numberOfWheel, numberOfPassenger, hasGas)
    }
}