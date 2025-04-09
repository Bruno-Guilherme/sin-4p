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
import api from "../repository/api";
import { Ionicons } from "@expo/vector-icons";

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

  const fetchTodos = () => {
    /* try {
      const { data } = await api.get("/");
      setTodos(data.results);
    } catch (error) {
      console.error("Erro ao carregar tarefas:", error);
    } */
    api.get("/")
      .then((response) => {
        setTodos(response.data.results);
      })
      .catch((error) => {
        console.error("Erro ao carregar tarefas:", error);
      });
  };


  const handleAddTodo = async () => {
    const title = input.trim();
    if (!title) return;

    try {
      await api.post("/", { title, completed: false });
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
      <TouchableOpacity
        style={styles.deleteButton}
        onPress={() => handleDeleteTodo(item.objectId)}
      >
        <Ionicons name="trash" size={24} color="#fff" />
      </TouchableOpacity>
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

      <TouchableOpacity style={styles.button} onPress={handleAddTodo}>
        <Text style={styles.buttonText}>Adicionar</Text>
      </TouchableOpacity>

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
  button: {
    backgroundColor: "#25292e",
    padding: 10,
    borderRadius: 5,
    alignItems: "center",
    marginBottom: 10,
  },
  buttonText: {
    color: "#fff",
    fontWeight: "bold",
    fontSize: 16,
  },
  deleteButton: {
    backgroundColor: "#25292e",
    padding: 10,
    borderRadius: 5,
    justifyContent: "center",
    alignItems: "center",
  },
});
