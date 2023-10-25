# Tweteroo

## Visão Geral

O Tweeroo, que fornece funcionalidades para criar usuários, postar tweets, visualizar tweets recentes e acessar tweets de usuários específicos. A API é construída usando o framework Spring e armazena os dados de forma temporária na memória.

Certifique-se de seguir as instruções abaixo para configurar e usar a API.

### Requisitos Gerais

- A porta utilizada pelo servidor é a 8080 (porta padrão do Spring).
- O versionamento usando Git é obrigatório. Certifique-se de criar um **repositório público** no seu perfil do GitHub.
- Faça commits a cada funcionalidade implementada.

### Armazenamento de Dados

- Para persistir os dados (usuários e tweets), utilizamos variáveis globais em memória.
- O formato de um **usuário** deve ser o seguinte:

```json
{
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
}
```


- O formato de um tweet deve ser o seguinte:
```json 
{
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
    "text": "eu amo o hub"
}
```

### Endpoints
#### POST /api/sign-up
- Recebe (no corpo da requisição) um parâmetro username e um avatar, contendo o nome do usuário e a sua foto de avatar:

```json
{
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
}
```
- Retorna a mensagem "OK".

#### POST /api/tweets

- Recebe (no corpo da requisição) os parâmetros username e tweet:

```json
{
    "username": "bobesponja",
    "tweet": "eu amo o hub"
}
```

- Salva o tweet em um array de tweets no servidor.
-  Retorna a mensagem "OK".

#### GET /api/tweets com Paginação

- Retorna os 5 tweets mais recentes.
- Recebe a página identificada via query string (?page=1).
- Retorna corretamente os tweets da página atual. A primeira página contém os 5 tweets mais recentes, a segunda de 6 a 10, a terceira de 11 a 15, e assim por diante.

```json
[
    {
        "username": "bobesponja",
        "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        "tweet": "eu amo o hub"
    }
]

```

#### GET /api/tweets/USERNAME
- Retorna todos os tweets publicados pelo usuário recebido como parâmetro na rota.

```json
[
    {
        "username": "bobesponja",
        "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        "tweet": "eu amo o hub"
    }
]
```

## Instruções para Docker

### Instalação do docker
#### Ubuntu
<a>https://docs.docker.com/engine/install/ubuntu/</a>

#### Windows
<a>https://docs.docker.com/desktop/install/windows-install/</a>

#### MacOS
<a>https://docs.docker.com/desktop/install/mac-install/</a>

___

### Iniciar e Parar o Projeto
- Para iniciar o projeto, execute o seguinte comando:

```bash
docker-compose up -d --build
```

- Para parar o projeto, execute o seguinte comando:

```bash
docker-compose down -v
```

Certifique-se de que o Docker esteja em execução antes de usar os comandos acima. Após iniciar o projeto, você pode acessar a API em http://localhost:8080.

Este é um guia básico para o Tweteroo. Você pode precisar ajustar as instruções com base nas configurações específicas do seu ambiente. Certifique-se de ter o Docker e o Docker Compose instalados antes de seguir as instruções acima.