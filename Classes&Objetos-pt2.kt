
open class Funcionario(val nome: String, val idade: Int) {

    //Passo 5:  Mensagem informando a criação de um novo Funcionário
    init {
        println("Novo funcionário registrado: $nome, $idade anos.")
    }

    //Passo 6:  Método apresentar
    open fun apresentar() {
        println("Funcionário: $nome, $idade anos.")
    }
}

// Passo 2: Criar Classe Gerente
class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade) {

    override fun apresentar() {
        println("Gerente: $nome, $idade anos, Setor: $setor.")
    }
}

//Passo 3: Criar Classe Desenvolvedor
class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        println("Desenvolvedor: $nome, $idade anos, Linguagem: $linguagem.")
    }
}

// Passo 4: Criar Classe Analista
class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade) {

    override fun apresentar() {
        println("Analista: $nome, $idade anos, Área: $area.")
    }
}

//Passo 7: Criação de uma lista para armazernar funcionarios
val listaFuncionarios: MutableList<Funcionario> = mutableListOf();


fun main() {
    //Passo 7: adicionando vários Funciona na lista
    val g1 = Gerente("Haniel Costa", 20, "Desenvolvimento Web")
    val d1 = Desenvolvedor("Rodrigo", 28, "Java")
    val a1 = Analista("Carlos", 50, "Finanças")
    listaFuncionarios.add(g1);
    listaFuncionarios.add(d1);
    listaFuncionarios.add(a1);

    // Passo 8: Iterar sobre a lista e chamar o método Apresentar correspondente
    for (funcionario in listaFuncionarios) {


        when (funcionario) {
            is Gerente ->
                (funcionario as Gerente).apresentar()

            is Desenvolvedor ->
                (funcionario as Desenvolvedor).apresentar()

            is Analista ->
                (funcionario as Analista).apresentar()

            else ->
                funcionario.apresentar()

        }
    }
}
