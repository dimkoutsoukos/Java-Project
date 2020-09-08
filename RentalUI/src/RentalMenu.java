
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;




import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Calendar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RentalMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable storetable;
	private JTable clienttable;
	private JTable vehicletable;
	private JTable rentaltable;
	private JTable availabletable;
	private JTextField textFieldcityid;
	private JTextField textFieldcityname;
	private DefaultTableModel CityTableModel;
	private DefaultTableModel StoreTableModel;
	private DefaultTableModel ClientTableModel;
	private DefaultTableModel VehicleTableModel;
	private DefaultTableModel RentalTableModel;
	private DefaultTableModel AvailableTableModel;
	private JTextField textFieldstroid;
	private JTextField textFieldcityidstore;
	private JTextField textFieldstorename;
	private JTextField textFieldclientid;
	private JTextField textFieldclientname;
	private JTextField textFieldclientsurname;
	private JTextField textFielddrivinglicence;
	private JTextField textFieldclientaddress;
	private JTextField textFieldclientemail;
	private JTextField textFieldphonenumber;
	private JTextField textFieldlicencenumber;
	private JTextField textFieldstoreidvehicle;
	private JTextField textFieldvehiclemodel;
	private JTextField textFieldvehiclefuel;
	private JTextField textFieldvehiclecapacity;
	private JTextField textFieldvehiclerentalcost;
	private JTextField textFieldvehicletype;
	private JTextField textFieldvehiclecategory;
	private JTextField textFieldseatheight;
	private JTextField textFieldluggagesupport;
	private JTextField textFieldseatnumber;
	private JTextField textFielddoornumber;
	private JTextField textFieldrentalid;
	private JTextField textFieldvehiclelicencenumber;
	private JTextField textFieldclientidvehicle;
	private JTextField textFieldpickuplocation;
	private JTextField textFieldreturnto;
	private JTextField textFieldrentalcost;
	private JTextField textFieldgetdate;
	private JTextField textFieldreturndate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalMenu frame = new RentalMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RentalMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		if (table == null) 
	        table = new JTable();
		String[] colName = { "City ID", "City Name"};
		   
	    CityTableModel = (DefaultTableModel) table.getModel();
	    CityTableModel.setColumnIdentifiers(colName);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				
				textFieldcityid.setText(table.getValueAt(rowIndex, 0).toString());
				textFieldcityname.setText(table.getValueAt(rowIndex, 1).toString());

			}
		});
		

		if (storetable == null) 
			storetable = new JTable();
		String[] colName1 = { "Store ID", "City ID", "Store Name"};
		   
		StoreTableModel = (DefaultTableModel) storetable.getModel();
		StoreTableModel.setColumnIdentifiers(colName1);
		storetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		storetable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = storetable.getSelectedRow();
				
				textFieldstroid.setText(storetable.getValueAt(rowIndex, 0).toString());
				textFieldcityidstore.setText(storetable.getValueAt(rowIndex, 1).toString());
				textFieldstorename.setText(storetable.getValueAt(rowIndex, 2).toString());

			}
		});
		if (clienttable == null) 
			clienttable = new JTable();
		String[] colName2 = { "Client ID", "Client Name", "Client Surname", "Client Driving Licence", "Client Address", "Client E-mail", "Client Telephone Number"};
		   
		ClientTableModel = (DefaultTableModel) clienttable.getModel();
		ClientTableModel.setColumnIdentifiers(colName2);
		clienttable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clienttable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = clienttable.getSelectedRow();
				
				textFieldclientid.setText(clienttable.getValueAt(rowIndex, 0).toString());
				textFieldclientname.setText(clienttable.getValueAt(rowIndex, 1).toString());
				textFieldclientsurname.setText(clienttable.getValueAt(rowIndex, 2).toString());
				textFielddrivinglicence.setText(clienttable.getValueAt(rowIndex, 3).toString());
				textFieldclientaddress.setText(clienttable.getValueAt(rowIndex, 4).toString());
				textFieldclientemail.setText(clienttable.getValueAt(rowIndex, 5).toString());
				textFieldphonenumber.setText(clienttable.getValueAt(rowIndex, 6).toString());
				textFieldclientidvehicle.setText(clienttable.getValueAt(rowIndex, 0).toString());
			}
		});
		if (vehicletable == null) 
			vehicletable = new JTable();
		String[] colName3 = { "Vehicle Licence Number", "Store ID", "Vehicle Model", "Vehicle Fuel Type",
				"Vehicle Capacity", "Vehicle Rental Cost", "Vehicle Type", "Vehicle Category", 
				"Bike Seat Hight", "Bike Luggage Support", "Car Number of Seats", "Car Number of Doors"};
		   
		VehicleTableModel = (DefaultTableModel) vehicletable.getModel();
		VehicleTableModel.setColumnIdentifiers(colName3);
		vehicletable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vehicletable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = vehicletable.getSelectedRow();
				
				textFieldlicencenumber.setText(vehicletable.getValueAt(rowIndex, 0).toString());
				textFieldstoreidvehicle.setText(vehicletable.getValueAt(rowIndex, 1).toString());
				textFieldvehiclemodel.setText(vehicletable.getValueAt(rowIndex, 2).toString());
				textFieldvehiclefuel.setText(vehicletable.getValueAt(rowIndex, 3).toString());
				textFieldvehiclecapacity.setText(vehicletable.getValueAt(rowIndex, 4).toString());
				textFieldvehiclerentalcost.setText(vehicletable.getValueAt(rowIndex, 5).toString());
				textFieldvehicletype.setText(vehicletable.getValueAt(rowIndex, 6).toString());
				textFieldvehiclecategory.setText(vehicletable.getValueAt(rowIndex, 7).toString());
				textFieldseatheight.setText(vehicletable.getValueAt(rowIndex, 8).toString());
				textFieldluggagesupport.setText(vehicletable.getValueAt(rowIndex, 9).toString());
				textFieldseatnumber.setText(vehicletable.getValueAt(rowIndex, 10).toString());
				textFielddoornumber.setText(vehicletable.getValueAt(rowIndex, 11).toString());
			}
		});
		if (rentaltable == null) 
			rentaltable = new JTable();
		String[] colName4 = { "Rental ID", "Licence Number of Vehicle", "Cient ID", "Pickup Location",
				"Pickup Datetime", "Return Location", "Return Datetime", "Rental Cost"};
		   
		RentalTableModel = (DefaultTableModel) rentaltable.getModel();
		RentalTableModel.setColumnIdentifiers(colName4);
		rentaltable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rentaltable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = rentaltable.getSelectedRow();
				
				textFieldrentalid.setText(rentaltable.getValueAt(rowIndex, 0).toString());
				textFieldvehiclelicencenumber.setText(rentaltable.getValueAt(rowIndex, 1).toString());
				textFieldclientidvehicle.setText(rentaltable.getValueAt(rowIndex, 2).toString());
				textFieldpickuplocation.setText(rentaltable.getValueAt(rowIndex, 3).toString());
				textFieldreturnto.setText(rentaltable.getValueAt(rowIndex, 5).toString());
				textFieldrentalcost.setText(rentaltable.getValueAt(rowIndex, 7).toString());

			}
		});
		
		if (availabletable == null) 
			availabletable = new JTable();
		String[] colName6 = { "Vehicle Licence Number", "Store ID", "Vehicle Model", "Vehicle Fuel Type",
				"Vehicle Capacity", "Vehicle Rental Cost", "Vehicle Type", "Vehicle Category", 
				"Bike Seat Hight", "Bike Luggage Support", "Car Number of Seats", "Car Number of Doors"};
		   
		AvailableTableModel = (DefaultTableModel) availabletable.getModel();
		AvailableTableModel.setColumnIdentifiers(colName6);
		availabletable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availabletable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = availabletable.getSelectedRow();
				
				
				textFieldvehiclelicencenumber.setText(availabletable.getValueAt(rowIndex, 0).toString());
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1286, 707);
		contentPane.add(tabbedPane);
		
		JPanel Cities = new JPanel();
		tabbedPane.addTab("Cities", null, Cities, null);
		Cities.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(149, 82, 1132, 549);
		Cities.add(scrollPane);
		
		textFieldcityid = new JTextField();
		textFieldcityid.setBounds(21, 158, 116, 22);
		Cities.add(textFieldcityid);
		textFieldcityid.setColumns(10);
		
		textFieldcityname = new JTextField();
		textFieldcityname.setBounds(21, 268, 116, 22);
		Cities.add(textFieldcityname);
		textFieldcityname.setColumns(10);
		
		JLabel lblcityid = new JLabel("City ID:");
		lblcityid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcityid.setHorizontalAlignment(SwingConstants.CENTER);
		lblcityid.setBounds(21, 108, 116, 29);
		Cities.add(lblcityid);
		
		JLabel lblNewLabelcityname = new JLabel("City Name:");
		lblNewLabelcityname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelcityname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelcityname.setBounds(21, 229, 116, 26);
		Cities.add(lblNewLabelcityname);
		
		JButton btnsearchcity = new JButton("Search");
		btnsearchcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadCityDetails();}
		});
		btnsearchcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnsearchcity.setBounds(21, 330, 116, 29);
		Cities.add(btnsearchcity);
		
		JButton btnaddcity = new JButton("Add City");
		btnaddcity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCity();}
		});
		btnaddcity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnaddcity.setBounds(433, 26, 135, 43);
		Cities.add(btnaddcity);
		
		JButton btncitylist = new JButton("City List");
		btncitylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadData();
			}
		});
		btncitylist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btncitylist.setBounds(253, 26, 135, 43);
		Cities.add(btncitylist);
		
		JButton btndeletecity = new JButton("Delete City");
		btndeletecity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteCity();
			}
		});
		btndeletecity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeletecity.setBounds(611, 26, 135, 43);
		Cities.add(btndeletecity);
		
		JButton btnupdatecity = new JButton("Update City");
		btnupdatecity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatecity();
			}
		});
		btnupdatecity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnupdatecity.setBounds(796, 26, 135, 43);
		Cities.add(btnupdatecity);
		
		JButton btnrefresh = new JButton("Refresh List");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadData();
			}
		});
		btnrefresh.setBounds(461, 639, 107, 30);
		Cities.add(btnrefresh);
		
		JButton btnclearlist = new JButton("Clear List");
		btnclearlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearlist();
			}
		});
		btnclearlist.setBounds(742, 639, 107, 30);
		Cities.add(btnclearlist);
		
		JPanel Stores = new JPanel();
		tabbedPane.addTab("Stores", null, Stores, null);
		Stores.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane(storetable);
		scrollPane_1.setBounds(144, 79, 1137, 534);
		Stores.add(scrollPane_1);
		
		JLabel lblstoreid = new JLabel("Store ID:");
		lblstoreid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstoreid.setHorizontalAlignment(SwingConstants.CENTER);
		lblstoreid.setBounds(16, 79, 116, 37);
		Stores.add(lblstoreid);
		
		textFieldstroid = new JTextField();
		textFieldstroid.setBounds(16, 118, 116, 22);
		Stores.add(textFieldstroid);
		textFieldstroid.setColumns(10);
		
		JLabel lblcityidstore = new JLabel("City ID:");
		lblcityidstore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcityidstore.setHorizontalAlignment(SwingConstants.CENTER);
		lblcityidstore.setBounds(16, 168, 116, 37);
		Stores.add(lblcityidstore);
		
		textFieldcityidstore = new JTextField();
		textFieldcityidstore.setText("");
		textFieldcityidstore.setBounds(16, 211, 116, 22);
		Stores.add(textFieldcityidstore);
		textFieldcityidstore.setColumns(10);
		
		JLabel lblstorename = new JLabel("Store Name:");
		lblstorename.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstorename.setHorizontalAlignment(SwingConstants.CENTER);
		lblstorename.setBounds(16, 271, 116, 37);
		Stores.add(lblstorename);
		
		textFieldstorename = new JTextField();
		textFieldstorename.setBounds(16, 310, 116, 22);
		Stores.add(textFieldstorename);
		textFieldstorename.setColumns(10);
		
		JButton btnstorelist = new JButton("Store List");
		
		btnstorelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getStores();
			}
		});
		btnstorelist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnstorelist.setBounds(261, 23, 163, 43);
		Stores.add(btnstorelist);
		
		JButton btnaddstore = new JButton("Add Store");
		btnaddstore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStore();
			}
		});
		btnaddstore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnaddstore.setBounds(515, 23, 163, 43);
		Stores.add(btnaddstore);
		
		JButton btndeletestore = new JButton("Delete Store");
		btndeletestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteStore();
			}
		});
		btndeletestore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeletestore.setBounds(756, 23, 163, 43);
		Stores.add(btndeletestore);
		
		JButton btnupdatestore = new JButton("Update Store");
		btnupdatestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateStore();
			}
		});
		btnupdatestore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnupdatestore.setBounds(977, 23, 163, 43);
		Stores.add(btnupdatestore);
		
		JButton btnrefreshstore = new JButton("Refresh");
		btnrefreshstore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getStores();
			}
		});
		btnrefreshstore.setBounds(425, 626, 97, 25);
		Stores.add(btnrefreshstore);
		
		JButton btnclearstore = new JButton("Clear List");
		btnclearstore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearstores();
			}
		});
		btnclearstore.setBounds(931, 626, 97, 25);
		Stores.add(btnclearstore);
		
		JButton btnsearchstore = new JButton("Search");
		btnsearchstore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getstoredetails();
			}
		});
		btnsearchstore.setBounds(16, 400, 116, 22);
		Stores.add(btnsearchstore);
		
		
		
		JPanel Clients = new JPanel();
		tabbedPane.addTab("Clients", null, Clients, null);
		Clients.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane(clienttable);
		scrollPane_2.setBounds(144, 82, 1137, 554);
		Clients.add(scrollPane_2);
		
		JButton btnclientlist = new JButton("Client List");
		btnclientlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientList();
			}
		});
		btnclientlist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnclientlist.setBounds(169, 13, 148, 56);
		Clients.add(btnclientlist);
		
		JButton btnaddclient = new JButton("Add Client");
		btnaddclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientAdd();
			}
		});
		btnaddclient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnaddclient.setBounds(357, 13, 148, 56);
		Clients.add(btnaddclient);
		
		JButton btndeleteclient = new JButton("Delete Client");
		btndeleteclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientDelete();
			}
		});
		btndeleteclient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeleteclient.setBounds(558, 13, 148, 56);
		Clients.add(btndeleteclient);
		
		JButton btnupdateclient = new JButton("Update Client");
		btnupdateclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientUpdate();
			}
		});
		btnupdateclient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnupdateclient.setBounds(751, 13, 148, 56);
		Clients.add(btnupdateclient);
		
		JButton btnrefreshclients = new JButton("Refresh");
		btnrefreshclients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientList();
			}
		});
		btnrefreshclients.setBounds(316, 645, 97, 25);
		Clients.add(btnrefreshclients);
		
		JButton btnclearclients = new JButton("Clear List");
		btnclearclients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientClear();
			}
		});
		btnclearclients.setBounds(719, 645, 97, 25);
		Clients.add(btnclearclients);
		
		JLabel lblclientid = new JLabel("Client ID:");
		lblclientid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientid.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientid.setBounds(12, 82, 120, 33);
		Clients.add(lblclientid);
		
		textFieldclientid = new JTextField();
		textFieldclientid.setBounds(16, 111, 116, 22);
		Clients.add(textFieldclientid);
		textFieldclientid.setColumns(10);
		
		JLabel lblclientname = new JLabel("Client Name:");
		lblclientname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientname.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientname.setBounds(12, 146, 120, 33);
		Clients.add(lblclientname);
		
		textFieldclientname = new JTextField();
		textFieldclientname.setBounds(16, 184, 116, 22);
		Clients.add(textFieldclientname);
		textFieldclientname.setColumns(10);
		
		JLabel lblclientsurname = new JLabel("Client Surname:");
		lblclientsurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientsurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientsurname.setBounds(12, 219, 120, 25);
		Clients.add(lblclientsurname);
		
		textFieldclientsurname = new JTextField();
		textFieldclientsurname.setBounds(16, 249, 116, 22);
		Clients.add(textFieldclientsurname);
		textFieldclientsurname.setColumns(10);
		
		JLabel lblclientdrivinglicence = new JLabel("Driving Licence:");
		lblclientdrivinglicence.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientdrivinglicence.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientdrivinglicence.setBounds(12, 284, 120, 33);
		Clients.add(lblclientdrivinglicence);
		
		textFielddrivinglicence = new JTextField();
		textFielddrivinglicence.setBounds(16, 315, 116, 22);
		Clients.add(textFielddrivinglicence);
		textFielddrivinglicence.setColumns(10);
		
		JLabel lblclientaddress = new JLabel("Client's Address:");
		lblclientaddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientaddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientaddress.setBounds(12, 350, 120, 33);
		Clients.add(lblclientaddress);
		
		textFieldclientaddress = new JTextField();
		textFieldclientaddress.setBounds(16, 380, 116, 22);
		Clients.add(textFieldclientaddress);
		textFieldclientaddress.setColumns(10);
		
		JLabel lblclientemail = new JLabel("Client's E-Mail:");
		lblclientemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientemail.setBounds(12, 415, 120, 33);
		Clients.add(lblclientemail);
		
		textFieldclientemail = new JTextField();
		textFieldclientemail.setBounds(16, 451, 116, 22);
		Clients.add(textFieldclientemail);
		textFieldclientemail.setColumns(10);
		
		JLabel lblclientphonenumber = new JLabel("Phone Number:");
		lblclientphonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientphonenumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientphonenumber.setBounds(12, 486, 120, 33);
		Clients.add(lblclientphonenumber);
		
		textFieldphonenumber = new JTextField();
		textFieldphonenumber.setBounds(16, 525, 116, 22);
		Clients.add(textFieldphonenumber);
		textFieldphonenumber.setColumns(10);
		
		JButton btnsearchclient = new JButton("Search");
		btnsearchclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientDetails();
			}
		});
		btnsearchclient.setBounds(24, 574, 97, 25);
		Clients.add(btnsearchclient);
		
		
		JPanel Rental = new JPanel();
		tabbedPane.addTab("Rental", null, Rental, null);
		Rental.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane(availabletable);
		scrollPane_4.setBounds(135, 43, 1134, 185);
		Rental.add(scrollPane_4);
		
		JScrollPane scrollPane_5 = new JScrollPane(rentaltable);
		scrollPane_5.setBounds(135, 307, 1134, 301);
		Rental.add(scrollPane_5);
		
		JLabel lblavailability = new JLabel("Available Vehicles");
		lblavailability.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblavailability.setHorizontalAlignment(SwingConstants.CENTER);
		lblavailability.setBounds(575, 0, 252, 41);
		Rental.add(lblavailability);
		
		JLabel lblrentalid = new JLabel("Rental ID:");
		lblrentalid.setHorizontalAlignment(SwingConstants.CENTER);
		lblrentalid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrentalid.setBounds(12, 43, 111, 28);
		Rental.add(lblrentalid);
		
		textFieldrentalid = new JTextField();
		textFieldrentalid.setBounds(7, 66, 116, 22);
		Rental.add(textFieldrentalid);
		textFieldrentalid.setColumns(10);
		
		JLabel lblvehiclelicencenumber = new JLabel("Vehicle Number:");
		lblvehiclelicencenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclelicencenumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclelicencenumber.setBounds(12, 101, 111, 28);
		Rental.add(lblvehiclelicencenumber);
		
		textFieldvehiclelicencenumber = new JTextField();
		textFieldvehiclelicencenumber.setBounds(7, 130, 116, 22);
		Rental.add(textFieldvehiclelicencenumber);
		textFieldvehiclelicencenumber.setColumns(10);
		
		JLabel lblclientidvehicle = new JLabel("Client's ID:");
		lblclientidvehicle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblclientidvehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblclientidvehicle.setBounds(12, 165, 111, 28);
		Rental.add(lblclientidvehicle);
		
		textFieldclientidvehicle = new JTextField();
		textFieldclientidvehicle.setBounds(7, 195, 116, 22);
		Rental.add(textFieldclientidvehicle);
		textFieldclientidvehicle.setColumns(10);
		
		JLabel lblNewLabelpickuplocation = new JLabel("Pickup From:");
		lblNewLabelpickuplocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelpickuplocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelpickuplocation.setBounds(12, 230, 111, 28);
		Rental.add(lblNewLabelpickuplocation);
		
		textFieldpickuplocation = new JTextField();
		textFieldpickuplocation.setBounds(7, 260, 116, 22);
		Rental.add(textFieldpickuplocation);
		textFieldpickuplocation.setColumns(10);
		
		JLabel lblpickuptime = new JLabel("Pickup Datetime:");
		lblpickuptime.setHorizontalAlignment(SwingConstants.CENTER);
		lblpickuptime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpickuptime.setBounds(12, 295, 111, 28);
		Rental.add(lblpickuptime);
		

		
		JLabel lblreturnlocation = new JLabel("Return To:");
		lblreturnlocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturnlocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblreturnlocation.setBounds(12, 359, 111, 28);
		Rental.add(lblreturnlocation);
		
		textFieldreturnto = new JTextField();
		textFieldreturnto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldreturnto.setBounds(12, 387, 116, 22);
		Rental.add(textFieldreturnto);
		textFieldreturnto.setColumns(10);
		
		JLabel lblreturndatetime = new JLabel("Return Datetime:");
		lblreturndatetime.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturndatetime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblreturndatetime.setBounds(7, 422, 116, 28);
		Rental.add(lblreturndatetime);
		

		
		JLabel lblrentalcost = new JLabel("Rental Cost:");
		lblrentalcost.setHorizontalAlignment(SwingConstants.CENTER);
		lblrentalcost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrentalcost.setBounds(12, 483, 111, 28);
		Rental.add(lblrentalcost);
		
		textFieldrentalcost = new JTextField();
		textFieldrentalcost.setBounds(7, 509, 116, 22);
		Rental.add(textFieldrentalcost);
		textFieldrentalcost.setColumns(10);
		
		JLabel lblvehiclecat = new JLabel("Vehicle Type:");
		lblvehiclecat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclecat.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclecat.setBounds(12, 544, 111, 28);
		Rental.add(lblvehiclecat);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Compact", "Midrange", "Van", "Bike", "Motorcycle"}));
		comboBox.setBounds(12, 572, 111, 28);
		Rental.add(comboBox);
		
		JButton btngetavailability = new JButton("Check Availability");
		btngetavailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object varName = (Object)comboBox.getSelectedItem();
				String value = comboBox.getSelectedItem().toString();
				System.out.println(value);
				try {
					availableList(value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btngetavailability.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btngetavailability.setBounds(164, 241, 141, 41);
		Rental.add(btngetavailability);
		
		JButton btnrentallist = new JButton("Rental List");
		btnrentallist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalList();
			}
		});
		btnrentallist.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnrentallist.setBounds(337, 241, 141, 41);
		Rental.add(btnrentallist);
		
		JButton btnaddrental = new JButton("Add Rental");
		btnaddrental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalAdd();
			}
		});
		btnaddrental.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnaddrental.setBounds(504, 241, 141, 41);
		Rental.add(btnaddrental);
		
		JButton btndeleterental = new JButton("Delete Rental");
		btndeleterental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalDelete();
			}
		});
		btndeleterental.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btndeleterental.setBounds(681, 241, 132, 41);
		Rental.add(btndeleterental);
		
		JButton btnupdaterental = new JButton("Update Rental");
		btnupdaterental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalUpdate();
			}
		});
		btnupdaterental.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnupdaterental.setBounds(845, 241, 141, 41);
		Rental.add(btnupdaterental);
		
		JButton btnrefreshrental = new JButton("Refresh");
		btnrefreshrental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalList();
			}
		});
		btnrefreshrental.setBounds(265, 628, 97, 25);
		Rental.add(btnrefreshrental);
		
		JButton btnclearrental = new JButton("Clear");
		btnclearrental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearrentalList();
			}
		});
		btnclearrental.setBounds(783, 628, 97, 25);
		Rental.add(btnclearrental);
		
		JButton btnrentaldetails = new JButton("Search");
		btnrentaldetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rentalDetails();
			}
		});
		btnrentaldetails.setBounds(12, 628, 97, 25);
		Rental.add(btnrentaldetails);
		
		textFieldgetdate = new JTextField();
		textFieldgetdate.setBounds(7, 320, 116, 22);
		Rental.add(textFieldgetdate);
		textFieldgetdate.setColumns(10);
		
		textFieldreturndate = new JTextField();
		textFieldreturndate.setBounds(7, 447, 116, 22);
		Rental.add(textFieldreturndate);
		textFieldreturndate.setColumns(10);
		

		
		JPanel Vehicle = new JPanel();
		tabbedPane.addTab("Vehicle", null, Vehicle, null);
		Vehicle.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane(vehicletable);
		scrollPane_3.setBounds(137, 83, 1132, 537);
		Vehicle.add(scrollPane_3);
		
		JButton btnvehiclelist = new JButton("Vehicle List");
		btnvehiclelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicleList();
			}
		});
		btnvehiclelist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnvehiclelist.setBounds(137, 13, 147, 57);
		Vehicle.add(btnvehiclelist);
		
		JButton btnaddvehicle = new JButton("Add Vehicle");
		btnaddvehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicleAdd();
			}
		});
		btnaddvehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnaddvehicle.setBounds(341, 13, 147, 57);
		Vehicle.add(btnaddvehicle);
		
		JButton btndeletevehicle = new JButton("Delete Vehicle");
		btndeletevehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicleDelete();
			}
		});
		btndeletevehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeletevehicle.setBounds(549, 13, 147, 57);
		Vehicle.add(btndeletevehicle);
		
		JButton btnupdatevehicle = new JButton("Update Vehicle");
		btnupdatevehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicleUpdate();
			}
		});
		btnupdatevehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnupdatevehicle.setBounds(749, 13, 147, 57);
		Vehicle.add(btnupdatevehicle);
		
		JButton btnrefreshvehicles = new JButton("Refresh");
		btnrefreshvehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicleList();
			}
		});
		btnrefreshvehicles.setBounds(147, 633, 97, 25);
		Vehicle.add(btnrefreshvehicles);
		
		JButton btnclearvehicles = new JButton("Clear List");
		btnclearvehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearVehicles();
			}
		});
		btnclearvehicles.setBounds(256, 633, 97, 25);
		Vehicle.add(btnclearvehicles);
		
		JLabel lbllicencenumber = new JLabel("Licence Number:");
		lbllicencenumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbllicencenumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbllicencenumber.setBounds(12, 13, 113, 25);
		Vehicle.add(lbllicencenumber);
		
		textFieldlicencenumber = new JTextField();
		textFieldlicencenumber.setBounds(9, 32, 116, 22);
		Vehicle.add(textFieldlicencenumber);
		textFieldlicencenumber.setColumns(10);
		
		JLabel lblstoreidvehicle = new JLabel("StoreID located:");
		lblstoreidvehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblstoreidvehicle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblstoreidvehicle.setBounds(0, 67, 125, 25);
		Vehicle.add(lblstoreidvehicle);
		
		textFieldstoreidvehicle = new JTextField();
		textFieldstoreidvehicle.setBounds(9, 91, 116, 22);
		Vehicle.add(textFieldstoreidvehicle);
		textFieldstoreidvehicle.setColumns(10);
		
		JLabel lblvehiclemodel = new JLabel("Vehicle Model:");
		lblvehiclemodel.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclemodel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclemodel.setBounds(12, 126, 113, 25);
		Vehicle.add(lblvehiclemodel);
		
		textFieldvehiclemodel = new JTextField();
		textFieldvehiclemodel.setBounds(9, 148, 116, 22);
		Vehicle.add(textFieldvehiclemodel);
		textFieldvehiclemodel.setColumns(10);
		
		JLabel lblvehiclefuel = new JLabel("Vehicle Fuel:");
		lblvehiclefuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclefuel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclefuel.setBounds(12, 183, 113, 25);
		Vehicle.add(lblvehiclefuel);
		
		textFieldvehiclefuel = new JTextField();
		textFieldvehiclefuel.setBounds(9, 207, 116, 22);
		Vehicle.add(textFieldvehiclefuel);
		textFieldvehiclefuel.setColumns(10);
		
		JLabel lblvehiclecapacity = new JLabel("Vehicle Capacity:");
		lblvehiclecapacity.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclecapacity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclecapacity.setBounds(12, 242, 113, 25);
		Vehicle.add(lblvehiclecapacity);
		
		textFieldvehiclecapacity = new JTextField();
		textFieldvehiclecapacity.setBounds(9, 266, 116, 22);
		Vehicle.add(textFieldvehiclecapacity);
		textFieldvehiclecapacity.setColumns(10);
		
		JLabel lblvehiclerentalcost = new JLabel("Rental Cost:");
		lblvehiclerentalcost.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclerentalcost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclerentalcost.setBounds(12, 301, 113, 25);
		Vehicle.add(lblvehiclerentalcost);
		
		textFieldvehiclerentalcost = new JTextField();
		textFieldvehiclerentalcost.setBounds(9, 320, 116, 22);
		Vehicle.add(textFieldvehiclerentalcost);
		textFieldvehiclerentalcost.setColumns(10);
		
		JLabel lblvehicletype = new JLabel("Vehicle Type:");
		lblvehicletype.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehicletype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehicletype.setBounds(12, 355, 113, 25);
		Vehicle.add(lblvehicletype);
		
		textFieldvehicletype = new JTextField();
		textFieldvehicletype.setBounds(9, 377, 116, 22);
		Vehicle.add(textFieldvehicletype);
		textFieldvehicletype.setColumns(10);
		
		JLabel lblvehiclecategoty = new JLabel("Vehicle Category:");
		lblvehiclecategoty.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehiclecategoty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblvehiclecategoty.setBounds(12, 412, 113, 25);
		Vehicle.add(lblvehiclecategoty);
		
		textFieldvehiclecategory = new JTextField();
		textFieldvehiclecategory.setBounds(9, 435, 116, 22);
		Vehicle.add(textFieldvehiclecategory);
		textFieldvehiclecategory.setColumns(10);
		
		JLabel lblseatheight = new JLabel("Seat Height:");
		lblseatheight.setHorizontalAlignment(SwingConstants.CENTER);
		lblseatheight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblseatheight.setBounds(12, 470, 113, 25);
		Vehicle.add(lblseatheight);
		
		textFieldseatheight = new JTextField();
		textFieldseatheight.setBounds(9, 492, 116, 22);
		Vehicle.add(textFieldseatheight);
		textFieldseatheight.setColumns(10);
		
		JLabel lblluggagesupport = new JLabel("Luggage Support:");
		lblluggagesupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblluggagesupport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblluggagesupport.setBounds(12, 527, 113, 25);
		Vehicle.add(lblluggagesupport);
		
		textFieldluggagesupport = new JTextField();
		textFieldluggagesupport.setBounds(9, 547, 116, 22);
		Vehicle.add(textFieldluggagesupport);
		textFieldluggagesupport.setColumns(10);
		
		JLabel lblseatnumber = new JLabel("Seat Number:");
		lblseatnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblseatnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblseatnumber.setBounds(12, 576, 113, 25);
		Vehicle.add(lblseatnumber);
		
		textFieldseatnumber = new JTextField();
		textFieldseatnumber.setBounds(9, 598, 116, 22);
		Vehicle.add(textFieldseatnumber);
		textFieldseatnumber.setColumns(10);
		
		JLabel lbldoornumber = new JLabel("Door Number:");
		lbldoornumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbldoornumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldoornumber.setBounds(12, 625, 113, 25);
		Vehicle.add(lbldoornumber);
		
		textFielddoornumber = new JTextField();
		textFielddoornumber.setBounds(9, 648, 116, 22);
		Vehicle.add(textFielddoornumber);
		textFielddoornumber.setColumns(10);
		
		JButton btnsearchvehicle = new JButton("Search Vehicle");
		btnsearchvehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicleDetails();
			}
		});
		btnsearchvehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnsearchvehicle.setBounds(944, 14, 147, 56);
		Vehicle.add(btnsearchvehicle);
		
		JButton btngetcars = new JButton("Car List");
		btngetcars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carList();
			}
		});
		btngetcars.setBounds(365, 633, 97, 25);
		Vehicle.add(btngetcars);
		
		JButton btngetbikes = new JButton("Bike List");
		btngetbikes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				twowheeledList();
			}
		});
		btngetbikes.setBounds(474, 633, 105, 25);
		Vehicle.add(btngetbikes);
		
		JButton btngetcompact = new JButton("Compact List");
		btngetcompact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compactList();
			}
		});
		btngetcompact.setBounds(591, 633, 105, 25);
		Vehicle.add(btngetcompact);
		
		JButton btngetmidrange = new JButton("Midrange List");
		btngetmidrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				midrangeList();
			}
		});
		btngetmidrange.setBounds(708, 633, 113, 25);
		Vehicle.add(btngetmidrange);
		
		JButton btngetvan = new JButton("Van List");
		btngetvan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vanList();
			}
		});
		btngetvan.setBounds(833, 633, 97, 25);
		Vehicle.add(btngetvan);
		
		JButton btngetbikelist = new JButton("Motorcycle List");
		btngetbikelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bikeList();
			}
		});
		btngetbikelist.setBounds(944, 633, 125, 25);
		Vehicle.add(btngetbikelist);
		
		JButton btngetscooter = new JButton("Scooter List");
		btngetscooter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scooterList();
			}
		});
		btngetscooter.setBounds(1081, 633, 113, 25);
		Vehicle.add(btngetscooter);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Logout", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(573, 250, 170, 69);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Thanks for your Work");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(521, 109, 297, 84);
		panel.add(lblNewLabel);
	}
		private void loadData() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/citymanage/retrieve");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("CityList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[2];
			        	  data[0]=sjo.get("City ID");
			        	  data[1]=sjo.get("City Name");
			        	  System.out.println(sjo.get("City ID")); 
			        	  System.out.println(sjo.get("City Name")); 
			        	  CityTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          CityTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void loadCityDetails() {
			try {
				URL url = new URL("http://localhost:8080/CarRental/citymanage/getcitydetails?cityname="+textFieldcityname.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JOptionPane.showMessageDialog(contentPane, jo.toString());
			       }catch(JSONException ex) {};
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }

		}
		

		private void addCity() {
			try {

				URL url = new URL("http://localhost:8080/CarRental/citymanage/register?cityname="+textFieldcityname.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);

				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "City "+textFieldcityname.getText().replace(" ","%20")+" registered successfully!");
				conn.disconnect();
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			
		
		}
		
		private void deleteCity() {
			int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this city?", "Delete", JOptionPane.YES_NO_OPTION);
			if(p==0) {				
			try {

				URL url = new URL("http://localhost:8080/CarRental/citymanage/delete?cityname="+textFieldcityname.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "City "+textFieldcityname.getText().replace(" ","%20")+" deleted successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			}
		
		}
		
		private void clearlist() {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
	        CityTableModel.fireTableDataChanged();
	        textFieldcityid.setText(null);
	        textFieldcityname.setText(null);
			
		}
		private void updatecity() {

			try {
				int id = Integer.parseInt(textFieldcityid.getText());
				URL url = new URL("http://localhost:8080/CarRental/citymanage/update?cityid="+id+"&cityname="+textFieldcityname.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "City "+textFieldcityname.getText().replace(" ","%20")+" updated successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			
		
		}
		private void getStores() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/storemanage/retrieve");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) storetable.getModel();
				model.setRowCount(0);
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("StoreList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[3];
			        	  data[0]=sjo.get("Store ID");
			        	  data[1]=sjo.get("City ID");
			        	  data[2]=sjo.get("Store Name");
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("City ID")); 
			        	  System.out.println(sjo.get("Store Name")); 
			        	  StoreTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          StoreTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void getstoredetails() {
			try {
				URL url = new URL("http://localhost:8080/CarRental/storemanage/getstoredetails?storename="+textFieldstorename.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JOptionPane.showMessageDialog(contentPane, jo.toString());
			       }catch(JSONException ex) {};
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }

		}
		private void addStore() {
			try {
				int id = Integer.parseInt(textFieldcityidstore.getText());
				URL url = new URL("http://localhost:8080/CarRental/storemanage/register?cityid="+id+"&storename="+textFieldstorename.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);

				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Store "+textFieldstorename.getText().replace(" ","%20")+" registered successfully!");
				conn.disconnect();
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			
		
		}
		private void deleteStore() {
			int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this store?", "Delete", JOptionPane.YES_NO_OPTION);
			if(p==0) {				
			try {
				int id = Integer.parseInt(textFieldstroid.getText());
				URL url = new URL("http://localhost:8080/CarRental/storemanage/delete?storeid="+id);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Store "+textFieldstorename.getText().replace(" ","%20")+" deleted successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			}
		}
		
		private void updateStore() {

			try {
				int id = Integer.parseInt(textFieldstroid.getText());
				URL url = new URL("http://localhost:8080/CarRental/storemanage/update?storeid="+id+"&storename="+textFieldstorename.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Store "+textFieldstorename.getText().replace(" ","%20")+" updated successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		
		private void clearstores() {
			DefaultTableModel model = (DefaultTableModel) storetable.getModel();
			model.setRowCount(0);
	        StoreTableModel.fireTableDataChanged();
	        textFieldstroid.setText(null);
	        textFieldcityidstore.setText(null);
	        textFieldstorename.setText(null);
			
		}
		
		private void clientList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/clientmanage/retrieve");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) clienttable.getModel();
				model.setRowCount(0);
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("ClientList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[7];
			        	  data[0]=sjo.get("Client ID");
			        	  data[1]=sjo.get("Client Name");
			        	  data[2]=sjo.get("Client Surname");
			        	  data[3]=sjo.get("Client Driving Licence");
			        	  data[4]=sjo.get("Client Address");
			        	  data[5]=sjo.get("Client E-mail");
			        	  data[6]=sjo.get("Client Telephone Number");
			        	  System.out.println(sjo.get("Client ID")); 
			        	  System.out.println(sjo.get("Client Name")); 
			        	  System.out.println(sjo.get("Client Surname")); 
			        	  System.out.println(sjo.get("Client Driving Licence"));
			        	  System.out.println(sjo.get("Client Address")); 
			        	  System.out.println(sjo.get("Client E-mail"));
			        	  System.out.println(sjo.get("Client Telephone Number"));
			        	  ClientTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          ClientTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		

		private void clientDetails() {
			try {
				URL url = new URL("http://localhost:8080/CarRental/clientmanage/getclientdetails?clientnamer="
				+textFieldclientname.getText().replace(" ","%20")+"&clienttelephonenumber="+textFieldphonenumber.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JOptionPane.showMessageDialog(contentPane, jo.toString());
			       }catch(JSONException ex) {};
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }

		}
		
		private void clientAdd() {
			try {
				URL url = new URL("http://localhost:8080/CarRental/clientmanage/register?clientname="+textFieldclientname.getText().replace(" ","%20")+
						"&clientsurname="+textFieldclientsurname.getText().replace(" ","%20")+"&clientdrivinglicence="+textFielddrivinglicence.getText().replace(" ","%20")+
						"&clientaddress="+textFieldclientaddress.getText().replace(" ","%20")+"&clientemail="+textFieldclientemail.getText().replace(" ","%20")+
						"&clienttelephonenumber="+textFieldphonenumber.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);

				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Client "+textFieldclientname.getText().replace(" ","%20")+
						" "+textFieldclientsurname.getText().replace(" ","%20")+" registered successfully!");
				conn.disconnect();
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			
		
		}

		private void clientDelete() {
			int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this client?", "Delete", JOptionPane.YES_NO_OPTION);
			if(p==0) {				
			try {
				int id = Integer.parseInt(textFieldclientid.getText());
				URL url = new URL("http://localhost:8080/CarRental/clientmanage/delete?clientid="+id);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane,  "Client "+textFieldclientname.getText().replace(" ","%20")+
						" "+textFieldclientsurname.getText().replace(" ","%20")+" deleted successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			}
		}
		private void clientUpdate() {

			try {
				int id = Integer.parseInt(textFieldclientid.getText());
				URL url = new URL("http://localhost:8080/CarRental/clientmanage/update?clientid="+id+"&clientname="+textFieldclientname.getText().replace(" ","%20")+
						"&clientsurname="+textFieldclientsurname.getText().replace(" ","%20")+"&clientdrivinglicence="+textFielddrivinglicence.getText().replace(" ","%20")+
						"&clientaddress="+textFieldclientaddress.getText().replace(" ","%20")+"&clientemail="+textFieldclientemail.getText().replace(" ","%20")+
						"&clienttelephonenumber="+textFieldphonenumber.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Client "+textFieldclientname.getText().replace(" ","%20")+
						" "+textFieldclientsurname.getText().replace(" ","%20")+" updated successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		
		private void clientClear() {
			DefaultTableModel model = (DefaultTableModel) clienttable.getModel();
			model.setRowCount(0);
	        ClientTableModel.fireTableDataChanged();
	        textFieldclientid.setText(null);
	        textFieldclientname.setText(null);
	        textFieldclientsurname.setText(null);
	        textFielddrivinglicence.setText(null);
	        textFieldclientaddress.setText(null);
	        textFieldclientemail.setText(null);
	        textFieldphonenumber.setText(null);
			
		}
		
		private void vehicleList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/all");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("VehicleList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Vehicle Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Vehicle Model");
			        	  data[3]=sjo.get("Vehicle Fuel Type");
			        	  data[4]=sjo.get("Vehicle Capacity");
			        	  data[5]=sjo.get("Vehicle Rental Cost");
			        	  data[6]=sjo.get("Vehicle Type");
			        	  data[7]=sjo.get("Vehicle Category");
			        	  data[8]=sjo.get("Bike Seat Hight");
			        	  data[9]=sjo.get("Bike Luggage Support");
			        	  data[10]=sjo.get("Car Number of Seats");
			        	  data[11]=sjo.get("Car Number of Doors");
			        	  System.out.println(sjo.get("Vehicle Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Vehicle Model")); 
			        	  System.out.println(sjo.get("Vehicle Fuel Type"));
			        	  System.out.println(sjo.get("Vehicle Capacity")); 
			        	  System.out.println(sjo.get("Vehicle Rental Cost"));
			        	  System.out.println(sjo.get("Vehicle Type"));
			        	  System.out.println(sjo.get("Vehicle Category")); 
			        	  System.out.println(sjo.get("Bike Seat Hight"));
			        	  System.out.println(sjo.get("Bike Luggage Support")); 
			        	  System.out.println(sjo.get("Car Number of Seats"));
			        	  System.out.println(sjo.get("Car Number of Doors"));
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		

		
		private void vehicleDetails() {
			try {
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/getvehicledetails?vehiclelicenceno="+textFieldlicencenumber.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JOptionPane.showMessageDialog(contentPane, jo.toString());
			       }catch(JSONException ex) {};
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }

		}
		
		private void vehicleAdd() {
			try {
				Integer seatno = 0;
				Integer doorno = 0;
				Integer seatheight = 0 ;
				int id = Integer.parseInt(textFieldstoreidvehicle.getText().replace(" ","%20"));
				Integer cost= Integer.parseInt(textFieldvehiclerentalcost.getText().replace(" ","%20"));
				if (textFieldseatnumber.getText().equals("null"))
					 seatno= 0;
				else 
					 seatno= Integer.parseInt(textFielddoornumber.getText().replace(" ","%20"));
				if (textFielddoornumber.getText().equals("null"))
					doorno=0;
				else
					 doorno= Integer.parseInt(textFielddoornumber.getText().replace(" ","%20"));
				if (textFieldseatheight.getText().equals("null"))
					seatheight=0;
				else
					 seatheight= Integer.parseInt(textFieldseatheight.getText().replace(" ","%20"));
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/register?vehiclelicenceno="+textFieldlicencenumber.getText().replace(" ","%20")+
						"&storeid="+id+"&vehiclemodel="+textFieldvehiclemodel.getText().replace(" ","%20")+
						"&vehiclefuel="+textFieldvehiclefuel.getText().replace(" ","%20")+"&vehiclecapacity="+textFieldvehiclecapacity.getText().replace(" ","%20")+
						"&vehiclerentalcost="+cost+
						"&vehiclecategory="+textFieldvehiclecategory.getText().replace(" ","%20")+"&vehicleseatno="+seatno+
						"&vehicledoornumber="+doorno+"&vehicleseatheight="+seatheight+
						"&vehicleluggagesupport="+textFieldluggagesupport.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);

				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Vehicle "+textFieldlicencenumber.getText().replace(" ","%20")+" registered successfully!");
				conn.disconnect();
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			
		
		}

		private void vehicleDelete() {
			int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this vehicle?", "Delete", JOptionPane.YES_NO_OPTION);
			if(p==0) {				
			try {
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/delete?vehiclelicenceno="+textFieldlicencenumber.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane,  "Vehicle "+textFieldlicencenumber.getText().replace(" ","%20")+" deleted successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			}
		}
		private void vehicleUpdate() {

			try {
				Integer seatno = 0;
				Integer doorno = 0;
				Integer seatheight = 0 ;
				int id = Integer.parseInt(textFieldstoreidvehicle.getText().replace(" ","%20"));
				Integer cost= Integer.parseInt(textFieldvehiclerentalcost.getText().replace(" ","%20"));
				if (textFieldseatnumber.getText().equals("null"))
					 seatno= 0;
				else 
					 seatno= Integer.parseInt(textFielddoornumber.getText().replace(" ","%20"));
				if (textFielddoornumber.getText().equals("null"))
					doorno=0;
				else
					 doorno= Integer.parseInt(textFielddoornumber.getText().replace(" ","%20"));
				if (textFieldseatheight.getText().equals("null"))
					seatheight=0;
				else
					 seatheight= Integer.parseInt(textFieldseatheight.getText().replace(" ","%20"));
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/update?vehiclelicenceno="+textFieldlicencenumber.getText().replace(" ","%20")+ 
						"&storeid="+id+"&vehiclemodel="+textFieldvehiclemodel.getText().replace(" ","%20")+ 
						"&vehiclefuel="+textFieldvehiclefuel.getText().replace(" ","%20")+"&vehiclecapacity="+textFieldvehiclecapacity.getText().replace(" ","%20")+
						"&vehiclecategory="+textFieldvehiclecategory.getText().replace(" ","%20")+"&vehiclerentalcost="+cost+
						"&vehicleseatno="+seatno+
						"&vehicledoornumber="+doorno+"&vehicleseatheight="+seatheight+
						"&vehicleluggagesupport="+textFieldluggagesupport.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Vehicle "+textFieldlicencenumber.getText().replace(" ","%20")+" updated successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		
		private void clearVehicles() {
			DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
			model.setRowCount(0);
	        VehicleTableModel.fireTableDataChanged();
	        textFieldlicencenumber.setText(null);
	        textFieldstoreidvehicle.setText(null);
	        textFieldvehiclemodel.setText(null);
	        textFieldvehiclefuel.setText(null);
	        textFieldvehiclecapacity.setText(null);
	        textFieldvehiclerentalcost.setText(null);
	        textFieldvehicletype.setText(null);
	        textFieldvehiclecategory.setText(null);
	        textFieldseatheight.setText(null);
	        textFieldluggagesupport.setText(null);
	        textFieldseatnumber.setText(null);
	        textFielddoornumber.setText(null);
			
		}
		private void carList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/allcars");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("CarList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Car Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Car Model");
			        	  data[3]=sjo.get("Car Fuel Type");
			        	  data[4]=sjo.get("Car Capacity");
			        	  data[5]=sjo.get("Car Rental Cost");
			        	  data[6]="Car";
			        	  data[7]=sjo.get("Car Category");
			        	  data[8]="null";
			        	  data[9]="null";
			        	  data[10]=sjo.get("Car Number of Seats");
			        	  data[11]=sjo.get("Car Number of Doors");
			        	  System.out.println(sjo.get("Car Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Car Model")); 
			        	  System.out.println(sjo.get("Car Fuel Type"));
			        	  System.out.println(sjo.get("Car Capacity")); 
			        	  System.out.println(sjo.get("Car Rental Cost"));
			        	  System.out.println("Car");
			        	  System.out.println(sjo.get("Car Category")); 
			        	  System.out.println("null");
			        	  System.out.println("null"); 
			        	  System.out.println(sjo.get("Car Number of Seats"));
			        	  System.out.println(sjo.get("Car Number of Doors"));
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void twowheeledList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/allbikes");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("BikeList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Bikes Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Bike Model");
			        	  data[3]=sjo.get("Bike Fuel Type");
			        	  data[4]=sjo.get("Bike Capacity");
			        	  data[5]=sjo.get("Bike Rental Cost");
			        	  data[6]="Bike";
			        	  data[7]=sjo.get("Bike Category");
			        	  data[8]=sjo.get("Bike Seat Hight");
			        	  data[9]=sjo.get("Bike Luggage Support");
			        	  data[10]="null";
			        	  data[11]="null";
			        	  System.out.println(sjo.get("Bikes Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Bike Model")); 
			        	  System.out.println(sjo.get("Bike Fuel Type"));
			        	  System.out.println(sjo.get("Bike Capacity")); 
			        	  System.out.println(sjo.get("Bike Rental Cost"));
			        	  System.out.println("Bike");
			        	  System.out.println(sjo.get("Bike Category")); 
			        	  System.out.println(sjo.get("Bike Seat Hight"));
			        	  System.out.println(sjo.get("Bike Luggage Support")); 
			        	  System.out.println("null");
			        	  System.out.println("null");
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void compactList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/Compact");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			    	  JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("CarList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Car Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Car Model");
			        	  data[3]=sjo.get("Car Fuel Type");
			        	  data[4]=sjo.get("Car Capacity");
			        	  data[5]=sjo.get("Car Rental Cost");
			        	  data[6]="Car";
			        	  data[7]=sjo.get("Car Category");
			        	  data[8]="null";
			        	  data[9]="null";
			        	  data[10]=sjo.get("Car Number of Seats");
			        	  data[11]=sjo.get("Car Number of Doors");
			        	  System.out.println(sjo.get("Car Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Car Model")); 
			        	  System.out.println(sjo.get("Car Fuel Type"));
			        	  System.out.println(sjo.get("Car Capacity")); 
			        	  System.out.println(sjo.get("Car Rental Cost"));
			        	  System.out.println("Car");
			        	  System.out.println(sjo.get("Car Category")); 
			        	  System.out.println("null");
			        	  System.out.println("null"); 
			        	  System.out.println(sjo.get("Car Number of Seats"));
			        	  System.out.println(sjo.get("Car Number of Doors"));
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void midrangeList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/Midrange");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			    	  JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("CarList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Car Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Car Model");
			        	  data[3]=sjo.get("Car Fuel Type");
			        	  data[4]=sjo.get("Car Capacity");
			        	  data[5]=sjo.get("Car Rental Cost");
			        	  data[6]="Car";
			        	  data[7]=sjo.get("Car Category");
			        	  data[8]="null";
			        	  data[9]="null";
			        	  data[10]=sjo.get("Car Number of Seats");
			        	  data[11]=sjo.get("Car Number of Doors");
			        	  System.out.println(sjo.get("Car Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Car Model")); 
			        	  System.out.println(sjo.get("Car Fuel Type"));
			        	  System.out.println(sjo.get("Car Capacity")); 
			        	  System.out.println(sjo.get("Car Rental Cost"));
			        	  System.out.println("Car");
			        	  System.out.println(sjo.get("Car Category")); 
			        	  System.out.println("null");
			        	  System.out.println("null"); 
			        	  System.out.println(sjo.get("Car Number of Seats"));
			        	  System.out.println(sjo.get("Car Number of Doors"));
			        	  VehicleTableModel.addRow(data);	
			        	  }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void vanList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/Van");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			    	  JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("CarList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Car Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Car Model");
			        	  data[3]=sjo.get("Car Fuel Type");
			        	  data[4]=sjo.get("Car Capacity");
			        	  data[5]=sjo.get("Car Rental Cost");
			        	  data[6]="Car";
			        	  data[7]=sjo.get("Car Category");
			        	  data[8]="null";
			        	  data[9]="null";
			        	  data[10]=sjo.get("Car Number of Seats");
			        	  data[11]=sjo.get("Car Number of Doors");
			        	  System.out.println(sjo.get("Car Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Car Model")); 
			        	  System.out.println(sjo.get("Car Fuel Type"));
			        	  System.out.println(sjo.get("Car Capacity")); 
			        	  System.out.println(sjo.get("Car Rental Cost"));
			        	  System.out.println("Car");
			        	  System.out.println(sjo.get("Car Category")); 
			        	  System.out.println("null");
			        	  System.out.println("null"); 
			        	  System.out.println(sjo.get("Car Number of Seats"));
			        	  System.out.println(sjo.get("Car Number of Doors"));
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void bikeList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/Motorcycle");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("BikeList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Bikes Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Bike Model");
			        	  data[3]=sjo.get("Bike Fuel Type");
			        	  data[4]=sjo.get("Bike Capacity");
			        	  data[5]=sjo.get("Bike Rental Cost");
			        	  data[6]="Bike";
			        	  data[7]=sjo.get("Bike Category");
			        	  data[8]=sjo.get("Bike Seat Hight");
			        	  data[9]=sjo.get("Bike Luggage Support");
			        	  data[10]="null";
			        	  data[11]="null";
			        	  System.out.println(sjo.get("Bikes Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Bike Model")); 
			        	  System.out.println(sjo.get("Bike Fuel Type"));
			        	  System.out.println(sjo.get("Bike Capacity")); 
			        	  System.out.println(sjo.get("Bike Rental Cost"));
			        	  System.out.println("Bike");
			        	  System.out.println(sjo.get("Bike Category")); 
			        	  System.out.println(sjo.get("Bike Seat Hight"));
			        	  System.out.println(sjo.get("Bike Luggage Support")); 
			        	  System.out.println("null");
			        	  System.out.println("null");
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void scooterList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/vehiclemanage/retrieve/Scooter");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) vehicletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("BikeList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Bikes Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Bike Model");
			        	  data[3]=sjo.get("Bike Fuel Type");
			        	  data[4]=sjo.get("Bike Capacity");
			        	  data[5]=sjo.get("Bike Rental Cost");
			        	  data[6]="Bike";
			        	  data[7]=sjo.get("Bike Category");
			        	  data[8]=sjo.get("Bike Seat Hight");
			        	  data[9]=sjo.get("Bike Luggage Support");
			        	  data[10]="null";
			        	  data[11]="null";
			        	  System.out.println(sjo.get("Bikes Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Bike Model")); 
			        	  System.out.println(sjo.get("Bike Fuel Type"));
			        	  System.out.println(sjo.get("Bike Capacity")); 
			        	  System.out.println(sjo.get("Bike Rental Cost"));
			        	  System.out.println("Bike");
			        	  System.out.println(sjo.get("Bike Category")); 
			        	  System.out.println(sjo.get("Bike Seat Hight"));
			        	  System.out.println(sjo.get("Bike Luggage Support")); 
			        	  System.out.println("null");
			        	  System.out.println("null");
			        	  VehicleTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          VehicleTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		private void rentalList() {
			try {
//				URL url = new URL("http://localhost:8080/PatientManagement/login/dologin?amka="+tamka.getText()+"&password="+tpassword.getText());
				URL url = new URL("http://localhost:8080/CarRental/rentalmanage/retrieve");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) rentaltable.getModel();
				model.setRowCount(0);
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("RentalList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[8];
			        	  data[0]=sjo.get("Rental ID");
			        	  data[1]=sjo.get("Licence Number of Vehicle");
			        	  data[2]=sjo.get("Cient ID");
			        	  data[3]=sjo.get("Pickup Location");
			        	  data[4]=sjo.get("Pickup Datetime");
			        	  data[5]=sjo.get("Return Location");
			        	  data[6]=sjo.get("Return Datetime");
			        	  data[7]=sjo.get("Rental Cost");
			        	  System.out.println(sjo.get("Rental ID")); 
			        	  System.out.println(sjo.get("Licence Number of Vehicle")); 
			        	  System.out.println(sjo.get("Cient ID")); 
			        	  System.out.println(sjo.get("Pickup Location"));
			        	  System.out.println(sjo.get("Pickup Datetime")); 
			        	  System.out.println(sjo.get("Return Location"));
			        	  System.out.println(sjo.get("Return Datetime"));
			        	  System.out.println(sjo.get("Rental Cost"));
			        	  RentalTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          ClientTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		

		private void rentalDetails() {
			try {
				URL url = new URL("http://localhost:8080/CarRental/rentalmanage/getrentaldetails?rentalid="
				+textFieldrentalid.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
			      try {
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JOptionPane.showMessageDialog(contentPane, jo.toString());
			       }catch(JSONException ex) {};
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }

		}
		
		private void rentalAdd() {

			try {
				int id = Integer.parseInt(textFieldclientidvehicle.getText());
				URL url = new URL("http://localhost:8080/CarRental/rentalmanage/register?vehiclelicenceno="+textFieldvehiclelicencenumber.getText().replace(" ","%20")+
						"&clientid="+id+"&rentalpickuplocation="+textFieldpickuplocation.getText().replace(" ","%20")+
						"&rentalpickupdatetime="+textFieldgetdate.getText().replace(" ","%20")+"&rentalreturnloction="+textFieldreturnto.getText().replace(" ","%20")+
						"&rentalreturndatetime="+textFieldreturndate.getText().replace(" ","%20"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);

				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Rental registered successfully!");
				conn.disconnect();
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			
		
		}

		private void rentalDelete() {
			int id = Integer.parseInt(textFieldrentalid.getText());
			int p =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this rental?", "Delete", JOptionPane.YES_NO_OPTION);
			if(p==0) {				
			try {
				
				URL url = new URL("http://localhost:8080/CarRental/rentalmanage/delete?rentalid="+id);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane,  "Rental "+id+" deleted successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
			}
		}
		private void rentalUpdate(){
			try {
				int id = Integer.parseInt(textFieldrentalid.getText());
				int id1 = Integer.parseInt(textFieldclientidvehicle.getText());
				Integer cost = Integer.parseInt(textFieldrentalcost.getText());
				URL url = new URL("http://localhost:8080/CarRental/rentalmanage/update?rentalid="+id+"&vehiclelicenceno="+textFieldvehiclelicencenumber.getText().replace(" ","%20")+
						"&clientid="+id1+"&rentalpickuplocation="+textFieldpickuplocation.getText().replace(" ","%20")+
						"&rentalpickupdatetime="+textFieldgetdate.getText().replace(" ","%20")+"&rentalreturnloction="+textFieldreturnto.getText().replace(" ","%20")+
						"&rentalreturndatetime="+textFieldreturndate.getText().replace(" ","%20")+"&rentaltotalcost="+cost);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				JOptionPane.showMessageDialog(contentPane, output);
				System.out.println("Output from Server .... \n");
				JOptionPane.showMessageDialog(contentPane, "Client "+textFieldclientname.getText().replace(" ","%20")+
						" "+textFieldclientsurname.getText().replace(" ","%20")+" updated successfully!");
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}
		
		private void clearrentalList() {
			DefaultTableModel model = (DefaultTableModel) rentaltable.getModel();
			model.setRowCount(0);
	        RentalTableModel.fireTableDataChanged();
	        textFieldvehiclelicencenumber.setText(null);
	        textFieldclientidvehicle.setText(null);
			textFieldpickuplocation.setText(null);
			textFieldreturnto.setText(null);
			textFieldrentalcost.setText(null);
			
		}
		private void availableList(String value) throws ParseException {
	


			try {
				String type=value.toString().replace(" ","%20");

				URL url = new URL("http://localhost:8080/CarRental/rentalmanage/getavailability?rentalpickuplocation="+textFieldpickuplocation.getText().replace(" ","%20")+
						"&rentalpickupdatetime="+textFieldgetdate.getText().replace(" ","%20")+
						"&rentalreturndatetime="+textFieldreturndate.getText().replace(" ","%20")+"&vehiclecategory="+type);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

				String output=br.readLine();
				//response="";
				System.out.println("Output from Server .... \n");
	/*				while ((output = br.readLine()) != null) {
					response+=output;
					JOptionPane.showMessageDialog(getContentPane(), output);
				}
	*/				
				DefaultTableModel model = (DefaultTableModel) availabletable.getModel();
				model.setRowCount(0);
			      try {
			    	  
			          // typecasting obj to JSONObject 
			          JSONObject jo = new JSONObject(output.toString()); 
			          System.out.println(jo.toString()); 
			          JSONArray ja=jo.getJSONArray("VehicleList");
			          for (int i=0;i<ja.length();i++) {
			        	  String firstName = ja.getString(i); 
			        	  JSONObject sjo=new JSONObject(firstName);
			        	  Object[] data=new Object[12];
			        	  data[0]=sjo.get("Vehicle Licence Number");
			        	  data[1]=sjo.get("Store ID");
			        	  data[2]=sjo.get("Vehicle Model");
			        	  data[3]=sjo.get("Vehicle Fuel Type");
			        	  data[4]=sjo.get("Vehicle Capacity");
			        	  data[5]=sjo.get("Vehicle Rental Cost");
			        	  data[6]=sjo.get("Vehicle Type");
			        	  data[7]=sjo.get("Vehicle Category");
			        	  data[8]=sjo.get("Bike Seat Hight");
			        	  data[9]=sjo.get("Bike Luggage Support");
			        	  data[10]=sjo.get("Car Number of Seats");
			        	  data[11]=sjo.get("Car Number of Doors");
			        	  System.out.println(sjo.get("Vehicle Licence Number")); 
			        	  System.out.println(sjo.get("Store ID")); 
			        	  System.out.println(sjo.get("Vehicle Model")); 
			        	  System.out.println(sjo.get("Vehicle Fuel Type"));
			        	  System.out.println(sjo.get("Vehicle Capacity")); 
			        	  System.out.println(sjo.get("Vehicle Rental Cost"));
			        	  System.out.println(sjo.get("Vehicle Type"));
			        	  System.out.println(sjo.get("Vehicle Category")); 
			        	  System.out.println(sjo.get("Bike Seat Hight"));
			        	  System.out.println(sjo.get("Bike Luggage Support")); 
			        	  System.out.println(sjo.get("Car Number of Seats"));
			        	  System.out.println(sjo.get("Car Number of Doors"));
			        	  AvailableTableModel.addRow(data);
			          }
			          }catch(JSONException ex) {};
			          AvailableTableModel.fireTableDataChanged();
			          
				conn.disconnect();
					
		  } catch (MalformedURLException me) {
				me.printStackTrace();
		  } catch (IOException me) {
				me.printStackTrace();
		  }
		}

}
	
	

