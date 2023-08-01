import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;
import java.util.Random;

        class Question
        {
            String the_question;
            String [] wrong_answers = new String[3];
            String correct_answer;
            int time_allowed; // This is the time allowed to look at the answers and which coloured block they are on.

        }


        
        
        public class Mini extends player_session{

            private Question create_question(String the_question, String [] wrong_answers, String correct_answer, int time_allowed){
                // Questions are created and returned.
                Question question = new Question();
                question.the_question = the_question;
                question.wrong_answers = wrong_answers;
                question.correct_answer = correct_answer;
                question.time_allowed = time_allowed;
        
                        return question;
            }

            public int play(Player p, int s){
                p.givePoints(0);
                p.show(" Welcome to my football quiz");
                p.delay(3);
        
                String [] instructions = new String[3];
        
                instructions[0] = "This is how the quiz works:<br>"+
                        "First, you will be shown the answers on coloured blocks.<br>"+
                        "You will need to memorise where each answer was on its dedicated colour.<br>"+
                        "Next the answers will disappear and the question will show.<br>"+
                        "Simultaneously the coloured blocks will change colours, after they stopped changing<br>"+
                        "you will need to choose the coloured block that had the right answer.<br>";
        
                instructions[1] = "From questions 1-3 you will have 15 seconds to look at the answers,<br>"+
                        " questions 4-9 you will have 10 seconds to look at the answers,<br>" +
                        "For all questions you will have 10 seconds to choose an answer. <br>"+
                        "The questions will gradually become more difficult to test your football knowledge.";
        
                instructions[2] = "Points System: <br>"+
                        "5 points are deducted for every wrong answer chosen. <br>"+
                        "15 points are won for every correct answer. ";
        
                for (int i = 0; i < 3; i++){
                    p.show(instructions[i]);
                    if (i == 2){
                        p.delay(15);
                        p.show("");
                    }
                    else{
                        p.delay(9);
                    }
                }
        
                ArrayList<Question> easy_questions = new ArrayList<>();
                easy_questions.add(create_question("Which player has won the world cup?", new String[]{"Ronaldo", "Neymar", "Suarez"}, "Messi", 15));
                easy_questions.add(create_question("Which club has the most UCLs?", new String[]{"Bayern Munich", "Arsenal", "AC Milan"}, "Real Madrid", 15));
                easy_questions.add(create_question("Which team recently won the treble?", new String[]{"Real Madrid", "Liverpool", "Barcelona"}, "Manchester City", 15));
                easy_questions.add(create_question("Who beat Manchester City in the UCL final 2021?", new String[]{"Bayern Munich", "Liverpool", "PSG"}, "Chelsea", 15));
                easy_questions.add(create_question("Which team in the Premier League has gone <br>"+  " unbeaten in a Premier League season? ?", new String[]{"Manchester United", "Liverpool", "Chelsea"}, "Arsenal", 15));
                easy_questions.add(create_question("Who is the last person to win the Ballon D'or <br>"+  " when playing in the the Premier League?", new String[]{"Michael Owen", "Thierry Henry", "Luka Modric"}, "Cristiano Ronaldo", 15));
                easy_questions.add(create_question("Which seria A team won 9 league titles <br>"+  "in a row from 2011-2020?", new String[]{"Napoli", "AC Milan", "Inter Milan "}, "Juventus", 15));
                easy_questions.add(create_question("Who won the Ballon D'or when playing for AC Milan?", new String[]{"Ronaldo Nazario", "Maldini", "Pirlo"}, "Kaká", 15));
                easy_questions.add(create_question("Which team won the 2nd most La Liga titles?", new String[]{"Sevilla", "Athletico Madrid", "Real Madrid"}, "Barcelona", 15));
                easy_questions.add(create_question("Which player has the most goals in La Liga?", new String[]{"Cristiano Ronaldo", "Benzema", "Raúl"}, "Messi", 15));
                easy_questions.add(create_question("Which team from Germany won the sextuple?", new String[]{"Wolfsburg", "Dortmund", "Frankfurt"}, "Bayern Munich", 15));
                easy_questions.add(create_question("Which player moved from Dortmund to Manchester United in 2021?", new String[]{"Akanji", "Erling Haaland", "Jude Bellingham"}, "Jadon Sancho", 15));
                easy_questions.add(create_question("Who scored a hat-trick in the world cup final 2022??", new String[]{"Messi", "Álvarez", "Olivier Giroud"}, "Kylian Mbappé", 15));
                Collections.shuffle(easy_questions);
        
                ArrayList<Question> intermediate_questions = new ArrayList<>();
                intermediate_questions.add(create_question("Which country has won the most world cups?", new String[]{"Argentina", "Germany", "France"}, "Brazil", 10));
                intermediate_questions.add(create_question("Who scored the EURO 2020 final goal for England?", new String[]{"Rashford", "Kane", "Kalvin Philips"}, "Luke Shaw", 10));
                intermediate_questions.add(create_question("Which team did Arsenal lose to in an 8-2 defeat?", new String[]{"Manchester City", "Liverpool", "Aston Villa"}, "Manchester United", 10));
                intermediate_questions.add(create_question("Who came 2nd place in the Ballon D'or rankings in 2021?", new String[]{"Messi", "Ronaldo", "Jorginho"}, "Lewandowski", 10));
                intermediate_questions.add(create_question("Who last won Dortmund their league title?", new String[]{"Thomas Tuchel", "Marco Rose", "Jürgen Röber"}, "Jürgen Klopp", 10));
                intermediate_questions.add(create_question("Which team won the UCL in 2019?", new String[]{"Tottenham", "Ajax", "Barcelona"}, "Liverpool", 10));
                intermediate_questions.add(create_question("When did Lionel Messi make his professional debut?", new String[]{"2003", "2005", "2001"}, "2004", 10));
                intermediate_questions.add(create_question("Who scored the penalty against Buffon (against PSG) <br> in the"+  " in the round of 16 of the Champions league in 2019?", new String[]{"Paul Pogba", "Lukaku", "Bruno Fernandes"}, "Rashford", 10));
                Collections.shuffle(intermediate_questions);
        
                ArrayList<Question> hard_questions = new ArrayList<>();
                hard_questions.add(create_question("Who scored a famous bicycle kick against England?", new String[]{"Cristiano Ronaldo", "Eto", "Cavani"}, "Zlatan", 10));
                hard_questions.add(create_question("Which manager won the UCL with Porto in 2004?", new String[]{"Sir Alex Ferguson", "Arsene Wenger", "Carlo Ancelotti"}, "José Mourinho", 10));
                hard_questions.add(create_question("Who scored the fastest hat-trick in Premier League history?", new String[]{"Salah", "Eden Hazard", "Wayne Rooney"}, "Sadio Mané", 10));
                hard_questions.add(create_question("Which team won the Premier League 3 times in a row from 2007-2009?", new String[]{"Manchester City", "Arsenal", "Chelsea"}, "Manchester United", 10));
                hard_questions.add(create_question("Who scored the famous goal for Man City to win the Premier league over Man United in 2012?", new String[]{"Balotelli", "Carlos Tevez", "Yaya Toure"}, "Sergio Agüero", 10));
                hard_questions.add(create_question("How many goals did Mourinho's Chelsea side concede in 2004/05 season in the Premier League?", new String[]{"14 goals", "11 goals", "17 goals"}, "15 goals", 10));
                hard_questions.add(create_question("Which player from Arsenal was sent off against Barcelona in the UCL final 2011??", new String[]{"Thierry Henry", "Jack Wilshere", "Cesc Fàbregas"}, "Van Persie", 10));
                hard_questions.add(create_question("Which team beat Portugal in the 2004 <br>"+  " UEFA Euros final?", new String[]{"France", "England", "Wales"}, "Greece", 10));
                Collections.shuffle(hard_questions);
        
                
                p.show("Easy questions 1-3");
                p.delay(3);
                p.show("");
                for(int i=0; i<3 ; i++){
                        p.mixAnswers((i+1) +". "+  easy_questions.get(i).the_question, easy_questions.get(i).wrong_answers, easy_questions.get(i).correct_answer, easy_questions.get(i).time_allowed);
                }
        
                p.show("Intermediate questions 4-6");
                p.delay(3);
                p.show("");
                for(int j=0; j<3 ; j++){
                        p.mixAnswers((j+3) +". "+  intermediate_questions.get(j).the_question, intermediate_questions.get(j).wrong_answers, intermediate_questions.get(j).correct_answer, intermediate_questions.get(j).time_allowed);
                }
        
                p.show("Hard questions 7-9");
                p.delay(3);
                p.show("");
                for(int k=0; k<3 ; k++){
                        p.mixAnswers((k+5)+ ". "+  hard_questions.get(k).the_question, hard_questions.get(k).wrong_answers, hard_questions.get(k).correct_answer, hard_questions.get(k).time_allowed);
                }
        
                p.end_quiz();
                return 0;
            }

        
        
        
        
        }

