import React from 'react';
import { Stack } from 'expo-router';
import { View, Text, StyleSheet } from 'react-native';
import { SafeAreaProvider, SafeAreaView } from 'react-native-safe-area-context';

export default function Layout() {
  return (
    <SafeAreaProvider>
      <SafeAreaView style={styles.container}>
        {/* Stack gerencia navegação entre telas */}
        <Stack screenOptions={{ headerStyle: { backgroundColor: '#6200ee' }, headerTintColor: '#fff' }} />
      </SafeAreaView>
    </SafeAreaProvider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f6f6f6'
  }
});