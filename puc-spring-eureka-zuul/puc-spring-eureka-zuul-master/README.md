# spring-cloud-netflix-proxy-apis
[Criando proxy de APIs com Spring cloud, Zuul e Eureka](https://wp.me/p5RSbg-kW)

O Zuul não tem suporte na versão mais atual do spring-boot, por isso nesse fork ele foi substituido
pelo `spring-cloud-gateway`
## Pré requisito
- Maven 3
- Java 11

### Optional
- Docker e docker-compose

## Preparando ambiente

### Sem Docker
- ```cd spring-cloud-netflix-proxy-apis```
- ```mvn clean package```

### Com Docker
Execute o `build.sh` ou build as imagens docker manualmente.

Cada modulo tem o seu próprio `Dockerfile` e `build.sh` com o comando utilizado para buildar a imagem.
Caso vc esteja usando Windows e não queira usar o git bash, você pode abrir e rodar o conteudo de cada build.sh,
por exemplo o customers:
```
cd japao
docker build --rm -t rodrigofujioka/japao-service:latest .
```


## Executando
### Sem Docker
Service Discovery (Eureka)
- ```cd eureka```
- ```mvn spring-boot:run```

Proxy (Gateway)
- ```cd gateway```
- ```mvn spring-boot:run```

API de Brasil
- ```cd customers```
- ```mvn spring-boot:run```

API de Japao
- ```cd products```
- ```mvn spring-boot:run```


### Com Docker
```
docker-compose up -d
```

Acssando Eureka: http://localhost:8761
Instances currently registered with Eureka
```

Application	AMIs	Availability Zones	Status
CUSTOMERS	n/a (1)	(1)	UP (1) - 192.168.11.247:customers:8060
PRODUCTS	n/a (1)	(1)	UP (1) - 192.168.11.247:products:8070
ZUUL	      n/a (1)	(1)	UP (1) - 192.168.11.247:zuul:8080
```

## Acessando APIs

#### Diretamente
#### Sem Docker
- http://localhost:8070/japao
- http://localhost:8060/brasil
#### Com Docker
As portas das api não estão expostas no docker compose, então caso queria acessar elas diretamente terá que modificar o
docker compose, por exemplo o customer-service ficaria assim:

```
japao-service:
  image: 'rodrigofujioka/japao-service:latest'
  networks:
    - fuji-network
  ports:
    - "8060:8060"
  depends_on:
    - eureka-service
  environment:
    EUREKA_URL: customer-service
    EUREKA_DEFAULT_ZONE: 'http://eureka-service:8761/eureka'
```

#### Via Proxy (Gateway)
- http://localhost:8080/japao
- http://localhost:8080/brasil


O procedimento é o mesmo com ou sem docker

