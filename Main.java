
public class Main {

    public static void main(String[] args) {

        //Example 1
        String string ="www.PhyeX.com";
        String newString = string.replaceAll("PhyeX","");
        System.out.println(newString);
       // Output: www..com

       // Regular expressions are extremely useful in extracting information from text such as: code, log files, spreadsheets, documents, etc.

       //Example 2
        String string = "P+H-Y*E.X=PhyeX";
        String newString = string.replaceAll("P.H.Y.E.X","PhyeX");
        System.out.println(newString);
      //  Output: PhyeX=PhyeX

      // Note: If you want to match (.) in the test string, you need to escape the dot by using a slash \.. In Java, use \\. instead of \..

      // Example 3

     //  Task:You have a test string S. Your task is to match the pattern xxXxxXxxxx
     //  Here x denotes a digit character, and X denotes a non-digit character.

     String string = "06-11-2015";
     String string2 = "123-153.a15";
     System.out.println(string.matches("\\d{2}\\D\\d{2}\\D\\d{4}"));
     System.out.println(string2.matches("\\d{2}\\D\\d{2}\\D\\d{4}"));

     // Output:True
     // Output:False

     //  The expression \d matches any digit [0-9].
     //  The expression \D matches any character that is not a digit.

     // Example 4

     // Task:You have a test String S.Your task is to match the pattern XXxXXxXX
     // Here,x denotes whitespace characters,and X denotes non-White space characters.

     String string = "12 11 15";
     String string2 = "12 132 13";
     System.out.println(string.matches("\\S{2}\\s\\S{2}\\s\\S{2}"));
     System.out.println(string2.matches("\\S{2}\\s\\S{2}\\s\\S{2}"));

     // Output: true
     // Output: false
     // The expression \s matches any whitespace character [ \r\n\t\f ].
     // The expression \S matches any non-white space character.

     //Example 5

     //Task:You have a test string S.Your task is to match pattern xxxXxxxxxxxxxxXxxx
     //Here x denotes any word character and X denotes any non-word character.

      String string = "192.168901351.102";
      String string2 = "www.hackeranka.com";
      System.out.println(string.matches("\\w{3}\\W\\w{10}\\W\\w{3}"));
      System.out.println(string2.matches("\\w{3}\\W\\w{10}\\W\\w{3}"));
      // Output: false
      // Output: True

     // The expression \w will match any word character.
     // Word characters include alphanumeric characters (a-z,A-Z and 0-9) and underscores(_).
     // The expression \W matches any non-word character.
     // Non-word characters include characters  other than alphanumeric characters like (>£#$½{]}).

     //Example 6

     //Task:You have a test string S.Your task is to match the pattern Xxxxx.
     //Here,x denotes a word charachter,and X denotes a digit.
     //S must start with a digit X and end with '.' symbol.
     //S should be 6 characters long only.

     String string = "0qwer.";
     String string2 ="8wait.";
     System.out.println(string.matches("^\\d\\w{4}\\.$"));
     System.out.println(string2.matches("^\\d\\w{4}\\.$"));

     // Output:
     // Output:

     // The ^ symbol matches the position at the start of a string.
     // The $ symbol matches the position at the end of a string.

     //Example 7

     //Task:You have a test string S.
     //Your task is to write a regex that will match S with following conditions.
     // * S must be length:6.
     // * First Character:1,2 or 3
     // * Second Character: 1,2,0
     // * Third character: x, s or 0
     // * Fourth character: 3, 0 , A or a
     // * Fifth character: x, s or u
     // * Sixth character: . or ,

     String string = "1203x.";
     String string2 = "32xAx,";
     System.out.println(string.matches("^[123][120][xs0][30Aa][xsu][.,]$"));
     System.out.println(string2.matches("^[123][120][xs0][30Aa][xsu][.,]$"));
        
     // Output:true
     // Output:true

     // The character class [] matches only one out of several characters placed inside the square brackets.

     //Example 8

     //Task: You have a test String S.
     //Your task is to write a regex that will match S with the following conditions:
    // * First character should not be a digit (1-9).
    // * Second character should not be a lowercase vowel (aeiou).
    // * Third character should not be b, c, D or F.
    // * Fourth character should not be a whitespace character ( \r, \n, \t, \f or <space> ).
    // * Fifth character should not be a uppercase vowel (AEIOU).
    // * Sixth character should not be a . or , symbol.
        
     String string = "think?";
     String string2 = "9adab=";
     System.out.println(string.matches("^[^\\d][^aeiou][^bcDF][^\\W][^AEIOU][^.,]$"));
     System.out.println(string2.matches("^[^\\d][^aeiou][^bcDF][^\\W][^AEIOU][^.,]$"));

     // Output:true
     // Output:false

    // The negated character class [^] matches any character that is not in the square brackets.

    //Example 9

    // Task: Write a RegEx that will match a string satisfying the following conditions:
    // The string's length is >= 5.
    //The first character must be a lowercase English alphabetic character.
    //The second character must be a positive digit. Note that we consider zero to be neither positive nor negative.
    //The third character must not be a lowercase English alphabetic character.
    //The fourth character must not be an uppercase English alphabetic character.
    //The fifth character must be an uppercase English alphabetic character.

    String string = "h4CkR";
    String string2 = "t4YyP";
    System.out.println(string.matches("^[a-z][1-9][^a-z][^A-Z][A-Z].*"));
    System.out.println(string2.matches("^[a-z][1-9][^a-z][^A-Z][A-Z].*"));

    // Output: true
    // Output: true

    //  .* after then this expression anything can come but at least It need to be min.(* since the statement said the string length can be at least 5 characters long but it could be more.)
    //A hyphen (-) inside a character class specifies a range of characters where the left and right operand are the respective lower and uppder bounds of the range.
    // Example:
      // [a-z] is the same as [abcdefghıiklmnopr..]
      // [A-Z] is the same as [ABCDEFGHIKLMNOPRS..]
      // [0-9] is the same as [0123456789]

     // Example 10

     // Task:You have a test string S.
     // Your task is to write a regex that will match S using the following conditions:
     // S must be length equal to 45.
     // The first 40 characters should consist of letters(both lowercase and uppercase),or of even digits.
     // The last 5 characters should consist of odd digits or whitespace characters.

     String string = "2222222222aaaaaaaaaa2222222222aaaaaaaaaa13 57";
     String string2 = "3333333333aaaaaaaaaa2222222222bbbbbbbbbb19 45";
     System.out.println(string.matches("^[a-zA-z246810]{40}[13579\\W]{5}$"));
     System.out.println(string2.matches("^[a-zA-z246810]{40}[13579\\W]{5}$"));
        
     // Output: true
     // Output: false

     //{x}
     //The tool {x} will match exactly x repetitions of character/character class/groups.

       // Example 11

     // Task:You have a test string S.
    // Your task is to write a regex that will match S using the following conditions:
    // *S should begin with 1 or 2 digits.
    // After that,S should have 3 or more letters(both lowercase and uppercase)
    // Then S should end with up to 3 . symbol(s).You can end with 0 to 3 . symbol(s),inclusively.

       String string = "3threeormorealphabets.";
       String string2 = "12hooppallaa...";
       System.out.println(string.matches("^\\d{1,2}[a-zA-Z]{3,}[.]{0,3}$"));
       System.out.println(string2.matches("^\\d{1,2}[a-zA-Z]{3,}[.]{0,3}$"));

      // Output: true
      // Output: true
      // The {x,y} tool will match between x and y (both inclusive) repetitions of character/character class/group.

      //Example 12
    // Task:You have a test string S.
    // S should begin with 2 or more digits.
    // After that,S should have 0 or more lowercase letters.
    // S should end with 0 or more uppercase letters.

        String string = "14";
        String string2 = "1500aaXX";
        System.out.println(string.matches("^\\d{2,}[0a-z]{0,}[0A-Z]{0,}$"));
        System.out.println(string2.matches("^\\d{2,}[0a-z]{0,}[0A-Z]{0,}$"));
        // Output: true
        // Output: true
      //   ^\\d{2,}[0a-z]{0,}[0A-Z]{0,}$ == ^\\d{2,}[0a-z]*[0A-Z]*$
      // * Expression
      // The * tool will match zero ore more repetitions of character/character class/group.Mean == {0,}

     //Example 13
     // Task:Your task is to write a regex that will match S using the following conditions:
     // S should begin with 1 or more digits.
     // After that,S should have 1 or mode uppercase letters.
     // S should end with 1 or more lowercase letters.

     String string = "1Qa";
     String string2 = "1122QQww";
     System.out.println(string.matches("^\\d+[A-Z]+[a-z]+$"));
     System.out.println(string2.matches("^\\d+[A-Z]+[a-z]+$"));
        // Output: true
        // Output: true

     // + Expression
     // The + tool will match one ore more repetitions of character/character class/group. Mean ==  {1,0}

     // Example 14
     // Task: Write a RegEx to match a test string,S,under the following conditions:
     // * S should consist of only lowercase and uppercase letters(no numbers of symbols)
     // * S should end in s.

    String string = "Kites";
    String string2 = "mAchIneS";
    System.out.println(string.matches("^[a-zA-Z]*s$"));
    System.out.println(string2.matches("^[a-zA-Z]*s$"));
        // Output: true
        // Output: false

     // $ Expression
     // The $ boundary matcher an occurrence of a character/character class/group at the end of a line.
    
    // Example 15
    // Task: Your task is write a regex which will match word starting with vowel(a,e,i,o,A,E,I,O or U9
    // The matched word can be of any length. The matcged word should consist of letters(lowercase and uppercase both)
    // The matched word must start and end with a word boundary.

    String string = "Found any match?";
    String string2 = "Yes of course";

     Answer == "\\b[aeiouAEIOU][a-zA-Z]*\\b"

    // \b assert position at a word boundary.
    // Three different positions qualify for word boundaries:
    // * Before the first character in the string,if the first character is a word character.
    // * Between two characters in the string,where one is a word character and the other is not a word character.
    // * After the last character in the string,if the last character is a word character.   
         
        // Example 16
    // Task: You have a test String S.
    // Task: Your task is to write a regex which will match S with the following condition:
    //  S should have 3 or more consecutive repetitions of ok.

     String string = "okokok! cya";

        Answer == "(ok){3,}";
    // The () expression.
    // Parenthesis () around a regular expression can group that part of regex together.This allows us to apply different quantifiers to that group.
    // These parenthesis also create a numbered capturing.It stores the part of string matched by the part of regex inside parentheses.


    //Example 17
    //Task:Given a test string,s,write a RegEx that matches s under the following conditions:
    // s must start with Mr.,Mrs.,Ms.,Dr. or Er..
    // The rest of the string must contain only one or more English alphabetic letters(upper and lowercase).

        String string = "Mr.DOSHI";

        Answer == "^(Mr|Mrs|Ms|Dr|Er)\\.[a-zA-Z]+$";
    // Alternations,denoted by the | character,match a single item out of several possible items separated by the vertical bar.When used inside a character class,
    // It will match characters;when used inside a group,it will match entire expressions.We must use parentheses to limit use of alternations.

        //Example 18
    //  Task:You have a test string S.
    //  Your task is to write a regex that will match  with the following conditions:
     //  S must be of length: 20
     // 1.character: lowercase letter.
     // 2.character: word character.
     // 3.character: whitespace character.
     // 4.character: non word character.
     // 5.character: digit.
     // 6.character: non digit.
     // 7.character: uppercase letter.
     // 8.character: letter (either lowercase or uppercase).
     // 9.character: vowel (a, e, i , o , u, A, E, I, O or U).
     // 10.character: non whitespace character.
     // The other 10 character also should same.

        String string = "ab #1?AZa$ab #1?AZa$";

        Answer == "([a-z]\\w\\s\\W\\d\\D[A-Z][a-zA-Z][aeiouAEIOU]\\S)\\1";
    // This tool (\1 references the first capturing group) matches the same text as previously matched by the capturing group.

    // Example 19
    // You have a task string S.
    // Your task is to write a regex which will match S,with following condition(s):
    //  S consists of 8 digits.
    //  S may have "-"separator such that string S gets divided in 4 parts,with each part having exactly two digits.
       String string = "12345678";
       String string = "12-34-56-87";
       Answer == "^\\d{2}(-?)\\d{2}\\1\\d{2}\\1\\d{2}$";
       // Here, (?) is optional and matches nothing

    // Example 20
    // You have a test string S.
    // S consist of "tic" or "tac";
    // "tic" should not be immeditate neighbour of itself.
    // The first "tic" must occur only when "tac" has appeared at least twice before.

     String string = "tactactic";
     String string2= "tactactictactic";

     Answer == "^tac(tac(tic)?)*$";  
        
     // Example 21
    // Task:
    // Write a regex that can match all occurrences of o followed immediately by oo in S.
     String string = "gooooo!";
     Answer == "o(?=oo)";
    // The positive lookahead (?=) asserts regex_1 to be immediately followed by regex_2.
    // The lookahead is excluded from the match. It does not return matches of regex_2.
    // The lookahead only asserts whether a match is possible or not.

    // Example 22
    // Task: You have a test String S.
    // Write a regex which can match all characters which are not immediately followed by that same character.
    // If S = goooo, then regex should match g"ooo"o.Because the first g is not follwed by g and the o is not followed by o.
       String string = "gooooo";
       Answer == ""(.)(?!\\1)"
    // The negative lookahead (?!) asserts regex_1 not to be immediately followed by regex_2.Lookahead is
    // excluded from the match(do not consume matches of regex_2),but only assert whether a match is possible or not.

    //Example 23
    // Task: You have a test String S.
    // Write a regex which can match all the occurences of digit which are immediately preceded by odd digit.
      String string = "123Go!";
      Answer == "(?<=[13579])\\d)"

    // (?>=regex_2)regex_1
    // The positive lookbehind (?<=) asserts regex_1 to be immediately preceded by regex_2.Lookbehind is excluded from
    // the match(do not consume matches of regex_2)

    //Example 24
    // Task: You have a test String S.
    // Write a regex which can match all the occurences of characters which are not immediatly preceded by vowels(a,e,i,u,o,A,E,I,O,U).

      String string ="1o1s1
      Answer == "(?<![aeiuoAEIOU]).";

    // The (?<!regex_2)regex_1
    // Te negative lookbehind(?<!)asserts regex_1 not to be immediately preceded by regex_2.Lookbehind is excluded from
    // the match ( dot not comsume matches of regex_2),but only assert whether a match is possible or not.


    // From now on I will use in programs so I will write a litte intro then show the solution.
    // Example 25
    // Task:We are trying to hack together a smart programming IDE. Help us build a feature which auto-detects the programming language, given the source code.
    // There are only three languages which we are interested in "auto-detecting": Java, C and Python.
        Solution -->   Scanner scan = new Scanner(System.in);
                                String string = "";
                                while(scan.hasNext()){
                                    string += scan.nextLine() + "\n";
                                }
                                    if(string.contains("java."))
                                        System.out.println("Java");
                                            else if(string.contains("#include"))
                                                 System.out.println("C");
                                                    else
                                                        System.out.println("Python");
        
    //Example 26
    }
}
