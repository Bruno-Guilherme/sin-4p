import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  TextInput,
  Button,
  FlatList,
  StyleSheet,
  TouchableOpacity,
} from "react-native";
import api from "./repository/api";

type Todo = {
  objectId: string;
  title: string;
  completed: boolean;
};

export default function App() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [input, setInput] = useState("");

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const { data } = await api.get("/todos");
      setTodos(data.results);
    } catch (error) {
      console.error("Erro ao carregar tarefas:", error);
    }
  };

  const handleAddTodo = async () => {
    const title = input.trim();
    if (!title) return;

    try {
      await api.post("", { title, completed: false });
      setInput("");
      fetchTodos();
    } catch (error) {
      console.error("Erro ao adicionar tarefa:", error);
    }
  };

  const handleToggleComplete = async (id: string, completed: boolean) => {
    try {
      await api.put(`/${id}`, { completed: !completed });
      fetchTodos();
    } catch (error) {
      console.error("Erro ao atualizar tarefa:", error);
    }
  };

  const handleDeleteTodo = async (id: string) => {
    try {
      await api.delete(`/${id}`);
      fetchTodos();
    } catch (error) {
      console.error("Erro ao deletar tarefa:", error);
    }
  };

  const renderItem = ({ item }: { item: Todo }) => (
    <View style={styles.item}>
      <TouchableOpacity onPress={() => handleToggleComplete(item.objectId, item.completed)}>
        <Text style={item.completed ? styles.done : styles.text}>{item.title}</Text>
      </TouchableOpacity>
      <Button title="🗑️" onPress={() => handleDeleteTodo(item.objectId)} />
    </View>
  );

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Minha To-Do List</Text>

      <TextInput
        style={styles.input}
        value={input}
        onChangeText={setInput}
        placeholder="Nova tarefa"
      />

      <Button title="Adicionar" onPress={handleAddTodo} />

      <FlatList
        data={todos}
        keyExtractor={(item) => item.objectId}
        renderItem={renderItem}
        ListEmptyComponent={<Text style={styles.empty}>Nenhuma tarefa encontrada.</Text>}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20, flex: 1, backgroundColor: "#fff" },
  title: { fontSize: 24, fontWeight: "bold", marginBottom: 10 },
  input: { borderWidth: 1, padding: 10, marginBottom: 10, borderRadius: 5 },
  item: {
    flexDirection: "row",
    justifyContent: "space-between",
    marginBottom: 10,
    alignItems: "center",
  },
  text: { fontSize: 16 },
  done: { fontSize: 16, textDecorationLine: "line-through", color: "gray" },
  empty: { marginTop: 20, textAlign: "center", color: "#999" },
});
