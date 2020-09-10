package Seminar_2;

public class Task1_Matrix {
    double[][] matrix;
    int leni;
    int lenj;

    public Task1_Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.leni = this.matrix.length;
        this.lenj = this.matrix[0].length;
    }

    public double[][] plus(double[][] matrix2) {
        double[][] matrix3 = matr3();
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                matrix3[i][j] += matrix2[i][j];
            }
        }
        return matrix3;
    }

    public double[][] minus(double[][] matrix2) {
        double[][] matrix3 = matr3();
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                matrix3[i][j] -= matrix2[i][j];
            }
        }
        return matrix3;
    }

    public double[][] mulcount(double c) {
        double[][] matrix3 = matr3();
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                matrix3[i][j] *= c;
            }
        }
        return matrix3;
    }

    public double[][] mulmat(double[][] matrix2) {
        double sumel = 0;
        double[] buf = new double[matrix2[0].length];
        double[][] matrix3 = new double[leni][buf.length];
        for (int i = 0; i < leni; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < lenj; k++) {
                    sumel = sumel + this.matrix[i][k] * matrix2[k][j];
                }
                buf[j] = sumel;
                sumel = 0;
            }
            for (int q = 0; q < lenj; q++) {
                matrix3[i][q] = buf[q];
            }
        }
        return matrix3;
    }

    public double[][] transpon() {
        double[][] matrix3 = new double[lenj][leni];
        double[] buf = new double[lenj];
        for (int j = 0; j < lenj; j++) {
            for (int i = 0; i < leni; i++) {
                buf[i] = this.matrix[i][j];
            }
            for (int i = 0; i < leni; i++) {
                matrix3[j][i] = buf[i];
            }
        }
        return matrix3;
    }

    public double[][] stepen(double st) {
        double sumel = 0;
        double[] buf = new double[lenj];
        double[][] matrix3 = matr3();
        for (int t = 0; t < st - 1; t++) {
            for (int i = 0; i < leni; i++) {
                for (int j = 0; j < lenj; j++) {
                    for (int k = 0; k < lenj; k++) {
                        sumel = sumel + matrix3[i][k] * this.matrix[k][j];
                    }
                    buf[j] = sumel;
                    sumel = 0;
                }
                for (int q = 0; q < lenj; q++) {
                    matrix3[i][q] = buf[q];
                }
            }
        }
        return matrix3;
    }

    public double[][] matr3() {
        double[][] matrix3 = new double[leni][lenj];
        for (int i = 0; i < leni; i++) {
            for (int j = 0; j < lenj; j++) {
                matrix3[i][j] = this.matrix[i][j];
            }
        }
        return matrix3;
    }

    public static void matrout(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
