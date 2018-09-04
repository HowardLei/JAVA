/*
  如果在.java文件中含 package com.*; 这行代码的时候，需要在 terminal 下如下执行代码
  1、先进入项目的目录
  2、然后在 terminal 中键入 javac -sourcepath src -d bin src/com/company/*.java[;如果有其他的类的话就继续添加]
     这个时候就会在这个项目的文件夹下创建一个bin的文件夹。里面的目录与之前在 src 中创建的目录相同。且在 bin/com/company 这个文件夹下出现 *.class 文件。
  3、编译完文件之后，再继续键入 java -cp bin com.company.Main 成功输出
    这行代码中， -cp 是 -classpath 的全称，即指定编译后的.class文件所在的目录，此处由于.class 文件已经生成在 bin 文件夹中。所以执行 *.class 代码的时候，就必须键入他的包处于的文件夹下
*/
