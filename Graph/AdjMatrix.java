package Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;

@SuppressWarnings({"unchecked", "deprecation"})
public class AdjMatrix {

    private int[][] matrix;
    private String[] v;
    private int n;

    public void loadGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            n = sc.nextInt();
            sc.nextLine();
            v = new String[n];

            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLine().trim();
            }
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String a = sc.nextLine().trim();
                String[] temp = a.split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(temp[j]);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public List<String> getAdjList() {
        List<String> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder list = new StringBuilder(v[i] + "->");
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    list.append(v[j]).append("->");
                }
            }
            String result = list.toString().replaceAll("->$", "");
            adjList.add(result);
        }
        return adjList;
    }


    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix();
        adjMatrix.loadGraphFromFile("file.txt");
        List<String> addList = adjMatrix.getAdjList();
        for (String adj : addList) {
            System.out.println(adj);
        }
    }
}
