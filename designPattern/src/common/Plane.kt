package common

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