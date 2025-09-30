import java.util.Scanner;
import java.util.Random;//para generar numeros aleatorios no array e realizar os testes
class Lab05{
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void FirstPivot(int [] array, int left, int right){
        if(left<right){
            int pivot = array[left];
            int i = left+1;
            int j = right;
            while(i<=j){
                while(i <= right && array[i] <= pivot){
                     i++;
                }
                while(j >= left && array[j] > pivot){ 
                    j--;
                }
                if(i < j){
                    swap(array, i, j);
                    i++; j--;
                }
            }
            array[left] = array[j];
            array[j] = pivot;
            FirstPivot(array , left , j-1);
            FirstPivot(array , j+1 , right);
        }
    }
    public static void LastPivot( int [] array , int left , int right ){
        if(left<right){
            int pivot = array[right];
            int i = left;
            int j = right - 1;
            while(i<=j){
                while(i <= right && array[i] < pivot){
                     i++;
                }
                while(j >= left && array[j] >= pivot){ 
                    j--;
                }
                if(i < j){
                    swap(array, i, j);
                    i++; j--;
                }
            }
            array[right] = array[i];
            array[i] = pivot;
            LastPivot(array , left , i-1);
            LastPivot(array , i+1 , right);
        }
    }
    public static void RandomPivot( int [] array , int left , int right ){
        if(left<right){
            int randomIndex = left + (int)(Math.random() * (right - left + 1));
            swap(array, left, randomIndex);
            int pivot = array[left];
            int i = left+1;
            int j = right;
            while(i<=j){
                while(i <= right && array[i] <= pivot){
                     i++;
                }
                while(j >= left && array[j] > pivot){ 
                    j--;
                }
                if(i < j){
                    swap(array, i, j);
                    i++; j--;

                }
            }
            array[left] = array[j];
            array[j] = pivot;
            RandomPivot(array , left , j-1 );
            RandomPivot(array , j+1 , right);
        }
    }
    public static void MedianOfThree( int [] array , int left , int right ){
        if(left<right){
            int mid = left + (right - left) / 2;
            if(array[left] > array[mid]){
                swap(array, left, mid);
            }
            if(array[left] > array[right]){
                swap(array, left, right);
            }
            if(array[mid] > array[right]){
                swap(array, mid, right);
            }
            swap(array, left, mid);
            int pivot = array[left];
            int i = left+1;
            int j = right;
            while(i<=j){
                while(i <= right && array[i] <= pivot){
                     i++;
                }
                while(j >= left && array[j] > pivot){ 
                    j--;
                }
                if(i < j){
                    swap(array, i, j);
                    i++; j--;

                }
            }
            array[left] = array[j];
            array[j] = pivot;
            MedianOfThree(array , left , j-1);
            MedianOfThree(array , j+1 , right);
        }
    }


    /*Na main vamos ter os diferntes casos de testes pedidos no lab(arrays ordenados, quase ordenados e aleatorios) e vamos ter as quatro chamadas das funcoes de pivots. Todos os difrenetes casos de teste estão comentados, para testar um caso de cada vez, basta descomentar o caso desejado e comentar os outros.
    */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] array= new int[n];

//-----------------------------------------------------------------------------------------------------

        //CASO 1: ARRAY ORDENADO:

        for (int i=0; i<n; i++){
            // Preenche o array com numeros ordenados, de 1 ate n
            array[i] = i+1;
        }

//-----------------------------------------------------------------------------------------------------

        //CASO 2: ARRAY QUASE ORDENADO:

        /*
        for (int i=0; i<n; i++){
            array[i] = i+1;
        }
        //o vetor ja esta ordenado, agora vamos fazer algumas trocas para desordenar um pouco
        int swaps = Math.max(1, n / 20);   
        Random rnd = new Random(42);         
        for (int s = 0; s < swaps; s++) {
            int i = rnd.nextInt(n), j = rnd.nextInt(n);
            swap(array, i, j);               
        }
        */
//-----------------------------------------------------------------------------------------------------

        //CASO 3: ARRAY ALEATORIO:
       /* 
        //trecho que preenche o array com numeros aleatorios
        Random random = new Random(); // Instancia a classe Random
        for (int i=0; i<n; i++){
            // Gera um número aleatório entre 0  e 10000 e Atribui o número ao vetor
            int numeroAleatorio = random.nextInt(10000); 
            array[i] = numeroAleatorio;
        }
        */
//-----------------------------------------------------------------------------------------------------
        FirstPivot(array, 0, array.length-1);

        //LastPivot(array, 0, array.length-1);

        //RandomPivot(array, 0, array.length-1);

        //MedianOfThree(array, 0, array.length-1);

       sc.close();
    }
}