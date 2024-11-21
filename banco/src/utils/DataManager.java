package utils;

import model.Conta;
import model.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    // Método para salvar contas
    public static void salvarContas(List<Conta> contas, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(contas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar contas
    public static List<Conta> carregarContas(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Conta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Retorna uma lista vazia se houver erro
        }
    }

    // Método para salvar funcionários
    public static void salvarFuncionarios(List<Funcionario> funcionarios, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar funcionários
    public static List<Funcionario> carregarFuncionarios(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Retorna uma lista vazia se houver erro
        }
    }
}

