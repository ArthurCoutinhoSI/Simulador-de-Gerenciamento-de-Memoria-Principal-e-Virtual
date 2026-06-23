# Simulador de Gerenciamento de Memória Principal e Virtual

Projeto em Java para simular o gerenciamento de páginas da memória virtual.

## Como compilar

```bash
bash build.sh
```

## Como executar

```bash
java -jar PageSimulator.jar <diretorio> <quantidade>
```

Exemplo:

```bash
java -jar PageSimulator.jar diretorio_das_paginas 10
```

O programa limpa o diretório informado e recria os arquivos de página antes de iniciar a simulação.

O limite do argumento ```<quantidade>``` é de 26¹⁰. Mais que suficiente para simulação.
