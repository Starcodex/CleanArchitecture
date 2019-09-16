# CleanArchitecture
Android CleanArchitecture demo

This is a sample app using the Uncle Bob's clean architecture approach.

Resources:  

Room for SQLite Database  
MVVM + DataBinding  
Dagger2 for Dependencies Injection  
Retorfit for Rest Client  
RXJava for Reactive Programing  
Kotlin Language  
  
Gradle plugin 5.4.1  
  
The data is retrieved from local database, if the local database returns an empty response, the data is retrieved from the APiClient and stored in local database
for a future request.  
   
   
![Screenshot](https://github.com/Starcodex/CleanArchitecture/blob/develop/clean_architecture.png)


# CleanArchitecture Layers
![Screenshot](https://github.com/Starcodex/CleanArchitecture/blob/develop/clean_architecture_layers.png)
   
The Presentation Layer contains Views and ViewModels, the ViewModel is responsible to handle UI interaction and communicate with Domain Layer,
the ViewModel Updates the UI aswell, this layer can only contains logic related with Views.  
  
The Domain Layer contains the USeCases that links the Presentation Layer with Data Layer and is responsible for the bussiness logic.
  
The Data Layer is implemented with the repository patters, the repository is responsible for handle the data from remote or local origin (API, or local Database)
  

# Layers Details
![Screenshot](https://github.com/Starcodex/CleanArchitecture/blob/develop/clean_architecture_layers_details.png)
  
  
The communication Between Layers occurs thanks to RxJava, Observable objects that can have a subscription to "listen" the new changes and update the UI.
The suscriber waits until the data changes.

# Classes
  
   
Data Layer:  
Entities are models used for data Layer and they can be Models for localDatabase, for remote responses or they can be both, 
but the models that arrive until the presentation layer
must be different classes just with the values that UI needs in order to acomplish the dependencie's inversion principle 
  
Domain Layer:  
The USeCases don't have dependencies, they works with interfaces implemented in the respectives repositories,
In this Layer the data is wrapped into new Model for use it in UI.

Presentation layer:
ViewModel is responsible of Update UI, that could be throught dataBinding or RX.  
  
  
  
  
  
   

  
