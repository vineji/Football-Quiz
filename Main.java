import java.util.ArrayList;
import java.util.Collections;

class Question
{
    String the_question;
    String [] wrong_answers = new String[3];
    String correct_answer;
    int time_allowed;
    public Question(String the_question, String [] wrong_answers, String correct_answer, int time_allowed){
        this.the_question = the_question;
        this.wrong_answers = wrong_answers;
        this.correct_answer = correct_answer;
        this.time_allowed =time_allowed;
    }

    // This is the time allowed to look at the answers and which coloured block they are on.
}
class Easy_question extends Question{
    public Easy_question(String the_question, String [] wrong_answers, String correct_answer){
        super(the_question, wrong_answers, correct_answer, 12);
    }
    public static ArrayList<Question> getEasyQuestions(){

        ArrayList<Question> easy_questions = new ArrayList<>();
        easy_questions.add(new Easy_question("Which player has won the world cup?", new String[]{"Ronaldo", "Neymar", "Suarez"}, "Messi"));
        easy_questions.add(new Easy_question("Which club has the most UCLs?", new String[]{"Bayern Munich", "Arsenal", "AC Milan"}, "Real Madrid" ));
        easy_questions.add(new Easy_question("Which team recently won the treble?", new String[]{"Real Madrid", "Liverpool", "Barcelona"}, "Manchester City" ));
        easy_questions.add(new Easy_question("Who beat Manchester City in the UCL final 2021?", new String[]{"Bayern Munich", "Liverpool", "PSG"}, "Chelsea"));
        easy_questions.add(new Easy_question("Which team in the Premier League has gone <br>"+  " unbeaten in a Premier League season? ?", new String[]{"Manchester United", "Liverpool", "Chelsea"}, "Arsenal"));
        easy_questions.add(new Easy_question("Who is the last person to win the Ballon D'or <br>"+  " when playing in the the Premier League?", new String[]{"Michael Owen", "Thierry Henry", "Luka Modric"}, "Cristiano Ronaldo"));
        easy_questions.add(new Easy_question("Which seria A team won 9 league titles <br>"+  "in a row from 2011-2020?", new String[]{"Napoli", "AC Milan", "Inter Milan "}, "Juventus"));
        easy_questions.add(new Easy_question("Who won the Ballon D'or when playing for AC Milan?", new String[]{"Ronaldo Nazario", "Maldini", "Pirlo"}, "Kaká"));
        easy_questions.add(new Easy_question("Which team won the 2nd most La Liga titles?", new String[]{"Sevilla", "Athletico Madrid", "Real Madrid"}, "Barcelona"));
        easy_questions.add(new Easy_question("Which player has the most goals in La Liga?", new String[]{"Cristiano Ronaldo", "Benzema", "Raúl"}, "Messi"));
        easy_questions.add(new Easy_question("Which team from Germany won the sextuple?", new String[]{"Wolfsburg", "Dortmund", "Frankfurt"}, "Bayern Munich"));
        easy_questions.add(new Easy_question("Which player moved from Dortmund to Manchester United in 2021?", new String[]{"Akanji", "Erling Haaland", "Jude Bellingham"}, "Jadon Sancho"));
        easy_questions.add(new Easy_question("Who scored a hat-trick in the world cup final 2022??", new String[]{"Messi", "Álvarez", "Olivier Giroud"}, "Kylian Mbappé"));
        return easy_questions;
    }
}

class Intermediate_question extends Question{
    public Intermediate_question(String the_question, String [] wrong_answers, String correct_answer){
        super(the_question, wrong_answers, correct_answer, 10);
    }
    public static ArrayList<Question> getIntermediateQuestions(){
        ArrayList<Question> intermediate_questions = new ArrayList<>();
        intermediate_questions.add(new Intermediate_question("Which country has won the most world cups?", new String[]{"Argentina", "Germany", "France"}, "Brazil"));
        intermediate_questions.add(new Intermediate_question("Who scored the EURO 2020 final goal for England?", new String[]{"Rashford", "Kane", "Kalvin Philips"}, "Luke Shaw"));
        intermediate_questions.add(new Intermediate_question("Which team did Arsenal lose to in an 8-2 defeat?", new String[]{"Manchester City", "Liverpool", "Aston Villa"}, "Manchester United"));
        intermediate_questions.add(new Intermediate_question("Who came 2nd place in the Ballon D'or rankings in 2021?", new String[]{"Messi", "Ronaldo", "Jorginho"}, "Lewandowski"));
        intermediate_questions.add(new Intermediate_question("Who last won Dortmund their league title?", new String[]{"Thomas Tuchel", "Marco Rose", "Jürgen Röber"}, "Jürgen Klopp"));
        intermediate_questions.add(new Intermediate_question("Which team won the UCL in 2019?", new String[]{"Tottenham", "Ajax", "Barcelona"}, "Liverpool"));
        intermediate_questions.add(new Intermediate_question("When did Lionel Messi make his professional debut?", new String[]{"2003", "2005", "2001"}, "2004"));
        intermediate_questions.add(new Intermediate_question("Who scored the penalty against Buffon (against PSG) <br> in the"+  " in the round of 16 of the Champions league in 2019?", new String[]{"Paul Pogba", "Lukaku", "Bruno Fernandes"}, "Rashford"));
        return intermediate_questions;
    }
}

class Hard_question extends Question{
    public Hard_question(String the_question, String [] wrong_answers, String correct_answer){
        super(the_question, wrong_answers, correct_answer, 8);
    }

    public static ArrayList<Question> getHardQuestions(){
        ArrayList<Question> hard_questions = new ArrayList<>();
        hard_questions.add(new Hard_question("Who scored a famous bicycle kick against England?", new String[]{"Cristiano Ronaldo", "Eto", "Cavani"}, "Zlatan"));
        hard_questions.add(new Hard_question("Which manager won the UCL with Porto in 2004?", new String[]{"Sir Alex Ferguson", "Arsene Wenger", "Carlo Ancelotti"}, "José Mourinho"));
        hard_questions.add(new Hard_question("Who scored the fastest hat-trick in Premier League history?", new String[]{"Salah", "Eden Hazard", "Wayne Rooney"}, "Sadio Mané"));
        hard_questions.add(new Hard_question("Which team won the Premier League 3 times in a row from 2007-2009?", new String[]{"Manchester City", "Arsenal", "Chelsea"}, "Manchester United"));
        hard_questions.add(new Hard_question("Who scored the famous goal for Man City to win the Premier league over Man United in 2012?", new String[]{"Balotelli", "Carlos Tevez", "Yaya Toure"}, "Sergio Agüero"));
        hard_questions.add(new Hard_question("How many goals did Mourinho's Chelsea side concede in 2004/05 season in the Premier League?", new String[]{"14 goals", "11 goals", "17 goals"}, "15 goals"));
        hard_questions.add(new Hard_question("Which player from Arsenal was sent off against Barcelona in the UCL final 2011??", new String[]{"Thierry Henry", "Jack Wilshere", "Cesc Fàbregas"}, "Van Persie"));
        hard_questions.add(new Hard_question("Which team beat Portugal in the 2004 <br>"+  " UEFA Euros final?", new String[]{"France", "England", "Wales"}, "Greece"));
        return hard_questions;
    }

}




        public class Main implements playable {


            public int play(Player p, int s){
                p.givePoints(0);
                p.show(" Welcome to my football quiz");
                p.delay(3);

                String [] instructions = new String[4];

                instructions[0] = "This is how the quiz works:<br>"+
                        "First, you will be shown the answers on coloured blocks.<br>"+
                        "You will need to memorise where each answer was on its dedicated colour.<br>"+
                        "Next the answers will disappear and the question will show.<br>"+
                        "Simultaneously the coloured blocks will change colours, after they stopped changing<br>"+
                        "you will need to choose the coloured block that had the right answer.<br>";

                instructions[1] = "From questions 1-3 you will have 12 seconds to look at the answers,<br>"+
                        " questions 4-6 you will have 10 seconds to look at the answers,<br>" +
                        "questions 7-9 you will have 8 seconds to look at the answers,<br>" +
                        "For all questions you will have 10 seconds to choose an answer. <br>"+
                        "The questions will gradually become more difficult to test your football knowledge.";

                instructions[2] = "Points System: <br>"+
                        "5 points are deducted for every wrong answer chosen. <br>"+
                        "15 points are won for every correct answer. ";

                instructions[3] = "For demo they will be one question for each difficulty.";

                for (int i = 0; i < 4; i++){

                    p.show(instructions[i]);
                    if (i < 2){
                        p.delay(9);
                        p.show("");
                    }
                    else{
                        p.delay(5);
                    }
                }

                ArrayList<Question> easy_questions = Easy_question.getEasyQuestions();
                ArrayList<Question> intermediate_questions = Intermediate_question.getIntermediateQuestions();
                ArrayList<Question> hard_questions = Hard_question.getHardQuestions();

                Collections.shuffle(easy_questions);
                Collections.shuffle(intermediate_questions);
                Collections.shuffle(hard_questions);


                p.show("Easy question");
                p.delay(3);
                p.show("");
                for(int i=0; i<1 ; i++){
                        p.mixAnswers((i+1) +". "+  easy_questions.get(i).the_question, easy_questions.get(i).wrong_answers, easy_questions.get(i).correct_answer, easy_questions.get(i).time_allowed);
                }

                p.show("Intermediate question");
                p.delay(3);
                p.show("");
                for(int j=0; j<1 ; j++){
                        p.mixAnswers((j+3) +". "+  intermediate_questions.get(j).the_question, intermediate_questions.get(j).wrong_answers, intermediate_questions.get(j).correct_answer, intermediate_questions.get(j).time_allowed);
                }

                p.show("Hard question");
                p.delay(3);
                p.show("");
                for(int k=0; k<1 ; k++){
                        p.mixAnswers((k+5)+ ". "+  hard_questions.get(k).the_question, hard_questions.get(k).wrong_answers, hard_questions.get(k).correct_answer, hard_questions.get(k).time_allowed);
                }

                p.end_quiz();
                return 0;
            }
            public static void main(String[] args) {
                Player player = new Quiz(System.out, System.in);
                int score = 0;
                Main game = new Main();
                game.play(player, score);
            }





        }




