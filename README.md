# Sistema de multas

- Sistema de multas produzido em Java para entrega da academia 1000Devs.
* Instrutor: João Almeida

## ✒️ Autor

* José Alan Vieira Sales
 - E-mail: salesalan854@gmail.com

## 🛠️ Construído com

* P.O.O
* [Hibernate](https://hibernate.org) 
* [Maven](https://maven.apache.org/) 
* [Postgresql](https://www.postgresql.org)

## ⭐ Uma breve descrição
* O sistema possui três entidades: Condutor, Veiculo e Multa com os seguintes atributos:
- 👤 Condutor -> Cnh (int / id); Data de emissão (String); Orgão emissor (String); Pontuação (int / recebde os pontos da multa); veiculo (Veiculo); multa (Multa)

- 🚗 Veiculo -> Placa (String / id); Modelo (String); Marca (String); Condutor (Condutor / Cnh); Multas (Multa / Código da multa)

- 📃 Multa -> Código da Multa (int / id); Valor (double); Pontuação (int); Veiculo(Veiculo / Placa do veiculo); Condutor(Condutor / chn)

## ⚙️ Operações
### 🔩 Para cada entidade é possível:
* Criar, Listar todos os cadastros, Colsultar a partir do Id (cnh, placa, codigo (da multa)), remover
* Operações adcionais: Venda de veículo (recebe a placa do veículo e a cnh do comprador)

* Observações: 
1. É possível criar um condutor sem um veiculo ou multa associados a ele
2. Não é possível prosseguir com a inserção de um veículo sem um condutor associado
3. É possível vender um veículo inserindo a cnh do comprador (previamente cadastrado) 
4. Pesquisar multas por veículo (função não implementada 😥)
5. passo a passo de inserção de valores deve ser seguido a risca, não há tratamento de exessões (ainda)

obs: O que ficou a desejar será implementado posteriormente (está assim devido ao limite de tempo da entrega)
