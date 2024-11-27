package application;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import db.dbhandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class Controller implements Initializable {
	private Stage stage;
	private Parent root;
	private Scene scene;
	
	public void switchToAdmin (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}
	public void switchToReception (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("receptionistlogin.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		//hi	
			
		}
	
	public void switchToReception1 (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Receptionist.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTrainer (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("trainerlogin.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}
	public void switchToShopkeeper (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("shopkeeperlogin.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	@FXML
	private Label loginmessagelable;
	@FXML
	private TextField adminname;
	@FXML
	private PasswordField adminpass;
	
	public void loginadmin (ActionEvent e) throws IOException {
		if(adminname.getText().isBlank()==false && adminpass.getText().isBlank() == false ) {
			verifyadminlogin(e);
			
		}else {
			loginmessagelable.setText("Please Enter username and password!");
		}
		
	}
	public void verifyadminlogin(ActionEvent event) throws IOException{
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifylogin ="select count(1) from admin where fname ='" + adminname.getText() + "' and password ='"+adminpass.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifylogin);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		System.out.println("hihihi");
	        		loginmessagelable.setText("Welcome");
	        		Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
	        		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        		scene = new Scene(root);
	        		stage.setScene(scene);
	        		stage.show();
	        		
	        	}else {
	        		loginmessagelable.setText("Login info not found!");
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
		}
	}
	
	@FXML
	private Label loginmessagelableRec;
	@FXML
	private TextField receptionname;
	@FXML
	private PasswordField receptionpass;
	public void loginreception (ActionEvent e) throws IOException {
		if(receptionname.getText().isBlank()==false && receptionpass.getText().isBlank() == false ) {
			
			verifyReclogin(e);
			
			
		}else {
			loginmessagelableRec.setText("Please Enter username and password!");
		}
		
	}
	
	public void verifyReclogin(ActionEvent event) throws IOException{
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifylogin ="select count(1) from receptionist where fname ='" + receptionname.getText() + "' and password ='"+ receptionpass.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifylogin);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		loginmessagelableRec.setText("Welcome");
	        		Parent root = FXMLLoader.load(getClass().getResource("Receptionist.fxml"));
	        		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        		scene = new Scene(root);
	        		stage.setScene(scene);
	        		stage.show();
	        		
	        		
	        	}else {
	        		loginmessagelableRec.setText("Login info not found!");
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
		}
	}
	
	@FXML
	private Label loginmessagelableshopkeeper;
	@FXML
	private TextField shopkeepername;
	@FXML
	private PasswordField shopkeeperpass;
	public void loginshopkeeper (ActionEvent e) throws IOException {
		if(shopkeepername.getText().isBlank()==false && shopkeeperpass.getText().isBlank() == false ) {
			verifyshopkeeperlogin(e);
			
		}else {
			loginmessagelableshopkeeper.setText("Please Enter username and password!");
		}
		
	}
	
	public void verifyshopkeeperlogin(ActionEvent event) throws IOException {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifylogin ="select count(1) from shopkeeper where fname ='" + shopkeepername.getText() + "' and password ='"+ shopkeeperpass.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifylogin);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		loginmessagelableshopkeeper.setText("Welcome");
	        		Parent root = FXMLLoader.load(getClass().getResource("Shopkeeper.fxml"));
	        		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        		scene = new Scene(root);
	        		stage.setScene(scene);
	        		stage.show();
	        	}else {
	        		loginmessagelableshopkeeper.setText("Login info not found!");
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
		}
	}
	@FXML
	private Label loginmessagelabletrainer;
	@FXML
	private TextField trainername;
	@FXML
	private PasswordField trainerpass;
	
	private static Trainer trainer1 = new Trainer();;
	
	public void logintrainer (ActionEvent e) throws IOException {
		if(trainername.getText().isBlank()==false && trainerpass.getText().isBlank() == false ) {
			verifytrainerlogin(e);
			
		}else {
			loginmessagelabletrainer.setText("Please Enter username and password!");
		}
		
	}
	
	public void verifytrainerlogin(ActionEvent event) throws IOException {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifylogin ="select count(1) from trainer where fname ='" + trainername.getText() + "' and password ='"+ trainerpass.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifylogin);
	        ResultSet queryResult= preparedStatement.executeQuery();
	       
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		trainer1.setFname(trainername.getText().toString());
	        		System.out.print(trainer1.getFname());
	     	        trainer1.setPassword(trainerpass.getText().toString());
	        		loginmessagelabletrainer.setText("Welcome");
	        		Parent root = FXMLLoader.load(getClass().getResource("Trainer.fxml"));
	        		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        		scene = new Scene(root);
	        		stage.setScene(scene);
	        		stage.show();
	        	}else {
	        		loginmessagelabletrainer.setText("Login info not found!");
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
		}
	}
	
	@FXML
    private Button Menu;

    @FXML
    private Button MenuBack;

    @FXML
    private AnchorPane slider;
    
    @FXML
    private AnchorPane logoPane;
    
    public void hide(ActionEvent e)
    {
    	TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);

        slide.setToX(-180);
        slide.play();
        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(0.4));
        slide2.setNode(logoPane);

        slide2.setToX(-70);
        slide2.play();
    	slider.setTranslateX(-180);
    	Menu.setVisible(false);
        MenuBack.setVisible(true);
        logoPane.setTranslateX(-70);
        
    }
    public void show(ActionEvent e)
    {
    	TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);

        slide.setToX(0);
        slide.play();
        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(0.4));
        slide2.setNode(logoPane);

        slide2.setToX(0);
        slide2.play();
    	slider.setTranslateX(0);
    	Menu.setVisible(true);
        MenuBack.setVisible(false);
        logoPane.setTranslateX(0);
    }
    
    @FXML
    private Button manageMembersButton;
    
    public void switchToManageMembers (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ManageMembers.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToAssignLockers (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AssignLockers.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToCollectFees (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CollectFees.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToRegisterComplaints (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RegisterComplaints.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    @FXML
    private Button dashboardButton;
    @FXML
    private Button memberAddButton;
    @FXML
    private Button memberRemoveButton;
    @FXML
    private Button memberUpdateButton;
    @FXML
    private Button memberViewButton;
    
    public void switchToManageMembersView (ActionEvent e) throws IOException {
  		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
  		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
  		scene = new Scene(root);
  		stage.setScene(scene);
  		stage.show();
  	}
    public void switchToManageMembersUpdate (ActionEvent e) throws IOException {
  		Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
  		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
  		scene = new Scene(root);
  		stage.setScene(scene);
  		stage.show();
  	}
    public void switchToManageMembersRemove (ActionEvent e) throws IOException {
  		Parent root = FXMLLoader.load(getClass().getResource("Remove.fxml"));
  		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
  		scene = new Scene(root);
  		stage.setScene(scene);
  		stage.show();
  	}
    public void switchToManageMembersAdd (ActionEvent e) throws IOException {
  		Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
  		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
  		scene = new Scene(root);
  		stage.setScene(scene);
  		stage.show();
  	}
    ///for add member
    @FXML
    private TextField traineridtext,lockeridtext,phonetext,cnictext,lnametext,fnametext;
    @FXML
    private DatePicker dobtext;
    @FXML
    private RadioButton feestatusno;
    @FXML
    private RadioButton feestatusyes;
    @FXML
	private Label addMemberlable;
    private boolean fee;
    public void addMemebr () throws SQLException {
    	boolean radioselected=false;
    	if (feestatusno.isSelected()) {
			fee=false;
			radioselected=true;
		}else if(feestatusyes.isSelected()) {
			fee=true;
			radioselected=true;
		}
		if(radioselected==true && dobtext.getValue().toString().isBlank()==false && phonetext.getText().isBlank()==false && cnictext.getText().isBlank() == false && lnametext.getText().isBlank()==false && fnametext.getText().isBlank() == false ) {
			customer cus = new customer(cnictext.getText(), fnametext.getText(), lnametext.getText(), dobtext.getValue().toString(), fee ,phonetext.getText(), traineridtext.getText(),lockeridtext.getText());
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
				System.out.println("Connected With the database successfully 10");
				
				String query ="insert into customer (id,fname,lname,dob,feepaid,phone,tid,lid) values(?,?,?,?,?,?,?,?) ";
				
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,cus.getId());
				preparedStatement.setString(2,cus.getFname());
				preparedStatement.setString(3,cus.getLname());
				preparedStatement.setString(4,cus.getDob());
				preparedStatement.setBoolean(5, cus.isFeepaid());
				preparedStatement.setString(6, cus.getPhone());
				if(cus.getTid().isBlank()==false){
					preparedStatement.setString(7,cus.getTid());
				}else {
					preparedStatement.setString(7,null);
				}
				
				if(cus.getLid().isBlank()==false){
					preparedStatement.setString(8,cus.getLid());
				}else {
					preparedStatement.setString(8,null);
				}
				
				
		        preparedStatement.executeUpdate();;
	        
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database  "+e.toString());
			}
		}else {
			addMemberlable.setText("Please fill required fields!");
		}
		
	}
    
    //for remove member
    @FXML
	private TextField removeMembercnic;
    @FXML
	private Label removeMemberlable;
    
    public void removeMember () {
		if(removeMembercnic.getText().isBlank()==false ) {
			if(verifyRemoveMemberCnic()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="DELETE FROM customer WHERE id ='" + removeMembercnic.getText() + "'";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
			        preparedStatement.executeUpdate();
			        
					
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else {
			removeMemberlable.setText("Please Enter Cnic!");
		}
		
	}
    public boolean verifyRemoveMemberCnic() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from customer where id ='" + removeMembercnic.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		removeMemberlable.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
    
  //for view member
  	@FXML
  	private TextField viewMembercnic;
  	@FXML
  	private Label viewMemberlable,viewMemberfnamelable,viewMemberlnamelable,viewMemberDOBlable,viewMemberPhonelable,viewMemberFeestatuslable,viewMemberTrainerlable,viewMemberlockerlable;
  	
  	public void viewMember() {
		if(viewMembercnic.getText().isBlank()==false ) {
			if(verifyViewMemberCnic()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="Select * FROM customer WHERE id ='" + viewMembercnic.getText() + "'";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
					ResultSet queryResult= preparedStatement.executeQuery();
					if(queryResult.next()){
						viewMemberfnamelable.setText(queryResult.getString(2));
						viewMemberlnamelable.setText(queryResult.getString(3));
						viewMemberPhonelable.setText(queryResult.getString(6));
						viewMemberFeestatuslable.setText(queryResult.getString(5));
						viewMemberTrainerlable.setText(queryResult.getString(7)) ;
						viewMemberlockerlable.setText(queryResult.getString(8));
						viewMemberDOBlable.setText(queryResult.getString(4));
					}
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else {
			viewMemberlable.setText("Please Enter Cnic!");
		}
		
	}
  	public boolean verifyViewMemberCnic() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from customer where id ='" + viewMembercnic.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		viewMemberlable.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  //for update member
  	@FXML
    private TextField updatetraineridtext,updatelockeridtext,updatephonetext,updatecnictext,updatelnametext,updatefnametext;
    @FXML
    private DatePicker updatedobtext;
    @FXML
    private RadioButton updatefeestatusno;
    @FXML
    private RadioButton updatefeestatusyes;
    @FXML
	private Label updateMemberlable;
    private boolean updatefee;
    public void updateMemebr () throws SQLException {
    	boolean radioselected=false;
    	if (updatefeestatusno.isSelected()) {
    		updatefee=false;
			radioselected=true;
		}else if(updatefeestatusyes.isSelected()) {
			updatefee=true;
			radioselected=true;
		}
		if(radioselected==true && updatedobtext.getValue().toString().isBlank()==false && updatephonetext.getText().isBlank()==false && updatecnictext.getText().isBlank() == false && updatelnametext.getText().isBlank()==false && updatefnametext.getText().isBlank() == false ) {
			customer cus = new customer(updatecnictext.getText(), updatefnametext.getText(), updatelnametext.getText(), updatedobtext.getValue().toString(), updatefee ,updatephonetext.getText(), updatetraineridtext.getText(),updatelockeridtext.getText());
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
				System.out.println("Connected With the database successfully 10");
				String query;
				if(updatetraineridtext.getText().isBlank() == false && updatelockeridtext.getText().isBlank()== false){
					 query ="UPDATE customer SET fname = '"+ updatefnametext.getText() + "' ,lname='"+updatelnametext.getText() +"' ,dob='"+ updatedobtext.getValue().toString() +"' ,feepaid="+ updatefee + " ,phone='"+updatephonetext.getText()+ "' ,tid='" +updatetraineridtext.getText()+"' ,lid='"+updatelockeridtext.getText()+"'  WHERE id ='" + updatecnictext.getText() + "' ";
					
				}else if(updatetraineridtext.getText().isBlank() == true && updatelockeridtext.getText().isBlank()== false) {
					 query ="UPDATE customer SET fname = '"+ updatefnametext.getText() + "' ,lname='"+updatelnametext.getText() +"' ,dob='"+ updatedobtext.getValue().toString() +"' ,feepaid="+ updatefee + " ,phone='"+updatephonetext.getText()+ "' ,tid='" + null +"' ,lid='"+updatelockeridtext.getText()+"'  WHERE id ='" + updatecnictext.getText() + "' ";
					
				}else if(updatetraineridtext.getText().isBlank() == false && updatelockeridtext.getText().isBlank()== true ) {
					 query ="UPDATE customer SET fname = '"+ updatefnametext.getText() + "' ,lname='"+updatelnametext.getText() +"' ,dob='"+ updatedobtext.getValue().toString() +"' ,feepaid="+ updatefee + " ,phone='"+updatephonetext.getText()+ "' ,tid='" +updatetraineridtext.getText()+"' ,lid='"+null+"'  WHERE id ='" + updatecnictext.getText() + "' ";
					
				}else {
					 query ="UPDATE customer SET fname = '"+ updatefnametext.getText() + "' ,lname='"+updatelnametext.getText() +"' ,dob='"+ updatedobtext.getValue().toString() +"' ,feepaid="+ updatefee + " ,phone='"+updatephonetext.getText()+ "' WHERE id ='" + updatecnictext.getText() + "' ";
					
				}
				
				PreparedStatement preparedStatement=connection.prepareStatement(query);
		        preparedStatement.executeUpdate();;
	        
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database  "+e.toString());
			}
		}else {
			updateMemberlable.setText("Please fill required fields!");
		}
		
	}
  //FOR COLLECT FEES
    @FXML
    private Label collectFeeslable;
    @FXML
    private TextField collectfeeCnicText,collectfeeAmountText;
    
    public void collectFees (ActionEvent event) throws IOException {
		if(collectfeeCnicText.getText().isBlank()==false && collectfeeAmountText.getText().isBlank()==false ) {
			if(verifycollectFeesCnic()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="update customer Set feepaid = true WHERE id ='" + collectfeeCnicText.getText() + "'";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
			        preparedStatement.executeUpdate();
			        
					
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else {
			collectFeeslable.setText("Please Enter Cnic and Amount!");
		}
		
	}
    public boolean verifycollectFeesCnic() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from customer where id ='" + collectfeeCnicText.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		collectFeeslable.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
    
    //FOR COLLECT FEES
    @FXML
    private Label RegisterComplaintlable;
    @FXML
    private TextArea RegisterComplaintText;
    
    public void RegisterComplaint (ActionEvent event) throws IOException {
		if( RegisterComplaintText.getText().isBlank()==false ) {
			complaint comp = new complaint(RegisterComplaintText.getText());
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
				System.out.println("Connected With the database successfully");
				String query ="insert into complaints (items,dateregistered,solvedstatus) values(?,?,?) ";
				
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,comp.getComplain());
				preparedStatement.setString(2,comp.getDateregistered());
				preparedStatement.setBoolean(3, false)	;
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database13 "+e.toString());
					
			}
			
		}else {
			RegisterComplaintlable.setText("Please Enter Complaint");
		}
		
	}
    
    //FOR Assignlockers
    @FXML
    private Label Assignlockerslable;
    @FXML
    private TextField AssignlockersCnicText,AssignlockerslockednoText;
    @FXML
    private TableView<lockers> AssignlockersAvalaible;
    @FXML
    private TableColumn<lockers,String> Assignlockerscolumn1;
    @FXML
    private TableColumn<lockers,String> Assignlockerscolumn2;
    @FXML
    ObservableList<lockers> lockerObservableList = FXCollections.observableArrayList();
    
    public void initialize(URL url, ResourceBundle resource) {
    	
    	
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
				System.out.println("Connected With the database successfully");
				String query = "select * from locker;";
				
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				ResultSet queryResult= preparedStatement.executeQuery();
				
		    
		        while(queryResult.next()) {
		     
		        	lockerObservableList.add(new lockers(queryResult.getString(1), queryResult.getString(2)));
		        }
		        if(Assignlockerscolumn1 != null && Assignlockerscolumn2 != null) {
		        	Assignlockerscolumn1.setCellValueFactory(new PropertyValueFactory<lockers, String>( "lockerid"));
			        Assignlockerscolumn2.setCellValueFactory (new PropertyValueFactory<lockers, String>( "Assignedto"));
			        AssignlockersAvalaible.setItems(lockerObservableList);
		        }
		        
		        
		        
		        
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database13 "+e.toString());
				
				
			}
			
	}
    
    public void assignLocker (ActionEvent event) throws IOException {
		if(AssignlockersCnicText.getText().isBlank()==false && AssignlockerslockednoText.getText().isBlank() ==false) {
			if(verifyAssignlockersCnic()) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String query ="update locker SET assignedto ='"+AssignlockerslockednoText.getText()+"' WHERE lockerid='"+AssignlockerslockednoText.getText() +"' ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
						
				}
			}
	
		}else {
			Assignlockerslable.setText("Please Enter Cnic and locker no");
		}
		
	}
    public boolean verifyAssignlockersCnic() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from customer where id ='" + AssignlockersCnicText.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		Assignlockerslable.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
    ///////////////////////////////////// N E W ////////////////////////////////////////////////////
    public void switchToDiet (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("DietPlan.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToWorkout (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("WorkoutPlan.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void Trainer (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Trainer.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void Shopkeeper (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Shopkeeper.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToShop (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ManageShop.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToSell (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SellItems.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToBill (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Bill.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToAddItems (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddItem.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToRemoveItems (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RemoveItem.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToUpdateItems (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UpdateItem.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToViewItems (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void Admin (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToHandleMachines (ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("HandleMachines.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToManageStaff(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ManageStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToRepairMachine(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RepairMachine.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToAddMachine(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddMachine.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToUpdateMachine(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UpdateMachine.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToRemoveMachine(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RemoveMachine.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToViewMachine(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewMachine.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToAddStaff(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToUpdateStaff(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UpdateStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToRemoveStaff(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RemoveStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    public void switchToViewStaff(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    //////////////For trainer/////////////////////
    
    @FXML
    private Label dietPlanlable;
    @FXML
    private TextField dietPlanCnicText;
    @FXML
    private TextArea dietPlanText;
    
    public void issueDietPlan (ActionEvent event) throws IOException {
		if(dietPlanCnicText.getText().isBlank()==false && dietPlanText.getText().isBlank()==false ) {
			dietPlan plan = new dietPlan(trainer1.getFname(),dietPlanCnicText.getText(),dietPlanText.getText());
			if(dietPlanCnic()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="Insert into dietplan (tid,cid,plan) values(?,?,?) ";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
					preparedStatement.setString(1,plan.getTrainerid());
					preparedStatement.setString(2,plan.getCustomerid());
					preparedStatement.setString(3,plan.getPlan());
			        preparedStatement.executeUpdate();
			        
					
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else {
			dietPlanlable.setText("Please Enter Cnic and Amount!");
		}
		
	}
    public boolean dietPlanCnic() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from customer where id ='" + dietPlanCnicText.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		dietPlanlable.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
    //workOutplan
    @FXML
    private Label workOutlable;
    @FXML
    private TextField workOutCnicText;
    @FXML
    private TextArea workOutText;
    
    public void issueworkOut (ActionEvent event) throws IOException {
		if(workOutCnicText.getText().isBlank()==false && workOutText.getText().isBlank()==false ) {
			workOutplan plan = new workOutplan(trainer1.getFname(),workOutCnicText.getText(),workOutText.getText());
			if(workOutCnic()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="Insert into workoutplan (tid,cid,plan) values(?,?,?) ";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
					preparedStatement.setString(1,plan.getTrainerid());
					preparedStatement.setString(2,plan.getCustomerid());
					preparedStatement.setString(3,plan.getPlan());
			        preparedStatement.executeUpdate();
			        
					
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else {
			dietPlanlable.setText("Please Enter Cnic and Amount!");
		}
		
	}
    public boolean workOutCnic() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from customer where id ='" + workOutCnicText.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		workOutlable.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
    //for addMAchine
    @FXML
    private Label Error;
    
    @FXML
    private DatePicker MachineDate;

    @FXML
    private TextField MachineName;

    @FXML
    private TextField MachineQuantity;
    
    
    public void addMachine () throws SQLException {
    	
		if(MachineDate.getValue().toString().isBlank()==false && MachineName.getText().isBlank()==false && MachineQuantity.getText().isBlank() == false  ) {
			machines mac = new machines(MachineName.getText(), Integer.parseInt(MachineQuantity.getText()),  MachineDate.getValue().toString(),"" );
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
				System.out.println("Connected With the database successfully 10");
				
				String query ="insert into machines (name,quantity,buydate,repairs) values(?,?,?,?) ";
				
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,mac.getName());
				preparedStatement.setInt(2,mac.getQuantity());
				preparedStatement.setString(3,mac.getBuyDate());
				preparedStatement.setString(4,mac.getRepairs());
				
				
				
		        preparedStatement.executeUpdate();;
	        
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database  "+e.toString());
			}
		}else {
			Error.setText("Please fill required fields!");
		}
		
	}
    //REMOVEMACHINE
    @FXML
    private Label Error2;


    @FXML
    private TextField RMachineName;

    int quantityk;
    public void removeMachine () {
		if(RMachineName.getText().isBlank()==false ) {
			if(verifyRemoveMachineName() ) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="DELETE FROM machines WHERE name ='" + RMachineName.getText() + "'";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
			        preparedStatement.executeUpdate();
			        
					
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else  {
			Error2.setText("ENTER NAME PLEASE!");
		}
		
		
	}
    public boolean verifyRemoveMachineName() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymachine ="select count(1) from machines where name ='" + RMachineName.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymachine);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		Error2.setText("Machine not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
    
    //UPDATE MACHINE
    @FXML
    private Label error3;
    
    @FXML
    private DatePicker uMachineBuyDate;

    @FXML
    private TextField uMachineName;

    @FXML
    private TextField uMachineQuantity;
    public void updateMachine () throws SQLException {
    	
		if(uMachineBuyDate.getValue().toString().isBlank()==false && uMachineName.getText().isBlank()==false && uMachineQuantity.getText().isBlank() == false  ) {
			machines mac = new machines(uMachineName.getText(), Integer.parseInt(uMachineQuantity.getText()), uMachineBuyDate.getValue().toString(), "" );
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
				System.out.println("Connected With the database successfully 10");
				String query;
					 query ="UPDATE machines SET quantity = '"+ mac.getQuantity() + "' ,buydate='"+mac.getBuyDate() +"'  WHERE name ='" + mac.getName()+ "' ";
					
				
				PreparedStatement preparedStatement=connection.prepareStatement(query);
		        preparedStatement.executeUpdate();;
	        
			} catch (SQLException e) {
				System.out.println("Error while connecting to the database  "+e.toString());
			}
		}else {
			updateMemberlable.setText("Please fill required fields!");
		}
		
	}
    //VIEW MACHINE
    @FXML
    private TextField VMachineName;

    @FXML
    private Label error4;


    @FXML
    private Label vBuy;

    @FXML
    private Label vName;

    @FXML
    private Label vQuantity;

    @FXML
    private Label vRepair;
    public void viewMachine() {
		if(VMachineName.getText().isBlank()==false ) {
			if(verifyViewMachineName()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully");
					String verifymember ="Select * FROM machines WHERE name ='" + VMachineName.getText() + "'";
					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
					ResultSet queryResult= preparedStatement.executeQuery();
					if(queryResult.next()){
						vName.setText(queryResult.getString(1));
						vQuantity.setText(queryResult.getString(2));
						vBuy.setText(queryResult.getString(3));
						vRepair.setText(queryResult.getString(4));
					}
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database13 "+e.toString());
					
				}
			}
			
		}else {
			error4.setText("MACHINE NOT FOUND!");
		}
		
	}
  	public boolean verifyViewMachineName() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from machines where name ='" + VMachineName.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error4.setText("MACHINE not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	@FXML
    private TextField sc;

    @FXML
    private Label scl;

    @FXML
    private TextField scn;

    @FXML
    private DatePicker sdob;

    @FXML
    private TextField sfn;


    @FXML
    private TextField sln;

    @FXML
    private TextField sp;

    @FXML
    private TextField spn;

    @FXML
    private RadioButton sr;

    @FXML
    private TextField ss;

    @FXML
    private RadioButton ssh;

    @FXML
    private RadioButton st;
    

    @FXML
    private Label error5;
    
  	public void rR(ActionEvent e)
  	{
  		scl.setTranslateX(13);
  		scl.setTranslateY(256);
  		sc.setTranslateX(104);
  		sc.setTranslateY(256);
  	}
  	//ADD STAFF
  	private String typess;
    public void addStaff() throws SQLException {
    	boolean radioselected=false;
    	
    	if (sr.isSelected()) {
			typess="R";
			radioselected=true;
		}else if(ssh.isSelected()) {
			typess="S";
			radioselected=true;
		}
		else if(st.isSelected()) {
			typess="T";
			radioselected=true;
		}
		if(radioselected==true && sfn.getText().isBlank()==false && sln.getText().isBlank()==false && scn.getText().isBlank() == false && sdob.getValue().toString().isBlank()==false && ss.getText().isBlank() == false && sp.getText().isBlank() == false && spn.getText().isBlank() == false ) {
			if(typess=="R")
			{
				receptionist rc = new receptionist(scn.getText(), sfn.getText(), sln.getText(), sdob.getValue().toString() ,sp.getText(), Integer.parseInt(ss.getText()),spn.getText());
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully 10");
					
					String query ="insert into receptionist (id,fname,lname,dob,salary,password,phone) values(?,?,?,?,?,?,?) ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					preparedStatement.setString(1,rc.getId());
					preparedStatement.setString(2,rc.getFname());
					preparedStatement.setString(3,rc.getLname());
					preparedStatement.setString(4,rc.getDob());
					preparedStatement.setInt(5, rc.getSalary());
					preparedStatement.setString(6, rc.getPassword());
					preparedStatement.setString(7,rc.getPhone());
					
			        preparedStatement.executeUpdate();;
		        
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database  "+e.toString());
				}
			}
			else if(typess=="S")
			{
				shopkeeper rc = new shopkeeper(scn.getText(), sfn.getText(), sln.getText(), sdob.getValue().toString() ,sp.getText(), Integer.parseInt(ss.getText()),spn.getText());
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully 10");
					
					String query ="insert into shopkeeper (id,fname,lname,dob,salary,password,phone) values(?,?,?,?,?,?,?) ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					preparedStatement.setString(1,rc.getId());
					preparedStatement.setString(2,rc.getFname());
					preparedStatement.setString(3,rc.getLname());
					preparedStatement.setString(4,rc.getDob());
					preparedStatement.setInt(5, rc.getSalary());
					preparedStatement.setString(6, rc.getPassword());
					preparedStatement.setString(7,rc.getPhone());
					
			        preparedStatement.executeUpdate();;
		        
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database  "+e.toString());
				}
			}
			else if(typess=="T")
			{
				Trainer rc = new Trainer(scn.getText(), sfn.getText(), sln.getText(), sdob.getValue().toString() ,ss.getText(), sp.getText(),spn.getText(),sc.getText());
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully 10");
					
					String query ="insert into trainer (id,fname,lname,dob,salary,password,phone,comission) values(?,?,?,?,?,?,?,?) ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					preparedStatement.setString(1,rc.getId());
					preparedStatement.setString(2,rc.getFname());
					preparedStatement.setString(3,rc.getLname());
					preparedStatement.setString(4,rc.getDob());
					preparedStatement.setString(5, rc.getSalary());
					preparedStatement.setString(6, rc.getPassword());
					preparedStatement.setString(7,rc.getPhone());
					preparedStatement.setString(8,rc.getComission());
					
			        preparedStatement.executeUpdate();;
		        
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database  "+e.toString());
				}
			}
		}
				
		else {
			error5.setText("Please fill required fields!");
		}
		
	}
    
    //updateStaff
    @FXML
    private TextField ucn;

    @FXML
    private DatePicker udob;

    @FXML
    private TextField ufn;

    @FXML
    private TextField uln;

    @FXML
    private TextField up;

    @FXML
    private TextField upn;

    @FXML
    private RadioButton ur;

    @FXML
    private TextField us,uc;

    @FXML
    private RadioButton ush;

    @FXML
    private RadioButton ut;
    
    @FXML
    private Label error6,ucl;
    private String t;
    public void updateStaff() throws SQLException {
    	boolean radioselected=false;
    	
    	if (ur.isSelected()) {
			t="R";
			radioselected=true;
		}else if(ush.isSelected()) {
			t="S";
			radioselected=true;
		}
		else if(ut.isSelected()) {
			t="T";
			radioselected=true;
		}
		if(radioselected==true && ufn.getText().isBlank()==false && uln.getText().isBlank()==false && ucn.getText().isBlank() == false && udob.getValue().toString().isBlank()==false && us.getText().isBlank() == false && up.getText().isBlank() == false && upn.getText().isBlank() == false ) {
			if(t=="R")
			{
				receptionist rc = new receptionist(ucn.getText(), ufn.getText(), uln.getText(), udob.getValue().toString() ,up.getText(), Integer.parseInt(us.getText()),upn.getText());
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully 10");
					
					String query ="UPDATE receptionist SET fname = '"+ ufn.getText() + "' ,lname='"+uln.getText() +"' ,dob='"+ udob.getValue().toString() +"' ,password="+ up.getText()+ " ,salary="+ Integer.parseInt(us.getText())+ ",phone='"+upn.getText()+ "'   WHERE id ='" + ucn.getText() + "' ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					
			        preparedStatement.executeUpdate();;
		        
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database  "+e.toString());
				}
			}
			else if(t=="S")
			{
				shopkeeper rc = new shopkeeper(ucn.getText(), ufn.getText(), uln.getText(), udob.getValue().toString() ,up.getText(), Integer.parseInt(us.getText()),upn.getText());
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully 10");
					
					String query ="UPDATE shopkeeper SET fname = '"+ ufn.getText() + "' ,lname='"+uln.getText() +"' ,dob='"+ udob.getValue().toString() +"' ,password="+ up.getText()+ " ,salary="+ Integer.parseInt(us.getText())+ ",phone='"+upn.getText()+ "'   WHERE id ='" + ucn.getText() + "' ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					
			        preparedStatement.executeUpdate();;
		        
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database  "+e.toString());
				}
			}
			
			else if(t=="T")
			{
				Trainer rc = new Trainer(ucn.getText(), ufn.getText(), uln.getText(), udob.getValue().toString(), us.getText() ,up.getText(),upn.getText(),uc.getText());
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
					System.out.println("Connected With the database successfully 10");
					
					String query ="UPDATE trainer SET fname = '"+ ufn.getText() + "' ,comission = '"+ uc.getText() + "',lname='"+uln.getText() +"' ,dob='"+ udob.getValue().toString() +"' ,password="+ up.getText()+ " ,salary="+ Integer.parseInt(us.getText())+ ",phone='"+upn.getText()+ "'   WHERE id ='" + ucn.getText() + "' ";
					
					PreparedStatement preparedStatement=connection.prepareStatement(query);
					
			        preparedStatement.executeUpdate();;
		        
				} catch (SQLException e) {
					System.out.println("Error while connecting to the database  "+e.toString());
				}
			}
		}
				
		else {
			error6.setText("Please fill required fields!");
		}
		
	}
    public void rR2(ActionEvent e)
  	{
  		ucl.setTranslateX(13);
  		ucl.setTranslateY(256);
  		uc.setTranslateX(104);
  		uc.setTranslateY(256);
  	}
    public void rR3(ActionEvent e)
  	{
  		vcl.setTranslateX(13);
  		vcl.setTranslateY(256);
  		vc.setTranslateX(104);
  		vc.setTranslateY(256);
  	}
	//VIEW STAFF
    @FXML
    private Label vc;

    @FXML
    private Label vcl;

    @FXML
    private TextField vcn;

    @FXML
    private Label vn;

    @FXML
    private Label vp;

    @FXML
    private RadioButton vr;

    @FXML
    private Label vs;

    @FXML
    private RadioButton vsh;

    @FXML
    private RadioButton vt;

    @FXML
    private Label vty,error7;
  	public void viewStaff() {
  		boolean radioselected=false;
    	t="";
    	if (vr.isSelected()) {
			t="R";
			radioselected=true;
		}else if(vsh.isSelected()) {
			t="S";
			radioselected=true;
		}
		else if(vt.isSelected()) {
			t="T";
			radioselected=true;
		}
		if(vcn.getText().isBlank()==false && radioselected==true) {
			if(t=="R")
			{
				if(verifyViewReceptionist()) {
					
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
						System.out.println("Connected With the database successfully");
						String verifymember ="Select * FROM receptionist WHERE id ='" + vcn.getText() + "'";
						PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
						ResultSet queryResult= preparedStatement.executeQuery();
						if(queryResult.next()){
							vn.setText(queryResult.getString(2));
							vp.setText(queryResult.getString(7));
							vs.setText(queryResult.getString(5));
							vty.setText("RECEPTIONIST") ;
						}
					} catch (SQLException e) {
						System.out.println("Error while connecting to the database13 "+e.toString());
						
					}
				}
			}
			else if(t=="S")
			{
				if(verifyViewShopkeeper()) {
					
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
						System.out.println("Connected With the database successfully");
						String verifymember ="Select * FROM shopkeeper WHERE id ='" + vcn.getText() + "'";
						PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
						ResultSet queryResult= preparedStatement.executeQuery();
						if(queryResult.next()){
							vn.setText(queryResult.getString(2));
							vp.setText(queryResult.getString(7));
							vs.setText(queryResult.getString(5));
							vty.setText("SHOPKEEPER") ;
						}
					} catch (SQLException e) {
						System.out.println("Error while connecting to the database13 "+e.toString());
						
					}
				}
			}
			else if(t=="T")
			{
				if(verifyViewTrainer()) {
					
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
						System.out.println("Connected With the database successfully");
						String verifymember ="Select * FROM trainer WHERE id ='" + vcn.getText() + "'";
						PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
						ResultSet queryResult= preparedStatement.executeQuery();
						if(queryResult.next()){
							vn.setText(queryResult.getString(2));
							vp.setText(queryResult.getString(7));
							vs.setText(queryResult.getString(5));
							vty.setText("TRAINER") ;
							vcl.setText("Comission:") ;
							vc.setText(queryResult.getString(8)) ;
						}
					} catch (SQLException e) {
						System.out.println("Error while connecting to the database13 "+e.toString());
						
					}
				}
			}
				
			
		}else {
			error7.setText("Please Enter Cnic!");
		}
		
		
	}
  	public boolean verifyViewReceptionist() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from receptionist where id ='" + vcn.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error7.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	public boolean verifyViewShopkeeper() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from shopkeeper where id ='" + vcn.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error7.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	public boolean verifyViewTrainer() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from trainer where id ='" + vcn.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error7.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	//REMOVE MEMBER
  	 @FXML
     private TextField rcn;

     @FXML
     private RadioButton rr;

     @FXML
     private RadioButton rsh;

     @FXML
     private RadioButton rt;
     
     @FXML
     private Label error8;

     public void removeStaff () {
    	 boolean radioselected=false;
     	t="";
     	if (rr.isSelected()) {
 			t="R";
 			radioselected=true;
 		}else if(rsh.isSelected()) {
 			t="S";
 			radioselected=true;
 		}
 		else if(rt.isSelected()) {
 			
 			t="T";
 			radioselected=true;
 		}
 		if(rcn.getText().isBlank()==false ) {
 			if(t=="R")
 			{
	 			if(verifyRemoveReceptionist()) {
	 				try {
	 					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
	 					System.out.println("Connected With the database successfully");
	 					String verifymember ="DELETE FROM receptionist WHERE id ='" + rcn.getText() + "'";
	 					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	 			        preparedStatement.executeUpdate();
	 			        
	 					
	 				} catch (SQLException e) {
	 					System.out.println("Error while connecting to the database13 "+e.toString());
	 					
	 				}
	 			}
 			}
 			else if(t=="S")
 			{
	 			if(verifyRemoveShopkeeper()) {
	 				try {
	 					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
	 					System.out.println("Connected With the database successfully");
	 					String verifymember ="DELETE FROM shopkeeper WHERE id ='" + rcn.getText() + "'";
	 					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	 			        preparedStatement.executeUpdate();
	 			        
	 					
	 				} catch (SQLException e) {
	 					System.out.println("Error while connecting to the database13 "+e.toString());
	 					
	 				}
	 			}
 			}
	 			else if(t=="T")
	 			{
		 			if(verifyRemoveTrainer()) {
		 				try {
		 					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
		 					System.out.println("Connected With the database successfully");
		 					String verifymember ="DELETE FROM trainer WHERE id ='" + rcn.getText() + "'";
		 					PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
		 			        preparedStatement.executeUpdate();
		 			        
		 					
		 				} catch (SQLException e) {
		 					System.out.println("Error while connecting to the database13 "+e.toString());
		 					
		 				}
		 			}
	 			}
 			}

 			
 		else {
 			error8.setText("Please Enter Cnic!");
 		}
 		
 	}
  	public boolean verifyRemoveReceptionist() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from receptionist where id ='" + rcn.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error8.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	public boolean verifyRemoveShopkeeper() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from shopkeeper where id ='" + rcn.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error8.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	public boolean verifyRemoveTrainer() {
    	boolean found=false;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");
			String verifymember ="select count(1) from trainer where id ='" + rcn.getText() + "'";
			PreparedStatement preparedStatement=connection.prepareStatement(verifymember);
	        ResultSet queryResult= preparedStatement.executeQuery();
	        
	        while(queryResult.next()) {
	        	if(queryResult.getInt(1)==1) {
	        		found= true;
	        	}else {
	        		error8.setText("Cnic not found!");
	        		found= false;
	        	}
	        }
			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database12"+e.toString());
			
		}
		return found;
	}
  	
  	
}




