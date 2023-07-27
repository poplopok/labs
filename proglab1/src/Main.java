import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        short[] a= new short[] {6,8,10,12,14,16,18,20,22};
        double[] x= new double [13];
        for (int i=0;i<13;i++){
            x[i]= (Math.random()*(12.0+2.0)-2.0);
        }
        double[][] k= new double[9][13];
        for (int i=0;i<9;i++){
            for (int j=0;j<13;j++){
                switch (a[i]){
                    case 10:
                        k[i][j]= Math.pow((Math.pow(Math.E,Math.pow((2.0/3.0)/(x[j]-1.0),2.0))),(Math.pow(0.25/(Math.pow(x[j],x[j]*(x[j]-3.0))),3.0)));
                        break;
                    case 6:
                    case 12:
                    case 18:
                    case 20:
                        k[i][j]=Math.atan(Math.pow(Math.E,Math.pow(-(Math.abs(x[j])*(Math.abs(x[j])+1.0)),(1.0/3.0))));
                        break;

                    default:
                        k[i][j]=Math.tan(Math.atan(Math.pow(Math.E,Math.pow(-Math.pow((2.0*Math.abs(x[j])),2.0),(1.0/3.0)))));
                        break;
                }
            }
        }

        System.out.println(Arrays.deepToString(k));
    }
}