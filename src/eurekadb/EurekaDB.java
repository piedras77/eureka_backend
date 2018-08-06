/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eurekadb;

import java.util.Scanner;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.service.ServiceRegistry;

//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.stage.Popup;
//import javafx.stage.Stage;
/**
 *
 * @author sebastian
 */
public class EurekaDB { // extends Application {

    private static SessionFactory factory;
    private static ServiceRegistry registry;
//    private final static int APP_WIDTH = 900;
//    private final static int APP_HEIGHT = 400;
//    private Stage primaryStage;
//    private HBox navigationButtons;
//    private final static int REFRESH_BUTTON_POS = 1;
//    private final static int BUTTON_SPACING = 7;
    
//    @Override
//    public void start(Stage primaryStage) {
//        try {
//            this.primaryStage = primaryStage;
//            Button main = new Button("Main Menu");
//            Button refresh = new Button("Refresh");
//            main.setOnAction((event) -> {
//                goToMain();
//            });
//            navigationButtons = new HBox(main, refresh);
//            navigationButtons.setAlignment(Pos.CENTER);
//            navigationButtons.setPadding(new Insets(20, 0, 20, 0));
//            navigationButtons.setSpacing(BUTTON_SPACING);
//            goToMain();
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration().configure();
            registry = new StandardServiceRegistryBuilder().applySettings(
            configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(registry);
        } catch (Throwable e) {
            System.out.println("Failed to create Session Factory." + e);
            throw new ExceptionInInitializerError();
        }
        
        Scanner scnr = new Scanner(System.in);
        System.out.println("APPLICATION RUNNING, PRESS ENTER TO QUIT");
        scnr.nextLine();
        
        StandardServiceRegistryBuilder.destroy(registry);
    }
    
//    private void goToMain() {
//        ((Button) navigationButtons.getChildren().get(REFRESH_BUTTON_POS))
//                .setText("Refresh");
//        VBox root = new VBox();
//        HBox buttons = new HBox();
//        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
//        Button showUsers = new Button("Show Users");
//        Button showTexts = new Button("Show Texts");
//        Button addTexts = new Button("Add Texts");        
//        Button addUsers = new Button("Add Users");
//
//        buttons.getChildren().add(showUsers);
//        buttons.getChildren().add(showTexts);
//        buttons.getChildren().add(addTexts);
//        buttons.getChildren().add(addUsers);
//        buttons.setSpacing(BUTTON_SPACING);
//
//        showUsers.setOnAction((event) -> {
//            showAllUsers();             
//        });
//
//        showTexts.setOnAction((event) -> {
//            showAllTexts(null);
//        });
//
//        addUsers.setOnAction((event) -> {
//            showAddUser();
//        });
//
//        addTexts.setOnAction((event) -> {
//            showAddText();
//        });
//
//        root.setAlignment(Pos.CENTER);
//        buttons.setAlignment(Pos.CENTER);
//        root.getChildren().add(buttons);           
//        primaryStage.setScene(scene);
//    }
//    
//    private void showAllUsers() {
//        HBox searchBox = new HBox();
//        TextField emailField = new TextField();
//        Button searchEmail = new Button("Search");        
//        searchBox.getChildren().add(new Text("Search by email: "));
//        searchBox.getChildren().add(emailField);
//        searchBox.getChildren().add(searchEmail);        
//        ((Button) navigationButtons.getChildren().get(REFRESH_BUTTON_POS))
//                .setOnAction((event) -> {
//                                       System.out.println("REFRESING USERS");
//
//                    showAllUsers();
//                });
//        GridPane grid = new GridPane();
//        grid.add(searchBox, 0, 0);
//        List<Users> users = getAllUsers();
//        int row = 1;
//        for (Iterator<Users> iterator = users.iterator();
//                iterator.hasNext();) {
//            Users user = iterator.next();
//            Button userButton = new Button(
//                "Email: "  + user.getEmail() + " ~ " +
//                "Name: " + user.getName() + " ~ " + 
//                "Age: " + user.getAge() + " ~ " +
//                "Gender: " + (user.getGender() ? "female" : "male") + " ~ " +
//                "Points: " + user.getPoints() + " ~ " +
//                "Facebook: " + (user.getFacebook() ? "yes" : "no") + " ~" +
//                "Admin: " + (user.getAdmin() ? "yes" : "no") + " ~" +
//                "Account created on: " + user.getSignupTime()+ " ~ " +
//                "Last login: " + user.getLastLogin()
//            );
//            grid.add(userButton, 0, row++);
//            grid.setMargin(userButton,
//                    new Insets(0, 0, BUTTON_SPACING, 0));
//            userButton.setOnAction((event) -> {
//                popup(true, user);
//            });
//        }
//        
//        showAllHelper(grid);
//    }
//   
//    private void showAllTexts(List<Texts> texts) {
//        HBox searchBox = new HBox();
//        TextField idField = new TextField();
//        Button searchID = new Button("Search");
//        TextField levelField = new TextField();
//        Button searchLevel = new Button("Search");
//        searchBox.getChildren().add(new Text("Search by id: "));
//        searchBox.getChildren().add(idField);
//        searchBox.getChildren().add(searchID);
//        searchBox.getChildren().add(new Text("Search by level: "));
//        searchBox.getChildren().add(levelField);
//        searchBox.getChildren().add(searchLevel);
//        GridPane grid = new GridPane();
//        grid.add(searchBox, 0, 0);
//        ((Button) navigationButtons.getChildren().get(REFRESH_BUTTON_POS))
//               .setOnAction((event) -> {
//                   System.out.println("REFRESING TEXTS");
//                   showAllTexts(null);
//        });
//        
//        searchID.setOnAction((event) -> {            
//            try {
//                if (idField.getText().isEmpty()) {
//                    showAllTexts(null);
//                } else{
//                    List<Texts> text = new LinkedList();
//                    text.add(getText(Long.parseLong(idField.getText())));
//                    showAllTexts(text);
//                }
//            } catch (Exception e) {
//                popupMessage("Invalid text index or index not found");
//            }
//        });
//        
//        searchLevel.setOnAction((event) -> {            
//            try {
//                if (levelField.getText().isEmpty()) {
//                    showAllTexts(null);
//                } else{
//                    showAllTexts(getText(Byte.parseByte(levelField.getText())));
//                }
//            } catch (Exception e) {
//                popupMessage("Invalid text index or index not found");
//            }
//        });
//        
//        if (texts == null) 
//            texts = getAllTexts();
//        int row = 1;
//        for (Iterator<Texts> iterator = texts.iterator();
//                iterator.hasNext();) {
//            Texts text = iterator.next();
//            Button textButton = new Button(
//                "Title: " + text.getTitle() + " ~ " + 
//                "Level: " + text.getLevel() + " ~ " +
//                "ID: " + text.getId() + " ~ " + 
//                "Upload date: " + text.getUploadDate() + " ~ " +
//                "Prompt: " + text.getText().substring(0, 40) + "..."
//            );
//            grid.add(textButton, 0, row++);
//            grid.setMargin(textButton,
//                    new Insets(0, 0, BUTTON_SPACING, 0));
//            textButton.setOnAction((event) -> {
//                popup(false, text);
//            });
//        }
//        
//       showAllHelper(grid);
//    }
//    
//    private void showAllHelper(GridPane grid) {
//        grid.setPadding(new Insets(0, 0, 0, BUTTON_SPACING));
//        BorderPane allUsers = new BorderPane();
//        ScrollPane usersPane = new ScrollPane(grid);
//        allUsers.setTop(navigationButtons);
//        if (grid.getChildren().size() <= 1)
//            allUsers.setCenter(new Text("There is no data available, yet."));
//        else
//            allUsers.setCenter(usersPane);
//        Scene userScene = new Scene(allUsers, APP_WIDTH, APP_HEIGHT);
//        primaryStage.setScene(userScene); 
//    }
//    
//    private void showAddText() {           
//        TextField titleField = new TextField();
//        TextField levelField = new TextField();
//        HBox input1 = new HBox();
//        VBox topPane = new VBox();
//        input1.setSpacing(BUTTON_SPACING);
//        input1.setPadding(new Insets(0, 0, BUTTON_SPACING, BUTTON_SPACING));
//        input1.getChildren().add(new Text("Title: "));
//        input1.getChildren().add(titleField);
//        input1.getChildren().add(new Text("Level: "));
//        input1.getChildren().add(levelField);  
//        topPane.getChildren().add(navigationButtons);
//        topPane.getChildren().add(input1);
//        TextArea textData = new TextArea("Text data..."); 
//        textData.setPadding(new Insets(BUTTON_SPACING, BUTTON_SPACING, BUTTON_SPACING, BUTTON_SPACING));
//        BorderPane pane = new BorderPane();
//        Texts text = new Texts();
//        pane.setTop(topPane);
//        pane.setCenter(textData);
//        Button submitButton = 
//            ((Button) navigationButtons.getChildren().get(REFRESH_BUTTON_POS));
//        submitButton.setText("Submit");
//        submitButton.setOnAction((event) -> {
//            try {
//                text.setLevel(Byte.parseByte(levelField.getText()));
//                text.setTitle(titleField.getText());
//                text.setUploadDate(new Date());
//                text.setText(textData.getText());
//                addText(text);
//                popupMessage("Text correctly added");
//            }catch (Exception e) {
//                popupMessage("Could not add this text to Eureka's database.");
//            }
//            
//            
//        });
//        Scene scene = new Scene(pane, APP_WIDTH, APP_HEIGHT);
//        primaryStage.setScene(scene);
//    }
//    
//    private void showAddUser() {
//        HBox emailBox = new HBox();
//        TextField emailField = new TextField();
//        emailBox.getChildren().addAll(  new Text("Email: "), emailField);
//        
//        HBox nameBox = new HBox();
//        TextField nameField = new TextField();
//        nameBox.getChildren().addAll(  new Text("Name: "), nameField);
//        
//        HBox ageBox = new HBox();
//        TextField ageField = new TextField();
//        ageBox.getChildren().addAll(  new Text("Age: "), ageField);
//        
//        HBox passwordBox = new HBox();
//        TextField passwordField = new TextField();
//        passwordBox.getChildren().addAll(  new Text("Password: "), passwordField);
//        
//        HBox genderBox = new HBox();
//        CheckBox genderField = new CheckBox("F checked, M unchecked");      
//        genderBox.getChildren().addAll(  new Text("Gender: "), genderField);
//        
//        HBox facebookBox = new HBox();
//        CheckBox facebookField = new CheckBox();
//        facebookBox.getChildren().addAll(  new Text("Facebook: "), facebookField);
//        
//        HBox adminBox = new HBox();
//        CheckBox adminField = new CheckBox();
//        adminBox.getChildren().addAll(  new Text("Admin: "), adminField);
//        
//        HBox pointsBox = new HBox();
//        TextField pointsField = new TextField();
//        pointsBox.getChildren().addAll(  new Text("Points: "), pointsField);
//        
//        GridPane grid = new GridPane();        
//        grid.add(emailBox, 0, 0);
//        grid.add(nameBox, 1, 0);
//        grid.add(ageBox, 2, 0);
//        grid.add(passwordBox, 0, 1);
//        grid.add(pointsBox, 1, 1);        
//        grid.add(genderBox, 0, 2);
//        grid.add(facebookBox, 1, 2);
//        grid.add(adminBox, 2, 2);
//        grid.setHgap(BUTTON_SPACING);
//        grid.setVgap(BUTTON_SPACING);        
//        grid.setPadding(new Insets(BUTTON_SPACING));
//        BorderPane pane = new BorderPane();
//        pane.setTop(navigationButtons);
//        pane.setCenter(grid);
//        Button submitButton = 
//            ((Button) navigationButtons.getChildren().get(REFRESH_BUTTON_POS));
//        submitButton.setText("Submit");
//        submitButton.setOnAction((event) -> {
//            try {
//                Users user = new Users(
//                    emailField.getText(),
//                    nameField.getText(),
//                    Byte.parseByte (ageField.getText()),
//                    passwordField.getText(),
//                    genderField.selectedProperty().get(),
//                    facebookField.selectedProperty().get(),
//                    adminField.selectedProperty().get(),
//                    new Date(),
//                    new Date(),
//                    Integer.parseInt(pointsField.getText())
//                );
//              
//                addUser(user);
//                popupMessage("User correctly added");
//                showAddUser();
//            } catch(NumberFormatException ex) {
//                popupMessage("Invalid info, could not add user.");
//            } catch (Exception e) {
//                e.printStackTrace();
//                popupMessage("Could not add this text to Eureka's database.");
//            }          
//        });
//        
//        Scene scene = new Scene(pane, APP_WIDTH, APP_HEIGHT);
//        primaryStage.setScene(scene);
//    }
//    
//    private void popupMessage(String message) {
//        Stage popupStage = new Stage();
//        HBox button = new HBox();
//        Button accept = new Button("Okay");
//        accept.setOnAction((event) -> {
//            popupStage.close();
//        });
//        button.getChildren().add(accept);
//        popupHelper(message, button, popupStage);
//
//    }
//    private void popup(boolean userElement, Object element) {
//        Stage popupStage = new Stage();
//        HBox buttons = new HBox();
//        Button accept = new Button("Yes");
//        Button cancel = new Button("Cancel");
//        accept.setOnAction((event) -> {
//            if (userElement) {
//                deleteUser(( (Users) element ).getId());
//            } else {
//                deleteText(( (Texts) element ).getId());
//            }
//            
//            popupStage.close();
//            ((Button)navigationButtons.getChildren().get(REFRESH_BUTTON_POS))
//                    .fire();
//        });
//        
//        cancel.setOnAction((event) -> {
//            popupStage.close();
//        });
//        buttons.getChildren().add(accept);
//        buttons.getChildren().add(cancel);
//        popupHelper("Delete this element?", buttons, popupStage);
//    }
//    
//    private void popupHelper(String message, HBox buttons, Stage popupStage) {
//        VBox popupLayout = new VBox();
//        popupLayout.getChildren().add(
//                new Text(message)
//        );
//        popupLayout.getChildren().add(buttons);
//        popupLayout.setAlignment(Pos.CENTER);
//        buttons.setAlignment(Pos.CENTER);
//        buttons.setSpacing(BUTTON_SPACING);
//        Scene popupScene = new Scene(popupLayout, 250, 150);
//        popupStage.setScene(popupScene);
//        popupStage.show();
//    }
    
    //HIBERNATE FROM HERE ONWARDS    
    private List<Users> getAllUsers() {
        return getAllHelper(true);
    }
    
    private List<Texts> getAllTexts() {
        return getAllHelper(false);
    }
    
    private List getAllHelper(boolean getUsers) {
        Session session = factory.openSession();
        Transaction tx = null;
        List results = null;
        try {
            tx = session.beginTransaction();
            results = session.createQuery(
                    "FROM " + (getUsers ? "Users" : "Texts")
            ).list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
        return results;
    }
    
    private Users getUser(String email) {//        
        return (Users) getHelper(Users.class, "email", email).get(0);
    }
    
    
    private Texts getText(long textID) {
        return (Texts) getHelper(Texts.class, "id", textID).get(0);
    }
    
    private List<Texts> getText (byte levelID) {
        return getHelper(Texts.class, "level", levelID);
    }
    
    private List getHelper(Class objectClass, String column, Object value) {
        Session session = factory.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(objectClass);
            criteria.add(Restrictions.eq(column, value));
            result = criteria.list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to get element");
        } finally {
            session.close();
        }
        
        return result;
    }

    private void addUser(Users user) {
        addHelper(user);
    }
        
    private void addText(Texts text) {
        addHelper(text);
    }
    
    private void addHelper(Object element) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(element);
            tx.commit();
        } catch(ConstraintViolationException e) {
              if (tx != null) tx.rollback();
              System.err.println("This email address already exists. Cannot be added");
        } catch(HibernateException ex) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
    
    private void deleteUser(long id) {
        deleteHelper(true, id);
    }
    
    private void deleteText(long id) {
        deleteHelper(false, id);
    }
    
    private void deleteHelper(boolean deleteUser, long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Object element;
            if (deleteUser) {
                element = session.get(Users.class, id);
            } else {
               element = session.get(Texts.class, id);
            }
            
            session.delete(element);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            System.err.println("Could not delete User");
        } finally {
            session.close();
        }   
    }
}
