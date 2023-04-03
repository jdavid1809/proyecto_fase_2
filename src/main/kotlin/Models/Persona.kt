package Models

open class Persona(
    name: String,
    age: Int
) {
    private var name:String = name
    private var age:Int = age
    fun setName(name: String) {
        this.name = name
    }
    fun getName():String {
        return this.name
    }
    fun setAge(age: Int) {
        this.age = age
    }
    fun getAge():Int {
        return this.age
    }

    override fun toString(): String {
        return "Persona(name='$name', age=$age)"
    }


}