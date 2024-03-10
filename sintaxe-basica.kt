class Livro(var titulo: String, var preco: Double) {
    override fun toString(): String {
        return "Livro: Titulo = $titulo, Preco = $preco"
    }
}

fun menu() {
    println("Haniel Aqui ó")
    println("1 - Cadastrar livro")
    println("2 - Excluir livro")
    println("3 - Buscar livro")
    println("4 - Editar livro")
    println("5 - Listar livros")
    println("6 - Listar livros que começam com letra escolhida")
    println("7 - Listar livros com preço abaixo do informado")
    println("8 - Sair")
}

fun inputTitulo(): String {
    print("Digite o titulo do livro: ")
    return readlnOrNull() ?:""
}

fun inputPreco(): Double {
    var preco:Double;
    do{
    print("Digite um preco para o livro: ")
        preco= readlnOrNull()!!.toDouble()

    }while (preco<0.0)

    return preco
}

fun cadastrarLivro(repositorio: MutableList<Livro>) {
    val titulo = inputTitulo()
    var preco = inputPreco().toDouble()
    if (preco  >= 0.0){
        repositorio.add(Livro(titulo, preco))
        println("\nCadastrado com sucesso!\n")

    }
    else {
        println("Valor inválido! ")
    }
}

fun excluirLivro(repositorio: MutableList<Livro>) {
    val livro = buscarNome(repositorio)
    repositorio.remove(livro)
    println("Livro removido com sucesso!")
}

fun buscarNome(repositorio: MutableList<Livro>): Livro? {
    val titulo = inputTitulo()
    return repositorio.find { it.titulo == titulo }
}

fun editarLivro(repositorio: MutableList<Livro>) {
        val livro = buscarNome(repositorio)

        if (livro != null) {
            println("Livro encontrado: $livro")
            println("Escolha o que deseja editar:")
            println("1 - Editar título")
            println("2 - Editar preço")
            println("3 - Cancelar")

            print("Digite a opção: ")
            val opcao = readlnOrNull()?.toInt() ?: 0

            when (opcao) {
                1 -> {
                    print("Digite o novo título: ")
                    val novoTitulo = readlnOrNull() ?: ""
                    livro.titulo = novoTitulo
                    println("Título editado com sucesso!")
                }
                2 -> {
                    val novoPreco = inputPreco()
                    livro.preco = novoPreco
                    println("Preço editado com sucesso!")
                }
                3 ->{
                    println("Operação Cancelada.")
                }
                else -> println("Opção inválida.")
            }
        } else {
            println("Livro não encontrado.")
        }
    }

fun listar(repositorio: MutableList<Livro>) {
    var cont=0

    for(livro in repositorio){
        println("${++cont} - ${livro}")
    }

}

fun listarComLetraInicial(repositorio: MutableList<Livro>) {
    print("Informe a letra: ")
    var letra = readlnOrNull() ?:""

    while(letra.length > 1) {
        print("Informe apenas uma letra: ")
        letra = readlnOrNull() ?:""
    }

    if(letra != "") {
        val livros = repositorio.filter { it.titulo.startsWith(letra) }
        livros.forEach {println(it)}
    } else {
        println("É necessário informar pelo menos um caracter para esta função executar!")
    }
}

fun listarComPrecoAbaixo(repositorio: MutableList<Livro>) {
    val preco = inputPreco()
    val livros = repositorio.filter { it.preco < preco }
    livros.forEach { println(it) }
}

fun main() {
    val repositorioLivros = mutableListOf<Livro>()
    repositorioLivros.add(Livro("Livro dos Livros", 999999.99))
    repositorioLivros.add(Livro("Turma da Monica", 4.99))
    repositorioLivros.add(Livro("Kotlin for Dummies", 29.99))
    repositorioLivros.add(Livro("A", 59.99))

    var opcao = 0
    while (opcao != 8) {
        menu()
        //println(repositorioLivros[0])
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?:8

        when (opcao) {
            1 -> cadastrarLivro(repositorioLivros)
            2 -> excluirLivro(repositorioLivros)
            3 -> {
                val livro = buscarNome(repositorioLivros)
                println(livro)
            }
            4 -> editarLivro(repositorioLivros)

            5 -> listar(repositorioLivros)
            6 -> listarComLetraInicial(repositorioLivros)
            7 -> listarComPrecoAbaixo(repositorioLivros)
            8 -> println("Até a próxima :)")
        }
        Thread.sleep(3000)
    }
}