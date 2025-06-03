import React from 'react';
import { View, Text, StyleSheet, ScrollView, Linking, TouchableOpacity } from 'react-native';

export default function Projetos() {
  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>Projetos</Text>
      <View style={styles.itemContainer}>
        <Text style={styles.itemTitle}>Currículo App (Este Projeto)</Text>
        <TouchableOpacity onPress={() => Linking.openURL('https://github.com/Bruno-Guilherme/sin-4p/tree/main/prog-mobile/curriculo-appp')}>
          <Text style={styles.link}>Repositório GitHub</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.itemContainer}>
        <Text style={styles.itemTitle}>WeParty</Text>
        <TouchableOpacity onPress={() => Linking.openURL('https://github.com/Bruno-Guilherme/weparty')}>
          <Text style={styles.link}>Repositório GitHub</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: '#fff' },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 16 },
  itemContainer: { marginBottom: 16 },
  itemTitle: { fontSize: 18, fontWeight: '600' },
  link: { fontSize: 16, color: '#6200ee', marginTop: 4 }
});