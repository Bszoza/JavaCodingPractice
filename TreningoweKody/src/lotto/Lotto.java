package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    private List<Integer> list = new ArrayList<Integer>();
    private List<Integer> hits = new ArrayList<Integer>();
    public List<Integer> generate() {
        for (int i = 1; i < 49; i++) {
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }

    public void randomize(){
        Collections.shuffle(list);
    }

    public Integer checkResult(List<Integer> numbers){
        Integer result = 0;
        for(int i=0; i<6; i++){
            if(numbers.get(i).equals(list.get(i))){
                    result++;
                    hits.add(numbers.get(i));
            }
        }
        return result;
    }

    public void showHits(){
        System.out.println(hits);
    }

}
