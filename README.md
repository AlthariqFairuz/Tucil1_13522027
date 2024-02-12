# Cyberpunk 2077 : Breach Protocol Minigame
## Description
<p> Breach Protocol is a hacking minigame in the video game Cyberpunk 2077. If players can complete this minigame, they will gain various benefits during their gameplay, such as in-game currency or attribute enhancements that can be used when facing enemies.
</p>
<p>In this program, the program generates all combination arrangements from the given matrix. These combinations must contain at least one given sequence. The search for combinations starts from one of the elements in the first row of the matrix. Then, it continues by moving vertically and horizontally alternately without visiting the same element for the second time. In addition, the program will also record every path that a combination has passed. All combinations that meet will be stored in an Array of Pair with Pair being a class that contains a combination that meets the rules and the path it has passed. After the program generates all the satisfying combinations and stores them in the Array of Pair, the program will loop for each Pair in the Array of Pair with all the sequences given previously. The maximum score will be initialized with 0. If a Pair contains more than one sequence, the score for that Pair will be added as much as the score owned by the related sequence. Finally, a check will be made whether the score for the current Pair is greater than the previous maximum score. If yes, the maximum score will be updated and the program will store the current Pair as the Pair with the highest score. Then, the program will send the highest score, combination, and the path that the combination has passed. However, if the maximum value remains 0, the program does not return anything because there is no satisfying solution.</p>

## Requirements

To run this program, you need:

1. **Java Runtime Environment (JRE)**: The JRE provides the libraries, the Java Virtual Machine (JVM), and other components necessary to run Java programs. If you already have the Java Development Kit (JDK) installed, you don't need a separate JRE. The JDK includes a compatible JRE.

2. **Java Development Kit (JDK)**: You need to have JDK installed on your system. You can download it from the official Oracle website. Make sure to download the version that suits your operating system.

3. **IDE (Optional)**: While not necessary, an Integrated Development Environment (IDE) like IntelliJ IDEA or VSCode can make coding in Java easier.

## Running the Java File

1. First, you need to clone this repository to your local machine. Open a terminal window and run the following command:
    ```bash
    git clone https://github.com/AlthariqFairuz/Tucil_13522027.git
    ```

2. Navigate to the `src` directory.
    ```bash
    cd src
    ``` 
3. Compile the Java file using the `javac` command:

    ```bash
    javac -d ../bin  Main.java
    ```

4. Run the compiled Java program using the `java` command:

    ```bash
    java Main.java
    ```
## Author

| Name | NIM | Class |
| ---- | -------- | ----- |
| Muhammad Althariq Fairuz | 13522027 | 01 |

