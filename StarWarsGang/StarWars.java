import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;
import java.io.*;

public class StarWars {
    public StarWars(){



        //Part 3:
        System.out.println("Part 3:");
        Stack<Character> maleStack = new Stack<>();
        Stack<Character> femaleStack = new Stack<>();
        Stack<Character> droidStack = new Stack<>();
        Stack<Character> agesStack = new Stack<>();

        try {
           File file  = new File("StarWarsCharacters.txt");
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while((text=input.readLine()) != null){
                String[] categories = text.split(",");
                String name = categories[0];

                String year = categories[5];

                String gender = categories[6];
                String home = categories[7];
                if(home.equals("NA")){
                    home = "Unknown";
                }
                String species = categories[8];
                Character character = new Character(name, year, gender, home, species);

                if(gender.equals("male")){
                    maleStack.push(character);
                }
                if(gender.equals("female")){
                    femaleStack.push(character);
                }
                if(species.equals("Droid")){
                    droidStack.push(character);
                }
                if(!(year.equals("NA"))){
                    agesStack.push(character);
                }
            }

            System.out.println("Male Characters");
            System.out.println(String.format("%-25s%30s", "Name", "Homeworld"));
            while(!(maleStack.isEmpty())){
                System.out.println(String.format("%-25s%30s", maleStack.peek().getName(), maleStack.peek().getHome()));
                maleStack.pop();
            }
            System.out.println();

            System.out.println("Female Characters");
            System.out.println(String.format("%-25s%30s", "Name", "Homeworld"));
            while(!(femaleStack.isEmpty())){
                System.out.println(String.format("%-25s%30s", femaleStack.peek().getName(), femaleStack.peek().getHome()));
                femaleStack.pop();
            }
            System.out.println();

            System.out.println("Droids");
            System.out.println(String.format("%-25s%30s", "Name", "Homeworld"));
            while(!(droidStack.isEmpty())){
                System.out.println(String.format("%-25s%30s", droidStack.peek().getName(), droidStack.peek().getHome()));
                droidStack.pop();
            }
            System.out.println();

            System.out.println("Ages");
            System.out.println(String.format("%-25s%30s%25s", "Name", "Homeworld", "Birth Year"));
            while(!(agesStack.isEmpty())){
                double printYear = Double.parseDouble(agesStack.peek().getYear().split("B")[0]);
                System.out.println(String.format("%-25s%30s%25s", agesStack.peek().getName(), agesStack.peek().getHome(), printYear));
                agesStack.pop();
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyStackException e){
        }

    }

    public class Character {

        private String name;
        private String year;
        private String gender;
        private String home;
        private String species;

        public Character(String name, String year, String gender, String home, String species) {

            this.name = name;
            this.year = year;
            this.gender = gender;
            this.home = home;
            this.species = species;
        }

        public String getName() {
            return name;
        }

        public String getYear() {
            return year;
        }

        public String getGender() {
            return gender;
        }

        public String getHome() {
            return home;
        }

        public String getSpecies() {
            return species;
        }
    }

    public static void main(String[]args){

        StarWars app = new StarWars();

    }
}