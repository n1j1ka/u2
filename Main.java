import java.util.Scanner;

public class Main {
    public static String[][] a = new String[11][11];
    public static int r, c;
    private static void fillBlock(String str){
        Scanner scanner = new Scanner(System.in);
        int len = str.length();
        for(int i=0; i<11; i++){ // Assume r, c<11
            for(int j=0; j<11; j++){
                a[i][j]="A";
            }
        }
        for(int i=0; i<len; i++){
            a[i/c][i%c] = str.substring(i, i+1);
        }
    }
    public static String encryptMessage(String message){
        int len = message.length();
        int cnt = (int)Math.ceil(1.0*len/(r*c));
        String ans = "";
        for(int i=1; i<Math.max(r, c); i++){
            message += "A";
        }
        for(int k=1; k<=cnt; k++){
            fillBlock(message.substring(r*c*(k-1), r*c*k));
            for(int i=0; i<c; i++){
                for(int j=0; j<r; j++){
                    ans += a[j][i];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        r = scanner.nextInt();
        c = scanner.nextInt();
//        fillBlock(str);
//        for(int i=0; i<r;i++){
//            for(int j=0; j<c; j++){
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }

//        System.out.println(encryptMessage(str));
    }
}
