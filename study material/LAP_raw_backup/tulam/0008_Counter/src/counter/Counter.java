/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package counter;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author ADMIN
 */
public class Counter {

    /**
     * @param args the command line arguments
     */
    private HashMap<Character, Integer> characterCounter = new HashMap<>();
    private HashMap<String, Integer> wordCounter = new HashMap<>();
    
    public void displayResult(){
        System.out.println(wordCounter);
        System.out.println(characterCounter);
    }
    public void analyzeInput(String input){
        for(String str : input.split("\\s+")){
            if(!wordCounter.containsKey(str)){
                wordCounter.put(str, 1);
            }else{
                int frequency = wordCounter.get(str);
                wordCounter.put(str, frequency+1);
            }
        }
        
        for(char character : input.toCharArray()){
            if(Character.isSpaceChar(character)) continue;
            if(!characterCounter.containsKey(character)){
                characterCounter.put(character, 1);
            }else{
                int frequency = characterCounter.get(character);
                characterCounter.put(character, frequency+1);
            }
        }
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
        Validation valid = new Validation();
        Counter counter = new Counter();
        
        String input = valid.enterAndCheckValidInput();
        
        counter.analyzeInput(input);
        
        counter.displayResult();
    }
    
}
