import kotlin.math.pow

// Questão 1
class Produto {
    var nome: String
    var preco: Double

    // Construtor 1: Não recebe parâmetros
    constructor() {
        nome = "Produto"
        preco = 0.0
    }

    // Construtor 2: Recebe apenas o nome como parâmetro
    constructor(nome: String) {
        this.nome = nome
        preco = 0.0
    }

    // Construtor 3: Recebe tanto o nome quanto o preço como parâmetros
    constructor(nome: String, preco: Double) {
        this.nome = nome
        this.preco = preco
    }

    override fun toString(): String {
        return "Produto ${nome}, preço: $preco"
    }
}

// Questão 2
class Cliente {

    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão
    public var nome: String = ""
    private var idade: Int = 0

    public fun mostrarIdade(): Int {
        return this.idade
    }

}

// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar()
}

class Guerreiro : Personagem() {
    override fun atacar() {
        println("Ataca com a espada: Corte cortante cortador")

    }
}

class Mago : Personagem() {
    override fun atacar() {
        println("Lança o feitiço: Shurastei o Shurasgou")
    }
}


// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        return altura * largura
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        return Math.PI * raio.pow(2)
    }
}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    private var _nomeTitular: String = ""
    private var _saldo: Double = 0.0

    var nomeTitular: String
        get() = _nomeTitular.capitalize()
        set(value) {
            _nomeTitular = value
        }

    var saldo: Double
        get() = _saldo
        set(value) {
            if (value >= 0) {
                _saldo = value
            } else {
                _saldo = 0.0
            }
        }

    override fun toString(): String {
        return "numeroConta: $numeroConta, nomeTitular: ${nomeTitular}, saldo: $_saldo)"
    }
}


fun main() {
//Q1
    println("Q1")
    val p1 = Produto() //sem parâmetros
    val p2 = Produto("Camisa")
    val p3 = Produto("Lousa", 30.0)
    println(p1)
    println(p2)
    println(p3)
    println("===".repeat(30))
//Q2
    println("Q2")
    val c1 = Cliente()
    println(c1.mostrarIdade())
    println("===".repeat(30))
//Q3
    println("Q3")
    val m1 = Mago()
    val g1 = Guerreiro()
    m1.atacar()
    g1.atacar()
    println("===".repeat(30))

//Q4
    println("Q4")
    val r1 = Retangulo(5.0, 3.2)
    val e1 = Circulo(4.0)

    println(r1.calcularArea())
    println(e1.calcularArea())
    println("===".repeat(30))

//Q5
    println("Q5")

    val cb1= ContaBancaria();
    cb1.nomeTitular ="haniel costa"
    cb1.saldo = -100000.00
    cb1.numeroConta = "102039"
    println(cb1);
    println("===".repeat(30))
}
