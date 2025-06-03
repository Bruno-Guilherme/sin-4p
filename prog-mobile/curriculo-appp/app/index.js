import React from 'react';
import { View, Text, StyleSheet, Button } from 'react-native';
import { Link } from 'expo-router';

export default function Home() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Bem-vindo ao meu Currículo/Portfólio!</Text>
      <View style={styles.navButtons}>
        <Link href="/sobre" style={styles.linkButton}>
          <Text style={styles.buttonText}>Sobre</Text>
        </Link>
        <Link href="/academico" style={styles.linkButton}>
          <Text style={styles.buttonText}>Experiência Acadêmica</Text>
        </Link>
        <Link href="/profissional" style={styles.linkButton}>
          <Text style={styles.buttonText}>Experiência Profissional</Text>
        </Link>
        <Link href="/projetos" style={styles.linkButton}>
          <Text style={styles.buttonText}>Projetos</Text>
        </Link>
        <Link href="/jogo" style={styles.linkButton}>
          <Text style={styles.buttonText}>Jogo Senha</Text>
        </Link>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    backgroundColor: '#ffffff'
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    textAlign: 'center'
  },
  navButtons: {
    flex: 1,
    justifyContent: 'center'
  },
  linkButton: {
    backgroundColor: '#6200ee',
    padding: 15,
    marginVertical: 8,
    borderRadius: 8
  },
  buttonText: {
    color: '#fff',
    textAlign: 'center',
    fontSize: 16
  }
});