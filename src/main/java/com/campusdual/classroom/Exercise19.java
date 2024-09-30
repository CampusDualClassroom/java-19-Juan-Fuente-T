package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int[][] flatTriArray = new int[intArrayTri.length][intArrayTri[0].length];
        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < intArrayTri[i].length; j++) {
                for (int k = 0; k < intArrayTri[i][j].length; k++) {
                    flatTriArray[j][i] += intArrayTri[k][j][i];
                }

            }
        }
        return flatTriArray;
    }

    public static String getBidimensionalString(int[][] intArrayBi) {
        int arrayRows = intArrayBi[0].length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrayRows; i++) {
            builder.append(stringFlatMatrixRow(intArrayBi, i));
            builder.append("\n");
        }
        builder.delete(builder.length() - 1, builder.length());
        return builder.toString();
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder builder = new StringBuilder();
        for (int i : uniArray) {
            builder.append(i);
            builder.append(" ");
        }
        builder.delete(builder.length() - 1, builder.length());
        return builder.toString();
    }

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] unidimensionalArray = new int[columns];
        for (int i = 0; i < columns; i++) {
            unidimensionalArray[i] = i + 1;
        }
        return unidimensionalArray;
    }


    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] bidimensionalArray = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bidimensionalArray[i][j] = num++;
            }
        }
        return bidimensionalArray;
    }


    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] tridimensionalArray = new int[depth][rows][columns];
        int num = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    tridimensionalArray[i][j][k] = num++;
                }
            }
        }
        return tridimensionalArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
