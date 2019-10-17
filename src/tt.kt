fun main(){
    val testClassMainMethod = Class.forName("TestKt").methods.find { it.name == "main" }
    val defaultOut = System.out
}