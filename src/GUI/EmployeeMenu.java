package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.RoomBookingCtr;
import Model.Room;
import Model.RoomBooking;
import Model.RoomLine;
import Model.Guest;
import Model.Location;
import Model.Person;
import Controller.PersonCtr;
import Controller.GuestCtr;
import Controller.TravelAgencyCtr;
import Controller.LocationCtr;
import Model.TravelAgency;
import javax.swing.JComboBox;

public class EmployeeMenu
{
	private JComboBox<String> guestTravelAgencyComboBox = new JComboBox<String>();
	private JComboBox<String> guestGuestTypeComboBox = new JComboBox<String>();
	private GuestCtr guestCtr = new GuestCtr();
	private PersonCtr personCtr = new PersonCtr();
	private TravelAgencyCtr travelCtr = new TravelAgencyCtr();
	private LocationCtr locationCtr = new LocationCtr();
	private JFrame frame;
	private JTextField txtRoomBookingId;
	private JTextField txtNumberOfChildren;
	private JTextField txtStatus;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtDd;
	private JTextField txtMm;
	private JTextField txtYyyy;
	private JTextField txtDepDD;
	private JTextField txtDepmm;
	private JTextField txtDepyyyy;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField guestIdTextField;
	private JTextField guestAddressTextField;
	private JTextField guestNameTextField;
	private JTextField guestPhoneNoTextField;
	private JTextField guestEmailTextField;
	private JTextField guestCityTextField;
	private JTextField guestPasswordTextField;
	private JTextField guestCountryTextField;
	private JTextField guestZipcodeTextField;
	private JTable guestTable;
	
	public EmployeeMenu()
	{
		initialize();
		frame.setVisible(true);
		
	}
	
	private void initialize()
	{
		frame = new JFrame("Employee menu");
		frame.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logOffButton = new JButton("Log Off");
		logOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
				LoginMenu loginMenu = LoginMenu.getInstance();
				loginMenu.frame.setVisible(true);
			}
		});
		logOffButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		logOffButton.setBounds(845, 572, 125, 39);
		frame.getContentPane().add(logOffButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 960, 550);
		frame.getContentPane().add(tabbedPane);
		
		JPanel WelcomePanel = new JPanel();
		tabbedPane.addTab("Main menu", null, WelcomePanel, null);
		
		JPanel GuestPanel = new JPanel();
		tabbedPane.addTab("Guest", null, GuestPanel, null);
		GuestPanel.setLayout(null);
		
		JLabel label_14 = new JLabel("Travel agency:");
		label_14.setFont(new Font("Arial", Font.PLAIN, 11));
		label_14.setBounds(6, 64, 86, 14);
		GuestPanel.add(label_14);
		
		JLabel label_15 = new JLabel("Address:");
		label_15.setFont(new Font("Arial", Font.PLAIN, 11));
		label_15.setBounds(16, 39, 86, 14);
		GuestPanel.add(label_15);
		
		JLabel label_16 = new JLabel("Id:");
		label_16.setFont(new Font("Arial", Font.PLAIN, 11));
		label_16.setBounds(16, 14, 46, 14);
		GuestPanel.add(label_16);
		
		guestIdTextField = new JTextField();
		guestIdTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestIdTextField.setColumns(10);
		guestIdTextField.setBounds(70, 11, 100, 20);
		GuestPanel.add(guestIdTextField);
		
		guestAddressTextField = new JTextField();
		guestAddressTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestAddressTextField.setColumns(10);
		guestAddressTextField.setBounds(70, 36, 100, 20);
		GuestPanel.add(guestAddressTextField);
		
		
		guestTravelAgencyComboBox.setBounds(84, 61, 122, 20);
		GuestPanel.add(guestTravelAgencyComboBox);
		
		JButton noTravelAgencyButton = new JButton("No travel agency");
		noTravelAgencyButton.setFont(new Font("Arial", Font.PLAIN, 11));
		noTravelAgencyButton.setBounds(216, 59, 146, 25);
		GuestPanel.add(noTravelAgencyButton);
		
		JLabel label_17 = new JLabel("Phone no:");
		label_17.setFont(new Font("Arial", Font.PLAIN, 11));
		label_17.setBounds(186, 39, 80, 14);
		GuestPanel.add(label_17);
		
		JLabel label_18 = new JLabel("Name:");
		label_18.setFont(new Font("Arial", Font.PLAIN, 11));
		label_18.setBounds(186, 14, 46, 14);
		GuestPanel.add(label_18);
		
		guestNameTextField = new JTextField();
		guestNameTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestNameTextField.setColumns(10);
		guestNameTextField.setBounds(239, 11, 100, 20);
		GuestPanel.add(guestNameTextField);
		
		guestPhoneNoTextField = new JTextField();
		guestPhoneNoTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestPhoneNoTextField.setColumns(10);
		guestPhoneNoTextField.setBounds(239, 36, 100, 20);
		GuestPanel.add(guestPhoneNoTextField);
		
		JLabel label_19 = new JLabel("City:");
		label_19.setFont(new Font("Arial", Font.PLAIN, 11));
		label_19.setBounds(401, 14, 80, 14);
		GuestPanel.add(label_19);
		
		JLabel label_20 = new JLabel("E-mail:");
		label_20.setFont(new Font("Arial", Font.PLAIN, 11));
		label_20.setBounds(401, 39, 80, 14);
		GuestPanel.add(label_20);
		
		guestEmailTextField = new JTextField();
		guestEmailTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestEmailTextField.setColumns(10);
		guestEmailTextField.setBounds(439, 36, 100, 20);
		GuestPanel.add(guestEmailTextField);
		
		guestCityTextField = new JTextField();
		guestCityTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestCityTextField.setColumns(10);
		guestCityTextField.setBounds(439, 11, 100, 20);
		GuestPanel.add(guestCityTextField);
		
		JLabel label_21 = new JLabel("Country:");
		label_21.setFont(new Font("Arial", Font.PLAIN, 11));
		label_21.setBounds(577, 14, 80, 14);
		GuestPanel.add(label_21);
		
		JLabel label_22 = new JLabel("Password:");
		label_22.setFont(new Font("Arial", Font.PLAIN, 11));
		label_22.setBounds(577, 39, 80, 14);
		GuestPanel.add(label_22);
		
		guestPasswordTextField = new JTextField();
		guestPasswordTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestPasswordTextField.setColumns(10);
		guestPasswordTextField.setBounds(639, 36, 100, 20);
		GuestPanel.add(guestPasswordTextField);
		
		guestCountryTextField = new JTextField();
		guestCountryTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestCountryTextField.setColumns(10);
		guestCountryTextField.setBounds(639, 11, 100, 20);
		GuestPanel.add(guestCountryTextField);
		
		JLabel label_23 = new JLabel("Zipcode:");
		label_23.setFont(new Font("Arial", Font.PLAIN, 11));
		label_23.setBounds(749, 14, 80, 14);
		GuestPanel.add(label_23);
		
		JLabel label_24 = new JLabel("Guest type:");
		label_24.setFont(new Font("Arial", Font.PLAIN, 11));
		label_24.setBounds(749, 39, 80, 14);
		GuestPanel.add(label_24);
		
		guestZipcodeTextField = new JTextField();
		guestZipcodeTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		guestZipcodeTextField.setColumns(10);
		guestZipcodeTextField.setBounds(815, 11, 100, 20);
		GuestPanel.add(guestZipcodeTextField);
		
	    
		guestGuestTypeComboBox.setBounds(815, 36, 100, 20);
		GuestPanel.add(guestGuestTypeComboBox);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new TitledBorder(null, "Guest", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_13.setBounds(0, 92, 140, 157);
		GuestPanel.add(panel_13);
		
		JButton guestSearchButton = new JButton("Search");
		guestSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(guestIdTextField.getText().equals("")==true && guestNameTextField.getText().equals("")==true)
				{
					JOptionPane.showMessageDialog(null, "Please insert either the id or the name of the wanted guest.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(guestNameTextField.getText().equals("") == true)
					{
						String stringGuestId = guestIdTextField.getText();
						int guestId = Integer.parseInt(stringGuestId);
						
						Guest guestObj = new Guest();
						guestObj = guestCtr.searchGuestById(guestId);
						
						if(guestObj == null)
						{
							JOptionPane.showMessageDialog(null, "There is no guest by this id. Please insert a valid guest id.", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							String guestName = guestObj.getName();
							int guestZipCode = guestObj.getZipCode();
							String stringGuestZipcode = String.valueOf(guestZipCode);
							String guestCountry = guestObj.getCountry();
							String guestAddress = guestObj.getAddress();
							String guestPhoneNo = guestObj.getPhoneNo();
							String guestEmail = guestObj.getEmail();
							String guestPassword = guestObj.getPassword();
							String guestType = guestObj.getGuestType();
							
							String travelAgencyName = new String();
							TravelAgency travelAgencyObj = new TravelAgency();
							travelAgencyObj = guestObj.getTravelAgency();
							if(travelAgencyObj == null)
							{
								travelAgencyName = "0";
							}
							else
							{
								travelAgencyName = travelAgencyObj.getName();
							}
							
							Location locationObj = new Location();
							locationObj = locationCtr.getLocation(guestZipCode, guestCountry);
							String guestCity = locationObj.getCity();
							
							guestIdTextField.setText(stringGuestId);
							guestNameTextField.setText(guestName);
							guestCityTextField.setText(guestCity);
							guestCountryTextField.setText(guestCountry);
							guestZipcodeTextField.setText(stringGuestZipcode);
							guestAddressTextField.setText(guestAddress);
							guestPhoneNoTextField.setText(guestPhoneNo);
							guestEmailTextField.setText(guestEmail);
							guestPasswordTextField.setText(guestPassword);
							guestGuestTypeComboBox.setSelectedItem(guestType);
							if(travelAgencyName.equals("0") == true)
							{
								guestTravelAgencyComboBox.setSelectedItem(null);
							}
							else
							{
								guestTravelAgencyComboBox.setSelectedItem(travelAgencyName);
							}
						}
					}
					else
					{
						if(guestIdTextField.getText().equals("") == true)
						{
							String guestName = guestNameTextField.getText();
							
							Person personObj = new Person();
							personObj = personCtr.searchPersonByName(guestName);
							
							if(personObj == null || personObj.getPersonType().equals("Guest") == false)
							{
								JOptionPane.showMessageDialog(null, "There is no guest by this name. Please insert a valid guest name.", "Error!", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								int guestId = personObj.getId();
								Guest guestObj = new Guest();
								guestObj = guestCtr.searchGuestById(guestId);
								String stringGuestId = String.valueOf(guestId);
								int guestZipCode = guestObj.getZipCode();
								String stringGuestZipcode = String.valueOf(guestZipCode);
								String guestCountry = guestObj.getCountry();
								String guestAddress = guestObj.getAddress();
								String guestPhoneNo = guestObj.getPhoneNo();
								String guestEmail = guestObj.getEmail();
								String guestPassword = guestObj.getPassword();
								String guestType = guestObj.getGuestType();
															
								String travelAgencyName = new String();
								TravelAgency travelAgencyObj = new TravelAgency();
								travelAgencyObj = guestObj.getTravelAgency();
								if(travelAgencyObj == null)
								{
									travelAgencyName = "0";
								}
								else
								{
									travelAgencyName = travelAgencyObj.getName();
								}
								
								Location locationObj = new Location();
								locationObj = locationCtr.getLocation(guestZipCode, guestCountry);
								String guestCity = locationObj.getCity();
								
								guestIdTextField.setText(stringGuestId);
								guestNameTextField.setText(guestName);
								guestCityTextField.setText(guestCity);
								guestCountryTextField.setText(guestCountry);
								guestZipcodeTextField.setText(stringGuestZipcode);
								guestAddressTextField.setText(guestAddress);
								guestPhoneNoTextField.setText(guestPhoneNo);
								guestEmailTextField.setText(guestEmail);
								guestPasswordTextField.setText(guestPassword);
								guestGuestTypeComboBox.setSelectedItem(guestType);
								if(travelAgencyName.equals("0") == true)
								{
									guestTravelAgencyComboBox.setSelectedItem(null);
								}
								else
								{
									guestTravelAgencyComboBox.setSelectedItem(travelAgencyName);
								}
							}
						}
						else
						{
							if(guestIdTextField.getText().equals("") != true && guestNameTextField.getText().equals("") != true)
							{
								String stringGuestId = guestIdTextField.getText();
								int guestId = Integer.parseInt(stringGuestId);
								
								Guest guestObj = new Guest();
								guestObj = guestCtr.searchGuestById(guestId);
								
								if(guestObj == null)
								{
									JOptionPane.showMessageDialog(null, "There is no guest by this id. Please insert a valid guest id.", "Error!", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									String guestName = guestObj.getName();
									int guestZipCode = guestObj.getZipCode();
									String stringGuestZipcode = String.valueOf(guestZipCode);
									String guestCountry = guestObj.getCountry();
									String guestAddress = guestObj.getAddress();
									String guestPhoneNo = guestObj.getPhoneNo();
									String guestEmail = guestObj.getEmail();
									String guestPassword = guestObj.getPassword();
									String guestType = guestObj.getGuestType();
																
									String travelAgencyName = new String();
									TravelAgency travelAgencyObj = new TravelAgency();
									travelAgencyObj = guestObj.getTravelAgency();
									if(travelAgencyObj == null)
									{
										travelAgencyName = "0";
									}
									else
									{
										travelAgencyName = travelAgencyObj.getName();
									}
									
									Location locationObj = new Location();
									locationObj = locationCtr.getLocation(guestZipCode, guestCountry);
									String guestCity = locationObj.getCity();
									
									guestIdTextField.setText(stringGuestId);
									guestNameTextField.setText(guestName);
									guestCityTextField.setText(guestCity);
									guestCountryTextField.setText(guestCountry);
									guestZipcodeTextField.setText(stringGuestZipcode);
									guestAddressTextField.setText(guestAddress);
									guestPhoneNoTextField.setText(guestPhoneNo);
									guestEmailTextField.setText(guestEmail);
									guestPasswordTextField.setText(guestPassword);									
									guestGuestTypeComboBox.setSelectedItem(guestType);
									
									if(travelAgencyName.equals("0") == true)
									{
										guestTravelAgencyComboBox.setSelectedItem(null);
									}
									else
									{
										guestTravelAgencyComboBox.setSelectedItem(travelAgencyName);
									}
								}
							}
						}
					}
				}
			}
		});
		guestSearchButton.setFont(new Font("Arial", Font.PLAIN, 11));
		guestSearchButton.setBounds(6, 16, 124, 25);
		panel_13.add(guestSearchButton);
		
		JButton guestCreateButton = new JButton("Create");
		guestCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(guestNameTextField.getText().equals("") == true || guestCityTextField.getText().equals("") == true ||
						guestCountryTextField.getText().equals("") == true || guestZipcodeTextField.getText().equals("") == true || guestAddressTextField.getText().equals("") == true ||
								guestGuestTypeComboBox.getSelectedItem().equals(null) == true)
			
				{
					JOptionPane.showMessageDialog(null, "A guest attribute might be missing. Please insert all needed guest attributes.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String guestName = guestNameTextField.getText();
					String guestCity = guestCityTextField.getText();
					String guestCountry = guestCountryTextField.getText();
					String stringGuestZipcode = guestZipcodeTextField.getText();
					int guestZipcode = Integer.parseInt(stringGuestZipcode);
					String guestAddress = guestAddressTextField.getText();
					String guestPhoneNo = guestPhoneNoTextField.getText();
					String guestEmail = guestEmailTextField.getText();
					String guestPassword = personCtr.getPersonPassword(guestName, stringGuestZipcode, guestCountry, guestAddress);
					String guestType =(String) guestGuestTypeComboBox.getSelectedItem();
					
					int travelAgencyCVR = 0;
					
					if(guestTravelAgencyComboBox.getSelectedItem() == null)
					{
						travelAgencyCVR = 0;
					}
					else
					{
						String travelAgencyName = (String) guestTravelAgencyComboBox.getSelectedItem();
						TravelAgency travelAgencyObj = new TravelAgency();
						travelAgencyObj = travelCtr.getTravelAgencyByName(travelAgencyName);
						travelAgencyCVR = travelAgencyObj.getCVR();
					}
					
					if(personCtr.searchPersonByName(guestName) != null)
					{
						JOptionPane.showMessageDialog(null, "Cannot register the same guest twice.", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Location locationObj = locationCtr.getLocation(guestZipcode, guestCountry);
						if(locationObj == null)
						{
							locationCtr.insertLocation(guestZipcode, guestCountry, guestCity);
						}
						
						personCtr.insertPerson(guestName, guestAddress, guestZipcode, guestCountry, guestPhoneNo, guestEmail, "Guest", guestPassword);
						guestCtr.insertGuest(guestName, travelAgencyCVR, guestType);
						
						JOptionPane.showMessageDialog(null, "Guest successfully inserted", "Info", JOptionPane.INFORMATION_MESSAGE);
						clearGuestPanel();
						clearGuestTable();
						guestTable.setModel(getGuestTableModel());
					}
				}
			}
		});
		guestCreateButton.setFont(new Font("Arial", Font.PLAIN, 11));
		guestCreateButton.setBounds(6, 52, 124, 25);
		panel_13.add(guestCreateButton);
		
		JButton guestUpdateButton = new JButton("Update");
		guestUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(guestIdTextField.getText().equals("") == true || guestNameTextField.getText().equals("") == true || guestCityTextField.getText().equals("") == true ||
						guestCountryTextField.getText().equals("") == true || guestZipcodeTextField.getText().equals("") == true || guestAddressTextField.getText().equals("") == true ||
								guestGuestTypeComboBox.getSelectedItem().equals(null) == true || guestPasswordTextField.getText().equals("") == true)
			
				{
					JOptionPane.showMessageDialog(null, "A guest attribute might be missing. Please insert all needed guest attributes.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String stringGuestId = guestIdTextField.getText();
					int guestId = Integer.parseInt(stringGuestId);
					
					Guest guestObj = new Guest();
					guestObj = guestCtr.searchGuestById(guestId);
					
					if(guestObj == null)
					{
						JOptionPane.showMessageDialog(null, "The wanted guest does not exist in the system. Please check guest list.", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String guestName = guestNameTextField.getText();
						String guestCity = guestCityTextField.getText();
						String guestCountry = guestCountryTextField.getText();
						String stringGuestZipcode = guestZipcodeTextField.getText();
						int guestZipcode = Integer.parseInt(stringGuestZipcode);
						String guestAddress = guestAddressTextField.getText();
						String guestPhoneNo = guestPhoneNoTextField.getText();
						String guestEmail = guestEmailTextField.getText();
						String guestType =(String) guestGuestTypeComboBox.getSelectedItem();
						String guestPassword = guestPasswordTextField.getText();
						
						int travelAgencyCVR = 0;
						if(guestTravelAgencyComboBox.getSelectedItem() == null)
						{
							travelAgencyCVR = 0;
						}
						else
						{
							String travelAgencyName = (String) guestTravelAgencyComboBox.getSelectedItem();
							TravelAgency travelAgencyObj = new TravelAgency();
							travelAgencyObj = travelCtr.getTravelAgencyByName(travelAgencyName);
							travelAgencyCVR = travelAgencyObj.getCVR();
						}
						
						if(personCtr.checkPersonInstanceCount(guestId, guestName, guestZipcode, guestCountry, guestAddress) == false)
						{
							JOptionPane.showMessageDialog(null, "You may not update with an already existing guest on this id.", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							Location locationObj =  new Location();
							locationObj = locationCtr.getLocation(guestZipcode, guestCountry);
							if(locationObj == null)
							{
								locationCtr.insertLocation(guestZipcode, guestCountry, guestCity);
							}
							
							personCtr.updatePerson(guestId, guestName, guestAddress, guestZipcode, guestCountry, guestPhoneNo, guestEmail, "Guest", guestPassword);
							guestCtr.updateGuest(guestId, guestType, travelAgencyCVR);
							
							JOptionPane.showMessageDialog(null, "Guest updated successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
							clearGuestPanel();
							clearGuestTable();
							guestTable.setModel(getGuestTableModel());
						}
					}
				}
			}
		});
		guestUpdateButton.setFont(new Font("Arial", Font.PLAIN, 11));
		guestUpdateButton.setBounds(6, 88, 124, 25);
		panel_13.add(guestUpdateButton);
		
		JButton guestAllButton = new JButton("All");
		guestAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				clearGuestPanel();
				clearGuestTable();
				
				guestTable.setModel(getGuestTableModel());
			}
		});
		guestAllButton.setFont(new Font("Arial", Font.PLAIN, 11));
		guestAllButton.setBounds(6, 124, 124, 25);
		panel_13.add(guestAllButton);
		
		JButton guestClearButton = new JButton("Clear all");
		guestClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clearGuestPanel();
				clearGuestTable();
			}
		});
		guestClearButton.setFont(new Font("Arial", Font.PLAIN, 11));
		guestClearButton.setBounds(0, 260, 140, 25);
		GuestPanel.add(guestClearButton);
		
		JScrollPane guestTableScrollPane = new JScrollPane();
		guestTableScrollPane.setBounds(156, 107, 789, 344);
		GuestPanel.add(guestTableScrollPane);
		
		guestTable = new JTable();
		guestTable.setFillsViewportHeight(true);
		guestTable.setBounds(151, 92, 787, 342);
		GuestPanel.add(guestTable);
		
		//delete room booking button
		/*JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				RoomBookingCtr rbCtr=new RoomBookingCtr();
				
				if(txtRoomBookingId.getText().equals("")!=true)
				{
					String stringID=txtRoomBookingId.getText();
					int bookingId=Integer.parseInt(stringID);
					
					RoomBooking rb=rbCtr.findRoomBookingByID(bookingId);
					if(rb!=null)
					{
						rbCtr.deleteBooking(bookingId);
						
						clearValues();
						
						JOptionPane.showMessageDialog(null, "Booking has been deleted.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "There is no such booking!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please insert either id of the booking.", "Error!", JOptionPane.ERROR_MESSAGE);
				}						
			}
		});
		btnDelete.setBounds(6, 154, 110, 35);
		panel.add(btnDelete);*/
		
		JPanel RoomBookingPanel = new JPanel();
		tabbedPane.addTab("Room booking", null, RoomBookingPanel, null);	
		RoomBookingPanel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Booking data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 7, 759, 120);
		RoomBookingPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBookingId = new JLabel("Booking ID:");
		lblBookingId.setBounds(6, 16, 100, 25);
		panel_1.add(lblBookingId);
		lblBookingId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblArrivalDate = new JLabel("Arrival date:");
		lblArrivalDate.setBounds(6, 52, 100, 25);
		panel_1.add(lblArrivalDate);
		lblArrivalDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNumberOfChildren = new JLabel("Children #:");
		lblNumberOfChildren.setBounds(6, 88, 100, 25);
		panel_1.add(lblNumberOfChildren);
		lblNumberOfChildren.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(375, 16, 100, 25);
		panel_1.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDepartureDate = new JLabel("Departure date:");
		lblDepartureDate.setBounds(375, 52, 100, 25);
		panel_1.add(lblDepartureDate);
		lblDepartureDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtRoomBookingId = new JTextField();
		txtRoomBookingId.setBounds(96, 20, 240, 20);
		panel_1.add(txtRoomBookingId);
		txtRoomBookingId.setColumns(10);
		
		txtNumberOfChildren = new JTextField();
		txtNumberOfChildren.setBounds(96, 92, 240, 20);
		panel_1.add(txtNumberOfChildren);
		txtNumberOfChildren.setColumns(10);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(485, 20, 240, 20);
		panel_1.add(txtStatus);
		txtStatus.setColumns(10);
		
		JLabel lblDdmmyyyy = new JLabel("DD:MM:YYYY");
		lblDdmmyyyy.setBounds(278, 59, 76, 14);
		panel_1.add(lblDdmmyyyy);
		
		JLabel lblDdmmyyyy_1 = new JLabel("DD:MM:YYYY");
		lblDdmmyyyy_1.setBounds(679, 59, 70, 14);
		panel_1.add(lblDdmmyyyy_1);
		
		txtDd = new JTextField();
		txtDd.setBounds(96, 56, 28, 20);
		panel_1.add(txtDd);
		txtDd.setColumns(10);
		
		JLabel label = new JLabel(":");
		label.setBounds(134, 59, 10, 14);
		panel_1.add(label);
		
		txtMm = new JTextField();
		txtMm.setBounds(144, 56, 28, 20);
		panel_1.add(txtMm);
		txtMm.setColumns(10);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(182, 59, 10, 14);
		panel_1.add(label_1);
		
		txtYyyy = new JTextField();
		txtYyyy.setBounds(202, 56, 66, 20);
		panel_1.add(txtYyyy);
		txtYyyy.setColumns(10);
		
		txtDepDD = new JTextField();
		txtDepDD.setBounds(485, 56, 28, 20);
		panel_1.add(txtDepDD);
		txtDepDD.setColumns(10);
		
		JLabel label_2 = new JLabel(":");
		label_2.setBounds(523, 59, 10, 14);
		panel_1.add(label_2);
		
		txtDepmm = new JTextField();
		txtDepmm.setBounds(533, 56, 28, 20);
		panel_1.add(txtDepmm);
		txtDepmm.setColumns(10);
		
		JLabel label_3 = new JLabel(":");
		label_3.setBounds(571, 59, 10, 14);
		panel_1.add(label_3);
		
		txtDepyyyy = new JTextField();
		txtDepyyyy.setBounds(583, 56, 86, 20);
		panel_1.add(txtDepyyyy);
		txtDepyyyy.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 142, 125, 338);
		RoomBookingPanel.add(panel);
		panel.setLayout(null);
		
		//search button
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				RoomBookingCtr rbCtr=new RoomBookingCtr();
				
				String txtArrivalDate = txtYyyy.getText()+txtMm.getText()+txtDd.getText();
				String txtDeparturedate = txtDepyyyy.getText()+txtDepmm.getText()+txtDepDD.getText();
				
				if(!txtRoomBookingId.getText().equals(""))
				{
					String stringID=txtRoomBookingId.getText();
					System.out.println(stringID);
					int id=Integer.parseInt(stringID);
					RoomBooking rb = rbCtr.findRoomBookingByID(id);
					putValuesOnTheScreen(rb);
					
					ArrayList<RoomLine> rlList=new ArrayList<RoomLine>();
					rlList=rbCtr.findRoomLinesForBooking(id);
					
					DefaultTableModel model2 = new DefaultTableModel()
					{
						private static final long serialVersionUID = 1L;

						@Override
						public boolean isCellEditable(int row, int column)
						{
							//all cells false
							return false;
						}
					};
				
					model2.setColumnIdentifiers(new String[] {"Booking id", "Guest", "Guest type", "Room", "Room type", "Room price"});
				
					try
					{
						for(RoomLine rlObj : rlList)
						{
							model2.addRow(new String[]
								{
									String.valueOf(rlObj.getBooking().getId()),
									rlObj.getGuest().getName(),
									rlObj.getGuest().getGuestType(),
									String.valueOf(rlObj.getRoom().getNumber()),
									rlObj.getRoom().getRoomType().getCategory(),
									String.valueOf(rlObj.getRoom().getRoomType().getPrice())
								});
						}
						table.setModel(model2);
					}
				
					catch(Exception e)
					{
						System.out.println("Exception: " + e);
					}
				}
				else if(!txtArrivalDate.equals(""))
				{
					int arrival = Integer.parseInt(txtArrivalDate);
					ArrayList<RoomBooking> rbList=new ArrayList<RoomBooking>();
					rbList=rbCtr.findRoomBookingByArrival(arrival);
					
					DefaultTableModel model2 = new DefaultTableModel()
					{
						private static final long serialVersionUID = 1L;

						@Override
						public boolean isCellEditable(int row, int column)
						{
							//all cells false
							return false;
						}
					};
				
					model2.setColumnIdentifiers(new String[] {"Booking id", "Guest", "Guest type", "Room", "Room type", "Room price"});
				
					try
					{
						for(RoomBooking rbObj : rbList)
						{
							ArrayList<RoomLine> rlList = new ArrayList<>();
							rlList=rbCtr.findRoomLinesForBooking(rbObj.getId());
							try
							{
								for(RoomLine rlObj : rlList)
								{
									model2.addRow(new String[]
										{
											String.valueOf(rlObj.getBooking().getId()),
											rlObj.getGuest().getName(),
											rlObj.getGuest().getGuestType(),
											String.valueOf(rlObj.getRoom().getNumber()),
											rlObj.getRoom().getRoomType().getCategory(),
											String.valueOf(rlObj.getRoom().getRoomType().getPrice())
										});
								}
								table.setModel(model2);
							}						
							catch(Exception e)
							{
								System.out.println("Exception: " + e);
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception: " + e);
					}
				}
				else if(!txtDeparturedate.equals(""))
				{
					int departure = Integer.parseInt(txtDeparturedate);
					ArrayList<RoomBooking> rbList=new ArrayList<RoomBooking>();
					rbList=rbCtr.findRoomBookingByDeparture(departure);
					
					DefaultTableModel model2 = new DefaultTableModel()
					{
						private static final long serialVersionUID = 1L;

						@Override
						public boolean isCellEditable(int row, int column)
						{
							//all cells false
							return false;
						}
					};
				
					model2.setColumnIdentifiers(new String[] {"Booking id", "Guest", "Guest type", "Room", "Room type", "Room price"});
				
					try
					{
						for(RoomBooking rbObj : rbList)
						{
							ArrayList<RoomLine> rlList = new ArrayList<>();
							rlList=rbCtr.findRoomLinesForBooking(rbObj.getId());
							try
							{
								for(RoomLine rlObj : rlList)
								{
									model2.addRow(new String[]
										{
											String.valueOf(rlObj.getBooking().getId()),
											rlObj.getGuest().getName(),
											rlObj.getGuest().getGuestType(),
											String.valueOf(rlObj.getRoom().getNumber()),
											rlObj.getRoom().getRoomType().getCategory(),
											String.valueOf(rlObj.getRoom().getRoomType().getPrice())
										});
								}
								table.setModel(model2);
							}
						
							catch(Exception e)
							{
								System.out.println("Exception: " + e);
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception: " + e);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please insert id of the booking.", "Error!", JOptionPane.ERROR_MESSAGE);			
				}
			}
		});
		btnNewButton.setBounds(6, 16, 110, 35);
		panel.add(btnNewButton);
		
		//update room booking button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				RoomBookingCtr rbCtr=new RoomBookingCtr();				

				String txtArrivalDate = txtYyyy.getText()+txtMm.getText()+txtDd.getText();
				String txtDeparturedate = txtDepyyyy.getText()+txtDepmm.getText()+txtDepDD.getText();
				
				if(txtRoomBookingId.getText().equals("")!=true)
				{
					String stringID=txtRoomBookingId.getText();
					int rbId=Integer.parseInt(stringID);
					
					RoomBooking rb1=rbCtr.findRoomBookingByID(rbId);
					if(rb1!=null)
					{
						if(txtArrivalDate.equals("")!=true || 
							txtNumberOfChildren.getText().equals("")!=true ||
							txtStatus.getText().equals("")!=true ||
							txtDeparturedate.equals("")!=true)
						{
							int arrival=Integer.parseInt(txtArrivalDate);
							int children=Integer.parseInt(txtNumberOfChildren.getText());
							String status=txtStatus.getText();
							int departure=Integer.parseInt(txtDeparturedate);
							
							rbCtr.updateBooking(rbId, arrival, departure, status, children);
							
							clearValues();
							
							JOptionPane.showMessageDialog(null, "Booking has been successfully updated.", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Some fields may be empty!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "There is no such booking!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please insert id of the booking.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
				DefaultTableModel tdm=(DefaultTableModel)table.getModel();
				tdm.getDataVector().removeAllElements();
				tdm.fireTableDataChanged();
			}
		});
		btnUpdate.setBounds(6, 108, 110, 35);
		panel.add(btnUpdate);
		
			//create button
			JButton btnCreate = new JButton("Create");
			btnCreate.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					String txtArrivalDate = txtYyyy.getText()+txtMm.getText()+txtDd.getText();
					String txtDeparturedate = txtDepyyyy.getText()+txtDepmm.getText()+txtDepDD.getText();
					
					if(txtArrivalDate.equals("")==true || txtDeparturedate.equals("")==true || txtNumberOfChildren.getText().equals("")==true || txtStatus.getText().equals("")==true)
					{
						JOptionPane.showMessageDialog(null, "Please insert all data!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						RoomBookingCtr rbCtr=new RoomBookingCtr();
						int arrival=Integer.parseInt(txtArrivalDate);
						int departure=Integer.parseInt(txtDeparturedate);
						String status=txtStatus.getText();
						int numberOfChildren=Integer.parseInt(txtNumberOfChildren.getText());
						System.out.println(txtArrivalDate);
						int bookingId = rbCtr.createNewBooking(arrival, departure, status, numberOfChildren);
						
						DefaultTableModel tdm=(DefaultTableModel)table.getModel();
						tdm.getDataVector().removeAllElements();
						tdm.fireTableDataChanged();
						
						RoomLineMenu.getInstance(bookingId, arrival, departure);
					}
				}
			});
			btnCreate.setBounds(6, 62, 110, 35);
			panel.add(btnCreate);
			
			//get available room lines 
			JButton btnGetRoomsAvailable = new JButton("Available rooms");
			btnGetRoomsAvailable.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					RoomBookingCtr rbCtr=new RoomBookingCtr();
					String txtArrivalDate = txtYyyy.getText()+txtMm.getText()+txtDd.getText();
					String txtDeparturedate = txtDepyyyy.getText()+txtDepmm.getText()+txtDepDD.getText();
					
					if(txtArrivalDate.equals("") || txtDeparturedate.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please insert arrival date and departure date.", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						int arrival=Integer.parseInt(txtArrivalDate);
						int departure=Integer.parseInt(txtDeparturedate);
						
						ArrayList<Room> rlList=new ArrayList<Room>();
						rlList=rbCtr.findAvailableRooms(arrival, departure);
						
						DefaultTableModel model2 = new DefaultTableModel()
						{
							private static final long serialVersionUID = 1L;

							@Override
							public boolean isCellEditable(int row, int column)
							{
								//all cells false
								return false;
							}
						};
					
						model2.setColumnIdentifiers(new String[] {"Booking id", "Guest", "Guest type", "Room", "Room type", "Room price"});
					
						try
						{
							for(Room rlObj : rlList)
							{
								model2.addRow(new String[]
									{
										"None",//String.valueOf(rlObj.getBooking().getId()),//None
										"None",//rlObj.getGuest().getName(),//None
										"None",//rlObj.getGuest().getGuestType(),//None
										String.valueOf(rlObj.getNumber()),
										rlObj.getRoomType().getCategory(),
										String.valueOf(rlObj.getRoomType().getPrice())
									});
							}
							table.setModel(model2);
						}
					
						catch(Exception e)
						{
							System.out.println("Exception: " + e);
						}
					}
				}
			});
			btnGetRoomsAvailable.setBounds(6, 200, 110, 35);
			panel.add(btnGetRoomsAvailable);
			
			//clear window data button
			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					clearValues();
				}
			});
			btnClear.setBounds(6, 246, 110, 35);
			panel.add(btnClear);
			
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnClose.setBounds(6, 292, 110, 35);
			panel.add(btnClose);
			
			//scroll pane and table creation
			scrollPane = new JScrollPane();
			scrollPane.setBounds(146, 142, 744, 346);
			RoomBookingPanel.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setFillsViewportHeight(true);
		//end room booking panel
		
		JPanel ActivityBookingPanel = new JPanel();
		tabbedPane.addTab("Activity booking", null, ActivityBookingPanel, null);
		ActivityBookingPanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Activity booking", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 237, 227);
		ActivityBookingPanel.add(panel_2);
		
		JLabel label_4 = new JLabel("Date:");
		label_4.setFont(new Font("Arial", Font.PLAIN, 11));
		label_4.setBounds(6, 33, 90, 14);
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "dd", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(39, 16, 57, 43);
		panel_2.add(panel_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(6, 16, 45, 20);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "MM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(97, 16, 56, 43);
		panel_2.add(panel_4);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(6, 16, 45, 20);
		panel_4.add(comboBox_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "yyyy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(152, 16, 77, 43);
		panel_2.add(panel_5);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(6, 16, 65, 20);
		panel_5.add(comboBox_2);
		
		JLabel label_5 = new JLabel("Selected date:");
		label_5.setFont(new Font("Arial", Font.PLAIN, 11));
		label_5.setBounds(6, 67, 122, 14);
		panel_2.add(label_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(91, 64, 138, 20);
		panel_2.add(textField);
		
		JLabel label_6 = new JLabel("Selected date:");
		label_6.setFont(new Font("Arial", Font.PLAIN, 11));
		label_6.setBounds(6, 95, 122, 14);
		panel_2.add(label_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 92, 138, 20);
		panel_2.add(textField_1);
		
		JButton button = new JButton("Create");
		button.setBounds(4, 120, 225, 25);
		panel_2.add(button);
		button.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton button_1 = new JButton("Activate activity lines");
		button_1.setBounds(6, 156, 225, 25);
		panel_2.add(button_1);
		button_1.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton button_2 = new JButton("All");
		button_2.setBounds(6, 192, 225, 25);
		panel_2.add(button_2);
		button_2.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Activity", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 237, 237, 93);
		ActivityBookingPanel.add(panel_6);
		
		JLabel label_7 = new JLabel("Activity:");
		label_7.setFont(new Font("Arial", Font.PLAIN, 11));
		label_7.setBounds(6, 19, 90, 14);
		panel_6.add(label_7);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_3.setEnabled(false);
		comboBox_3.setBounds(57, 16, 170, 20);
		panel_6.add(comboBox_3);
		
		JLabel label_8 = new JLabel("Max participants:");
		label_8.setFont(new Font("Arial", Font.PLAIN, 11));
		label_8.setBounds(6, 44, 90, 14);
		panel_6.add(label_8);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(104, 41, 123, 20);
		panel_6.add(textField_2);
		
		JLabel label_9 = new JLabel("Start hour:");
		label_9.setFont(new Font("Arial", Font.PLAIN, 11));
		label_9.setBounds(6, 69, 90, 14);
		panel_6.add(label_9);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setEnabled(false);
		comboBox_4.setBounds(104, 66, 123, 20);
		panel_6.add(comboBox_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "Facility", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 330, 237, 75);
		ActivityBookingPanel.add(panel_7);
		
		JLabel label_10 = new JLabel("Facility:");
		label_10.setFont(new Font("Arial", Font.PLAIN, 11));
		label_10.setBounds(6, 19, 90, 14);
		panel_7.add(label_10);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_5.setEnabled(false);
		comboBox_5.setBounds(57, 16, 170, 20);
		panel_7.add(comboBox_5);
		
		JButton button_3 = new JButton("Get facilities");
		button_3.setFont(new Font("Arial", Font.PLAIN, 11));
		button_3.setEnabled(false);
		button_3.setBounds(6, 43, 225, 25);
		panel_7.add(button_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "Instructor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(10, 407, 237, 100);
		ActivityBookingPanel.add(panel_8);
		
		JLabel label_11 = new JLabel("Instructor:");
		label_11.setFont(new Font("Arial", Font.PLAIN, 11));
		label_11.setBounds(6, 19, 90, 14);
		panel_8.add(label_11);
		
		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_6.setEnabled(false);
		comboBox_6.setBounds(60, 16, 170, 20);
		panel_8.add(comboBox_6);
		
		JButton button_4 = new JButton("Get instructors");
		button_4.setFont(new Font("Arial", Font.PLAIN, 11));
		button_4.setEnabled(false);
		button_4.setBounds(6, 40, 225, 25);
		panel_8.add(button_4);
		
		JButton button_5 = new JButton("Clear");
		button_5.setFont(new Font("Arial", Font.PLAIN, 11));
		button_5.setEnabled(false);
		button_5.setBounds(6, 68, 225, 25);
		panel_8.add(button_5);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(null, "Activity line", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(708, 400, 237, 107);
		ActivityBookingPanel.add(panel_10);
		
		JButton button_8 = new JButton("Add");
		button_8.setFont(new Font("Arial", Font.PLAIN, 11));
		button_8.setEnabled(false);
		button_8.setBounds(6, 11, 225, 25);
		panel_10.add(button_8);
		
		JButton button_9 = new JButton("Cancel activity");
		button_9.setFont(new Font("Arial", Font.PLAIN, 11));
		button_9.setEnabled(false);
		button_9.setBounds(6, 46, 225, 25);
		panel_10.add(button_9);
		
		JButton button_10 = new JButton("All");
		button_10.setFont(new Font("Arial", Font.PLAIN, 11));
		button_10.setEnabled(false);
		button_10.setBounds(6, 75, 225, 25);
		panel_10.add(button_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(null, "Activity lines", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(257, 237, 688, 162);
		ActivityBookingPanel.add(panel_11);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 672, 130);
		panel_11.add(scrollPane_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new TitledBorder(null, "Activity bookings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBounds(257, 11, 688, 215);
		ActivityBookingPanel.add(panel_12);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 16, 672, 188);
		panel_12.add(scrollPane_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(256, 407, 272, 100);
		ActivityBookingPanel.add(panel_9);
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "Team", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_12 = new JLabel("Team:");
		label_12.setFont(new Font("Arial", Font.PLAIN, 11));
		label_12.setBounds(6, 19, 90, 14);
		panel_9.add(label_12);
		
		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_7.setEnabled(false);
		comboBox_7.setBounds(60, 16, 65, 20);
		panel_9.add(comboBox_7);
		
		JButton button_6 = new JButton("Get teams");
		button_6.setFont(new Font("Arial", Font.PLAIN, 11));
		button_6.setEnabled(false);
		button_6.setBounds(6, 40, 256, 25);
		panel_9.add(button_6);
		
		JButton button_7 = new JButton("Clear");
		button_7.setFont(new Font("Arial", Font.PLAIN, 11));
		button_7.setEnabled(false);
		button_7.setBounds(6, 68, 256, 25);
		panel_9.add(button_7);
		
		JLabel label_13 = new JLabel("Participants:");
		label_13.setFont(new Font("Arial", Font.PLAIN, 11));
		label_13.setBounds(135, 19, 90, 14);
		panel_9.add(label_13);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(198, 16, 65, 20);
		panel_9.add(textField_3);
		
		
	}
	
	private void putValuesOnTheScreen(RoomBooking rbObj)
	{
		txtRoomBookingId.setText(String.valueOf(rbObj.getId()));
		txtDd.setText(String.valueOf(rbObj.getArrivalDate()).substring(6, 8));
		txtMm.setText(String.valueOf(rbObj.getArrivalDate()).substring(4, 6));
		txtYyyy.setText(String.valueOf(rbObj.getArrivalDate()).substring(0, 4));
		txtDepDD.setText(String.valueOf(rbObj.getDepartureDate()).substring(6, 8));
		txtDepmm.setText(String.valueOf(rbObj.getDepartureDate()).substring(4, 6));
		txtDepyyyy.setText(String.valueOf(rbObj.getDepartureDate()).substring(0, 4));
		txtNumberOfChildren.setText(String.valueOf(rbObj.getNumberOfChildren()));
		txtStatus.setText(rbObj.getStatus());
	}

	private void clearValues()
	{
		txtRoomBookingId.setText(null);
		txtDd.setText(null);
		txtMm.setText(null);
		txtYyyy.setText(null);
		txtDepDD.setText(null);
		txtDepmm.setText(null);
		txtDepyyyy.setText(null);
		txtNumberOfChildren.setText(null);
		txtStatus.setText(null);
		
		DefaultTableModel tdm=(DefaultTableModel)table.getModel();
		tdm.getDataVector().removeAllElements();
		tdm.fireTableDataChanged();
	}

public void clearGuestPanel()
{
	guestIdTextField.setText("");
	guestNameTextField.setText("");
	guestCityTextField.setText("");
	guestCountryTextField.setText("");
	guestZipcodeTextField.setText("");
	guestAddressTextField.setText("");
	guestPhoneNoTextField.setText("");
	guestEmailTextField.setText("");
	guestPasswordTextField.setText("");									
	guestGuestTypeComboBox.setSelectedItem(null);
	guestTravelAgencyComboBox.setSelectedItem(null);
}

public void clearGuestTable()
{
	guestTable.setCellSelectionEnabled(false);
	guestTable.setModel(new DefaultTableModel());
}

public DefaultTableModel getGuestTableModel()
{
	LinkedList<Guest> completeGuestList = new LinkedList<Guest>();
	completeGuestList = guestCtr.getAllGuests();
	
	DefaultTableModel guestTableModel = new DefaultTableModel()
	{
		private static final long serialVersionUID = 1L;
		
		public boolean isCellEditable(int row, int column)
		{
			//all cells false
			return false;
		}
	};
	
	guestTableModel.setColumnIdentifiers(new String[] {"Id", "Name", "Guest type", "Travel agency", "Password"});
	
	for(Guest guestObj : completeGuestList)
	{
		String travelAgencyName = new String();
		TravelAgency travelAgencyObj = new TravelAgency();
		travelAgencyObj = guestObj.getTravelAgency();
		if(travelAgencyObj == null)
		{
			travelAgencyName = "0";
		}
		else
		{
			travelAgencyName = travelAgencyObj.getName();
		}
		guestTableModel.addRow(new String[]
				{
				String.valueOf(guestObj.getId()),
				guestObj.getName(),
				guestObj.getGuestType(),
				travelAgencyName,
				guestObj.getPassword()
				});
	}
	
	guestTable.setCellSelectionEnabled(true);
	ListSelectionModel cellSelectionModel = guestTable.getSelectionModel();
	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	cellSelectionModel.addListSelectionListener(new ListSelectionListener()
	{
		public void valueChanged(ListSelectionEvent arg0)
		{
			Guest guestObj = new Guest();
			
			int selectedRow = guestTable.getSelectedRow();
			if(selectedRow > -1)
			{
				String selectedData = (String) guestTable.getValueAt(selectedRow, 0);
				int guestId = Integer.parseInt(selectedData);
				String stringGuestId = String.valueOf(guestId);
				
				guestObj = guestCtr.searchGuestById(guestId);
				String guestName = guestObj.getName();
				int guestZipCode = guestObj.getZipCode();
				String stringGuestZipcode = String.valueOf(guestZipCode);
				String guestCountry = guestObj.getCountry();
				String guestAddress = guestObj.getAddress();
				String guestPhoneNo = guestObj.getPhoneNo();
				String guestEmail = guestObj.getEmail();
				String guestPassword = guestObj.getPassword();
				String guestType = guestObj.getGuestType();
											
				String travelAgencyName = new String();
				TravelAgency travelAgencyObj = new TravelAgency();
				travelAgencyObj = guestObj.getTravelAgency();
				if(travelAgencyObj == null)
				{
					travelAgencyName = "0";
				}
				else
				{
					travelAgencyName = travelAgencyObj.getName();
				}
				
				Location locationObj = new Location();
				locationObj = locationCtr.getLocation(guestZipCode, guestCountry);
				String guestCity = locationObj.getCity();
				
				guestIdTextField.setText(stringGuestId);
				guestNameTextField.setText(guestName);
				guestCityTextField.setText(guestCity);
				guestCountryTextField.setText(guestCountry);
				guestZipcodeTextField.setText(stringGuestZipcode);
				guestAddressTextField.setText(guestAddress);
				guestPhoneNoTextField.setText(guestPhoneNo);
				guestEmailTextField.setText(guestEmail);
				guestPasswordTextField.setText(guestPassword);									
				guestGuestTypeComboBox.setSelectedItem(guestType);
				
				if(travelAgencyName.equals("0") == true)
				{
					guestTravelAgencyComboBox.setSelectedItem(null);
				}
				else
				{
					guestTravelAgencyComboBox.setSelectedItem(travelAgencyName);
				}
			}
		}
	});
	
	return guestTableModel;
 }
}
