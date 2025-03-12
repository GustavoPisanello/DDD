public class Calculadora {
    int soma(int a, int b){
        return a + b;
    }

    int soma(int a, int b, int c){
        return a + b + c;
    }

    double soma(double a, double b){
        return a + b;
    }

    int soma(int[] array){
        int somal = 0;
        for(int number: array){
            somal += number;
        }

        return somal;
    }

    int sub(int a, int b){
        return a - b;
    }

    int sub(int[] array){
        int result = array[0];
        for(int number: array){
            result -= number;
        }
        return result;
    }

    int mult(int[] array){
        int result = 1;
        for(int number: array){
            result *= number;
        }
        return result;
    }

    float div(int[] array){
        float result = array[0];
        for(int number: array){
            result /= number;
        }
        return result;
    }
}

