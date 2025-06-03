import React from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';

export default function Sobre() {
  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>Sobre Este App</Text>
      <Text style={styles.paragraph}>
        Este aplicativo foi desenvolvido em React Native, utilizando Expo para facilitar a construção e publicação. A navegação entre as telas é feita com Expo Router.
      </Text>
      <Text style={styles.subtitle}>Tecnologias e Módulos Utilizados:</Text>
      <View style={styles.listItem}>
        <Text style={styles.item}>• React Native</Text>
      </View>
      <View style={styles.listItem}>
        <Text style={styles.item}>• Expo SDK 48</Text>
      </View>
      <View style={styles.listItem}>
        <Text style={styles.item}>• Expo Router (navegação baseada em arquivos)</Text>
      </View>
      <View style={styles.listItem}>
        <Text style={styles.item}>• React Native Gesture Handler</Text>
      </View>
      <View style={styles.listItem}>
        <Text style={styles.item}>• React Native Safe Area Context</Text>
      </View>
      <View style={styles.listItem}>
        <Text style={styles.item}>• React Native Screens</Text>
      </View>
      <Text style={styles.association}>
        Associação: Navegar neste App é similar ao funcionamento de sites modernos, onde cada rota corresponde a uma página física (conceito de roteamento baseado em arquivos). Como em Next.js ou Nuxt, ao criar o arquivo "sobre.js" criamos automaticamente a rota "/sobre".
      </Text>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: '#fff' },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 12 },
  subtitle: { fontSize: 20, fontWeight: '600', marginTop: 16, marginBottom: 8 },
  paragraph: { fontSize: 16, marginBottom: 12, lineHeight: 22 },
  listItem: { marginBottom: 6 },
  item: { fontSize: 16 },
  association: { fontStyle: 'italic', marginTop: 16, fontSize: 14, color: '#555' }
});