const express = require("express");
const dotenv = require("dotenv");
const path = require("path");

dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

// Servir arquivos estáticos da pasta 'public'
app.use(express.static(path.join(__dirname, "..", "public")));

// Endpoint API - Retorna uma saudação em JSON
app.get("/api/saudacao", (req, res) => {
    res.json({ 
        mensagem: "Olá! Seja bem-vindo à API RESTful.",
        dataHora: new Date().toLocaleString("pt-BR", { timeZone: "America/Recife" })
    });
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});