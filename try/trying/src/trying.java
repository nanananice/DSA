public class trying {
    public static void main(String[] args) {
        int n = 5;
        double[] a = new double[n];
        double max = Double.NEGATIVE_INFINITY;
        double sum = 0.0;
        System.out.print("List\n");
        for (int i = 0; i < n; i++) {
            a[i] = Math.random();
            System.out.print(a[i]+"\n");
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        System.out.print("List reverse\n");
        for (int i = 0; i < n/2; i++) {
            double temp = a[i];
            a[i] = a[n-1-i];
            a[n-i-1] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+"\n");
        }
        double avg = sum/n;
        System.out.print("Max:"+"\n"+max+"\n");
        System.out.print("Sum:"+"\n"+sum+"\n");
        System.out.print("Avg:"+"\n"+avg+"\n");
        double[] b = new double[n];
        System.out.print("List new\n");
        for(int i = 0; i < n; i++) {
            b[i] = a[i];
            System.out.print(a[i]+"\n");
        }
    }
}
