# ap-lab9

## Overview
At the moment, the app contains:
- A working JPA app using the Hibernate ORM and a PostgreSQL database
- A well-configured persistence.xml file
- The *entity* package with the required classes Artist and Album
- The *util* package with the required PersistenceUtil singleton used to create a static instance of a EntityManagerFactory
- The *repo* package with the required classes ArtistRepository and AlbumRepository, each implementing ArtistDAO and AlbumDAO, respectively, in order to implement the required methods
- The *app* package with the AlbumManager class serving as a main class for testing purposes

## Compulsory
The tasks are:
- Create a *persistence unit* with the name "MusicAlbumsPU" (use EclipseLink or Hibernate or other JPA implementation).
- Verify the presence of the *persistence.xml* file in your project. Make sure the driver for EclipseLink or Hibernate was added to your project classpath (or add it yourself).
- Create the package *entity* in your project and define the entity classes *Artist* and *Album*. You may use the IDE support in order to generate entity classes from database tables.
- Create the package *util* containing a class called *PersistenceUtil*. This class must contain a method for creating/returning an *EntityManagerFactory* object. Implement the *Singleton* design pattern.
- Create the package *repo* in your project and define the classes *ArtistRepository* and *AlbumRepository*. Both classes must have the methods:
  - *create* that receives an entity and saves it into the database;
  - *findById* that returns an entity based on its primary key;
  - *findByName* that returns a list of entities that match a given name pattern. Use a *named query* in order to implement this method. 
- The *AlbumRepository* class must also have the method *findByArtist*, that returns the list of albums of a given artist. Use a named query in order to implement this method.
- Create the package *app* and the main class *AlbumManager* in order to test your application.