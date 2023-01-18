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






[get]consultar pessoa: http://localhost:8080/pessoa/consultarPessoa/{id}
<br>
<br>
[get] listar pessoas:http://localhost:8080/pessoa/listarPessoas
Essa requisição não precisa de parametros.
<br>
<br>
[delete]deletar pessoa: http://localhost:8080/pessoa/deletarPessoa/{id}
<br>
<br>

-----------------------------------------------------------------------------------------


Endereço:


[post]criar endereço: http://localhost:8080/endereco/criar


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


[put]editar endereço: http://localhost:8080/endereco/editar
<br>
Para alterar esse endereço para o principal, basta passar o parâmetro enderecoPrin como true,
ue automaticamente caso a pessoa tenha outro endereço principal vai ficar falso.
<br>
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

<br>
[get]consultar endereços por pessoa: http://localhost:8080/endereco/consultarEndePessoa/{id} , sendo esse id da pessoa que tem esses endereços

<br>
<br>

[get] listar todos endereços:http://localhost:8080/endereco/listarEnderecos'


Essa requisição não precisa de parâmetros.









