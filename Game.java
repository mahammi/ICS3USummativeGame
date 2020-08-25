//Maham Ali
//ICS3U0


package decisiongame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.Random;

public class Game {


	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, moneyLabel, moneyLabelNumber, intelligenceLabel, athleticismLabel , popularityLabel , intelligenceLabelNumber, athleticismLabelNumber, popularityLabelNumber, ageLabel, ageLabelText;
	int playerMoney, intelligence, athleticism, popularity, mischief, position, friends;
	String playerAge, subject, career, jobLevel;
	
	
	Random rn = new Random();
	
	Font titleFont = new Font("Times New Roman", Font.BOLD, 60);
	Font normalText = new Font("Times New Roman", Font.PLAIN, 24);
	Font barText = new Font("Times New Roman", Font.PLAIN, 16);
	Font endText = new Font("Times New Roman", Font.PLAIN, 25);
	
	JTextArea mainTextArea;
	
	JButton startButton, choice1, choice2, choice3, choice4;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main(String[] args) {
		
		new Game();

	}
	
	
	public Game() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane();
		window.getContentPane().setBackground(Color.black);				//Creating the window
		window.setLayout(null);
		
		
		con = window.getContentPane();						//Container
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);		//Panel for title
		
		titleNameLabel = new JLabel("LIFE SIMULATOR");
		titleNameLabel.setForeground(Color.white);			//Title
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();					//Panel for button
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
	
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);				//Button
		startButton.setFont(normalText);
		startButton.addActionListener(tsHandler);		//Add action that I created
		startButton.setFocusPainted(false);
		
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		window.setVisible(true);
		
	}

	public void createGameScreen(){											////CREATING GAME SCREEN/////
		
		titleNamePanel.setVisible(false);									//hide title screen and start button
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);						//Creating main text panel for all text in the game
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
	
		
		
		mainTextArea = new JTextArea("Main Text Area");
		mainTextArea.setBounds(100,200,600,100);					//Setting boundaries, colour, and font
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalText);
		mainTextArea.setLineWrap(true);		//Wraps text if it's too long
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();							//Creating panel for buttons
		choiceButtonPanel.setBounds(200,350,350,150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));			//Grid with 4 blocks vertically
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");						///// INITIALIZING BUTTONS: size, background colour, text /////
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalText);							//Choice 1 button
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);						//Choice 2 button
		choice2.setFont(normalText);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");					
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);						//Choice 3 button
		choice3.setFont(normalText);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalText);						//Choice 4 button
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		

		playerPanel = new JPanel();						//Panel telling player how much points and money
		con.add(playerPanel);

		playerPanel.setBounds(55,15,676,100);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout (1,5));
		

		moneyLabel = new JLabel("Money:");			//Label for Money: 
		moneyLabel.setFont(barText);
		moneyLabel.setForeground(Color.white);
		playerPanel.add(moneyLabel);
		
		moneyLabelNumber = new JLabel();			//Labels the user's amount of money
		moneyLabelNumber.setFont(barText);
		moneyLabelNumber.setForeground(Color.white);
		playerPanel.add(moneyLabelNumber);
		
		intelligenceLabel = new JLabel("INT: ");		//Label for intelligence
		intelligenceLabel.setFont(barText);
		intelligenceLabel.setForeground(Color.white);
		playerPanel.add(intelligenceLabel);
		
		intelligenceLabelNumber = new JLabel();
		intelligenceLabelNumber.setFont(barText);			//Labels the user's athleticism points
		intelligenceLabelNumber.setForeground(Color.white);
		playerPanel.add(intelligenceLabelNumber);
		
		popularityLabel = new JLabel("POP: ");		//Label for intelligence
		popularityLabel.setFont(barText);
		popularityLabel.setForeground(Color.white);
		playerPanel.add(popularityLabel);
		
		
		
		popularityLabelNumber = new JLabel();
		popularityLabelNumber.setFont(barText);			//Labels the user's athleticism points
		popularityLabelNumber.setForeground(Color.white);
		playerPanel.add(popularityLabelNumber);
		
		athleticismLabel = new JLabel("ATH: ");		//Label for athleticism
		athleticismLabel.setFont(barText);
		athleticismLabel.setForeground(Color.white);
		playerPanel.add(athleticismLabel);
		
		athleticismLabelNumber = new JLabel();
		athleticismLabelNumber.setFont(barText);			//Labels the user's intelligence points
		athleticismLabelNumber.setForeground(Color.white);
		playerPanel.add(athleticismLabelNumber);
		
		ageLabel = new JLabel("Age:");				//Label for Age
		ageLabel.setFont(barText);
		ageLabel.setForeground(Color.white);
		playerPanel.add(ageLabel);
		
		ageLabelText = new JLabel();					//Labels the user's age
		ageLabelText.setFont(barText);
		ageLabelText.setForeground(Color.white);
		playerPanel.add(ageLabelText);
		
		playerSetup();
		
	

	}
	
	
	public void playerSetup(){
		
		playerMoney = 0;
		intelligence = 0;										//Setting up the user
		athleticism = 0;									//At the beginning of the game the user begins with no points
		popularity = 0;
		playerAge = "Newborn";
		moneyLabelNumber.setText("" + playerMoney);
		intelligenceLabelNumber.setText("" + intelligence);
		popularityLabelNumber.setText("" + popularity);
		athleticismLabelNumber.setText("" + athleticism);
		ageLabelText.setText(playerAge);
		
		birth();
		
	}
	
	
	public void birth(){
		position = 1;						//Position variable helps to proceed through the switch case later on in the program
		mainTextArea.setText("Welcome! In this game, you will make decisions as given to progress through the game and earn points and money.\n\nINT = Intelligence Points\nATH = Athleticism Points\nPOP = Popularity Points\n\nWhat time of year were you born in?");
		choice1.setText("Summer");
		choice2.setText("Spring");
		choice3.setText("Fall");
		choice4.setText("Winter");
		mainTextArea.setEditable(false);
	}
				
							//Next 4 methods are birth scenarios for each season, telling the user how they were born
	public void summer(){
		
		choice1.setEnabled(false);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		
		position = 2;
		mainTextArea.setText("What's that sound? Is that a cicada chirping? Oh wait.. it's just you crying. You were just brought home for the first time.\nWelcome to the world.");
		choice1.setText("");
		choice2.setText(">");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void spring(){
		
		choice1.setEnabled(false);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		position = 3;
		
		mainTextArea.setText("Spring showers begin, flowers are blossoming..\nHey look, you were born too. \nWelcome to the world.");
		choice1.setText("");
		choice2.setText(">");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void fall(){
		
		choice1.setEnabled(false);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 4;
		
		mainTextArea.setText("The weather begins to cool down, red and oranges leaves \nfalling from the trees..\nYou take your first breath. Welcome to the world.");
		
		choice1.setText("");
		choice2.setText(">");
		choice3.setText("");
		choice4.setText("");
	}

	public void winter(){
		choice1.setEnabled(false);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 5;
		
		mainTextArea.setText("The bitter wind is blowing outside.\nLuckily, you're held inside the warmth of your home.\nWelcome to the world.");
		choice1.setText("");
		choice2.setText(">");
		choice3.setText("");
		choice4.setText("");
	}
											
	//// User will now start GAINING POINTS from this point until the end of the game ////
	
											/// 	MOTHER SCENARIO 	///
	public void mother() {

		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(false);
		
		playerAge = "Infant";
		ageLabelText.setText("" + playerAge);
		position = 6;
		
		mainTextArea.setText("Months pass by. Your grow older.\nA human begins cradling you in their arms.\n\nIt seems that they have long hair, and are looking at you lovingly.\nThey are cooing you to say something.\nWhat do you do?");
		choice1.setText("Say \"mama\"");
		choice2.setText("Vomit on the human");
		choice3.setText("Cry");
		
	}
	
											//1. say mom : intelligence + 2 
	public void sayMom() {

		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 7;
		intelligence+=2;											//Gaining intelligence because they tried to speak
		intelligenceLabelNumber.setText("" + intelligence);
		
		mainTextArea.setText("Congratulations! You have begun learning how to speak.\nYou gained 2 intelligence points.\nYour mother smiles at you.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
											//2. vomit : mischief + 1
	public void vomit(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 8;
		mainTextArea.setText("The human seems to be slightly annoyed.\nNonetheless, they begin to clean you up.\nYou realize that this person cares for you a lot.\nThis must be your mother.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		mischief++;
	}
											//3. cry: popularity + 2 (because crying grabs attention)
	public void cry() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 9;
		popularity+=2;
		popularityLabelNumber.setText("" + popularity);
		mainTextArea.setText("The human stares at you for a minute.\nYou seem to have caught not only this person's attention, but someone else as well.\nYou realize that these are your parents. Seems like crying will get their attention...\nYou have gained 2 popularity points.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
											///		WALKING SCENARIO	///
	public void walking(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(false);
		
		position = 10;
		mainTextArea.setText("Your parents are sitting in the distance, while you are playing with your toys.\nYou want to reach them quickly.\nWhat will you do?");
		choice1.setText("Use the wall to walk");
		choice2.setText("Get up and walk");
		choice3.setText("Crawl");
		choice4.setText("");
		
	}
	
										//1. wall walk : intelligence + 2
	public void wallWalk(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 11;
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		mainTextArea.setText("You glance to your left and see the wall. Hmm.. it looks like a good way to get up.\n\nYou get a get of the wall and stand yourself up to walk, using the wall to support you.\n\nYou gained 2 intelligence points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
										//2. get up walk : athleticism + 2 
										//2. get up and walk : athleticism + 2
	public void getUpWalk() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 12;
		athleticism+=2;
		athleticismLabelNumber.setText("" + athleticism);
		mainTextArea.setText("Walking for the first time seems daunting...\nYou still try.\nYou stumble a little bit..\n\nYou did it! Congratulations!\nYou have learned how to walk.\n\nYou gained 2 Athleticism points.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
										//3. crawl : 0 points gained
										//3. crawl: nothing happens
	public void crawl() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 13;
		mainTextArea.setText("You crawl over to your parents, as you usually would.\nThey look happy to see you.\nDays continue to pass.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
										
	
										///Become a CHILD///
	public void ageChild() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 14;								//go to kindergarten and become a child
		playerAge = "Child";
		ageLabelText.setText("" + playerAge);
		mainTextArea.setText("Months pass by, as they usually do.\nYou grow older.\nYour mother tells you that it's time for you to start going to school.\nCongratulations on this milestone,\n but get ready for what's to come.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
			
										/// BULLY SCENARIO ///
	public void bully() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(false);
		
		position = 15;															///bully scenario
		mainTextArea.setText("Your mother drops you off at kindergarten.\nYour first days at school go smoothly... until you encounter something you did not expect.\nA bully begins to making fun of you.\nWhat do you do?");
		choice1.setText("Talk to the bully");
		choice2.setText("Tell the teacher");
		choice3.setText("Fight the bully");
		choice4.setText("");
		
	}
	
										// 1. talk to bully: intelligence + 2 , popularity + 2 
										
	public void talkBully() {
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 16;
		popularity+=2;
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		popularityLabelNumber.setText("" + popularity);
		
		mainTextArea.setText("You sit down and talk to the bully.\nTo the contrary, you learn that they are a kind person. They were only taking out their anger because they did not have a friend.\nBut now they do. Congratulations on making your first friend.\n\nYou gained 2 Intelligence points!\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
										// 2. tell teacher : intelligence + 2
										//2. tell the teacher: intelligence + 2
	public void tellTeacher(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 17;
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		mainTextArea.setText("\"I'm glad you came to me,\" your teacher says, \"you did the right thing.\"\nYou made a wise decision.\n\nYou have gained 2 intelligence points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
										// 3. fight bully: mischief + 1
										
	public void fightBully(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		mischief++;
		position = 18;
		mainTextArea.setText("\"Eww. You're so stinky. Why does anyone play with you?\"\n\nYou hear the bully say this, then walk up to them and proceed to punch them square in the nose.\nYour teacher is extremely disappointed in you.\nYour mother ends up arriving to school to pick you up.\nBeing hot-headed was not a good idea.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
										///		LUNCH SCENARIO	///
	public void lunchtime() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);
		
		position = 19;
		mainTextArea.setText("Time passes by. You're now in middle school.\nIt's a new day.\nThe bell rings. Looks like it's time for lunch!\nHow will you spend your lunch?");
		choice1.setText("Talk to new people");
		choice2.setText("Play sports");
		choice3.setText("Read at the library");
		choice4.setText("Go home");
		
	}
		
										// 1. talk people : popularity + 2
										
	public void talkPeople(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 20;
		popularity+=2;
		popularityLabelNumber.setText("" + popularity);
		
		mainTextArea.setText("You go outside and strike up a conversation with some people in the same grade as you.\nAfter getting to know them, you discover that you have a lot in common.\nCongratulations! You made new friends.\n\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	
										// 2. play sports : popularity + 2
									
	public void playSports(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 21;
		athleticism+=2;						
		athleticismLabelNumber.setText("" + athleticism);
	
		mainTextArea.setText("You walk outside and see some of your classmates playing basketball. You decide to join them.\n\"Hey, you're great at basketball! Did you know the school is starting up a team?\"\nYou keep this thought at the back of your head.\n\nYou gained 2 athleticism points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
										// 3. library: intelligence +2
	public void library(){
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		position = 22;
		intelligence+=2;
		intelligenceLabelNumber.setText(""+ intelligence);
		mainTextArea.setText("You walk into the library and settle down at a table.\n\nYou decide to pick up a couple of different books, but there is so much to choose from..\nMystery, fantasy, thriller.. what to read?\nYou spend your lunch perusing through books.\n\nYou gained 2 intelligence points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
										// 4. go home: no points
	public void goHome(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 23;
		mainTextArea.setText("You decide to go home for lunch.\nYou walk the long way home and think about life after middle school.\nBe careful! Don't get lost in your head.\n\nYou spend lunch relaxing at home with your\n father who took the day off.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText(""); 
		
	}
	
										/// 	RUMOUR SCENARIO		 ///
	public void spreadRumour(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);
		
		position = 24;
		mainTextArea.setText("Middle school is slowly coming to an end.\nUnfortunately, you discover that a group of your classmates have began spreading a rumour about you.\nWhat will you do?");
		choice1.setText("Fight them");
		choice2.setText("Tell the teacher");
		choice3.setText("Talk to them");
		choice4.setText("Do nothing");
		
	}

										// 1. fight the people: mischief + 1
	public void fightRumour(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		mischief++;
		position = 25;
		mainTextArea.setText("You walk into school the next day just to see the same group of people looking at you and whispering. One of them turns to you.\n\"Hey, you do know that everybody knows righ-\"\n\nBefore the person could finish, you kick them right in the stomach.\nYou end up in an in-school suspension for the rest of the week.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
										// 2. talk to the teacher: intelligence +2
	public void talkTeacher(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 26;
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		mainTextArea.setText("The rumours begin troubling you even more as days pass by, so you decide to talk to your teacher about it.\nSoon enough, your teacher was able to talk to the group of people and shut the rumuors down.\nYou feel much better now.\n\nYou gained 2 intelligence points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
											//3. talk to the rumour spreaders: intelligence + 2 and popularity +2
										
	public void talkRumour(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 27;
		intelligence+=2;
		popularity+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		popularityLabelNumber.setText("" + popularity);
		
		mainTextArea.setText("You realize that nothing will be clarified unless you address the rumours.You talk to the people who were spreading lies about you.\n\"What? We didn't even expect you to do anything. Well.. I guess we can tell people it was all a lie. Whatever,\" says the lead rumour spreader.\n\nYou gained 2 intelligence points!\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
										
										// 4. do nothing: no points
	public void doNothing(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 28;
		mainTextArea.setText("You decide to let the rumours spread.\nGoing to school for the next few days becomes a little harder, but you push through.\nNext thing you know, the rumours all blow over.\nThings are back to normal.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}

											/// Become YOUNG ADULT  -- HIGH SCHOOL ////
										/// CHOOSE FAVOURITE CLASS SCENARIO///
	public void youngAdult() {
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);
		
		position = 29;
		playerAge = "Y.Adult";
		ageLabelText.setText("" + playerAge);
		mainTextArea.setText("Years pass by.\nYou are now a young adult, and before you know it, it's your first day of high school.\nWhat class will you look forward to the most during your 4 years?");
		choice1.setText("Phys. Ed"); //ath
		choice2.setText("Biology"); // int
		choice3.setText("Math");	//int
		choice4.setText("Drama");	//pop
		
	}
	
									///do good in gym: athleticism+2
	public void physEdGood(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		subject = "gymGood";
		position = 30;
		athleticism+=2;
		mainTextArea.setText("You attend your first gym classes in high school.\nYour classmates are impressed by your athletic capabilities, and so is your teacher.\nYou gained 2 athleticism points!\nYou are approached by your gym teacher.\n\"Would you like to join the school basketball team? You seem cut out for it.\"\nWill you join the team?");
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
	}
	
										//being on sports team: athleticism + 2 , popularity + 2
	public void physEdSportsTeam(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 31;
		
		athleticism+=2;
		popularity+=2;
		athleticismLabelNumber.setText("" + athleticism);
		popularityLabelNumber.setText("" + popularity);
		
		mainTextArea.setText("You decide to join your team's basketball team.\nThis gives you something to work towards during your high school career.\nAnd above all, you have created many new friends.\n\nYou gained 2 athleticism points!\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
										//do bad in gym: nothing happens
	public void physEdBad(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		subject = "gymBad";
		position = 32;
		mainTextArea.setText("You attend your first gym classes in high school.\nYou don't seem to be performing up to par.\n\"You've really got to step it up. You'll start lagging behind everyone else if you continue like this,\" says one of your classmates. Ouch.");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
											//do good in science class: intelligence + 2
	public void biologyGood(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		subject = "biologyGood";
		position = 33;
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		
		mainTextArea.setText("You begin taking an interest in biology in your grade 9 science course.\nYour teacher praises you for your great work in class, \"You should definitely take Biology in your senior classes!\"\nYou gained 2 intelligence points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void bioHelpFriend(){

		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
	
		position = 34;
		
		mainTextArea.setText("A classmate approaches you during class the next day.\n\n\"Hey, I know you're doing really good in this class. Some of us are really having a hard time though, wanna join us at tne library for a study group before exams?\"\n\nWill you join your classmates for a study group?");
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void bioStudyGroup() {

		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 35;
		
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		popularity+=2;
		popularityLabelNumber.setText("" + popularity);

		mainTextArea.setText("You agree to go to the library with your classmates to study for your upcoming exam.\nIt ends up being a good way to study, and you also make new friends.\n\"Thanks for helping us out! You're honestly the best.\"\n\nYou gained 2 intelligence points!\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
											//do bad in bio: nothing happens
	public void biologyBad(){

		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		subject = "biologyBad";
		position = 36;
		
		mainTextArea.setText("You start taking an interest in biology in your first science class in grade 9.\nHowever, you begin noticing that it's a lot for you understand and memorize.\nKeeping up like this may be difficult...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	
											//do good in math: intelligence + 2
	public void mathGood(){

		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		subject = "mathGood";
		position = 37;
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		
		mainTextArea.setText("Math class seems a bit daunting at first, but you know that you enjoy the class.\nYou start off doing well in your first math class.\nYour teacher praises you for your good work.\n\nYou gained 2 intelligence points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void mathContest(){

		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 38;
		
		mainTextArea.setText("Your math teacher approaches you in class the next day.\n\"You really are doing great in this class right now. Would you like to participate in a regional math contest next month?\"\n\nWill you partiicpate in the contest?");
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
		
	}
				
	public void doMathContest() {
		
		position = 39;
		
		intelligence+=2;
		popularity+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		popularityLabelNumber.setText("" + popularity);
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		mainTextArea.setText("");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
						//do bad in math: nothing happens
	public void mathBad(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		subject = "mathBad";
		position = 40;
		
		mainTextArea.setText("You step into your first math class of high school.\nAlthough math seems like it interests you, you quickly realize that it may not be for you.\nYou have trouble keeping up and doing well in the class.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	
											//do good in drama: popularity + 2
	public void dramaGood(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		popularity+=2;
		popularityLabelNumber.setText("" + popularity);
		
		position = 41;
		mainTextArea.setText("You walk into your first drama class, excited to put your acting skills on display.\nThe class begins with an improv activity.\nYour teacher walks up to you, impressed by your skillful acting.\n\"Would you like to audition for the school play?\"\nWill you audition?");
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void dramaPlay(){
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 42;
		
		popularity+=2;
		popularityLabelNumber.setText("" + popularity);
		
		mainTextArea.setText("You audition for the school's play.\n\nCongratulations! You got a role!\n\nYou have fun rehearsing and performing with your crew.\n\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
										//do bad in drama: nothing happens
	public void dramaBad(){

		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 43;
		subject = "dramaGood";
		mainTextArea.setText("You take drama in your first year of high school.\nAlthough you look forward to the class, you discover that acting in front of people may be harder for you than expected..\nYou end up not doing very well in the class.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lunch(){
		
		position = 44;
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);
		
		mainTextArea.setText("Time is flying by. You are now more than half way through high school.\n\nIt's time for lunch!\nWhat will you choose to do for your lunch period?");
		choice1.setText("Catch up in classes");
		choice2.setText("Hang out with friends");
		choice3.setText("Go to intramurals");
		choice4.setText("Go home");
		
	}
										/// catch up: intelligence + 2
	public void catchUp(){
		position = 45;
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		intelligence+=2;
		intelligenceLabelNumber.setText("" + intelligence);
		
		mainTextArea.setText("You head over to the library with some classmates and decide to catch up on your classes.\n\nWith your exams coming up soon, this extra study time comes in handy, especially with friends to help you.\n\nYou gained 2 intelligence points.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
										/// hang out: popularity + 2
	public void hangOut(){
		
		position = 46;
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		popularity+=2;
		popularityLabelNumber.setText("" + popularity);
		
		mainTextArea.setText("You meet up with your friends and decide to head to the mall for lunch.\nYou grab food and spend a great lunch with your friend group, talking and having fun.\n\nYou gained 2 popularity points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
										/// intramurals : athleticism + 2
	public void intramurals(){
		
		position = 47;
		
		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		athleticism+=2;
		athleticismLabelNumber.setText("" + athleticism);
		
		mainTextArea.setText("You stop by your school's gym to play some badminton for the lunch.\nYou have fun, and start getting better at the sport.\n\nYou gained 2 athleticism points!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	
										///home for lunch: nothing happens
	public void homeLunch(){
		

		choice1.setEnabled(true);
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		position = 48;
		
		mainTextArea.setText("You decide to head home for lunch.\nYou think about how high school will be ending soon..\nWhat type of job will you have?\nOnly time can tell.\n\nYou spend the rest of lunch relaxing at home.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void graduationBiology() {
		
		position = 49;
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);

		mainTextArea.setText("High school graduation is near!\nIt's time to decide what you will pursue after high school.\nYou know that you want to pursue a career related to your favourite subject, biology.\nWhat do you want to become after high school?");
		choice1.setText("Doctor");
		choice2.setText("Pharmacologist");
		choice3.setText("Bio Teacher");
		choice4.setText("Lab Biologist");
	
	}
	
	public void graduationDrama() {
		
		position = 50;
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);
		
		mainTextArea.setText("High school graduation is near!\nIt's time to decide what you will pursue after high school.\nYou know that you want to pursue a career related to your favourite subject, drama.\nWhat do you want to become after high school?");
		choice1.setText("Stage Actor");
		choice2.setText("TV Actor");
		choice3.setText("Film Actor");
		choice4.setText("Drama Teacher");
		
	}
	
	public void graduationMath() {
		
		position = 51;
		
		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);

		mainTextArea.setText("High school graduation is near!\nIt's time to decide what you will pursue after high school.\nYou know that you want to pursue a career is related to your favourite subject, math (to some degree).\nWhat do you want to become after high school?");
		choice1.setText("Accountant");
		choice2.setText("Software Dev");
		choice3.setText("Engineer");
		choice4.setText("Physicist");
		
	}
	
	public void graduationPhysEd() {
		
		position = 52;

		choice1.setEnabled(true);
		choice2.setEnabled(true);
		choice3.setEnabled(true);
		choice4.setEnabled(true);
		
		mainTextArea.setText("High school graduation is near!\nIt's time to decide what you will pursue after high school.\nYou know that you want to pursue a career related to your favourite subject, phys. ed.\nWhat do you want to become after high school?");
		choice1.setText("NBA Athlete");
		choice2.setText("Gym Teacher");
		choice3.setText("Personal Trainer");
		choice4.setText("Sports Coach");
	}
	
	public void goodEnding() {
		
		position = 53;
		
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		playerMoney = 1500;
		moneyLabelNumber.setText("" + playerMoney);
		mainTextArea.setText("You continue through the rest of your life \nworking as a " + career + ".\nYou make a good living and, most importantly, enjoy your job.\n\n");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void normalEnding() {
		
		position = 54;
		
		choice2.setEnabled(false);
		choice3.setEnabled(false);
		choice4.setEnabled(false);
		
		
		
		if(mischief>=2) {
			
			playerMoney = 500;
			moneyLabelNumber.setText("" + playerMoney);
			mainTextArea.setText("You continue through the rest of your life \nworking as a " + career + ".\nYou make a liveable amount of money, and your job could be better.\n\n");
		}
		
		else {
			
			playerMoney = 1000;
			moneyLabelNumber.setText("" + playerMoney);
			mainTextArea.setText("You continue through the rest of your life \nworking as a " + career + ".\nYou make a decent living, living normally as others would.");
		}

		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void gameOver() {

		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		mainTextPanel.setBounds(100,100,600,350);
		mainTextArea.setBounds(100,200,600,300);
		mainTextArea.setFont(endText);
		mainTextArea.setText("THE END!\n\nYou Finished With:\n" + intelligence + " Intelligence Points\n" + popularity + " Popularity Points\n" + athleticism + " Athleticism Points\n" + playerMoney + " dollars\nRestart the program to play again.");
	}

	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			createGameScreen();
		}
		
	}
	
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();		//c1 c2 c3 or c4 will be put into this string when button is clicked
																		//Identify which button was clicked
		
			
		switch(position){				/////// THIS ENTIRE SWITCH CASE controls how the user will continue through the game //////
		
		case 1:								//bornSeason			
			if(yourChoice.equals("c1")){
				summer();
				yourChoice = "";
				
			}
			if(yourChoice.equals("c2")){						///// This is where the position variable works./////
				spring();									///Depending on where the user is in the game, certain methods will be called
				yourChoice = "";
			}
			if(yourChoice.equals("c3")){
				fall();
				yourChoice = "";
			}
			if(yourChoice.equals("c4")){
				winter();
				yourChoice = "";
			}
		
		case 2:								//summerBirth
			if(yourChoice.equals("c2")){
				mother();
				yourChoice = "";
			}
		case 3:								//springBirth
			if(yourChoice.equals("c2")){
				mother();
				yourChoice = "";
			}
		
		case 4:								//fallBirth
			if(yourChoice.equals("c2")){
				mother();
				yourChoice = "";
			}
		
		case 5:								//winterBirth
			if(yourChoice.equals("c2")){
				mother();
				yourChoice = "";
			}
																		////////// AGE IS NOW INFANT ///////////
		case 6:								//firstWords
			if(yourChoice.equals("c1")){
				sayMom();
				yourChoice = "";
			}
			if(yourChoice.equals("c2")){
				vomit();
				yourChoice = "";
			}
			if(yourChoice.equals("c3")){
				cry();
				yourChoice = "";
			}
		
		case 7:										//sayMom
			if(yourChoice.equals("c1")){
				walking();
				yourChoice = "";
			}
		case 8:									
			if(yourChoice.equals("c1")){
				walking();							//vomit
				yourChoice = "";
			}
		case 9: 									
			if(yourChoice.equals("c1")){
				walking();	
				yourChoice = "";			//cry
			}
			
			
		case 10:										//Walking
			if(yourChoice.equals("c1")){
				wallWalk();
				yourChoice = "";
			}
			if(yourChoice.equals("c2")){
				getUpWalk();
				yourChoice = "";
			}
			if(yourChoice.equals("c3")){
				crawl();
				yourChoice = "";
			}
			
		case 11:					
			if(yourChoice.equals("c1")){						//wallWalk
				ageChild();
				yourChoice = "";
			}
		case 12:												//getUpWalk
			if(yourChoice.equals("c1")){
				ageChild();
				yourChoice = "";
			}
		case 13: 											//crawl
			if(yourChoice.equals("c1")){
				ageChild();
				yourChoice = "";
			}
	
	
		case 14:													/////// AGE IS NOW CHILD //////
			if(yourChoice.equals("c1")){
				bully();
				yourChoice = "";
			}
		
		case 15:
			if(yourChoice.equals("c1")){
				talkBully();
				yourChoice = "";
			}
			if(yourChoice.equals("c2")){
				tellTeacher();
				yourChoice = "";
			}
			if(yourChoice.equals("c3")){
				fightBully();
				yourChoice = "";
			}
			
		case 16:
			if(yourChoice.equals("c1")){
				lunchtime();
				yourChoice = "";
			}
		
		case 17:
			
			if(yourChoice.equals("c1")){
				lunchtime();
				yourChoice = "";
			}
			
		case 18:
			
			if(yourChoice.equals("c1")){
				lunchtime();
				yourChoice = "";
			}
	
		case 19:
			
			if(yourChoice.equals("c1")){
				talkPeople();
				yourChoice = "";
			}
			
			if (yourChoice.equals("c2")){
				playSports();
				yourChoice = "";
				
			}
			
			if (yourChoice.equals("c3")){
				library();
				yourChoice = "";
				
			}
			
			if (yourChoice.equals("c4")){
				goHome();
				yourChoice = "";
			}
		
		case 20:
			if(yourChoice.equals("c1")){
				spreadRumour();
				yourChoice = "";
			}
			
		case 21:
			if(yourChoice.equals("c1")){
				spreadRumour();
				yourChoice = "";
			}
			
		case 22:
			if(yourChoice.equals("c1")){
				spreadRumour();
				yourChoice = "";
			}
			
		case 23:
			if(yourChoice.equals("c1")){
				spreadRumour();
				yourChoice = "";
						
			}
	
		case 24:
			if(yourChoice.equals("c1")){
				fightRumour();
				yourChoice = "";
			}
			
			if (yourChoice.equals("c2")){
				talkTeacher();
				yourChoice = "";
			}
			
			if (yourChoice.equals("c3")){
				talkRumour();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c4")){
				doNothing();
				yourChoice = "";
			}
		
		case 25:
			
			if(yourChoice.equals("c1")){
				youngAdult();
				yourChoice = "";
			}
		case 26:
			
			if(yourChoice.equals("c1")){
				youngAdult();
				yourChoice = "";
				
			}
		case 27: 
			if(yourChoice.equals("c1")){
				youngAdult();
				yourChoice = "";
				
			}
		case 28:
			if(yourChoice.equals("c1")){
				youngAdult();
				yourChoice = "";
			}
		
		case 29:
			if(yourChoice.equals("c1")){
				
				if(athleticism>=2) {
					physEdGood();
					yourChoice  = "";
				}
				if(athleticism<2) {
					physEdBad();
					yourChoice  = "";
				}
				
			}
			
			if(yourChoice.equals("c2")){
				
				if(intelligence>=4) {
					biologyGood();
					yourChoice  = "";
				}
				
				if(intelligence<4) {
					biologyBad();
					yourChoice  = "";
				}
				
			
			}
			
			if(yourChoice.equals("c3")){
				
				if(intelligence>=4) {
					mathGood();
					yourChoice = "";
				}
				
				if(intelligence<4) {
					mathBad();
					yourChoice  = "";
				}
				
				
				
			}
			
			if(yourChoice.equals("c4")){
				
				if(popularity>2) {
					dramaGood();
					yourChoice  = "";
				}
				
				if(popularity<=2) {
					dramaBad();
					yourChoice  = "";
				}
			}
		
		case 30:
			if(yourChoice.equals("c1")) {
				physEdSportsTeam();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c2")) {
				lunch();
				yourChoice = "";
			}
		case 31:
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
			
		case 32:
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
			
		case 33:
			
			if(yourChoice.equals("c1")) {
				bioHelpFriend();
				yourChoice = "";
			}
			
		case 34:
			
			if(yourChoice.equals("c1")) {
				bioStudyGroup();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c2")) {
				lunch();
				yourChoice = "";
			}
			
		case 35:
			
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
			
		case 36:
			
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
			
		case 37:
			
			if(yourChoice.equals("c1")) {
				mathContest();
				yourChoice = "";
			}
			
		case 38:
			
			if(yourChoice.equals("c1")) {
				doMathContest();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c2")) {
				lunch();
				yourChoice = "";
			}
			
		case 39:
			
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
		
		case 40:
			
			if(yourChoice.equals("c1")){
				lunch();
				yourChoice = "";
			}
			
		case 41:
			
			if(yourChoice.equals("c1")) {
				
				dramaPlay();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c2")) {
				
				lunch();
				yourChoice = "";
			}
			
		case 42:
			
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
			
		case 43:
			
			if(yourChoice.equals("c1")) {
				lunch();
				yourChoice = "";
			}
			
		case 44:
			
			if(yourChoice.equals("c1")) {
				catchUp();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c2")) {
				hangOut();
				yourChoice = "";
			}
			
			if(yourChoice.equals("c3")) {
				intramurals();
				yourChoice = "";
	
			}
			
			if(yourChoice.equals("c4")) {
				homeLunch();
				yourChoice = "";
			}
		case 45:
			
			if(yourChoice.equals("c1")) {
				
				if(subject.equals("gymBad")||subject.equals("gymGood")) {
					graduationPhysEd();
					yourChoice = "";
				}
				
				else if(subject.equals("biologyGood")||subject.equals("biologyBad")){
					graduationBiology();
					yourChoice = "";
				}
				
				else if(subject.equals("dramaGood")||subject.equals("dramaBad")) {
					graduationDrama();
					yourChoice = "";
				}
				
				else if(subject.equals("mathGood")||subject.equals("mathBad")) {
					graduationMath();
					yourChoice = "";
				}
			}
			
		case 46:
			
			if(yourChoice.equals("c1")) {
				
				if(subject.equals("gymBad")||subject.equals("gymGood")) {
					graduationPhysEd();
					yourChoice = "";
				}
				
				else if(subject.equals("biologyGood")||subject.equals("biologyBad")){
					graduationBiology();
					yourChoice = "";
				}
				
				else if(subject.equals("dramaGood")||subject.equals("dramaBad")) {
					graduationDrama();
					yourChoice = "";
				}
				
				else if(subject.equals("mathGood")||subject.equals("mathBad")) {
					graduationMath();
					yourChoice = "";
				}
			}
			
		case 47:
			
			if(yourChoice.equals("c1")) {
				
				if(subject.equals("gymBad")||subject.equals("gymGood")) {
					graduationPhysEd();
					yourChoice = "";
				}
				
				else if(subject.equals("biologyGood")||subject.equals("biologyBad")){
					graduationBiology();
					yourChoice = "";
				}
				
				else if(subject.equals("dramaGood")||subject.equals("dramaBad")) {
					graduationDrama();
					yourChoice = "";
				}
				
				else if(subject.equals("mathGood")||subject.equals("mathBad")) {
					graduationMath();
					yourChoice = "";
				}
			}
			
		case 48:
			
			if(yourChoice.equals("c1")) {
				
				if(subject.equals("gymBad")||subject.equals("gymGood")) {
					graduationPhysEd();
					yourChoice = "";
				}
				
				else if(subject.equals("biologyGood")||subject.equals("biologyBad")){
					graduationBiology();
					yourChoice = "";
				}
				
				else if(subject.equals("dramaGood")||subject.equals("dramaBad")) {
					graduationDrama();
					yourChoice = "";
				}
				
				else if(subject.equals("mathGood")||subject.equals("mathBad")) {
					graduationMath();
					yourChoice = "";
				}
				
			}
		case 49:
			
			if(yourChoice.equals("c1")) {
				career = "Doctor";

				if(subject.equals("biologyGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("biologyBad")) {
					normalEnding();
					yourChoice = "";
				}
						
				
			}
			
			if(yourChoice.equals("c2")) {
				career = "Pharmacologist";
				
				if(subject.equals("biologyGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("biologyBad")) {
					normalEnding();
					yourChoice = "";
				}
				
			}
			
			if(yourChoice.equals("c3")) {
				career = "Biology Teacher";

				if(subject.equals("biologyGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("biologyBad")) {
					normalEnding();
					yourChoice = "";
				}
				
			}
			
			if(yourChoice.equals("c4")) {
				career = "Lab Biologist";

				if(subject.equals("biologyGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("biologyBad")) {
					normalEnding();
					yourChoice = "";
				}
				
			}
			
		case 50:
			
			if(yourChoice.equals("c1")) {
				career = "Stage Actor";
				if(subject.equals("dramaGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("dramaBad")) {
					normalEnding();
					yourChoice = "";
				}
				
			
			}
			
			if(yourChoice.equals("c2")) {
				career = "TV Actor";
				if(subject.equals("dramaGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("dramaBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c3")) {
				career = "Film Actor";
				if(subject.equals("dramaGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("dramaBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c4")) {
				career = "Drama Teacher";
				if(subject.equals("dramaGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("dramaBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
		case 51:
			
			if(yourChoice.equals("c1")) {
				career = "Accountant";
				if(subject.equals("mathGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("mathBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c2")) {
				career = "Software Developer";
				if(subject.equals("mathGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("mathBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c3")) {
				career = "Engineer";
				if(subject.equals("mathGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("mathBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c4")) {
				career = "Physicist";
				if(subject.equals("mathGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("mathBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
		case 52:
			

			if(yourChoice.equals("c1")) {
				career = "NBA Athlete";
				if(subject.equals("gymGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("gymBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c2")) {
				career = "Gym Teacher";
				if(subject.equals("gymGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("gymBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c3")) {
				career = "Personal Trainer";
				if(subject.equals("gymGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("gymBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		
			if(yourChoice.equals("c4")) {
				career = "Sports Coach";
				if(subject.equals("gymGood")) {
					goodEnding();
					yourChoice = "";
				}
				if(subject.equals("gymBad")) {
					normalEnding();
					yourChoice = "";
				}
			
			}
		case 53:
			if(yourChoice.equals("c1")){
				gameOver();
			}
		case 54:
			if(yourChoice.equals("c1")) {
				gameOver();
			}
		
			
			
		}
		
		
			
			
		}		
	}
	
}
	
