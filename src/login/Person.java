package login;

import java.time.LocalDate;

import games.Scores;

public class Person {
	
	private String name;
	private String surname;
	private String username;
	private LocalDate dateOfBirth;
	private String mail;
	private String password;
	private Scores scores;
	

	Person(String name, String surname, String username, LocalDate dateOfBirth, String mail, String password, Scores scores) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.mail = mail;
		this.password = password;
		this.scores = scores;
	}

	Person(String name, String surname, String username, LocalDate dateOfBirth, String mail, String password) {
		this(name, surname, username, dateOfBirth, mail, password, new Scores());
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Scores getScores() {
		return scores;
	}
	
}
