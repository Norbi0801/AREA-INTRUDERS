import java.awt.Dimension;
import java.util.ArrayList;

public class Combinations {
    public static ArrayList<Dimension> comb(int n){
        ArrayList<Dimension> result = new ArrayList<>();
        for(int i=0;i<n-1; i++){
            for(int j=i+1;j<n;j++){
                result.add(new Dimension(i,j));
            }
        }
        return result;
    }
}
