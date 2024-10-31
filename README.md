# Facts Application

## Descrição

Esta é uma aplicação simples para gerenciar e consultar fatos relacionados a 
entidades e seus atributos. Os dados são representados por tuplas, onde cada tupla 
contém uma entidade, um atributo, um valor e um indicador de se o fato foi 
adicionado ou removido.

## Pré-requisitos

- Java 21

## Funcionalidades

- **Adicionar Fatos**: Insira novos fatos, especificando entidade, atributo, valor e se está ativo ou não.
- **Adicionar Esquemas**: Configure a cardinalidade (um ou muitos) para cada tipo de atributo.
- **Visualizar Fatos Vigentes**: Veja as informações atuais das entidades, de acordo com a cardinalidade e status de cada fato.

## Como utilizar

### Clonando o Repositório e Configurando o Ambiente

1. **Clone o repositório**:
```bash
git clone git@github.com:lucas00jr/storm-group-java.git
```
2. **Limpe e Construa**:
```bash
  mvn clean install
```
3. **Rodar Aplicação**:
run application em: FastApplication

4. **Acesse a aplicação no navegador**:
    - http://localhost:8080/  
# storm-group-java
