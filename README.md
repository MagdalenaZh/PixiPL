PixiPL(Planner/Note Taking Application)

Project Description

This application is a planner platform with integrated gamification elements to enhance user engagement and 
productivity. It features several key components including a login page, character selection, a map interface,
 and individual pages for health, education, and finance management. 

Why did I decide on health, education, and finance? As a student I wanted this application to appeal to people
 my age so I thought of the three most common areas people would be interested to write about day to day. 




Features

Login Page:
Users authenticate using a username and password which are checked if entered and valid.

Loading Screen:
During the loading phase, the username entered is displayed, providing a personalized touch to the user experience.

Character Selection:
Choose from six different characters to represent the user, adding a visual element to the application.

Map Page:
Displays the selected character both in the center and upper left corner of the screen.
Progress bars for health, education, and finance are present in the left upper corner next to the character image.
 I chose this because it reminded me of a lot of video games I have previously played. 
Various sections on the map represent different areas: Health and Fitness, Education, Money/Finance
Each section is accessible via buttons for navigation which are actually the pictures themselves.
Includes a logout button redirecting users to the login page.

Individual Pages (Health, Education, Finance):
Character representation and progress bars persist across these pages for consistent user interaction.
Each page features:
Buttons for goal setting, to-do lists, and note-taking.
Functionality to input text for goals, to-dos, and notes.
Text entered is saved upon confirmation (Enter key) and retains its state when revisited.
XP (experience points) are earned based on user actions (button clicks), reflecting on the progress bars accordingly.




Technologies Used

Frontend:
Framework: JavaFX
Languages: Java (for application logic), CSS (for styling)

Backend:
Database: Text files used to store information.



Challenges Faced

Technical Complexity:
Overcoming challenges related to integrating character selection, persistent data display, maintaining state 
across multiple pages, using text files to store information, and working on some animations.

Design Consistency:
Pixel Drawings: All visual elements, including characters, maps, and other graphical components, were hand-drawn
 by myself, ensuring a unique and personalized appearance to the application.

Animations and CSS Styling: A significant effort was dedicated to implementing animations and leveraging CSS styling
 techniques. This was done to maintain a consistent and visually appealing design throughout the application.

User-Friendly Interface: Special attention was given to user experience (UX) and ensuring the application's ease 
of use. Design elements were optimized for usability to create an intuitive and engaging user interface.

Data Management:
Efficient Storage Methods: Implementing efficient data storage was a crucial aspect of the project. I utilized 
file-handling techniques within JavaFX to ensure the seamless storage and retrieval of user-entered content.

User-Generated Content Handling: The application handles user-entered content, such as goals, to-do lists, and 
notes, effectively. This involved developing mechanisms to store this information in files securely and retrieve 
it accurately when needed.

File-Based Storage: The use of files to store information provides a flexible and manageable solution for data 
storage. Each user's content was stored persistently in a file-based system, enabling easy access and modification 
whenever necessary.




How to Install and Run the Project


Prerequisites:
Java Development Kit (JDK): Ensure you have JDK installed on your system. You can download it from the official 
Oracle website or use OpenJDK.
JavaFX SDK: Download and install the JavaFX SDK if you haven't already. JavaFX is often bundled with JDK, but 
for separate installations, download it from the official OpenJFX website.


Steps:
1. Download the Project: Obtain the project files, usually as a ZIP archive or folder containing your JavaFX project.
Extract the Project: If the project is in a ZIP file, extract it to your preferred location.


2.Open the IDE where you usually work on Java projects
 (e.g., IntelliJ IDEA, Eclipse, NetBeans).


3.Set Up Project in IDE:
Open your IDE.
Create a new project or import the existing project by selecting the folder where your JavaFX project resides.


4.Configure Project Settings:
Make sure the JavaFX SDK is added to your project's build path or module settings within your IDE.
Set the project's main class or entry point (usually a class containing the main method).


5.Run the Project:
Locate the main class or the file containing the main method.
Run the project using the IDE's "Run" or "Debug" option.


6.Launch the Application:
Once the project is successfully built and run, the JavaFX application window should open, displaying your
 application's interface.



Usage

Login:
Enter username and password to access the application.

Character Selection:
Choose a character by clicking on the arrows to represent yourself.

Map Page:
Navigate through different areas (Health, Education, Finance) using the respective buttons.

Individual Pages:
Set goals, manage to-do lists, and take notes on each respective page.

Earning XP:
Perform actions like goal setting or task completion to earn experience points, reflected in progress bars.

