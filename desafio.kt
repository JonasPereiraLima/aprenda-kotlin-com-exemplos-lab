// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val id: Int, var nome: String, var idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if(findById(usuario.id) == null){
        	inscritos.add(usuario)
        }else{
           	println("Este id já está em uso!")
        }

    }
    
    fun removeUser(id: Int){
        val usuario = findById(id)
        inscritos.remove(usuario)
    }
    
    fun updateAgeOfUser(id: Int, idade: Int){
        val usuario = findById(id)
        if(usuario != null) usuario.idade = idade
        else println("Usuário não encontrado")
        
    }
    
    fun showAllUsers(){
        if(inscritos.count() > 0){
            inscritos.forEach{println("Nome: "+it.nome+", Idade: "+it.idade+", Id: "+it.id)}
        }else{
            println("Nenhum usuário cadastrado.")
        }
        
    }
    
    private fun findById(id: Int): Usuario? {
       return inscritos.find{it.id == id}
    }
}

fun main() {
//     TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//     TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val conteudosKotlinBasico = listOf(
    	ConteudoEducacional("Conhecendo o kotlin e sua documentação oficial", 60, Nivel.BASICO),
        ConteudoEducacional("Introdução prática à linguagem de programação kotlin", 120, Nivel.BASICO),
        ConteudoEducacional("Tratamento de exceções em kotlin", 120, Nivel.INTERMEDIARIO)
    )
    
    val aprendendoKotlin = Formacao("Aprendendo kotlin", conteudosKotlinBasico)
    aprendendoKotlin.matricular(Usuario(1, "Jonas Pereira Lima", 22))
    aprendendoKotlin.matricular(Usuario(2, "Jonas Pereira Lima", 22))
    aprendendoKotlin.matricular(Usuario(1, "Jonas Pereira Lima", 22))
    aprendendoKotlin.showAllUsers()
    println("\n")
    aprendendoKotlin.updateAgeOfUser(1, 23)
    aprendendoKotlin.showAllUsers()
    println("\n")
    aprendendoKotlin.removeUser(1)
    aprendendoKotlin.removeUser(2)
    aprendendoKotlin.showAllUsers()
}