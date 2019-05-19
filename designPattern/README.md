# Bongo's Android Developer Position Assigment 
## Problem 
Explain the design pattern used in following:
~~~
interface common.Vehicle {
int set_num_of_wheels()
int set_num_of_passengers()
boolean has_gas()
}
~~~
- Explain how can you use the pattern to create car and plane class?
- Use a different design pattern for this solution.

#### Task
- Cretae Car and Plane class.
- Specify the interface design pattern.
- Use another design pattern.

#### Cretae Car and Plane class
- Car class
~~~kotlin

class Car constructor(
    private val numberOfWheel: Int,
    private val numberOfPassenger: Int,
    private val hasGas: Boolean
) : Vehicle {

    override fun setSumOfWheel(): Int {
       return numberOfWheel
    }

    override fun setNumOfPassenger(): Int {
        return numberOfPassenger
    }

    override fun hasGas(): Boolean {
        return hasGas
    }

}
~~~

- Plane class
~~~

class Plane constructor(
    private val numberOfWheel: Int,
    private val numberOfPassenger: Int,
    private val hasGas: Boolean
) : Vehicle {

    override fun setSumOfWheel(): Int {
        return numberOfWheel
    }

    override fun setNumOfPassenger(): Int {
        return numberOfPassenger
    }

    override fun hasGas(): Boolean {
        return hasGas
    }

}
~~~
#### Specify the interface design pattern

~~~kotlin
fun main() {
    var vehicle: Vehicle = Car(4, 4, true)
    println("Car has gas: ${vehicle.hasGas()}")
    vehicle = Plane(4, 20, true)
    println("Plane has gas: ${vehicle.hasGas()}")
}
~~~
### In factory design pattern
- Create a factory 
~~~kotlin

class VehicleFactory {
    fun makeCar(numberOfWheel: Int, numberOfPassenger: Int, hasGas: Boolean): Vehicle {
        return Car(numberOfWheel, numberOfPassenger, hasGas)
    }

    fun makePlane(numberOfWheel: Int, numberOfPassenger: Int, hasGas: Boolean): Vehicle {
        return Plane(numberOfWheel, numberOfPassenger, hasGas)
    }
}
~~~
- Run the factory
~~~kotlin 

fun main() {
    val car = VehicleFactory().makeCar(4, 4, true)
    val plane = VehicleFactory().makePlane(4, 40, true)
    println("Car Passenger: ${car.setNumOfPassenger()}")
    println("Plane Passenger: ${plane.setNumOfPassenger()}")
}
~~~