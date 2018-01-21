
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class smartflash {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //This creates a common set of flash cards
        //The format will be front,back,front,back...
        List<String> deck = new LinkedList<>();
        //This creates a counter to keep track of the amount of cards that
        //the user has gotten wrong
        //List<Integer> counter = new LinkedList<>();
        //This keeps track of the size of the decks
        //The format will be start,end,start,end...
        List<Integer> sizes = new LinkedList<>();
        //This is where the names of sets
        List<String> nameOfSet = new LinkedList<>();


        //Create a scanner
        //Scanner scan = new Scanner(System.in);

        boolean createAnotherSet = false;

        System.out.println("Would you like to create a Set?");
        String createSet = scan.next();
        if(createSet.equals("Yes")) {
            createAnotherSet = true;
        }

        //If the user wants to create a set of cards, cards get added to the main linked list (deck)
        //The starting position of the set is then recorded in createLinkedList
        while(createAnotherSet == true) {
            System.out.println("What is the name of the set?");
            //Store the name of the set in nameOfSet linked list
            String setName = scan.next();
            createLinkedList(deck,sizes, setName, nameOfSet);

            boolean continueAdding = true;

            //Create a while loop that runs until the user has added enough cards
            while(continueAdding == true) {
                System.out.println("Please enter the front");
                String front = scan.next();


                System.out.println("Please enter the back");
                String back = scan.next();
                //Add the front and back of card to the deck linked list
                addToDeck(front,back,deck);

                //ask the user whether or not to add more cards
                System.out.println("Would you like to continue");
                String continueOrNot = scan.next();
                //check if the user wants to end
                if(continueOrNot.equals("No")) {
                    continueAdding = false;
                }

            }
            //record the ending position of a set of flashcards and store it in sizes linked list
            endOfLinkedList(deck,sizes);

            System.out.println("Would you like to create another set?");
            String createAdditionalSet = scan.next();
            if(createAdditionalSet.equals("No")) {
                createAnotherSet = false;
            }

        }
        //Asks user if he/she wishes to practice
        System.out.println("Would you like to review a set?");
        String reviewOrNot = scan.next();
        System.out.println("Which set would you like to review?");
        String setToReview = scan.next();
        //this gets the starting and ending index of a set in the deck
        int startingPosition = getStartingPosition(sizes, nameOfSet, setToReview);
        int endingPosition = getEndingPosition(sizes, nameOfSet, setToReview);

        //System.out.println(startingPosition);
        //System.out.println(endingPosition);


        if(reviewOrNot.equals("Yes")) {
            reviewSetOfCards(deck, nameOfSet, startingPosition, endingPosition);
        }



    }




    //This records the ending position of a set of flashcards
    static void endOfLinkedList(List<String> deck1, List<Integer> sizes1) {
        int endPlace = deck1.size();
        sizes1.add(endPlace);
    }

    //This records the starting positon of a set of flashcards
    static void createLinkedList(List<String> deck1, List<Integer> sizes1, String setName, List<String> nameOfSet) {
        int startPlace = deck1.size() +1;
        sizes1.add(startPlace);
        nameOfSet.add(setName);
    }

    //This adds cards to the deck
    static void addToDeck(String front_add, String back_add, List<String> deck1) {
        deck1.add(front_add);
        deck1.add(back_add);
    }

    //This gets the starting position in the deck from the name of the deck
    static int getStartingPosition(List<Integer> sizes1, List<String> nameOfSet1, String actualName) {
        int indexOfName = nameOfSet1.indexOf(actualName);

        return sizes1.get(indexOfName*2)-1;
    }

    //This gets the ending point in the deck from the name of the deck
    static int getEndingPosition(List<Integer> sizes1, List<String> nameOfSet1, String actualName) {
        int indexOfName = nameOfSet1.indexOf(actualName);

        if(indexOfName == 0) {
            return sizes1.get(1)-1;
        }
        else {
            return sizes1.get((indexOfName * 2)+1)-1;
        }
    }



    static void reviewSetOfCards(List<String> deck1, List<String> nameOfSets, int startingPosition, int endingPosition) {
        List<String> linkedList0 = new LinkedList<>();
        List<String> linkedList1 = new LinkedList<>();
        List<String> linkedList2 = new LinkedList<>();
        List<String> linkedList3 = new LinkedList<>();

        for(int i = 0; i<deck1.size(); i+=2) {
            //System.out.println(deck1.get(i));
            Random rand = new Random(System.currentTimeMillis());
            int x = rand.nextInt(5);
            if(x==0) {
                linkedList0.add(deck1.get(i));
                linkedList0.add(deck1.get(i+1));

            }
            else if(x==1){
                linkedList1.add(deck1.get(i));
                linkedList1.add(deck1.get(i+1));

            }
            else if(x==2){
                linkedList2.add(deck1.get(i));
                linkedList2.add(deck1.get(i+1));


            }
            else if(x == 3){
                linkedList3.add(deck1.get(i));
                linkedList3.add(deck1.get(i+1));


            }
            //System.out.println(linkedList0.get(i));
        }


        boolean userWantsToContinue = true;
        while(userWantsToContinue == true) {
            boolean boxCouldBeEmpty = true;
            int value=0;

            while(boxCouldBeEmpty == true) {
                Random rand = new Random(System.currentTimeMillis());
                value = rand.nextInt(100);
                if(value <=9 && value >=0) {
                    int check = linkedList0.size();
                    if(check>0) {
                        System.out.println("Your are in box 0");

                        boxCouldBeEmpty = false;
                    }
                }
                if(value >=10 && value <=29) {
                    int check = linkedList1.size();
                    if(check>0) {
                        System.out.println("Your are in box 1");

                        boxCouldBeEmpty = false;
                    }
                }
                if(value >=30 && value <= 59) {
                    int check = linkedList2.size();
                    if(check>0) {
                        System.out.println("Your are in box 2");

                        boxCouldBeEmpty = false;
                    }
                }
                if(value >=60 && value <=99) {
                    int check = linkedList3.size();
                    if(check>0) {
                        System.out.println("Your are in box 3");

                        boxCouldBeEmpty = false;
                    }
                }
            }


            if(value <=9 && value >=0) {
                linkedList0Imp(linkedList0, linkedList1);
            }
            else if(value>=10 && value<=29) {
                linkedList1Imp(linkedList0, linkedList1, linkedList2);
            }
            else if(value>=30 && value <= 59) {
                linkedList2Imp(linkedList1, linkedList2, linkedList3);
            }
            else if(value>=60 && value <= 99) {
                linkedList3Imp(linkedList2, linkedList3);
            }

            System.out.println("Would you like to continue?");
            String continueOrNot = scan.next();
            if(continueOrNot.equals("No")) {
                userWantsToContinue = false;
            }

        }
    }

    static void linkedList0Imp(List<String> linkedList0new, List<String> linkedList1new) {
        //Display the front of the card
        System.out.println(linkedList0new.get(0));
        //The user will now click
        //Display the back of the card
        System.out.println(linkedList0new.get(1));
        System.out.println("Did you get it correct?");
        //ask the user to mark whether they answered correctly
        String correctOrNot = scan.next();
        //If the user answered wrong, move the card to the next box, otherwise the card stays becuase it is at the lowest level
        if(correctOrNot.equals("No")) {
            //Add the card to the next box if the user marked incorrect
            linkedList1new.add(linkedList0new.get(0));
            linkedList1new.add(linkedList0new.get(1));

            linkedList0new.remove(0);
            linkedList0new.remove(0);
            //System.out.println("I like coffee");
            //System.out.println(linkedList0new.get(3));
        }
        else if(correctOrNot.equals("Yes")) {
            linkedList0new.add(linkedList0new.get(0));
            linkedList0new.add(linkedList0new.get(1));

            linkedList0new.remove(0);
            linkedList0new.remove(0);

        }


    }
    static void linkedList1Imp(List<String> linkedList0new, List<String> linkedList1new, List<String> linkedList2new) {
        //Display the front of the card
        System.out.println(linkedList1new.get(0));
        //The user will now click
        //Display the back of the card
        System.out.println(linkedList1new.get(1));
        System.out.println("Did you get it correct?");
        //ask the user to mark whether they answered correctly
        String correctOrNot = scan.next();
        //If the user answered wrong, move the card to the next box, otherwise the card stays becuase it is at the lowest level
        if(correctOrNot.equals( "No")) {
            //Add the card to the next box if the user marked incorrect
            linkedList2new.add(linkedList1new.get(0));
            linkedList2new.add(linkedList1new.get(1));

            linkedList1new.remove(0);
            linkedList1new.remove(0);
        }
        //If the user answered correctly, move the card one box lower to the front
        else if(correctOrNot.equals("Yes")) {
            linkedList0new.add(linkedList1new.get(0));
            linkedList0new.add(linkedList1new.get(1));

            linkedList1new.remove(0);
            linkedList1new.remove(0);
        }

    }

    static void linkedList2Imp(List<String> linkedList1new, List<String> linkedList2new, List<String> linkedList3new) {
        //Display the front of the card
        System.out.println(linkedList2new.get(0));
        //The user will now click
        //Display the back of the card
        System.out.println(linkedList2new.get(1));
        System.out.println("Did you get it correct?");
        //ask the user to mark whether they answered correctly
        String correctOrNot = scan.next();
        //If the user answered wrong, move the card to the next box, otherwise the card stays becuase it is at the lowest level
        if(correctOrNot.equals( "No")) {
            //Add the card to the next box if the user marked incorrect
            linkedList3new.add(linkedList2new.get(0));
            linkedList3new.add(linkedList2new.get(1));

            linkedList2new.remove(0);
            linkedList2new.remove(0);
        }
        //If the user answered correctly, move the card one box lower to the front
        else if(correctOrNot.equals("Yes")) {
            linkedList1new.add(linkedList2new.get(0));
            linkedList1new.add(linkedList2new.get(1));

            linkedList2new.remove(0);
            linkedList2new.remove(0);
        }

    }
    static void linkedList3Imp(List<String> linkedList2new, List<String> linkedList3new) {
        //Display the front of the card
        System.out.println(linkedList3new.get(0));
        //The user will now click
        //Display the back of the card
        System.out.println(linkedList3new.get(1));
        System.out.println("Did you get it correct?");
        //ask the user to mark whether they answered correctly
        String correctOrNot = scan.next();
        //If the user answered wrong, move the card to the next box, otherwise the card stays becuase it is at the lowest level

        //If the user answered correctly, move the card one box lower to the front
        if(correctOrNot.equals("Yes")) {
            linkedList2new.add(linkedList3new.get(0));
            linkedList2new.add(linkedList3new.get(1));

            linkedList3new.remove(0);
            linkedList3new.remove(0);
        }
        else if(correctOrNot.equals("No")) {
            linkedList3new.add(linkedList3new.get(0));
            linkedList3new.add(linkedList3new.get(1));

            linkedList3new.remove(0);
            linkedList3new.remove(0);
        }

    }




}

