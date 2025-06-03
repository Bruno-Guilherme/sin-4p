import React from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';

export default function Academico() {
  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>Experiência Acadêmica</Text>
      <View style={styles.itemContainer}>
        <Text style={styles.itemTitle}>Bacharelado em Ciência da Computação</Text>
        <Text style={styles.itemSubtitle}>Universidade Federal de Pernambuco (UFPE)</Text>
        <Text style={styles.itemDate}>2021 - Presente</Text>
        <Text style={styles.itemDescription}>
          - Disciplinas: Estruturas de Dados, Algoritmos, Sistemas Operacionais, Redes de Computadores, Inteligência Artificial.
        </Text>
      </View>
      <View style={styles.itemContainer}>
        <Text style={styles.itemTitle}>Curso de Packet Tracer</Text>
        <Text style={styles.itemSubtitle}>Cisco Networking Academy</Text>
        <Text style={styles.itemDate}>2024</Text>
        <Text style={styles.itemDescription}>
          - Aprendizado prático sobre configuração de redes e simulação de ambientes.
        </Text>
      </View>
      {/* Exemplo real 1 de experiência acadêmica: Monografia sobre Processamento de Linguagem Natural aplicada a tweets.
          Exemplo real 2: Participação em projeto de pesquisa para previsão de acidentes de trânsito em Recife até 2032.
          Associação: Assim como um currículo em formato PDF, aqui cada seção é um bloco de informação organizado cronologicamente. */}
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