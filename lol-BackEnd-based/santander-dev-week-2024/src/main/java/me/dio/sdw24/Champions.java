package me.dio.sdw24;


/*
Modelagem das Entidades (campeao) reflete o banco de dados.
Mapeamento Obj Relacional
 */


// Mapeando o record para representar a tabela criada
public record Champions (
        Long id,
         String name,
         String role,
         String lore,
         String imageUrl
){
    // modelos responsaveis por gerar o contexto das questões e formata. Faz parte do pront para envio das Ias
    public String generateContextByQuestion(String question){

        return """
        Pergunta: %S
        Nome do campeao: %s
        Funcao: %s
        Lore (Historia): %s
        """.formatted(question, this.name,this.role,this.lore);
    }
}

