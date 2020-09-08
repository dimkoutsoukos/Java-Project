package com.ps.models;

import java.util.Set;

import javax.persistence.*;
@Entity (name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column (name="CLIENT_ID")
	private int clientid;
	@Column (name="CLIENT_NAME")
	private String clientname;
	@Column (name="CLIENT_SURNAME")
	private String clientsurname;
	@Column (name="CLIENT_DRIVING_LICENSE")
	private String clientdrivinglicence;
	@Column (name="CLIENT_ADDRESS")
	private String clientaddress;
	@Column (name="CLIENT_EMAIL")
	private String clientemail;
	@Column (name="CLIENT_TELEPHONE_NO")
	private String clienttelephonenumber;
	@OneToMany(mappedBy = "clientid", cascade = CascadeType.ALL)
	private Set<Rental> rental;
	
	public Client(){
		
	}
	public Client(int clientid) {
		this.clientid=clientid;
	}
	public Client (String clientname, String clientsurname, String clientdrivinglicence, String clientaddress, String clientemail, String clienttelephonenumber) {
		this.clientname=clientname;
		this.clientsurname=clientsurname;
		this.clientdrivinglicence=clientdrivinglicence;
		this.clientaddress=clientaddress;
		this.clientemail=clientemail;
		this.clienttelephonenumber=clienttelephonenumber;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getClientsurname() {
		return clientsurname;
	}
	public void setClientsurname(String clientsurname) {
		this.clientsurname = clientsurname;
	}
	public String getClientdrivinglicence() {
		return clientdrivinglicence;
	}
	public void setClientdrivinglicence(String clientdrivinglicence) {
		this.clientdrivinglicence = clientdrivinglicence;
	}
	public String getClientaddress() {
		return clientaddress;
	}
	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}
	public String getClientemail() {
		return clientemail;
	}
	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}
	public String getClienttelephonenumber() {
		return clienttelephonenumber;
	}
	public void setClienttelephonenumber(String clienttelephonenumber) {
		this.clienttelephonenumber = clienttelephonenumber;
	}
	public Set<Rental> getRental() {
		return rental;
	}
	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}

}
