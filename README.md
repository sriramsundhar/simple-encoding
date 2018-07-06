# Simple Encoding
Java (Java 8 compatible) program that performs a simple encoding of a large volume of text using Akka Streams.

```$xslt
{"1","2","3","4","5","6","7","8","9","0"}
{"q","w","e","r","t","y","u","i","o","p"}
{"a","s","d","f","g","h","j","k","l",";"}
{"z","x","c","v","b","n","m",",",".","/"}
```
 
 ### Horizontal Flip
 This transformation will flip all rows of the keyboard horizontally (e.g., the 1 will
 swap with the 0, the 2 with the 9, etc.)
 
 ### Vertical Flip
 This transformation will flip all columns of the keyboard vertically (e.g., the 1
 will swap with the z, the q with the a, the 2 with the x, etc.)
 
 ###Shift
 This transformation should take in an integer N and perform a linear shift of
 the keyboard. Each key should shift N places to its right if N > 0 (and likewise
 to the left if N < 0). If a key would move past its current row then it should shift
 into the row below, and so on. So for example, for N = 5, the last five keys
 (nm,./ would move into the first 5 places of the top row, the 12345 would move
 5 places to the right, 67890 would move to the start of the 2nd row, and so
 on). Likewise, left-shifting keys past their current rows would shift them back
 into the row above. Therefore, a single right and a left shift would produce the
 same keyboard.
 
 ## Environment Setup
 
 ### Prerequisites
 
 * [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
 * [Docker](https://docs.docker.com/install/)
 * [Gradle](https://gradle.org/install/)
 
 ### Building
 ```ShellSession
 gradle clean
 gradle shadowJar
 ```
 
 ### Configuration
 
 The configuration settings input file and encoding technique
 * _./sampleFiles/inputSource.txt_
 * _./sampleFiles/iencoding.txt_
 
 - Note: `sampleFiles` folder is mounted to the docker image. Please modify the above files for changing input text and encoding sequence.
 
  ### Running
  ```ShellSession
  docker-compose up
  ```