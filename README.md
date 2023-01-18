# Desafio attornatus

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
    • Criar uma pessoa
    • Editar uma pessoa
    • Consultar uma pessoa
    • Listar pessoas
    • Criar endereço para pessoa
    • Listar endereços da pessoa
    • Poder informar qual endereço é o principal da pessoa 

    Uma Pessoa deve ter os seguintes campos:  
    • Nome
    • Data de nascimento
    • Endereço:
        ◦ Logradouro
        ◦ CEP
        ◦ Número
        ◦ Cidade
       
     

## 🚀 Arquitetura usada

Projeto foi separado em camas possuindo:

```
•entity
•service
•controller
•repository.
```


## Lista de endpoints e corpo de requisição, todos em json.

Pessoa:

[post]criar pessoa: http://localhost:8080/pessoa/criar

body: 
{   
    "nome": "joao pedro",
    "dataNascimento": "16-02-2001"
}


[put]editar pessoa: http://localhost:8080/pessoa/editar

body: 
{   "id": 1,
    "nome": "joao pedro",
    "dataNascimento": "16-02-2001"
}



[get]consultar pessoa: http://localhost:8080/pessoa/consultarPessoa

body: 
{   "id": 1
}



[get] listar pessoas:http://localhost:8080/pessoa/listarPessoas

Essa requisição não precisa de parametros.


[delete]deletar pessoa: http://localhost:8080/pessoa/excluir

body: 
{
    "id": 1
}

-----------------------------------------------------------------------------------------

Endereco:

[post]criar endereco: http://localhost:8080/endereco/criar

body: 
{
    "logradouro": "av manoel",
    "cep": "72820200",
    "numero": 1,
    "cidade": "luziania",
    "pessoa": {
        "id": 1
    }
}

[put]editar endereco: http://localhost:8080/endereco/editar , para alterar esse endereço para o principal, basta passar o parametro enderecoPrin como true,
que automaticamente caso a pessoa tenha outro como endereco principal vai ficar falso.

body: 

    {
        "id": 1,
        "logradouro": " logradouro mudado",
        "cep": "72820200",
        "numero": 1,
        "cidade": "luziania",
        "enderecoPrin": true,
        "pessoa":{
            "id": 1
        }
    }


[get]consultar enderecos por pessoa: http://localhost:8080/endereco/consultarEndePessoa/{id} , sendo esse id da pessoa que tem esses enderecos


[get] listar todos enderecos: http://localhost:8080/endereco/listarEnderecos

Essa requisição não precisa de parametros.



