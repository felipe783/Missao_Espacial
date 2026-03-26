# 🚀 Missão Espacial

## 📖 Sobre o Projeto
Foi dado como uma atividade em sala sobre JAVA

Esta Atividade consiste na criação de um **Centro de Controle de Missões Espaciais**, permitindo o gerenciamento completo de foguetes, satélites, astronautas e equipes.

A aplicação possui um **Back End em Java** responsável pela lógica e persistência dos dados, além de um **Front End moderno** para interação com o usuário.

---

## 💻 Tecnologias Utilizadas

### 🖥️ Back End
- Java
- MySQL
- Flyway (migrations)

### 🌐 Front End
- React
- TypeScript

### ⚙️ Infraestrutura
- Servidor Ubuntu (local)
- Docker

## 🎯 Funcionalidades Principais

### 📁 Criação
Responsável pelo cadastro dos principais elementos do sistema:
- 🚀 Foguetes
- 🛰️ Satélites
- 👨‍🚀 Astronautas
- 👥 Equipes

### 👥 Equipes
Gerenciamento completo das equipes:
- ➕ Adicionar membros
- ➖ Remover membros
- 📋 Organização dos astronautas por equipe

### 🚀 Missões
Controle das missões espaciais:
- 🚀 Lançamento de missões
- 📊 Visualização de relatórios das missões

### 📊 Relatórios
Consulta detalhada das informações do sistema:
- 🚀 Foguetes
- 🛰️ Satélites
- 👨‍🚀 Astronautas
- 👥 Equipes

Cada relatório exibe todos os dados relacionados ao item selecionado.

## 🧠 Estrutura do Projeto
O sistema está organizado em módulos separados:

- `Criacao/` → Cadastro de entidades
- `Equipe/` → Gerenciamento de equipes
- `Missao/` → Controle de missões
- `Relatorios/` → Geração de relatórios