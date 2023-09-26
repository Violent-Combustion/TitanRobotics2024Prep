2024 code documentation:
we are now using subclasses (extends) througout our code 
this means that to add a new function to the code a new 
file will be created with the class being defined as: 
public class (functions name) extends (parent) {}
In doing so we whish to achieve a more modular and standardized
coding format.
Note: More information is located in each folder in reference 
to each Sub System)

We have also started to use a single instance of commonly called 
code. To access these use the following:
    mDrive = Drive.getInstance();
    mGyro = Gyro.getInstance();
To make a new commonly used instance use:
    private static (function) mInstance = null;

    public static (function) getInstance() {
      if (mInstance == null) {
          mInstance = new (function)();
      }
      return mInstance;

Descriptions: please add descriptions to functions using:
/*(description)*/
Note: These files do note automatically go to the next line 
so please go to the next line if the description is reaching 
this size with no end soon.

hi

Documentation: please update documentation as needed
Note: These files do note automatically go to the next line 
so please go to the next line if the Documentation is reaching 
this size with no end soon.

Comments/Notes: if code is getting complicated enough where a quick
look over the code does not explain what it does please add 
Comments/Notes using: //(Comment/Note)
Note: These files do note automatically go to the next line 
so please go to the next line if the Comment/Note is reaching 
this size with no end soon.
