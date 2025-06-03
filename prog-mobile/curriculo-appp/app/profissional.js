import React from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';

export default function Profissional() {
  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>Experiência Profissional</Text>
      <View style={styles.itemContainer}>
        <Text style={styles.itemTitle}>Estagiário em Desenvolvimento Backend</Text>
        <Text style={styles.itemSubtitle}>Avanade</Text>
        <Text style={styles.itemDate}>2025 - Presente</Text>
        <Text style={styles.itemDescription}>
          - Desenvolvimento de APIs REST com Java Spring.
          - Criação de testes unitários e integração contínua.
        </Text>
      </View>
      <View style={styles.itemContainer}>
        <Text style={styles.itemTitle}>Desenvolvedor Junior (Freelance)</Text>
        <Text style={styles.itemSubtitle}>WeParty Project</Text>
        <Text style={styles.itemDate}>2024</Text>
        <Text style={styles.itemDescription}>
          - Desenvolvimento de sistema para conectar fornecedores de serviços de eventos.
          - Implementação de autenticação e rotas protegidas com React e Node.js.
        </Text>
      </View>
      {/* Exemplo real 1: Atuação na Avanade, detalhando tarefas diárias em ambiente corporativo.
          Exemplo real 2: Projeto WeParty como experiência prática de fullstack.
          Associação: Tal como um portfólio inclui depoimentos, aqui as descrições servem como evidência de habilidades. */}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: '#fff' },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 16 },
  itemContainer: { marginBottom: 20 },
  itemTitle: { fontSize: 18, fontWeight: '600' },
  itemSubtitle: { fontSize: 16, fontStyle: 'italic', marginVertical: 4 },
  itemDate: { fontSize: 14, color: '#777' },
  itemDescription: { fontSize: 16, marginTop: 4, lineHeight: 22 }
});