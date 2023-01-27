
# Microservice Order e History

O projeto trata-se de dois microservices, um para pedidos e outro para histórico. Para implementação foi utilizado o Mysql como banco de dados e o RabbitMQ para mensageria. 
## Documentação da API
### Microservices History e Order
#### Cria um pedido

```http
  POST /api/pedidos
```

| Response      | Descrição                           |
| :----------  | :---------------------------------- |
| `200`| OK |
|`400`| Bad Request|

#### Retorna todos os doutores

```http
  GET /api/pedidos
```


| Response      | Descrição                           |
| :----------  | :---------------------------------- |
| `200`| OK |
|`403`| Forbidden |

#### Retorna um pedido

```http
  GET /api/pedidos/{idOrder}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idOrder`      | `long` | **Obrigatório**. O idOrder do pedido que você quer |


| Response      | Descrição                           |
| :----------  | :---------------------------------- |
| `200`| OK |
|`404`| Order Not Found |

#### Atualiza um item

```http
  PATCH /api/itens/{idItem}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idItem`      | `long` | **Obrigatório**. O idItem do item que você quer |

| Response      | Descrição                           |
| :----------  | :---------------------------------- |
| `200`| OK |
|`400`| Bad Request|
|`404`| Item Not Found |

#### Atualiza um pedido

```http
  PUT /api/pedidos/{idOrder}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idOrder`      | `long` | **Obrigatório**. O idOrder do pedido que você quer |

| Response      | Descrição                           |
| :----------  | :---------------------------------- |
| `200`| OK |
|`400`| Bad Request|
|`404`| Order Not Found |


#### Remove um pedido
```http
  DELETE /api/pedidos/{idOrder}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idDoctor`      | `long` | **Obrigatório**. O idOrder do pedido que você quer remover|

| Response      | Descrição                           |
| :----------  | :---------------------------------- |
|`200`| OK |
|`404`| Order Not Found |

