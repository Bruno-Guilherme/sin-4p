import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity, Alert, FlatList, Keyboard, ScrollView } from 'react-native';

function gerarNumeroSecreto() {
  const digits = [];
  while (digits.length < 4) {
    const rand = Math.floor(Math.random() * 10).toString();
    if (!digits.includes(rand)) digits.push(rand);
  }
  return digits.join('');
}

export default function Jogo() {
  const [numeroSecreto, setNumeroSecreto] = useState('');
  const [tentativa, setTentativa] = useState('');
  const [historico, setHistorico] = useState([]);
  const [jogoFinalizado, setJogoFinalizado] = useState(false);

  useEffect(() => {
    reiniciarJogo();
  }, []);

  function verificarTentativa() {
    if (tentativa.length !== 4) {
      Alert.alert('Erro', 'Digite um número de 4 dígitos.');
      return;
    }
    const guess = tentativa;
    let bulls = 0;
    let cows = 0;
    for (let i = 0; i < 4; i++) {
      if (guess[i] === numeroSecreto[i]) bulls++;
      else if (numeroSecreto.includes(guess[i])) cows++;
    }
    const resultado = `${bulls} Bulls, ${cows} Cows`;
    const novoRegistro = { key: Date.now().toString(), tentativa: guess, resultado };
    setHistorico([novoRegistro, ...historico]); // lista em ordem reversa
    setTentativa('');

    if (bulls === 4) {
      Alert.alert('Parabéns!', `Você acertou a senha! ${numeroSecreto}`);
      setJogoFinalizado(true);
    } else if (historico.length + 1 >= 10) {
      Alert.alert('Fim de Jogo', `Você atingiu 10 tentativas. A senha era: ${numeroSecreto}`);
      setJogoFinalizado(true);
    }
    Keyboard.dismiss();
  }

  function revelarSenha() {
    Alert.alert('Senha Secreta', numeroSecreto);
  }

  function reiniciarJogo() {
    const novoNumero = gerarNumeroSecreto();
    setNumeroSecreto(novoNumero);
    setHistorico([]);
    setTentativa('');
    setJogoFinalizado(false);
  }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Jogo Senha (Bulls and Cows)</Text>
      <TouchableOpacity onPress={revelarSenha} style={styles.revealButton}>
        <Text style={styles.revealText}>Revelar Senha</Text>
      </TouchableOpacity>
      {!jogoFinalizado && (
        <View style={styles.inputContainer}>
          <TextInput
            style={styles.input}
            placeholder="Digite sua tentativa"
            keyboardType="numeric"
            maxLength={4}
            value={tentativa}
            onChangeText={setTentativa}
          />
          <TouchableOpacity onPress={verificarTentativa} style={styles.verifyButton}>
            <Text style={styles.verifyText}>Verificar</Text>
          </TouchableOpacity>
        </View>
      )}

      <Text style={styles.historyTitle}>Histórico de Tentativas</Text>
      <FlatList
        data={historico}
        renderItem={({ item }) => (
          <View style={styles.historyItem}>
            <Text style={styles.historyText}>{item.tentativa} - {item.resultado}</Text>
          </View>
        )}
        keyExtractor={(item) => item.key}
        style={styles.historyList}
      />

      {jogoFinalizado && (
        <TouchableOpacity onPress={reiniciarJogo} style={styles.restartButton}>
          <Text style={styles.restartText}>Jogar Novamente</Text>
        </TouchableOpacity>
      )}

      {/* Exemplo real 1: no terminal, mostrar jogo em funcionamento gerando um número como "1234" e o usuário digitando "1243" gera 2 Bulls, 2 Cows.
          Exemplo real 2: teste no dispositivo Android, digitar aleatoriamente e ver histórico aparecendo em ordem reversa.
          Associação: este jogo é similar a quebra-cabeças de lógica, como Sudoku, onde cada tentativa fornece pistas para chegar à solução. */}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    backgroundColor: '#fff'
  },
  title: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 12,
    textAlign: 'center'
  },
  revealButton: {
    alignSelf: 'center',
    marginBottom: 12,
    padding: 10,
    backgroundColor: '#ff6f00',
    borderRadius: 6
  },
  revealText: { color: '#fff', fontSize: 16 },
  inputContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginBottom: 12
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    borderRadius: 6,
    width: '60%',
    fontSize: 16
  },
  verifyButton: {
    backgroundColor: '#6200ee',
    padding: 10,
    borderRadius: 6,
    justifyContent: 'center'
  },
  verifyText: { color: '#fff', fontSize: 16 },
  historyTitle: { fontSize: 18, fontWeight: '600', marginTop: 16, marginBottom: 8 },
  historyList: { flex: 1 },
  historyItem: { padding: 8, backgroundColor: '#f1f1f1', marginVertical: 4, borderRadius: 4 },
  historyText: { fontSize: 16 },
  restartButton: {
    backgroundColor: '#03a9f4',
    padding: 12,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 12
  },
  restartText: { color: '#fff', fontSize: 16 }
});