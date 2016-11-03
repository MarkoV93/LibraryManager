# LibraryManager
This is simple library meneger aplication

Functionality:

In main menu you can choose one of actions:
  
add - for adding new book
  
delete - for deleting new book

books - for viewing all books

find - for finding book by part of title

genres - for viewing       genresand books by genre

update - for changing book's title

help - for getting this information

exit - exiting from application

Then after choosing you can return to the main menu by command ‘cencel’ or after end of operation.

Instaling:

1.Import project in your IDE.

2.At the first running of application ,change in file: LibraryManager\src\main\resources\hibernate.cfg.xml 

       a)<property name="hibernate.hbm2ddl.auto"></property> 
       
On 

          <property name="hibernate.hbm2ddl.auto">create</property>

b)Set your password and login to MySQL in this file

     <property name="hibernate.connection.username">(login)</property>
     
      <property name="hibernate.connection.password">(password)</property>,
  
3.Create in MySQL new database 'MyLibrary'

Libraries and frameworks

1.Hibernate – for connection to a database, operating with model objects and their validation;

2.Log4j-for logging project errors and warnings;

3.javax.persistence- for mapping entity;

Patterns

1.	singleton - in com.mycompany.util.HibernateUtil.class and in 
com.mycompanyt.dao.impl.DaoFactory.class for returning only one object of session initialized in static field.;

2.	Factory method- in com.mycompany.dao.DaoFactory.class for returning model's dao classes and in com.mycompany.commands.CommandFactory.class for crating commands;

3.	Lazy initialization- in com.markoproject.dao.DaoFactory.class for  initialization model's dao classes and in com.mycompany.commands.CommandFactory.class;

4.	Data Access Object –for work with entity;

5.	Command-for working with different actions
