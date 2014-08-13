# Android build from Gradle build
This is a example project for android build using gradle build tool. 
This contain,
 
 * How to set file dependencies and module dependencies (android modules, java modules) to the project. 
 * Demonstrate how to use gradle and maven repositories in the project and each module. 
 * What are the gradle tasks and how we can use them.

### Gradle installation

 1. Download the gradle from here (for this sample project using gradle 1.12)

     > http://www.gradle.org/downloads

 2. Extract the gradle.tar.gz file to your preferred location and set PATH to GRADLE_HOME 

### Build the sample project

 1. Clone the project
  
     > git clone https://kavi707@bitbucket.org/kavi707/android-gradle-build.git

 2. Clean and build the project

     > #### (If you installed gradle)
     > 
     > ./gradle clean
     >
     > ./gradle build

     > ---

     > #### (If you don't install gradle)
     > 
     > ./gradlew clean
     >
     > ./gradlew build

### Project dependencies 
 In a project we can define three type of dependencies, Module dependencies, file dependencies and Library dependencies. In this sample project you can see
there are separate modules as Android application module (app), Android library module (support) and Java library module (java-support). 
These three modules depended as follows

#### Module dependencies

 * **app** module depended on **support** module - (app module build.gradle)
      
      ```

        dependencies {
            compile fileTree(dir: 'libs', include: ['*.jar'])
            compile project(':support')
        }
      ```  
       
    `compile project(':support')` part defines **app** module depend on **support** module   
    
     --- 
 
 * **support** module depended on **java-support** module - (support module build.gradle)

      ```

        dependencies {
            compile fileTree(dir: 'libs', include: ['*.jar'])
            compile project(':java-support')
        }
      ``` 

    `compile project(':java-support')` part defines **support** module depend on **java-support** module 

#### File dependencies

 * **support** module use **gcm.jar** as external file dependency (support module build.gradle)
       
      ```

        dependencies {
            compile fileTree(dir: 'libs', include: ['*.jar'])
            compile project(':java-support')
            compile files('libs/gcm.jar')
        }
      ```

    `compile files('libs/gcm.jar')` part defines **support** module have **gcm.jar** external dependency and its located in module **libs** directory
   
#### Library dependency

 * **java-support** module use **maven** library dependency (java-support module build.gradle)

      ```

        dependencies {
            compile fileTree(dir: 'libs', include: ['*.jar'])
            compile group:'org.apache.commons', name:'commons-math3', version:'3.2'
        }
      ```

    `compile group:'org.apache.commons', name:'commons-math3', version:'3.2'` part defines **java-support** module use this **apche-commons-math** library as dependency. This library dependency integration is discussed below with further details
   
### Gradle and Maven repository usage

In Gradle we can use maven repositories as for dependency downloading. In this sample project java-support module shows how we can do it.

 * In Maven

      ```

        <dependency>
	      <groupId>org.apache.commons</groupId>
	      <artifactId>commons-math3</artifactId>
	      <version>3.2</version>
        </dependency>

      ```
 
 * In Gradle

      ```

        dependencies {
            compile fileTree(dir: 'libs', include: ['*.jar'])
            compile group:'org.apache.commons', name:'commons-math3', version:'3.2'
        }

      ```

Above two code blocks show how we defines a dependency in maven and gradle. So you can clearly see that, we need to configure same parameters as follows

Maven       | Gradle
----------- | -----------
groupId     | group
artifactId  | name
version     | version

### Gradle Tasks